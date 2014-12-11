snackbar.controller('SnackController', ['$scope', 'snackService', 
	function($scope, snackService){

		$scope.showSnacks = function(){
			snackService.getAllSnacks(function(snacks){
				$scope.snacks = snacks;
				console.log(snacks);
			});
		};
	}]);
