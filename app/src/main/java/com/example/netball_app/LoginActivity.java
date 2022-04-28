package com.example.netball_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    // declared buttons and other containers
    EditText Name;
    EditText Password;
    ImageButton Info;
    ImageButton Login;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //assigning variables
        Name = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        Info = findViewById(R.id.btnregister);
        Login = findViewById(R.id.btnLogin);

        //set what the Login button does
        Login.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);


        //button to register instead of login -> points user towards register page
        Info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }


        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = Name.getText().toString();
                final String password = Password.getText().toString();

                //listener that checks on the information received from user input
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //info converted into jsonobject to work with
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            // if information matches - user is sent to Home Activity. Info also sent to show as Profile in Home Activity
                            if (success){

                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                String email = jsonResponse.getString("email");

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("username", username);
                                intent.putExtra("email", email);

                                LoginActivity.this.startActivity(intent);

                            // if information does not match or is missing - alert user of wrong info
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                            //if any error occurs
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //information for Request Queue
                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);


            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}



