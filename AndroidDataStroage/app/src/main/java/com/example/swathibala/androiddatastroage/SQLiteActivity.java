package com.example.swathibala.androiddatastroage;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteActivity extends AppCompatActivity {

    DBHelper mdb;
    SQLiteDatabase db;
    private EditText nameval,author,description;
    public static int counter=0;
    private SimpleDateFormat dtfrmt=new SimpleDateFormat("MM/dd/yyyy-hh:mm a");
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
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
        mdb=new DBHelper(getBaseContext());
    }

    public void Sqlsave(View view)
    {
        nameval=(EditText)findViewById(R.id.textbox1);
        author=(EditText)findViewById(R.id.textbox2);
        description=(EditText)findViewById(R.id.textbox3);
        System.out.println(nameval.getText()+"::"+author.getText()+"::"+description.getText());
        ContentValues values= new ContentValues();
        //values.put(mdb.COLUMN_ID,id);
        values.put(DBHelper.COLUMN_NAME_BOOK_NAME, nameval.getText().toString());
        values.put(DBHelper.COLUMN_NAME_BOOK_AUTHOR, author.getText().toString());
        values.put(DBHelper.COLUMN_NAME_DESCRIPTION, description.getText().toString());
        int countVal=StoreInToSQLite(values);
        MainActivity.tx1.append("SQLite " + countVal + " , " + dtfrmt.format(new Date()).toString() + "\n");
        finish();
    }

    public int StoreInToSQLite(ContentValues value) {
        db = mdb.getWritableDatabase();
        long newRowId;
        newRowId = db.insert(
                DBHelper.TABLE_NAME,
                null,
                value);
        System.out.println(newRowId);

        // for my reference on how to read
        db = mdb.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from BookInfo where bookname='test'", null );
        if (res != null)
            res.moveToFirst();
        //System.out.println(res.getString(0)+"::"+res.getString(1)+" , "+res.getString(2));
        counter++;
        return counter;
    }

}
