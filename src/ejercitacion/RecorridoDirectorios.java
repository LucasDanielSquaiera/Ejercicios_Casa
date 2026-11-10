package ejercitacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class RecorridoDirectorios {
	public static void main(String[] args) throws IOException {
		
		Path raiz = Path.of("clase");
		Path subcarpeta = raiz.resolve("recursos");
	
		try(Stream<Path> flujo = Files.list(raiz); Stream<Path> flujo2 = Files.walk(raiz)){
			Files.createDirectories(subcarpeta);
			Files.writeString(subcarpeta.resolve("ejercicios.txt"), "Texto de los ejercicios");
			Files.writeString(subcarpeta.resolve("apuntes.txt"), "Texto de apuntes");
			
			System.out.println("Recorremos la intancia de Stream con función List en un forEach");
			
			flujo.forEach(p -> System.out.println("-> " + p));
			
			System.out.println("Recorremos la intancia de Stream con función Walk en un forEach");
			flujo2.forEach(p -> System.out.println("-> " + p));

		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
