package com.dsi32g6.Agence_de_voyage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText datedep,datevente,garedep,garearriver ,editTextId;
    Button save;
    private SQLiteDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

// Apply the adapter to the spinner
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);

        myDb = new DatabaseHelper(this);


       save = (Button) findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Ligne de voyage")
                        .setMessage("Vous etes d'accord pour les informations de votre voyage ?")


                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), payement.class));
                            }
                        })


                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                AddData();

            }
        });


      //

    }
   public  void AddData() {
       save.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        garedep = (EditText)findViewById(R.id.textView);
                        garearriver = (EditText)findViewById(R.id.textView3);
                        RadioButton aller = findViewById(R.id.radioButton);
                        datedep = (EditText)findViewById(R.id.editText);
                        datevente = (EditText)findViewById(R.id.editText2);
                        Spinner sp = findViewById(R.id.spinner);
                        String gared = garedep.getText().toString();
                        String garear = garearriver.getText().toString();
                        String dated = datedep.getText().toString();
                        String datev = datevente.getText().toString();

                        boolean isInserted = myDb.insertData(gared, garear, dated, datev);
                        if (isInserted == true){
                            startActivity(new Intent(getApplicationContext(), payement.class));
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            garedep.setText("");
                            garearriver.setText("");
                            datedep.setText("");
                            datevente.setText("");
                        }
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }
}
