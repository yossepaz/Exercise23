package com.ypaz.exercise23.Configuration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConexion extends SQLiteOpenHelper {

    public static final String nameDataBase = "PM12PE23";
    public static final int versionDataBase = 1;
    public static final String tableName = "photos";
    public static final String columnid = "Id";
    public static final String columnphoto = "photo";
    public static final String columndescription = "description";
    public static final String CreateTable =
            "CREATE TABLE " + tableName + "(" +
                    columnid + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    columnphoto + " BLOB," +
                    columndescription + " TEXT" +
                    ")";
    public static final String DropTablePhotos = "DROP TABLE IF EXISTS " + tableName;

    public static final String SelectTablePhotos= "SELECT * FROM " + tableName;


    public SQLiteConexion(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory) {
        super(context, nameDataBase, factory, versionDataBase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creacion de objetos de bases de datos
        db.execSQL(CreateTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DropTablePhotos);
        onCreate(db);
    }


}
