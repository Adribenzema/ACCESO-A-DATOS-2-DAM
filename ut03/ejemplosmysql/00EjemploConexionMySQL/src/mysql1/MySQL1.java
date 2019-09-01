/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author J
 */
public class MySQL1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            String cadenaConexion = "jdbc:mysql://localhost/sakila?user=root&password=@sturiaS2016";
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
            
            
            
          
            
            // inserta un dato
             stmt.executeUpdate("INSERT INTO `sakila`.`actor` (`actor_id`, `first_name`, `last_name`, `last_update`) VALUES ('201', 'Javier', 'Barden', '2006-02-15 04:34:33');");
           
                    
            
            // Borra un dato
           // stmt.executeUpdate("DELETE FROM `sakila`.`actor` WHERE `actor_id`='201';");
            
            
            //Visualiza resultados
     /*       ResultSet rs = stmt.executeQuery("SELECT * from actor");

            String usuario;
            while (rs.next()) {
                usuario = rs.getString("last_name");
                System.out.println(usuario);
            }
    */
            con.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
