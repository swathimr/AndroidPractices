package com.example.swathibala.currencyconversionbroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ApplyActivity extends AppCompatActivity {

    private TextView view1;
    private TextView view2;
    public static String currencytype = "";
    public static int dollarVal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apply, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        view1=(TextView)findViewById(R.id.textView1);
        view1.setText(String.valueOf(dollarVal));
        view2=(TextView)findViewById(R.id.textView2);
        view2.setText(currencytype);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void callConvert(View view)
    {
        double converted = 0.0;
        if (currencytype.equalsIgnoreCase("Euro")) {
            converted = dollarVal * 0.92;
        } else if (currencytype.equalsIgnoreCase("British Pound")) {
            converted = dollarVal * 0.72;
        } else {
            converted = dollarVal * 67.64;
        }
        Intent intent = new Intent();
        intent.putExtra("convertedValue",String.valueOf(converted));
        intent.putExtra("currenytype",String.valueOf(currencytype));
        intent.putExtra("dollarVal",String.valueOf(dollarVal));
        intent.setAction("com.example.broadcast");
        sendBroadcast(intent);
    }
}
