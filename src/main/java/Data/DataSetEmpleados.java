package Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import Model.Empleado;
import Util.Configuracion;
import Util.EscritorArchivoCSV;
import Util.EscritorArchivoTXT;

public class DataSetEmpleados {

    // Méto.do estático que genera la lista de empleados
    public static List<Empleado> generarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        Random random = new Random();

        // Nombres y DNIs de ejemplo
        String[] nombres = {"Juan Pérez", "María García", "Pedro Rodríguez", "Laura Sánchez", "Javier López",
                "Ana Fernández", "Miguel Torres", "Lucía Martín", "Raúl González", "Carmen Ruiz",
                "Sergio Hernández", "Sofía Morales", "David Castillo", "Isabel Ortega", "Manuel Vega",
                "Paula Rojas", "Rubén Giménez", "Adriana Ramos", "José Ibáñez", "Claudia Pardo",
                "Vicente Varela", "Andrea Gutiérrez", "Fernando Serrano", "Beatriz Díaz", "Diego Romero"};

        String[] dnis = {"12345678A", "87654321B", "12398745C", "87451236D", "74951238E", "98234567F", "34567821G",
                "54872345H", "67543218I", "32458769J", "82736451K", "92748365L", "43658729M", "98237465N",
                "12387594O", "76543218P", "12983756Q", "67834512R", "98237645S", "78452139T",
                "92387546U", "34827619V", "23879456W", "87236451X", "94738265Y"};

        // Generar 25 empleados
        for (int i = 0; i < 25; i++) {
            List<Double> sueldosMensuales = generarSueldosAleatorios(random);
            Empleado empleado = new Empleado(i + 1, nombres[i], dnis[i], sueldosMensuales);
            empleados.add(empleado);
        }

        return empleados;
    }

    // Méto.do auxiliar para generar sueldos aleatorios entre 1200 y 2000 euros
    private static List<Double> generarSueldosAleatorios(Random random) {
        List<Double> sueldosMensuales = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            double sueldo = 1200 + (800 * random.nextDouble()); // Generar sueldos entre 1200 y 2000
            sueldosMensuales.add(sueldo);
        }
        return sueldosMensuales;
    }

    // Métodos para escribir el dataset (datos generados) en diferentes formatos
    public static void escribirDatasetTXT(List<Empleado> empleados) throws IOException {
        Configuracion configuracion = new Configuracion();
        String rutaArchivo = configuracion.getProperty("ruta.txt");
        EscritorArchivoTXT.escribirDatosGenerados(rutaArchivo, empleados);
    }

    public static void escribirDatasetCSV(List<Empleado> empleados) throws IOException {
        Configuracion configuracion = new Configuracion();
        String rutaArchivo = configuracion.getProperty("ruta.csv");
        EscritorArchivoCSV.escribirDatosGenerados(rutaArchivo, empleados);
    }

    public static void escribirDatasetExcel(List<Empleado> empleados) throws IOException {
        Configuracion configuracion = new Configuracion();
        String rutaArchivo = configuracion.getProperty("ruta.xlsx");
        EscritorArchivoExcel.escribirDatosOriginales(rutaArchivo, empleados);
    }

    public static void escribirDatasetXML(List<Empleado> empleados) throws IOException {
        Configuracion configuracion = new Configuracion();
        String rutaArchivo = configuracion.getProperty("ruta.xml");
        EscritorArchivoXML.escribirDatosOriginales(rutaArchivo, empleados);
    }

    public static void escribirDatasetJSON(List<Empleado> empleados) throws IOException {
        Configuracion configuracion = new Configuracion();
        String rutaArchivo = configuracion.getProperty("ruta.json");
        EscritorArchivoJSON.escribirDatosOriginales(rutaArchivo, empleados);
    }

}