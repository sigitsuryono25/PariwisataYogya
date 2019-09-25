package com.project.lauwba.pariwisatayogya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GaleriAdapter extends RecyclerView.Adapter<GaleriAdapter.ViewHolder> {

    String[] gambar;
    Context context;

    public GaleriAdapter(String[] gambar, Context context) {
        this.gambar = gambar;
        this.context = context;
    }

    @NonNull
    @Override
    public GaleriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.activity_galeri_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GaleriAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(gambar[position]).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.gambar);
        }
    }
}
