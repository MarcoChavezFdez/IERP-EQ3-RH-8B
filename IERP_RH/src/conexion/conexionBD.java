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
public class conexionBD {
    public static  Connection GetConexion() throws SQLException, ClassNotFoundException{
       String url ="jdbc:sqlserver://localhost:1433;"
               +"databaseName=AgroZam;"
               + "user=sa;"
               + "password=1234;";
       try{
          
           Connection con =DriverManager.getConnection(url);
           return con;
       } catch(SQLException e){
           System.out.println(e.toString());
           return  null;
       }
    }
}
