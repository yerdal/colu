angular.module('coluApp')


.controller('mainController', function($scope, $http){
    


    // somewhere in your controller

    $scope.options = {
      min: new Date(2015,2,07),  //Date for when the shipdataa got init
      format: 'yyyy-mm-dd', // ISO formatted date
      onClose: function(e) {
        // do something when the picker closes  
        // console.log('jasdjas')
      }
    }
    var nrOfDaysForward = 4;
    $scope.maxDate = new Date(2015,2,18); //Date.now()-1000*60*60*24*nrOfDaysForward); //Set a default date to slide to
    $scope.minDate = new Date(2015,02,07); 
    $scope.sliderDate = $scope.minDate;
    $scope.sliderValue = 0
    var vectorLayer;
    var shipVectorSource = new ol.source.Vector({});

    var map = new ol.Map({
      layers: [new ol.layer.Tile({ source: new ol.source.OSM()})],
      target: document.getElementById('map'),
      view: new ol.View({
        center: [0, 0],
        zoom: 2.500
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
    // initGribData();
    $scope.putData = function(){
      console.log('hejje ');
      parameters = {
        requiredCurrentSpeed: 1.2,
        requiredWindSpeed: 15,
        requiredWindDir: 125,
        requiredSignWaveHeight: 1.1,
        requiredCurrentDir: 12,
        requiredMinETA: "2015-05-20 00:00",
        requiredMaxETA: "2015-05-21 02:00",
        requiredAvgSpeedMin: 13,
        requiredAvgSpeedMax: 20
      }
      $http.put('http://localhost:8090/voyages/89710/updatelimits', parameters).success(function(data,status,headers,config)
      {
        //Succes getting from backend
        //Init scope data
        console.log ('data ', data);


        //drawLines(data);
      }).error(function(data,status,headers,config){
          console.log('ERROR getting from backend' , status);
      });
    }

    //Get data from backend
    $http.get('http://localhost:8090/ships/id/notdefined').success(function(data,status,headers,config)
    {
      //Succes getting from backend
      //Init scope data
      $scope.ships = data;
      console.log ('data ', data);
      initShipPos();
      //drawLines(data);
    }).error(function(data,status,headers,config){
        console.log('ERROR getting from backend' , status);
    });
  
    
    var initShipPos = function(){
       var shipVectorIconSrc = new ol.source.Vector({});
       var styleArray = [];
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
        iconFeature.setId(i);   //Set id to get the right feature later in when updating position
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
         // });
      var stroke = new ol.style.Stroke({
        color: 'black'
      });
      var textStroke = new ol.style.Stroke({
        color: '#fff',
        width: 3
      });
      var textFill = new ol.style.Fill({
        color: '#000'
      });
      var iconStyle = new ol.style.Style({
        image: new ol.style.Icon({
          // anchor: [0.5, 46],
          // anchorXUnits: 'fraction',
          // anchorYUnits: 'pixels',
          opacity: 0.75,
          // rotation: -3.14/2,
          src: 'http://icons.iconarchive.com/icons/icons-land/transporter/32/Container-Ship-Top-Red-icon.png'
        }),
        text: new ol.style.Text({
          offsetY : -14,
          font: '14px Calibri,sans-serif',
          text: $scope.ships[i].shipName,
          fill: textFill,
          stroke: textStroke,
          
        })
        
      });

      map.addLayer(shipRouteLineLayer);

      // THIS IS NEW - add each style individually to the feature
      iconFeature.setStyle(iconStyle);

        // shipVectorIconSrc.addFeature(iconStyle);
      shipVectorSource.addFeature(iconFeature);
         
      }
         
      //add the feature vector to the layer vector, and apply a style to whole layer
      vectorLayer = new ol.layer.Vector({
        source: shipVectorSource,
        style: iconStyle
      });
      shipVectorSource.getFeatureById(1).setGeometry(
              new ol.geom.Point(ol.proj.transform([$scope.ships[i].satCPollPositions[nearestPosInd].lon, $scope.ships[i].satCPollPositions[nearestPosInd].lat], 'EPSG:4326',   'EPSG:3857'))
          )
 
      map.addLayer(vectorLayer);
      
      
    }

    $scope.updateShipPos = function(){
        var nowDate = new Date(2015,02,07); //Should use Date.Now in real application
        $scope.maxDate = new Date($scope.maxDate);
        console.log('MaxDate ', new Date($scope.maxDate));
        var milliBetweenEndAndNow = Math.abs(nowDate - $scope.maxDate)
        //multiply slider value with milliseconds between end and now date
        var milliOnSlider = $scope.sliderValue * (1 / 100) * milliBetweenEndAndNow;
        // get the current date & time
        var tempM = nowDate.getTime() + milliOnSlider;
        $scope.sliderDate = new Date(tempM);
        // console.log('Slider DATE ', $scope.sliderDate, nowDate.getTime(),milliOnSlider, tempM);
    
        for(var i = 0; i < shipVectorSource.getFeatures().length; i++){
          var tempDiff;
          var nearestPosInd = 0;
          for(var k = 0; k < $scope.ships[i].satCPollPositions.length; k++){
            var tempDate =  new Date($scope.ships[i].satCPollPositions[k].date.replace(/-/g,'/'));
            // console.log('tempDate Ship ' , tempDate);
            if(k == 0){
              nearestPosInd = k;
              tempDiff =  Math.abs($scope.sliderDate - tempDate);
            }
            //Check if Date is close and set the nearestPos index to move ship to that positions 
            if(tempDiff > Math.abs($scope.sliderDate - tempDate))
            {
              nearestPosInd = k;
              tempDiff = Math.abs($scope.sliderDate - tempDate);
            }
          }

          shipVectorSource.getFeatureById(i).setGeometry(
              new ol.geom.Point(ol.proj.transform([$scope.ships[i].satCPollPositions[nearestPosInd].lon, $scope.ships[i].satCPollPositions[nearestPosInd].lat], 'EPSG:4326',   'EPSG:3857'))
          )
        }
        // console.log('asdsad' ,$scope.ships);

    }

    

    

     
      
    


});