package com.example.parkkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;



public class payment extends AppCompatActivity implements PaymentResultListener {
    // variables for our
    // edit text and button.
    private EditText amountEdt;
    private Button payBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        amountEdt = findViewById(R.id.idEdtAmount);
        payBtn = findViewById(R.id.idBtnPay);

        // adding on click listener to our button.
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount that is entered by user.
                String samount = amountEdt.getText().toString();

                // rounding off the amount.
                int amount = Math.round(Float.parseFloat(samount) * 100);

                // initialize Razorpay account.
                Checkout checkout = new Checkout();

                // set your id as below
                checkout.setKeyID("rzp_test_fdXDw7M2Xj5Sxq");

                // set image
                checkout.setImage(R.drawable.dh);

                // initialize json object
                JSONObject object = new JSONObject();
                try {
                    // to put name
                    object.put("name", "Park Karo");

                    // put description
                    object.put("description", "Test payment");

                    // to set theme color
                    object.put("theme.color", "color");

                    // put the currency
                    object.put("currency", "INR");

                    // put amount
                    object.put("amount", amount);

                    // put mobile number
                    object.put("prefill.contact", "7048525286");

                    // put email
                    object.put("prefill.email", "bhavdeep992@gmail.com");

                    // open razorpay to checkout activity
                    checkout.open(payment.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    @Override
    public void onPaymentSuccess(String s) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }

}