package com.example.wlq.datetimepicker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class GridViewActivity extends ActionBarActivity {
    private GridView gridView;
    private Button grid_back_bt;

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




        grid_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
