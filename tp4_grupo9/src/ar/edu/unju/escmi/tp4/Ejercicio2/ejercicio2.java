package ar.edu.unju.escmi.tp4.Ejercicio2;

import java.util.*;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Empleado> empleados = new HashMap<>();
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 – Alta de empleado.");
            System.out.println("2 – Mostrar empleados.");
            System.out.println("3 – Eliminar empleado.");
            System.out.println("4 – Consultar los datos de un empleado.");
            System.out.println("5 – Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Sueldo: ");
                    double sueldo = scanner.nextDouble();
                    System.out.print("Categoría (char): ");
                    char categoria = scanner.next().charAt(0);
                    scanner.nextLine(); // Limpiar buffer

                    Empleado emp = new Empleado(dni, nombre, apellido, sueldo, categoria);
                    String clave = dni + categoria;
                    empleados.put(clave, emp);
                    System.out.println("Empleado agregado con clave: " + clave);
                    break;

                case 2:
                    Iterator<Map.Entry<String, Empleado>> it = empleados.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Empleado> entry = it.next();
                        System.out.println("Clave: " + entry.getKey() + " - " + entry.getValue());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave del empleado a eliminar: ");
                    String claveEliminar = scanner.nextLine();
                    if (empleados.containsKey(claveEliminar)) {
                        empleados.remove(claveEliminar);
                        System.out.println("Empleado eliminado.");
                    } else {
                        System.out.println("No existe un empleado con esa clave.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la clave del empleado a consultar: ");
                    String claveConsultar = scanner.nextLine();
                    if (empleados.containsKey(claveConsultar)) {
                        System.out.println("Datos: " + empleados.get(claveConsultar));
                    } else {
                        System.out.println("No existe un empleado con esa clave.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}