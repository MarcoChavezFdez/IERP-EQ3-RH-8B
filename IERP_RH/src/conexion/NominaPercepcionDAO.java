/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RH_Nomina;
import modelo.RH_NominaPercepcion;
import modelo.RH_Percepcion;

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

    public ArrayList<RH_NominaPercepcion> consultaPercepciones(Integer idNomina) {
        String sql = "select * "
                + "from RH.NominasPercepciones "
                + "where idNomina=" + idNomina;
        ArrayList<RH_NominaPercepcion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_NominaPercepcion e = new RH_NominaPercepcion();
                e.setNomina(new RH_Nomina());
                e.getNomina().setIdNomina(rs.getInt("idNomina"));
                e.getNomina().recuperaNomina(conexion);
                e.setPercepcion(new RH_Percepcion(rs.getInt("idPercepcion"), this.conexion));
                e.setImporte(rs.getFloat("importe"));
                e.setEstatus(rs.getString("estatus"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }
}
