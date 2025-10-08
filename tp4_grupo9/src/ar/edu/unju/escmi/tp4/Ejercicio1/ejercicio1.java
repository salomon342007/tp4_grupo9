package ar.edu.unju.escmi.tp4.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    // Programa principal: menú para administrar una lista de jugadores
    public static void main(String[] args) {
        // Lista dinámica que almacena objetos Jugador
        ArrayList<Jugador> jugadores = new ArrayList<>();
        // Scanner para leer la entrada del usuario desde consola
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú de opciones al usuario
            System.out.println("----- Menú de Jugadores -----");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Modificar datos de un jugador");
            System.out.println("3 - Eliminar un jugador");
            System.out.println("4 - Mostrar todos los jugadores");
            System.out.println("5 - Mostrar cantidad de jugadores");
            System.out.println("6 - Limpiar lista de jugadores");
            System.out.println("7 - Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer después de leer un entero

            switch (opcion) {
                case 1:
                    // Alta: crear un nuevo Jugador y pedir sus datos por consola
                    Jugador nuevo = new Jugador();
                    System.out.print("Ingrese DNI: ");
                    nuevo.setDni(sc.nextLine());
                    System.out.print("Ingrese Nombre: ");
                    nuevo.setNombre(sc.nextLine());
                    System.out.print("Ingrese Equipo: ");
                    nuevo.setEquipo(sc.nextLine());
                    System.out.print("Ingrese Nacionalidad: ");
                    nuevo.setNacionalidad(sc.nextLine());
                    System.out.print("Ingrese Estatura: ");
                    String estaturaStr = sc.nextLine();
                    try {
                        // Aceptar coma o punto decimal al parsear
                        nuevo.setEstatura(Double.parseDouble(estaturaStr.replace(",", ".")));
                    } catch (NumberFormatException e) {
                        // En caso de error asignar 0 y notificar
                        System.out.println("Estatura inválida. Se asigna 0.");
                        nuevo.setEstatura(0);
                    }
                    jugadores.add(nuevo); // Agregar a la lista
                    System.out.println("Jugador agregado.");
                    break;
                case 2:
                    // Modificar: buscar por DNI y actualizar atributos
                    System.out.print("Ingrese DNI del jugador a modificar: ");
                    String dniMod = sc.nextLine();
                    boolean encontrado = false;
                    for (Jugador j : jugadores) {
                        if (j.getDni().equals(dniMod)) {
                            encontrado = true;
                            System.out.println("Datos actuales:");
                            j.mostrarDatos(); // Mostrar datos antes de modificar
                            System.out.print("Nuevo Nombre: ");
                            j.setNombre(sc.nextLine());
                            System.out.print("Nuevo Equipo: ");
                            j.setEquipo(sc.nextLine());
                            System.out.print("Nueva Nacionalidad: ");
                            j.setNacionalidad(sc.nextLine());
                            System.out.print("Nueva Estatura: ");
                            j.setEstatura(sc.nextDouble());
                            sc.nextLine(); // Limpiar buffer tras leer double
                            System.out.println("Datos modificados.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encuentra el dni");
                    }
                    break;
                case 3:
                    // Eliminar: buscar por DNI y remover de la lista
                    System.out.print("Ingrese DNI del jugador a eliminar: ");
                    String dniDel = sc.nextLine();
                    Jugador jugadorEliminar = null;
                    for (Jugador j : jugadores) {
                        if (j.getDni().equals(dniDel)) {
                            jugadorEliminar = j;
                            break;
                        }
                    }
                    if (jugadorEliminar != null) {
                        jugadores.remove(jugadorEliminar);
                        System.out.println("Jugador eliminado.");
                    } else {
                        System.out.println("No se encuentra el dni");
                    }
                    break;
                case 4:
                    // Mostrar todos: iterar y llamar al método mostrarDatos
                    if (jugadores.isEmpty()) {
                        System.out.println("No hay jugadores en la lista.");
                    } else {
                        for (Jugador j : jugadores) {
                            j.mostrarDatos();
                        }
                    }
                    break;
                case 5:
                    // Mostrar cantidad actual de jugadores
                    System.out.println("Cantidad de jugadores: " + jugadores.size());
                    break;
                case 6:
                    // Limpiar la lista por completo
                    jugadores.clear();
                    System.out.println("Lista de jugadores limpiada.");
                    break;
                case 7:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Opción inválida ingresada por el usuario
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        sc.close(); // Cerrar Scanner para liberar recurso
    }
}