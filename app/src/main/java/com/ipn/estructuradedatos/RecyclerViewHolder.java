package com.ipn.estructuradedatos;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewHolder extends RecyclerView.Adapter<RecyclerViewHolder.ViewHolder>
{
    protected static class ViewHolder extends RecyclerView.ViewHolder
    {
        protected final CardView cardView;
        protected final TextView textView;
        protected final TextView textViewAddress;
        protected final ImageView imageView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.textViewTitle);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    private final LayoutInflater layoutInflater;
    private final List<LocationData> locationDataList;
    private final OnClick onClick;

    public RecyclerViewHolder(LayoutInflater layoutInflater, List<LocationData> locationDataList, OnClick onClick)
    {
        this.layoutInflater = layoutInflater;
        this.locationDataList = locationDataList;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public RecyclerViewHolder.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder.ViewHolder holder, int position)
    {
        holder.textView.setText(locationDataList.get(holder.getAdapterPosition()).getName()); //Titulo
        holder.textViewAddress.setText(locationDataList.get(holder.getAdapterPosition()).getAddress()); //Direccion
        holder.imageView.setImageResource(locationDataList.get(holder.getAdapterPosition()).getImageH()); //Imagen
        holder.cardView.setOnClickListener(v -> onClick.click(locationDataList.get(holder.getAdapterPosition()))); //CardView
    }

    @Override
    public int getItemCount() {
        return locationDataList.size();
    }

    public interface OnClick {
        public void click(LocationData locationData);
    }
}
