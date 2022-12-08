package com.example.bai1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText firstName, lastName, birthday, address, email;
    RadioButton male, female;
    RadioGroup radioGroup;
    CheckBox checkBox;
    Button select, register,ok;
    DatePicker datePicker;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        birthday = findViewById(R.id.editBirthday);
        address = findViewById(R.id.editAddress);
        email = findViewById(R.id.editEmail);
        radioGroup = findViewById(R.id.radioGroup);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        checkBox = findViewById(R.id.checkBox);
        select = findViewById(R.id.btSelect);
        register = findViewById(R.id.btRegister);
        datePicker = findViewById(R.id.datePicker);
        ok = findViewById(R.id.OK);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month  = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(view.VISIBLE);
                ok.setVisibility(view.VISIBLE);
                register.setVisibility(view.INVISIBLE);
                address.setEnabled(false);
                email.setEnabled(false);
            }
        });

        birthday.setEnabled(true);

        datePicker.init( year, month , day , new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                datePickerChange(datePicker, year, month, dayOfMonth);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkData();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
                datePicker.setVisibility(v.INVISIBLE);
                ok.setVisibility(v.INVISIBLE);
                register.setVisibility(v.VISIBLE);
                address.setEnabled(true);
                email.setEnabled(true);
            }
        });
    }

    boolean isEmpty(EditText e){
        CharSequence str = e.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isCheckRadio(RadioGroup rg){
        if (rg.getCheckedRadioButtonId() == -1){
            return true;
        }
        return false;
    }

    boolean isCheckBox(CheckBox cb){
        if (!cb.isChecked()){
            return true;
        }
        return false;
    }

    void datePickerChange(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
        birthday.setText(dayOfMonth +"-" + (month + 1) + "-" + year);
    }

    void showDate() {
        int year = this.datePicker.getYear();
        int month = this.datePicker.getMonth();
        int day = this.datePicker.getDayOfMonth();

        Toast.makeText(this, "Date: " + day + "-" + (month + 1) + "-" + year, Toast.LENGTH_LONG).show();
    }

    public void alter(String str){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Notification..!!!");
        alertDialogBuilder.setMessage(str);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }
        );

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    void checkData(){
        if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(birthday) || isCheckRadio(radioGroup)
            || isEmpty(address) || isEmpty(email) || isCheckBox(checkBox)) {
            alter("Không được để trống!");
        }
        else {
            alter("Thành công!");
        }
    }

}