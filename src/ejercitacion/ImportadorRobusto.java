package ejercitacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

record Operacion(int id,String tipo,double importe) {}
record ErrorLinea(int numeroLinea,String tipo,String mensaje) {}

public class ImportadorRobusto {
	public static void main(String[] args) {
		Path raiz = Path.of("datos");
		Path fichero = raiz.resolve("operaciones.csv");
		Path auditor = Path.of("auditoria-seguridad.log");
		int contadorLinea = 0;
		
		String [] valoresSimulados = {
				"101;COMPRA;45.50",
				"102;VENTA;120.00",
				"ID_FALSO;COMPRA;10.00",
				"103;DEVOLUCION",
				"104;COMPRA;250.75"};

		rellenarFichero(fichero,valoresSimulados);
		
		ArrayList<Operacion> recuperadas = new ArrayList<>();
		leerFichero(fichero,recuperadas,auditor);
		
		System.out.println(recuperadas);
		
		
		
		
		
	}

	public static Path rellenarFichero(Path fichero,String[] valores) {
		
		try(BufferedWriter escritor = Files.newBufferedWriter(fichero)){
			for(String s : valores) {
				escritor.write(s+"\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fichero;
	}
	
	
	public static void leerFichero(Path fichero,ArrayList<Operacion> recuperadas,Path auditor) {
		
		try(BufferedReader lector = Files.newBufferedReader(fichero)){
			String linea;
			ArrayList<ErrorLinea> erroresEncontrados = new ArrayList<>();
			int contadorLinea = 0;
			
			while((linea = lector.readLine())!= null) {
				String[] delimitador = linea.split(";",3);
				contadorLinea++;
				try {
					if(delimitador.length == 3) {
						Operacion o =new Operacion(Integer.parseInt(delimitador[0]),delimitador[1],Double.parseDouble(delimitador[2]));
						recuperadas.add(o);
					}else {
						String errorLongitud= "Campo ausente";
						ErrorLinea error = new ErrorLinea(contadorLinea,"Línea rota",errorLongitud);
						erroresEncontrados.add(error);
						String mensajeAuditor = "\nError encontrado en línea: "+contadorLinea+", tipor de error: "+errorLongitud+
								"\nFecha: "+LocalDate.now()+"\nCuerpo de la operación errónea:\n"+error;
						Files.writeString(auditor, mensajeAuditor,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
					}
				}catch(NumberFormatException e) {
					ErrorLinea error = new ErrorLinea(contadorLinea,"Línea rota",e.getLocalizedMessage());
					erroresEncontrados.add(error);
					String mensajeAuditor = "\nError encontrado en línea: "+contadorLinea+", tipor de error: Error de formato"+
							"\nFecha: "+LocalDate.now()+"\nCuerpo de la operación errónea:\n"+error;
					Files.writeString(auditor, mensajeAuditor,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
				}
				
			}
				
				
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
}


