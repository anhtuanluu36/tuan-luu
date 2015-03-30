module.exports = function(config){
  config.set({

    basePath : '../',

    files : [
      'resources/jquery/jquery.min.js',
      'resources/angular/angular.min.js',
      'resources/angular-route/angular-route.min.js',
      'resources/bootstrap/dist/js/bootstrap.js',
      'resources/angular-mocks/angular-mocks.js',
      'resources/angular-bootstrap/ui-bootstrap-tpls.min.js',
      'resources/angular-xeditable/dist/js/xeditable.min.js',
      'resources/custom/js/dist/main.js',
      'test/unit/**/*.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['Chrome'],

    plugins : [
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-jasmine'
            ],

    junitReporter : {
      outputFile: 'test_out/unit.xml',
      suite: 'unit'
    }

  });
};