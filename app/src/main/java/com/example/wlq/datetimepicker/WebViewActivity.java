package com.example.wlq.datetimepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
    private  String url = "http://www.baidu.com";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
//        Uri uri = Uri.parse(url);
//        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);
        init();
    }

    private void init() {
        webView = (WebView)findViewById(R.id.webview);
        webView.loadUrl(url);
        //覆盖webview默认通过第三方或者系统过浏览器打开网页的行为，使得网页可以在webview中打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候网页在webview中去打开，如果false就调用第三方或者系统浏览器打开
                view.loadUrl(url);
                return  true;
                //return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //WebViewClient帮助webview去处理一些页面控制和通知
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
    }
    //改写物理案件--返回的逻辑

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();
                return true;
            }
            else
            {
                System.exit(0);//退出程序的处理
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
