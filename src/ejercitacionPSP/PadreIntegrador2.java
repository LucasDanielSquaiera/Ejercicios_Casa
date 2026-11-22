package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadreIntegrador2 {
	public static void main(String[] args) throws InterruptedException {
		// para error 2
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoIntegrador2");
		// no existe el fichero
		pb.redirectErrorStream(true);
		Process error2;
		try {
			error2 = pb.start();
			int codigo = error2.waitFor();
			
			if(codigo != 0) {
			BufferedReader lector = new BufferedReader(new InputStreamReader(error2.getInputStream()));
			String linea;
			System.out.println("Error proceso A: ");
			while((linea = lector.readLine())!=null) {
				System.out.println(linea);
			} lector.close();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Para error 1
		ProcessBuilder processB = new ProcessBuilder("dir","*.txt");
		try {
			Process error1 = processB.start();
		} catch (IOException e) {
			System.out.println("Error de proceso B:\nEl comando dir, debe ejecutarse dentro de un interprete como CMD");
			e.printStackTrace();
		}
	}
}
