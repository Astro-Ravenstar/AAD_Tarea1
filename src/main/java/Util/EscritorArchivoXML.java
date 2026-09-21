package Util;

import Model.Empleado;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorArchivoXML {

    public static void escribirArchivoXML(String rutaArchivo, List<Empleado> empleados) throws IOException {
        Element rootElement = new Element("empleados");
        Document documento = new Document(rootElement);

        for (Empleado empleado : empleados) {
            Element empleadoElement = new Element("empleado");

            Element idElement = new Element("id").setText(String.valueOf(empleado.getId()));
            Element nombreElement = new Element("nombre").setText(empleado.getNombre());
            Element dniElement = new Element("dni").setText(empleado.getDni());

            Element sueldosElement = new Element("sueldos");
            for (Double sueldo : empleado.getSueldosMensuales()) {
                sueldosElement.addContent(new Element("sueldo").setText(String.valueOf(sueldo)));
            }

            empleadoElement.addContent(idElement);
            empleadoElement.addContent(nombreElement);
            empleadoElement.addContent(dniElement);
            empleadoElement.addContent(sueldosElement);

            rootElement.addContent(empleadoElement);
        }

        // Guardar el archivo XML
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.setFormat(Format.getPrettyFormat());
        try (FileWriter fileWriter = new FileWriter(rutaArchivo)) {
            xmlOutputter.output(documento, fileWriter);
        }
    }

    public static void escribirDatosGenerados(String rutaArchivo, List<Empleado> empleados) throws IOException {
        Element rootElement = new Element("empleados");
        Document documento = new Document(rootElement);

        for (Empleado empleado : empleados) {
            Element empleadoElement = new Element("empleado");

            empleadoElement.addContent(new Element("id").setText(String.valueOf(empleado.getId())));
            empleadoElement.addContent(new Element("nombre").setText(empleado.getNombre()));
            empleadoElement.addContent(new Element("dni").setText(empleado.getDni()));

            Element sueldosElement = new Element("sueldos");
            for (Double sueldo : empleado.getSueldosMensuales()) {
                sueldosElement.addContent(new Element("sueldo").setText(String.valueOf(sueldo)));
            }
            empleadoElement.addContent(sueldosElement);

            rootElement.addContent(empleadoElement);
        }

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.setFormat(Format.getPrettyFormat());
        try (FileWriter fileWriter = new FileWriter(rutaArchivo)) {
            xmlOutputter.output(documento, fileWriter);
        }
    }

}
