package com.example.laboratorio8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity_PostulanteInfo extends AppCompatActivity {

    private EditText campoDni;
    private TextView result;
    private List<Postulante> postulantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Intent intent = getIntent();
        File path = getApplicationContext().getFilesDir();
        //postulantes = intent.getParcelableArrayListExtra(Activity_Menu.EXTRA_POSTULANTES);
        String data =  Data.readFromFile(path);
        postulantes = Postulante.listPostulantes(data);
        Log.i("DATA", data);

        campoDni = (EditText) findViewById(R.id.editTextDNI);
        result = (TextView) findViewById(R.id.textResult);

        if (postulantes == null) {
           result.setText("No hay postulantes registrados");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PostulanteAdapter(getApplicationContext(), postulantes));
    }

    public void getResults(View button) {
        String dni = campoDni.getText().toString();
        if (dni != null) {
            for (Postulante p: postulantes) {
                if (p.getDni().equals(dni)) {
                    String datosPostulante = "DNI:" + p.getDni() + "\n" +
                            "APELLIDOS:" + p.getApellidoPaterno() + " " + p.getApellidoMaterno() + "\n" +
                            "NOMBRES:" + p.getNombres() + "\n" +
                            "FECHA NACIMIENTO:" + p.getFechaNacimiento() + "\n" +
                            "FECHA COLEGIO:" + p.getColegioPrecedencia() + "\n" +
                            "FECHA CARRERA:" + p.getCarreraPostula() + "\n";
                    result.setText(datosPostulante);
                } else {
                    result.setText("No hay resultados");
                }
            }
        }
    }


}

