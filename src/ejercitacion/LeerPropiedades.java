package ejercitacion;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class LeerPropiedades {
    public static void main(String[] args) {
        Path fichero = Path.of("documentosXML/config.properties");
        Properties props = new Properties();

        try {
            // Cargamos el fichero usando un InputStream proporcionado por Files
            props.load(Files.newInputStream(fichero));

            // Extraemos los valores por su clave
            String url = props.getProperty("db.url");
            String usuario = props.getProperty("db.user");
            
            // Podemos definir un valor por defecto si la clave no existe
            String puerto = props.getProperty("db.port", "3306"); 

            System.out.println("URL de BD: " + url);
            System.out.println("Usuario: " + usuario);
            System.out.println("Puerto por defecto: " + puerto);

        } catch (IOException e) {
            System.out.println("No se pudo leer el fichero de propiedades.");
            e.printStackTrace();
        }
    }
}
