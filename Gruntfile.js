module.exports = function (grunt) {

  grunt.loadNpmTasks('grunt-ngdocs');
  grunt.loadNpmTasks('grunt-contrib-connect');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-karma');

  grunt.initConfig({
    karma: {
      options: {
        // point all tasks to karma config file
        configFile: 'test/javascript/karma.conf.js'
      },
      unit: {
        // run tests once instead of continuously
        singleRun: true
      }
    },
    ngdocs: {
      options: {
        scripts: ['angular.js', '../scripts/main.controller.js'],
        html5Mode: false,
        title: "Colu Frontend API Documentation",
        titleLink: "/docs/api"
      },
      all: ['scripts/**/*.js']
    },
    connect: {
      options: {
        keepalive: true
      },
      server: {}
    },
    clean: ['docs']
  });

  grunt.registerTask('default', ['clean', 'ngdocs', 'connect']);

};