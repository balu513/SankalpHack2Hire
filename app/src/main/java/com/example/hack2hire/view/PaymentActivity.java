package com.example.hack2hire.view;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hack2hire.R;

public class PaymentActivity  extends AppCompatActivity {

    private EditText etCardHolderName;
    private EditText etCardNumber;
    private EditText etMobile;
    private EditText etExpiry;
    private EditText etCvv;

    private boolean canProceed = false;
    private long goalAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        etCardHolderName = (EditText) findViewById(R.id.cardholder_name);
        etCardNumber = (EditText) findViewById(R.id.card_number);
        etMobile =(EditText)findViewById(R.id.mobile);
        etExpiry =(EditText)findViewById(R.id.expiry);
        etCvv =(EditText)findViewById(R.id.cvv);

        if(getIntent()!=null)
        {
            goalAmt=getIntent().getExtras().getLong("GoalValue");
            ((TextView)findViewById(R.id.item_price)).setText(goalAmt+"$");
        }


        ((Button)findViewById(R.id.pay_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
                if(canProceed) {
                    Toast.makeText(PaymentActivity.this, "Payment Successful, You are eligible for Buy Goal - IPHONE X", Toast.LENGTH_SHORT).show();
                    showNotification();
                    PaymentActivity.this.finish();

                }
            }
        });
    }

    private void showNotification(){
        NotificationManager mNotificationManager;

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getApplicationContext(), "notify_001");
        Intent ii = new Intent(getApplicationContext(), PaymentActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, ii, 0);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText("");
        bigText.setBigContentTitle("WOW,");
        bigText.setSummaryText("Successfull");

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentText("You are eligible for Buy Goal - IPHONE X ");
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);

        mNotificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        mNotificationManager.notify(0, mBuilder.build());
    }

    private void validateData() {

        if(etCardHolderName.getText().toString().isEmpty()) {
           // Toast.makeText(this, "Card holder name empty", Toast.LENGTH_SHORT).show();
            etCardHolderName.setError("invalid name");
            return;
        }
        if(etCardNumber.getText().toString().isEmpty()) {
          //  Toast.makeText(this, "Card holder name empty", Toast.LENGTH_SHORT).show();
            etCardNumber.setError("Card number mandatory");
            return;
        }
        if(etMobile.getText().toString().isEmpty()) {
          //  Toast.makeText(this, "Mobile number empty", Toast.LENGTH_SHORT).show();
            etMobile.setError("invalid mobile number");
            return;
        }
        if(etCvv.getText().toString().isEmpty()) {
            //Toast.makeText(this, "CVV empty", Toast.LENGTH_SHORT).show();
            etCvv.setError("CVV must");
            return;
        }
        if(etExpiry.getText().toString().isEmpty()) {
            //Toast.makeText(this, "Expire must", Toast.LENGTH_SHORT).show();
            etExpiry.setError("expiry must");
            return;
        }
        canProceed =true;

    }
}

