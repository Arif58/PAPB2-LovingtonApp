package com.example.lovingtonapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    List<ProductItem> data;
    Activity activity;

    public ProductAdapter(List<ProductItem> data, Activity activity){
        this.data = data;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView productName, description;

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.desc);
            imageView = itemView.findViewById(R.id.photo_url);

        }

        public void bind(ProductItem ProductItem) {
            productName.setText(ProductItem.product_name);
            description.setText(ProductItem.desc);

            Glide.with(activity).load(ProductItem.getPhoto_url()).into(imageView);

        }
    }
}
