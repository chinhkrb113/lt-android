package com.example.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainScreen;
    String data, input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreen = (TextView) findViewById(R.id.textView2);
    }

    public void ButtonClick(View v){
        Button bt = (Button) v;
        data = bt.getText().toString();

        switch (data) {
            case "CE":
                input = "";
                break;
            case "C" :
                if (input.length() > 0){
                    String newInput = input.substring(0, input.length() - 1 );
                    input = newInput;
                }
                break;
            case "BS":
                break;
            case "+/-":
                break;
            case "=":
                Solve();
                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("×") || data.equals("/")){
                    Solve();
                }
                input += data;
        }
        mainScreen.setText(input);
    }

    public void Solve() {
        if (input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            } catch (Exception e){

            }
        }
        if (input.split("\\-").length == 2){
            String number[] = input.split("\\-");
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = sub + "";
            } catch (Exception e){

            }
        }
        if (input.split("\\×").length == 2){
            String number[] = input.split("\\×");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            } catch (Exception e){

            }
        }
        if (input.split("\\/").length == 2){
            String number[] = input.split("\\/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            } catch (Exception e){

            }
        }
    }
}