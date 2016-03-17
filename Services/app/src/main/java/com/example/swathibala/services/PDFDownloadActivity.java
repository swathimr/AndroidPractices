package com.example.swathibala.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PDFDownloadActivity extends AppCompatActivity {

    private final String[] urlLink = new String[] {"http://www.cisco.com/web/about/ac79/docs/innov/IoE_Economy.pdf",
            "http://www.cisco.com/c/dam/en_us/about/ac79/docs/innov/IoE.pdf",
            "http://www.cisco.com/web/strategy/docs/gov/everything-for-cities.pdf",
            "http://www.cisco.com/web/offer/gist_ty2_asset/Cisco_2014_ASR.pdf",
            "http://www.cisco.com/web/offer/emear/38586/images/Presentations/P3.pdf"};

    public static TextView prg1,prg2,prg3,prg4,prg5;
    private EditText inp1,inp2,inp3,inp4,inp5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfdownload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        prg1 = (TextView) findViewById(R.id.prg11);
        prg2 = (TextView) findViewById(R.id.prg2);
        prg3 = (TextView) findViewById(R.id.prg3);
        prg4 = (TextView) findViewById(R.id.prg4);
        prg5 = (TextView) findViewById(R.id.prg5);
     setUrl();
    }

    private void setUrl() {
        inp1=(EditText)findViewById(R.id.textbox1);
        inp1.setText(urlLink[0]);
        inp2=(EditText)findViewById(R.id.textbox2);
        inp2.setText(urlLink[1]);
        inp3=(EditText)findViewById(R.id.textbox3);
        inp3.setText(urlLink[2]);
        inp4=(EditText)findViewById(R.id.textbox4);
        inp4.setText(urlLink[3]);
        inp5=(EditText)findViewById(R.id.textbox5);
        inp5.setText(urlLink[4]);
    }

    public void startDownload(View view)
    {
        Intent intent=new Intent(this,MyService.class);
        intent.putExtra("url1",inp1.getText().toString());
        intent.putExtra("url2", inp2.getText().toString());
        intent.putExtra("url3",inp3.getText().toString());
        intent.putExtra("url4", inp4.getText().toString());
        intent.putExtra("url5",inp5.getText().toString());
        startService(intent);
        //stopService(intent);
    }

    public void exitApp(View view)
    {
        finish();
    }

    /*public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }*/

}
