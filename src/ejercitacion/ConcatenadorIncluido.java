package ejercitacion;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConcatenadorIncluido {
	
	record Producto(int id,String nombre, double precio) {}
	public static void main(String[] args) {
		
		List<Producto> listaProductos = List.of(
				new Producto(1,"Mesa de centro | Madera", 45.50),
				new Producto(2,"Silla de comedor",12.00));
		
		Path fichero = Path.of("producto.txt");
		
		List<String> lineas = new ArrayList<>();
		
		for(Producto p : listaProductos) {
			lineas.add(p.id()+"|"+p.nombre()+"|"+p.precio());
		}
		System.out.println(lineas);
		
		try {
			Files.write(fichero, lineas);
			
			List<Producto> catalogo = new ArrayList<>();
			// Se va a romper porque el delimitador forma parte de la información del producto. 
			for(String p : lineas) {
				String[] delimitador = p.split("|");
				catalogo.add(
				new Producto (Integer.parseInt(delimitador[0]), delimitador[1], Double.parseDouble(delimitador[2])));
			}
			
			System.out.println(catalogo);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
