package com.abir.callhimagain;

import android.telephony.PhoneStateListener;

/**
 * Created by Abir Hasan on 13-Dec-16.
 */

public class CallStateListener extends PhoneStateListener {
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);
    }
}
