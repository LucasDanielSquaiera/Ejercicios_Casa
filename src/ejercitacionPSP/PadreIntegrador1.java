package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PadreIntegrador1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoIntegrador1","variableFalsa","fichero.txt");
		pb.redirectErrorStream(true);
		Process hijo = pb.start();
		
		// hijo dos
		
		ProcessBuilder pb2 = Lanzador.para("ejercitacionPSP.HijoIntegrador1", "prueba","fichero.txt");
		pb2.redirectErrorStream(true);
		// Estructura directory
		Path directorio = Path.of("Integrador","fichero.txt");
		Files.createDirectories(directorio.getParent());
		
		if(!Files.exists(directorio)) { Files.createFile(directorio);}
		//pb2.directory(directorio.getParent().toFile());
		pb2.environment().put("prueba", "variable de entorno creada con éxito");
		Process hijo2 = pb2.start();
		
		try(BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()))){
			String respuesta;
			while((respuesta = lector.readLine())!= null) {
				System.out.println(respuesta);
			}
			lector.close();
		}
		int codigo = hijo.waitFor();
		System.out.println("El hijo 1 terminó con código: "+ codigo);
		
		try(BufferedReader lector = new BufferedReader(new InputStreamReader(hijo2.getInputStream(),StandardCharsets.UTF_8))){
			String respuesta;
			while((respuesta = lector.readLine())!= null) {
				System.out.println(respuesta);
			}
			lector.close();
		}
		int codigo2 = hijo2.waitFor();
		System.out.println("El hijo 2 terminó con código: "+ codigo2);
		
		Files.deleteIfExists(directorio);
		Files.deleteIfExists(directorio.getParent());
	}
}
