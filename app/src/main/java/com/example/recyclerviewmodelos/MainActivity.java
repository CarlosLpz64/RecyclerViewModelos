package com.example.recyclerviewmodelos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewmodelos.adaptadores.AlumndoAdapter;
import com.example.recyclerviewmodelos.modelos.alumno;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView re;
    //RECYCLER VIEW TRABAJA CON UN ADAPTADOR Y CONTEXTO (VIEWGROUP)
    // EL ADAPTADOR TRABAJA CON DISEÑO Y DATOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<alumno> Alumnos = new ArrayList<>();

        Alumnos.add(new alumno ("Carlos López", "20170032", "8713911354", "19"));
        Alumnos.add(new alumno ("Brenda Medina", "20170033", "8713919228", "18"));
        Alumnos.add(new alumno ("Jorge Montoya", "20170034", "8713911364", "15"));
        Alumnos.add(new alumno ("América Loera", "20170035", "8713919861", "19"));

        re=findViewById(R.id.recyclerId);
        re.setHasFixedSize(true);
        AlumndoAdapter ad = new AlumndoAdapter(Alumnos);
        LinearLayoutManager lr = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        re.setLayoutManager(lr);
        re.setAdapter(ad);
    }
    /*
    ArrayList<String> listDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIA DE RECYCLER
        recycler= findViewById(R.id.recyclerId);

        //DETERMINAR LAYOUT DEL RECYCLER
            //EJEMPLO LISTA
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            //EJEMPLO GRID
        recycler.setLayoutManager(new GridLayoutManager(this, 2)); //Número de columnas

        //LLENAR LISTA EJEMPLO
        listDatos= new ArrayList<String>();
        for (int i = 0; i<=50; i++){
            listDatos.add("Dato #" + i + " ");
        }

        //RELACIONAR CON ADAPTADOR
        AdapterDatos adapter = new AdapterDatos(listDatos); //ENVIAR LISTA AL ADAPTADOR
        recycler.setAdapter(adapter);


    }*/
}