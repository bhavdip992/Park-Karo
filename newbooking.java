package com.example.parkkaro;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;



public class newbooking extends AppCompatActivity {


     private   EditText search;
    private Button bhva,ahmd,surat1,Anan,rajk,vadod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbooking);


        bhva = (Button) findViewById(R.id.bhavnagar);
        surat1 = (Button) findViewById(R.id.Surat);
       ahmd = (Button) findViewById(R.id.Ahmedabad);
       rajk = (Button) findViewById(R.id.Rajkot);
       Anan = (Button) findViewById(R.id.Anand);
       vadod= (Button) findViewById(R.id.Vadodara);

        bhva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                    Intent int6 = new Intent(newbooking.this, MAp.class);
//                    startActivity(int6);
            }
        });

        surat1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent int6 = new Intent(newbooking.this, MAp.class);
                    startActivity(int6);
                }
        });

        ahmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(newbooking.this, MAp.class);
                startActivity(int6);
            }
        });

        rajk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(newbooking.this, MAp.class);
                startActivity(int6);
            }
        });

        Anan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(newbooking.this, MAp.class);
                startActivity(int6);
            }
        });

        vadod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(newbooking.this, MAp.class);
                startActivity(int6);
            }
        });

    }




}
