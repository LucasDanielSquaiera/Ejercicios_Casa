package ejercitacionPSP;

public class LeeEntorno {
	public static void main(String[] args) {
		System.out.println("Hijo: leyendo varibales de entorno:");
		System.out.println(System.getenv("username"));
		System.out.println(System.getenv("Prueba_Lucas"));
		
		System.out.println("Terminando lectura...");
	}
}
