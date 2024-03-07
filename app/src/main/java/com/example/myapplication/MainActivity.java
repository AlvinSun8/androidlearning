package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.os.Build;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.myapplication.listview.ListViewActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button activityButton;
    private Button radioButton;
    private Button checkedButton;
    private Button ImageViewButton;
    private Button ListViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        activityButton = findViewById(R.id.btn_editext);
        radioButton = findViewById(R.id.btn_radiobtn);
        checkedButton = findViewById(R.id.btn_checkbox);
        ImageViewButton = findViewById(R.id.btn_imageview);
        ListViewButton = findViewById(R.id.btn_listview);
        setListeners();
    }
    private void setListeners(){
        OnClick onclick = new OnClick();
        mBtnTextView.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        activityButton.setOnClickListener(onclick);
        radioButton.setOnClickListener(onclick);
        checkedButton.setOnClickListener(onclick);
        ImageViewButton.setOnClickListener(onclick);
        ListViewButton.setOnClickListener(onclick);
    }
    private class OnClick implements View.OnClickListener{
        private final Map<Integer, Class<? extends Activity>> activityMap = new HashMap<>();

        public OnClick() {
            activityMap.put(R.id.btn_editext, EditTextActivity.class);
            activityMap.put(R.id.btn_textview, TextViewActivity.class);
            activityMap.put(R.id.btn_button, ButtonActivity.class);
            activityMap.put(R.id.btn_radiobtn, RadioBtnActivity.class);
            activityMap.put(R.id.btn_checkbox, CheckBoxActivity.class);
            activityMap.put(R.id.btn_imageview, ImageViewActivity.class);
            activityMap.put(R.id.btn_listview, ListViewActivity.class);
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
