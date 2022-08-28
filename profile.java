package com.example.parkkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class profile extends AppCompatActivity {

    ListView sellerlistview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<User> sellerArrayList;
    User user;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
        sellerlistview = findViewById(R.id.retriveddata_user);
        sellerArrayList = new ArrayList<>();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        getData();


    }
    private void getData() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        user = new User(
                                dataSnapshot.child("username").getValue().toString(),
                                dataSnapshot.child("emailaddress").getValue().toString(),
                                dataSnapshot.child("password").getValue().toString(),
                                dataSnapshot.child("uphoneno").getValue().toString(),
                                dataSnapshot.child("gender").getValue().toString());
                    }
                    sellerArrayList.add(user);

                    //  Log.v("DS","listsize"+contributorArrayList.size());

                    UserProfileAdapter userProfileAdapter = new UserProfileAdapter(profile.this,
                            sellerArrayList);
                    sellerlistview.setAdapter(userProfileAdapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"not work",Toast.LENGTH_LONG).show();
            }
        });

    }
}