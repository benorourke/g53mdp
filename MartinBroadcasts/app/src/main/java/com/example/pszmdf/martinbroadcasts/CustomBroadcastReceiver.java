package com.example.pszmdf.martinbroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("g53mdp", "CustomBroadcastReceiver onReceive custom");
        Toast.makeText(context, "custom broadcast received", Toast.LENGTH_LONG).show();

        // why would you want to do this?
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

        abortBroadcast();
    }
}