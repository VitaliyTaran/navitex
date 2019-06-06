var map = L.map('map').setView([53.901332, 27.558382], 12);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

var control = L.Routing.control(L.extend(window.lrmConfig, {
    waypoints: [
        L.latLng(57.74, 11.94),
        L.latLng(57.67, 11.94),
        L.latLng(57.6792, 11.949)
    ],
    geocoder: L.Control.Geocoder.nominatim(),
    routeWhileDragging: true,
    reverseWaypoints: true,
    showAlternatives: true,
    altLineOptions: {
        styles: [
            {color: 'black', opacity: 0.15, weight: 9},
            {color: 'white', opacity: 0.8, weight: 6},
            {color: 'blue', opacity: 0.5, weight: 2}
        ]
    }
})).addTo(map);

L.Routing.errorControl(control).addTo(map);