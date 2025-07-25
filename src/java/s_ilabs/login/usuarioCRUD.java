/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s_ilabs.login;
import java.sql.*;
/**
 *
 * @author Dahia
 */
public class usuarioCRUD {
    
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/s_ilabjava";
        String usuario = "root";
        String clave = "MySQL123";

        Connection conn = DriverManager.getConnection(url, usuario, clave);
        Statement stmt = conn.createStatement();
        ResultSet rs;

        //CONSULTA INICIAL
        System.out.println("\n Estado inicial:");
        rs = stmt.executeQuery("SELECT * FROM usuarios");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | Nombre: " + rs.getString("nombre"));
        }
        
        System.out.println("========================================");

        //INSERCIÓN DE DATOS
        System.out.println("\n INSERTANDO usuario Dahiana (ID 5)");
        stmt.executeUpdate("INSERT INTO usuarios (id, nombre, email, password, rol) VALUES (5, 'Dahiana', 'dahiana@gmail.com', '1234', 'admin')");
        rs = stmt.executeQuery("SELECT * FROM usuarios");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | Nombre: " + rs.getString("nombre"));
        }

        System.out.println("========================================");
        
        //ACTUALIZACIÓN DE DATOS
        System.out.println("\n ACTUALIZANDO usuario con ID 3, cambio de nombre de Ronaldp a Ronaldo");
        stmt.executeUpdate("UPDATE usuarios SET nombre='Ronaldo' WHERE id=3");
        rs = stmt.executeQuery("SELECT * FROM usuarios");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | Nombre: " + rs.getString("nombre"));
        }

        System.out.println("========================================");
        
        //ELIMINACIÓN DE DATOS
        System.out.println("\n ELIMINANDO usuario con ID 5");
        stmt.executeUpdate("DELETE FROM usuarios WHERE id=5");
        rs = stmt.executeQuery("SELECT * FROM usuarios");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | Nombre: " + rs.getString("nombre"));
        }
        
        System.out.println("========================================");
        
        //CIERRE
        conn.close();
        System.out.println("\n Conexión cerrada correctamente");
        }
}

    
