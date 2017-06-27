package com.melayer.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getExtras() != null) {
            if (intent.getExtras().getBoolean("state", false)) {
                Toast.makeText(context, "On", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Off", Toast.LENGTH_SHORT).show();
            }
        }

        Toast.makeText(context, "Custom Broadcast", Toast.LENGTH_SHORT).show();
    }
}
