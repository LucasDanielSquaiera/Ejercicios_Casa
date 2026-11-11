package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PadreScanner {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.HijoScanner");
		pb.redirectErrorStream(true);
		
		System.out.println("Padre: Lanzando hijo...");
		Process hijo = pb.start(); 
		
		String opcionUsuario;
		Scanner sc = new Scanner(System.in);
		// abrimos bufer
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));
		System.out.println("---Dime números y los iré sumando ---");
		
		do {
			System.out.println("Escribe un número o la palabra fin");
			opcionUsuario = sc.nextLine();
			escritor.write(opcionUsuario+"\n");
			escritor.flush();
		}while(!opcionUsuario.equalsIgnoreCase("Fin"));
		escritor.close();
		sc.close();

		
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		String linea;
		while((linea = lector.readLine())!= null) {
			System.out.println(linea);
		}
		int salida = hijo.waitFor();
		System.out.println("Padre: el hijo terminó con código: "+salida);
	}
}
