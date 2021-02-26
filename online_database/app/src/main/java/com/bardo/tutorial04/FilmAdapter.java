package com.bardo.tutorial04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bardo.tutorial04.model.ResultsItem;
import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    public static final String DATA_MOVIE = "datamovie";
    public static final String DATA_EXTRA = "dataextra";
    private Context context;
    private List<ResultsItem> data = new ArrayList<>();

    public FilmAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.per_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvJudulFilm.setText(data.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + data.get(position).getPosterPath()).into(holder.ivGambarFilm);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, DetailMovieActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(DATA_MOVIE, Parcels.wrap(data.get(position)));
                pindah.putExtra(DATA_EXTRA, bundle);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudulFilm;
        ImageView ivGambarFilm;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudulFilm = itemView.findViewById(R.id.judulFilm);
            ivGambarFilm = itemView.findViewById(R.id.gambarFilm);
        }
    }
}
