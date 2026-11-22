package ejercitacionPSP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class HijoIntegrador1 {
	public static void main(String[] args) throws IOException {
		
		ProcessHandle pid = ProcessHandle.current();
		System.out.println("Hijo: mi PID es: "+ pid.pid());
		Path f = Path.of(args[1]);
		String valorVariable = (System.getenv(args[0]) != null) ? System.getenv(args[0]): "No Definida" ;
		
		try(BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out,StandardCharsets.UTF_8))){
			Optional<ProcessHandle> pPid = pid.parent();
			if(pPid.isPresent()) {
				ProcessHandle p = pPid.get();
				escritor.write("Hijo: el PID de mi padre es: "+p.pid()+"\n");
			}else {
				escritor.write("Hijo: no puedo ver el PID de mi padre");
			}
			escritor.write("Hijo: mostrando la varibale de entorno del argumento pasado por el Padre: "+ args[0]+"\n");
			escritor.write(valorVariable);
			
			escritor.write("\nHijo: el fichero del argumento pasado por el Padre: "+ args[1]+" existe?\n"+Files.exists(f));
			escritor.write("\nTerminando ejecucuión...");
			
		}
		if(Files.exists(f) && !valorVariable.equals("No Definida"))
			System.exit(0);
			else {
				System.exit(2);
			}
	
		
	}
}
