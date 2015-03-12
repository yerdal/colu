function initialize() {
  var map = new google.maps.Map(document.getElementById('map-canvas'), {
    zoom: 5,
    center: new google.maps.LatLng(-40.363882,200.044922),
    mapTypeId: google.maps.MapTypeId.HYBRID
  });

  var myShip = new google.maps.Circle({
    center: new google.maps.LatLng(-40.363882,200.044922),
    radius:20000,
    strokeColor:"#FF0000",
    strokeOpacity:0.8,
    strokeWeight:2,
    fillColor:"#FF0000",
    fillOpacity:0.4,
    map: map,

  });
    var otherShip = new google.maps.Circle({
    center: new google.maps.LatLng(-42.363882,200.044922),
    radius:20000,
    strokeColor:"#FF0000",
    strokeOpacity:0.8,
    strokeWeight:2,
    fillColor:"#FF0000",
    fillOpacity:0.4,
    map: map,
  });
}


google.maps.event.addDomListener(window, 'load', initialize);