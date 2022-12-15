package com.example.laboratorio3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Activity_Menu extends AppCompatActivity {

    public final static String EXTRA_POSTULANTES = "EXTRA_POSTULANTES";
    private ArrayList<Postulante> postulantes;
    private Postulante postulante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        postulantes = new ArrayList<>();

        Button btnPostulanteInfo  = findViewById(R.id.button_postulante_info);
        Button btnPostulanteRegistro = findViewById(R.id.button_postulante_registro);

        btnPostulanteInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentActivityPostulanteInfo = new Intent(getApplicationContext(), Activity_PostulanteInfo.class);
                intentActivityPostulanteInfo.putParcelableArrayListExtra(EXTRA_POSTULANTES, postulantes);
                startActivity(intentActivityPostulanteInfo);
            }
        });

        btnPostulanteRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPostulanteRegistro = new Intent(getApplicationContext(), Activity_PostulanteRegistro.class);
                startForResult.launch(intentPostulanteRegistro);
            }
        });

    }

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        Postulante postulante =  intent.getParcelableExtra(Activity_PostulanteRegistro.NEW_POSTULANTE);
                        postulantes.add(postulante);
                    }
                }
            }
    );
}