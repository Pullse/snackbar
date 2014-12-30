snackbar.controller('CollegaController', ['$scope', 'collegaService', 'snackService', 
	function($scope, collegaService, snackService){
		$scope.showCollegas = function(){
			collegaService.getAllCollegas(function(collegas){
				$scope.collegas = collegas;
			});
		};
		$scope.showCollegas();

		$scope.saveCollega = function(collega){
			collegaService.postCollega(collega).success(function(collega){
				$scope.showCollegas();
			});
		};

		$scope.retrieveAllSnacks = function(){
			snackService.getAllSnacks(function(snacks){
				$scope.snacks = snacks;
			});
		};
		$scope.retrieveAllSnacks();
	}]);
