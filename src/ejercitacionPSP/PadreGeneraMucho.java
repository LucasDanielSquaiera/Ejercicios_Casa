package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class PadreGeneraMucho {
	
	public static void main(String[] args) {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.GeneraMucho");
		try {
			pb.redirectError(ProcessBuilder.Redirect.appendTo(new File("salidaError.txt")));
			Process hijo = pb.start();
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream(),StandardCharsets.UTF_8));
			String respuesta;
			while((respuesta = lector.readLine())!=null) {
				System.out.println(respuesta);
			}
			
			int codigo = hijo.waitFor();
			System.out.println("El hijo terminó con código: "+codigo);
		} catch(IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
