package com.kfs.readotp.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by lenovo on 4/28/2017.
 */


public class UsePermissions {

    public static UsePermissions mInstance = null;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private String TAG = UsePermissions.class.getSimpleName();

    private UsePermissions() {}

    public static UsePermissions getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new UsePermissions();
        }
        return mInstance;
    }

    public boolean permissions(Activity activity)
    {
        boolean hasPermission = (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.RECEIVE_SMS},
                    PERMISSION_REQUEST_CODE);
            return false;
        } else {
            return true;
        }
    }

}

