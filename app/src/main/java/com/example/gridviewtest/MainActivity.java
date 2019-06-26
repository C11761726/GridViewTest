package com.example.gridviewtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    //图标
    int icno[] = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridview);
        //初始化数据
        initData();

        String[] from = {"img", "text"};

        int[] to = {R.id.img, R.id.text};

        adapter = new SimpleAdapter(this, dataList, R.layout.gridview_item, from, to);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,
                                    long arg3) {
                Log.d("posi", "==>>" + arg2 + "==>>" + arg3);
                GridView gridView = (GridView) view.getParent();
                for (int i = 0; i < icno.length; ++i) {
                    LinearLayout ll = (LinearLayout) gridView.getChildAt(i);
                    if (i == arg2) {
                        ll.setBackgroundColor(Color.GREEN);
                    } else {
                        ll.setBackgroundColor(Color.RED);
                    }
                }
            }
        });

    }

    void initData() {

        //图标下的文字
        String name[] = {"时钟", "信号", "宝箱", "秒钟", "大象", "FF", "记事本", "书签", "印象", "商店", "主题", "迅雷"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text", name[i]);
            dataList.add(map);
        }
    }
}
