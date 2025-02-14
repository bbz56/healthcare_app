package com.example.healthcare_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



            EditText usernameEditText = findViewById(R.id.username);
            EditText emailEditText = findViewById(R.id.email);
            EditText passwordEditText = findViewById(R.id.password);
            EditText password2EditText = findViewById(R.id.password2);
            Button registerButton = findViewById(R.id.register);
            TextView othersTextView = findViewById(R.id.others);
            ImageView fbButton = findViewById(R.id.fb);
            ImageView twitterButton = findViewById(R.id.twitter);
            ImageView googleButton = findViewById(R.id.google);


            registerButton.setOnClickListener(v -> {
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String password2 = password2EditText.getText().toString().trim();


                Button btnRegister = findViewById(R.id.register);
                btnRegister.setOnClickListener(view -> {

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                });


                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(password2)) {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();

                }
            });

            othersTextView.setOnClickListener(v -> {
                Toast.makeText(RegisterActivity.this, "You can sign up with social media", Toast.LENGTH_SHORT).show();
            });

            fbButton.setOnClickListener(v -> {
                Toast.makeText(RegisterActivity.this, "Logging in with Facebook", Toast.LENGTH_SHORT).show();
            });

            twitterButton.setOnClickListener(v -> {
                Toast.makeText(RegisterActivity.this, "Logging in with Twitter", Toast.LENGTH_SHORT).show();
            });

            googleButton.setOnClickListener(v -> {
                Toast.makeText(RegisterActivity.this, "Logging in with Google", Toast.LENGTH_SHORT).show();
            });
        }
}
