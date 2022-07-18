package com.example.pfe_v3final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pfe_v3final.models.CategoryModel;
import com.example.pfe_v3final.models.ProductsModel;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetails extends AppCompatActivity {
        RecyclerView dataList;
    ArrayList<ProductsModel> dataholder8 ;
    private RecyclerView.Adapter adapter ;
    private RecyclerView recyclerViewCategoryList ,recyclerViewShopList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        dataList =findViewById(R.id.recyclerView5);
        LinearLayoutManager c = new LinearLayoutManager(getBaseContext());
        c.setOrientation(RecyclerView.HORIZONTAL);
        dataList.setLayoutManager(c);

        dataholder8 = new ArrayList<>();
        ProductsModel c1 = new ProductsModel(R.drawable.exempleplat,"Poulet Biryani ","Hôtel Ambrosia  \n & Restaurant");
        ProductsModel c2 = new ProductsModel(R.drawable.exempleplat1, "Sauce Tonkatsu","Handi-Restaurant, \n Chittagong");
        ProductsModel c3 = new ProductsModel(R.drawable.exempleplat2,"Poulet Katsu","Hôtel Ambrosia  \n & Restaurant");

        dataholder8.add(c1);
        dataholder8.add(c2);
        dataholder8.add(c3);
        
      //  dataList.setAdapter(new ProductsModel(dataholder8));



    }
}