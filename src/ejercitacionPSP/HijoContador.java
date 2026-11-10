package ejercitacionPSP;

public class HijoContador {
	public static void main(String[] args) throws InterruptedException {
		
		long pid = ProcessHandle.current().pid();
		System.out.println("I'm a procces and this is my PID: "+pid);
		// Hay que implementar el throws por si el programa peta
		Thread.sleep(2000);
		System.out.println("El proceso ha muerto");
	}
}
