/**
 *
 * @author Dahia
 */
package s_ilabs.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LooginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //Conexión con la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/s_ilabjava", "root", "MySQL123"
            );

            //Validación de credenciales en la BD
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM usuarios WHERE nombre=? AND password=?"
            );
            ps.setString(1, nombre);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            //Respuesta al ingreso con archivo .jsp
            out.println("<html><body>");
            if (rs.next()) {
                request.setAttribute("nombre", nombre);
                request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
            }else {
                out.println("<h2 style='color:red;'>Acceso denegado</h2>");
            }
            out.println("</body></html>");

            //Cierre de conexiones -- Buenas práctica para liberar espacio
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace(out); // muestra el error en el navegador
        }
    }
}

