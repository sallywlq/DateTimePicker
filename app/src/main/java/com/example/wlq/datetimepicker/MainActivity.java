package com.example.wlq.datetimepicker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button date_bt;
    private Button grid_bt;



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




    }
}
