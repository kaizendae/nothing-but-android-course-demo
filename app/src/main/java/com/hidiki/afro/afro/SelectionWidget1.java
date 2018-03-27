package com.hidiki.afro.afro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;


public class SelectionWidget1 extends AppCompatActivity {

    ArrayList<Map<String,String>> List;
    private TextView txt;
    String items[] = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine","ten"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_widget1);

        txt = (TextView)findViewById(R.id.txt);
        final ListView MainList = (ListView) findViewById(R.id.MainList);
        ArrayAdapter<String> adapterForMainList = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        MainList.setAdapter(adapterForMainList);


        MainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText("Position:"+position+" element:"+items[position]);
            }
        });

    }
}
