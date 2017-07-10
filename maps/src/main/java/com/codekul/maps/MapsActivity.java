package com.codekul.maps;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<LatLng> markers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        markers = new ArrayList<>();

        Geocoder coder = new Geocoder(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                markers.add(latLng);
                mMap.addMarker(new MarkerOptions().position(latLng));

                drawLines();

                gotoPune();
            }
        });

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a marker in Sydney and move the camera
        LatLng pune = new LatLng(18.72, 72);
        mMap.addMarker(new MarkerOptions().position(pune).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pune));

        LatLng mumbai = new LatLng(19.0760, 72.8777);
        mMap.addMarker(new MarkerOptions().position(mumbai).title("Mumbai"));

        mMap.addPolyline(new PolylineOptions().add(pune, mumbai).color(Color.RED).width(3));

        mMap.addCircle(new CircleOptions().center(mumbai).fillColor(Color.RED).radius(300));
    }

    private void drawLines() {
        mMap.addPolyline(new PolylineOptions().addAll(markers).color(Color.RED).width(5));
    }

    private void gotoPune() {
        LatLng coordinate = new LatLng(18.72, 72);; //Store these lat lng values somewhere. These should be constant.
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                coordinate, 8);
        mMap.animateCamera(location);
    }

    public void onOkay(View view) {

        String name = ((EditText)findViewById(R.id.edtPlace)).getText().toString();
        Geocoder coder = new Geocoder(this);
        try {
            List<Address> locations = coder.getFromLocationName(name, 5);

            LatLng loc = new LatLng(locations.get(0).getLatitude(), locations.get(0).getLongitude());
            mMap.addMarker(new MarkerOptions().position(loc));

            CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                    loc, 8);
            mMap.animateCamera(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
