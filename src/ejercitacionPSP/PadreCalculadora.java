package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PadreCalculadora {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoCalculadora");
		pb.redirectErrorStream(true);
		
		System.out.println("Padre: Lanzado hijo...");
		Process hijo = pb.start();
		System.out.println("Padre: enviando números al hijo...");
		
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));
		escritor.write("5\n");
		escritor.write("2\n");
		escritor.flush();
		escritor.close();
		
		System.out.println("Padre: Leyendo hijo...");
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		String respuesta;
		while((respuesta = lector.readLine())!= null) {
			System.out.println(respuesta);
		}

		int salida = hijo.waitFor();
		System.out.println("Padre: El hijo terminó con código: "+salida);
		
	}
}
