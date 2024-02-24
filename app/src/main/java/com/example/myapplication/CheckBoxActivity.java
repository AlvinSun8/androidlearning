package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox cb1, cb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cb1 = findViewById(R.id.checkbox1);
        cb2 = findViewById(R.id.checkbox2);
        setListeners();
    }

    private void setListeners(){
        onCheckedChanged oncheckedChanged =  new onCheckedChanged();
        cb1.setOnCheckedChangeListener(oncheckedChanged);
        cb2.setOnCheckedChangeListener(oncheckedChanged);
    }

    private class onCheckedChanged implements CompoundButton.OnCheckedChangeListener{
        private final Map<Integer, String> mapCheck= new HashMap<>();
        public onCheckedChanged(){
            mapCheck.put(R.id.checkbox1, "按钮1");
            mapCheck.put(R.id.checkbox2, "按钮2");
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String checkName = mapCheck.get(buttonView.getId());

            if(isChecked){
                showToast(checkName + "选中了");
            }else{
                showToast(checkName + "取消选中啦");
            }
        }

        private void showToast(String msg){
            Toast.makeText(CheckBoxActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}