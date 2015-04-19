var coluApp = angular.module('coluApp');

coluApp.service('sharedProperties', function() {
    var activeShip = "Default";
    
    return {
        getActive: function() {
            return activeShip;
        },
        setActive: function(s) {
            activeShip = s;
        }
    }
});

coluApp.controller('mainController', function($scope, $http, sharedProperties ){

  $http.get('http://localhost:8090/ships/test').success(function(data,status,headers,config)
    {
      console.log("skepp", data[0]);
      $scope.ships = data.slice(1, 10);
      
      }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);
      });

  $scope.showActive = function(s){
    sharedProperties.setActive(s);
    $scope.activeShip = sharedProperties.getActive();
  }

  $scope.time = {lowerLimit: '-30',
                   upperLimit: '30'};

  $scope.fuel = {upperLimit: '250'};

  $scope.combinedWave = {upperLimit: '250'};

  $scope.current = {upperLimit: '250'};

  $scope.wind = {upperLimit: '250'};

  $scope.velocity = {upperLimit: '250'};


  $scope.editorEnabled = [false, false, false, false, false, false];
  
  $scope.enableEditor = function(id) {
    $scope.editorEnabled[id] = true;
  };
  
  $scope.disableEditor = function(id) {
    $scope.editorEnabled[id] = false;
  };
  
  $scope.save = function(id) {
    $scope.disableEditor(id);
  };

});