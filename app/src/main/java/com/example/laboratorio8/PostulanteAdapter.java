package com.example.laboratorio8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostulanteAdapter extends RecyclerView.Adapter<ItemPostulante> {

    Context context;
    List<Postulante> postulantes;

    public PostulanteAdapter(Context context, List<Postulante> postulantes) {
        this.context = context;
        this.postulantes = postulantes;
    }

    @NonNull
    @Override
    public ItemPostulante onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemPostulante(LayoutInflater.from(context).inflate(R.layout.item_postulante, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPostulante holder, int position) {
        holder.dni.setText(postulantes.get(position).getDni());
        holder.apellidoPaterno.setText(postulantes.get(position).getApellidoPaterno());
        holder.apellidoMaterno.setText(postulantes.get(position).getApellidoMaterno());
        holder.nombres.setText(postulantes.get(position).getNombres());
        holder.fechaNacimiento.setText(postulantes.get(position).getFechaNacimiento());
        holder.colegio.setText(postulantes.get(position).getColegioPrecedencia());
        holder.carrera.setText(postulantes.get(position).getCarreraPostula());
    }

    @Override
    public int getItemCount() {
        return postulantes.size();
    }
}
