package com.abir.callhimagain.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Helper class to detect incoming and outgoing calls.
 *
 * @author Moskvichev Andrey V.
 */
public class CallHelper {

    /**
     * Listener to detect incoming calls.
     */
    private class CallStateListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    // called when someone is ringing to this phone

                    Toast.makeText(ctx,
                            "Incoming: " + incomingNumber,
                            Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    /**
     * Broadcast receiver to detect the outgoing calls.
     */
    public class OutgoingReceiver extends BroadcastReceiver {
        public OutgoingReceiver() {
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

    private Context ctx;
    private TelephonyManager tm;
    private CallStateListener callStateListener;

    private OutgoingReceiver outgoingReceiver;

    public CallHelper(Context ctx) {
        this.ctx = ctx;

        callStateListener = new CallStateListener();
        outgoingReceiver = new OutgoingReceiver();
    }

    /**
     * Start calls detection.
     */
    public void start() {
        tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL);
        ctx.registerReceiver(outgoingReceiver, intentFilter);
    }

    /**
     * Stop calls detection.
     */
    public void stop() {
        tm.listen(callStateListener, PhoneStateListener.LISTEN_NONE);
        ctx.unregisterReceiver(outgoingReceiver);
    }

}
