package ar.edu.unju.escmi.tp4.Ejercicio4;

public class Cliente {
    private String dni;
    private String nombre;
    private String tipoCliente; // "ocasional" o "frecuente"

    public Cliente(String dni, String nombre, String tipoCliente) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getTipoCliente() { return tipoCliente; }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni.equals(cliente.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
