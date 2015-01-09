snackbar.controller('CollegaController', ['$scope', 'collegaService', 'snackService', 'modalService', 
	function($scope, collegaService, snackService, modalService){
		//getCollegas
		collegaService.getAllCollegas().success(function (collegas){
			$scope.collegas = collegas;
		});

		snackService.getAllSnacks(function(snacks){
			$scope.snacks = snacks;
		});

		$scope.saveCollega = function(collega){
			collegaService.postCollega(collega).success(function(collega){
				$scope.collegas.push(collega);
			});
		};

		$scope.deleteCollega = function(collega, index){
			collegaService.deleteCollega(collega).success(function(collega){
				$scope.collegas.splice(index, 1);
			});
		};

		$scope.openSnackSummaryModal = function(){
			modalService.openModal("lg", "snackSummary", $scope);
		};

		$scope.dismissSnackSummaryModal = function () {
            modalService.dismissModal();
        }
	}]);
