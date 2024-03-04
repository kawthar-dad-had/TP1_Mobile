package com.example.tp1_programmationmobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textNom, textPrenom, textAge, textCompetences, textTelephone;
    String telephone;
    private Button btnOK, btnRetour;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textNom = findViewById(R.id.textNom);
        textPrenom = findViewById(R.id.textPrenom);
        textAge = findViewById(R.id.textAge);
        textCompetences = findViewById(R.id.textCompetences);
        textTelephone = findViewById(R.id.textTelephone);


        btnOK = findViewById(R.id.btnOK);
        btnRetour = findViewById(R.id.btnRetour);

        Intent intent = getIntent();
        if (intent != null) {
            String nom = intent.getStringExtra("nom");
            String prenom = intent.getStringExtra("prenom");
            String age = intent.getStringExtra("age");
            String competences = intent.getStringExtra("competences");
             telephone = intent.getStringExtra("telephone");

            // Afficher les données dans les TextView
            textNom.setText("Name: " + nom);
            textPrenom.setText("First Name: " + prenom);
            textAge.setText("Age: " + age);
            textCompetences.setText("Field of Expertise: " + competences);
            textTelephone.setText("Phone Number: " + telephone);
        }

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lancer la troisième activité (écran vide par exemple)
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("telephone", telephone);
                startActivity(intent);
            }
        });

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Revenir à l'activité précédente
                finish();
            }
        });


    }
}