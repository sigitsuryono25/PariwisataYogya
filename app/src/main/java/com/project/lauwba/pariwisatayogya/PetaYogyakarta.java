package com.project.lauwba.pariwisatayogya;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PetaYogyakarta extends Fragment implements OnMapReadyCallback, View.OnClickListener {


    GoogleMap map;
    Button normal, satelit, hybrid, terrain;
    SupportMapFragment mp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_peta_yogyakarta, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mp = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);
        mp.getMapAsync(this);

        normal = view.findViewById(R.id.normal);
        satelit = view.findViewById(R.id.satelit);
        hybrid = view.findViewById(R.id.hybrid);
        terrain = view.findViewById(R.id.terrain);

        normal.setOnClickListener(this);
        satelit.setOnClickListener(this);
        hybrid.setOnClickListener(this);
        terrain.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng candi_prambanan = new LatLng(-7.7520206, 110.4892787);
        LatLng tugu_jogja = new LatLng(-7.7828893, 110.3648875);

        map.addMarker(new MarkerOptions().position(candi_prambanan).title("Candi Prambanan"));
        map.addMarker(new MarkerOptions().position(tugu_jogja).title("Tugu Jogja"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(candi_prambanan, 5));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normal:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.satelit:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.hybrid:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.terrain:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
    }
}
