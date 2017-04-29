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
        LatLng caxa = new LatLng( 14.4610287 , -87.64013669999997);
        LatLng villa = new LatLng( 14.4194658 , -87.61604119999998);
        LatLng museo = new LatLng( 14.4618588 , -87.6416178);
        LatLng plaza = new LatLng( 14.4572525 , -87.64011440000002);
        LatLng gaso = new LatLng( 14.4498032 , -87.64297440000001);
        LatLng pizza = new LatLng( 14.4460238 , -87.63899529999998);
        LatLng burguer = new LatLng( 14.4453436 , -87.63758469999999);
        LatLng museoC = new LatLng( 14.45944896124414 ,-87.64010667800903);
        LatLng corral = new LatLng( 14.4521101 ,-87.63953620000001);


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 18));


        googleMap.addMarker(new MarkerOptions().title("Google Maps!").position(marker));
        googleMap.addMarker(new MarkerOptions().title("Hotel Antigua Comayagua").position(hotel1).icon(BitmapDescriptorFactory.fromResource(R.drawable.maphotel)));
        googleMap.addMarker(new MarkerOptions().title("Catedral inmaculada concepcion").position(catedral).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Caxa Real").position(caxa).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Villa Mark Park").position(villa).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Museo Arqueologico").position(museo).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Plaza la Merced").position(plaza).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Gasolinera Texaco").position(gaso).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Pizza Hut").position(pizza).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Burguer King").position(burguer).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Museo Casa Cabañas").position(museoC).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));
        googleMap.addMarker(new MarkerOptions().title("Supermercados del corral").position(corral).icon(BitmapDescriptorFactory.fromResource(R.drawable.turis)));

    }
}
