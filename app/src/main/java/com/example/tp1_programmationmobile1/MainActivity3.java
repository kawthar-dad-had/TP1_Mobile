package com.example.tp1_programmationmobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private ImageView imageTelephone;
    private TextView labelNumero;
    private Button btnAppeler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageTelephone = findViewById(R.id.imageTelephone);
        labelNumero = findViewById(R.id.labelNumero);
        btnAppeler = findViewById(R.id.btnAppeler);

        Intent intent = getIntent();
        if (intent != null) {
            String telephone = intent.getStringExtra("telephone");

            labelNumero.setText(getString(R.string.label_numero, telephone));
        }
        btnAppeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lancerAppelTelephonique();
            }
        });
    }
    private void lancerAppelTelephonique() {
        String numeroTelephone = labelNumero.getText().toString().replaceAll("[^0-9]", "");;
        //Log.d("TAG", "Contenu du TextView : " + labelNumero.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL);

        // Remplacez "1234567890" par le numéro de téléphone réel
        intent.setData(Uri.parse("tel:"+ numeroTelephone));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Impossible de lancer l'appel"+numeroTelephone, Toast.LENGTH_SHORT).show();
        }
    }
}