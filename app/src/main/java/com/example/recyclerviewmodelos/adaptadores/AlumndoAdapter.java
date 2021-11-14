package com.example.recyclerviewmodelos.adaptadores;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewmodelos.R;
import com.example.recyclerviewmodelos.modelos.alumno;

import java.util.ArrayList;
import java.util.List;


public class AlumndoAdapter extends RecyclerView.Adapter<AlumndoAdapter.ViewHolder>{

    public AlumndoAdapter(List<alumno> alumnos) {
        Alumnos = alumnos;
    }

    private List<alumno> Alumnos;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.disenorv, null, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        alumno a = Alumnos.get(position);
        holder.llenar(a);
    }


    @Override
    public int getItemCount() {
        return Alumnos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView matricula;
        TextView edad;
        TextView nombre;
        TextView telefono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            matricula = itemView.findViewById(R.id.txt_matricula);
            nombre = itemView.findViewById(R.id.txt_nombre);
            edad = itemView.findViewById(R.id.txt_edad);
            telefono = itemView.findViewById(R.id.txt_telefono);
        }

        public void llenar(alumno a) {
            nombre.setText(a.getNombre());
            edad.setText(a.getEdad());
            telefono.setText(a.getTelefono());
            matricula.setText(a.getMatricula());
        }
    }
}
