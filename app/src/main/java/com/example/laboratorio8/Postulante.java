package com.example.laboratorio8;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Postulante implements Parcelable {

    private String dni;

    public Postulante(String dni, String apellidoPaterno, String apellidoMaterno, String nombres, String fechaNacimiento, String colegioPrecedencia, String carreraPostula) {
        this.dni = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.colegioPrecedencia = colegioPrecedencia;
        this.carreraPostula = carreraPostula;
    }

    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String fechaNacimiento;
    private String colegioPrecedencia;
    private String carreraPostula;

    public Postulante() {
    }

    protected Postulante(Parcel in) {
        dni = in.readString();
        apellidoPaterno = in.readString();
        apellidoMaterno = in.readString();
        nombres = in.readString();
        fechaNacimiento = in.readString();
        colegioPrecedencia = in.readString();
        carreraPostula = in.readString();
    }

    public static final Creator<Postulante> CREATOR = new Creator<Postulante>() {
        @Override
        public Postulante createFromParcel(Parcel in) {
            return new Postulante(in);
        }

        @Override
        public Postulante[] newArray(int size) {
            return new Postulante[size];
        }
    };

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @NonNull
    @Override
    public String toString() {
        return "Postulante{" +
                "apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", nombres='" + nombres + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", colegioPrecedencia='" + colegioPrecedencia + '\'' +
                ", carreraPostula='" + carreraPostula + '\'' +
                '}';
    }

    public String toText() {
        return dni + ","
                + apellidoPaterno + ","
                + apellidoMaterno + ","
                + nombres + ","
                + fechaNacimiento + ","
                + colegioPrecedencia +","
                + carreraPostula + "\n";
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getColegioPrecedencia() {
        return colegioPrecedencia;
    }

    public void setColegioPrecedencia(String colegioPrecedencia) {
        this.colegioPrecedencia = colegioPrecedencia;
    }

    public String getCarreraPostula() {
        return carreraPostula;
    }

    public void setCarreraPostula(String carreraPostula) {
        this.carreraPostula = carreraPostula;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dni);
        parcel.writeString(apellidoPaterno);
        parcel.writeString(apellidoMaterno);
        parcel.writeString(nombres);
        parcel.writeString(fechaNacimiento);
        parcel.writeString(colegioPrecedencia);
        parcel.writeString(carreraPostula);
    }

    public static List<Postulante> listPostulantes( String data) {

        List<Postulante> listaPostulantes = new ArrayList<Postulante> ();

        String[] postulantes = data.split("\n");

        for (int i = 0; i < postulantes.length ; i++) {
            String [] postulante = postulantes[i].split(",");
            listaPostulantes.add(new Postulante(
               postulante[0],
               postulante[1],
               postulante[2],
               postulante[3],
               postulante[4],
               postulante[5],
               postulante[6]
            ));
        }
        Log.i("DATA", listaPostulantes.toString());
        return listaPostulantes;
    }
}
