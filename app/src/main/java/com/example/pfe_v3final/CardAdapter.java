package com.example.pfe_v3final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfe_v3final.models.CardModel;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter <CardAdapter.myviewholder3> {
    ArrayList<CardModel>dataholder3;

    public CardAdapter(ArrayList<CardModel> dataholder3) {
        this.dataholder3 = dataholder3;
    }

    @NonNull
    @Override
    public myviewholder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row_disgn,parent,false);
      return new myviewholder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder3 holder, int position) {
            holder.img.setImageResource(dataholder3.get(position).getImage());
            holder.name.setText(dataholder3.get(position).getName());
            holder.speciality.setText(dataholder3.get(position).getSpeciality());
            holder.price.setText(dataholder3.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return dataholder3.size();
    }

    class myviewholder3 extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,speciality,price;



        public myviewholder3(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imagecar1);
            name = itemView.findViewById(R.id.name1);
            speciality = itemView.findViewById(R.id.sepeciality1);
            price = itemView.findViewById(R.id.price1);

        }
    }
}
