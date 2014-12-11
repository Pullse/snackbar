snackbar.factory('snackService', function($http){
	var instance = {};

	instance.getAllSnacks = function(success){
		return $http.get('http://localhost:8060/api/snacks').success(success);
	};

	return instance;
	
)};