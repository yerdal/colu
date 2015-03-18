'use strict';

//Application Configurations 
//The order of the applications startup 
//1 app config
//2 app run
//3 directive setup
//4 directive compile
//5 app controller
//6 directive link

(function () { 
var app = angular.module('coluApp', ['openlayers-directive']);


var ships = [
            {
                name: 'Jonken1',
                lat: 51.505,
                lon: -2.09
            },
            {
                name: 'Jonken2',
                lat: 51.375,
                lon: -20.35
            },
            {
                name: 'Jonken3',
                lat: 51.267,
                lon: -10.083
            }
        ];

 app.controller('mainController', [ '$scope', function($scope) {
 
             angular.extend($scope, {
                 center: {
                     lat: ships[0].lat,
                     lon: ships[1].lon,
                     zoom: 4
                 },

              	ships: ships

             });
             
  }]);

})();


