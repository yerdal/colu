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
    templateUrl: 'scripts/directives/map/map.html',
    link: function(scope, element, attrs){
      scope.updateMapView = function(){
        map.getView().setCenter(ol.proj.transform([Number(scope.searchDestLocation.lon), Number(scope.searchDestLocation.lon)],'EPSG:4326', 'EPSG:3857'));
      };
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
          zoom: 2.5,
          minZoom: 2
        })
      });
      // console.log('scope.search ', scope.search);
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

        //Update the points-array with activeVoayges points.
        updatePoints();

        var featureLine = new ol.Feature({
            geometry: new ol.geom.MultiLineString(points)
            // style:new ol.style.Style({
            //     fill: new ol.style.Fill({
            //         color: '#FFFFFF',
            //         weight: 1
            //     }),stroke: new ol.style.Stroke({
            //         color: '#FFFFFF',
            //         width: 1
            //     })
            //   })

        });

        featureLine.setId(2); 
        shipRouteLine.addFeature(featureLine);

        var shipRouteLineLayer = new ol.layer.Vector({
              source: shipRouteLine
              // style: new ol.style.Style({
              //   fill: new ol.style.Fill({
              //       color: '#000000',
              //       weight: 1
              //   }),
              //   stroke: new ol.style.Stroke({
              //       color: '#000000',
              //       width: 1
              //   })
              // })
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
        shipRouteLine.getFeatureById(2).setGeometry(new ol.geom.LineString(points));

      
        pointsarr = shipRouteLine.getFeatureById(2).getGeometry().getCoordinates();
        var styles = [];
        // console.log('cksck', pointsarr);
        for(var i = 0; i < pointsarr.length; i++){
          if(i%5==0)
            color = '#000000';
            // console.log('changinge color ')
          
          styles.push(new ol.style.Style(({
                fill: new ol.style.Fill({
                    color: color,
                    weight: 1
                }),
                stroke: new ol.style.Stroke({
                    color: color,
                    width: 1
                })
              }))
          );
        }
        // shipRouteLine.getFeatureById(2).setStyle(new ol.style.Style({
        //         fill: new ol.style.Fill({
        //             color: '#FF0000',
        //             weight: 1
        //         }),
        //         stroke: new ol.style.Stroke({
        //             color: '#FF0000',
        //             width: 1
        //         })
        //       }));
        shipRouteLine.getFeatureById(2).setStyle(styles);
        
      }

   
    scope.$watch('searchDestLocation' , function(){
      if(scope.searchDestLocation){
        if(shipVectorSource.getFeatureById(3))
          shipVectorSource.removeFeature(shipVectorSource.getFeatureById(3));
        var srcStr = scope.searchDestLocation.replace(" ", "%20");
        srcStr = srcStr.replace(/"/g, "").replace(/'/g, "").replace(/\([\s\S]*?\)/g, "");
        // console.log(srcStr)
        $http.get('http://nominatim.openstreetmap.org/search/'+srcStr+'?format=json&addressdetails=1&limit=1').success(function(data,status,headers,config)
        {
          if(shipVectorSource.getFeatureById(3))
            shipVectorSource.removeFeature(shipVectorSource.getFeatureById(3));
          scope.searchDestLocationlon = data[0].lon;
          scope.searchDestLocationlat = data[0].lat;
         
          var iconFeature = new ol.Feature({
            geometry: new                         //LON , LAT 
              ol.geom.Point(ol.proj.transform([Number(data[0].lon), Number(data[0].lat)], 'EPSG:4326',   'EPSG:3857')),
              population: 4000,
              rainfall: 500
          });
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
              scale: 0.25,
              opacity: 0.75,
              // rotation: -3.14/2,
              src: 'http://localhost:8000/styles/images/map-marker-green.png'
            }),
            text: new ol.style.Text({
              offsetY : -22,
              font: '14px Calibri,sans-serif',
              text: scope.searchDestLocation,
              fill: textFill,
              stroke: textStroke,
          
            })

        
          });
        iconFeature.setStyle(iconStyle);
        iconFeature.setId(3);
        shipVectorSource.addFeature(iconFeature);
 
          // console.log('data', data)
        }).error(function(data,status,headers,config){
          console.log('ERROR getting from find locaiton' , status);

        });
      }
    });
    scope.$watch('searchDepLocation' , function(){
     if(scope.searchDepLocation){
        if(shipVectorSource.getFeatureById(4))
            shipVectorSource.removeFeature(shipVectorSource.getFeatureById(4));
        var srcStr = scope.searchDepLocation.replace(" ", "%20");
        srcStr = srcStr.replace(/"/g, "").replace(/'/g, "").replace(/\([\s\S]*?\)/g, "");
        // console.log(srcStr)
        $http.get('http://nominatim.openstreetmap.org/search/'+srcStr+'?format=json&addressdetails=1&limit=1').success(function(data,status,headers,config)
        {
          if(shipVectorSource.getFeatureById(4))
            shipVectorSource.removeFeature(shipVectorSource.getFeatureById(4));
          scope.searchDepLocationlon = data[0].lon;
          scope.searchDepLocationlat = data[0].lat;
        
          var iconFeature = new ol.Feature({
          geometry: new                         //LON , LAT 
            ol.geom.Point(ol.proj.transform([Number(data[0].lon), Number(data[0].lat)], 'EPSG:4326',   'EPSG:3857')),
            population: 4000,
            rainfall: 500
          });
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
              scale: 0.25,
              opacity: 0.75,
              // rotation: -3.14/2,
              src: 'http://localhost:8000/styles/images/map-marker-green.png'
            }),
            text: new ol.style.Text({
              offsetY : -22,
              font: '14px Calibri,sans-serif',
              text: scope.searchDepLocation,
              fill: textFill,
              stroke: textStroke,
          
            })

        
          });
          iconFeature.setStyle(iconStyle);
          iconFeature.setId(4);
          shipVectorSource.addFeature(iconFeature);
 
          }).error(function(data,status,headers,config){
            console.log('ERROR getting from find locaiton' , status);

          });
        }
      });
  
    scope.$watch('locationFocus', function(){
      if(scope.locationFocus == 'dest'){
        map.getView().setCenter(ol.proj.transform([Number(scope.searchDestLocationlon), Number(scope.searchDestLocationlat)],'EPSG:4326', 'EPSG:3857'));
        scope.updateMap("undefined");
      }else if(scope.locationFocus == 'dep'){
        console.log('in dep' ,scope.searchDepLocationlon)
        map.getView().setCenter(ol.proj.transform([Number(scope.searchDepLocationlon), Number(scope.searchDepLocationlat)], 'EPSG:4326', 'EPSG:3857'));
        scope.updateMap("undefined");
      }
    }); 

    

    }

  }; //link return bracket
}]);



