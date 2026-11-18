package ejercitacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class LogAuditoria {
	public static void main(String[] args) {
		Path fichero = Path.of("documentosXML/auditoria.log");
		
		if(!Files.exists(fichero)){
			try {
				Files.writeString(fichero,"[INICIO DE SISTEMA]"+LocalDate.now(),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				System.out.println("Archivo creado.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	try(BufferedReader lector = Files.newBufferedReader(fichero)){
		
		System.out.println("Leyendo contenido del fichero: ");
		String linea;
		
		while((linea = lector.readLine())!= null) {
			System.out.println(linea);
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}
}
