/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.RH_NominaDeduccion;

/**
 *
 * @author Marco Chavez
 */
public class NominaDeduccionDAO {

    private ConexionBD conexion;

    public NominaDeduccionDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public boolean insertarNominaDeducion(RH_NominaDeduccion nominaDeduccion) {
        String sql = "insert into RH.NominasDeducciones values(?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setInt(1, nominaDeduccion.getNomina().getIdNomina());
            st.setInt(2, nominaDeduccion.getDeduccion().getIdDeduccion());
            st.setFloat(3, nominaDeduccion.getImporte());
            st.setString(4, nominaDeduccion.getEstatus());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }
}
