package ejercitacionPSP;

import java.io.IOException;

public class PadreLanzadorArgs {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.MultiplicadorHijo", "5");
		pb.inheritIO();
		System.out.println("Padre: Lanzando hijo y esperando por él...");
		Process hijo = pb.start();
	
		int codigoSalida = hijo.waitFor();
		
		System.out.println("Proceso hijo terminado, si su código de salida es 0 ha sido exitoso.\nCorroborando código de salida: "+codigoSalida);

	}
}
