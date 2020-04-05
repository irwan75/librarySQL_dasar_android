package com.example.learnsqldatabase.model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.learnsqldatabase.dao.obPengguna;

import java.util.ArrayList;

public class tbPengguna {

    SQLiteDatabase db;

    public tbPengguna(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertData(String nama, String no_hp) {
        String query = "insert into pengguna(nama, no_hp) values('" + nama + "'," + no_hp + ");";
        db.execSQL(query);
    }

    public void updateData(String no_hp_baru, String no_hp_lama) {
        String query = "update pengguna set no_hp = " + no_hp_baru + " where no_hp = " + no_hp_lama + ";";
        db.execSQL(query);
    }

    public void deleteData(String no_hp) {
        String query = "delete from pengguna where no_hp = " + no_hp + ";";
        db.execSQL(query);
    }

    public ArrayList<String> select() {
        ArrayList<String> noname = new ArrayList<>();

        String query = "select *from pengguna";
        Cursor cursor = db.rawQuery(query, null);;

        while (cursor.moveToNext()) {
            String nama = cursor.getString(1);
            noname.add(nama);
        }

        cursor.close();

        return noname;
    }

    public obPengguna selectBy(String no_hpp){
        obPengguna obp = null;
        String query = "select *from pengguna where no_hp = "+no_hpp+";";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nama = cursor.getString(1);
            String no_hp = cursor.getString(2);
//            ArrayList<obPengguna> all = new ArrayList<>();
//            all.add(new obp(id, nama, no_hp));
            obp = new obPengguna(id, nama, no_hp);
        }
        return obp;
    }
}
