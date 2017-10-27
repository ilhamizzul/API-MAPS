package com.example.izul.gmaps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {




    static final CameraPosition INDONESIA = CameraPosition.builder()
            .target(new LatLng(-6.967854, 107.583750))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    LatLng IND = new LatLng(-6.967854, 107.583750);
    MarkerOptions Indonesia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Indonesia = new MarkerOptions()
                .position(new LatLng(-6.967854, 107.583750))
                .title("Perumahan")
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
        map.addCircle(new CircleOptions()
                .center(IND)
                .radius(500)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 0)));
        m_map.addMarker(Indonesia);
    }

}
