package com.example.hack2hire.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import com.example.hack2hire.R;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName, etMobile,etEmail,etPwd;
    private int mYear;
    private int mMonth;
    private int mDay;
    private EditText etDob;
    private EditText etJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
       etName = (EditText) findViewById(R.id.name);
       etMobile=(EditText) findViewById(R.id.mobile);
       etEmail= (EditText)findViewById(R.id.email);
       etPwd = (EditText)findViewById(R.id.password);
       etDob= (EditText)findViewById(R.id.date_of_birth);
        etJob= (EditText)findViewById(R.id.job);

       ((Button)findViewById(R.id.email_sign_in_button)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_date)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
       switch (v.getId())
       {
           case R.id.email_sign_in_button:
               signupUser();
               break;
           case R.id.btn_date:
               Toast.makeText(this,"Date selcted",Toast.LENGTH_SHORT).show();
               showDatePicker();
               break;
       }
    }

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                         etDob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void signupUser() {
        String name = etName.getText().toString();
        String mobile = etMobile.getText().toString();
        String email =etEmail.getText().toString();
        String pwd= etPwd.getText().toString();
        String dob= etDob.getText().toString();
        String job = etJob.getText().toString();

    /*    boolean addUser = new MyDB(this).addUser(new User(name, mobile, email, pwd));
        if(!addUser)
            Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        }*/
    }
}
