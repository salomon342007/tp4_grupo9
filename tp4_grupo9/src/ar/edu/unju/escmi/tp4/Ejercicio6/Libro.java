package ar.edu.unju.escmi.tp4.Ejercicio6;

public class Libro {
    private String isbn;
    private String titulo;
    private int cantidadPaginas;
    private String autor;

    public Libro(String isbn, String titulo, int cantidadPaginas, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
    }

    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Cantidad de páginas: " + cantidadPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("-----------------------------");
    }
}
