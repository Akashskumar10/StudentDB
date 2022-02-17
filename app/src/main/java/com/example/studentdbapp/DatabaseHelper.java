package com.example.studentdbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String DbName = "College.db";
    static String TableName = "Student";
    static String Col1 = "ID";
    static String Col2 = "Name";
    static String Col3 = "RollNO";
    static String Col4 = "AdmNO";
    static String Col5 = "College";

    public DatabaseHelper(Context context) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TableName + "("+Col1+ " integer primary key autoincrement," +
                Col2 + " text," +
                Col3 + " text," +
                Col4 + " text," +
                Col5 + " text)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String Name, String RollNo, String AdmNo, String College) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(Col2, Name);
        content.put(Col3, RollNo);
        content.put(Col4, AdmNo);
        content.put(Col5, College);

        long status = db.insert(TableName, null, content);

        if (status==-1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor Search(String AdmNo)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+TableName+" where " +Col4+" ='"+AdmNo+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }
}
