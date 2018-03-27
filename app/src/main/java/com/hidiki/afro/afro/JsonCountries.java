package com.hidiki.afro.afro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JsonCountries extends AppCompatActivity {

    private ArrayList<Country> Countries=new ArrayList<Country>();

    private ArrayList<String> items = new ArrayList<String>();
    private ListView MainList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_countries);

        MainList = (ListView) findViewById(R.id.MainList);


        try{
            ArrayList<Country> countries = getDataJson(this,R.raw.countires);
            for(int i=0;i<countries.size();i++){
                Country cou = countries.get(i);
                items.add(cou.name + "   code : " + cou.code);
            }
        }
        catch(JSONException e){

        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        MainList.setAdapter(arrayAdapter);

    }


    public String stream2string(InputStream stream) {
        String line, result = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {}
        return result;
    }

    public ArrayList<Country> getDataJson(Context context, int fichier) throws JSONException{

        //Création d'une liste de Countrys
        ArrayList<Country> Countries=new ArrayList<Country>();

        //Lecture de fichier donnees.json de /res/raw
        InputStream is = getResources().openRawResource(R.raw.countires);

        //Convertir le contenu du fichier donnees.json en une chaîne de caractère
        String rawJson = stream2string(is);

        //Instancier un objet JSON
        JSONObject obj_JSON=new JSONObject(rawJson);

        //Récupération d'un tableau des objets JSON contenus dans "countries«
        JSONArray array_JSON = obj_JSON.getJSONArray("countries");

        //pour chaque country
        for(int i=0;i<array_JSON.length();i++){

        //Instanciation d'un objet Country
            Country country=new Country();

        //Pour le ième Country
            JSONObject ob_per= array_JSON.getJSONObject(i);
            country.name = ob_per.getString("name");
            country.code = ob_per.getString("code");

        //l'ajout de Country dans la liste
            Countries.add(country);
        }
        return Countries;
    }
}
