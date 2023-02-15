package com.example.module_2_assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registartion extends AppCompatActivity {

    EditText userName;
    EditText emailId;
    EditText password;
    Button reg_link_btn;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        userName = findViewById(R.id.userName);
        emailId = findViewById(R.id.emailId);
        password =  findViewById(R.id.password);
        reg_link_btn = findViewById(R.id.reg_link_btn);
        btn_login = findViewById(R.id.btn_login);


        reg_link_btn.setOnClickListener(view -> checkInputData());

        btn_login.setOnClickListener(view -> {
            Intent i = new Intent(registartion.this,MainActivity.class);
            startActivity(i);

        });


    }

    boolean isEmpty (EditText text){
        CharSequence str =  text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmailValid(EditText text) {
        CharSequence emailId = text.getText().toString();
        return (!TextUtils.isEmpty(emailId) && Patterns.EMAIL_ADDRESS.matcher(emailId).matches());
    }

    void checkInputData(){
        if (isEmpty(password)){
            Toast t = Toast.makeText(this,"Please Enter Password to proceed",Toast.LENGTH_SHORT);
            t.show();
        }

        if (!isEmailValid(emailId)){
            emailId.setError("Enter valid Email Id");

        }

        else {
            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
        }
    }
}