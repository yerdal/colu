
angular.module('coluApp')


.controller('mainController', function($scope, $http){
  	
;

       $scope.ship = {name: 'JOnk', lat: 51.04, lon: -20.32};
        

         //Get data from backend
             $http.get('http://localhost:8080/ship/test').success(function(data,status,headers,config)
             {
               console.log('Got some values ', data);

               $scope.shipData = data;

             }).error(function(data,status,headers,config){
               console.log('ERROR getting from backend' , status);
             });

  			$scope.center = {
  	             lat: $scope.ship.lat,
  	             lon: $scope.ship.lon,
  	             zoom: 4
  	         }

});