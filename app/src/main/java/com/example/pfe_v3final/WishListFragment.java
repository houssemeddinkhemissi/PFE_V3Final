package com.example.pfe_v3final;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.pfe_v3final.models.CardModel;
import com.example.pfe_v3final.models.CategoryModel;
import com.example.pfe_v3final.models.ShopModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WishListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WishListFragment extends Fragment {
    private RecyclerView  recyclerViewCardList ;
    ArrayList<CardModel> dataholder3 ;
    private ScrollView v1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WishListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WishListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WishListFragment newInstance(String param1, String param2) {
        WishListFragment fragment = new WishListFragment();
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
        View view =  inflater.inflate(R.layout.fragment_wish_list, container, false);

        recyclerViewCardList=view.findViewById(R.id.recyclerView3);
        LinearLayoutManager t = new LinearLayoutManager(getContext());
        t.setOrientation(RecyclerView.VERTICAL);
        recyclerViewCardList.setLayoutManager(t);

        dataholder3 = new ArrayList<>();
        CardModel s1 = new CardModel(R.drawable.testfood1,"Crabe frais spacieux","Kita Waroenk","€ 65");
        CardModel s2 = new CardModel(R.drawable.testfood2,"Les Penne Rigate","Italiennes ","€ 35");
        CardModel s3 = new CardModel(R.drawable.testfood3,"Sandwich Libanais ","libanaise","€ 20");

        dataholder3.add(s1);
        dataholder3.add(s2);
        dataholder3.add(s3);

        recyclerViewCardList.setAdapter(new CardAdapter(dataholder3));
        return view;
    }
}