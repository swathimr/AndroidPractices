package com.example.swathibala.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyService extends Service {
    private static final String TAG = "MyService";


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Download Service Started", Toast.LENGTH_LONG).show();
        Bundle intentVal=intent.getExtras();
        String url[]=new String[]{intentVal.getString("url1"),intentVal.getString("url2"),intentVal.getString("url3"),
                intentVal.getString("url4"),intentVal.getString("url5")};

        for (String uri : url) {
            Log.i(TAG,"Downloading Url"+uri);
            new DownloadAsynTask(getApplicationContext()).execute(uri);
        }

        Toast.makeText(getApplicationContext(), "Service Completed", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Download Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
