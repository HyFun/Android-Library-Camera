package com.hyfun.camera.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hyfun.camera.CameraCaptureActivity;
import com.hyfun.camera.FunCamera;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void capture(View view) {
        FunCamera.capturePhoto(this, 10);
    }

    public void record(View view) {
        FunCamera.captureRecord(this, 20, 15000);
    }

    public void captureRecord(View view) {

    }
}
