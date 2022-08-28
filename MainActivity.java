package com.example.parkkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
//import  java.util.Timer;
//import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    public static final String TAG="MailActivity";

    private EditText Email;
    public EditText Password;
    private TextView forgotPassword;
    public Button signin,map;
    private TextView NewUser;
   public int counter = 3;
    private TextView Info;

    private FirebaseAuth mAuth;
FirebaseUser user;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.EmailAddress);
        Password = (EditText) findViewById(R.id.Password);
        forgotPassword = (TextView) findViewById(R.id.forgetpswd);
        signin = (Button) findViewById(R.id.btn);
        NewUser = (TextView) findViewById(R.id.textView2);
        Info = (TextView)  findViewById(R.id.textView);
        map = (Button)  findViewById(R.id.Map);

        mAuth=FirebaseAuth.getInstance();

        //add data
        map.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(MainActivity.this,MAp.class);
                startActivity(int1);
            }
        });
        forgotPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText resetMail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link. ");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the mail and reset link
                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MainActivity.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Eroor ! Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();
            }


//                Intent intent = new Intent(MainActivity.this,forgot1.class);
//                startActivity(intent);
            }
        );

        NewUser.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,forgot1.class);
                startActivity(intent);
            }
        });



        Info.setText("no of attempts 3");
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Login();
            }
        });

    }
// Method Create for add Data
    private void Login() {

        String username=Email.getText().toString();
        String Pass=Password.getText().toString();
        String pas=Password.getText().toString();

        if(!username.isEmpty()) {
            Email.setError(null);
            Email.setEnabled(true);
            if (!Pass.isEmpty()) {
                Password.setError(null);
                Password.setEnabled(true);

                mAuth.signInWithEmailAndPassword(username,Pass).addOnCompleteListener(task -> {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    if(user.isEmailVerified()){
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity.this, Mainmenu.class));


                        } else {
                            Toast.makeText(MainActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Email Is not Verifyed ! ", Toast.LENGTH_SHORT).show();
                    }
                });


            } else {
                Password.setError("Enter Password");
            }

        } else {
            Email.setError("Enter Email ID");
        }
//

        }
//                Required Field Condition

//                        myRef.setValue("He ");



//                Reqired Field End

//                validate(Email.getText().toString(), Password.getText().toString());


//    }




    private void validate(String userEmail, String userPassword) {
//        if ((userEmail.equals ("abc@gmail.com")) && (userPassword.equals ("1234"))) {
//            Intent intent = new Intent(MainActivity.this, Mainmenu.class);
//            startActivity(intent);
//        } else {
//            counter--;
//
            Info.setText("No of attempts " +String.valueOf(counter));
            if(counter == 0){
                signin.setEnabled(false);
            }
        }
//    }







}


