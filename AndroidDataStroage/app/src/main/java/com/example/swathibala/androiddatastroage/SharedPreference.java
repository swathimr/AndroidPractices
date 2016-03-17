package com.example.swathibala.androiddatastroage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedPreference extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String bookname = "bookname";
    public static final String author = "author";
    public static final String description = "description";
    SharedPreferences sharedpreferences;
    private EditText ed1,ed2,ed3;
    public int counter=0;
    private SimpleDateFormat dtfrmt=new SimpleDateFormat("MM/dd/yyyy-hh:mm a");
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void SharedPrefSave(View view)
    {
        ed1=(EditText)findViewById(R.id.textbox1);
        ed2=(EditText)findViewById(R.id.textbox2);
        ed3=(EditText)findViewById(R.id.textbox3);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(bookname, ed1.getText().toString());
        editor.putString(author, ed2.getText().toString());
        editor.putString(description, ed3.getText().toString());
        editor.commit();
        counter=counter+1;
        main.tx1.append("Save Preference " + counter + "," + dtfrmt.format(new Date()).toString()+"\n");
        finish();
        //startActivity(intent);
    }
}
