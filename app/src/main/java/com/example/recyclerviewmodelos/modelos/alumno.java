package com.example.recyclerviewmodelos.modelos;

public class alumno {
    private String Nombre;
    private String Matricula;
    private String Telefono;
    private String Edad;

    //CONSTRUCTOR CON TODOS LOS PARÁMETROS
    public alumno(String nombre, String matricula, String telefono, String edad) {
        Nombre = nombre;
        Matricula = matricula;
        Telefono = telefono;
        Edad = edad;
    }

    //GET Y SET
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMatricula() {
        return Matricula;
    }
    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEdad() {
        return Edad;
    }
    public void setEdad(String edad) {
        Edad = edad;
    }
}
