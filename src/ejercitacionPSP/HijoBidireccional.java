package ejercitacionPSP;

import java.util.Scanner;

public class HijoBidireccional {
	public static void main(String[] args) {
	
		try (Scanner sc = new Scanner(System.in)){
			if(sc.hasNextLine()) {
			String datosPadre = sc.nextLine().trim();
			System.out.println("Hijo: He recibido del padre el número..."+ datosPadre);
			
			int datoRecibido = Integer.parseInt(datosPadre);
			int triple = datoRecibido * 3;
			
			System.out.println("El valor triple de "+datosPadre+" es: "+triple);
			System.out.println("Terminando ejecución.");
			}
		}	
	}
}
