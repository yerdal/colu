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

  //Gets the ship-data
  $http.get('http://localhost:8090/ships/test').success(function(data,status,headers,config)
    {
      
      //For now, just looking at a few ships
      $scope.ships = data.slice(1, 20);

      //Sets some hardcoded parameters
      for(var i = 0; i < $scope.ships.length; i++)
      {
        $scope.ships[i].rangeParameters = {
          time: {label: "Tid", lowerLimit: '-30', upperLimit: '30', status: true, unit: "minuter", number: 0},
          velocity: {label: "Hastighet", lowerLimit: '50', upperLimit: '250', status:false, unit: "knop", number: 1}
        }

        $scope.ships[i].singleParameters = {

          fuel: {label: "Bränsle", upperLimit: '250', status: true, unit: "L/mil", number: 2},
          combinedWave : {label: "Våghöjd",upperLimit: '250', status:false, unit: "m",number: 3},
          current : {label: "Ström", upperLimit: '250', status:true, unit: "m/s", number: 4},
          wind : {label: "Vind", upperLimit: '250', status:false, unit: "m/s", number: 5}
        }        
      
      } 
      
      $scope.shipsBad = $scope.ships.slice(1, 7);
      $scope.shipsGood = $scope.ships.slice(7, 9);
      $scope.shipsHandled = $scope.ships.slice(9, 15);
      
      //Where all the functionality is
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

    //Functionality of the form
    function formFunctionality(){

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