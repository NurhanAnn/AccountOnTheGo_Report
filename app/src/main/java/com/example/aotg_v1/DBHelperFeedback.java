package com.example.aotg_v1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHelperFeedback extends SQLiteOpenHelper {
    public static final String DBNAME = "FeedbackData";

    public DBHelperFeedback(FeedbackActivity context) {
        super(context, "FeedbackData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table feedbacks(ETFeedback TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists feedbacks");

    }

    public Boolean insertData (String etFeedback){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("etFeedback", String.valueOf(etFeedback));
        long result = MyDB.insert("feedbacks",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }


}
