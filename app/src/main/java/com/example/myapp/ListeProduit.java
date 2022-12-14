package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListeProduit extends AppCompatActivity {

    Button prodadd;
    ListView list;
    helper h=new helper(ListeProduit.this);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produit);
        list=findViewById(R.id.list);
        Cursor c=h.getAllProducts();
        prodadd=findViewById(R.id.prodadd);
        SimpleCursorAdapter adapter= new SimpleCursorAdapter(ListeProduit.this,R.layout.item,c,new String[]{c.getColumnName(0),c.getColumnName(1),c.getColumnName(2)},new int[]{R.id.id,R.id.nom,R.id.prix},1);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView t=view.findViewById(R.id.id);
                Intent x=new Intent(ListeProduit.this,DetailProduit.class);
                x.putExtra("id",t.getText().toString());
                startActivity(x);
            }
        });
        prodadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ListeProduit.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}