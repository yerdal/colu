
var coluApp = angular.module('coluApp');
coluApp.directive('map', function() {
  return {
    restrict: 'E',
    transclude: true,
    templateUrl: 'scripts/directives/map/map.html',
    link: function(scope, element){
      var map = new ol.Map({
        layers: [new ol.layer.Tile({ source: new ol.source.OSM()})],
        target: document.getElementById('map'),
        view: new ol.View({
          zoom: 2.000
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
      initPos();
      
      scope.$watch('activeVoyage' , function(){
        setShipPosition();
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