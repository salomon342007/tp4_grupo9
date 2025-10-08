package ar.edu.unju.escmi.tp4.Ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {
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
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Libro nuevoLibro = new Libro();
                    System.out.print("Ingrese ISBN: ");
                    nuevoLibro.setIsbn(scanner.nextLine());
                    System.out.print("Ingrese título: ");
                    nuevoLibro.setTitulo(scanner.nextLine());
                    System.out.print("Ingrese cantidad de páginas: ");
                    nuevoLibro.setCantidadPaginas(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Ingrese autor: ");
                    nuevoLibro.setAutor(scanner.nextLine());
                    libros.add(nuevoLibro);
                    System.out.println("Libro agregado correctamente.\n");
                    break;
                case 2:
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros cargados.\n");
                    } else {
                        for (Libro libro : libros) {
                            libro.mostrarDatos();
                        }
                    }
                    break;
                case 3:
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
                    Collections.sort(libros);
                    System.out.println("Libros ordenados por título.\n");
                    break;
                case 5:
                    System.out.print("Ingrese ISBN del libro a modificar: ");
                    String isbnModificar = scanner.nextLine();
                    boolean modificado = false;
                    for (Libro libro : libros) {
                        if (libro.getIsbn().equals(isbnModificar)) {
                            System.out.println("Datos actuales del libro:");
                            libro.mostrarDatos();
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
                    System.out.print("Ingrese ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    boolean eliminado = false;
                    for (int i = 0; i < libros.size(); i++) {
                        if (libros.get(i).getIsbn().equals(isbnEliminar)) {
                            libros.remove(i);
                            eliminado = true;
                            System.out.println("Libro eliminado correctamente.\n");
                            break;
                        }
                    }
                    if (!eliminado) {
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
