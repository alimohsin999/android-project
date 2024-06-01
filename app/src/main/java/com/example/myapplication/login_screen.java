package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class login_screen extends AppCompatActivity {
Button button;
TextInputLayout usernamelayout,emaillayout,numberlayout,passwordlayout,confirmlayout;
TextInputEditText usernameEdittext,emailEdittext,numberEdittext,passwordEdittext,confirmEdittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_screen);

        button = (Button)findViewById(R.id.button2);
        usernamelayout =(TextInputLayout) findViewById(R.id.usernamelayout);
        emaillayout = (TextInputLayout)findViewById(R.id.emaillayout);
        numberlayout = (TextInputLayout)findViewById(R.id.numberlayout);
        passwordlayout = (TextInputLayout)findViewById(R.id.passwordlayout);
        confirmlayout = (TextInputLayout)findViewById(R.id.confirmlayout);
        usernameEdittext = (TextInputEditText)findViewById(R.id.usernameEdittext);
        emailEdittext = (TextInputEditText)findViewById(R.id.emailEdittext);
        numberEdittext =(TextInputEditText)findViewById((R.id.emailEdittext));
        passwordEdittext = (TextInputEditText)findViewById(R.id.passwordEdittext);
        confirmEdittext = (TextInputEditText)findViewById(R.id.confirmEdittext);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String username = usernameEdittext.getText().toString().trim();
        String email =emailEdittext.getText().toString().trim();

        String Number = numberEdittext.getText().toString().trim();
        String password = passwordEdittext.getText().toString().trim();
        String confirmPassword = confirmEdittext.getText().toString().trim();

        usernamelayout.setError(null);
        emaillayout.setError(null);
        numberlayout.setError(null);
        passwordlayout.setError(null);
        confirmlayout.setError(null);
        boolean isValid = true;

        if (username.isEmpty()) {
            usernamelayout.setError("Please enter your last name");
            isValid = false;
        }

        if (email.isEmpty()) {
            emaillayout.setError("Please enter your email address");
            isValid = false;
        }
        if(!isValidEmail(email)){
            emaillayout.setError("Enter valid email address");
            isValid = false;
        }
        if (Number.isEmpty()) {
            numberlayout.setError("Please enter your Phone Number");
            isValid = false;
        }
        if (password.isEmpty()) {
            passwordlayout.setError("Please enter a password");
            isValid = false;
        }
        if(confirmPassword.length() < 8){
            confirmlayout.setError("Use 8 characters or more for your password");
            isValid = false;
        }
        if(!isValidPassword(password)){
            passwordlayout.setError("Password must have at least one uppercase letter, one lowercase letter, one digit, and one special character");
            isValid = false;
        }

               /* String error = validatePassword(signuppassword);
                if(!error.isEmpty()) {
                    System.out.println("Password Validation Failed");
                    System.out.println(error);
                    isValid = false;
                }*/
        if (confirmPassword.isEmpty()) {
            confirmlayout.setError("Please confirm your password");
            isValid = false;
        }
        if(!passwordlayout.equals(confirmPassword)){
            confirmlayout.setError("Passwords do not match");
            isValid = false;
        }


    }
     Intent intent = new Intent(login_screen.this,register.class);

});

        }

    private boolean containsInteger(String str){
        for (char c : str.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
    private boolean isValidEmail(String email){
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void togglePasswordVisibility(TextInputEditText passwordEditText, ImageView toggleIcon) {
        if (passwordEditText.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            toggleIcon.setImageResource(R.drawable.ic_visibility); // Replace with your "visible" icon
        } else {
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            toggleIcon.setImageResource(R.drawable.ic_visibility_off); // Replace with your "invisible" icon
        }
        // Move the cursor to the end of the text
        passwordEditText.setSelection(passwordEditText.getText().length());
    }

    private boolean isValidPassword(String password) {
        // Password must have at least 8 characters, including one uppercase letter, one lowercase letter, one digit, and one special character
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    }
