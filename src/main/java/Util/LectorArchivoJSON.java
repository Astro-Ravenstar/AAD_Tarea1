package Util;

import Model.Empleado;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LectorArchivoJSON {

    public static List<Empleado> leerArchivoJSON(String rutaArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Crear un objeto auxiliar para mapear la estructura del JSON
        EmpleadosWrapper empleadosWrapper = objectMapper.readValue(new File(rutaArchivo), EmpleadosWrapper.class);

        return empleadosWrapper.getEmpleados();
    }

    // Clase auxiliar para mapear el JSON
    public static class EmpleadosWrapper {
        private List<Empleado> empleados;

        public List<Empleado> getEmpleados() {
            return empleados;
        }

        public void setEmpleados(List<Empleado> empleados) {
            this.empleados = empleados;
        }
    }
}
