package ejercitacionPSP;

import java.util.Scanner;

public class HijoCalculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hijo: Recibiendo valores.");
		int n1 = Integer.parseInt(sc.nextLine());
		int n2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("Hijo: los valores son: "+n1+", "+n2);
		System.out.println("La suma de "+n1+" más "+n2+" es: "+(n1+n2));
		System.out.println("La multiplicación de "+n1+" por "+n2+" es: "+(n1*n2));
		
		System.out.println("Terminando programa...\nSaliendo");
	}
}
