package com.example.izul.gmaps;

import android.content.res.Resources;
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

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition INDONESIA = CameraPosition.builder()
            .target(new LatLng(-6.175392, 106.827178))
            .zoom(17)
            .bearing(295)
            .tilt(90)
            .build();
    static final CameraPosition AUSTRALIA = CameraPosition.builder()
            .target(new LatLng(-33.856820, 151.215279))
            .zoom(16)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions ina, aust;

    @Override
    public Resources getResources() {
        return super.getResources();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aust = new MarkerOptions()
                .position(new LatLng(-33.856820, 151.215279))
                .title("Sydney Opera House")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        ina = new MarkerOptions()
                .position(new LatLng(-6.175392, 106.827178))
                .title("Monumen Nasional")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(ina);
        m_map.addMarker(aust);
        flyTo(SEATTLE);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
