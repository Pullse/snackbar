snackbar.factory('snackService', function($http){
	var instance = {};

	instance.getAllSnacks = function(){
		return $http.get('http://localhost:8060/api/snacks').succes(iets met data).;
	};

	return instance;
	
)};