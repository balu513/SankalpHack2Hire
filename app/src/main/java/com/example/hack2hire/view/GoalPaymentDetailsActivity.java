package com.example.hack2hire.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hack2hire.R;

public class GoalPaymentDetailsActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] country = { "Buying Home", "Buying Car", "Paying for School","Paying DTH"};
    private TextView tvGoal,tvGoalAmt;
    private long goalAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_payment_details);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        tvGoal=(TextView)findViewById(R.id.tv_goal);
        tvGoalAmt=(TextView)findViewById(R.id.tv_goal_amt);

        ((Button)findViewById(R.id.pay_button_)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("GoalValue",goalAmt);

            }
        });
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
        if(position>0)
            tvGoal.setVisibility(View.VISIBLE);
            tvGoalAmt.setVisibility(View.VISIBLE);
            goalAmt=(position+1)*145;
            tvGoalAmt.setText((position+1)*145+"$");

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}