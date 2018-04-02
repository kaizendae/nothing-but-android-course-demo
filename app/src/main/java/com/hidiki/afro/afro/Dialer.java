package com.hidiki.afro.afro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialer extends AppCompatActivity {

    public static boolean hidden = false;
    private Button BtnCall;
    private  Button BtnDial;
    private EditText PhoneNumber;
    private Button BtnAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);

        Intent intent = getIntent();
        BtnCall = (Button)findViewById(R.id.Btncall);
        PhoneNumber = (EditText)findViewById(R.id.phoneNumber);
        BtnDial = (Button)findViewById(R.id.BtnDial);
        BtnAction = (Button)findViewById(R.id.btnActionbar);

        BtnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hidden){
                    ActionBar AB = getSupportActionBar();
                    AB.show();
                    hidden = false;
                    BtnAction.setText("hide");
                    BtnAction.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }else{
                    ActionBar AB = getSupportActionBar();
                    AB.hide();
                    hidden = true;
                    BtnAction.setText("Show");
                    BtnAction.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }

            }
        });
        BtnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:"+PhoneNumber.getText().toString();
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(uri));
                    startActivity(dialIntent);
                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"Your call has failed...",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });

        BtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:"+PhoneNumber.getText().toString();
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    startActivity(callIntent);
                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"Your call has failed...",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
