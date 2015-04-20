angular.module('coluApp')


.controller('mainController', function($scope, $http ){

  $http.get('http://localhost:8090/ships/test').success(function(data,status,headers,config)
    {
      
      console.log("skepp", data[0]);
      $scope.ships = data.slice(1, 10);

      for(var i = 0; i < $scope.ships.length; i++)
      {

        $scope.ships[i].time = {lowerLimit: '-30',
                      upperLimit: '30'};

        $scope.ships[i].fuel = {upperLimit: '250'};

        $scope.ships[i].combinedWave = {upperLimit: '250'};

        $scope.ships[i].current = {upperLimit: '250'};

        $scope.ships[i].wind = {upperLimit: '250'};

        $scope.ships[i].velocity = {upperLimit: '250'};   
        
      }    
      
      }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);

      });

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
  
    $scope.activeShip = "Default";

    $scope.showActive = function(s){

    $scope.activeShip = s;  

  }

});