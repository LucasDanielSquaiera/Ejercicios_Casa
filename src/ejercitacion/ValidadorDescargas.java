package ejercitacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;




public class ValidadorDescargas {
	public static void main(String[] args) {
		
		Path base = Path.of("servidor","documentos");
		Scanner sc = new Scanner(System.in);
		List<String> peticiones = List.of("manual.pdf","fotos/vacaciones.jpg","../../etc/shadow","../documentos-confidenciales/claves.txt");
		
		for(String s : peticiones) {
			Path conversion = base.resolve(s);
			if(conversion.normalize().startsWith(base)) {
				System.out.println(s);
				System.out.println("Acceso permitido");
			} else {
				System.out.println(s);
				System.out.println("Acceso denegado");
			}
		}
		
		
		// Ejercicio 12.2 / 12.3
		Path auditoria = Path.of("auditoria-seguridad.log");
		Path pruebaTrue = base.resolve("prueba.txt");
		
		System.out.println("Indique la ruta de descarga...");
		String input = sc.nextLine();
		
		try {
			Files.createDirectories(base);
			Files.writeString(pruebaTrue, "Archivo correcto");
			Files.writeString(auditoria, "Libro de auditorías",StandardOpenOption.CREATE);
			
			if(esRutaSegura(base,input) && Files.exists(base.resolve(input))) {
				System.out.println(Files.readAllLines(base.resolve(input)));
				
			}else {
				Files.writeString(auditoria,"Ataque registrado con fecha: "+LocalDate.now(),StandardOpenOption.APPEND);
				System.out.println("Acceso denegado, registrado en auditoria");
			}
			
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static boolean esRutaSegura(Path base,String input) {
		Path rutaNormalizada = base.resolve(input).normalize();
		return rutaNormalizada.startsWith(base);
	}
	
	
	
}
