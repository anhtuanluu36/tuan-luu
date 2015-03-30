'use strict';

describe('Test Student Service', function() {

  // load modules
  beforeEach(function() {
	  angular.mock.module('app');
  });

  // Test service availability
  it('check the existence of Student Service', inject(function(StudentService) {
      expect(StudentService).toBeDefined();
    }));
});