package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fromID, toID;
    EditText beginValue, resultValue;
    Button convertBtn, clearBtn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String key = "fromID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromID = findViewById(R.id.fromID);
        toID = findViewById(R.id.toID);
        beginValue = findViewById(R.id.beginValue);
        resultValue = findViewById(R.id.endValue);
        convertBtn = findViewById(R.id.convertbtn);

        resultValue.setEnabled(false);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);

        Intent getIntent = getIntent();
        final String FROM = getIntent.getStringExtra(SelectActivity.FROM);
        final String TO = getIntent.getStringExtra(SelectActivity.TO);

        convert(getMoneyType(fromID), getMoneyType(toID));

        if(FROM != null && TO != null){
            try {
                fromID.setText("From: " + FROM);
                toID.setText("To: " + TO);
            }
            catch (Exception e){

           }
        }

        beginValue.setText(sharedPreferences.getString(key, ""));
        fromID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                editor = sharedPreferences.edit();
                editor.putString(key, beginValue.getText().toString());
                editor.commit();
                startActivity(intent);
            }
        });

        toID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 convert(getMoneyType(fromID), getMoneyType(toID));
            }
        });

    }

    public void convert(String fr, String to) {
        if(fr.equals("CNY") && !isEmpty(beginValue)){
                switch (to) {
                    case "CNY":
                        resultValue.setText(beginValue.getText().toString());
                        break;
                    case "EUR":
                        resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.14)));
                        break;
                    case "JPY":
                        resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 19.12)));
                        break;
                    case "KRW":
                        resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 185.30)));
                        break;
                    case "USD":
                        resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.14)));
                        break;
                    case "VND":
                        resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 3468)));
                        break;
                    default:
                        break;
                }
        }
        if(fr.equals("EUR") && !isEmpty(beginValue)){
            switch (to) {
                case "CNY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 7.4)));
                    break;
                case "EUR":
                    resultValue.setText(beginValue.getText().toString());
                    break;
                case "JPY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 141.53)));
                    break;
                case "KRW":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 1370.83)));
                    break;
                case "USD":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 1.05)));
                    break;
                case "VND":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 25830.05)));
                    break;
                default:
                    break;
            }
        }
        if(fr.equals("JPY") && !isEmpty(beginValue)){
            switch (to) {
                case "CNY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.052)));
                    break;
                case "EUR":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.0071)));
                    break;
                case "JPY":
                    resultValue.setText(beginValue.getText().toString());
                    break;
                case "KRW":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 9.69)));
                    break;
                case "USD":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.0074)));
                    break;
                case "VND":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 177.6)));
                    break;
                default:
                    break;
            }
        }
        if(fr.equals("KRW") && !isEmpty(beginValue)){
            switch (to) {
                case "CNY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.0054)));
                    break;
                case "EUR":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.00073)));
                    break;
                case "JPY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.1)));
                    break;
                case "KRW":
                    resultValue.setText(beginValue.getText().toString());
                    break;
                case "USD":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.00077)));
                    break;
                case "VND":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 18.83)));
                    break;
                default:
                    break;
            }
        }
        if(fr.equals("USD") && !isEmpty(beginValue)){
            switch (to) {
                case "CNY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 7.02)));
                    break;
                case "EUR":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.95)));
                    break;
                case "JPY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 134.31)));
                    break;
                case "KRW":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 1300.92)));
                    break;
                case "USD":
                    resultValue.setText(beginValue.getText().toString());
                    break;
                case "VND":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 24365)));
                    break;
                default:
                    break;
            }
        }
        if(fr.equals("VND") && !isEmpty(beginValue)){
            switch (to) {
                case "CNY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.00029)));
                    break;
                case "EUR":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.000039)));
                    break;
                case "JPY":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.0055)));
                    break;
                case "KRW":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.053)));
                    break;
                case "USD":
                    resultValue.setText(Float.toString((float) (Float.parseFloat(beginValue.getText().toString()) * 0.000041)));
                    break;
                case "VND":
                    resultValue.setText(beginValue.getText().toString());
                    break;
                default:
                    break;
            }
        }
    }

    String getMoneyType(TextView tv) {
        String[] s = (tv.getText().toString()).split(" ");
        return  s[1];
    }

    boolean isEmpty(EditText e){
        CharSequence str = e.getText().toString();
        return TextUtils.isEmpty(str);
    }

}