package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_PostulanteRegistro extends AppCompatActivity {

    public final static String NEW_POSTULANTE = "NEW_POSTULANTE";
    private EditText campoDni;
    private EditText campoApellidoPaterno;
    private EditText campoApellidoMaterno;
    private EditText campoNombres;
    private EditText campoFechaNacimiento;
    private EditText campoColegioPrecedencia;
    private EditText campoCarreraPostula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);
        Button btnRegistrar = findViewById(R.id.buttonRegistar);

        campoDni = (EditText) findViewById(R.id.editTextDni);
        campoApellidoPaterno = (EditText) findViewById(R.id.editTextApellidoPaterno);
        campoApellidoMaterno = (EditText) findViewById(R.id.editTextApellidoMaterno);
        campoNombres = (EditText) findViewById(R.id.editTextNombres);
        campoFechaNacimiento = (EditText) findViewById(R.id.editTextFechaNacimiento);
        campoColegioPrecedencia = (EditText) findViewById(R.id.editTextColegioProcedencia);
        campoCarreraPostula = (EditText) findViewById(R.id.editTextCarreraPostula);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Postulante postulante = new Postulante();

                postulante.setDni(campoDni.getText().toString());
                postulante.setApellidoPaterno(campoApellidoPaterno.getText().toString());
                postulante.setApellidoMaterno(campoApellidoMaterno.getText().toString());
                postulante.setNombres(campoNombres.getText().toString());
                postulante.setFechaNacimiento(campoFechaNacimiento.getText().toString());
                postulante.setColegioPrecedencia(campoColegioPrecedencia.getText().toString());
                postulante.setCarreraPostula(campoCarreraPostula.getText().toString());

                Intent intentActivityMenu = new Intent();
                intentActivityMenu.putExtra(NEW_POSTULANTE,postulante);
                setResult(Activity.RESULT_OK, intentActivityMenu);
                finish();
            }
        });

    }
}

