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

  function checkTimeStatus(i){

      //console.log("hej",i);
      var MINUTES_TO_MILLISEC = 60000;

      var required = Date.parse($scope.voyages[i].rangeParameters.time.required);
      var estimated = Date.parse($scope.voyages[i].rangeParameters.time.current);
      //console.log("estimated ", estimated);


      var lower = required + $scope.voyages[i].rangeParameters.time.lowerLimit*MINUTES_TO_MILLISEC;
      //console.log("lower ", lower);
      var higher = required + $scope.voyages[i].rangeParameters.time.upperLimit*MINUTES_TO_MILLISEC;
            //console.log("higher ", higher);


      if( estimated < higher && estimated > lower){
        $scope.voyages[i].rangeParameters.status = true;
      }
      else {
        $scope.voyages[i].rangeParameters.status = false;
      }
      //console.log($scope.voyages[i].rangeParameters.status);
    }

  //Gets the Voyage-data
  $http.get('http://localhost:8090/voyages').success(function(data,status,headers,config)
    {
      

      //Delete some broken data, Einis will solve it, sometime,
        data.splice(9, 1);  
      
      $scope.voyages = data.slice(1, 26);
      console.log("fesfsdfsdfs", data[0]);

      $scope.voyagesBad = [];
      $scope.voyagesGood = [];    
      $scope.voyagesHandled = [];
      $scope.activeVoyage = $scope.voyages[0];

      //Sets some hardcoded parameters
      for(var i = 0; i < $scope.voyages.length; i++)
      {
        $scope.voyages[i].rangeParameters = {
          time: {label: "Tid", lowerLimit: '-30', upperLimit: '30', required: $scope.voyages[i].eta, status: true, unit: "minuter", current: $scope.voyages[i].eta, number: 0, index: i },
          velocity: {label: "Hastighet", lowerLimit: '50', upperLimit: '250', status: false, unit: "knop", current: $scope.voyages[i].shipReports[1].speedAvg, number: 1}
        }
        
         checkTimeStatus(i);
  
        $scope.voyages[i].singleParameters = {

          fuel: {label: "Bränsle", upperLimit: '250', status: true, unit: "L/mil", number: 2},
          combinedWave : {label: "Våghöjd", upperLimit: $scope.voyages[i].requiredMaxSignWaveHeight, current: $scope.voyages[i].weatherWaypoints[1].signWaveHeight, status:false, unit: "m",number: 3},
          current : {label: "Ström", upperLimit: $scope.voyages[i].requiredMaxCurrentSpeed,current: $scope.voyages[i].weatherWaypoints[1].currentSpeed, status:true, unit: "m/s", number: 4},
          wind : {label: "Vind", upperLimit: $scope.voyages[i].requiredMaxWindSpeed, current: $scope.voyages[i].weatherWaypoints[1].windSpeed, status:false, unit: "m/s", number: 5}


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

      $scope.saveIndex = function(id, index) {
        $scope.disableEditor(id);
        //("save", id);
        //console.log("sadsad", index);
        checkTimeStatus(index);

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