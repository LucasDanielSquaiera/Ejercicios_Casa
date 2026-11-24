package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class EncadenadorProcesos {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.GeneradorLineas");
		ProcessBuilder pb2 = Lanzador.para("ejercitacionPSP.TransformadorLineas");
		
		Process hijo1 = pb.start();
		Process hijo2 = pb.start();
		
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo2.getOutputStream(),StandardCharsets.UTF_8));
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo1.getInputStream(), StandardCharsets.UTF_8));
		
		String salidaHijo1;
		while((salidaHijo1 = lector.readLine())!=null) {
			escritor.write(salidaHijo1);
			escritor.newLine();
			escritor.flush();
		}
		lector.close();//hijo1
		escritor.close();//hijo2
		
		BufferedReader lectorHijo2 = new BufferedReader(new InputStreamReader(hijo2.getInputStream(), StandardCharsets.UTF_8));
		String salidaHijo2;
		while((salidaHijo2 = lectorHijo2.readLine())!=null) {
			System.out.println(salidaHijo2);
		} 
		lectorHijo2.close();
		
		
		int codigo1 = hijo1.waitFor();
		int codigo2 = hijo2.waitFor();
		
		System.out.println("Hijo 1 terminado con código: "+ codigo1);
		System.out.println("Hijo 2 terminado con código: "+ codigo2);
		
	}
	
	
}
