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

public class XmlMaraton {
	public static void main(String[] args) {
	
		Path fichero = Path.of("documentosXML/maraton.xml");
		
		try {
			Files.createDirectories(fichero.getParent());
			
			//Creamos estructura
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document documento = db.newDocument();
			
			// Comenzamos la estructura
			
			Element raiz = documento.createElement("maraton");
			raiz.setAttribute("nombre","Maratón Internacional Ciudad Galileo");
			raiz.setAttribute("edicion","15");
			documento.appendChild(raiz);
			
			Element infoGeneral = documento.createElement("informacion_general");
			raiz.appendChild(infoGeneral);
			
			Element fecha = documento.createElement("fecha");
			fecha.setTextContent("2026-11-15");
			infoGeneral.appendChild(fecha);
			
			Element ciudad = documento.createElement("ciudad");
			ciudad.setTextContent("Valladolid");
			infoGeneral.appendChild(ciudad);
			
			Element distancia = documento.createElement("distancia");
			distancia.setAttribute("unidad","km");
			distancia.setTextContent("42.195");
			infoGeneral.appendChild(distancia);
			
			Element participantes = documento.createElement("participantes");
			raiz.appendChild(participantes);
			
			Element corredor1 = documento.createElement("corredor");
			corredor1.setAttribute("dorsal", "102");
			corredor1.setAttribute("categoria", "popular");
			participantes.appendChild(corredor1);
			
			Element nombre1 = documento.createElement("nombre");
			nombre1.setTextContent("Carlos");
			corredor1.appendChild(nombre1);
			Element apellidos1 = documento.createElement("apellidos");
			apellidos1.setTextContent("Gómez Ruiz");
			corredor1.appendChild(apellidos1);
			Element edad1 = documento.createElement("edad");
			edad1.setTextContent("29");
			corredor1.appendChild(edad1);
			Element pais1 = documento.createElement("pais");
			pais1.setTextContent("España");
			corredor1.appendChild(pais1);
			Element tiempoFinal1 = documento.createElement("tiempo_final");
			tiempoFinal1.setTextContent("03:14:52");
			corredor1.appendChild(tiempoFinal1);
			
			Element corredor2 = documento.createElement("corredor");
			corredor2.setAttribute("dorsal", "103");
			corredor2.setAttribute("categoria", "Pro");
			participantes.appendChild(corredor2);
			
			Element nombre2 = documento.createElement("nombre");
			nombre2.setTextContent("Elena");
			corredor2.appendChild(nombre2);
			
			Element apellidos2 = documento.createElement("apellidos");
			apellidos2.setTextContent("Martínez Pérez");
			corredor2.appendChild(apellidos2);
			
			Element edad2 = documento.createElement("edad");
			edad2.setTextContent("34");
			corredor2.appendChild(edad2);
			
			Element pais2 = documento.createElement("pais");
			pais2.setTextContent("México");
			corredor2.appendChild(pais2);
			
			Element tiempoFinal2 = documento.createElement("tiempo_final");
			tiempoFinal2.setTextContent("02:15:12");
			corredor2.appendChild(tiempoFinal2);
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			
			  // Truco estético: Indentar el XML para que no salga todo en una sola línea
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            
            DOMSource dSource = new DOMSource(documento);
            StreamResult result = new StreamResult(fichero.toFile());
            
			transformer.transform(dSource, result);
			
			
			System.out.println("XML generado");
			
			
		} catch (IOException e) {
			System.out.println("Error con la ruta del fichero");
			e.printStackTrace();
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
