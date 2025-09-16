package ar.edu.unju.escmi.tp4.Ejercicio4;

import java.util.HashSet;

public class ejercicio4 {
    public static void main(String[] args) {
        HashSet<Cliente> clientes = new HashSet<>();

        clientes.add(new Cliente("12345678", "Juan Perez", "frecuente"));
        clientes.add(new Cliente("87654321", "Ana Gomez", "ocasional"));
        clientes.add(new Cliente("11223344", "Carlos Ruiz", "frecuente"));

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
