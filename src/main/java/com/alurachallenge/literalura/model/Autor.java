package com.alurachallenge.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;
    private List<String> libros = new ArrayList<String>();

    public Autor() {}

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.nacimiento = datosAutor.nacimiento();
        this.fallecimiento = datosAutor.fallecimiento();
    }

    public void agregarLibro(String titulo) {
        if (!libros.contains(titulo)) {
            libros.add(titulo);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    @Override
    public String toString() {
        return "Autor: " + nombre + "\n" +
                "Fecha de nacimiento: " + nacimiento + "\n" +
                "Fecha de fallecimiento: " + fallecimiento + "\n" +
                "Libros: " + libros + "\n";
    }

}
