snackbar.controller('CollegaController', ['$scope', 'collegaService', 
	function($scope, collegaService){
		$scope.showCollegas = function(){
			collegaService.getAllCollegas(function(collegas){
				$scope.collegas = collegas;
			});
		};
		$scope.showCollegas();
	}]);
