package com.example.aotg_v1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Register";

    public DBHelper(RegisterActivity context) {
        super(context, "Register", null, 1);
    }
    public DBHelper(Context context) {
        super(context, "Register", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, fullname TEXT, age TEXT, edubackground TEXT, markquizziz INT, markwordwall INT, markkahoot INT, totalquizziz INT, totalwordwall INT, totalkahoot INT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");

    }
    //to insert data
    public Boolean insertData (String username,String password,String fullname, Integer age, String edubackground){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int zero_value = 0;
        contentValues.put("username", username);
        contentValues.put("password",password);
        contentValues.put("fullname",fullname);
        contentValues.put("age",age);
        contentValues.put("edubackground",edubackground);
        contentValues.put("markquizziz",zero_value);
        contentValues.put("totalquizziz",zero_value);
        contentValues.put("markwordwall",zero_value);
        contentValues.put("totalwordwall",zero_value);
        contentValues.put("markkahoot",zero_value);
        contentValues.put("totalkahoot",zero_value);
        long result = MyDB.insert("users",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean deletedata (String username)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            long result = MyDB.delete("users", "username=?", new String[]{username});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean updateMarksQuizziz (String username, int mark, int total){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("markquizziz",mark);
        contentValues.put("totalquizziz",total);
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if(cursor.getCount()>0) {
            long result = MyDB.update("users", contentValues, "username = ?", new String[]{username});
            if (result == -1) return false;
            else
                return true;
        }
        else{
            return false;
        }
    }

    public Boolean updateMarksWordwall (String username, int mark, int total){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("markwordwall",mark);
        contentValues.put("totalwordwall",total);
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if(cursor.getCount()>0) {
            long result = MyDB.update("users", contentValues, "username = ?", new String[]{username});
            if (result == -1) return false;
            else
                return true;
        }
        else{
            return false;
        }
    }

    public Boolean updateMarksKahoot (String username, int mark, int total){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("markkahoot",mark);
        contentValues.put("totalkahoot",total);
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if(cursor.getCount()>0) {
            long result = MyDB.update("users", contentValues, "username = ?", new String[]{username});
            if (result == -1) return false;
            else
                return true;
        }
        else{
            return false;
        }
    }

    public Boolean updatepassword (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("password", password);
        long result = MyDB.update("users", contentValues,"username = ?",new String[] {username});
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername (String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?",new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public Boolean checkusernamepassword (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public String displayAge (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select age from users where username = ?", new String[] {username});

        String data = "";


        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                data = cursor.getString(cursor.getColumnIndexOrThrow("age"));
                System.out.println(data);
                cursor.moveToNext();
            }
        }else data=null;
        cursor.close();
        return data;
//        return cursor.getString(index);
    }

    public String displayMarksWW (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select markwordwall from users where username = ?", new String[] {username});

        String data = "";


        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                data = cursor.getString(cursor.getColumnIndexOrThrow("markwordwall"));
                System.out.println(data);
                cursor.moveToNext();
            }
        }else data=null;
        cursor.close();
        return data;
//        return cursor.getString(index);
    }

    public String displayTotalWW (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select totalwordwall from users where username = ?", new String[] {username});

        String data = "";


        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                data = cursor.getString(cursor.getColumnIndexOrThrow("totalwordwall"));
                System.out.println(data);
                cursor.moveToNext();
            }
        }else data=null;
        cursor.close();
        return data;
//        return cursor.getString(index);
    }

    public String displayMarksK (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select markkahoot from users where username = ?", new String[] {username});

        String data = "";


        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                data = cursor.getString(cursor.getColumnIndexOrThrow("markkahoot"));
                System.out.println(data);
                cursor.moveToNext();
            }
        }else data=null;
        cursor.close();
        return data;
//        return cursor.getString(index);
    }

    public String displayTotalK (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select totalkahoot from users where username = ?", new String[] {username});

        String data = "";


        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                data = cursor.getString(cursor.getColumnIndexOrThrow("totalkahoot"));
                System.out.println(data);
                cursor.moveToNext();
            }
        }else data=null;
        cursor.close();
        return data;
//        return cursor.getString(index);
    }

    public String displayMarksQ (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursorMQ = MyDB.rawQuery("Select markquizziz from users where username = ?", new String[] {username});

        String data = "";


        if (cursorMQ.moveToFirst()){
            while(!cursorMQ.isAfterLast()){
                data = cursorMQ.getString(cursorMQ.getColumnIndexOrThrow("markquizziz"));
                System.out.println(data);
                cursorMQ.moveToNext();
            }
        }else data=null;
        cursorMQ.close();
        return data;
//        return cursor.getString(index);
    }

    public String displayTotalQ (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursorTQ = MyDB.rawQuery("Select totalquizziz from users where username = ?", new String[] {username});

        String data = "";


        if (cursorTQ.moveToFirst()){
            while(!cursorTQ.isAfterLast()){
                data = cursorTQ.getString(cursorTQ.getColumnIndexOrThrow("totalquizziz"));
                System.out.println(data);
                cursorTQ.moveToNext();
            }
        }else data=null;
        cursorTQ.close();
        return data;
//        return cursor.getString(index);
    }

    public String displayeduBackground (String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select edubackground from users where username = ?", new String[] {username});

        String data = "";


        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                data = cursor.getString(cursor.getColumnIndexOrThrow("edubackground"));
                System.out.println(data);
                cursor.moveToNext();
            }
        }else data=null;
        cursor.close();
        return data;
//        return cursor.getString(index);
    }





//    public String displayuserName (String username){
//        SQLiteDatabase MyDB = this.getReadableDatabase();
//        Cursor cursor = MyDB.rawQuery("Select edubackground from users where username = ?", new String[] {username});
//
//        String data = "";
//
//
//        if (cursor.moveToFirst()){
//            while(!cursor.isAfterLast()){
//                data = cursor.getString(cursor.getColumnIndexOrThrow("edubackground"));
//                System.out.println(data);
//                cursor.moveToNext();
//            }
//        }else data=null;
//        cursor.close();
//        return data;
////        return cursor.getString(index);
//    }


}
