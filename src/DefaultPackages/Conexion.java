package DefaultPackages;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    public static final String BaseDeDatos = "stock";
    public static final String usuario = "root";         
    public static final String contraseña = "minimei13";

    public static final String URL = "jdbc:mysql://localhost:3306/" + BaseDeDatos + "?autoReconnet = true&useSSL=false";

    public Connection getConnection() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL, usuario, contraseña);

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
        }

        return conexion;

    }

}
