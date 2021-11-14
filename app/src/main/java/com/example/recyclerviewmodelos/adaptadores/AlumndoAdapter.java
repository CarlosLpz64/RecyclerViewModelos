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


public class AlumndoAdapter extends RecyclerView.Adapter<AlumndoAdapter.ViewHolder> implements View.OnClickListener{

    public AlumndoAdapter(List<alumno> alumnos) {
        Alumnos = alumnos;
    }

    //CREAR UNA LISTA DE TIPO ALUMNOS
    private List<alumno> Alumnos;

    //ONCLICK
    private View.OnClickListener listener;

    //CREAR VIEWHOLDER (DISENO)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //INFLAR
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.disenorv, null, false);
        //ONCLICK
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    //DAR INFORMACION
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        alumno a = Alumnos.get(position); //TOMAR UN ELEMENTO DE LA LISTA
        holder.llenar(a);
    }


    //TAMANO DE LA LISTA
    @Override
    public int getItemCount() {
        return Alumnos.size();
    }


    //MÉTODO ONCLICK
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    //CLASE ANIDADA
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView matricula;
        TextView edad;
        TextView nombre;
        TextView telefono;

        //DETECTAR ELEMENTOS POR ID
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            matricula = itemView.findViewById(R.id.txt_matricula);
            nombre = itemView.findViewById(R.id.txt_nombre);
            edad = itemView.findViewById(R.id.txt_edad);
            telefono = itemView.findViewById(R.id.txt_telefono);
        }

        //CAMBIAR TEXTOS
        public void llenar(alumno a) {
            nombre.setText(a.getNombre());
            edad.setText(a.getEdad());
            telefono.setText(a.getTelefono());
            matricula.setText(a.getMatricula());
        }
    }
}
