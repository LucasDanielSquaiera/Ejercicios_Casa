package ejercitacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class EjecutarBorradoLogico {
	public static void main(String[] args) {
		Path f = Path.of("datos/empleados.dat");
		
		try(RandomAccessFile raf = new RandomAccessFile(f.toFile(),"rw")){
		   raf.seek(FormatoEmpleado.posicionDe(1));
		   raf.writeBoolean(true);
		   
		   System.out.println("registro 2 eliminado, lectura del raf completo: \n");
		   
		   
		   // lenght te decuelve la cantidad total de Bytes, hay que dividirlo por tamaño y saber el número de registros
		   for(int i = 0; i<raf.length()/FormatoEmpleado.TAMANO;i++) {
			   raf.seek(FormatoEmpleado.posicionDe(i));
			   System.out.println(FormatoEmpleado.leer(raf));   
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
