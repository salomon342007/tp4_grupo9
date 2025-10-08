package ar.edu.unju.escmi.tp4.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
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
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
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
                        nuevo.setEstatura(Double.parseDouble(estaturaStr.replace(",", ".")));
                    } catch (NumberFormatException e) {
                        System.out.println("Estatura inválida. Se asigna 0.");
                        nuevo.setEstatura(0);
                    }
                    jugadores.add(nuevo);
                    System.out.println("Jugador agregado.");
                    break;
                case 2:
                    System.out.print("Ingrese DNI del jugador a modificar: ");
                    String dniMod = sc.nextLine();
                    boolean encontrado = false;
                    for (Jugador j : jugadores) {
                        if (j.getDni().equals(dniMod)) {
                            encontrado = true;
                            System.out.println("Datos actuales:");
                            j.mostrarDatos();
                            System.out.print("Nuevo Nombre: ");
                            j.setNombre(sc.nextLine());
                            System.out.print("Nuevo Equipo: ");
                            j.setEquipo(sc.nextLine());
                            System.out.print("Nueva Nacionalidad: ");
                            j.setNacionalidad(sc.nextLine());
                            System.out.print("Nueva Estatura: ");
                            j.setEstatura(sc.nextDouble());
                            sc.nextLine();
                            System.out.println("Datos modificados.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encuentra el dni");
                    }
                    break;
                case 3:
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
                    if (jugadores.isEmpty()) {
                        System.out.println("No hay jugadores en la lista.");
                    } else {
                        for (Jugador j : jugadores) {
                            j.mostrarDatos();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Cantidad de jugadores: " + jugadores.size());
                    break;
                case 6:
                    jugadores.clear();
                    System.out.println("Lista de jugadores limpiada.");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        sc.close();
    }
}
