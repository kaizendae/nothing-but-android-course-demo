package com.hidiki.afro.afro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectionWidget2 extends AppCompatActivity {

    ArrayList<Map<String,String>> List;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_widget2);

        txt = (TextView)findViewById(R.id.txt);
        final ListView MainList = (ListView) findViewById(R.id.MainList);

        List = buildData();
        String[] from = { "nom", "tel" };
        int[] to = {android.R.id.text1, android.R.id.text2 };
        SimpleAdapter adapter = new SimpleAdapter(this,List,android.R.layout.simple_list_item_2, from, to);

        MainList.setAdapter(adapter);


        MainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, String> pair =List.get(position);
                txt.setText("Nom : "+ pair.get("nom")+" Tél : "+ pair.get("tel"));

            }
        });
    }

    private ArrayList<Map<String,String>>buildData(){
        ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
        list.add(putData("hanan", "0643543423"));
        list.add(putData("salma", "0671432345"));
        list.add(putData("rachid", "0654123655"));
        list.add(putData("azdin", "0644563423"));
        list.add(putData("yassin", "0671432986"));
        list.add(putData("Rachid", "0654556655"));
        list.add(putData("med", "0643545483"));
        list.add(putData("Hamid", "0671125845"));
        list.add(putData("laila", "0654556689"));
        list.add(putData("fatima", "0671432412"));
        list.add(putData("zahra", "061455153"));

        return list;
    }

    private HashMap<String, String> putData(String name, String ntel) {
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("nom", name);
        item.put("tel", ntel);
        return item;
    }

}
