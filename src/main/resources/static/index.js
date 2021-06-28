'use strict';

const locations = [{"id":1,"longValue":"30.5624","latValue":"50.4356","address":"Lavrska St, 15, Kyiv, 01015","addressDeatails":"Ornate religious buildings line this iconic monastic complex, known for its network of catacombs.","city":{"id":1,"city":"Kyiv"}},{"id":2,"longValue":"30.5378","latValue":"50.4276","address":"Zapecherna St, Kyiv, 02000","addressDeatails":"Huge statue atop of the National Museum of the History of the Great Patriotic War of 1941-1945.","city":{"id":1,"city":"Kyiv"}},{"id":3,"longValue":"32.0224","latValue":"49.4198","address":"Smilyanska St, 132, Cherkasy","addressDeatails":"City zoo","city":{"id":2,"city":"Cherkasy"}}];


let markers = [];
let map;
let startMapParams = { coords: { lat: 48.3794, lng: 31.1656 }, zoom: 6 };
//let locations = [];

async function initMap() {

  map = new google.maps.Map(document.getElementById('map'), {
    center: startMapParams.coords,
    zoom: startMapParams.zoom,
    zoomControl: false,
  });
/*
  let response = await fetch('http://localhost:8080/locations');
  locations = await response.json();
*/
  if (locations.length > 0) {
    locations.forEach(location => addMarker(location));
  
    const cities = [...new Set(locations.map(({city}) => city.city))];
    putCitiesToMenu(cities.sort());
  }

  manageZoom();
}

const manageZoom = function () {
  document.getElementById('increase').addEventListener("click", () => map.setZoom(map.getZoom() + 1));
  document.getElementById('decrease').addEventListener("click", () => map.setZoom(map.getZoom() - 1));
  document.getElementById('reset').addEventListener("click", () => resetMap());
}

const addMarker = function (location) {
  const { longValue, latValue, addressDeatails } = location;
  const marker = new google.maps.Marker({
    position: { lat: +latValue, lng: +longValue },
    map,
  });

  markers.push(marker);

  let infoWindow = new google.maps.InfoWindow({
    content: addressDeatails,
  });

  marker.addListener('click', () => {
    infoWindow.close();
    infoWindow.open(marker.get('map'), marker);

    moveToCoords(marker.getPosition(), 10);
  })
}

const moveToCoords = function (coords, zoom = 12) {
  map.setZoom(zoom);
  map.setCenter(coords);
}

const resetMap = function () {
  moveToCoords(startMapParams.coords, startMapParams.zoom);
}

const putCitiesToMenu = function (cities) {
  let citiesList = '<ul class="list">';

  citiesList += cities.reduce((list, city) => {
    return list.concat(`<li id=${city} class="item">${city}</li>`)
  }, '');
  citiesList += '</ul>';

  document.getElementById('menu').innerHTML = citiesList;
  document.getElementById('menu').onclick = function (event) {
    moveToCoords(getCoordsOfCity(event.target.innerHTML));
  };
}

const getCoordsOfCity = function (city) {
  const location = locations.find(cityRecord => cityRecord.city.city === city);
  const { latValue, longValue } = location;

  return { lat: +latValue, lng: +longValue };
}
