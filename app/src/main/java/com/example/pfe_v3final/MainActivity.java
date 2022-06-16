package com.example.pfe_v3final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        navigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nac_home);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null ;
                switch (item.getItemId()){
                    case R.id.nac_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nac_like:
                        fragment = new ProductsFragment();
                        break;
                    case R.id.nac_seach:
                        fragment = new AccountFragment();
                        break;
                    case R.id.nac_shop:
                        fragment = new WishListFragment ();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();
                return true;
            }
        });
    }
}