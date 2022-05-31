package com.example.lovingtonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText email, username, noWA, password, confPassword;
    Button mButtonRegister;
    TextView backLogin;
    DBHelper DB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.editTextMail);
        username = (EditText) findViewById(R.id.editTextUsername);
        noWA = (EditText) findViewById(R.id.editTextNoWA);
        password = (EditText) findViewById(R.id.editTextPW);
        confPassword = (EditText) findViewById(R.id.editTextConfirmPW);

        backLogin = (TextView) findViewById(R.id.backLogin);
        mButtonRegister = (Button) findViewById(R.id.buttonRegister);
        DB = new DBHelper(this);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail= email.getText().toString();
                String user = username.getText().toString();
                String wa = noWA.getText().toString();
                String pass = password.getText().toString();
                String confPass = confPassword.getText().toString();

                if(mail.equals("")||user.equals("")||wa.equals("")||pass.equals("")||confPass.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(confPass)) {
                        Boolean checkmail = DB.checkemail(mail);
                        if (checkmail==false) {
                            Boolean insert = DB.insertData(mail, pass);
                            if (insert==true) {
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "User already exists! please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}
