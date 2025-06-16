package com.alurachallenge.literalura.model;

public enum Idioma {
    ESPAÑOL("es"),
    INGLES("en"),
    FRANCES("fr"),
    PORTUGUES("pt");

    private String idiomaOmdb;
    Idioma(String idiomaOmdb){
        this.idiomaOmdb = idiomaOmdb;
    }

    public static Idioma fromString(String text){
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaOmdb.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        return null;
    }
}
