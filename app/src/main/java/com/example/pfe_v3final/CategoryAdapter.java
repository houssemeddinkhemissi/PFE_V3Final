package com.example.pfe_v3final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfe_v3final.models.CategoryModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.myviewHolder>{
    ArrayList<CategoryModel>categoryModel;

    public CategoryAdapter(ArrayList<CategoryModel> categoryModel) {
        this.categoryModel = categoryModel;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row_disgn,parent,false);
            return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
            holder.img.setImageResource(categoryModel.get(position).getImage());
            holder.distance.setText(categoryModel.get(position).getDistance());
            holder.time.setText(categoryModel.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return categoryModel.size();
    }

    class myviewHolder extends RecyclerView.ViewHolder{
        ImageView img ;
        TextView distance,time;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.categoryimage);
            distance=itemView.findViewById(R.id.distance);
            time=itemView.findViewById(R.id.time);


        }
    }

}
