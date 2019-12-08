package com.dsi32g6.Agence_de_voyage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "voyage.db";
    public static final String TABLE_NAME = "EMP_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATEDEP";
    public static final String COL_3 = "DATEV";
    public static final String COL_4 = "GARED";
    public static final String COL_5 = "GAREARRIVER";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATEDEP TEXT,DATEV TEXT,GARED TEXT," +
                "GAREARRIVER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String DATEDEP,String DATEV,String GARED,String GAREARRIVER) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,DATEDEP);
        contentValues.put(COL_3,DATEV);
        contentValues.put(COL_4,GARED);
        contentValues.put(COL_5,GAREARRIVER);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME ,null);
        return res ;
    }

    public boolean updateData(String Cin,String Nom,String Prenom,String Gare_de_départ,String Gared_arriver,String Date_de_départ,String Date_de_vente,int Numéro_de_voyage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,Cin);
        contentValues.put(COL_2,Nom);
        contentValues.put(COL_3,Prenom);
        contentValues.put(COL_4,Gare_de_départ);
        contentValues.put(COL_5,Gared_arriver);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { Cin });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
