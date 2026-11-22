package ejercitacionPSP;

import java.nio.file.Files;
import java.nio.file.Path;

public class Hijo1 {
	public static void main(String[] args) {
		
		System.out.println("Hola, soy el hijo");
		System.out.println("Comprobando si el fichero empleados.dat existe: ");
		Path fichero = Path.of("empleados.dat");
		System.out.println(Files.exists(fichero));
	}
}
