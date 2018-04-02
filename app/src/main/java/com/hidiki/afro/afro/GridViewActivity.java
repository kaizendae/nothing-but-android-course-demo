package com.hidiki.afro.afro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class GridViewActivity extends AppCompatActivity {

    private TextView txt;
    String items[] = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine","ten"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        txt = (TextView)findViewById(R.id.txt);
        final GridView MainGrid = (GridView) findViewById(R.id.gdv);


        //arraydapter getting the layout abd the items to show
        ArrayAdapter<String> adapterForMainList = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        MainGrid.setAdapter(adapterForMainList);

        //onclick on an item
        MainGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText("Position:"+position+" element:"+items[position]);
            }
        });

    }
}
