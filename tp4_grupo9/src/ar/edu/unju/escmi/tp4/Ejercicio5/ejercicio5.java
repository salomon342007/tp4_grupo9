package ar.edu.unju.escmi.tp4.Ejercicio5;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ejercicio5 {
    // Punto de entrada del programa: muestra un menú para gestionar productos
    public static void main(String[] args) {
        // Mapa ordenado por clave que almacena los productos (clave entera -> Producto)
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        // Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones mostrado al usuario
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 – Alta de producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Buscar un producto");
            System.out.println("4 – Eliminar un producto");
            System.out.println("5 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer después de leer un entero

            switch (opcion) {
                case 1:
                    // Alta de un nuevo producto: se pide la clave, descripción, precio y fecha de vencimiento
                    System.out.print("Ingrese código del producto (entero): ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    if (productos.containsKey(codigo)) {
                        // Evita duplicados de clave
                        System.out.println("La clave ya existe. No se puede duplicar.");
                        break;
                    }
                    System.out.print("Ingrese descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese fecha de vencimiento (AAAA-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    // Parseo de la fecha en formato ISO (AAAA-MM-DD)
                    LocalDate fechaVencimiento = LocalDate.parse(fechaStr);
                    // Creación del objeto Producto con los datos ingresados
                    Producto nuevoProducto = new Producto(descripcion, precio, fechaVencimiento);
                    productos.put(codigo, nuevoProducto);
                    System.out.println("Producto agregado exitosamente.");
                    break;
                case 2:
                    // Mostrar todos los productos registrados en el TreeMap
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        Iterator<Map.Entry<Integer, Producto>> it = productos.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<Integer, Producto> entry = it.next();
                            // Muestra la clave y el valor (Producto.toString())
                            System.out.println("Clave: " + entry.getKey() + " - Valor: " + entry.getValue());
                        }
                    }
                    break;
                case 3:
                    // Buscar un producto por su clave
                    System.out.print("Ingrese clave del producto a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    scanner.nextLine();
                    if (productos.containsKey(claveBuscar)) {
                        System.out.println("Clave: " + claveBuscar + " - Valor: " + productos.get(claveBuscar));
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    // Eliminar un producto por su clave (si existe)
                    System.out.print("Ingrese clave del producto a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    scanner.nextLine();
                    if (productos.containsKey(claveEliminar)) {
                        Producto eliminado = productos.remove(claveEliminar);
                        System.out.println("Producto eliminado: " + eliminado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    // Opción para salir del bucle y terminar el programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    // Manejo de opciones inválidas ingresadas por el usuario
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        // Cierre del Scanner para liberar el recurso de entrada
        scanner.close();
    }
}
