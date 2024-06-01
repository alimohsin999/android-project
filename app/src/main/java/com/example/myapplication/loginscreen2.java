package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class loginscreen2 extends AppCompatActivity {
Button button;
    TextInputLayout emaillayout,passwordlayout;
    TextInputEditText emailEdittext,passwordEdittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loginscreen2);

        String email =emailEdittext.getText().toString().trim();


        String password = passwordEdittext.getText().toString().trim();




        emaillayout.setError(null);

        passwordlayout.setError(null);

        boolean isValid = true;




        if (email.isEmpty()) {
            emaillayout.setError("Please enter your email address");
            isValid = false;
        }




        if (password.isEmpty()) {
            passwordlayout.setError("Please enter a password");
            isValid = false;
        }


               /* String error = validatePassword(signuppassword);
                if(!error.isEmpty()) {
                    System.out.println("Password Validation Failed");
                    System.out.println(error);
                    isValid = false;
                }*/


        button = (Button)findViewById(R.id.button);
        emaillayout = (TextInputLayout) findViewById(R.id.emaillayout);
        passwordlayout = (TextInputLayout)findViewById(R.id.passwordlayout);
        passwordEdittext= (TextInputEditText)findViewById(R.id.passwordEdittext);
        emailEdittext = (TextInputEditText)findViewById(R.id.emailEdittext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(loginscreen2.this,home_page.class);
                startActivity(intent);
            }
        });




    }
}


