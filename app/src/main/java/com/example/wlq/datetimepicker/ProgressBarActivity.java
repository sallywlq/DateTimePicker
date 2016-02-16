package com.example.wlq.datetimepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends Activity implements View.OnClickListener{
    private ProgressBar progress;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView text;
    private ProgressDialog prodialog;
    private Button show_bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 启用窗口特征，启用带进度和不带进度的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_progress_bar);
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(false);
        //max=10000
        setProgress(9999);
        init();

    }
    private void  init(){
        progress = (ProgressBar)findViewById(R.id.progressBar_horizontal);
        add = (Button)findViewById(R.id.add);
        reduce = (Button)findViewById(R.id.reduce);
        reset = (Button)findViewById(R.id.reset);
        text = (TextView)findViewById(R.id.show_text);
        show_bt = (Button)findViewById(R.id.show_bt);
        int first = progress.getProgress();
        int second = progress.getSecondaryProgress();
        int max = progress.getMax();
        text.setText("第一进度百分比：" + (int) (first / (float) max * 100)
                + "% 第二进度百分比：" + (int) (second / (float) max * 100) + "%");
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
        show_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.add: {
                //增加第一进度和第二进度10个刻度
                progress.incrementProgressBy(10);
                progress.incrementSecondaryProgressBy(10);
                break;
            }
            case R.id.reduce: {
                //减少第一进度和第二进度10个刻度
                progress.incrementProgressBy(-10);
                progress.incrementSecondaryProgressBy(-10);
                break;
            }
            case R.id.reset: {
                progress.setProgress(50);
                progress.setSecondaryProgress(80);
                break;
            }
            case R.id.show_bt:{
                /*
                *页面显示风格
                 */
                //新建progressdialog对象
                prodialog = new ProgressDialog(ProgressBarActivity.this);
                //设置显示风格
                prodialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //设置标题
                prodialog.setTitle("sallyquan");
                //设置对话框的文字信息
                prodialog.setMessage("感谢大家支持！");
                //设置图标
                prodialog.setIcon(R.mipmap.ic_launcher);
                prodialog.setMax(100);
                prodialog.incrementProgressBy(50);
                //进度条是明确显示进度
                prodialog.setIndeterminate(false);
                /*
                *设定一个确定按钮
                 */
                prodialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressBarActivity.this,"欢迎大家支持慕课网！",Toast.LENGTH_SHORT).show();
                    }
                });
                //是否可以通过返回按钮退出对话框
                prodialog.setCancelable(true);
                //显示progressDialog
                prodialog.show();
                break;
            }
        }

        text.setText("第一进度百分比：" + (int) (progress.getProgress() / (float) progress.getMax() * 100)
                + "% 第二进度百分比：" + (int) (progress.getSecondaryProgress() / (float) progress.getMax() * 100) + "%");
    }
}
