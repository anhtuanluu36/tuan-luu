/*jslint node: true */
"use strict";


module.exports = function(grunt) {
	
	var globalConfig = {
		    dest: '../html'
		  };
  
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    
    bower: {
      install: {
        options: {
          install: true,
          copy: false,
          targetDir: "./resources",
          cleanTargetDir: false,
		  cleanBowerDir: false
        }
      }
    },
    
    uglify: {
      main: {
        files: {
          'resources/custom/js/dist/main.js': [ 'resources/custom/js/dist/main.js' ]
        },
        options: {
          mangle: false
        }
      }
    },
    
    clean: {
      options: {
        force: true
      },
      main: {
    	
        src: [ globalConfig.dest ]
      }
    },
    
    concat: {
      options: {
        separator: ';'
      },
      main: {
        src: [ 'resources/custom/js/*.js'],
        dest: 'resources/custom/js/dist/main.js'
      }
    },
    
    connect: {
      server: {
        options: {
          hostname: 'localhost',
          port: 8000
        }
      }
    },
	
    copy: {
	  main: {
	    files: [
	      { src:"partials/*", dest: globalConfig.dest + "/" },
	      { src:"public/*", dest: globalConfig.dest + "/" },
	      { src:"resources/angular-bootstrap/*min.js", dest: globalConfig.dest + "/" },
	      { src:"index.html", dest: globalConfig.dest + "/" },
	      { src:"resources/angular/angular.min.js", dest: globalConfig.dest + "/" },
	      { src:"resources/angular-xeditable/dist/**", dest: globalConfig.dest + "/" },
	      { src:"resources/angular-route/angular-route.min.js", dest: globalConfig.dest + "/" },
		  { src:"resources/angular-translate/angular-translate.min.js", dest: globalConfig.dest + "/" },
	      { src:"resources/angular-translate-loader-static-files/angular-translate-loader-static-files.min.js", dest: globalConfig.dest + "/" },
	      { src:"resources/bootstrap/dist/**", dest: globalConfig.dest + "/" },
	      { src:"resources/i18n/**", dest: globalConfig.dest + "/" },
	      { src:"resources/custom/js/dist/main.js", dest: globalConfig.dest + "/" },
	      { src:"resources/jquery/jquery.min.js", dest: globalConfig.dest + "/" }
	    ]
	  }
	},
    
    compress: {
      dist: {
        options: {
          archive: 'dist/<%= pkg.name %>-<%= pkg.version %>.zip'
        },
        files: [{
          src: [ 'index.html' ],
          dest: '/'
        }, {
          src: [ 'dist/**' ],
          dest: 'dist/'
        }, {
          src: [ 'assets/**' ],
          dest: 'assets/'
        }, {
          src: [ 'libs/**' ],
          dest: 'libs/'
        }]
      }
    },
    
    karma: {
      options: {
        configFile: 'test/karma.conf.js'
      },
      unit: {
        singleRun: true
      },
      
      continuous: {
        singleRun: false,
        autoWatch: true
      }
    },
    
    protractor: {
	  options: {
	    // Location of your protractor config file
	    configFile: "test/protractor-conf.js",
	 
	    // Do you want the output to use fun colors?
	    noColor: true,
	    
	    //debug: true,
	 
	    // Set to true if you would like to use the Protractor command line debugging tool
	    // debug: true,
	 
	    // Additional arguments that are passed to the webdriver command
	    args: { }
	  },
	  e2e: {
	    options: {
	      // Stops Grunt process if a test fails
	      keepAlive: false
	    }
	  },
	  continuous: {
	    options: {
	      keepAlive: true
	    }
	  }
	}
  });
  
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-connect');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-compress');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-bower-task');
  grunt.loadNpmTasks('grunt-protractor-runner');
  grunt.loadNpmTasks('grunt-karma');
  
  grunt.registerTask('test', [ 'bower', 'concat:main', 'uglify:main', 'karma:unit']);
  grunt.registerTask('e2e-test', [ 'bower', 'concat:main', 'protractor:e2e']);
  grunt.registerTask('build', [ 'bower', 'concat:main', 'uglify:main',
                                'clean:main', 'copy:main' ]);
};
