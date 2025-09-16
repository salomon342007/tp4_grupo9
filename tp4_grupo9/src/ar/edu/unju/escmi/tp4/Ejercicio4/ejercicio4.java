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
            System.out.println("3 – Buscar cliente por DNI");
            System.out.println("4 – Mostrar todos los clientes ocasionales y la cantidad");
            System.out.println("5 – Mostrar todos los clientes frecuentes y la cantidad");
            System.out.println("6 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

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
                    Cliente nuevoCliente = new Cliente(dni, nombre, tipo);
                    clientes.add(nuevoCliente);
                    System.out.println("Cliente creado exitosamente.");
                    break;
                case 2:
                   
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        clientes.stream().forEach(c -> System.out.println(c));
                    }
                    break;
                case 3:
                   
                    System.out.print("Ingrese DNI del cliente a buscar: ");
                    String dniBuscar = scanner.nextLine();
                    boolean encontrado = clientes.stream()
                        .filter(c -> c.getDni().equals(dniBuscar))
                        .peek(c -> System.out.println(c))
                        .findFirst()
                        .isPresent();
                    if (!encontrado) {
                        System.out.println("No se encontró el dni");
                    }
                    break;
                case 4:
                    
                    long cantidadOcasionales = clientes.stream()
                        .filter(c -> c.getTipoCliente().equalsIgnoreCase("ocasional"))
                        .peek(c -> System.out.println(c))
                        .count();
                    System.out.println("Cantidad de clientes ocasionales: " + cantidadOcasionales);
                    break;
                case 5:
                    
                    long cantidadFrecuentes = clientes.stream()
                        .filter(c -> c.getTipoCliente().equalsIgnoreCase("frecuente"))
                        .peek(c -> System.out.println(c))
                        .count();
                    System.out.println("Cantidad de clientes frecuentes: " + cantidadFrecuentes);
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
