package Frame;

import Data.DataSetEmpleados;
import Model.Empleado;
import Util.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuSeleccion {

    public static void mostrarMenu() throws Exception {
        // Generar el dataset y escribir los archivos de datos
        List<Empleado> empleados = DataSetEmpleados.generarEmpleados();
        generarArchivosDeDatos(empleados);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de archivo a procesar:");
        System.out.println("1. TXT");
        System.out.println("2. CSV");
        System.out.println("3. Excel");
        System.out.println("4. XML");
        System.out.println("5. JSON");
        System.out.println("0. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea nueva después del número

        String rutaArchivo = null;
        List<Empleado> empleadosLeidos = null;

        switch (opcion) {
            case 1:
                try {
                    rutaArchivo = new Configuracion().getProperty("ruta.txt");
                    empleadosLeidos = LectorArchivoTXT.leerArchivoTXT(rutaArchivo);
                } catch (FileNotFoundException e) {
                    System.out.println("No se encontró el archivo en la ruta predeterminada:\n"
                            + rutaArchivo + ".");
                }
                break;
            case 2:
                try {
                    rutaArchivo = new Configuracion().getProperty("ruta.csv");
                    empleadosLeidos = LectorArchivoCSV.leerArchivoCSV(rutaArchivo);
                } catch (FileNotFoundException e) {
                    System.out.println("No se encontró el archivo en la ruta predeterminada:\n"
                            + rutaArchivo + ".");
                }
                break;
            case 3:
                try {
                    rutaArchivo = new Configuracion().getProperty("ruta.xlsx");
                    empleadosLeidos = LectorArchivoExcel.leerArchivoExcel(rutaArchivo);
                } catch (FileNotFoundException e) {
                    System.out.println("No se encontró el archivo en la ruta predeterminada:\n"
                            + rutaArchivo + ".");
                }
                break;
            case 4:
                try {
                    rutaArchivo = new Configuracion().getProperty("ruta.xml");
                    empleadosLeidos = LectorArchivoXML.leerArchivoXML(rutaArchivo);
                } catch (FileNotFoundException e) {
                    System.out.println("No se encontró el archivo en la ruta predeterminada:\n"
                            + rutaArchivo + ".");
                }
                break;
            case 5:
                try {
                    rutaArchivo = new Configuracion().getProperty("ruta.json");
                    empleadosLeidos = LectorArchivoJSON.leerArchivoJSON(rutaArchivo);
                }
                catch (FileNotFoundException e) {
                    System.out.println("No se encontró el archivo en la ruta predeterminada:\n"
                            + rutaArchivo + ".");
                }
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                return;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (empleadosLeidos != null) {
            mostrarSumario(empleadosLeidos);
            System.out.println("Introduzca la ruta para el archivo de salida:");
            String rutaSalida = scanner.nextLine();

            // Guardar el archivo en el mismo formato que el archivo de entrada
            switch (opcion) {
                case 1:
                    EscritorArchivoTXT.escribirDatosGenerados(rutaSalida, empleadosLeidos);
                    break;
                case 2:
                    EscritorArchivoCSV.escribirDatosGenerados(rutaSalida, empleadosLeidos);
                    break;
                case 3:
                    EscritorArchivoExcel.escribirDatosGenerados(rutaSalida, empleadosLeidos);
                    break;
                case 4:
                    EscritorArchivoXML.escribirDatosGenerados(rutaSalida, empleadosLeidos);
                    break;
                case 5:
                    EscritorArchivoJSON.escribirDatosGenerados(rutaSalida, empleadosLeidos);
                    break;
            }
        }
    }

    // Método para mostrar el sumario en consola
    private static void mostrarSumario(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            double salMed = empleado.calcularSueldoMedio();
            double salMax = empleado.obtenerSueldoMaximo();
            double salMin = empleado.obtenerSueldoMinimo();
            System.out.printf("Empleado: " + empleado.getNombre() + " , Sueldo medio = " + salMed +
                    " , Sueldo máximo = " + salMax +
                    " , Sueldo mínimo = " + salMin + ".\n");
        }
    }

    // Método para generar los archivos de datos
    private static void generarArchivosDeDatos(List<Empleado> empleados) throws IOException {
        DataSetEmpleados.escribirDatasetTXT(empleados);
        DataSetEmpleados.escribirDatasetCSV(empleados);
        DataSetEmpleados.escribirDatasetExcel(empleados);
        DataSetEmpleados.escribirDatasetXML(empleados);
        DataSetEmpleados.escribirDatasetJSON(empleados);

    }
}