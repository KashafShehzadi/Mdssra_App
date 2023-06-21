/*package com.example.madrsa_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_Name="StudentDB";
    private static final String TABLE_NAME="StudentTable";
    private static final String id="id";
    private static final String NAME="Name";
    private static final String Class="Class";
     private static int String Start ="Name";
    private static final String End="Class";


    public MyDBHelper(Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
 db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
          NAME+" TEXT," + Phone+" Text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
     db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
     onCreate(db);
    }

    public void addContent(String N,String P){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(NAME,N);
        value.put(Phone,P);
        DB.insert(TABLE_NAME,null,value);

    }
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);

    }
    public ArrayList<ContactModel> getContact(){
        SQLiteDatabase DB=this.getReadableDatabase();
        Cursor c=DB.rawQuery("SELECT * FROM "+TABLE_NAME,null);
      ArrayList<ContactModel> arrContant=new ArrayList<>();

       while(c.moveToNext()){
             ContactModel cm=new ContactModel();
             cm.id=c.getInt(0);
cm.NAME=c.getString(1);
cm.Phone=c.getString(2);

arrContant.add(cm);
        }
       return arrContant;
    }
}
*/