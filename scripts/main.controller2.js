var coluApp = angular.module('coluApp');

coluApp.service('sharedProperties', function() {
    
    var activeVoyage = "Default";
    return {
        getActive: function() {
            return activeVoyage;
        },
        setActive: function(s) {
            activeVoyage = s;
        }
    }
});

coluApp.controller('mainController', function($scope, $http, sharedProperties ){

  //Gets the Voyage-data
  $http.get('http://localhost:8090/voyages').success(function(data,status,headers,config)
    {
    
      //Delete some broken data, Einar Sanberg will solve it, sometime.
      data.splice(9, 1);  
    
      //Position 27 is broken, and I can´t manage to delete it, hehe.   
      $scope.voyages = data.slice(1, 26);

      //console.log("fesfsdfsdfs", data[0]);
      $scope.activeVoyage = $scope.voyages[0];
      $scope.voyagesBad = [];
      $scope.voyagesGood = [];    
      $scope.voyagesHandled = [];

      //Sets some hardcoded parameters
      for(var i = 0; i < $scope.voyages.length; i++)
      {

        var statusArray = ["GOOD", "BAD"];
        
        // console.log("ska vara rand", rand);   

        $scope.voyages[i].rangeParameters = {
          time: {label: "Tid", lowerLimit: '-30', upperLimit: '30', current: $scope.voyages[i].eta, status: statusArray[Math.round(Math.random())], unit: "minuter" },
          velocity: {label: "Hastighet", lowerLimit: '50', upperLimit: '250', current: $scope.voyages[i].shipReports[1].speedAvg, status: statusArray[Math.round(Math.random())], unit: "knop"}
        }

        $scope.voyages[i].singleParameters = {

          fuel: {label: "Bränsle", upperLimit: '250', status:  statusArray[Math.round(Math.random())], unit: "L/mil",},
          combinedWave : {label: "Våghöjd", upperLimit: $scope.voyages[i].requiredMaxSignWaveHeight, current: $scope.voyages[i].weatherWaypoints[1].signWaveHeight, status: statusArray[Math.round(Math.random())], unit: "m"},
          current : {label: "Ström", upperLimit: $scope.voyages[i].requiredMaxCurrentSpeed,current: $scope.voyages[i].weatherWaypoints[1].currentSpeed, status: statusArray[Math.round(Math.random())], unit: "m/s"},
          wind : {label: "Vind", upperLimit: $scope.voyages[i].requiredMaxWindSpeed, current: $scope.voyages[i].weatherWaypoints[1].windSpeed, status: statusArray[Math.round(Math.random())], unit: "m/s"}

        }  
       
        //Add voyages to right array
        if($scope.voyages[i].status == "BAD")
          $scope.voyagesBad.push($scope.voyages[i]);
        else if($scope.voyages[i].status == "OK")
          $scope.voyagesHandled.push($scope.voyages[i]);
        else
          $scope.voyagesGood.push($scope.voyages[i])
      } 

      //Where all the functionality is
      main();   
      
      }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);

      });

  function main (){
    
    //How the form works
    formFunctionality();
    
    //Shows the active Voyage in the detailed view 
    $scope.showActive = function(s){
      sharedProperties.setActive(s);
      $scope.activeVoyage = sharedProperties.getActive();
      $scope.showActive.shipTrue = true;
      //console.log('active shipname ', $scope.showActive.shipName);
    }

    $scope.goBack = function(){
    $scope.showActive.shipTrue = false;
    }


    $scope.smallScreenSize = function(){
      var screenSize = screen.width;

      if(screenSize >= 1000){
        //console.log('Big screen');
        return false;
      }
      if(screenSize < 1000){
        //console.log('Small screen');
        return true;  
      }

    } 

    //Used to only show handle-button on Bad-voyages
    $scope.isBad = function(s){
      return ($scope.voyagesBad.indexOf(s) != -1)
    }

    $scope.test = function(p){
      if(p == BAD)
        return false;
      else
        return true;
    }

    //To "handle" voyages, and then put them in the handled-list
    $scope.handel = function(s){
      if(!isInArray(s,$scope.voyagesHandled))
        $scope.voyagesHandled.push(s);

      var index = $scope.voyagesBad.indexOf(s);
      //console.log("index", index);

      if (index > -1) {
        $scope.voyagesBad.splice(index, 1);
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