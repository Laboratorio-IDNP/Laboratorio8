package com.example.laboratorio8;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemPostulante extends RecyclerView.ViewHolder {

    TextView dni;
    TextView apellidoPaterno;
    TextView apellidoMaterno;
    TextView nombres;
    TextView fechaNacimiento;
    TextView colegio;
    TextView carrera;

    public ItemPostulante(@NonNull View itemView) {
        super(itemView);
        dni = itemView.findViewById(R.id.dni);
        apellidoPaterno = itemView.findViewById(R.id.apellido_paterno);
        apellidoMaterno = itemView.findViewById(R.id.apellido_materno);
        nombres = itemView.findViewById(R.id.nombres);
        fechaNacimiento = itemView.findViewById(R.id.fecha_nacimiento);
        colegio = itemView.findViewById(R.id.colegio);
        carrera = itemView.findViewById(R.id.carrera);
    }
}
