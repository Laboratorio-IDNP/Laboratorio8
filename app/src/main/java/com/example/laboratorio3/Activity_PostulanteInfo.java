package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_PostulanteInfo extends AppCompatActivity {

    private EditText campoDni;
    private TextView result;
    private ArrayList<Postulante> postulantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        Intent intent = getIntent();
        postulantes = intent.getParcelableArrayListExtra(Activity_Menu.EXTRA_POSTULANTES);

        campoDni = (EditText) findViewById(R.id.editTextDNI);
        result = (TextView) findViewById(R.id.textResult);

        if (postulantes.size() == 0 ) {
           result.setText("No hay postulantes registrados");
        }
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

