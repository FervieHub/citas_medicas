
package ConexionDB;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConexionBase {
    
    Connection conectar = null;
    Statement sentencia = null;
    ResultSet resultado = null;

    public ConexionBase() {
    
        try {
            String rutaBD="C:\\TareaG7_New\\clinicaG7.accdb";
            String url="jdbc:ucanaccess://"+rutaBD;
            conectar = DriverManager.getConnection(url);
            sentencia = conectar.createStatement();
            //JOptionPane.showMessageDialog(null, "Conectado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos"+e);
            System.exit(0);
        }
    }

    public Connection getConnection() {
        return conectar;
    }
    
    
}
