package com.example.madrsa_application;

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
    private static final String ClassName="Class";
     private static String Start ="Start_verse";
    private static final String End="Ending_verse";
      private static  String roll ="Roll";
    private static final String sbqi="Sbqi";
      private static  String mnzil ="Mnzil";




    public MyDBHelper(Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
 db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
          NAME+" TEXT," + ClassName +" Text," +Start +" INTEGER," +End +" INTEGER," +roll +" Text,"+sbqi +" INTEGER,"+mnzil +" INTEGER"+   ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
     db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
     onCreate(db);
    }

    public boolean addContent(String N,int C,int start,int end,String Roll,int Sbqi,int Mnzil){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(NAME,N);
        value.put(ClassName,C);
        value.put(Start,start);
        value.put(End,end);
        value.put(roll,Roll);
        value.put(sbqi,Sbqi);
          value.put(mnzil,Mnzil);
       long result =DB.insert(TABLE_NAME,null,value);
if(result==-1){
return false;
}else{
 return true;
}
    }
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);

    }
    public ArrayList<DB_model_class> getAll(){
        SQLiteDatabase DB=this.getReadableDatabase();
        Cursor c=DB.rawQuery("SELECT * FROM "+TABLE_NAME,null);
      ArrayList<DB_model_class> arrContant=new ArrayList<>();

       while(c.moveToNext()){
             DB_model_class cm=new DB_model_class();
             cm.id=c.getInt(0);
cm.NAME=c.getString(1);
cm.ClassName=c.getInt(2);
cm.Start=c.getInt(3);
cm.End=c.getInt(4);
cm.roll=c.getString(5);
cm.sbqi=c.getInt(6);
cm.mnzil=c.getInt(7);

arrContant.add(cm);
        }
       return arrContant;
    }
}
