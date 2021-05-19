/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.RH_Empleado;

/**
 *
 * @author Marco Chavez
 */
public class ConexionBD {

    private final String user;
    private final String pass;
    private RH_Empleado empleado;


    private String connectionUrl = "jdbc:sqlserver://l72.17.93.207:1433;databaseName=ERP;integratedSecurity=false";

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

    public RH_Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(RH_Empleado empleado) {
        this.empleado = empleado;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }


    public String getName() {
        String sql = "SELECT login_name "
                + "FROM sys.dm_exec_sessions "
                + "where client_interface_name='Microsoft JDBC Driver 9.2' ";
        String name = "";
        try {
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("login_name");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return name;
    }

}
