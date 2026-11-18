package ejercitacion;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecturaMaraton {
	public static void main(String[] args) {
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document documento = db.parse("documentosXML/maraton.xml");
			documento.getDocumentElement().normalize();
			
			String nombre = documento.getDocumentElement().getAttribute("nombre");
			int edicion = Integer.parseInt(documento.getDocumentElement().getAttribute("edicion"));
			
			System.out.println("--- "+ nombre+" --- "+edicion+"º edición.");
			
			//Extrayendo corredores
			NodeList corredores = documento.getElementsByTagName("corredor");
			
			System.out.println("--Ganadores:");
			
			for(int i = 0;i < corredores.getLength();i++) {
				Node nodoCorredor = corredores.item(i);
				
				if(nodoCorredor.getNodeType() == Node.ELEMENT_NODE) {
					
					Element elementoCorredor = (Element) nodoCorredor;
					
					
					int dorsal = Integer.parseInt(elementoCorredor.getAttribute("dorsal"));
					String categoria = elementoCorredor.getAttribute("categoria");
					String nombreC = elementoCorredor.getElementsByTagName("nombre").item(0).getTextContent();
					String apellidos = elementoCorredor.getElementsByTagName("apellidos").item(0).getTextContent();
					String pais = elementoCorredor.getElementsByTagName("pais").item(0).getTextContent();
					String tiempoFinal = elementoCorredor.getElementsByTagName("tiempo_final").item(0).getTextContent();
					
					System.out.println("\n Categoría: "+categoria);
					System.out.println(" Puesto #"+(i+1)+": "+nombreC+" "+apellidos+".");
					System.out.println(" Procedente de "+pais);
					System.out.println(" Tiempo final: "+tiempoFinal);
				}
				
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
