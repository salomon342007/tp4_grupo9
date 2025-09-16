package ar.edu.unju.escmi.tp4.Ejercicio5;

import java.time.LocalDate;
import java.util.TreeMap;

public class ejercicio5 {
    public static void main(String[] args) {
        TreeMap<Integer, Producto> productos = new TreeMap<>();

        // Ejemplo de carga de productos
        productos.put(1, new Producto("Leche", 1200.50, LocalDate.of(2025, 10, 10)));
        productos.put(2, new Producto("Pan", 500.00, LocalDate.of(2025, 9, 20)));
        productos.put(3, new Producto("Queso", 2500.00, LocalDate.of(2025, 12, 5)));

        // Mostrar productos
        productos.forEach((k, v) -> System.out.println("Código: " + k + " - " + v));
    }
}
