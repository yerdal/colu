angular.module('coluApp')


.controller('mainController', function($scope, $http){
    

       $scope.ship = {name: 'JOnk', lat: 51.04, lon: -20.32};
        

         //Get data from backend
             $http.get('http://localhost:8080/ships/test').success(function(data,status,headers,config)
             {

               $scope.ships = data;
               
               console.log('comments', $scope.ships[8])
              

               // console.log('Got some values ', data);

            $scope.center = {
                      lat: 40.04,
                      lon: -10.32,
                      zoom: 2
                  }

             }).error(function(data,status,headers,config){
               console.log('ERROR getting from backend' , status);
             });

        

});