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
      
      $scope.shipsBad = data.slice(1, 7);
      $scope.shipsGood = data.slice(7, 9);
      $scope.shipsHandled = data.slice(9, 15);
      main();

    }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);

    });
  
  function main (){
  
    $scope.activeShip = "Default";  


    $scope.showActive = function(s){
      sharedProperties.setActive(s);
      $scope.activeShip = sharedProperties.getActive();
    }

    $scope.isBad = function(s){
      return ($scope.shipsBad.indexOf(s) != -1)
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

   $scope.handel = function(s){
        console.log("HANTERAD", s.shipName);
        
        if(!isInArray(s,$scope.shipsHandled))
          $scope.shipsHandled.push(s);

        var index = $scope.shipsBad.indexOf(s);
        console.log("index", index);

        if (index > -1) {
          $scope.shipsBad.splice(index, 1);
        } 
    }

    function isInArray(value, array) {
      return array.indexOf(value) > -1;
    }

  }
});