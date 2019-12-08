package com.dsi32g6.Agence_de_voyage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class payement extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editCompanyname,editPhno,editDesignation ,editTextId;
    Button btnAddData;
    private SQLiteDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_payement );

        myDb = new DatabaseHelper( this );
        editName = (EditText) findViewById( R.id.cin );
        editCompanyname = (EditText) findViewById( R.id.nomm );
        editPhno = (EditText) findViewById( R.id.prenom );
        editDesignation = (EditText) findViewById( R.id.numcarte );
        editDesignation = (EditText) findViewById( R.id.pass );
        btnAddData = (Button) findViewById( R.id.btnsave );
        Button button=findViewById( R.id.btnsave );
        Button bt=findViewById( R.id.btncancel );
        button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), Facture.class ) );
            };
        } );

        bt.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), MainActivity.class ) );
            };
        } );
    }}