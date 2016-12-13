package com.abir.callhimagain;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Abir Hasan on 13-Dec-16.
 */

public class CallStateListener /*extends BroadcastReceiver*/ {

    /*private static final String TAG = "CallStateListener";

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "BLA", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive:()" + intent.getStringExtra(TelephonyManager.EXTRA_STATE));
        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                TelephonyManager.EXTRA_STATE_RINGING)) {

            // Phone number
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            // Ringing state
            // This code will execute when the phone has an incoming call
            Log.v(TAG, "onReceive: Ringing");
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                TelephonyManager.EXTRA_STATE_IDLE)
                || intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                TelephonyManager.EXTRA_STATE_OFFHOOK)) {

            Log.e(TAG, "onReceive: Answered or Disconnected");
            // This code will execute when the call is answered or disconnected
        }

    }*/
}
