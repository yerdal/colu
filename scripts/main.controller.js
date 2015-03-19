
angular.module('coluApp')

.controller('mainController', function($scope){
  	
      	$scope.ships = [
            {
                name: 'Jonken1',
                lat: 51.505,
                lon: -2.09
            },
            {
                name: 'Jonken2',
                lat: 51.375,
                lon: -20.35
            },
            {
                name: 'Jonken3',
                lat: 51.267,
                lon: -10.083
            }
        ];

		$scope.center = {
             lat: $scope.ships[0].lat,
             lon: $scope.ships[1].lon,
             zoom: 4
         }


             
             
 
    
});