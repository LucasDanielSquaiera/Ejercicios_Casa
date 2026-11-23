package ejercitacionPSP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class GeneraMucho {
	
	public static void main(String[] args) throws IOException {
	
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out,StandardCharsets.UTF_8));
		for(int i = 1; i <= 2000;i++) {
			escritor.write("Línea número: "+i);
			escritor.newLine();
		}
		escritor.flush();
		escritor.close();
		
		BufferedWriter escritorError = new BufferedWriter(new OutputStreamWriter(System.err,StandardCharsets.UTF_8));
		for(int i = 1; i <= 2000;i++) {
			escritorError.write("Línea error: "+i);
			escritorError.newLine();
		}
		escritorError.flush();
		escritorError.close();
	
	
	
	
	}
}
