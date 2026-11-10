package ejercitacionPSP;

public class ContadorHijo {
	public static void main(String[] args) {
		
		int valorRecibido = Integer.parseInt(args[0]);
				
		for(int i = 0; i <= valorRecibido;i++) {
			System.out.println("Línea número "+i);
		}
	}
}
