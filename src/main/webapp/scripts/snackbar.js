var snackbar = angular.module('snackbar', ['ngRoute']);

snackbar.config(['$routeProvider',
	function($routeProvider){
		$routeProvider.
		when('/snacks', {
			templateUrl: 'views/pages/snacks_overview.html',
			controller: 'SnackController'
		}).
		when('/collegas', {
			templateUrl: 'views/pages/collegas_overview.html',
			controller: 'CollegaController'
		}).
		otherwise({
			redirectTo: '/snacks' 
		});
	}]);