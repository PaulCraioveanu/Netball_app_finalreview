package com.example.netball_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity{
    EditText etName, etUsername, etEmail, etPassword, etAge;
    final int MIN_PASSWORD_LENGTH = 6;
    ImageButton bRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewInitializations();
    }

    // boolean isEmailValid(String email) {
        //return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    //}

    void viewInitializations() {
        etUsername = findViewById(R.id.etUsername);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAge = findViewById(R.id.etAge);
        bRegister = findViewById(R.id.Registerbutton);

        //set what button does
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            //variable only assigned to this
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String name = etName.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    //converting to jsonobject to be able to work with it
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            //check if response is successful
                            boolean success = jsonResponse.getBoolean("success");

                            //if register successful - push user to login
                            if (success){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                                //if register not successful - alert user of failed rergistration
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //request has to be added to request queue
                //get queue from volley
                RegisterRequest registerReguest = new RegisterRequest(username, name, email, password, age, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerReguest);

            }
        });


    }



}

