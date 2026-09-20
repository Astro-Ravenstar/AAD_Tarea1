package Util;

import Model.Empleado;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorArchivoCSV {

    public static void escribirArchivoCSV(String rutaArchivo, List<Empleado> empleados) throws IOException {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(rutaArchivo), CSVFormat.DEFAULT)) {
            for (Empleado empleado : empleados) {
                // Escribir id, nombre, dni, sueldo medio y sueldos mensuales
                csvPrinter.print(empleado.getId());
                csvPrinter.print(empleado.getNombre());
                csvPrinter.print(empleado.getDni());
                csvPrinter.print(empleado.calcularSueldoMedio());

                for (Double sueldo : empleado.getSueldosMensuales()) {
                    csvPrinter.print(sueldo);
                }

                csvPrinter.println();
            }
        }
    }

    public static void escribirDatosGenerados(String rutaArchivo, List<Empleado> empleados) throws IOException {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(rutaArchivo), CSVFormat.DEFAULT)) {
            for (Empleado empleado : empleados) {
                csvPrinter.print(empleado.getId());
                csvPrinter.print(empleado.getNombre());
                csvPrinter.print(empleado.getDni());

                for (Double sueldo : empleado.getSueldosMensuales()) {
                    csvPrinter.print(sueldo);
                }

                csvPrinter.println();
            }
        }
    }

}