package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CalculadoraHijo {
	public static void main(String[] args) throws IOException {
		
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out,StandardCharsets.UTF_8));
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		String entrada;
		do {
			escritor.write("Elige una operación: (SUMAR/RESTAR/MULTIPLICAR/DIVIDIR/SALIR)");
			escritor.newLine();
			escritor.flush();
			//lectura operacion
			entrada= lector.readLine(); 
			if(entrada.equalsIgnoreCase("sumar")) {
				escritor.write("Has elegido sumar\n");
				escritor.flush();
				escritor.write("Indica el primer número:\n");
				escritor.flush();
				int num1 = Integer.parseInt(lector.readLine());
				escritor.write("Indica el segundo número:\n");
				escritor.flush();
				int num2 = Integer.parseInt(lector.readLine());
				escritor.write("El resultado es "+(num1 +num2)+"\n");
				escritor.flush();
			}
			if(entrada.equalsIgnoreCase("restar")) {
				escritor.write("Has elegido restar\n");
				escritor.flush();
				escritor.write("Indica el primer número:\n");
				escritor.flush();
				int num1 = Integer.parseInt(lector.readLine());
				escritor.write("Indica el segundo número:\n");
				escritor.flush();
				int num2 = Integer.parseInt(lector.readLine());
				escritor.write("El resultado es "+(num1 - num2)+"\n");
				escritor.flush();
			}
			if(entrada.equalsIgnoreCase("multiplicar")) {
				escritor.write("Has elegido multiplicar\n");
				escritor.flush();
				escritor.write("Indica el primer número:\n");
				escritor.flush();
				int num1 = Integer.parseInt(lector.readLine());
				escritor.write("Indica el segundo número:\n");
				escritor.flush();
				int num2 = Integer.parseInt(lector.readLine());
				escritor.write("El resultado es "+(num1 * num2)+"\n");
				escritor.flush();
			}
			if(entrada.equalsIgnoreCase("dividir")) {
				escritor.write("Has elegido dividir\n");
				escritor.flush();
				escritor.write("Indica el primer número:\n");
				escritor.flush();
				int num1 = Integer.parseInt(lector.readLine());
				escritor.write("Indica el segundo número:\n");
				escritor.flush();
				int num2 = Integer.parseInt(lector.readLine());
				if(num2 == 0) {
					escritor.write("La división por 0 no es posible\n");
					escritor.flush();
				}else {
					escritor.write("El resultado es "+(num1 / num2)+"\n");
					escritor.flush();
				}
				
			}
			if(entrada.equalsIgnoreCase("salir")) {
				escritor.write("Adiós");
				escritor.newLine();
				escritor.flush();
			}
			
			if(!entrada.equalsIgnoreCase("sumar")||!entrada.equalsIgnoreCase("restar")
			   ||!entrada.equalsIgnoreCase("multiplicar")||!entrada.equalsIgnoreCase("dividir") 
			   ||!entrada.equalsIgnoreCase("salir")) {
				
				escritor.write("Opción inválida...");
				escritor.newLine();
				escritor.flush();
			}
			
		
		}while(!entrada.equalsIgnoreCase("salir"));
		
		escritor.write("Proceso terminado...");
		escritor.newLine();
		escritor.flush();
		escritor.close();
		
		
		
		
	}
}
