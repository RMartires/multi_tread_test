package com.example.rohit.multi_tread_test;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    responsereciver responsereciver1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button =findViewById(R.id.click);

        final Intent intent = new Intent(this,simpleintentservice.class);
        intent.putExtra("imsg","sup");

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(responsereciver.Action);
        responsereciver1 = new responsereciver(this);
        registerReceiver(responsereciver1,intentFilter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
                //SystemClock.sleep(3000);
                Log.d("click", "onClick:");
            }
        });

    }
}
