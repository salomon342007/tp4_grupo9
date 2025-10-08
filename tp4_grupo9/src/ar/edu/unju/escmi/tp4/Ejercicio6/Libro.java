package ar.edu.unju.escmi.tp4.Ejercicio6;

/**
 * Clase Libro que representa un libro con sus datos principales.
 * Implementa Comparable para permitir ordenar por título.
 */
public class Libro implements Comparable<Libro> {
    // Atributos privados para encapsulamiento
    private String isbn;
    private String titulo;
    private int cantidadPaginas;
    private String autor;

    // Constructor vacío
    public Libro() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Libro(String isbn, String titulo, int cantidadPaginas, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
    }

    // Métodos getter para acceder a los atributos
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    // Métodos setter para modificar los atributos
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Muestra los datos del libro por consola.
     */
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Cantidad de páginas: " + cantidadPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("-----------------------------");
    }

    /**
     * Permite comparar libros por título, ignorando mayúsculas/minúsculas.
     * Esto es útil para ordenar listas de libros alfabéticamente.
     */
    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }
}
