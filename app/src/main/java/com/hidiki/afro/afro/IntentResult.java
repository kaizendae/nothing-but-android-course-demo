package com.hidiki.afro.afro;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntentResult extends AppCompatActivity {


    private Button Btnadd ;
    private EditText num1;
    private EditText num2;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result);


        Btnadd = (Button)findViewById(R.id.Btnadd);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        res = (TextView)findViewById(R.id.textsum);



    }

    public void OnClickSum(View v){
        String n1 = num1.getText().toString();
        String n2 = num1.getText().toString();

        Intent intent = new Intent(IntentResult.this,IntentResultSecond.class);
        intent.putExtra("n1",n1);
        intent.putExtra("n2",n2);

        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == IntentResult.RESULT_OK){
                String result = data.getStringExtra("result");
                res.setText("La Somme est :" + result);
            }
            if (resultCode == IntentResult.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
