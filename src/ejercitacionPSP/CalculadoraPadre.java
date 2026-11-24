package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CalculadoraPadre {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = Lanzador.para("ejercitacionPSP.CalculadoraHijo");
		pb.redirectErrorStream(true);
		Process hijo = pb.start();
		
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream(),StandardCharsets.UTF_8));
		BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream(), StandardCharsets.UTF_8));
		Scanner sc = new Scanner(System.in);
		String entrada;
		do {
			
			System.out.println(lector.readLine()); 
			escritor.write(entrada = sc.nextLine());
			escritor.newLine();
			escritor.flush();
			if(entrada.equalsIgnoreCase("salir")) {
				System.out.println(lector.readLine());
				break;
			}
			if(entrada.equalsIgnoreCase("sumar")||entrada.equalsIgnoreCase("restar")
			  ||entrada.equalsIgnoreCase("multiplicar")||entrada.equalsIgnoreCase("dividir")) {
				System.out.println(lector.readLine()); 
				System.out.println(lector.readLine());
				escritor.write(entrada = sc.nextLine());
				escritor.newLine();
				escritor.flush();
				System.out.println(lector.readLine());
				escritor.write(entrada = sc.nextLine());
				escritor.newLine();
				escritor.flush();
				System.out.println(lector.readLine());
			} else {
				System.out.println(lector.readLine());
			}
			
		}while(!entrada.equalsIgnoreCase("salir"));
		
		String resto;
		while((resto = lector.readLine())!= null) {
			System.out.println(resto);
		}
		lector.close();
		escritor.close();
		
		int codigo = hijo.waitFor();
		System.out.println("Hijo terminado en código "+codigo);
	}
}
