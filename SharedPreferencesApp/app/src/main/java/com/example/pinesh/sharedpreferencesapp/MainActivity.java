package com.example.pinesh.sharedpreferencesapp;

import android.animation.TypeEvaluator;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText message;
    RadioButton rb;
    SeekBar seekbar;
    float font_size;
    String font_color;
    String text_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (EditText)findViewById(R.id.message);
        seekbar = (SeekBar) findViewById(R.id.seek_bar);
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);

        text_info = sharedPreferences.getString(getString(R.string.TEXT_INFO),"");
        message.setText(text_info);

        font_size = sharedPreferences.getFloat(getString(R.string.FONT_SIZE),25);
        font_color = sharedPreferences.getString(getString(R.string.FONT_COLOR),"BLACK");

        message.setTextSize(TypedValue.COMPLEX_UNIT_PX,font_size);
        if(font_size == 25) {
            seekbar.setProgress(0);
        } else {
            seekbar.setProgress((int)font_size);
        }

        if(font_color.equals("RED")) {
            rb = (RadioButton) findViewById(R.id.red);
            rb.setChecked(true);
            message.setTextColor(Color.RED);
        } else if(font_color.equals("GREEN")){
            rb = (RadioButton) findViewById(R.id.green);
            rb.setChecked(true);
            message.setTextColor(Color.GREEN);
        } else if(font_color.equals("BLUE")){
            message.setTextColor(Color.BLUE);
            rb = (RadioButton) findViewById(R.id.blue);
            rb.setChecked(true);
        } else {
            message.setTextColor(Color.BLACK);
        }

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                message.setTextSize(TypedValue.COMPLEX_UNIT_PX,i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                font_size = message.getTextSize();
            }
        });
    }

    public void changeColor(View view) {
        switch (view.getId()) {
            case R.id.red:
                message.setTextColor(Color.RED);
                font_color = "RED";

                break;
            case R.id.green:
                message.setTextColor(Color.GREEN);
                font_color = "GREEN";
                break;
            case R.id.blue:
                message.setTextColor(Color.BLUE);
                font_color = "BLUE";
                break;
        }
    }

    public void saveSetting(View view){
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat(getString(R.string.FONT_SIZE),font_size);
        editor.putString((getString(R.string.FONT_COLOR)),font_color);
        editor.putString(getString(R.string.TEXT_INFO),message.getText().toString());
        editor.commit();
    }

    public void clearSetting(View view){
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
