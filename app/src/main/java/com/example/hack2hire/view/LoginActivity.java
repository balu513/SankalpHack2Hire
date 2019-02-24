package com.example.hack2hire.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hack2hire.R;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText etEmail, etPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText)findViewById(R.id.email);
        etPwd = (EditText)findViewById(R.id.password);

        ((Button)findViewById(R.id.email_sign_in_button)).setOnClickListener(this);
        ((TextView)findViewById(R.id.tv_register)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.email_sign_in_button:
                login();
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }
    }

    private void login() {

        String emmail = etEmail.getText().toString();
        String pwd = etPwd.getText().toString();

        if(emmail.isEmpty())
        {
            etEmail.setError("UserId empty");
            return;
        }
        if(pwd.isEmpty())
        {
            etEmail.setError("password empty");
            return;
        }

        if(emmail.equals("1234") && pwd.equals("dbs1234")) {

            Toast.makeText(this, "Logged In Successful", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, DashBoardActivity.class));
        }else
        {
            Toast.makeText(this, "invalid credentials", Toast.LENGTH_SHORT).show();
        }


    }
}