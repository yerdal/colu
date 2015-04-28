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

      //console.log("fesfsdfsdfs", data[5]);
      $scope.activeVoyage = $scope.voyages[0];
      $scope.voyagesBad = [];
      $scope.voyagesGood = [];    
      $scope.voyagesHandled = [];

      //Sets some hardcoded parameters
      for(var i = 0; i < $scope.voyages.length; i++)
      {
      
        $scope.voyages[i].rangeParameters = {
          time: {label: "Tid", lowerLimit: '-30', upperLimit: '30', current: $scope.voyages[i].requiredETA, status: $scope.voyages[i].latestShipReport.requiredETAStatus, unit: "minuter" },
          velocity: {label: "Hastighet", lowerLimit: $scope.voyages[i].requiredAvgSpeedMin, upperLimit: $scope.voyages[i].requiredAvgSpeedMax, current: $scope.voyages[i].latestShipReport.speedAvg, status: $scope.voyages[i].latestShipReport.avgSpeedStatus, unit: "knop"}
        }

        $scope.voyages[i].singleParameters = {

          fuel: {label: "Bränsle", upperLimit: '250', current: '200', status: "GOOD", unit: "L/mil",},
          combinedWave : {label: "Våghöjd", upperLimit: $scope.voyages[i].requiredMaxSignWaveHeight, current: $scope.voyages[i].currentWeatherWaypoint.signWaveHeight, status: $scope.voyages[i].currentWeatherWaypoint.signWaveHeightStatus, unit: "m"},
          current : {label: "Ström", upperLimit: $scope.voyages[i].requiredMaxCurrentSpeed, current: $scope.voyages[i].currentWeatherWaypoint.currentSpeed, status: $scope.voyages[i].currentWeatherWaypoint.currentSpeedStatus, unit: "m/s"},
          wind : {label: "Vind", upperLimit: $scope.voyages[i].requiredMaxWindSpeed, current: $scope.voyages[i].currentWeatherWaypoint.windSpeed, status: $scope.voyages[i].currentWeatherWaypoint.windSpeedStatus, unit: "m/s"}

        }

        flagVoyage($scope.voyages[i]);

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

    //To "handle" voyages, and then put them in the handled-list
    $scope.handel = function(s){
      if(!isInArray(s,$scope.voyagesHandled))
        $scope.voyagesHandled.push(s);

      var index = $scope.voyagesBad.indexOf(s);
      

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

  
          //Test current and investigate the status
          if ($scope.activeVoyage.singleParameters.current.current < $scope.activeVoyage.singleParameters.current.upperLimit)
          {
            $scope.activeVoyage.singleParameters.current.status = "GOOD";
          } 

          //Test fuel and investigate the status
          if ($scope.activeVoyage.singleParameters.fuel.current < $scope.activeVoyage.singleParameters.fuel.upperLimit)
          {
            $scope.activeVoyage.singleParameters.fuel.status = "GOOD";
          } 

          //Test combineWaveHeight and investigate the status
          if ($scope.activeVoyage.singleParameters.combinedWave.current < $scope.activeVoyage.singleParameters.combinedWave.upperLimit)
          {
            $scope.activeVoyage.singleParameters.combinedWave.status = "GOOD";
          } 

          //Test wind and investigate the status
          if ($scope.activeVoyage.singleParameters.wind.current < $scope.activeVoyage.singleParameters.wind.upperLimit)
          {
            $scope.activeVoyage.singleParameters.wind.status = "GOOD";
          } 

          flagVoyage($scope.activeVoyage);


        };

      }

      function isInArray(value, array) {
        return array.indexOf(value) > -1;
      }
      
  }

  //Add voyages to right array, if any status is BAD, place in voyagesBad.
  function flagVoyage(voyage){
    if(voyage.rangeParameters.time.status == "BAD" || voyage.rangeParameters.velocity.status == "BAD" || voyage.singleParameters.fuel.status == "BAD" || voyage.singleParameters.combinedWave.status == "BAD" || voyage.singleParameters.current.status == "BAD"  || voyage.singleParameters.wind.status == "BAD")
    {

      var index = $scope.voyagesBad.indexOf(voyage);
        if (index == -1)
          $scope.voyagesBad.push(voyage);

    } 
    else
    {
      $scope.voyagesGood.push(voyage)
      var index = $scope.voyagesBad.indexOf(voyage);
        if (index > -1) 
          $scope.voyagesBad.splice(index, 1);
    }
  }
});