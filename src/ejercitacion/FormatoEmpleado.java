package ejercitacion;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FormatoEmpleado {
	
	final static int TAMANO_NOMBRE = 15;
	final static int TAMANO = 4 + 8 + 1 + (TAMANO_NOMBRE *2);
	
	
	public static long posicionDe(int NumeroRegistro) {
		return NumeroRegistro * TAMANO;
	}
	
	
	
	public static void escribir(RandomAccessFile raf, int id, double sueldo, String nombre) throws IOException {
		
		if(nombre.length()> TAMANO_NOMBRE) {
			throw new IllegalArgumentException("El nombre indicado es muy largo. Debe contener una longitud de "+TAMANO_NOMBRE);
		}
		
		raf.writeBoolean(false);
		raf.writeInt(id);
		raf.writeDouble(sueldo);
		
		StringBuilder sb = new StringBuilder(nombre);
		
		while(sb.length() < TAMANO_NOMBRE) {
			sb.append(' ');
		}
		
		raf.writeChars(sb.toString());
	}
	

	public static String leer(RandomAccessFile raf) throws IOException {
	
		if(raf.readBoolean() == false) {
		int id = raf.readInt();
		double sueldo = raf.readDouble();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< TAMANO_NOMBRE; i++) {
			sb.append(raf.readChar());
		}
		
		return"ID: "+id+"| Sueldo: "+sueldo+"| Nombre: "+sb.toString();
		}else {
			return "[REGISTRO ELIMINADO]";
			
		}
	}
	
	
}
