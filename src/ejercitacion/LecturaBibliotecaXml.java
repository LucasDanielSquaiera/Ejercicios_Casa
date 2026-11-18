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

public class LecturaBibliotecaXml {
	public static void main(String[] args) {
		//Leemos de forma inversa a cómo escribimos
	
		try {
			// Igual que escribir
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			// Parseamos el file
			Document documento = db.parse("documentosXML/biblioteca.xml");

			//Opcional normalizar pero recomendado para evitar nodos de texto vacíos o fragmentados
			documento.getDocumentElement().normalize();
			
			System.out.println("Elemento raíz: "+ documento.getDocumentElement().getNodeName());
			
			//Capturamos en una lista todos los elementos que se llamen libro
			NodeList listaLibros = documento.getElementsByTagName("libro");
			
			//Recorremos el nodeList como un array
			
			for(int i =0; i< listaLibros.getLength();i++) {
				Node nodoLibro = listaLibros.item(i);
				
				//Comprobamos que el nodo sea un elemento XML
				
				if(nodoLibro.getNodeType()==Node.ELEMENT_NODE) {
					Element elementoLibro = (Element) nodoLibro;
					
					//Extraemos atributos etiqueta
					String isbn = elementoLibro.getAttribute("isbn");
					//Extraemos los textContent - ojo no va el i en el item
					String titulo = elementoLibro.getElementsByTagName("titulo").item(0).getTextContent();
					String precio = elementoLibro.getElementsByTagName("precio").item(0).getTextContent();
					
					//Se imprimen datos limpios por consola
					
					System.out.println("Libro # "+ (i+1));
					System.out.println("- ISBN: "+isbn);
					System.out.println("- Título: "+titulo);
					System.out.println("- Precio: "+precio+"€\n");
					
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
