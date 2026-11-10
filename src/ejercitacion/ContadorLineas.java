package ejercitacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;



public class ContadorLineas {
	

	public static void main(String[] args) {
		Path raiz = Path.of("proyecto");
		Path subcarpeta1 = raiz.resolve("modulo1.txt");
		Path subcarpeta2 = raiz.resolve("modulo2.txt");
		
		
		try {
		
			Files.createDirectory(raiz);
			Files.createFile(subcarpeta1);
			Files.createFile(subcarpeta2);
			
		
			
			for(int i = 0; i <= 10; i++) {
			Files.writeString(subcarpeta1,"Línea: "+i+"\n",StandardOpenOption.APPEND);
			Files.writeString(subcarpeta2,"Línea: "+i+"\n",StandardOpenOption.APPEND);
			}
			
			int [] acumuladorLineas = {0};
			try(Stream<Path> flujo = Files.walk(raiz)){
				flujo.filter(Files::isRegularFile).filter(p -> p.toString().endsWith(".txt")).forEach(p -> {
					try {
						List<String> lineas = Files.readAllLines(p);
						int lineasTotales = lineas.size();
						
						acumuladorLineas[0] += lineasTotales;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
						
			}
	
			System.out.println("Líneas totales: "+ acumuladorLineas[0]);
	
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try(Stream<Path> todo = Files.walk(raiz)){
			
			List<Path> alReves = todo.sorted(Comparator.reverseOrder()).toList();
			
			for(Path p : alReves) {
				Files.deleteIfExists(p);
			}
			
			System.out.println("Borrado exitoso");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
