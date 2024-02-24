package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TextViewActivity extends AppCompatActivity {
    private TextView txtView4, txtView5, txtView6, txtView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        txtView4 = findViewById(R.id.text_view3);
        txtView4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtView4.getPaint().setAntiAlias(true);//去除锯齿

        txtView5 = findViewById(R.id.text_view4);
        txtView5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        txtView6 = findViewById(R.id.text_view5);
        txtView6.setText(Html.fromHtml("<u>hahhahah<u/>"));


//        setFullScreen();
    }

    private void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }
}