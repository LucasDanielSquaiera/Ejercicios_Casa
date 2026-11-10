package ejercitacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

public class EjecutarEmpleado {
	public static void main(String[] args) throws IOException {
		Path f = Path.of("datos/empleados.dat");
		Files.createDirectories(f.getParent());
		Files.deleteIfExists(f);
		
		try(RandomAccessFile raf = new RandomAccessFile(f.toFile(), "rw")){
			FormatoEmpleado.escribir(raf, 1, 2500.0, "Lautaro Machuca");
			FormatoEmpleado.escribir(raf, 2, 2500.0, "Tito");
			FormatoEmpleado.escribir(raf, 3, 2500.0, "Walterio");
			
			
			
			raf.seek(FormatoEmpleado.posicionDe(0));
			
			System.out.println("Imprimiendo número 4 del raf: \n"+ FormatoEmpleado.leer(raf));
			
		    System.out.println("Tamaño de un registro fijo: " + FormatoEmpleado.TAMANO + " bytes");
	        System.out.println("Tamaño total del fichero en disco: " + Files.size(f) + " bytes");
	        System.out.println("Número total de registros calculados: " + Files.size(f) / FormatoEmpleado.TAMANO);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
