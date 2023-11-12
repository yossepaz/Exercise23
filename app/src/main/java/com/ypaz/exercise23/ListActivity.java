package com.ypaz.exercise23;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.widget.ListView;


import com.ypaz.exercise23.Configuration.ListAdapter;
import com.ypaz.exercise23.Configuration.Photograh;
import com.ypaz.exercise23.Configuration.SQLiteConexion;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    List<Photograh> mData = new ArrayList<>();
    ListAdapter mAdapter;
    SQLiteConexion conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, null);

        listView = (ListView) findViewById(R.id.listView);
        obtenerTabla();
        mAdapter = new ListAdapter(ListActivity.this,mData);
        listView.setAdapter(mAdapter);
    }

    private void obtenerTabla() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Photograh photograh = null;
        //Cursor de base de datos
        Cursor cursor = db.rawQuery(SQLiteConexion.SelectTablePhotos,null);

        //Recorremos el cursor
        while (cursor.moveToNext()){
            photograh = new Photograh();
            photograh.setId(cursor.getString(0));
            photograh.setDescription(cursor.getString(2));
            mData.add(photograh);
        }
        cursor.close();
    }
}