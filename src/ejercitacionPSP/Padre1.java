package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Padre1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.Hijo1");
		Path directorio = Path.of("datos");
		//cambiamos de directorio de trabajo
		pb.directory(directorio.toFile());
		Process hijo = pb.start(); // lanzamos
		
		try(BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()))){
			String respuesta;
			while((respuesta = lector.readLine())!= null)
				System.out.println("Padre: recibiendo mensaje de hijo: "+respuesta);
		}
		
		int codigo = hijo.waitFor();
		
		System.out.println("El hijo terminó con código "+ codigo);
		
	}
}
