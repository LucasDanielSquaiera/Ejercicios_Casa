package ejercitacionPSP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Optional;

public class HijoIntegradorDos {
	public static void main(String[] args) throws IOException {
		Path f = Path.of(args[1]);
		String variableEntorno = System.getenv(args[0]) != null ? System.getenv(args[0]) :"No definida";
		String existeF = Files.exists(f)  ? "existe":"no existe";
		
		BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out,StandardCharsets.UTF_8));
		long pid = ProcessHandle.current().pid();
		escritor.write("PID del hijo: "+pid);
		escritor.newLine();
		Optional<ProcessHandle> ppid = ProcessHandle.current().parent();
		if(ppid.isPresent()) {
			escritor.write("PID del padre: "+ppid.get().pid());
			escritor.newLine();
		} else {
			escritor.write("PID del padre: inaccesible");
			escritor.newLine();
		}
		
		escritor.write("El valor de la variable de entorno recibida "+args[0]+", es: "+variableEntorno);
		escritor.newLine();
		escritor.write("El fichero recibido "+existeF);
		escritor.newLine();
		escritor.flush();
		escritor.close();
		
		if( Files.exists(f) && !variableEntorno.equals("No definida")) {
			
			System.exit(0);
		}else {
			if(!Files.exists(f)) {
				System.err.println(LocalDate.now()+" Error detectado: el fichero no existe.");
				System.exit(2);
			}
				
			if(variableEntorno.equals("No definida")) {
				System.err.println(LocalDate.now()+" Error detectado: la variable de entorno no existe.");
				System.exit(2);
			}
				
		}
		
	}
}
