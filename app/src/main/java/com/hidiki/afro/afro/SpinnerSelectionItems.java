package com.hidiki.afro.afro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerSelectionItems extends AppCompatActivity {

    private TextView txt;
    String items[] = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine","ten"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_selection_items);


        txt = (TextView)findViewById(R.id.txt);
        final Spinner MainSpinner = (Spinner) findViewById(R.id.spinnerID);


        //arraydapter getting the layout abd the items to show
        ArrayAdapter<String> adapterForMainList = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);

        adapterForMainList.setDropDownViewResource(android.R.layout.simple_spinner_item);

        MainSpinner.setAdapter(adapterForMainList);

        //onclick on an item
        MainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    txt.setText("Position: "+position+"\nelement:"+items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                txt.setText("Nothing Selected");
            }
        });
    }
}
