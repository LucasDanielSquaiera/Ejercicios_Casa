package ejercitacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class EjecutarActualizacion {
	public static void main(String[] args) {
		Path f = Path.of("datos/empleados.dat");
		
		try(RandomAccessFile raf = new RandomAccessFile(f.toFile(),"rw")){
			raf.seek(FormatoEmpleado.posicionDe(1));
			System.out.println("Antes del cambio:");
			System.out.println(FormatoEmpleado.leer(raf));
			FormatoEmpleado.escribir(raf, 2, 3000.0, "Tito Alberto");
			System.out.println("\nLuego del cambio:");
			raf.seek(1*FormatoEmpleado.TAMANO);
			System.out.println(FormatoEmpleado.leer(raf));
			
			raf.seek(2*FormatoEmpleado.TAMANO);
			FormatoEmpleado.escribir(raf, 3, 2500.0, "Walterio");
			raf.seek(1*FormatoEmpleado.TAMANO);
			FormatoEmpleado.escribir(raf, 2, 3000.0, "Tito Alberto");
			raf.seek(2*FormatoEmpleado.TAMANO);
			System.out.println(FormatoEmpleado.leer(raf));
			raf.seek(1*FormatoEmpleado.TAMANO);
			System.out.println(FormatoEmpleado.leer(raf));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}	
