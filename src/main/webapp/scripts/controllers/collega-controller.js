snackbar.controller('CollegaController', ['$scope', 'collegaService', 'snackService', 
	function($scope, collegaService, snackService){
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

		$scope.openSnackSummary = function(){
			modalService.openModal("lg", "snackSummary", $scope);
		};

		$scope.dismissSnackSummaryModal = function () {
            modalService.dismissModal();
        }
	}]);
