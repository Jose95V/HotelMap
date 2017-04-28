package com.example.berenice.proyectohoteles.fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.berenice.proyectohoteles.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Jose Danilo on 06/04/2017.
 */

public class GmapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gmaps, container,false);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        map = googleMap;

        map.getUiSettings().setZoomControlsEnabled(true);

        LatLng marker = new LatLng( 14.4504684 , -87.62989800000003);
        LatLng hotel1 = new LatLng( 14.4610489 , -87.64246579999997);
        LatLng catedral = new LatLng( 14.4602045 , -87.64094490000002);
        LatLng hotel3 = new LatLng( 14.446667531505083 , -87.63346284627914);
        LatLng hotel4 = new LatLng( 14.456540023343491 , -87.63174891471863);
        LatLng hotel5 = new LatLng( 14.450176588950702 , -87.64241874217987);
        LatLng hotel6 = new LatLng( 14.454171288641326 , -87.6426762342453);


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 18));


        googleMap.addMarker(new MarkerOptions().title("Google Maps!").position(marker));
        googleMap.addMarker(new MarkerOptions().title("Hotel Antigua Comayagua").position(hotel1).icon(BitmapDescriptorFactory.fromResource(R.drawable.maphotel)));
        googleMap.addMarker(new MarkerOptions().title("Catedral inmaculada concepcion").position(catedral).icon(BitmapDescriptorFactory.fromResource(R.drawable.iglesia)));
        googleMap.addMarker(new MarkerOptions().title("Hotel Comayagua Colonial").position(hotel3).icon(BitmapDescriptorFactory.fromResource(R.drawable.maphotel)));
        googleMap.addMarker(new MarkerOptions().title("Hotel Suarez").position(hotel4).icon(BitmapDescriptorFactory.fromResource(R.drawable.maphotel)));
        googleMap.addMarker(new MarkerOptions().title("Hotel Posada del Valle").position(hotel5).icon(BitmapDescriptorFactory.fromResource(R.drawable.maphotel)));
        googleMap.addMarker(new MarkerOptions().title("Hotel Santa Teresa").position(hotel6).icon(BitmapDescriptorFactory.fromResource(R.drawable.maphotel)));
    }

}
