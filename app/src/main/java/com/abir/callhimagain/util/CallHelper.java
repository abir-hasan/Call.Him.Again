package com.abir.callhimagain.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;


public class CallHelper {
    private Context ctx;
    private CallStateListener callStateListener;

    public CallHelper(Context ctx) {
        this.ctx = ctx;
        callStateListener = new CallStateListener();
    }

    /**
     * Start calls detection.
     */
    public void start() {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL);
        ctx.registerReceiver(callStateListener, intentFilter);
    }

    /**
     * Stop calls detection.
     */
    public void stop() {
        ctx.unregisterReceiver(callStateListener);
    }

}
