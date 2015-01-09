snackbar.controller('CollegaController', ['$scope', 'collegaService', 'snackService', 'modalService',
	function($scope, collegaService, snackService, modalService){
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

		$scope.deleteCollega = function(collega){
			collegaService.deleteCollega(collega).success(function(collega){
				$scope.showCollegas();
			});
		};

		$scope.openSnackSummary = function(){
			modalService.openModal("lg", "snackSummary", $scope);
		};

		$scope.dismissSnackSummaryModal = function () {
            modalService.dismissModal();
        }
	}]);
