package ar.edu.unju.escmi.tp4.Ejercicio2;

public class Empleado {
    private String dni;
    private String nombre;
    private String apellido;
    private double sueldo;
    private char categoria;

    public Empleado(String dni, String nombre, String apellido, double sueldo, char categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.categoria = categoria;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public double getSueldo() { return sueldo; }
    public char getCategoria() { return categoria; }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sueldo=" + sueldo +
                ", categoria=" + categoria +
                '}';
    }
}