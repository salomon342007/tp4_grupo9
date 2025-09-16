package ar.edu.unju.escmi.tp4.Ejercicio4;

import java.util.HashSet;
import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        HashSet<Cliente> clientes = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 – Crear cliente");
            System.out.println("2 – Mostrar los datos de un cliente");
            System.out.println("3 – Mostrar todos los clientes");
            System.out.println("4 – Mostrar todos los clientes ocasionales y la cantidad");
            System.out.println("5 – Mostrar todos los clientes frecuentes y la cantidad");
            System.out.println("6 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    String tipo;
                    do {
                        System.out.print("Ingrese tipo de cliente (ocasional/frecuente): ");
                        tipo = scanner.nextLine().toLowerCase();
                    } while (!tipo.equals("ocasional") && !tipo.equals("frecuente"));
                    clientes.add(new Cliente(dni, nombre, tipo));
                    System.out.println("Cliente creado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese DNI del cliente a buscar: ");
                    String dniBuscar = scanner.nextLine();
                    boolean encontrado = false;
                    for (Cliente c : clientes) {
                        if (c.getDni().equals(dniBuscar)) {
                            System.out.println(c);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 3:
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 4:
                    int contOcasional = 0;
                    for (Cliente c : clientes) {
                        if (c.getTipoCliente().equalsIgnoreCase("ocasional")) {
                            System.out.println(c);
                            contOcasional++;
                        }
                    }
                    System.out.println("Cantidad de clientes ocasionales: " + contOcasional);
                    break;
                case 5:
                    int contFrecuente = 0;
                    for (Cliente c : clientes) {
                        if (c.getTipoCliente().equalsIgnoreCase("frecuente")) {
                            System.out.println(c);
                            contFrecuente++;
                        }
                    }
                    System.out.println("Cantidad de clientes frecuentes: " + contFrecuente);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
