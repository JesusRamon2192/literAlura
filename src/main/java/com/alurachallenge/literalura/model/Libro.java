package com.alurachallenge.literalura.model;

import com.alurachallenge.literalura.model.Autor;
import com.alurachallenge.literalura.model.DatosLibro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
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

    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    @Transient
    private List<String> idiomas;

    private Integer descargas;

    @Column(name = "autor")
    private String autoresStr;

    @Column(name = "idioma")
    private String idiomasStr;

    public Libro() {}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.autor = new Autor(datosLibro.autores().get(0));
        this.idiomas = datosLibro.idiomas();
        this.descargas = datosLibro.descargas();

        // Calcula los campos de string con los datos ya cargados
        this.autoresStr = autor.getNombre();

        this.idiomasStr = (idiomas != null && !idiomas.isEmpty())
                ? idiomas.get(0)
                : "N/A";

    }

    @Override
    public String toString() {
        return  "---- LIBRO -----" + "\n" +
                "titulo: " + titulo + "\n" +
                "autores: " + autor.getNombre() + "\n" +
                "idioma: " + idiomasStr + "\n" +
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
}
