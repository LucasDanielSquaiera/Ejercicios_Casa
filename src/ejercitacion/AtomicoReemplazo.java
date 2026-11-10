package ejercitacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class AtomicoReemplazo {
	public static void main(String[] args) throws IOException {
		Path fichero = Path.of("subcarpeta","fichero.txt");
		
		try {
			
			Files.writeString(fichero,"Texto de prueba");
			
		} catch(NoSuchFileException e) {
			e.printStackTrace();
			System.out.println("No existe la carpeta padre del fichero");
		}
		
		
		// crear carpetas, se llama al padre apra que el .txt sea creado como fichero y no como carpeta
		Files.createDirectories(fichero.getParent());
		
		
		System.out.println("Escrito Línea 1.");
		Files.writeString(fichero,"Línea 1\n");
		System.out.println("Escrito Línea 2.");
		Files.writeString(fichero,"Línea 2\n");
		
		System.out.println("Resultado final de escritura en el fichero: \n"+Files.readAllLines(fichero));
		
		System.out.println("La clase Files sobreescriobe las líneas, probamos con un método de append");
		Files.writeString(fichero,"Línea 1\n");
		Files.writeString(fichero,"Línea 2\n", StandardOpenOption.APPEND);
		Files.writeString(fichero, "Línea 3\n",StandardOpenOption.APPEND);
		System.out.println("Resultado final de escritura en el fichero con APPEND: \n"+Files.readAllLines(fichero));
	}
}
