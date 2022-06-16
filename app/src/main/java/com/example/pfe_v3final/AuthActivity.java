package com.example.pfe_v3final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView usernema =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);
        TextView signup =(TextView) findViewById(R.id.others);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.logibtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent();
                Intent intent1 = new Intent(AuthActivity.this,RegiActivity.class);
                startActivity(intent1);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // if (usernema.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                  //  Toast.makeText(AuthActivity.this,"Login SUCCESSFUL",Toast.LENGTH_LONG);
                   // Log.d("Sucess","Right");
               // }else {
                  //  Toast.makeText(AuthActivity.this,"Login FAILD",Toast.LENGTH_LONG);
                   // Log.d("Failed","NotRight");
                //}
                Intent i = new Intent();
                Intent intent = new Intent(AuthActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}