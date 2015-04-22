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
      
      //For now, just looking at a few voyages
      $scope.voyages = data.slice(1, 5);
      console.log("fesfsdfsdfs", data[0]);

      //Sets some hardcoded parameters
      for(var i = 0; i < $scope.voyages.length; i++)
      {
        $scope.voyages[i].rangeParameters = {
          time: {label: "Tid", lowerLimit: '-30', upperLimit: '30', status: true, unit: "minuter", number: 0},
          velocity: {label: "Hastighet", lowerLimit: '50', upperLimit: '250', status: false, unit: "knop", number: 1}
        }

        //console.log("oefsn", $scope.voyages[8]);
        
        // $scope.voyages[i].warning = {warning: ': '
        //                           };
                                  
        // if($scope.voyages[i].time.status == 'false')
        // {
        //   $scope.voyages[i].warning.warning += 'T ';
        // } 

        // if($scope.voyages[i].fuel.status == 'false')
        // {
        //   $scope.voyages[i].warning.warning += 'B ';
        // } 

        // if($scope.voyages[i].combinedWave.status == 'false' || $scope.voyages[i].current.status == 'false' || $scope.voyages[i].wind.status == 'false')
        // {
        //   $scope.voyages[i].warning.warning += 'V ';
        // } 

        // if($scope.voyages[i].velocity.status == 'false')
        // {
        //   $scope.voyages[i].warning.warning += 'F ';
        // }                            
        $scope.voyages[i].singleParameters = {

          fuel: {label: "Bränsle", upperLimit: '250', status: true, unit: "L/mil", number: 2},
          combinedWave : {label: "Våghöjd", upperLimit: '250', status:false, unit: "m",number: 3},
          current : {label: "Ström", upperLimit: '250', status:true, unit: "m/s", number: 4},
          wind : {label: "Vind", upperLimit: $scope.voyages[i].weatherWaypoints[1].windSpeed, status:false, unit: "m/s", number: 5}
        
        }        
      
      } 

      
      
      $scope.voyagesBad = $scope.voyages.slice(1, 7);
      $scope.voyagesGood = $scope.voyages.slice(7, 9);
      $scope.voyagesHandled = $scope.voyages.slice(9, 15);
      
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
      console.log("index", index);

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