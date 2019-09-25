package com.project.lauwba.pariwisatayogya;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GaleriWisata extends Fragment {
    RecyclerView rc;
    String[] gambar = {
            "https://www.pikniek.com/wp-content/uploads/2017/10/000015-00_wisata-candi-prambanan_kompleks-candi_800x450_cc0-min.jpg",
            "http://spotunik.com/assets/images/spots/tugu-jogja-20160620160402.jpg",
            "http://cdn-2.tstatic.net/tribunnews/foto/bank/images/pemandangan-candi-ijo2_20150519_174558.jpg",
            "https://www.yogyes.com/en/yogyakarta-tourism-object/candi/ijo/1.jpg"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_galeri_wisata, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc = view.findViewById(R.id.rv);
        rc.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new GridLayoutManager(getContext(), 2);
        rc.setLayoutManager(lm);

        GaleriAdapter galeri = new GaleriAdapter(gambar, getContext());
        rc.setAdapter(galeri);
    }
}
