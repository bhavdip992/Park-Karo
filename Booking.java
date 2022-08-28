package com.example.parkkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

public class Booking extends AppCompatActivity implements View.OnClickListener {
    public RadioButton r1,r2;
    public Button btn;
    public EditText selectdate;
    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        r1 = findViewById(R.id.rb1);
        r2 = findViewById(R.id.rb2);
        btn = findViewById(R.id.Confirm);

        selectdate = findViewById(R.id.edtdate);

        selectdate.setOnClickListener ( this );


        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String date= selectdate.getText().toString();
                String gender;
                if (date.isEmpty())
                {
                    selectdate.setError("Enter Date");
                }
                else {
                    if (r1.isChecked()) {
                        gender = r1.getText().toString();
                    } else {
                        gender = r2.getText().toString();
                    }
                    Intent intent = new Intent(getApplicationContext(), payment.class);
                    startActivity(intent);
                }
            }





        });
    }
    @Override
    public void onClick(View v) {
        if (v == selectdate) {
            final Calendar calendar = Calendar.getInstance ();
            mYear = calendar.get ( Calendar.YEAR );
            mMonth = calendar.get ( Calendar.MONTH );
            mDay = calendar.get ( Calendar.DAY_OF_MONTH );

            //show dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog ( this, new DatePickerDialog.OnDateSetListener () {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    selectdate.setText ( dayOfMonth + "/" + (month + 1) + "/" + year );
                }
            }, mYear, mMonth, mDay );
            datePickerDialog.show ();
        }
    }



}