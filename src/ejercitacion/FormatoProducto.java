package ejercitacion;

import java.io.IOException;
import java.io.RandomAccessFile;

	public final class FormatoProducto {
	    public static final int TAMANO_NOMBRE = 10; // Máximo 10 caracteres
	    
	    // 4 bytes (int) + 8 bytes (double) + (10 caracteres * 2 bytes cada uno en UTF-16) = 32 bytes
	    public static final int TAMANO = 4 + 8 + (TAMANO_NOMBRE * 2);

	    private FormatoProducto() { }

	    public static long posicionDe(int numeroRegistro) {
	        return (long) numeroRegistro * TAMANO;
	    }

	    public static void escribir(RandomAccessFile raf, int id, double precio, String nombre) throws IOException {
	        if (nombre.length() > TAMANO_NOMBRE) {
	            throw new IllegalArgumentException("El nombre es demasiado largo para el ancho fijo de " + TAMANO_NOMBRE);
	        }
	        
	        // 1. Escribir ID (4 bytes)
	        raf.writeInt(id);
	        
	        // 2. Escribir Precio (8 bytes)
	        raf.writeDouble(precio);
	        
	        // 3. Rellenar el nombre con espacios en blanco hasta completar los 10 caracteres
	        StringBuilder b = new StringBuilder(nombre);
	        while (b.length() < TAMANO_NOMBRE) {
	            b.append(' ');
	        }
	        
	        // Escribir caracteres (20 bytes)
	        raf.writeChars(b.toString());
	    }

	    public static String leer(RandomAccessFile raf) throws IOException {
	        int id = raf.readInt();
	        double precio = raf.readDouble();
	        
	        StringBuilder b = new StringBuilder();
	        for (int i = 0; i < TAMANO_NOMBRE; i++) {
	            b.append(raf.readChar());
	        }
	        
	        return "ID: " + id + " | Precio: " + precio + "€ | Nombre: " + b.toString().strip().trim();
	    }
	}
	

