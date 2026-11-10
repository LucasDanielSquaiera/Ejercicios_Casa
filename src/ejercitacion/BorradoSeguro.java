package ejercitacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BorradoSeguro {
	public static void main(String[] args){
		// Utilizamos el método DeleteIfExists en lugar del delete
	
		Path fantasma = Path.of("fantasma.txt");
		Path temporal = Path.of("temporal.txt");
		
		try {
			Files.createFile(temporal);
		
			System.out.println("Borrando el archivo fantasma con DeleteIfExists");
			System.out.println("Se pudo borrar? "+ Files.deleteIfExists(fantasma));
			System.out.println("Borrando el archivo temporal con DeleteIfExists");
			System.out.println("Se pudo borrar? "+ Files.deleteIfExists(temporal));
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	
	
	}
}
