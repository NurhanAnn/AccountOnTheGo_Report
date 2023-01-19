package com.example.aotg_v1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHelperFAQ extends SQLiteOpenHelper {
    public static final String DBNAME = "FAQData";

    public DBHelperFAQ(FAQ_mainActivity context) {
        super(context, "FAQData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MYDB) {
        MYDB.execSQL("create Table faq(ETQuestion TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MYDB, int oldVersion, int newVersion) {
        MYDB.execSQL("drop Table if exists faq");

    }

    public Boolean insertData (String etFAQ){
        SQLiteDatabase MYDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ETQuestion", String.valueOf(etFAQ));
        long result = MYDB.insert("faq",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }


}
