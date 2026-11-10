package ejercitacion;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Codificacion {
	public static void main(String[] args) {
		
	        Path fichero = Path.of("texto-corrompido.txt");
	        
	        try {
	            System.out.println("Guardamos el texto con el símbolo del euro usando Windows-1252...");
	            
	            // Usamos Charset.forName para codificaciones fuera de StandardCharsets
	            Files.writeString(fichero, "Canción de cuna en Peñafiel €", Charset.forName("Windows-1252"));
	            
	            System.out.println("Leyendo el fichero interpretándolo por defecto (con UTF-8): nos dará error");
	   //Internamente nos dará un error al leerlo, los bytes de una codificación y otra son diferentes en lo que ocupa un caracter
	           // System.out.println(Files.readString(fichero, StandardCharsets.UTF_8));
	            
	            
	            String frase = "Canción de cuna en Peñafiel €";
	            
	            byte[] win1252 = frase.getBytes(Charset.forName("Windows-1252"));
	            byte[] utf8 = frase.getBytes(StandardCharsets.UTF_8);
	            
	            System.out.println("Longitud en bytes en UTF-8: "+ utf8.length);
	            System.out.println("Longitud en bytes en Windows-1252: "+ win1252.length);
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
