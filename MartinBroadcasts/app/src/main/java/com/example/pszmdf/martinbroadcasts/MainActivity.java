package com.example.pszmdf.martinbroadcasts;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST_PROCESS_CALLS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.PROCESS_OUTGOING_CALLS)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.PROCESS_OUTGOING_CALLS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Log.d("g53mdp", "explanation required");
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},MY_PERMISSIONS_REQUEST_PROCESS_CALLS
                        );
                Log.d("g53mdp", "explanation not needed");
            }
        }

        LocalBroadcastReceiver receiver = new LocalBroadcastReceiver();
        IntentFilter filter = new IntentFilter("com.example.pszmdf.martinbroadcasts.MY_LOCAL_CUSTOM_BROADCAST");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }

    public void onClickBroadcast(View v) {
        Intent intent = new Intent(this, CustomBroadcastReceiver.class);
        intent.setAction("com.example.pszmdf.martinbroadcasts.MY_CUSTOM_BROADCAST");
        sendBroadcast(intent);
    }

    public void onClickLocalBroadcast(View v) {
        Intent intent = new Intent();
        intent.setAction("com.example.pszmdf.martinbroadcasts.MY_LOCAL_CUSTOM_BROADCAST");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_PROCESS_CALLS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("g53mdp", "permission granted");
                } else {
                    Log.d("g53mdp", "permission denied");
                }
                return;
            }
        }
    }
}
