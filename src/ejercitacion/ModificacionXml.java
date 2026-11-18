package ejercitacion;

import java.io.IOException;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModificacionXml {
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		try {
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		Document documento = db.parse("documentosXML/biblioteca.xml");
		documento.getDocumentElement().normalize();
		
		NodeList listaLibros = documento.getElementsByTagName("libro");
		String nombreActual;
		for(int i = 0; i< listaLibros.getLength(); i++) {
			Node nodoLibro = listaLibros.item(i);
			
			if(nodoLibro.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoLibro = (Element) nodoLibro;
				
				if(elementoLibro.getAttribute("isbn").equals("978-65-321")) {
					nombreActual = documento.getDocumentElement().getElementsByTagName("titulo").item(0).getTextContent();
					System.out.println("Nombre original del libro: "+nombreActual);
					String nombreModificado = nombreActual.replace(nombreActual, nombreActual+" (Edición Especial)");
					System.out.println("Nombre modificado: " 
								+ nombreModificado);
					
				}
			}
		}
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		
		  // Truco estético: Indentar el XML para que no salga todo en una sola línea
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        
        
        DOMSource dSource = new DOMSource(documento);
        StreamResult result = new StreamResult("documentosXML/biblioteca.xml");
        
		transformer.transform(dSource, result);
		
		System.out.println("Modificación guardad en disco...");
		
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
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
