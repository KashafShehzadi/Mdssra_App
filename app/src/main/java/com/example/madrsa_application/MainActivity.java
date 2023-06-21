package com.example.madrsa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LoginActivity.java







                editTextUsername = findViewById(R.id.editTextUsername);
                editTextPassword = findViewById(R.id.editTextPassword);
                buttonLogin = findViewById(R.id.buttonLogin);

                buttonLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = editTextUsername.getText().toString();
                        String password = editTextPassword.getText().toString();

                        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                            // Login successful, do something (e.g., start a new activity)
                            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AddUser.class);
                            startActivity(intent);
                        } else {
                            // Invalid credentials, show an error message
                            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }



}