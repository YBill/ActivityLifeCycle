package com.activitylifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private void logd(String msg) {
        Log.d("Bill", "MainActivity " + msg);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        logd("onConfigurationChanged");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logd("onCreate");
        if (savedInstanceState != null) {
            int key = savedInstanceState.getInt("key", 0);
            logd("onCreate key:" + key);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logd("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logd("onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logd("onRestoreInstanceState");
        int key = savedInstanceState.getInt("key", 0);
        logd("onRestoreInstanceState key:" + key);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logd("onResume");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        logd("onWindowFocusChanged:" + hasFocus);
    }

    @Override
    protected void onPause() {
        super.onPause();
        logd("onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logd("onSaveInstanceState");
        outState.putInt("key", 250);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logd("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logd("onDestroy");
    }

    public void handleClick(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
