package ar.edu.unju.escmi.tp4.Ejercicio5;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeMap;

public class ejercicio5 {
    public static void main(String[] args) {
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 – Alta de producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Buscar un producto");
            System.out.println("4 – Eliminar un producto");
            System.out.println("5 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese código del producto (entero): ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese fecha de vencimiento (AAAA-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    LocalDate fechaVencimiento = LocalDate.parse(fechaStr);
                    Producto nuevoProducto = new Producto(descripcion, precio, fechaVencimiento);
                    productos.put(codigo, nuevoProducto);
                    System.out.println("Producto agregado exitosamente.");
                    break;
                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        productos.forEach((k, v) -> System.out.println("Código: " + k + " - " + v));
                    }
                    break;
                case 3:
                    System.out.print("Ingrese código del producto a buscar: ");
                    int codigoBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Producto prodBuscado = productos.get(codigoBuscar);
                    if (prodBuscado != null) {
                        System.out.println("Código: " + codigoBuscar + " - " + prodBuscado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese código del producto a eliminar: ");
                    int codigoEliminar = scanner.nextInt();
                    scanner.nextLine();
                    Producto eliminado = productos.remove(codigoEliminar);
                    if (eliminado != null) {
                        System.out.println("Producto eliminado: " + eliminado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
