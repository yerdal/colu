angular.module('coluApp')


.controller('mainController', function($scope, $http ){

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
  }
      

});