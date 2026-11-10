package ejercitacionPSP;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	
	  private Lanzador() {
	    }

	    public static ProcessBuilder para(String clase, String... argumentos) {
	        String java = Path.of(System.getProperty("java.home"), "bin", "java")
	                .toString();
	        String cp = Path.of(System.getProperty("java.class.path"))
	                .toAbsolutePath().toString();
	        List<String> orden = new ArrayList<>();
	        orden.add(java);
	        orden.add("-cp");
	        orden.add(cp);
	        orden.add(clase);
	        orden.addAll(List.of(argumentos));
	        return new ProcessBuilder(orden);
	    }
	}


