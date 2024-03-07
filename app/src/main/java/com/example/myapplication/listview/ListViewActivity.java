package com.example.myapplication.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class ListViewActivity extends Activity {
    private ListView lsView1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lsView1 = findViewById(R.id.lv_1one);
        lsView1.setAdapter(new MyListAdapter(ListViewActivity.this));
        lsView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "点击pos: "+ position, Toast.LENGTH_SHORT).show();
            }
        });

        lsView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //position是列表的序号，从0开始
                Toast.makeText(ListViewActivity.this, "长按pos: "+ position, Toast.LENGTH_SHORT).show();
                //return false表示事件到这里没截止，所以长按后还会执行点击事件
                return true;
            }
        });
    }
}
