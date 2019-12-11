package com.example.light;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private Button btnFlashLight;
    private final int CAMERA_REQUEST_CODE=2;
    boolean hasCameraFlash = false;
    private boolean isFlashOn=false;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasCameraFlash = getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        btnFlashLight =  (Button) findViewById(R.id.btnFlash);

        btnFlashLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermission(Manifest.permission.CAMERA,CAMERA_REQUEST_CODE);

            }
        });
    }

    private void flashLight() {
        if (hasCameraFlash) {
            if (isFlashOn) {
                btnFlashLight.setText("ON");
                flashLightOff();
                isFlashOn=false;
            } else {
                btnFlashLight.setText("OFF");
                flashLightOn();
                isFlashOn=true;
            }
        } else {
            Toast.makeText(MainActivity.this, "No flash available on your device",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void flashLightOn() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
        } catch (CameraAccessException e) {
        }
    }

    private void flashLightOff() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
        }
    }

    private void askPermission(String permission,int requestCode) {
        if (ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
            // We Dont have permission
            ActivityCompat.requestPermissions(this,new String[]{permission},requestCode);

        }else {
            // We already have permission do what you want
            flashLight();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                hasCameraFlash = getPackageManager().
                        hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
                Toast.makeText(this,"Camera Permission Granted",Toast.LENGTH_LONG).show();
                flashLight();

            } else {
                Toast.makeText(this,"Camera Permission Denied",Toast.LENGTH_LONG).show();
            }
            break;
        }
    }
}
