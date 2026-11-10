package ejercitacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InspectorInformes {
	public static void main(String[] args) {
		Path documentos = Path.of("documentos","departamentoA");
		Path subcarpeta = documentos.getParent().resolve("departamentoB");
		Path informe =Path.of("informe-resumen.txt");
		

		try (Stream<Path> flujo = Files.walk(documentos.getParent())){
			//Creamos estructura de carpetas
			Files.createDirectories(documentos);
			Files.createDirectories(subcarpeta);
			Files.writeString(documentos.resolve("nota1.txt"), "Este documento es urgente");
			Files.writeString(subcarpeta.resolve("nota2.txt"), "Este documento es urgente");	
			Files.writeString(subcarpeta.resolve("nota3.txt"), "Este documento es de relleno");
		
			// Recorremos la estructura con el Stream
						
			flujo.filter(Files:: isRegularFile).filter(p -> p.toString().endsWith(".txt")).forEach(p->{
				String palabraClave = "Urgente";
				
				try {					
					String nombreFichero = p.getFileName().toString();
					String linea = "Fichero: "+nombreFichero+" "+Files.readString(p);
					if(linea.toLowerCase().contains(palabraClave)) {
						Files.writeString(informe,linea+"\n",StandardOpenOption.CREATE,StandardOpenOption.APPEND);
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			});;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
