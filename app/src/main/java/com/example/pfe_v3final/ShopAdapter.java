package com.example.pfe_v3final;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfe_v3final.models.CategoryModel;
import com.example.pfe_v3final.models.ShopModel;

import java.util.ArrayList;

public class ShopAdapter extends  RecyclerView.Adapter<ShopAdapter.myviewholder1>{
    ArrayList<ShopModel>shopModels;
    private static final String TAG = "TasksSample";
    public ShopAdapter(ArrayList<ShopModel> shopModels) {
        this.shopModels = shopModels;
    }

    @NonNull
    @Override
    public myviewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_row_disgn,parent,false);
        return new myviewholder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder1 holder, int position) {
        holder.img.setImageResource(shopModels.get(position).getImage());
        holder.name.setText(shopModels.get(position).getName());
        holder.adresse.setText(shopModels.get(position).getAdresse());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: "+shopModels.get(position).getName());
                Intent intent=new Intent(v.getContext(),RestaurantDetails.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopModels.size();
    }

    class myviewholder1 extends RecyclerView.ViewHolder {
        ImageView img ;
        TextView name, adresse ;
        Button button;

        public myviewholder1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView4);
            name = itemView.findViewById(R.id.textView2);
            adresse = itemView.findViewById(R.id.textView5);
            button = itemView.findViewById(R.id.button3);
        }
    }

}
