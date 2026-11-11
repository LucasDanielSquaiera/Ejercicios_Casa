package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PadreInspector {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoInspector");
		//Creando carpeta de trabajo hijo
		Path carpetaTrabajo = Path.of("zona_segura");
		if(!Files.exists(carpetaTrabajo))
			try {
				Files.createDirectory(carpetaTrabajo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		pb.redirectErrorStream(true);
		//Cambiamos la carpeta de trabajo del hijo
		pb.directory(carpetaTrabajo.toFile());
		
		System.out.println("Padre: Lanzamos al hijo...");
		Process hijo = pb.start();
		
		System.out.println("Padre: Leyendo al hijo...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream(),StandardCharsets.UTF_8));
		String linea;
		while((linea = lector.readLine())!= null) {
			System.out.println(linea);
		}
		
		int salida = hijo.waitFor();
		System.out.println("Padre: el hijo terminó con código: "+ salida);
	}
}
