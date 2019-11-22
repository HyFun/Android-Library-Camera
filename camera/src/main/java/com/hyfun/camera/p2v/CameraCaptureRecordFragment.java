package com.hyfun.camera.p2v;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.hyfun.camera.R;
import com.hyfun.camera.widget.CaptureButton;

/**
 * Created by HyFun on 2019/10/14.
 * Email: 775183940@qq.com
 * Description: 用于拍摄照片和视频的fragment,默认保存至DCMI文件夹中
 */
@SuppressLint("ValidFragment")
public class CameraCaptureRecordFragment extends BaseFragment {


    private int mode; // 拍摄模式
    private long duration; // 拍摄时长


    //视图
    private SurfaceView surfaceView;
    private View viewBack;
    private CaptureButton captureButton;


    public CameraCaptureRecordFragment(int mode, long duration) {
        this.mode = mode;
        this.duration = duration;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.camera_fragment_capture_record, container, false);
        surfaceView = view.findViewById(R.id.camera_capture_record_surface_view);
        viewBack = view.findViewById(R.id.camera_capture_record_btn_back);
        captureButton = view.findViewById(R.id.camera_capture_record_capture_button);

        // 初始化
        Capture capture = new Capture(surfaceView);

        viewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        captureButton.setMode(mode);
        captureButton.setDuration(duration);
        captureButton.setOnProgressTouchListener(new CaptureButton.OnProgressTouchListener() {
            @Override
            public void onCapture() {
                Util.log("拍照片");
            }

            @Override
            public void onCaptureRecordStart() {
                Util.log("录制开始");
            }

            @Override
            public void onCaptureRecordEnd() {
                Util.log("录制结束了");
            }

            @Override
            public void onCaptureError(String message) {
                Util.log("拍摄出错>>>>>" + message);
            }

        });





        return view;
    }
}