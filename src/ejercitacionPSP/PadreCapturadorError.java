package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadreCapturadorError {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoError");
		
		//indicamops que se use la misma salida para errores y prints
		//pb.redirectErrorStream(true);
		
		System.out.println("Padre: Lanzando hijo...");
		
		Process hijo = pb.start();
		
		System.out.println("Leyendo al hijo, errores y mensajes en el mismo búfer...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		String linea;
		
		while((linea = lector.readLine())!=null) {
			System.out.println(linea);
		}
		
		int codigoSalida = hijo.waitFor();
		
		System.out.println("Padre: hijo terminó con código: "+codigoSalida); 
	}
}
