package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PadreBidireccional {
	public static void main(String[] args) throws IOException {
		
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoBidireccional");
		pb.redirectErrorStream(true);
		Process hijo = pb.start();
		System.out.println("Lanzando hijo...");
		try{
			BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));
			System.out.println("Padre: enviando datos al hijo."); 
		    escritor.write("3\n");
		    escritor.flush();
		    escritor.close();
		    
		    System.out.println("Padre: Leyendo al hijo...");
		    
		    BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		    String respuestaHijo;
		    while((respuestaHijo = lector.readLine())!= null) {
		    	System.out.println(respuestaHijo);
		    }
		    
		
		    int codigoSalida = hijo.waitFor();
		    System.out.println("Padre: el hijo terminó con código: "+ codigoSalida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
