package com.hidiki.afro.afro;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Database extends AppCompatActivity {

    Cursor c = null;
    TextView text;
    DatabaseHelper myDbHelper;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        lv=(ListView)findViewById(R.id.list);

        myDbHelper = new DatabaseHelper(Database.this);
        try {
            myDbHelper.createDataBase();
        } catch (Exception ioe) {

            text.append("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            text.append("Open Error");
        }
        Toast.makeText(Database.this, "Success", Toast.LENGTH_SHORT).show();
        mList();
    }
    private void mList(){
        /*
        * cette fontion fait retourner data de la base de données dans un cursor
        * pour chaque row de cursor on ajoutant les données a la list
        *
        * */
        final ArrayList<String> list= new ArrayList<>();
        Cursor cu = myDbHelper.getData();
        while(cu.moveToNext()){
            list.add(cu.getString(1)+" ("+cu.getString(2)+")");
        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(Database.this,Info.class);
                intent.putExtra("id",i);
                startActivity(intent);
            }
        });
        cu.close();
        myDbHelper.close();
    }
}
