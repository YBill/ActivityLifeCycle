package com.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityDialog extends AppCompatActivity {

    private void logd(String msg) {
        Log.d("Bill", "ActivityDialog " + msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
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
}
