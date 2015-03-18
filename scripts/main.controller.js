

angular.module('coluApp')
  .controller('MainController', function($scope, $http){

    //Get data from backend
    $http.get('http://localhost:8080/ship/test').success(function(data,status,headers,config)
    {
      console.log('Got some values ', data);
      $scope.shipData = data;
    }).error(function(data,status,headers,config){
      console.log('ERROR getting from backend' , status);
    });

    //Starting Coordinates, Los Angeles
    var citymap ={};
    var cityCircle;
    var map;
    citymap['losangeles'] = {
        center: new google.maps.LatLng(37.772323, -122.214897),
        population: 3857799
      };

    function initialize() {
        // Create the map.
        var mapOptions = {
          zoom: 4,
          center: new google.maps.LatLng(37.09024, -122.214897),
          mapTypeId: google.maps.MapTypeId.TERRAIN
        };

        map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);

    }

    initialize();

    var x = -(37.772323 - 21.291982);
    var y = -(-122.214897 - -157.821856);

    var stepX = 0;
    var stepY = 0;

    $scope.moveShip = function(){
        
      stepX = (x  + stepX) / 1000;
      stepY = (y + stepY )/ 1000;
      
      // console.log('X ', x, ' Y ', y);

      //Set latitud and longitud coords to circle
      citymap.losangeles.center.k =  citymap.losangeles.center.k  + stepX;
      citymap.losangeles.center.D =  citymap.losangeles.center.D + stepY;

      // console.log('cityCircle ', cityCircle);
      var populationOptions = {
          strokeColor: '#FF0000',
          strokeOpacity: 0.8,
          strokeWeight: 2,
          fillColor: '#FF0000',
          fillOpacity: 0.35,
          map: map,
          center: citymap['losangeles'].center,
          radius: Math.sqrt(citymap['losangeles'].population) * 10
        };
        // Add the circle for this city to the map.
      cityCircle = new google.maps.Circle(populationOptions);
      //Call this function again
      setTimeout($scope.moveShip,100); 
       
  }
   setTimeout($scope.moveShip,1000); 
});