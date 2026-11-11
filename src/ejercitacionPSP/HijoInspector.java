package ejercitacionPSP;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class HijoInspector {
	public static void main(String[] args) {
		System.out.println("Hijo: impriendo carpeta de trabajo actual...\n"+System.getProperty("user.dir"));
		
		System.out.println("Hijo: buscando un fichero llamado 'datos.dat'");
		Path fichero = Path.of("datos.dat");
		if(!Files.exists(fichero)) {
			try {
				Files.writeString(fichero,"Contenido secreto generado por el hijo.",StandardCharsets.UTF_8);
				System.out.println("Hijo: fichero creado, no existía.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("Hijo: fichero existente. Leyendo su contenido:");
				System.out.println(Files.readAllLines(fichero,StandardCharsets.UTF_8));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Hijo: ejecución terminada!");
	}
}
