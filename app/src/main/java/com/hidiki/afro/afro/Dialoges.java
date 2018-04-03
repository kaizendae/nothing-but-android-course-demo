package com.hidiki.afro.afro;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dialoges extends AppCompatActivity {


    private TextView Txt;
    public ArrayList<Integer> mSelectedItems ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialoges);


        Txt = (TextView)findViewById(R.id.dialogtxt);


    }

    public void onClickSingleChoice(View v){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(R.array.couleurs,0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                String[] clrs = getResources().getStringArray(R.array.couleurs);
                switch(which){
                    case 0 :
                        Txt.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case 1 :
                        Txt.setTextColor(getResources().getColor(R.color.green));
                        break;
                    case 2:
                        Txt.setTextColor(getResources().getColor(R.color.yellow));
                        break;
                    case 3 :
                        Txt.setTextColor(getResources().getColor(R.color.purple));
                        break;
                    case 4 :
                        Txt.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case 5 :
                        Txt.setTextColor(getResources().getColor(R.color.black));
                        break;
                }
                Txt.setText("Single color : " + clrs[which]);
            }
        });
        builder.show();
    }

    public void onClickMultipleChoice(View v){

        mSelectedItems = new ArrayList();

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(R.array.countries_array, null,new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which,boolean isChecked) {
                if (isChecked) {// Si l'utlisateur a couché un Item.
                        mSelectedItems.add(which);
                }else{
                    for (int i:mSelectedItems ) {
                        if(i == which){
                            int index = mSelectedItems.indexOf(i);
                            mSelectedItems.remove(index);
                        }
                    }
                }
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] cntrs = getResources().getStringArray(R.array.countries_array);
                String Output = "Selected : " ;

                for (int i:mSelectedItems ) {
                    Output = Output + " " + cntrs[i];
                }
                Txt.setText(Output);
            }
        });


        builder.show();
    }
    public void onClickCustom(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        View mView = getLayoutInflater().inflate(R.layout.fragment_dialog,null);

        final EditText EMail = (EditText) mView.findViewById(R.id.username);
        final EditText Epass = (EditText) mView.findViewById(R.id.password);
        Button LogBtn = (Button) mView.findViewById(R.id.BtnLogin);

        LogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!EMail.getText().toString().isEmpty() && !Epass.getText().toString().isEmpty()){
                    Toast.makeText(Dialoges.this,"Email : " + EMail.getText().toString() + " Password : "+ Epass.getText().toString(),Toast.LENGTH_SHORT).show();
                    Txt.setText("Email : " + EMail.getText().toString() + " Password : "+ Epass.getText().toString());
                } else{
                    Toast.makeText(Dialoges.this,"Please fill any empty data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setView(mView);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void onClickListAlert(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Choisissez une couleur ?");

        builder.setItems(R.array.couleurs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0 :
                        Txt.setTextColor(getResources().getColor(R.color.red));
                        break;
                    case 1 :
                        Txt.setTextColor(getResources().getColor(R.color.green));
                        break;
                    case 2:
                        Txt.setTextColor(getResources().getColor(R.color.yellow));
                        break;
                    case 3 :
                        Txt.setTextColor(getResources().getColor(R.color.purple));
                        break;
                    case 4 :
                        Txt.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case 5 :
                        Txt.setTextColor(getResources().getColor(R.color.black));
                        break;
                }

                String[] clrs = getResources().getStringArray(R.array.couleurs);
                Txt.setText("couleur choix : " + clrs[which]);
            }
        });

        builder.show();

    }
    public void onClickAlert(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(Dialoges.this).create();
        alertDialog.setTitle("le titre ");
        alertDialog.setMessage("message de l'alert !!!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "annuler",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        Txt.setText("alert dialog : annuler");
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        Txt.setTextColor(getResources().getColor(R.color.red));
                        Txt.setText("alert dialog : No");
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OUI",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        Txt.setTextColor(getResources().getColor(R.color.green));
                        Txt.setText("alert dialog : OUI");
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
