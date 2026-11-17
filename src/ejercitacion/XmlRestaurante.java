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

public class XmlRestaurante {
	public static void main(String[] args) {
		
		Path fichero = Path.of("documentosXML/restaurante.xml");
		
		try {
			Files.createDirectories(fichero.getParent());
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document documento = db.newDocument();
			
			
			//Elemento raíz
			Element raiz = documento.createElement("restaurante");
			raiz.setAttribute("nombre", "El Café de Galileo");
			raiz.setAttribute("ciudad","Neuquen");
			documento.appendChild(raiz);
			
			Element menu = documento.createElement("menu");
			raiz.appendChild(menu);
			
			//Productos disponibles
			Element producto1 = documento.createElement("producto");
			producto1.setAttribute("id", "1");
			producto1.setAttribute("tipo","bebida");
			menu.appendChild(producto1);
			
			Element nombre1 = documento.createElement("nombre");
			nombre1.setTextContent("Café con leche");
			producto1.appendChild(nombre1);
			
			Element precio1 = documento.createElement("precio");
			precio1.setTextContent("1.20");
			producto1.appendChild(precio1);
			
			
			Element producto2 = documento.createElement("producto");
			producto2.setAttribute("id", "2");
			producto2.setAttribute("tipo", "bebida");
			menu.appendChild(producto2);
			
			Element nombre2 = documento.createElement("nombre");
			nombre2.setTextContent("Café solo");
			producto2.appendChild(nombre2);
			
			Element precio2 = documento.createElement("precio");
			precio2.setTextContent("1.00");
			producto2.appendChild(precio2);
			
			Element producto3 = documento.createElement("producto");
			producto3.setAttribute("id", "3");
			producto3.setAttribute("tipo","comida");
			menu.appendChild(producto3);
			
			Element nombre3 = documento.createElement("nombre");
			nombre3.setTextContent("Criollitos");
			producto3.appendChild(nombre3);
			
			Element precio3 = documento.createElement("precio");
			precio3.setTextContent("0.30");
			producto3.appendChild(precio3);
			
			Element producto4 = documento.createElement("producto");
			producto4.setAttribute("id", "4");
			producto4.setAttribute("tipo","comida");
			menu.appendChild(producto4);
			
			Element nombre4 = documento.createElement("nombre");
			nombre4.setTextContent("Medialuna");
			producto4.appendChild(nombre4);
			
			Element precio4 = documento.createElement("precio");
			precio4.setTextContent("0.80");
			producto4.appendChild(precio4);
			// Pedidos
			Element pedido1 = documento.createElement("pedido");
			pedido1.setAttribute("id", "orden:1");
			pedido1.setAttribute("estado", "Entregado");
			raiz.appendChild(pedido1);
			
			Element cliente1 = documento.createElement("cliente");
			cliente1.setTextContent("Carlos Pérez");
			pedido1.appendChild(cliente1);
			
			Element items1 = documento.createElement("items_pedidos");
			items1.setTextContent("Café solo y criollitos");
			pedido1.appendChild(items1);
			
			Element total1 = documento.createElement("total");
			total1.setTextContent("1.30");
			pedido1.appendChild(total1);
			
			Element pedido2 = documento.createElement("pedido");
			pedido2.setAttribute("id", "orden:2");
			pedido2.setAttribute("estado", "Preparando");
			raiz.appendChild(pedido2);
			
			Element cliente2 = documento.createElement("cliente");
			cliente2.setTextContent("Laura Diale");
			pedido2.appendChild(cliente2);
			
			Element items2 = documento.createElement("items_pedidos");
			items2.setTextContent("Café con leche y medialuna");
			pedido2.appendChild(items2);
			
			Element total2 = documento.createElement("total");
			total2.setTextContent("2.0");
			pedido2.appendChild(total2);
			
			

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
			System.out.println("error en la ruta del fichero");
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
