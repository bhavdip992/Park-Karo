package com.example.parkkaro;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;
import java.text.BreakIterator;
import java.util.HashMap;

public class forgot1 extends AppCompatActivity {

    private EditText Pname2;
    private EditText EmailAddress2;
    private EditText Phone;
    private EditText Password;
    private TextView text;
//    private RadioGroup radioGroup;
    private RadioButton radioButton,radioButton2;
    private Button btn;
    private Button btn2;
    private Object Button;
    private Object Intent;
    public View View;



    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("User");
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot1);
        Pname2 = (EditText) findViewById(R.id.Pname2);
        EmailAddress2 = (EditText) findViewById(R.id.EmailAddress2);
        Phone = (EditText) findViewById(R.id.Phone);
        Password = (EditText) findViewById(R.id.Password);
        text = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        radioButton= findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);


        mAuth=FirebaseAuth.getInstance();



//


//        if(selectedradioButton!= null){
//            Intent intent = new Intent(forgot1.this,Mainmenu.class);
//            startActivity((android.content.Intent) Intent); }

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    int ID = radioGroup.getCheckedRadioButtonId();
//                    radioButton = findViewById(ID);

//                    String Rusers = Pname2.getText().toString();
//                    String Emails = EmailAddress2.getText().toString();
//                    String Rphones = Phone.getText().toString();
//                    String Passs = Password.getText().toString();

                   CreateUser();
//                    Required Field Condition END
                }
            });

//            Cancel Button
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(forgot1.this, MainActivity.class);
                    startActivity(intent);
                }
            });



        }

    private void CreateUser() {


        String Ruser = Pname2.getText().toString();
        String Email = EmailAddress2.getText().toString();
        String Rphone = Phone.getText().toString();
        String Pass = Password.getText().toString();
        String rad1=radioButton.getText().toString();
        String rad2=radioButton2.getText().toString();
        String member;
        if(radioButton.isChecked())
        {
            member=radioButton.getText().toString();
        }
        else
        {
            member=radioButton2.getText().toString();
        }


//                Required Field Condition
        if (!Ruser.isEmpty() && Ruser.length() >= 3) {
            Pname2.setError(null);
            Pname2.setEnabled(true);

            if (Email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                EmailAddress2.setError(null);
                EmailAddress2.setEnabled(true);

                if (!Rphone.isEmpty() && Rphone.length() == 10) {
                    Phone.setEnabled(true);
                    Phone.setError(null);

                    if (!Pass.isEmpty() && Pass.length() > 6) {
                        Password.setError(null);
                        Password.setEnabled(true);
                        if(!rad1.isEmpty() || rad2.isEmpty())
                        {
                            radioButton.setError(null);
                            radioButton.setEnabled(true);



                        }

//
                      mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if(task.isSuccessful())
                              {
                                  FirebaseUser user = mAuth.getCurrentUser();
                                  user.sendEmailVerification();


                                      if(task.isSuccessful()){

                                          HashMap<String,String> userMap= new HashMap<>();
                                          userMap.put("Name",Ruser);
                                          userMap.put("Email",Email);
                                          userMap.put("Phone No",Rphone);
                                          userMap.put("Password",Pass);
                                          userMap.put("Gender",member);






                                          myRef.child(user.getUid()).setValue(userMap);
//                                          myRef.setValue(Ruser);
//                                          myRef.setValue(Email);
//                                          myRef.setValue(Rphone);
//                                          myRef.setValue(Pass);

                                          Toast.makeText(forgot1.this,"Register Successful",Toast.LENGTH_LONG).show();
//                                          startActivity(new Intent(forgot1.this,Mainmenu.class));



                                          Intent i = new Intent(getApplicationContext(),Mainmenu.class);
                                          startActivity(i);
                                      }else
                                      {
                                          Toast.makeText(forgot1.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                      }



                              }
                              else {
                                  Toast.makeText(forgot1.this,"Error"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                              }
                          }

                          private void addOnCompleteListener(OnCompleteListener<Void> register_successful) {
                          }
                      });
                        Intent intent = new Intent(forgot1.this, Mainmenu.class);
                        startActivity(intent);

                    } else {
                        Password.setError("Enter Password");
                    }
                } else {
                    Phone.setError("Enter Phone Number");
                }
            } else {
                EmailAddress2.setError("Enter Correct Email ID");
            }
        } else {
            Pname2.setError("Enter Name");
        }
//                    Required Field Condition END
    }

}











