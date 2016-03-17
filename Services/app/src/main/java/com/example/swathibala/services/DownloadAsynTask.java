package com.example.swathibala.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by SwathiBala on 3/13/16.
 */
public class DownloadAsynTask extends AsyncTask<String, Integer, String>{

    public Context myCtx;

    public DownloadAsynTask(Context ctxt)
    {
    myCtx=ctxt;
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }


    @Override
        protected String doInBackground(String... sUrl) {

            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(sUrl[0]);
                String urlVal=sUrl[0];
                String fileName = urlVal.substring( urlVal.lastIndexOf('/')+1, urlVal.length() );
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                // expect HTTP 200 OK, so we don't mistakenly save error report
                // instead of the file
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage();
                }

                int fileLength = connection.getContentLength();
                System.out.println(fileLength);
                // download the file
                InputStream input = connection.getInputStream();
                if (input == null) {
                    System.out.println("input is null");
                }
                System.out.println(isExternalStorageWritable());
                System.out.println(Environment.getExternalStorageDirectory().getParentFile());
                File tm = new File("sdcard/1");
                tm.mkdir();
                System.out.println(tm.getAbsolutePath());
                tm.setWritable(true);
                System.out.println(tm.exists());
                File out = new File(tm,fileName);
                output = new FileOutputStream(out);

                byte data[] = new byte[4096];
                long total = 0;
                int count=0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    if (fileLength > 0) // only if total length is known
                    {
                     publishProgress((int) (total * 100 / fileLength));}
                    output.write(data, 0, count);
                }
                input.close();
            } catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (output != null)
                        output.close();

                } catch (IOException ignored) {
                }

                if (connection != null)
                    connection.disconnect();
            }
            return "done";
        }


    protected void onProgressUpdate(Integer... values) {

        //System.out.println(MyService.idVal);
            PDFDownloadActivity.prg1.setText("Progress::"+String.valueOf(values[0]));

    }

    protected void onPostExecute(String result) {
        if (result.equals("done")) {
           Toast.makeText(myCtx,"Downloaded", Toast.LENGTH_LONG).show();
        }
    }

    }
