package com.example.parkkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Mainmenu extends AppCompatActivity {
     private Button NEWBOOKING;
     private Button VIEWBOOKING;
     private Button ADDVEHICLE;
     private Button PROFILE;
     private Button LOGOUT;
     FirebaseAuth mAuth;

    public FirebaseUser Muser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        NEWBOOKING=(Button) findViewById(R.id.btn3);
        VIEWBOOKING=(Button) findViewById(R.id.btn4);
        PROFILE=(Button) findViewById(R.id.btn5);
        ADDVEHICLE=(Button) findViewById(R.id.button);
        LOGOUT=(Button) findViewById(R.id.btn2);
        mAuth=FirebaseAuth.getInstance();

        NEWBOOKING.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainmenu.this,newbooking.class);
                startActivity(intent);
            }
        });
        VIEWBOOKING.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Mainmenu.this,MAp.class);
                startActivity(int1);
            }
        });

        PROFILE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3=new Intent(Mainmenu.this,profile.class);
                startActivity(int3);
            }
        }) ;

        ADDVEHICLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5=new Intent(Mainmenu.this,vehicle.class);
                startActivity(int5);
            }
        });

        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent int4=new Intent(Mainmenu.this,MainActivity.class);
                startActivity(int4);
                Toast.makeText(Mainmenu.this,"Logout Successful",Toast.LENGTH_LONG).show();


            }
        }) ;

    }
    public void onstart() {
        super.onStart();
        Muser = mAuth.getCurrentUser();
        if (Muser == null) {
            startActivity(new Intent(Mainmenu.this,MainActivity.class));
        }
    }
}