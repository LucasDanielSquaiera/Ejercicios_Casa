package ejercitacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class EjecutarBusquedaID {
	public static void main(String[] args) {
		Path f = Path.of("datos/empleados.dat");
		
		
		try(RandomAccessFile raf = new RandomAccessFile(f.toFile(),"rw")){
			
			FormatoEmpleado.escribir(raf, 10, 1500.0, "Empleado A");
			FormatoEmpleado.escribir(raf, 20, 1500.0, "Empleado B");
			FormatoEmpleado.escribir(raf, 30, 1500.0, "Empleado C");
			FormatoEmpleado.escribir(raf, 40, 1500.0, "Empleado D");
			
			int idBuscado = 30;
			long cantidadRegistros = raf.length()/FormatoEmpleado.TAMANO;
			
			for(int i = 0; i < cantidadRegistros;i++) {
				raf.seek(FormatoEmpleado.posicionDe(i));
				if(raf.readBoolean()==false && raf.readInt()==idBuscado) {
					raf.seek(FormatoEmpleado.posicionDe(i));
					System.out.println("Registro encontrado:");
					System.out.println(FormatoEmpleado.leer(raf));
					break;
				}
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
