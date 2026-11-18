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

public class ModificarXmlRestaurante {
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document documento = db.parse("documentosXML/restaurante.xml");
			
			documento.getDocumentElement().normalize();
			
			Element raiz = documento.getDocumentElement();
			
			NodeList listaProductos = documento.getElementsByTagName("producto");
			
			for(int i =0; i< listaProductos.getLength();i++) {
				Node nodoProducto = listaProductos.item(i);
				
				if(nodoProducto.getNodeType()==Node.ELEMENT_NODE) {
					Element elementoProducto = (Element) nodoProducto;
					
					if(elementoProducto.getAttribute("id").equals("3")) {
					  Element precioElemento = (Element) elementoProducto.getElementsByTagName("precio").item(0);
					  precioElemento.setTextContent("0.45");
					  System.out.println("Precio del criollito actualizado.");
					}
				}
			}
			
			//Modificamos el pedido
			
			NodeList listaPedidos = documento.getElementsByTagName("pedido");
			for(int i =0; i< listaPedidos.getLength();i++) {
				Node nodoPedido = listaPedidos.item(i);
				
				if(nodoPedido.getNodeType()==Node.ELEMENT_NODE) {
					Element elementoPedido = (Element) nodoPedido;
					if(elementoPedido.getAttribute("estado").equals("Preparando")) {
						elementoPedido.setAttribute("estado", "Entregado");
						System.out.println("Estado cambiado");
					}
				}
			}
			
			Element padre = (Element) raiz.getElementsByTagName("menu").item(0);
			
			Element productoNuevo = documento.createElement("producto");
			productoNuevo.setAttribute("id", "5");
			productoNuevo.setAttribute("tipo","comida");
			padre.appendChild(productoNuevo);
			
			
			Element nombreNuevo = documento.createElement("nombre");
			nombreNuevo.setTextContent("Tarta de queso");
			productoNuevo.appendChild(nombreNuevo);
			
			Element precioNuevo = documento.createElement("precio");
			precioNuevo.setTextContent("3.50");
			productoNuevo.appendChild(precioNuevo);
			
			System.out.println("Producto nuevo incluido en el menú");
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			
			  // Truco estético: Indentar el XML para que no salga todo en una sola línea
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            
            DOMSource dSource = new DOMSource(documento);
            StreamResult result = new StreamResult("documentosXML/restaurante.xml");
            
			transformer.transform(dSource, result);
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
