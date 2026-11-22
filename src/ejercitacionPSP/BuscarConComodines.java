package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class BuscarConComodines {
	public static void main(String[] args) throws IOException, InterruptedException {
		Path f1 = Path.of("notas.txt");
		Path f2 = Path.of("listas.txt");
		
		Files.deleteIfExists(f1);
		Files.deleteIfExists(f2);
		
		Files.createFile(f2);
		Files.createFile(f1);
		
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir *.txt");
			pb.redirectErrorStream(true);
			Process proceso = pb.start();
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream(),Charset.forName("CP850")));
			String linea;
			while((linea = lector.readLine())!= null) {
				System.out.println(linea);
			}
			lector.close();
			int codigo = proceso.waitFor();
			System.out.println("El proceso terminó con código: "+codigo);
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("El sistema no puede encontrar el archivo especificado");
		}
		
	
	}
}
