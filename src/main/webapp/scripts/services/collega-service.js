snackbar.factory('collegaService', function($http){
	var instance = {};

	instance.getAllCollegas = function(){
		return $http.get('api/collegas');
	};

	instance.postCollega = function(collega){
		return $http.post('api/collegas', collega);
	};

	instance.deleteCollega = function(collega){
		return $http["delete"]("api/collegas",
                        {
                            headers: { 'Content-type': 'application/json' },
                            data: collega
                        });
	};

	return instance;
	
});