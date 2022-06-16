package com.example.pfe_v3final;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pfe_v3final.models.ProductsModel;

import java.util.List;

public class ProductsAdapter extends BaseAdapter {


    private static final String TAG = "Populate";
    private List<ProductsModel>productsModels;
    private List<ProductsModel>productsModelsFilltred;
    private Context context;
    LayoutInflater inflater;


    public ProductsAdapter(List<ProductsModel> productsModels, Context context) {
        this.productsModels = productsModels;
        this.productsModelsFilltred = productsModels;
        Log.d(TAG, "ProductsAdapter: "+productsModelsFilltred.size());
        this.context = context;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {

        return productsModelsFilltred.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView = inflater.inflate(R.layout.grid_item_products, null);
        TextView name = (TextView) convertView.findViewById(R.id.textView27);
        TextView price = (TextView)  convertView.findViewById(R.id.textView28);
        ImageView imgview = (ImageView) convertView.findViewById(R.id.imageView3);

        imgview.setImageResource(productsModelsFilltred.get(position).getImage());
        name.setText(productsModelsFilltred.get(position).getName());
        price.setText(productsModelsFilltred.get(position).getPrice());

        return convertView;

    }
}
