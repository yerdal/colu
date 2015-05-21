/**
 * @ngdoc directive
 * @name coluApp.directive:map
 * @restrict E

 * External Link -  {@link http://angular-ui.github.com/ng-grid/ ngGrid} 
 *
 * @description
 * Directive to represent a world map with ship, voyage and weather visualizations
 *
 * @example
   <example module="coluApp">
     <file name="index.html">
         <map></map>
     </file>
   </example>
 */

var coluApp = angular.module('coluApp');
coluApp.directive('map', ['$http', function($http) {
  return {
    restrict: 'E',
    transclude: false,
    templateUrl: 'scripts/directives/map/map.html',
    link: function(scope, element){
      var map = new ol.Map({
        layers: [new ol.layer.Tile({ preload: 4, source: new ol.source.OSM()})],
        target: document.getElementById('map'),
        view: new ol.View({
          zoom: 6.000,
          minZoom: 2
          })
      });
      console.log('scope.search ', scope.search);
      var shipVectorSource = new ol.source.Vector({});
      var shipRouteLine = new ol.source.Vector({});
      var points = []; 

      var updatePoints = function(){

        //Clears the array
        points.length = 0;
        for(var a = 0; a < scope.activeVoyage.weatherWaypoints.length; a++){
          points[a] = ol.proj.transform([scope.activeVoyage.weatherWaypoints[a].lon, scope.activeVoyage.weatherWaypoints[a].lat], 'EPSG:4326', 'EPSG:3857');
        }

      }

      var initPos = function(){

        var iconFeature = new ol.Feature({
        geometry: new                         
          ol.geom.Point(ol.proj.transform([scope.activeVoyage.latestShipReport.lon, scope.activeVoyage.latestShipReport.lat], 'EPSG:4326',   'EPSG:3857'))
        });

         iconFeature.setId(1);   //Set id to get the right feature later in when updating position
         var iconStyle = new ol.style.Style({
          image: new ol.style.Icon({
            opacity: 0.75,
            src: 'http://icons.iconarchive.com/icons/icons-land/transporter/32/Container-Ship-Top-Red-icon.png'
          })
        });

        iconFeature.setStyle(iconStyle);
        shipVectorSource.addFeature(iconFeature);
          
        //add the feature vector to the layer vector, and apply a style to whole layer
        vectorLayer = new ol.layer.Vector({
          source: shipVectorSource,
          style: iconStyle
        });

        map.addLayer(vectorLayer);
      }

      var initLine = function()
      {

        //Update the points-aray with activeVoayges points.
        updatePoints();

        var featureLine = new ol.Feature({
            geometry: new ol.geom.LineString(points)
        });

        featureLine.setId(2); 
        shipRouteLine.addFeature(featureLine);

        var shipRouteLineLayer = new ol.layer.Vector({
              source: shipRouteLine,
              style: new ol.style.Style({
              fill: new ol.style.Fill({
                  color: '#000000',
                  weight: 1
              }),
              stroke: new ol.style.Stroke({
                  color: '#000000',
                  width: 1
              })
              })
        });

       map.addLayer(shipRouteLineLayer);  
       
      }

      initPos();
      initLine();
      
      scope.$watch('activeVoyage' , function(){
        updatePoints();
        setShipPosition();
        setLinePosition();
      });


      
      
      var setShipPosition = function(){
        map.getView().setCenter(ol.proj.transform([scope.activeVoyage.latestShipReport.lon, scope.activeVoyage.latestShipReport.lat], 'EPSG:4326', 'EPSG:3857'));
     
          
        shipVectorSource.getFeatureById(1).setGeometry(
              new ol.geom.Point(ol.proj.transform([scope.activeVoyage.latestShipReport.lon, scope.activeVoyage.latestShipReport.lat], 'EPSG:4326',   'EPSG:3857'))
          );
 
      }

      var setLinePosition = function(){
          
        shipRouteLine.getFeatureById(2).setGeometry(
              new ol.geom.LineString(points)
              
          );
      
      }

    scope.$watch('searchLocation' , function(){
      if(scope.searchLocation){
        var srcStr = scope.searchLocation.replace(" ", "%20");
        srcStr = srcStr.replace(/"/g, "").replace(/'/g, "").replace(/\([\s\S]*?\)/g, "");
        console.log(srcStr)
        $http.get('http://nominatim.openstreetmap.org/search/'+srcStr+'?format=json&addressdetails=1&limit=1').success(function(data,status,headers,config)
        {
          map.getView().setCenter(ol.proj.transform([Number(data[0].lon), Number(data[0].lat)],'EPSG:4326', 'EPSG:3857'));
          console.log('data', data)
        }).error(function(data,status,headers,config){
          console.log('ERROR getting from find locaiton' , status);

        });
      }
      console.log('scope. search in map dire ', scope.searchLocation );
    });
    scope.findLocation = function(locationName){
      console.log('hahsah');
        // http://nominatim.openstreetmap.org/search?q=santa+barbara
        
    }


    }
  }; //link return bracket
}]);