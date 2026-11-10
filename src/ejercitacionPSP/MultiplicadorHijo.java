package ejercitacionPSP;

public class MultiplicadorHijo {
	public static void main(String[] args) throws InterruptedException {
	
		long Mipid = ProcessHandle.current().pid(); 
		
		int numeroPadre = Integer.parseInt(args[0]);
		int valorDoble = numeroPadre * 2;
		Thread.sleep(2000);
		System.out.println("Hijo: Valor recibido desde la clase padre "+ numeroPadre+", calculando su doble:...\nEl resultado es: "+valorDoble);
	
	}
}
