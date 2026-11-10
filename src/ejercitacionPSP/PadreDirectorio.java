package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadreDirectorio {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Creamos carpeta
		
		File carpetaTrabajoHijo = new File("mi_carpeta_especial");
		//comprobamos que exista, si no existe la creamos
		if(!carpetaTrabajoHijo.exists()) {
			carpetaTrabajoHijo.mkdir();
			System.out.println("Padre: Carpeta de trabajo hijo creada.");
		}
		
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoDirectorio");
		
		pb.directory(carpetaTrabajoHijo);
		pb.redirectErrorStream(true);
		System.out.println("Padre: Lanzando hijo con la nueva configuración de carpeta de trabajo");
		Process hijo = pb.start();
		
		//Leyendo el hijo
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		String linea;
		
		while((linea = lector.readLine())!=null) {
			System.out.println("Padre leyendo: "+linea);
		}
		
		int codigoSalida = hijo.waitFor();
		System.out.println("Padre: proceso hijo terminado con código: "+codigoSalida);
	}
}
