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
import modelo.RH_Percepcion;

/**
 *
 * @author Marco Chavez
 */
public class PercepcionDAO {

    ConexionBD conexion;

    public PercepcionDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public boolean insertarPercepcion(RH_Percepcion percepcion) {
        String sql = "insert into RH.Percepciones values(?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, percepcion.getNombre());
            st.setString(2, percepcion.getDescripcion());
            st.setInt(3, percepcion.getDiasPagar());
            st.setString(4,percepcion.getEstatus());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Percepcion> consultaPercepcionesVista() {
        String sql = "select * from vPercepciones "
                + "order by idPercepcion ";

        ArrayList<RH_Percepcion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Percepcion e = new RH_Percepcion();
                e.setIdPercepcion(rs.getInt("idPercepcion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setDiasPagar(rs.getInt("diasPagar"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Percepcion> consultaPercepcionesVistaPaginada(Integer pagina) {
        String sql = "select * from vPercepciones "
                + "order by idPercepcion "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Percepcion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Percepcion e = new RH_Percepcion();
                e.setIdPercepcion(rs.getInt("idPercepcion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setDiasPagar(rs.getInt("diasPagar"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public Integer consultaPaginas() {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Percepciones FROM vPercepciones)/CAST(" + 3 + " AS float)))as paginasMaximas";
        Integer r = null;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                r = rs.getInt("paginasMaximas");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return r;
    }

    public Integer consultaPaginasNombre(String nombre) {
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Percepciones FROM vPercepciones where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 3 + " AS float)))as paginasMaximas";
        Integer r = null;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                r = rs.getInt("paginasMaximas");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return r;
    }

    public ArrayList<RH_Percepcion> consultaPercepcionesNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vPercepciones "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idPercepcion "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Percepcion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Percepcion e = new RH_Percepcion();
                e.setIdPercepcion(rs.getInt("idPercepcion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setDiasPagar(rs.getInt("diasPagar"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Percepcion> consultaPercepcionesNombreVista(String nombre) {
        String sql = "select * "
                + "from RH.Percepciones "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Percepcion> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Percepcion e = new RH_Percepcion();
                e.setIdPercepcion(rs.getInt("idPercepcion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setDiasPagar(rs.getInt("diasPagar"));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Percepcion consultaPercepcionNombre(String nombre) {
        String sql = "select * "
                + "from RH.Percepciones "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        RH_Percepcion e = new RH_Percepcion();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                e.setIdPercepcion(rs.getInt("idPercepcion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setDiasPagar(rs.getInt("diasPagar"));
            }
            rs.close();
            st.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error:" + err.getMessage());
        }
        return e;

    }

    public RH_Percepcion consultaPercepcionId(int idPercepcion) {
        String sql = (" select * "
                + " from RH.Percepciones "
                + " where idPercepcion=" + idPercepcion);
        RH_Percepcion e = new RH_Percepcion();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                e.setIdPercepcion(rs.getInt("idPercepcion"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setDiasPagar(rs.getInt("diasPagar"));
            }
            rs.close();
            st.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error:" + err.getMessage());
        }
        return e;
    }

    public boolean actualizarPercepcion(RH_Percepcion percepcion) {
        String sql = "update RH.Percepciones set nombre=?, descripcion=?, diasPagar=? "
                + " where idPercepcion=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(4, percepcion.getIdPercepcion());
            st.setString(1, percepcion.getNombre());
            st.setString(2, percepcion.getDescripcion());
            st.setInt(3, percepcion.getDiasPagar());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_Percepcion p) {
        String sql = "update RH.Percepciones set estatus=? "
                + " where idPercepcion=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, p.getIdPercepcion());
            st.setString(1, "I");
            st.execute();
            st.close();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionPercepcion(Integer p) {
        String sql = "delete from RH.Percepciones "
                + "where idPercepcion=" + p;
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error elimando:" + e.getMessage());
        }
        return ban;
    }

    public ConexionBD getConexion() {
        return conexion;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }
}
