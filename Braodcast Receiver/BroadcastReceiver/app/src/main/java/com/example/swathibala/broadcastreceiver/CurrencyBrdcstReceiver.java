package com.example.swathibala.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CurrencyBrdcstReceiver extends BroadcastReceiver {
    public CurrencyBrdcstReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        if (intent.getAction().equals("com.example.broadcast")) {
            System.out.println("I came here");
            String currency = intent.getExtras().getString("currenytype");
            String converted=intent.getExtras().getString("convertedValue");
            String dollar = intent.getExtras().getString("dollarVal");
            MainActivity.result="Dollar Amount " + dollar + " converted to:" + converted +" "+currency;
            System.out.println(MainActivity.result);
            //Toast.makeText(context, "Dollar Amount " + dollar + " converted to:" + converted, Toast.LENGTH_LONG).show();
            //throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}
