package com.example.izul.gmaps;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {




    static final CameraPosition INDONESIA = CameraPosition.builder()
            .target(new LatLng(-6.175392, 106.827178))
            .zoom(5)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    LatLng IND = new LatLng(-6.175392, 106.827178);
    LatLng FRC = new LatLng(48.858270, 2.294509);
    LatLng USA = new LatLng(38.897678, -77.036477);
    LatLng AUS = new LatLng(-33.856820, 151.215279);
    MarkerOptions Indonesia, France, UnitedState, Australia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Indonesia = new MarkerOptions()
                .position(new LatLng(-6.175392, 106.827178))
                .title("Monumen Nasional")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        France = new MarkerOptions()
                .position(new LatLng(48.858270, 2.294509))
                .title("Eiffel Tower")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        UnitedState = new MarkerOptions()
                .position(new LatLng(38.897678, -77.036477))
                .title("The White House")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        Australia = new MarkerOptions()
                .position(new LatLng(-33.856820, 151.215279))
                .title("Sydney Opera House")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        map.moveCamera(CameraUpdateFactory.newCameraPosition(INDONESIA));
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(IND)
                .add(AUS)
                .add(FRC)
                .add(USA));
        m_map.addMarker(Indonesia);
        m_map.addMarker(France);
        m_map.addMarker(UnitedState);
        m_map.addMarker(Australia);
    }

}
