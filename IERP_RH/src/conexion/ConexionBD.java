/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marco Chavez
 */
public class ConexionBD {

    private final String user;
    private final String pass;

    private String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master;integratedSecurity=false";
    private Connection conexion;

    public ConexionBD(String user, String pass) {
        this.user = user;
        this.pass = pass;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(connectionUrl, user, pass);
        } catch (SQLException e) {
            System.out.println("Error al conectar con MS SQL Server:" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver:" + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    //Modificar este metodo 
    public static Connection GetConexion() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=ERP;"
                + "user=sa;"
                + "password=1234;";
        try {

            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
