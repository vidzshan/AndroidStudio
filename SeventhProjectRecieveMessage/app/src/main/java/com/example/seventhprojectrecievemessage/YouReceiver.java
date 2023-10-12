package com.example.seventhprojectrecievemessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class YouReceiver extends BroadcastReceiver {
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SmsBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Intent Received: " + intent.getAction());
        if (SMS_RECEIVED.equals(intent.getAction())) {
            Bundle dataBundle = intent.getExtras();
            if (dataBundle != null) {
                Object[] mypdu = (Object[]) dataBundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[mypdu.length];

                for (int i = 0; i < mypdu.length; i++) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format = dataBundle.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) mypdu[i], format);
                    } else {
                        messages[i] = SmsMessage.createFromPdu((byte[]) mypdu[i]);
                    }

                    String msg = messages[i].getMessageBody();
                    String phoneNo = messages[i].getOriginatingAddress();

                    if (phoneNo != null && phoneNo.equals("+94783220863")) {
                        // Display message only if it's from the specified number
//                        Toast.makeText(context, "Expected Number", Toast.LENGTH_LONG).show();
                        Toast.makeText(context, "Message: " + msg + "\nNumber: " + phoneNo, Toast.LENGTH_LONG).show();

                        // Send a reply message to +94764520952
                        sendReplyMessage(context, "+94764520952", "Thank you for your message.");
                    } else {

                        Toast.makeText(context, "Invalid Number", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    private void sendReplyMessage(Context context, String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(context, "Reply sent to " + phoneNumber, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, "Failed to send reply", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}