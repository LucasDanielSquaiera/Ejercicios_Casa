package ejercitacion;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXmlEmpleados {
    public static void main(String[] args) {
        try {
            Path dir = Path.of("datos");
            Files.createDirectories(dir);

            // 1. Obtener la fábrica y construir un documento DOM vacío en memoria
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // 2. Crear el elemento raíz del árbol: <empleados>
            Element rootElement = doc.createElement("empleados");
            doc.appendChild(rootElement);

            // 3. Crear el primer empleado (Ej: ID 10)
            Element empleado1 = doc.createElement("empleado");
            empleado1.setAttribute("id", "10"); // Atributo ID

            // Crear nodo hijo <sueldo>
            Element sueldo1 = doc.createElement("sueldo");
            sueldo1.setTextContent("1500.0");
            empleado1.appendChild(sueldo1);

            // Crear nodo hijo <nombre>
            Element nombre1 = doc.createElement("nombre");
            nombre1.setTextContent("Lautaro Machuca");
            empleado1.appendChild(nombre1);

            // Colgar el empleado dentro de la raíz <empleados>
            rootElement.appendChild(empleado1);

            // --- Podríamos añadir más empleados de la misma forma ---

            // 4. Volcar (serializar) el árbol DOM desde la memoria RAM a un fichero físico en disco
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            // Truco estético: Indentar el XML para que no salga todo en una sola línea
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("datos/empleados.xml"));

            transformer.transform(source, result);

            System.out.println("¡Fichero XML creado e indentado con éxito en datos/empleados.xml!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}