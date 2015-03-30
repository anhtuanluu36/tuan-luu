var httpHeaders;
var originalLocation = "/main";

app.config(function($routeProvider, $httpProvider, $translateProvider) {
	
	// ======= router configuration
	$routeProvider
		.when('/main', {
			templateUrl: 'partials/main.html'
		})
		.when('/student/search', {
			controller: 'StudentController',
			templateUrl: 'partials/student_search.html'
		})
		.when('/student/save', {
			controller: 'StudentController',
			templateUrl: 'partials/student_save.html'
		})
		.when('/login', {
			controller: 'LoginController',
			templateUrl: 'partials/login.html'
		})
		.otherwise({ redirectTo : "/main"});
	
	$translateProvider.useStaticFilesLoader({
        prefix: 'resources/i18n/',
        suffix: '.json'
      });
	  $translateProvider.preferredLanguage('en');
	
	// ======== http configuration
	
	//configure $http to view a login whenever a 401 unauthorized response arrives
    $httpProvider.interceptors.push('myHttpResponseInterceptor');
    httpHeaders = $httpProvider.defaults.headers;
});