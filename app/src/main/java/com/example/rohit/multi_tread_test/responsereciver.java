package com.example.rohit.multi_tread_test;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ROHIT on 1/4/2019.
 */

public class responsereciver extends BroadcastReceiver {

    Context Activitycontext;
    public responsereciver(Context context){
        Activitycontext=context;
    }

    public static final String Action = "msgrecived";

    @Override
    public void onReceive(Context context, Intent intent) {

        String s = intent.getStringExtra("omsg");
        Log.d("working", "onReceive: "+s);

        TextView view = (TextView)((Activity)Activitycontext).findViewById(R.id.textview);
        view.setText(s);

    }
}
