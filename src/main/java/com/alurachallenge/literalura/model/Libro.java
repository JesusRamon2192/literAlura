package com.alurachallenge.literalura.model;

import com.alurachallenge.literalura.model.Autor;
import com.alurachallenge.literalura.model.DatosLibro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;

    @Transient
    private List<Autor> autores = new ArrayList<>();

    @Transient
    private List<String> resumenes;

    @Transient
    private List<String> idiomas;

    private Integer descargas;

    @Column(name = "autor")
    private String autoresStr;

    @Column(name = "idioma")
    private String idiomasStr;

    @Column(name = "resumen")
    private String resumenStr;

    public Libro() {}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores().stream()
                .map(Autor::new)
                .collect(Collectors.toList());
        this.resumenes = datosLibro.resumenes();
        this.idiomas = datosLibro.idiomas();
        this.descargas = datosLibro.descargas();

        // Calcula los campos de string con los datos ya cargados
        this.autoresStr = autores.stream()
                .map(Autor::getNombre)
                .collect(Collectors.joining(", "));

        this.idiomasStr = (idiomas != null && !idiomas.isEmpty())
                ? idiomas.get(0)
                : "N/A";

        this.resumenStr = (resumenes != null && !resumenes.isEmpty())
                ? resumenes.get(0)
                : "N/A";
    }

    @Override
    public String toString() {
        return  "---- LIBRO -----" + "\n" +
                "titulo: " + titulo + "\n" +
                "autores: " + autoresStr + "\n" +
                "idioma: " + idiomasStr + "\n" +
                //"resumen: " + resumenStr + "\n" +
                "descargas: " + descargas + "\n" +
                "----------------" + "\n";
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

    public String getAutoresStr() {
        return autoresStr;
    }

    public void setAutoresStr(String autoresStr) {
        this.autoresStr = autoresStr;
    }

    public String getIdiomasStr() {
        return idiomasStr;
    }

    public void setIdiomasStr(String idiomasStr) {
        this.idiomasStr = idiomasStr;
    }

    public String getResumenStr() {
        return resumenStr;
    }

    public void setResumenStr(String resumenStr) {
        this.resumenStr = resumenStr;
    }
}
