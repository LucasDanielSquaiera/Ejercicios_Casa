package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PadreLector {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.ContadorHijo", "10");
		System.out.println("Lanzando hijo y esperando...");
		Process hijo = pb.start();
		
		System.out.println("Leyendo datos del hijo...");
		
		//Abrimos y concetamos búfer al hijo para poder manipular su salida y no sólo mostralo
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream(),StandardCharsets.UTF_8));
		//Leemos
		String resultadoHijo;
		while((resultadoHijo = lector.readLine())!= null) {System.out.println(resultadoHijo);}
		int salida = hijo.waitFor();
		
		System.out.println("Proceso hijo terminado, código de salida: "+salida);
	}
}
