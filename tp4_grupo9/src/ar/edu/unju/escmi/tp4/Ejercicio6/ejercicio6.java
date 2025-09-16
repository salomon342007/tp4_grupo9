package ar.edu.unju.escmi.tp4.Ejercicio6;

import java.util.ArrayList;

public class ejercicio6 {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("978-987-1234567", "El Principito", 96, "Antoine de Saint-Exupéry"));
        libros.add(new Libro("978-950-1234567", "Cien años de soledad", 471, "Gabriel García Márquez"));
        libros.add(new Libro("978-843-1234567", "Don Quijote de la Mancha", 863, "Miguel de Cervantes"));

        for (Libro libro : libros) {
            libro.mostrarDatos();
        }
    }
}
