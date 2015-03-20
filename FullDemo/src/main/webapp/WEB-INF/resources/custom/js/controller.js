app.controller('MainController', function ($scope, $rootScope, $location, AuthenticationService) {
	$scope.logout = function () {
		$scope.$emit('event:logoutRequest');
		
        AuthenticationService.logout().then(function() {
        	$rootScope.user = null;
            $scope.username = $scope.password = null;
            $location.path('/main');
        });
    };
});

app.controller('StudentController', function ($scope, StudentService) {
	$scope.init = function() {
        StudentService.getStudents().then(function(response) {
            $scope.students = response;
        });
	};

    $scope.delete = function(id) {
        StudentService.deleteStudent(id).then(function(response) {
            angular.forEach($scope.students, function(student, index) {
                if(id == student.studentId) {
                    $scope.students.splice(index, 1);

                    console.info("Student " + id + " has been deleted.")
                }
            });
        });
    };

    $scope.save = function(id) {
        angular.forEach($scope.students, function(student, index) {
            if(id == student.studentId) {
                StudentService.saveStudent(student).then(function(response) {
                    console.info("Student " + id + " has been saved.")
                });
            }
        });
    };
    
    $scope.saveStudent = function() {
    	student = {
    		studentName : $scope.studentName,
    		birthday : $scope.birthday,
    	};
        StudentService.saveStudent(student).then(function(response) {
            console.info("Student " + $scope.studentName + " has been saved.")
            window.location = '#/student/search';
        });
        
    };
});

app.controller('LoginController', function($scope, $location) {
	$scope.login = function () {
		$scope.$emit('event:loginRequest', $scope.username, $scope.password);
		$location.path(originalLocation);
    };
});