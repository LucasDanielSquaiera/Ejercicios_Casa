package ejercitacionPSP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class GeneraSalida {
	public static void main(String[] args) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out,StandardCharsets.UTF_8));
		for(int i = 0; i<=10;i++) {
			escritor.write("Línea número: "+i);
			escritor.newLine();
		}
		System.err.printf("Línea de error desde fichero Hijo\n",StandardCharsets.UTF_8);
		escritor.flush();
		escritor.close();
		
	}
}
