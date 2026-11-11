package ejercitacionPSP;

import java.util.Scanner;

public class HijoScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		while(sc.hasNextLine()) {
			String linea = sc.nextLine().trim();
			
			if(linea.equalsIgnoreCase("fin")) {
				break;
			}
			
			try {
				int valor = Integer.parseInt(linea);
				total += valor;
			}catch(NumberFormatException e) {
				System.out.println("Hijo: ignorando texto no numérico...");
			}
		}
		sc.close();
		System.out.println("Hijo: la suma total de los valores recibidos por consola es: "+total);
		System.out.println("Hijo: cerrando proceso...");
	}
}
