package Frame;

import Data.DataSetEmpleados;
import Model.Empleado;
import Util.*;
import java.io.IOException;
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
                rutaArchivo = "empleados.txt";
                empleadosLeidos = LectorArchivoTXT.leerArchivoTXT(rutaArchivo);
                break;
            case 2:
                rutaArchivo = "empleados.csv";
                empleadosLeidos = LectorArchivoCSV.leerArchivoCSV(rutaArchivo);
                break;
            case 3:
                rutaArchivo = "empleados.xlsx";
                empleadosLeidos = LectorArchivoExcel.leerArchivoExcel(rutaArchivo);
                break;
            case 4:
                rutaArchivo = "empleados.xml";
                empleadosLeidos = LectorArchivoXML.leerArchivoXML(rutaArchivo);
                break;
            case 5:
                rutaArchivo = "empleados.json";
                empleadosLeidos = LectorArchivoJSON.leerArchivoJSON(rutaArchivo);
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
                    // hacer
                    break;
                case 2:
// hacer
                    break;
                case 3:
// hacer
                    break;
                case 4:
// hacer
                    break;
                case 5:
// hacer
                    break;
            }
        }
    }

    // Método para mostrar el sumario en consola
    private static void mostrarSumario(List<Empleado> empleados) {
        // hacer
    }

    // Método para generar los archivos de datos
    private static void generarArchivosDeDatos(List<Empleado> empleados) throws IOException {
        // hacer
    }
}