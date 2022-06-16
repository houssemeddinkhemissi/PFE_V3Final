package com.example.pfe_v3final;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pfe_v3final.models.CategoryModel;
import com.example.pfe_v3final.models.ShopModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView.Adapter adapter ;
    private RecyclerView recyclerViewCategoryList ,recyclerViewShopList ;
    ArrayList<CategoryModel> dataholder1 ;
    ArrayList<ShopModel> dataholder2 ;
    ImageSlider imageSlider;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewCategoryList=view.findViewById(R.id.recyclerView3);
        LinearLayoutManager c = new LinearLayoutManager(getContext());
        c.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewCategoryList.setLayoutManager(c);

        dataholder1 = new ArrayList<>();
        CategoryModel c1 = new CategoryModel(R.drawable.exempleplat,"Poulet Biryani ","Hôtel Ambrosia  \n & Restaurant");
        CategoryModel c2 = new CategoryModel(R.drawable.exempleplat1, "Sauce Tonkatsu","Handi-Restaurant, \n Chittagong");
        CategoryModel c3 = new CategoryModel(R.drawable.exempleplat2,"Poulet Katsu","Hôtel Ambrosia  \n & Restaurant");
        CategoryModel c4 = new CategoryModel(R.drawable.exempleplat,"12km","12min");
        CategoryModel c5 = new CategoryModel(R.drawable.exempleplat,"50km","30min");
        dataholder1.add(c1);
        dataholder1.add(c2);
        dataholder1.add(c3);
        dataholder1.add(c4);
        dataholder1.add(c5);
        recyclerViewCategoryList.setAdapter(new CategoryAdapter(dataholder1));

        recyclerViewShopList=view.findViewById(R.id.recyclerView1);
        LinearLayoutManager t = new LinearLayoutManager(getContext());
        t.setOrientation(RecyclerView.VERTICAL);
        recyclerViewShopList.setLayoutManager(t);

        dataholder2 = new ArrayList<>();
        ShopModel s1 = new ShopModel(R.drawable.exmepleresto,"Ambroisie Hôtel & Restaurant","kazi Deiry, col du \n Taiger Chittagong");
        ShopModel s2 = new ShopModel(R.drawable.exmepleresto1,"Restaurant Tava"," Surson Rue, \n Chittagong");
        ShopModel s3 = new ShopModel(R.drawable.exmepleresto,"10km","10min");
        ShopModel s4 = new ShopModel(R.drawable.exmepleresto,"12km","12min");
        ShopModel s5 = new ShopModel(R.drawable.exmepleresto,"50km","30min");
        dataholder2.add(s1);
        dataholder2.add(s2);
        dataholder2.add(s3);
        dataholder2.add(s4);
        dataholder2.add(s5);
        recyclerViewShopList.setAdapter(new ShopAdapter(dataholder2));

        imageSlider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imagelist = new ArrayList<>();
        imagelist.add(new SlideModel(R.drawable.testpub2,null));
        imagelist.add(new SlideModel(R.drawable.testpub1,null));
        imageSlider.setImageList(imagelist);

        return view;


    }


}