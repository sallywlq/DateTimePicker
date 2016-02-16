package com.example.wlq.datetimepicker;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button date_bt;
    private Button grid_bt;
    private Button spinner_bt;
    private Button progress_bt;
    private Button webview_bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date_bt = (Button)findViewById(R.id.date_bt);
        date_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,DatePickerActivity.class);
                startActivity(intent);
            }
        });
        grid_bt = (Button)findViewById(R.id.grid_bt);
        grid_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GridViewActivity.class);
                startActivity(intent);


            }
        });
        spinner_bt = (Button)findViewById(R.id.spinner_bt);
        spinner_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SpinnerActivity.class);
                startActivity(intent);
            }
        });
        progress_bt = (Button)findViewById(R.id.progress_bt);
        progress_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProgressBarActivity.class);
                startActivity(intent);
            }
        });
        webview_bt = (Button)findViewById(R.id.webview_bt);
        webview_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });




    }
}
