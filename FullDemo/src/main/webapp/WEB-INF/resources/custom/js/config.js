var httpHeaders;
var originalLocation = "/main";

app.config([ '$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
	
	// ======= router configuration
	$routeProvider
		.when('/main', {
			templateUrl: 'resources/html/partials/main.html'
		})
		.when('/student/search', {
			controller: 'StudentController',
			templateUrl: 'resources/html/partials/student_search.html'
		})
		.when('/student/save', {
			controller: 'StudentController',
			templateUrl: 'resources/html/partials/student_save.html'
		})
		.when('/login', {
			controller: 'LoginController',
			templateUrl: 'resources/html/partials/login.html'
		})
		.otherwise({ redirectTo : "/main"});
	
	// ======== http configuration
	
	//configure $http to view a login whenever a 401 unauthorized response arrives
    $httpProvider.interceptors.push('myHttpResponseInterceptor');
    httpHeaders = $httpProvider.defaults.headers;
}]);