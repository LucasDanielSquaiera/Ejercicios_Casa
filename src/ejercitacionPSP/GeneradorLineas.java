package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class GeneradorLineas {
	public static void main(String[] args) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out,StandardCharsets.UTF_8));
		
		
		for(int i = 1; i<=10;i++) {
			escritor.write("línea larga de contenido número: "+i);
			escritor.newLine();
			escritor.flush();
		}
		escritor.close();
		
	}
}
