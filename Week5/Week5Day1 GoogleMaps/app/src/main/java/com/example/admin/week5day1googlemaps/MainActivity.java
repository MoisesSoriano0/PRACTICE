package com.example.admin.week5day1googlemaps;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.g_map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Minimum and maximum zoom
//        mMap.setMinZoomPreference(5);
//        mMap.setMaxZoomPreference(15);


        //Seattle coordinates 47.6062095, -122.3320708
        //Atlanta Coordinates 33.753746, -84.386330
        LatLng atlanta = new LatLng(33.753746, -84.386330);
        LatLng seattle = new LatLng(47.6062095, -122.3320708);
        LatLng redmond = new LatLng(47.6739881, -122.121512);
        LatLng sammamish = new LatLng(47.6162683, -122.0355736);
        LatLng issaquah = new LatLng(47.5301011, -122.0326191);
        LatLng bellevue = new LatLng(47.6101497, -122.2015159);




        //Circle
        circleOptions(atlanta);
        circleOptions(seattle);

//        mMap.addMarker(new MarkerOptions().position(atlanta).title("Atlanta"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(atlanta));


        //Polyline, a line to join two or more locations
        LatLng[] polys = {atlanta, seattle, redmond, sammamish};
//        polylineOptions(polys);


        //Polygon
        LatLng[] polys2 = {issaquah, seattle, bellevue, sammamish, redmond};
        polygonOptions(polys2);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));


        //Map Types
//        You can display different types of Google maps in your application by calling setMapType and passing map type such as
        // MAP_TYPE_HYBRID, MAP_TYPE_NORMAL, MAP_TYPE_SATELLITE or MAP_TYPE_TERRAIN.
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        //Google Maps Custom Marker (image in this case)
//        CustomMarker(bellevue);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(bellevue));


        //Android Google Maps Ground Overlay
/*        Ground overlay, which you can add to map, is an image tied to earth surface.
        The difference between marker and ground overlay is that marker is tied to screen and
        its orientation is not changed on rotating or tilting the map.
                Whereas ground overlay image changes its orientation on rotating or tilting the map.*/

//        mMap.setMinZoomPreference(10);
//        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions ();
//        groundOverlayOptions.position(bellevue,100, 100)
//                .image( BitmapDescriptorFactory.fromResource(R.drawable.wally));
//
//        mMap.addGroundOverlay(groundOverlayOptions);
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(bellevue));


        //Android Google Maps Info Window
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(bellevue)
                .title("Bellevue")
                .icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN));

        Marker m = mMap.addMarker(markerOptions);
        m.showInfoWindow();

    }

    private void CustomMarker(LatLng bellevue) {
        mMap.setMinZoomPreference(10);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(bellevue)
                .title("Bellevue")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.waldo))
                .rotation(20)
                .draggable(false);
        mMap.addMarker(markerOptions);
    }

    private void polygonOptions(LatLng[] polys) {
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.add(polys[0], polys[1], polys[2], polys[3], polys[4]);
        polygonOptions.strokeJointType(JointType.ROUND);
        polygonOptions.strokeColor(Color.RED);
        polygonOptions.strokeWidth(10);

        mMap.addPolygon(polygonOptions);
    }

    private void polylineOptions(LatLng[] polys) {
        PolylineOptions plo = new PolylineOptions();
        plo.add(polys[0]);
        plo.add(polys[1]);
        plo.color(Color.RED);
        plo.geodesic(true);
        plo.startCap(new RoundCap());
        plo.width(15);
        plo.jointType(JointType.BEVEL);
        mMap.addPolyline(plo);
    }


    private void circleOptions(LatLng area) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(area);
        circleOptions.radius(8500);
        circleOptions.fillColor(Color.GREEN);
        circleOptions.strokeColor(Color.RED);
        circleOptions.strokeWidth(4);
        mMap.addCircle(circleOptions);
    }

}
