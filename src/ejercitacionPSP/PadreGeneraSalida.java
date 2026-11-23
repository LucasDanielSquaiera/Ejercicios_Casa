package ejercitacionPSP;

import java.io.File;
import java.io.IOException;

public class PadreGeneraSalida {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.GeneraSalida");
		pb.redirectErrorStream(true);
		pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("salidaRedirigida.log")));
		Process hijo = pb.start();
		
		int codigo = hijo.waitFor();
		
		System.out.println("El procesos terminó con código: "+codigo);
	}
}
