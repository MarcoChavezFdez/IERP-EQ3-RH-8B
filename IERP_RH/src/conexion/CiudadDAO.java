package conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RH_Ciudad;
//import modelo.RH_Ciudades;

public class CiudadDAO {

    private ConexionBD conexion;

    public CiudadDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarCiudad(RH_Ciudad ciudad) {
        String sql = "insert into RH.Ciudades values(?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, ciudad.getNombre());
            st.setInt(2, ciudad.getIdEstado());
            st.setString(3, "A");
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Ciudad> consultaCiudadesVista() {
        String sql = "select * from vCiudades";
        ArrayList<RH_Ciudad> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Ciudad c = new RH_Ciudad();
                c.setIdCiudad(rs.getInt("idCiudad"));
                c.setNombre(rs.getString("nombre"));
                c.setNombreEstado(rs.getString("nombreEstado"));
                c.setIdEstado(rs.getInt("idEstado"));
                lista.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Ciudad> consultarCiudadesNombre(String nombre) {
        String sql = "select * "
                + "from vCiudades "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Ciudad> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Ciudad c = new RH_Ciudad();
                c.setIdCiudad(rs.getInt("idCiudad"));
                c.setNombre(rs.getString("nombre"));
                c.setNombreEstado(rs.getString("nombreEstado"));
                c.setIdEstado(rs.getInt("idEstado"));
                lista.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Ciudad consultarCiudadId(Integer idCiudad) {
        String sql = "select * "
                + "from RH.Ciudades "
                + "where idCiudad=?";

        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setInt(1, idCiudad);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                RH_Ciudad ciudad = new RH_Ciudad();
                ciudad.setIdCiudad(rs.getInt("idCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setIdEstado(rs.getInt("idEstado"));
                rs.close();
                st.close();
                return ciudad;
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return null;
    }
//
//    public ArrayList<RH_Estado> consultaEstadoNombre(String nombre) {
//        String sql = "select * "
//                + "from RH.Estados "
//                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
//        ArrayList<RH_Estado> lista = new ArrayList<>();
//        try {
//            Statement st = conexion.getConexion().createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                RH_Estado e = new RH_Estado();
//                e.setIdEstado(rs.getInt("idEstado"));
//                e.setNombre(rs.getString("nombre"));
//                e.setSiglas(rs.getString("siglas"));
//                e.setEstatus(rs.getString("estatus"));
//                lista.add(e);
//            }
//            rs.close();
//            st.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
//        }
//        return lista;
//    }
//
//    public RH_Estado consultaEstadoId(int idEstado) {
//        String sql = (" select * "
//                + " from RH.Estados "
//                + " where idEstado=" + idEstado);
//        RH_Estado estado = new RH_Estado();
//        try {
//            Statement st = conexion.getConexion().createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            while (rs.next()) {
//                estado.setIdEstado(rs.getInt("idEstado"));
//                estado.setNombre(rs.getString("nombre"));
//                estado.setSiglas(rs.getString("siglas"));
//                estado.setEstatus(rs.getString("estatus"));
//            }
//            rs.close();
//            st.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
//        }
//        return estado;
//    }
//
//    public boolean actualizarEstado(RH_Estado estado) {
//        String sql = "update RH.Estados set nombre=?, siglas=?, estatus=? "
//                + " where idEstado=?";
//        boolean ban = false;
//        try {
//            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
//            st.setInt(4, estado.getIdEstado());
//            st.setString(1, estado.getNombre());
//            st.setString(2, estado.getSiglas());
//            st.setString(3, estado.getEstatus());
//            st.execute();
//            st.close();
//            ban = true;
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
//        }
//        return ban;
//    }
//

    public boolean eliminacionLogicaCiudad(RH_Ciudad c) {
        String sql = "update RH.Ciudades set estatus=? "
                + "where idCiudad=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, "I");
            st.setInt(2, c.getIdCiudad());
            st.execute();
            st.close();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
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
