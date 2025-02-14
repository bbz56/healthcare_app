package com.example.healthcare; // Ensure this matches your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginbtn);
        TextView forgotPasswordText = findViewById(R.id.frogotpass);
        Button btnRegister = findViewById(R.id.btnRegister);
        ImageView fbButton = findViewById(R.id.fb);
        ImageView twitterButton = findViewById(R.id.twitter);
        ImageView googleButton = findViewById(R.id.google);



        loginBtn.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
            } else {

                if (username.equals("Chamindu") && password.equals("2000")) {
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(MainActivity.this, home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPasswordText.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Redirecting to password recovery", Toast.LENGTH_SHORT).show();

        });

        btnRegister.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Register button clicked", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        fbButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Logging in with Facebook", Toast.LENGTH_SHORT).show();

        });

        twitterButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Logging in with Twitter", Toast.LENGTH_SHORT).show();

        });

        googleButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Logging in with Google", Toast.LENGTH_SHORT).show();

        });
    }
}
