package com.justanotherproject.botischile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {

    MapView mapView;
    GoogleMap map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_layout, container, false);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setMyLocationEnabled(true);

        //Add a marker
        map.addMarker(new MarkerOptions().position(
                new LatLng(-33.4556327, -70.655571)).icon(
                BitmapDescriptorFactory.defaultMarker()));


        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
            MapsInitializer.initialize(this.getActivity());




        //Starting position
        map.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-33.4556327,-70.655571) , 12) );

        //Move the camera to a determinate position
        // Updates the location and zoom of the MapView
        //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(-33.4556327, -70.655571), 12);
       // map.animateCamera(cameraUpdate);

        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}