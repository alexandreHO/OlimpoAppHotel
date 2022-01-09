package br.unip.olimpo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DBHelper extends SQLiteOpenHelper {

    public static  final String DBNAME = "OlimpoHotel.db";

    public DBHelper(Context context){
        super(context, "OlimpoHotel.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("CREATE TABLE users(email TEXT primary key, password TEXT, name TEXT, CPF TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        MyDB.execSQL("DROP TABLE IF EXISTS users");

    }

    public Boolean insertData(String email, String password, String name, String CPF){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("CPF", CPF);
        long result = MyDB.insert("users", null, contentValues);
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkCPF(String CPF){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE CPF= ?", new String[] {CPF});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkUserName(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE email= ?", new String[] {email});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkUserNamePassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE email = ? and password = ?",
                new String[] {email, password});
        if (cursor.getCount()>0)
            return true;

        else
            return false;

    }

}

