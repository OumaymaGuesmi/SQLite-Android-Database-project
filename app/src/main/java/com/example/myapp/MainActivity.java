package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText nom;
    EditText prix;
    Button add;
    helper h=new helper(MainActivity.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        prix=findViewById(R.id.prix);
        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produit p=new Produit(nom.getText().toString(),Double.parseDouble(prix
                        .getText().toString()));
                h.insertProduct(p);
                Intent i=new Intent(MainActivity.this,ListeProduit.class);
                startActivity(i);

            }
        });


    }
}