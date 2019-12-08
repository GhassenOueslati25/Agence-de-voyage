package com.dsi32g6.Agence_de_voyage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Facture extends AppCompatActivity {
    Button btnfetch;
    DatabaseHelper myDb;
    private View main;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture);
        myDb = new DatabaseHelper(this);
        btnfetch=(Button)findViewById(R.id.button2);
        viewAll();


       


    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void viewAll() {
        btnfetch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Alert","Nothing found");
                            return;
                        }

                        while (res.moveToNext()) {

                            EditText d1=findViewById( R.id.date_Vente );
                            EditText d2=findViewById( R.id.date_Voyage );
                            EditText d5=findViewById( R.id.dte_dep);
                            EditText d4=findViewById( R.id.arr );
                            EditText d3=findViewById( R.id.num_voy );
                            d1.setText( res.getString(3) );
                            d2.setText( res.getString(4) );
                            d3.setText( res.getString(0) );
                            d4.setText( res.getString(1) );
                            d5.setText( res.getString(2) );
                            TextView t1=findViewById( R.id.attr);
                            t1.setText( "r"+Math.round(Math.random() * ( 3333 - 33 ) ));
                            EditText s=findViewById( R.id.somme );
                            s.setText( Math.round(Math.random() * ( 23 - 1 ) )+"00");
                        }

                    }
                });
    }
}