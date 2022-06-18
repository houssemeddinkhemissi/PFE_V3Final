package com.example.pfe_v3final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfe_v3final.models.ProductsModel;

import java.util.List;
import java.util.zip.Inflater;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.myviewholder4> {
    private List<ProductsModel> productsModels;
    LayoutInflater inflater;
    Context context;


    public RestaurantAdapter(List<ProductsModel> productsModels, LayoutInflater inflater, Context context) {
        this.productsModels = productsModels;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public myviewholder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_item_products,parent,false);

        return new myviewholder4(view);


    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder4 holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class myviewholder4 extends RecyclerView.ViewHolder{

        public myviewholder4(@NonNull View itemView) {
            super(itemView);
        }
    }
}
