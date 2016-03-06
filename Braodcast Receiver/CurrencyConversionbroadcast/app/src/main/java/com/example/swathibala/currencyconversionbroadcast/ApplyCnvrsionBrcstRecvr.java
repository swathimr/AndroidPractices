package com.example.swathibala.currencyconversionbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class ApplyCnvrsionBrcstRecvr extends BroadcastReceiver {

    public ApplyCnvrsionBrcstRecvr() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals("com.example.sendbroadcast")) {
            System.out.println("I came here");
            String currency = intent.getExtras().getString("currenytype");
            int dollar = intent.getExtras().getInt("dollarVal");
            ApplyActivity.currencytype=currency;
            ApplyActivity.dollarVal=dollar;
            System.out.println(ApplyActivity.currencytype);
            System.out.println(ApplyActivity.dollarVal);
        }
    }
}
