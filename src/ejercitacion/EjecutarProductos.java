package ejercitacion;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

public class EjecutarProductos {
    public static void main(String[] args) throws IOException {
        Path f = Path.of("datos", "productos.dat");
        Files.createDirectories(f.getParent());
        Files.deleteIfExists(f); // Borramos si ya existía de antes

        // Abrimos RandomAccessFile en modo lectura/escritura ("rw")
        try (RandomAccessFile raf = new RandomAccessFile(f.toFile(), "rw")) {
            FormatoProducto.escribir(raf, 1, 19.99, "Ratón");
            FormatoProducto.escribir(raf, 2, 850.50, "Portátil");
            FormatoProducto.escribir(raf, 3, 45.00, "Teclado");
            
            
            raf.seek(FormatoProducto.TAMANO * 1);
            System.out.println(FormatoProducto.leer(raf));
            
          
           
        }

        // Comprobaciones de tamaño
        System.out.println("Tamaño de un registro fijo: " + FormatoProducto.TAMANO + " bytes");
        System.out.println("Tamaño total del fichero en disco: " + Files.size(f) + " bytes");
        System.out.println("Número total de registros calculados: " + Files.size(f) / FormatoProducto.TAMANO);
    }
}