package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HijoEco {
	public static void main(String[] args) {
		
		try{
			BufferedReader lector = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));
			
			String entradaPadre;
			while((entradaPadre = lector.readLine())!= null) {
				
					System.out.println("Hijo: recibiendo del padre la palabra: "+ entradaPadre);
					System.out.println("Hijo: devuelvo: "+entradaPadre.toUpperCase());
			}
			System.out.println("Proceso terminado...");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
