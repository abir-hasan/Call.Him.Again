package com.abir.callhimagain.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Abir Hasan on 13-Dec-16.
 */


public class CallStateListener extends BroadcastReceiver {
    public CallStateListener() {
    }

    private boolean noCallListenerYet = true;

    @Override
    public void onReceive(final Context context, Intent intent) {
        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if (noCallListenerYet) {
            final TelephonyManager tm = (TelephonyManager) context.getSystemService(
                    Context.TELEPHONY_SERVICE);
            tm.listen(new PhoneStateListener() {
                @Override
                public void onCallStateChanged(int state, String incomingNumber) {
                    switch (state) {
                        case TelephonyManager.CALL_STATE_RINGING:
                            Log.d("OutgoingReceiver", "RINGING");
                            break;
                        case TelephonyManager.CALL_STATE_OFFHOOK:
                            Log.d("OutgoingReceiver", "OFFHOOK");
                            break;
                        case TelephonyManager.CALL_STATE_IDLE:
                            Log.d("OutgoingReceiver", "IDLE");
                            break;
                        default:
                            Log.d("OutgoingReceiver", "Default: " + state);
                            break;
                    }
                }
            }, PhoneStateListener.LISTEN_CALL_STATE);
            noCallListenerYet = false;
        }
    }
}