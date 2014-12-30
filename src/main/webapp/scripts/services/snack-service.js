snackbar.factory('snackService', function($http){
	var instance = {};

	instance.getAllSnacks = function(success){
		return $http.get('api/snacks').success(success);
	};

	instance.postSnack = function(snack){
		return $http.post('api/snacks', snack);
	};

	instance.deleteSnack = function(snack){
		return $http["delete"]("api/snacks",
                        {
                            headers: { 'Content-type': 'application/json' },
                            data: snack
                        });

		//return $http.delete('api/snacks', angular.toJson(snack));
	};

	return instance;
	
});