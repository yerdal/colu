
var coluApp = angular.module('coluApp', ['ngRoute'])

//Failed routing...
/*coluApp.config(function($routeProvider, $locationProvider){

      $routeProvider
          .when('/mobile',{
                templateUrl: 'indexmobile.html',
                controller:'mainController'
          })

           $locationProvider.html5Mode(true); 
});*/

coluApp.controller('mainController', function($scope, $http, $location){

  $http.get('http://localhost:8090/ships/test').success(function(data,status,headers,config)
    {
      
      console.log("skepp", data[0]);  
      $scope.ships = data.slice(1, 10);
      
      }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);
      });
  
  $scope.activeShip = "Default";
 
 $scope.showActive = function(s){
 
    $scope.activeShip = s;  
    $scope.activeShip.shipTrue = true;
    console.log('active shipname ', $scope.activeShip.shipName);
    

  }
  $scope.goBack = function(){
    $scope.activeShip = "Default";
  }


  $scope.smallScreenSize = function(){
    var screenSize = screen.width;

    if(screenSize >= 1000){
      console.log('Big screen');
      return false;
    }
    if(screenSize < 1000){
      console.log('Small screen');
      return true;  
    }

  }

});

/*coluApp.controller('checkScreenController', ['screenSize','matchMedia', function (screenSize, $scope, $http) {
  screenSize.rules = {
    retina: 'only screen and (min-device-pixel-ratio: 2), only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx)',
    superJumbo: '(min-width: 1000px)',
  };

  //$scope.bajs = "BAJSJSSSJS";
  if (screenSize.is('retina')) {
    // switch out regular images for hi-dpi ones
    console.log('RETINA!!!');
  }

  if (screenSize.is('superJumbo')) {
    // do something for enormous screens
    console.log('BIGGG!!');

  }

}]);*/




