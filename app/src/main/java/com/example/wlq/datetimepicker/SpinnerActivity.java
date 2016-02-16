package com.example.wlq.datetimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView textView;
    private Spinner spinner;
    private List<String> list;
    private Button spinner_back_bt;
    private List<Map<String,Object>>datalist;
    private String[] citylist = {"北京","上海","天津","广州","深圳","香港","澳门",
            "台湾"};

   // ArrayAdapter adapter;
    SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        textView = (TextView)findViewById(R.id.spinner_text);
        textView.setText("您选择的城市：");
        spinner = (Spinner)findViewById(R.id.spinner);
        list = new ArrayList<String>();
        //1.设置数据源
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        //2.新建ArrayAdapter（数组适配器）
        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        //adapter = new SimpleAdapter(this,getData(),R.layout.spinner_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        //adapter = new SimpleAdapter(this,getData(),R.layout.spinner_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        datalist = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(this,getData(),R.layout.spinner_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        //3.adapter设置一个下拉列表样式
        adapter.setDropDownViewResource(R.layout.spinner_item);
        //4.spinner加载适配器
        spinner.setAdapter(adapter);
        //5.设置spinner监听器
        spinner.setOnItemSelectedListener(this);

        spinner_back_bt = (Button)findViewById(R.id.spinner_back_bt);
        spinner_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       //String cityName = (String) adapter.getItem(position);
       // textView.setText("您选择的城市是："+cityName);
        textView.setText("您选择的城市是："+citylist[position]);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private List<Map<String,Object>>  getData(){
        for(int i=0;i<citylist.length;i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image",R.mipmap.ic_launcher);
            map.put("text",citylist[i]);
            datalist.add(map);
        }
        return  datalist;

    }
}
