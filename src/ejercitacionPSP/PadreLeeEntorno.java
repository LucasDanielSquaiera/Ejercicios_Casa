package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadreLeeEntorno {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.LeeEntorno");
		System.out.println("Padre: Lanzando hijo...");
		pb.redirectErrorStream(true);
		pb.environment().put("Prueba_Lucas", "lectura_Correcta");
		Process hijo = pb.start();
		try(BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()))){
			String linea;
			while((linea=lector.readLine())!= null) {
				System.out.println(linea);
			}
		}
		int codigo = hijo.waitFor();
		System.out.println("Padre: hijo terminó su ejecución con código "+ codigo);
		System.out.println("comprobando si sólo modifica las varibales del hijo o global: \n"
				+ System.getenv("Prueba_Lucas"));
		
	}
}
