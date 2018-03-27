package com.hidiki.afro.afro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentResultSecond extends AppCompatActivity {


    private TextView txt;
    private Button btncall;
    public  int res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result_second);


        txt = (TextView)findViewById(R.id.txt);
        btncall = (Button)findViewById(R.id.btnCall);

        if ( getIntent().getExtras() != null) {
            String n1 = getIntent().getExtras().getString("n1");
            String n2 = getIntent().getExtras().getString("n2");


            res = Integer.parseInt(n1) +  Integer.parseInt(n2);

            txt.setText("val 1 :" + n1 +"\n val 2 :"+ n2 + "\n result : "+ res);
        }
    }

    public void OnClickCall(View v){
        Intent returnIntent = new Intent();
        String ress = " " + res;
        returnIntent.putExtra("result",ress);
        setResult(IntentResult.RESULT_OK,returnIntent);
        finish();
    }
}
