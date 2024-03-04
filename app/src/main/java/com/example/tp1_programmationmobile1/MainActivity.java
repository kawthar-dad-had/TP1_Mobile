package com.example.tp1_programmationmobile1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editNom, editPrenom, editAge, editCompetences, editTelephone;
    private Button btnValider;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNom = findViewById(R.id.editNom);
        editPrenom = findViewById(R.id.editPrenom);
        editAge = findViewById(R.id.editAge);
        editCompetences = findViewById(R.id.editCompetences);
        editTelephone = findViewById(R.id.editTelephone);
        btnValider = findViewById(R.id.btnValider);


        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afficherDialogConfirmation();
            }
        });
    }

    private void afficherDialogConfirmation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Voulez-vous vraiment valider les informations?");

        //Exercice 5
        //builder.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
        //    @Override
        //    public void onClick(DialogInterface dialog, int which) {
        //        validerInformations();
        //    }
        //});

        //Exercice 6
        builder.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Créer un Intent pour lancer une nouvelle activité
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                // Ajouter les données saisies à l'Intent
                intent.putExtra("nom", editNom.getText().toString());
                intent.putExtra("prenom", editPrenom.getText().toString());
                intent.putExtra("age", editAge.getText().toString());
                intent.putExtra("competences", editCompetences.getText().toString());
                intent.putExtra("telephone", editTelephone.getText().toString());

                // Lancer la nouvelle activité avec l'Intent
                startActivity(intent);
            }
        });


        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // L'utilisateur a annulé, ne rien faire.
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void validerInformations() {
        String message = "Informations validées!";
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}