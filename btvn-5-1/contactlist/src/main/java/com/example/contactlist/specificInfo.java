package com.example.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class specificInfo extends AppCompatActivity {
    String name,email,tel;
    TextView textName,textEmail,textTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_info);
        textName=findViewById(R.id.textName);
        textTel=findViewById(R.id.textPhoneNumber);
        textEmail=findViewById(R.id.textMail);
        setValue();
        textName.setText(name);
        textEmail.setText(email);
        textTel.setText(tel);
    }
    public void setValue(){
        Intent intent=getIntent();
        name=intent.getStringExtra("Name");
        email=intent.getStringExtra("Email");
        tel=intent.getStringExtra("Tel");


    }
}