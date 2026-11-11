package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PadreValidador {

	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoValidador");
		pb.redirectErrorStream(true);
		
		System.out.println("Padre: Lanzando hijo...");
		Process hijo = pb.start();
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));
		System.out.println("Padre: Enviando edades al hijo...");
		escritor.write("19\n");
		escritor.flush();
		escritor.close();
		
		System.out.println("Padre: Leyendo al hijo...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		String respuesta;
		while((respuesta=lector.readLine())!= null) {
			System.out.println(respuesta);
		}
		int codigoSalida = hijo.waitFor();
		System.out.println("El hijo termino con código "+ codigoSalida);
	}
}
