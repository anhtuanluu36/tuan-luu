app.factory('myHttpResponseInterceptor',function($q,$location,$rootScope){
  return {
	// optional method
    'response': function(response) {
      // do something on success
      return response;
    },
    // optional method
    'responseError': function(rejection) {
        if (rejection.status === 401) {
            var deferred = $q.defer(),
                req = {
                    config: rejection.config,
                    deferred: deferred
                };
            $rootScope.requests401.push(req);
            $rootScope.$broadcast('event:loginRequired');
            return deferred.promise;
        }
        return $q.reject(response);
     }
  }
});