package com.example.pinesh.multipleactivityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_receive_message);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra("message");
        TextView tv = (TextView)findViewById(R.id.rmessage);
        tv.setText(messageText);
    }
}
