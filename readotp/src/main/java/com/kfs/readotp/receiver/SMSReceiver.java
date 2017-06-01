package com.kfs.readotp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;


import com.kfs.readotp.interfaces.OtpInterface;

/**
 * Created by lenovo on 4/27/2017.
 */

public class SMSReceiver extends BroadcastReceiver {
    String TAG = SMSReceiver.class.getSimpleName();
    private static OtpInterface otPinterface;
    private static String receivingNumber;

    public static void requestData(OtpInterface otp, String receivingString)
    {
        otPinterface = otp;
        receivingNumber = receivingString;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdusArray = (Object[]) bundle.get("pdus");
            for (int i =0; i < pdusArray.length; i++)
            {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdusArray[i]);
                String senderNumber = smsMessage.getDisplayOriginatingAddress();
                String message = smsMessage.getDisplayMessageBody();

                Log.d(TAG, "onReceive: senderNumber" + senderNumber + " message " + message );

                if (!TextUtils.isEmpty(receivingNumber) && senderNumber.contains(receivingNumber))
                {
                    if (otPinterface != null) {
                        otPinterface.messageBody(message);
                    }
                }
            }
        }


    }
}
