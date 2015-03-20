angular.module('coluApp')


.controller('mainController', function($scope, $http){
    

    

    $scope.sliderValue = 0
    var vectorLayer;
    var shipVectorSource = new ol.source.Vector({});
    var map = new ol.Map({
      layers: [new ol.layer.Tile({ source: new ol.source.OSM() })],
      target: document.getElementById('map'),
      view: new ol.View({
        center: [0, 0],
        zoom: 2.5
      })
    });

    var initGribData = function(){
      var gribSource = new ol.source.TileWMS({
          url: 'http://localhost:8080/geoserver/wms',
                    params: {'LAYERS': 'cite:Temperature_surface'},
                    serverType: 'geoserver'
                    //crossOrigin: ''
                    
      });
      var gribLayer = new ol.layer.Tile({
        source: gribSource,
        opacity: 0.5
      });
      var view = new ol.View({
        center: [0, 0],
        zoom: 1
      });
       
      map.addLayer(gribLayer);

      map.on('pointermove', function(evt) {
        document.getElementById('info').innerHTML = '';
        var viewResolution = /** @type {number} */ (view.getResolution());
        var url = gribSource.getGetFeatureInfoUrl(
          evt.coordinate, viewResolution, 'EPSG:3857',
          {'INFO_FORMAT': 'text/html'});
        if (url) {
          document.getElementById('info').innerHTML =
            '<iframe seamless src="' + url + '"></iframe>';
        }
      });
    }
    initGribData();
         //Get data from backend
    $http.get('http://localhost:8090/ships/test').success(function(data,status,headers,config)
    {
      //Init scope data
      $scope.ships = data;
      initShipPos();

      //drawLines(data);

    }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);
    });
  
      
    var initShipPos = function(){
      
      // console.log('daata ', data)
      for(var i = 0; i < $scope.ships.length; i++){
        var iconFeature = new ol.Feature({
        geometry: new                         //LON , LAT 
          ol.geom.Point(ol.proj.transform([$scope.ships[i].satCPollPositions[0].lon, $scope.ships[i].satCPollPositions[0].lat], 'EPSG:4326',   'EPSG:3857')),
          name: 'Null Island ' + i,
          population: 4000,
          rainfall: 500
        });
        var points = [];
        //Loop through ship positions
        for(var a = 0; a < $scope.ships[i].satCPollPositions.length;a++){
          points[a] = ol.proj.transform([$scope.ships[i].satCPollPositions[a].lon, $scope.ships[i].satCPollPositions[a].lat], 'EPSG:4326', 'EPSG:3857');
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


        shipVectorSource.addFeature(iconFeature);


      }
          
      //create the style
      var iconStyle = new ol.style.Style({
        image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
          // anchor: [0.5, 46],
          // anchorXUnits: 'fraction',
          // anchorYUnits: 'pixels',
          opacity: 0.75,
          // rotation: -3.14/2,

          src: 'http://icons.iconarchive.com/icons/icons-land/transporter/32/Container-Ship-Top-Red-icon.png'
        }))
      });
      

   
      //add the feature vector to the layer vector, and apply a style to whole layer
      vectorLayer = new ol.layer.Vector({
        source: shipVectorSource,
        style: iconStyle
      });

      map.addLayer(vectorLayer);
      
    }
    var count = 0;
    $scope.updateShip = function(){
        console.log('sliderchange');
        // console.log('getLayer ', shipVectorSource.getFeatures().length);
        count++;
        // shipVectorSource.getFeatures()[20].setGeometry(
        //       new ol.geom.Point(ol.proj.transform([22,22], 'EPSG:4326',   'EPSG:3857'))
        //     )
        // var tempShipArr = shipVectorSource.getFeatures();
        for(var i = 0; i < shipVectorSource.getFeatures().length; i++){
          shipVectorSource.getFeatures()[i].setGeometry(
              new ol.geom.Point(ol.proj.transform([$scope.ships[i].satCPollPositions[count].lon, $scope.ships[i].satCPollPositions[count].lat], 'EPSG:4326',   'EPSG:3857'))
          )
        }

    }

    

    

     
      
    


});