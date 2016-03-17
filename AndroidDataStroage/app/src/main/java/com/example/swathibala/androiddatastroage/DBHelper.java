package com.example.swathibala.androiddatastroage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SwathiBala on 3/8/16.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "FirstDB";
    public static final String TABLE_NAME = "BookInfo";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME_BOOK_NAME = "bookname";
    public static final String COLUMN_NAME_BOOK_AUTHOR = "bookauthor";
    public static final String COLUMN_NAME_DESCRIPTION= "description";
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_BOOK_NAME + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_BOOK_AUTHOR + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_DESCRIPTION + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context ctxt)
    {
    super(ctxt,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
