package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PadreEco {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoEco");
		pb.redirectErrorStream(true);
		Process hijo = pb.start();
		
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream(),StandardCharsets.UTF_8));
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream(),StandardCharsets.UTF_8));
		System.out.println("Dime una palabra: ");
		
		while(true) {
			String entrada = sc.nextLine();
			
			escritor.write(entrada);
			escritor.newLine();
			escritor.flush();
			
			System.out.println(lector.readLine()); 
			System.out.println(lector.readLine());
			
			if(entrada.equalsIgnoreCase("fin")) {break;}
		}
		
		escritor.close();
		String resto;
		while((resto = lector.readLine())!= null) {
			System.out.println(resto);
		}
		
		int codigo = hijo.waitFor();
		System.out.println("Proceso hijo terminado en: "+codigo);
	}
}
