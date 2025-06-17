package com.alurachallenge.literalura.principal;

import com.alurachallenge.literalura.model.Autor;
import com.alurachallenge.literalura.repository.LibroRepository;
import org.springframework.stereotype.Component;
import com.alurachallenge.literalura.model.DatosAutor;
import com.alurachallenge.literalura.model.DatosLibro;
import com.alurachallenge.literalura.model.Libro;
import com.alurachallenge.literalura.service.ConsumoAPI;
import com.alurachallenge.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorio;
    private List<DatosLibro> datosLibros = new ArrayList<>();

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }


    public  void muestraElMenu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ----------------------
                    Elija la opción a través de su número:
                    1 - Buscar libro por titulo 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAño();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private DatosLibro getDatosLibro(){
        System.out.println("Escriba el nombre del libro a buscar;");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL + "?search=" + nombreLibro.replace(" ", "+"));
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }

    private void buscarLibroPorTitulo() {
        DatosLibro datos = getDatosLibro();
        Libro libro = new Libro(datos);
        repositorio.save(libro);
        //datosLibros.add(datos);
        System.out.println("Libro encontrado;");
        //System.out.println(datos);
        System.out.println(libro);
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = datosLibros.stream()
                .map(d -> new Libro(d))
                .collect(Collectors.toList());

        //List<Libro> libros = repositorio.findAll();

        libros.stream()
                .forEach(System.out::println);

    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = new ArrayList<>();

        for (DatosLibro datosLibro : datosLibros) {
            String titulo = datosLibro.titulo();
            for (DatosAutor datosAutor : datosLibro.autores()) {
                // ¿Ya tenemos este autor en la lista?
                Autor autorExistente = autores.stream()
                        .filter(a -> a.getNombre().equalsIgnoreCase(datosAutor.nombre()))
                        .findFirst()
                        .orElse(null);

                if (autorExistente == null) {
                    Autor nuevoAutor = new Autor(datosAutor);
                    nuevoAutor.agregarLibro(titulo);
                    autores.add(nuevoAutor);
                } else {
                    autorExistente.agregarLibro(titulo);
                }
            }
        }

        // Mostrar autores
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosPorAño() {
    }

    private void listarLibrosPorIdioma() {
    }
}
