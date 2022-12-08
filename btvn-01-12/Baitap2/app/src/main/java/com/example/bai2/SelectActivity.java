package com.example.bai2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {

    RadioGroup rd11, rd12, rd21, rd22;
    Button ok, cancel;
    RadioButton rb11, rb12, rb21, rb22;
    static String FROM = "FROM";
    static String TO = "TO";
    public static String datafrom = "", datato = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);


        rd11 = findViewById(R.id.rd11);
        rd12 = findViewById(R.id.rd12);
        rd21 = findViewById(R.id.rd21);
        rd22 = findViewById(R.id.rd22);
        ok = findViewById(R.id.btnOK);
        cancel = findViewById(R.id.btnCANCEL);

        rd11.setOnCheckedChangeListener(listener11);
        rd12.setOnCheckedChangeListener(listener12);
        rd21.setOnCheckedChangeListener(listener21);
        rd22.setOnCheckedChangeListener(listener22);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectActivity.this, MainActivity.class);
                intent.putExtra(FROM, datafrom);
                intent.putExtra(TO, datato);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    RadioGroup.OnCheckedChangeListener listener11 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i != -1) {
                rd12.setOnCheckedChangeListener(null);
                rd12.clearCheck();
                rd12.setOnCheckedChangeListener(listener12);
                rb11 = (RadioButton) findViewById(rd11.getCheckedRadioButtonId());
                datafrom = rb11.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener listener12 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i != -1) {
                rd11.setOnCheckedChangeListener(null);
                rd11.clearCheck();
                rd11.setOnCheckedChangeListener(listener11);
                rb12 = (RadioButton) findViewById(rd12.getCheckedRadioButtonId());
                datafrom = rb12.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener listener21 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i != -1) {
                rd22.setOnCheckedChangeListener(null);
                rd22.clearCheck();
                rd22.setOnCheckedChangeListener(listener22);
                rb21 = (RadioButton) findViewById(rd21.getCheckedRadioButtonId());
                datato = rb21.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener listener22 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i != -1) {
                rd21.setOnCheckedChangeListener(null);
                rd21.clearCheck();
                rd21.setOnCheckedChangeListener(listener21);
                rb22 = (RadioButton) findViewById(rd22.getCheckedRadioButtonId());
                datato = rb22.getText().toString();
            }
        }
    };
}