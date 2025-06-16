package com.alurachallenge.literalura.model;

import jakarta.persistence.* ;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Libro {
    private Long Id;
    private String titulo;
    private List<Autor> autores = new ArrayList<>();
    private List<String> resumenes;
    private List<String> idiomas;
    private Integer descargas;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();

        this.autores = datosLibro.autores().stream()
                .map(Autor::new)
                .collect(Collectors.toList());

        this.resumenes = datosLibro.resumenes();
        this.descargas = datosLibro.descargas();
        this.idiomas = datosLibro.idiomas();
    }

    @Override
    public String toString() {
        String autoresStr = autores.stream()
                .map(Autor::getNombre)
                .collect(Collectors.joining(", "));

        String idiomasStr = (idiomas != null ? String.join(", ", idiomas) : "N/A");

        return  "---- LIBRO -----" + "\n" +
                "titulo: " + titulo + "\n" +
                "autores: " + autoresStr + "\n" +
                "idioma: " + idiomasStr + "\n" +
                "descargas: " + descargas + "\n" +
                "----------------" + "\n" ;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getResumenes() {
        return resumenes;
    }

    public void setResumenes(List<String> resumenes) {
        this.resumenes = resumenes;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }
}
