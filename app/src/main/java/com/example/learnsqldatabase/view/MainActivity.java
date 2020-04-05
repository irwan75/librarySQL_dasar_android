package com.example.learnsqldatabase.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.learnsqldatabase.R;
import com.example.learnsqldatabase.controller.SQLLiteHelper;
import com.example.learnsqldatabase.model.tbPengguna;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTablePengguna;

    ArrayList<String> data;

    SQLLiteHelper helper;
    SQLiteDatabase db;
    tbPengguna tbp;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTablePengguna = findViewById(R.id.lvTablePengguna);

        helper = new SQLLiteHelper(getApplicationContext());
        db = helper.getReadableDatabase();

        tbp = new tbPengguna(db);
//        tbp.insertData("Nina","123456789123");
//        tbp.insertData("Ambo","087263562712");
//        tbp.insertData("Lita","763829102938");
//        tbp.deleteData("087263562712");
//        tbp.updateData("123456789876","763829102938");

        data = tbp.select();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);

        lvTablePengguna.setAdapter(adapter);

    }

}
