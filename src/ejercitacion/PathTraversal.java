package ejercitacion;

import java.nio.file.Path;

public class PathTraversal {
	public static void main(String[] args) {
		Path base = Path.of("salida");
		Path fichero = Path.of("../fichero-secreto.txt");
		
		Path destinoFinal = base.resolve(fichero);
		
		
		System.out.println("La ruta final sin normalizar: "+ destinoFinal);
		System.out.println("Empieza con salida? "+ destinoFinal.startsWith(base));
		System.out.println("La ruta normalizada: "+ destinoFinal.normalize());
		System.out.println("Normalizada empieza por salida? " + destinoFinal.normalize().startsWith(base));
		
		
	}
}
