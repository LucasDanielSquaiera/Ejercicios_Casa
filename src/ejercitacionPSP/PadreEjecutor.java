package ejercitacionPSP;

import java.io.IOException;

public class PadreEjecutor {
		public static void main(String[] args) throws IOException, InterruptedException {
			
			// Llamamos al Lanzador desde una instancia de PB
			ProcessBuilder pb = Lanzador.para("ejercitacionPSP/HijoContador");
		
			// Para mostrar en esta consola lo que dice el hijo
			pb.inheritIO();
			
			//Instanciamos proceso?
			Process hijo = pb.start();
			
			System.out.println("Padre: Hijo lanzado. Ahora esperaré a que termine...");
			
			//Esperamos que termine y guardamos el código de salida
			int codigoSalida = hijo.waitFor();
			
			System.out.println("Padre: El hijo a terminado, su código de salida es: "+ codigoSalida);
			
		
		}
	
}
