package ar.edu.unju.escmi.tp4.Ejercicio2;

import java.util.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Empleado> empleados = new HashMap<>();
        int opcion = 0;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1) Alta de empleado.");
            System.out.println("2) Mostrar empleados.");
            System.out.println("3) Eliminar empleado.");
            System.out.println("4) Consultar los datos de un empleado.");
            System.out.println("5) Salir.");

            //  Validar opción numérica
            while (true) {
                System.out.print("Ingrese una opción: ");
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                    if (opcion < 1 || opcion > 5) {
                        System.out.println("Opción fuera de rango. Intente nuevamente.");
                    } else break;
                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un número válido.");
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();

                    //  Validar que el sueldo sea un número
                    double sueldo = 0;
                    while (true) {
                        System.out.print("Sueldo: ");
                        try {
                            sueldo = Double.parseDouble(scanner.nextLine());
                            if (sueldo < 0) {
                                System.out.println("El sueldo no puede ser negativo.");
                            } else break;
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un número para el sueldo.");
                        }
                    }

                    System.out.print("Categoría (una letra): ");
                    char categoria = scanner.nextLine().charAt(0);

                    Empleado emp = new Empleado(dni, nombre, apellido, sueldo, categoria);
                    String clave = dni + categoria;
                    empleados.put(clave, emp);
                    System.out.println("✅ Empleado agregado con clave: " + clave);
                    break;

                case 2:
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados cargados.");
                    } else {
                        System.out.println("\nLista de empleados:");
                        for (Map.Entry<String, Empleado> entry : empleados.entrySet()) {
                            System.out.println("Clave: " + entry.getKey() + " - " + entry.getValue());
                        }
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
                        System.out.println("👤 Datos: " + empleados.get(claveConsultar));
                    } else {
                        System.out.println("No existe un empleado con esa clave.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
