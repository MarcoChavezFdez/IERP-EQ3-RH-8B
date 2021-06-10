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
import modelo.RH_Deduccion;
import modelo.RH_Nomina;
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
        public ArrayList<RH_NominaDeduccion> consultaDeducciones(Integer idNomina) {
        String sql = "select * "
                + "from RH.NominasDeducciones "
                + "where idNomina="+idNomina;
        ArrayList<RH_NominaDeduccion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_NominaDeduccion e = new RH_NominaDeduccion();
                e.setNomina(new RH_Nomina());
                e.getNomina().setIdNomina(rs.getInt("idNomina"));
                e.getNomina().recuperaNomina(conexion);
                e.setDeduccion(new RH_Deduccion(rs.getInt("idDeduccion"),this.conexion));
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

