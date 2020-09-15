package com.songjumin.moviereviewapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.songjumin.moviereviewapp.R;
import com.songjumin.moviereviewapp.model.Movie;
import com.songjumin.moviereviewapp.util.Util;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Movie> movieArrayList;

    public RecyclerViewAdapter (Context context, ArrayList<Movie> movieArrayList) {

        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);
        String poster_path = movie.getPoster_path();
        Log.i("aaa",poster_path);
        Glide.with(context)
                .load(Util.BASE_IMAGE_URL + poster_path)
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return this.movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
        }
    }

}
