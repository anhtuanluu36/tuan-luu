'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Student App', function() {

  it('should redirect to #/main', function() {
    browser.get('#/login');
    browser.getLocationAbsUrl().then(function(url) {
        expect(url.split('#')[1]).toBe('/login');
      });
  });

describe('Test Login', function() {

    it('should login successfully', function() {
      browser.get('#/login');
      var username = element(by.model('username'));
      var password = element(by.model('password'));
      
      browser.pause();
      username.sendKeys('user');
      password.sendKeys('password');
      
      element(by.id('btnSubmit')).click();
      
      browser.getLocationAbsUrl().then(function(url) {
          expect(url.split('#')[1]).toBe('/main');
        });
    });
});
