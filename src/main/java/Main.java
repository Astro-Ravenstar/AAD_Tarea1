import Data.DataSetEmpleados;
import Model.Empleado;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = DataSetEmpleados.generarEmpleados();

        // Imprimir cada empleado en consola
        empleados.forEach(System.out::println);
    }
}