package ejercitacionPSP;

import java.util.Scanner;

public class HijoValidador {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			if(sc.hasNextLine()) {
				String valor = sc.nextLine().trim();
				int valorNumero = Integer.parseInt(valor);
				System.out.println("Hijo valor recibido: "+valorNumero);
				if(valorNumero >= 18)
					System.out.println("Hijo: La persona es mayor de edad.");
					
				else
					System.out.println("Hijo: La persona es menor de edad");
			}
			
			System.out.println("Final del programa.");
		}
	}
}
