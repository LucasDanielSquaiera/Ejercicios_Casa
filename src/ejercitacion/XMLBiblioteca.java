package ejercitacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLBiblioteca {
	public static void main(String[] args) {
		Path fichero = Path.of("documentosXML/biblioteca.xml");
		
		try {
			
			try {
				Files.createDirectories(fichero.getParent());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Creamos la estructura
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();
			
			//Elemento raíz
			Element raiz = doc.createElement("biblioteca");
			doc.appendChild(raiz);
			
			//elemento padre
			Element libro1 = doc.createElement("libro");
			libro1.setAttribute("isbn","978-65-321");
		
			
			//elementos hijos
			Element titulo1 = doc.createElement("titulo");
			titulo1.setTextContent("Libro 1");
			libro1.appendChild(titulo1);
			
			Element precio1 = doc.createElement("precio");
			precio1.setTextContent("12.50");
			libro1.appendChild(precio1);
			//Lo agregamos a la raíz
			raiz.appendChild(libro1);
			
			//elemento padre
			Element libro2 = doc.createElement("libro");
			libro2.setAttribute("isbn","978-65-123");
			
			
			//elementos hijos
			Element titulo2 = doc.createElement("titulo");
			titulo2.setTextContent("Libro 2");
			libro2.appendChild(titulo2);
			
			Element precio2 = doc.createElement("precio");
			precio2.setTextContent("12.50");
			libro2.appendChild(precio2);
			
			raiz.appendChild(libro2);
			
			//elemento padre
			Element libro3 = doc.createElement("libro");
			libro3.setAttribute("isbn","978-65-213");
		
			
			//elementos hijos
			Element titulo3 = doc.createElement("titulo");
			titulo3.setTextContent("Libro 3");
			libro3.appendChild(titulo3);
			
			Element precio3 = doc.createElement("precio");
			precio3.setTextContent("12.50");
			libro3.appendChild(precio3);
			
			
			// Los colgamos de la raíz a cada elemento padre que a su vez contienen a los elementos hijos
			
			raiz.appendChild(libro3);
			
			// Esto qué hace? 
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			
			  // Truco estético: Indentar el XML para que no salga todo en una sola línea
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            
            DOMSource dSource = new DOMSource(doc);
            StreamResult result = new StreamResult(fichero.toFile());
            
			transformer.transform(dSource, result);
			
			System.out.println("Comprobamos que sale bien!");
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
