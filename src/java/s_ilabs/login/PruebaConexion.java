import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) throws Exception{
        
        // Paso 1: Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Crear la conexión con la base de datos, declarando variables para bd, usuario y clave 
            String url = "jdbc:mysql://localhost:3306/s_ilabjava";
            String usuario = "root";
            String clave = "MySQL123";

            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión exitosa");
            
            conexion.close();
    }
}


