package com.kfs.otpreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kfs.readotp.activity.UsePermissions;
import com.kfs.readotp.interfaces.OtpInterface;
import com.kfs.readotp.receiver.SMSReceiver;


public class MainActivity extends AppCompatActivity implements OtpInterface {
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsePermissions.getInstance().permissions(MainActivity.this);
        SMSReceiver.requestData(this,"DZ-bytwoo");
    }

    @Override
    public void messageBody(String message) {
        Log.d(TAG, "messageBody: message" + message);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
