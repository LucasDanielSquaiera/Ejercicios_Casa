package ejercitacionPSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class TransformadorLineas {
	public static void main(String[] args) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out,StandardCharsets.UTF_8));
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		String linea;
		while((linea = lector.readLine())!=null) {
			String mayusculas = linea.toUpperCase();
			escritor.write(mayusculas);
			escritor.newLine();
			escritor.flush();
		}
		escritor.close();
		
	}
}
