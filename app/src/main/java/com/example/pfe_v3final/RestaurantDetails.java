package com.example.pfe_v3final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pfe_v3final.models.CategoryModel;
import com.example.pfe_v3final.models.ProductsModel;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetails extends AppCompatActivity {
        RecyclerView dataList;
    ArrayList<ProductsModel> dataholder5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        dataList = findViewById(R.id.recyclerView5);
        dataholder5 = new ArrayList<>();
        ProductsModel c1 = new ProductsModel(R.drawable.exempleplat,"Poulet Biryani ","Hôtel Ambrosia  \n & Restaurant");
        ProductsModel c2 = new ProductsModel(R.drawable.exempleplat1, "Sauce Tonkatsu","Handi-Restaurant, \n Chittagong");
        ProductsModel c3 = new ProductsModel(R.drawable.exempleplat2,"Poulet Katsu","Hôtel Ambrosia  \n & Restaurant");
        ProductsModel c4 = new ProductsModel(R.drawable.exempleplat,"12km","12min");
        ProductsModel c5 = new ProductsModel(R.drawable.exempleplat,"50km","30min");
        dataholder5.add(c1);
        dataholder5.add(c2);
        dataholder5.add(c3);
        dataholder5.add(c4);
        dataholder5.add(c5);


    }
}