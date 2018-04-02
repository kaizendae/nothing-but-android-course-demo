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
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private HashMap<String, String> putData(String s1, String s2,String s3, String s4, String s5) {
        //Création d'une HashMap pour insérer les informations d’un item de notre listView
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("iso", s1);

        map.put("name", s2);

        map.put("iso3", s3);

        map.put("numcode", "NumCode : " + s4);

        map.put("numphone", "PhoneCode : " + s5);

        return map;
    }

    private void mList(){
        /*
        * cette fontion fait retourner data de la base de données dans un cursor
        * pour chaque row de cursor on ajoutant les données a la list
        *
        * */

        String[] from = { "iso", "name","iso3", "numcode","numphone" };
        int[] to = { R.id.txtiso, R.id.txtname,R.id.txtiso3, R.id.txtcode,R.id.txtphone  };


        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        //final ArrayList<String> list= new ArrayList<>();

        Cursor cu = myDbHelper.getData();
        while(cu.moveToNext()){
            //String[] Holder = {cu.getString(1),cu.getString(2),cu.getString(3),cu.getString(4),cu.getString(5)};
            list.add(putData(cu.getString(1),cu.getString(2),cu.getString(4),cu.getString(5),cu.getString(6)));
        }

        SimpleAdapter adapter = new SimpleAdapter (this, list, R.layout.itemcustom,from,to);

        //ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
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
