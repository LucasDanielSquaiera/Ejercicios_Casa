package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadreIntegradorDos {
	public static void main(String[] args){
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoIntegradorDos", "VariablPrueba","errores.log");
		pb.environment().put("VariablePrueba","Definida con éxito");
		pb.redirectError(ProcessBuilder.Redirect.appendTo(new File("errores.log")));
		
		try {
			Process hijo = pb.start();
			
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			String respuesta;
			while((respuesta = lector.readLine())!= null) {
				System.out.println(respuesta);
			}
			int codigo = hijo.waitFor();
			if(codigo != 0) {
				System.out.println("Fallo detectado en el proceso hijo, consulte los detalles en el fichero 'errores.log'");
			}else {
				System.out.println("Proceso hijo, terminado de forma exitosa!");
			}
		}catch(IOException e) {
			System.out.println("Fallo al arrancar el hijo.");
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
