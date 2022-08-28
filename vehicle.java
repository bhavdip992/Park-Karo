package com.example.parkkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class vehicle extends AppCompatActivity {
public Button Button2;
public EditText num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        Button2= (Button) findViewById(R.id.button2);
        num=(EditText)findViewById(R.id.number);


        Button2.setOnClickListener(new View.OnClickListener() {
            String no=num.getText().toString();
            @Override

            public void onClick(View v) {

                   if(no.matches("(([A-Za-z]){2,3}(|-)([0-9]){1,2}(|-)([A-Za-z]){1,3}(|-)([0-9]){1,4})|(([A-Za-z]){2,3}(|-)([0-9]){1,4})") )
                    {
                        num.setError(null);
                        num.setEnabled(true);
                        dispalyToast();
                    }

                else {
                    num.setError("Enter Vehicle Number Plate");
                }


            }
        });
    }


    public void dispalyToast(){
        Toast.makeText(vehicle.this,"Vehicle is Added",Toast.LENGTH_SHORT).show();
    }

}