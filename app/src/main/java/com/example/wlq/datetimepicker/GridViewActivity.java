package com.example.wlq.datetimepicker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends ActionBarActivity  implements AdapterView.OnItemClickListener{
    private GridView gridView;
    private Button grid_back_bt;
    private List<Map<String,Object>>datalist;
//    private int[] icon = {R.mipmap.ic_1_pic,R.mipmap.ic_2_pic,R.mipmap.ic_3_pic,R.mipmap.ic_4_pic,R.mipmap.ic_5_pic,
//            R.mipmap.ic_6_pic,R.mipmap.ic_7_pic,R.mipmap.ic_8_pic,R.mipmap.ic_9_pic,R.mipmap.ic_10_pic,
//            R.mipmap.ic_11_pic,R.mipmap.ic_12_pic};
private int[] icon = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
        R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
        R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    private String[] iconName = {"通讯录","日历","照相机","时钟","游戏","短信","铃声",
            "设置","语音","天气","浏览器","视频"};
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        gridView = (GridView)findViewById(R.id.gridView);
        grid_back_bt = (Button)findViewById(R.id.grid_back_bt);
        //1.准备数据源
        //2.新建适配器(SimpleAdapter)
        //3.GridView加载适配器
        //4.GridView配置事件监听器(OnItemClickListener)
        datalist = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);





        grid_back_bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private  List<Map<String,Object>> getData(){
        for(int i=0;i<icon.length;i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            datalist.add(map);
        }
        return  datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"我是"+iconName[position],Toast.LENGTH_SHORT).show();
    }
}
