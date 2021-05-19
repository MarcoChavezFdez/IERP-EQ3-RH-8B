/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.RH_NominaPercepcion;

/**
 *
 * @author Marco Chavez
 */
public class NominaPercepcionDAO {
        private ConexionBD conexion;

    public NominaPercepcionDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public boolean insertarNominaPercepcion(RH_NominaPercepcion nominaPercepcion) {
        String sql = "insert into RH.NominasPercepciones values(?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setInt(1, nominaPercepcion.getNomina().getIdNomina());
        st.setInt(2, nominaPercepcion.getPercepcion().getIdPercepcion());
            st.setFloat(3, nominaPercepcion.getImporte());
            st.setString(4, nominaPercepcion.getEstatus());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }
}
