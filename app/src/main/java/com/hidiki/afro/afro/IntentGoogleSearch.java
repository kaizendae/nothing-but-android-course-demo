package com.hidiki.afro.afro;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentGoogleSearch extends AppCompatActivity {

    private Button BtnSearch;
    private EditText QueryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_google_search);

        BtnSearch = (Button)findViewById(R.id.BtnDial);
        QueryText = (EditText)findViewById(R.id.Querytext) ;


    }

    public void onClickSearch(View v) {

        String q = QueryText.getText().toString();
        Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        searchIntent.putExtra(SearchManager.QUERY,q);
        startActivity(searchIntent);

    }
}
