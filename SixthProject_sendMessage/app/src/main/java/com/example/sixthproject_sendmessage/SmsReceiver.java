package com.example.sixthproject_sendmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;

public class SmsReceiver extends BroadcastReceiver {

    private TextView receivedMsgTextView;  // Reference to the TextView

    // Constructor to pass the reference to the TextView
    public SmsReceiver(TextView textView) {
        receivedMsgTextView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            if (pdus != null) {
                for (Object pdu : pdus) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                    String sender = smsMessage.getOriginatingAddress();
                    String messageBody = smsMessage.getMessageBody();

                    // Update the received message in the TextView
                    updateReceivedMessage(sender, messageBody);
                }
            }
        }
    }

    private void updateReceivedMessage(String sender, String message) {
        // Display the received message in the TextView
        String currentText = receivedMsgTextView.getText().toString();
        String updatedText = currentText + "\n" + "From: " + sender + "\n" + "Message: " + message;
        receivedMsgTextView.setText(updatedText);
    }
}
