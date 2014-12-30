snackbar.factory('collegaService', function($http){
	var instance = {};

	instance.getAllCollegas = function(success){
		return $http.get('http://localhost:8060/api/collegas').success(success);
	};

	instance.postCollega = function(collega){
		return $http.post('api/collegas', collega);
	};

	return instance;
	
});