package ejercitacionPSP;

import java.nio.file.Files;
import java.nio.file.Path;

public class HijoDirectorio {
	public static void main(String[] args) {
		String carpetaActual = System.getProperty("user.dir");
		System.out.println("Mi directorio actual es: "+carpetaActual);
		
		//Comprobación de la existencia del fichero informe.txt
		
		Path fichero = Path.of("fichero.txt");
		
		if(Files.exists(fichero)) {
			System.out.println("Hijo: el archivo 'fichero.txt' existe!");
		} else {
			System.out.println("Hijo: no existe ningún archivo 'fichero.txt'.");
			System.err.println("La carpeta indicada no se encuentra en el directorio\n"+carpetaActual);
		}
		
		
	}
}
