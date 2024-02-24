package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.os.Build;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button activityButton;
    private Button radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        activityButton = findViewById(R.id.btn_editext);
        radioButton = findViewById(R.id.btn_radiobtn);
        setListeners();
    }
    private void setListeners(){
        OnClick onclick = new OnClick();
        mBtnTextView.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        activityButton.setOnClickListener(onclick);
        radioButton.setOnClickListener(onclick);
    }
    private class OnClick implements View.OnClickListener{
        private final Map<Integer, Class<? extends Activity>> activityMap = new HashMap<>();

        public OnClick() {
            activityMap.put(R.id.btn_editext, EditTextActivity.class);
            activityMap.put(R.id.btn_textview, TextViewActivity.class);
            activityMap.put(R.id.btn_button, ButtonActivity.class);
            activityMap.put(R.id.btn_radiobtn, RadioBtnActivity.class);
        }

        @Override
        public void onClick(View v) {
            Class<? extends Activity> activityClass = activityMap.get(v.getId());
            if (activityClass != null) {
                Intent intent = new Intent(MainActivity.this, activityClass);
                startActivity(intent);
            } else {
                // 可选：处理未知ID或设置默认行为
            }
        }
    }
}