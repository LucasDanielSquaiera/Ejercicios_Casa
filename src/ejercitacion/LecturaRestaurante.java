package ejercitacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecturaRestaurante {
	
	record Producto(int id,String tipo,String nombre, double precio) {}
	record Pedido(String id,String estado, String cliente, String pedido,double total) {}
	public static void main(String[] args) {
		
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document documento = db.parse("documentosXML/restaurante.xml");
			
			documento.getDocumentElement().normalize();
			Element raiz = documento.getDocumentElement();
			System.out.println("Restaurante: "+documento.getDocumentElement().getAttribute("nombre")
					+"	Ubicación: "+raiz.getAttribute("ciudad"));
			
			
			NodeList listaProductos = raiz.getElementsByTagName("producto"); 
			NodeList listaPedidos = raiz.getElementsByTagName("pedido");
			List<Producto> productos = new ArrayList<>();
			
			System.out.println("--- Menú ---");
			
			for(int i = 0; i < listaProductos.getLength();i++) {
				
				Node nodoProducto = listaProductos.item(i);
				
				if(nodoProducto.getNodeType() == Node.ELEMENT_NODE) {
					
					Element elementoProducto = (Element) nodoProducto;
					
					int idProducto = Integer.parseInt(elementoProducto.getAttribute("id"));
					String tipoProducto = elementoProducto.getAttribute("tipo");
					String nombreProducto = elementoProducto.getElementsByTagName("nombre").item(0).getTextContent();
					double precioProducto = Double.parseDouble(elementoProducto.getElementsByTagName("precio").item(0).getTextContent());
					
					productos.add(new Producto(idProducto,tipoProducto,nombreProducto,precioProducto));
					
					System.out.println("Producto id: "+idProducto+". Tipo de producto: "+tipoProducto);
					System.out.println("Nombre: "+nombreProducto);
					System.out.println("Precio: "+precioProducto+"€\n"); 	
				}
				
			}
			
			System.out.println("Listando menú desde un ArrayList de instancias de Producto: \n");
			for(Producto p : productos) {
				System.out.println(p);
			}
			
			List<Pedido> pedidos = new ArrayList<>();
			for(int i = 0; i < listaPedidos.getLength();i++) {
				Node nodoPedido = listaPedidos.item(i);
				
				if(nodoPedido.getNodeType() == Node.ELEMENT_NODE) {
					Element elementoPedido = (Element) nodoPedido;
					
					String idOrden = elementoPedido.getAttribute("id");
					String estadoP = elementoPedido.getAttribute("estado");
					String clienteP = elementoPedido.getElementsByTagName("cliente").item(0).getTextContent();
					String comanda = elementoPedido.getElementsByTagName("items_pedidos").item(0).getTextContent();
					Double precioP = Double.parseDouble(elementoPedido.getElementsByTagName("total").item(0).getTextContent());
					
					
					pedidos.add(
						new Pedido(idOrden,estadoP,clienteP,comanda,precioP));
				}
			}
			//Solo hay dos por eso lo muestro así, sino lo lógico es hacerlo con un for each
			System.out.println("\nPedidos de la jornada:\n");
			System.out.println("Pedido # "+pedidos.getFirst().id+". "+pedidos.getFirst().estado);
			System.out.println("Cliente: "+pedidos.getFirst().cliente);
			System.out.println("Precio final: "+pedidos.getFirst().total+"€\n");
			System.out.println("Pedido # "+pedidos.getLast().id+". "+pedidos.getLast().estado);
			System.out.println("Cliente: "+pedidos.getLast().cliente);
			System.out.println("Precio final: "+pedidos.getLast().total+"€\n");
			
			
			
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
