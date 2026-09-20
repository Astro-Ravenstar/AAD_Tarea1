package Model;

import java.util.List;
import java.util.stream.*;

public class Empleado {

    private int id;
    private String nombre;
    private String dni;
    private List<Double> sueldosMensuales;

    // Constructor
    public Empleado(int id, String nombre, String dni, List<Double> sueldosMensuales) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.sueldosMensuales = sueldosMensuales;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Double> getSueldosMensuales() {
        return sueldosMensuales;
    }

    public void setSueldosMensuales(List<Double> sueldosMensuales) {
        this.sueldosMensuales = sueldosMensuales;
    }

    // Método para calcular el sueldo medio
    public double calcularSueldoMedio() {
        return sueldosMensuales.stream()
                .mapToDouble(Double::doubleValue)
                .sum()/sueldosMensuales.toArray().length;
    }

    // Método para obtener el sueldo máximo
    public double obtenerSueldoMaximo() {
        return sueldosMensuales.stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0.0);
    }

    // Método para obtener el sueldo mínimo
    public double obtenerSueldoMinimo() {
        return sueldosMensuales.stream()
                .mapToDouble(Double::doubleValue)
                .min()
                .orElse(0.0);
    }

    // Método toString para mostrar información del empleado
    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", sueldosMensuales=" + sueldosMensuales +
                '}';
    }
}