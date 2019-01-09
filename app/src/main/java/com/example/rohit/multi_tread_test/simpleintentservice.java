package com.example.rohit.multi_tread_test;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentSender;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ROHIT on 1/4/2019.
 */

public class simpleintentservice extends IntentService {

    public simpleintentservice() {
        super("simpleintentservice");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        SystemClock.sleep(3000);
        String msg = intent.getStringExtra("imsg");
        Log.d("onhandel", "onHandleIntent:"+msg);

        Intent broadcastintent = new Intent();
        broadcastintent.setAction(responsereciver.Action);
        broadcastintent.putExtra("omsg","done:sup");
        sendBroadcast(broadcastintent);

    }
}
