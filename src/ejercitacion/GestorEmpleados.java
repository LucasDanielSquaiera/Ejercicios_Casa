package ejercitacion;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
	
	record Empleado(int id, String nombre, double salario, boolean activo) {}
	
	public static void main(String[] args)  {
		
		
		Path carpetaPadre = Path.of("datos");
		Path subcarpeta = carpetaPadre.resolve("personal");
		Path fichero = subcarpeta.resolve("empleados.txt");
		Path ruta = fichero.normalize();
		System.out.println("Creamos el Path con las funciones resolve, la normalizamos y preguntamos si empieza por datos: "
						+ "\n"+ruta.startsWith(carpetaPadre));
		System.out.println("La ruta normalizada es la siguiente: "+ ruta);
		try {								// no crea la carpeta personal
				Files.createDirectories(subcarpeta.getParent()); // Esto está mal porque subcarpeta involucra datos, poniendo sólo subcarpeta crea ambas.
				
				List<Empleado> plantilla = List.of(
						new Empleado(1,"María José López",3.500,true),
						new Empleado(2,"Walter Benítez",3.500,true),
						new Empleado(3,"Juan José Ñuñez",3.500,true),
						new Empleado(4,"Daniel Squaiera",3.500,true),
						new Empleado(5,"Laura Diale",3.500,false));
				
				System.out.println("Creamos la lista de empleados y la escribimos en un documento plano");
				for(Empleado e : plantilla) {
					String linea = e.id()+"#"+e.nombre()+"#"+e.salario()+"#"+e.activo()+"\n";
					Files.writeString(ruta, linea,Charset.forName("Windows-1252"),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
				}
				
				System.out.println("Documento escrito con éxito!");
				System.out.println("Ahora leeremos el fichero y recuperaremos los empleados en otra lista...");
				
				List<Empleado> recuperados = new ArrayList<>();
				for (String linea : Files.readAllLines(ruta, Charset.forName("Windows-1252"))) {
					String [] separador = linea.split("\\#");
					
					int recuperoId = Integer.parseInt(separador[0]);
					String recuperoNombre = separador[1];
					double recuperoSalario = Double.parseDouble(separador[2]);
					boolean activo2 = Boolean.parseBoolean(separador[3]);
				recuperados.add(new Empleado(recuperoId,recuperoNombre,recuperoSalario,activo2));	
				}	
					
				System.out.println("Empleados recuperados:\n"+recuperados);
				
					
					
				
				
				
			
		} catch (NoSuchFileException e) {
			System.out.println("El fichero al que se quiere acceder no se encuentra.");
			e.printStackTrace();
		} catch(IOException e2) {
			e2.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
