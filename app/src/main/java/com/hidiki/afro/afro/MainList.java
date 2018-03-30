package com.hidiki.afro.afro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainList extends AppCompatActivity {
    Intent Int;
    String items[] = new String[]{"0 - Dialer Intent","1 - Google Search Intent","2 - Intent Result","3 - WebView + ImageButton","4 - SelectionWidget1","5 - SelectionWidget2",
            "6 - Json Countries" ,"7 - Dialoges" ,"8 - menu + asynctask  " ,"9 - Database SQLite" ,"7 - Dialoges" ,"7 - Dialoges" ,"7 - Dialoges"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);


        final ListView MainList = (ListView) findViewById(R.id.MainList);
        ArrayAdapter<String> adapterForMainList = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        MainList.setAdapter(adapterForMainList);


        MainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Int = new Intent(MainList.this ,Dialer.class);
                        startActivity(Int);
                        break;
                    case 1:
                        Int = new Intent(MainList.this ,IntentGoogleSearch.class);
                        startActivity(Int);
                        break;
                    case 2:
                        Int = new Intent(MainList.this ,IntentResult.class);
                        startActivity(Int);
                        break;
                    case 3:
                        Int = new Intent(MainList.this ,WebView.class);
                        startActivity(Int);
                        break;
                    case 4:
                        Int = new Intent(MainList.this ,SelectionWidget1.class);
                        startActivity(Int);
                        break;
                    case 5:
                        Int = new Intent(MainList.this ,SelectionWidget2.class);
                        startActivity(Int);
                        break;
                    case 6:
                        Int = new Intent(MainList.this ,JsonCountries.class);
                        startActivity(Int);
                        break;
                    case 7:
                        Int = new Intent(MainList.this ,Dialoges.class);
                        startActivity(Int);
                        break;
                    case 8:
                        Int = new Intent(MainList.this ,ChipInfo.class);
                        startActivity(Int);
                        break;
                    case 9:
                        Int = new Intent(MainList.this ,Database.class);
                        startActivity(Int);
                        break;
                }
            }
        });
    }
}
