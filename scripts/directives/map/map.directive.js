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
coluApp.directive('map', function() {
  return {
    restrict: 'E',
    transclude: true,
    templateUrl: 'scripts/directives/map/map.html',
    link: function(scope, element){
      var map = new ol.Map({
        layers: [
          new ol.layer.Tile({
            source: new ol.source.XYZ({
              url: 'http://api.tiles.mapbox.com/v4/mapbox.streets/{z}/{x}/{y}.png?access_token=pk.eyJ1Ijoiam9oYW5oZW5yaWtzc29uIiwiYSI6IjZkZmZkNDQ2N2EzYmRhYjBhMzUzYjNiNzgwMWRhOWYwIn0.mI8Pclywhn9DD3t9_YaADg'
            })
          })
        ],
        target: 'map',
        view: new ol.View({
          center: [0, 0],
          zoom: 6,
          minZoom: 2
        })
      });

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


    }
  };
});