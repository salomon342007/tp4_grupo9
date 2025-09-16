package ar.edu.unju.escmi.tp4.Ejercicio3;

import java.util.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Paciente> pacientes = new TreeSet<>();
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 – Alta de paciente.");
            System.out.println("2 – Mostrar todos los pacientes.");
            System.out.println("3 – Mostrar el paciente de la mitad de la lista.");
            System.out.println("4 – Mostrar el primer paciente de la lista.");
            System.out.println("5 – Mostrar el último paciente de la lista.");
            System.out.println("6 – Filtrar por historia clínica.");
            System.out.println("7 – Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Paciente p = new Paciente();
                    System.out.print("DNI: ");
                    p.setDni(scanner.nextLine());
                    System.out.print("Nombre: ");
                    p.setNombre(scanner.nextLine());
                    System.out.print("Apellido: ");
                    p.setApellido(scanner.nextLine());
                    System.out.print("Número de historia clínica: ");
                    p.setNumeroHistoriaClinica(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Obra social: ");
                    p.setObraSocial(scanner.nextLine());
                    pacientes.add(p);
                    System.out.println("Paciente agregado.");
                    break;

                case 2:
                    pacientes.stream().forEach(System.out::println);
                    break;

                case 3:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes.");
                    } else {
                        int mitad = pacientes.size() / 2;
                        Iterator<Paciente> it = pacientes.iterator();
                        Paciente pacienteMitad = null;
                        for (int i = 0; i <= mitad; i++) {
                            pacienteMitad = it.next();
                        }
                        System.out.println("Paciente en la mitad de la lista: " + pacienteMitad);
                    }
                    break;

                case 4:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes.");
                    } else {
                        System.out.println("Primer paciente: " + pacientes.first());
                    }
                    break;

                case 5:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes.");
                    } else {
                        System.out.println("Último paciente: " + pacientes.last());
                    }
                    break;

                case 6:
                    System.out.print("Ingrese número de historia clínica para filtrar: ");
                    int filtro = scanner.nextInt();
                    scanner.nextLine();
                    pacientes.stream()
                        .filter(pa -> pa.getNumeroHistoriaClinica() > filtro)
                        .forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}