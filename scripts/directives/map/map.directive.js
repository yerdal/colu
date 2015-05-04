
var coluApp = angular.module('coluApp');
coluApp.directive('map', function() {
  return {
    restrict: 'E',
    transclude: true,
    templateUrl: 'colu/scripts/directives/map/map.html',
    link: function(scope, element){
      var map = new ol.Map({
        layers: [new ol.layer.Tile({ preload: 4, source: new ol.source.OSM()})],
        target: document.getElementById('map'),
        view: new ol.View({
          zoom: 6.000
          })
      });
      var shipVectorSource = new ol.source.Vector({});

      var initPos = function(){

        var iconFeature = new ol.Feature({
        geometry: new                         //LON , LAT 
          ol.geom.Point(ol.proj.transform([scope.activeVoyage.latestShipReport.lon, scope.activeVoyage.latestShipReport.lat], 'EPSG:4326',   'EPSG:3857'))
        });

         iconFeature.setId(1);   //Set id to get the right feature later in when updating position
         var iconStyle = new ol.style.Style({
          image: new ol.style.Icon({
            // anchor: [0.5, 46],
            // anchorXUnits: 'fraction',
            // anchorYUnits: 'pixels',
            opacity: 0.75,
            // rotation: -3.14/2,
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

      var setLine = function()
      {
          var points = []; 

        for(var a = 0; a < scope.activeVoyage.weatherWaypoints.length; a++){
          points[a] = ol.proj.transform([scope.activeVoyage.weatherWaypoints[a].lon, scope.activeVoyage.weatherWaypoints[a].lat], 'EPSG:4326', 'EPSG:3857');
          //console.log(points[a]);
        }

        var featureLine = new ol.Feature({
            geometry: new ol.geom.LineString(points)
        });

        var shipRouteLine = new ol.source.Vector({});
        shipRouteLine.addFeature(featureLine);

        var shipRouteLineLayer = new ol.layer.Vector({
              source: shipRouteLine,
              style: new ol.style.Style({
              fill: new ol.style.Fill({
                  color: '#000000',
                  weight: 4
              }),
              stroke: new ol.style.Stroke({
                  color: '#FF00FF',
                  width: 2
              })
              })
        });
       
       map.addLayer(shipRouteLineLayer);  
      }

      initPos();
      setLine();
      
      scope.$watch('activeVoyage' , function(){
        setShipPosition();
        setLine();
      });
      
      
      
      
      var setShipPosition = function(){
        map.getView().setCenter(ol.proj.transform([scope.activeVoyage.latestShipReport.lon, scope.activeVoyage.latestShipReport.lat], 'EPSG:4326', 'EPSG:3857'));
     
          
        shipVectorSource.getFeatureById(1).setGeometry(
              new ol.geom.Point(ol.proj.transform([scope.activeVoyage.latestShipReport.lon, scope.activeVoyage.latestShipReport.lat], 'EPSG:4326',   'EPSG:3857'))
          );
 
      }

    }
  };
});