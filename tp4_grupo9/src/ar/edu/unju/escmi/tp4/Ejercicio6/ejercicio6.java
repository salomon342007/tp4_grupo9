package ar.edu.unju.escmi.tp4.Ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- MENÚ DE OPCIONES -----");
            System.out.println("1 – Alta de Libro.");
            System.out.println("2 – Mostrar libros.");
            System.out.println("3 – Buscar y mostrar un libro.");
            System.out.println("4 – Ordenar libros.");
            System.out.println("5 – Modificar datos de un libro.");
            System.out.println("6 – Eliminar un libro.");
            System.out.println("7 – Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Alta de Libro
                    System.out.print("Ingrese ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Ingrese título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese cantidad de páginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese autor: ");
                    String autor = scanner.nextLine();
                    libros.add(new Libro(isbn, titulo, paginas, autor));
                    System.out.println("Libro agregado correctamente.\n");
                    break;
                case 2:
                    // Mostrar libros
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros cargados.\n");
                    } else {
                        for (Libro libro : libros) {
                            libro.mostrarDatos();
                        }
                    }
                    break;
                case 3:
                    // Buscar y mostrar un libro
                    System.out.print("Ingrese ISBN del libro a buscar: ");
                    String isbnBuscar = scanner.nextLine();
                    boolean encontrado = false;
                    for (Libro libro : libros) {
                        if (libro.getIsbn().equals(isbnBuscar)) {
                            libro.mostrarDatos();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Libro no encontrado.\n");
                    }
                    break;
                case 4:
                    // Ordenar libros por título
                    Collections.sort(libros, Comparator.comparing(Libro::getTitulo));
                    System.out.println("Libros ordenados por título.\n");
                    break;
                case 5:
                    // Modificar datos de un libro
                    System.out.print("Ingrese ISBN del libro a modificar: ");
                    String isbnModificar = scanner.nextLine();
                    boolean modificado = false;
                    for (Libro libro : libros) {
                        if (libro.getIsbn().equals(isbnModificar)) {
                            System.out.print("Nuevo título: ");
                            libro.setTitulo(scanner.nextLine());
                            System.out.print("Nueva cantidad de páginas: ");
                            libro.setCantidadPaginas(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Nuevo autor: ");
                            libro.setAutor(scanner.nextLine());
                            System.out.println("Datos modificados correctamente.\n");
                            modificado = true;
                            break;
                        }
                    }
                    if (!modificado) {
                        System.out.println("Libro no encontrado.\n");
                    }
                    break;
                case 6:
                    // Eliminar un libro
                    System.out.print("Ingrese ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    boolean eliminado = libros.removeIf(libro -> libro.getIsbn().equals(isbnEliminar));
                    if (eliminado) {
                        System.out.println("Libro eliminado correctamente.\n");
                    } else {
                        System.out.println("Libro no encontrado.\n");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.\n");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
