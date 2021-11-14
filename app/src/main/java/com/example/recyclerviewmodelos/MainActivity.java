package com.example.recyclerviewmodelos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerviewmodelos.adaptadores.AlumndoAdapter;
import com.example.recyclerviewmodelos.modelos.alumno;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView re;
    //PERMISOS
    private static final int REQUEST_PERMISSION_CALL = 100;

    //RECYCLER VIEW TRABAJA CON UN ADAPTADOR Y CONTEXTO (VIEWGROUP)
    // EL ADAPTADOR TRABAJA CON DISEÑO Y DATOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //LISTA DE TIPO ALUMNOS
        List<alumno> Alumnos = new ArrayList<>();

        //AGREGAR ELEMENTOS A LA LISTA
        Alumnos.add(new alumno ("Carlos López", "20170032", "8713911354", "19"));
        Alumnos.add(new alumno ("Brenda Medina", "20170033", "8713919228", "18"));
        Alumnos.add(new alumno ("Jorge Montoya", "20170034", "8713911364", "15"));
        Alumnos.add(new alumno ("América Loera", "20170035", "8713919861", "18"));
        Alumnos.add(new alumno ("Álvaro Rentería", "20170036", "8713911648", "7"));
        Alumnos.add(new alumno ("Oscar Zapata", "20170037", "8713911326", "17"));
        Alumnos.add(new alumno ("José Tapia", "20170038", "8713911319", "16"));

        //UBICAR RECYCLER
        re=findViewById(R.id.recyclerId);
        re.setHasFixedSize(true);
        //CREAR ADAPTER
        AlumndoAdapter ad = new AlumndoAdapter(Alumnos);
        LinearLayoutManager lr = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        re.setLayoutManager(lr);

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), Alumnos.get(re.getChildAdapterPosition(v)).getTelefono(), Toast.LENGTH_SHORT).show();
                //INTENT
                String tel;
                tel = Alumnos.get(re.getChildAdapterPosition(v)).getTelefono();
                PermisoMarcar(tel);

            }
        });


        re.setAdapter(ad);
    }

    public void PermisoMarcar(String tel){
        //PERMISO
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){ //VER SI LA VERSIÓN ES MENOR A 23 (PERMISOS AL INSTALAR)
            Marcar(tel);
        } else { //SOLICITAR PERMISO EN EJECUCIÓN
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                Marcar(tel);
            }else{
                /*
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CALL_PHONE)){ //LÍNEA POR SI ANTERIORMENTE SE HA RECHAZADO
                    Log.i("TAG","El usuario previamente ha rechazado la solicitud de permiso");
                } else {
                    Log.i("TAG","Solicitar permiso");
                }*/
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PERMISSION_CALL );
            }
        }
    }

    public void Marcar(String tel){
        Intent MarcarImp= new Intent(Intent.ACTION_CALL );
        MarcarImp.setData(Uri.parse("tel:" + tel));
        startActivity(MarcarImp);
    }

    //VENTANA PARA SOLICITAR PERMISO
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}