package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText mBtnUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
            }
        });

        mBtnUserName = findViewById(R.id.edit_one);
        mBtnUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //s就是当前输入框字符串
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("editext", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}