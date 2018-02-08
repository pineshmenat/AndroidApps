package com.example.pinesh.multipleactivityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    EditText et;
    private String LOG_TAG="MSG_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        Log.d(LOG_TAG,"oncreate");
    }

    //START For activity Lifecycle


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onReStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }


    //END For activity Lifecycle


    protected void onSendMessage(View view){
        et = (EditText)findViewById(R.id.message);
        String message = et.getText().toString();
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("message",message);
        startActivity(intent);
    }
}
