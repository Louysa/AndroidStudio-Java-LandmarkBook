package com.dogan.javamaps.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dogan.javamaps.databinding.RecyclerRowBinding;
import com.dogan.javamaps.model.Place;
import com.dogan.javamaps.view.MapsActivity;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {

    List<Place> placeList;
    public PlaceAdapter(List<Place> placeList){
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlaceHolder(recyclerRowBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.PlaceHolder holder, int position) {
        int a = holder.getAdapterPosition();

        holder.recyclerRowBinding.recyclerViewTextView.setText(placeList.get(a).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);
                intent.putExtra("info","old");
                intent.putExtra("place",placeList.get(a));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }


    public class PlaceHolder extends RecyclerView.ViewHolder{
    RecyclerRowBinding recyclerRowBinding;
        public PlaceHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
