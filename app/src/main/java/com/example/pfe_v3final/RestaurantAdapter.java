package com.example.pfe_v3final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfe_v3final.models.ProductsModel;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.myviewholder4> {
    private List<ProductsModel> productsModels;
    LayoutInflater inflater;

    public RestaurantAdapter(List<ProductsModel> productsModels) {
        this.productsModels = productsModels;

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
