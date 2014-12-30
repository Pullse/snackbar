snackbar.controller('SnackController', ['$scope', 'snackService', 
	function($scope, snackService){
		$scope.showSnacks = function(){
			snackService.getAllSnacks(function(snacks){
				$scope.snacks = snacks;
			});
		};
		$scope.showSnacks();

		$scope.saveSnack = function(snack){
			snackService.postSnack(snack).success(function(snack){
				$scope.showSnacks();
			});
		};

		$scope.deleteSnack = function(snack){;
			snackService.deleteSnack(snack).success(function(snack){
				$scope.showSnacks();
			});
		}
	}]);
