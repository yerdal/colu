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

  //Hämtar in skepp-data
  $http.get('http://localhost:8090/ships/test').success(function(data,status,headers,config)
    { 
      $scope.shipsBad = data.slice(1, 7);
      $scope.shipsGood = data.slice(7, 9);
      $scope.shipsHandled = data.slice(9, 15);
      
      //Where all the functionlaity is
      main();

    }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);

    });
  

  function main (){

    //How the form works
    formFunctionality();
  
    //Shows the active ship in the detailed view 
    $scope.showActive = function(s){
      sharedProperties.setActive(s);
      $scope.activeShip = sharedProperties.getActive();
    }

    //Used to only show handle-button on Bad-ships
    $scope.isBad = function(s){
      return ($scope.shipsBad.indexOf(s) != -1)
    }

    //To "handle" ships, and then put them i the handled-list
    $scope.handel = function(s){
      if(!isInArray(s,$scope.shipsHandled))
        $scope.shipsHandled.push(s);

      var index = $scope.shipsBad.indexOf(s);
      console.log("index", index);

      if (index > -1) {
        $scope.shipsBad.splice(index, 1);
      } 
    }

    function formFunctionality(){
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

      }

      function isInArray(value, array) {
        return array.indexOf(value) > -1;
      }
  }

});