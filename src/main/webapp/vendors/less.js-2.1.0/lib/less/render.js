var PromiseConstructor = typeof Promise === 'undefined' ? require('promise') : Promise,
    contexts = require("./contexts"),
    Parser = require('./parser/parser'),
    PluginManager = require('./plugin-manager');

module.exports = function(environment, ParseTree, ImportManager) {
    var render = function (input, options, callback) {
        options = options || {};

        if (typeof(options) === 'function') {
            callback = options;
            options = {};
        }

        if (!callback) {
            return new PromiseConstructor(function (resolve, reject) {
                render(input, options, function(err, output) {
                    if (err) {
                        reject(err);
                    } else {
                        resolve(output);
                    }
                });
            });
        } else {
            var context,
                rootFileInfo,
                pluginManager = new PluginManager(this);

            pluginManager.addPlugins(options.plugins);
            options.pluginManager = pluginManager;

            context = new contexts.Parse(options);

            if (options.rootFileInfo) {
                rootFileInfo = options.rootFileInfo;
            } else {
                var filename = options.filename || "input";
                var entryPath = filename.replace(/[^\/\\]*$/, "");
                rootFileInfo = {
                    filename: filename,
                    relativeUrls: context.relativeUrls,
                    rootpath: context.rootpath || "",
                    currentDirectory: entryPath,
                    entryPath: entryPath,
                    rootFilename: filename
                };
            }

            var imports = new ImportManager(context, rootFileInfo);

            new Parser(context, imports, rootFileInfo)
                .parse(input, function (e, root) {
                if (e) { return callback(e); }
                try {
                    var parseTree = new ParseTree(root, imports);
                    var result = parseTree.toCSS(options);
                    callback(null, result);
                }
                catch (err) { callback( err); }
            }, options);
        }
    };
    return render;
};
