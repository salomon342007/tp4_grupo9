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

    // Getters
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

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setAutor(String autor) {
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
