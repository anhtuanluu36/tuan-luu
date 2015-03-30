'use strict';

describe('StudentController', function(){
    var rootScope, scope, ctrl, $httpBackend, mockStudentService, q, students;
    
    beforeEach(module('app'));
    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller, $q) {
      $httpBackend = _$httpBackend_;
      rootScope = $rootScope;
      q = $q;
      mockStudentService = {getStudents: function(){} };
      $httpBackend.expectGET('student/ajax/list').
          respond([
                   {"studentId":1051,"studentName":"Tuan","birthday":1425229200000},
                   {"studentId":6050,"studentName":"Peter","birthday":1425661200000}
                 ]);

      scope = $rootScope.$new();
      ctrl = $controller('StudentController', {$scope: scope, StudentService: mockStudentService});
    }));


    it('It should retrieve 2 students', function() {
    	var deferred = q.defer();
        // Place the fake return object here
  	  	var students = [
                    {"studentId":1051,"studentName":"Tuan","birthday":1425229200000},
                    {"studentId":6050,"studentName":"Peter","birthday":1425661200000}
                  ];
        deferred.resolve(students);
        spyOn(mockStudentService, 'getStudents').andReturn(deferred.promise);
        scope.init();
        rootScope.$apply();
	    expect(mockStudentService.getStudents).toHaveBeenCalledWith();
	    expect(scope.students).toEqual(students);
    });
    
});

	

