package com.example.hack2hire.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hack2hire.R;

public class OnlineShopActivity extends AppCompatActivity {

    private EditText etGoalAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_shop);

        etGoalAmt=(EditText)findViewById(R.id.goal_amount);

        (findViewById(R.id.pay_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("GoalValue", Long.parseLong(etGoalAmt.getText().toString()));
                Intent intent = new Intent(OnlineShopActivity.this, PaymentActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                OnlineShopActivity.this.finish();
            }
        });
    }
}
