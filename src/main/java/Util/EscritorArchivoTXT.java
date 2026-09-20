package Util;

import Model.Empleado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorArchivoTXT {

    public static void escribirArchivoTXT(String rutaArchivo, List<Empleado> empleados) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Empleado empleado : empleados) {
                // Formatear la salida como id nombre dni sueldo medio sueldos mensuales
                bw.write(empleado.getId() + " " + empleado.getNombre() + " " + empleado.getDni() + " " +
                        empleado.calcularSueldoMedio());

                for (Double sueldo : empleado.getSueldosMensuales()) {
                    bw.write(" " + sueldo);
                }

                bw.newLine(); // Saltar a la siguiente línea
            }
        }
    }


    public static void escribirDatosGenerados(String rutaArchivo, List<Empleado> empleados) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Empleado empleado : empleados) {
                // Escribir id, nombre, dni y sueldos mensuales
                bw.write(empleado.getId() + " " + empleado.getNombre() + " " + empleado.getDni());

                for (Double sueldo : empleado.getSueldosMensuales()) {
                    bw.write(" " + sueldo);
                }

                bw.newLine();
            }
        }
    }

}
