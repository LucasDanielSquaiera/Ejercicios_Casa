package ejercitacion;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class CopiaProtegida {
	public static void main(String[] args) {
		Path fichero = Path.of("origen.txt");
		Path destino = Path.of("destino.txt");
		Path copiaIntermedia = Path.of("copia.txt");
		try {
			Files.writeString(fichero,"Hola Java");
			
			System.out.println("Copiamos el contenido del fichero oriegn en otro archivo...");
			Files.deleteIfExists(destino);
			Files.copy(fichero,destino);
			/*try{
				System.out.println("Intentamos volver a repetir la copia de los mismos ficheros");
				Files.copy(fichero, destino);
			}catch(FileAlreadyExistsException e2) {
				System.out.println("El archivo de destino ya existe, no se puede sobreescribir"); 
				e2.printStackTrace();
			}*/
			
			System.out.println("Ahora lo intenamos con el método REPLACE_EXISTING");
			Files.copy(destino,copiaIntermedia);
			
			
			
			Files.copy(destino,copiaIntermedia,StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("Copia éxitosa");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
