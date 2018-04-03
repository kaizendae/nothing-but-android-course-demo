package com.hidiki.afro.afro;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Info extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        db = new DatabaseHelper(this);
        try {
            db.openDataBase();
        } catch (SQLException sqle) {
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }

        TextView text=(TextView)findViewById(R.id.text);
        Intent intent = getIntent();

        int index=intent.getIntExtra("id",0);       //requperation de l'id cliquée par l'utilisateur

        Cursor cu = db.select(index+1);     //recuperation des données

        cu.moveToFirst();
        text.setText(
                "ISO         \t\t\t:"+ cu.getString(1)+"\n"
                        +"Name       \t\t:"+cu.getString(3)+"\n"
                        +"ISO3       \t\t\t:"+cu.getString(4)+"\n"
                        +"Num Code  \t:"+cu.getString(5)+"\n"
                        +"Phone Code :"+cu.getString(6)+"\n");

        this.setTitle(cu.getString(2));
        cu.close();
        db.close();
    }
}
