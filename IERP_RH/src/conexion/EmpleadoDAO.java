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
import modelo.RH_Empleado;
import modelo.RH_Estado;

/**
 *
 * @author Marco Chavez
 */
public class EmpleadoDAO {

    private final ConexionBD conexion;

    public EmpleadoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public boolean insertarEmpleado(RH_Empleado empleado) {
        String sql = "insert into RH.Estados values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean ban = false;
        try {

            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, empleado.getNombre());
            st.setString(2, empleado.getApellidoPaterno());
            st.setString(3, empleado.getApellidoMaterno());
            st.setString(4, empleado.getSexo());
            st.setDate(5, empleado.getFechaNacimeinto());
            st.setString(6, empleado.getEstadoCivil());
            st.setDate(7, empleado.getFechaContratacion());
            st.setFloat(8, empleado.getSalarioDiario());
            st.setString(9, empleado.getNss());
            st.setInt(10, empleado.getDiasVacaciones());
            st.setInt(11, empleado.getDiasPermiso());
            st.setBytes(12, empleado.getFotografia());
            st.setString(13, empleado.getDireccion());
            st.setString(14, empleado.getColonia());
            st.setString(15, empleado.getCodigoPostal());
            st.setString(16, empleado.getEscolaridad());
            st.setString(17, empleado.getEspecialidad());
            st.setString(18, empleado.getEmail());
            st.setString(19, empleado.getPassword());
            st.setString(20, empleado.getTipo());
            st.setString(21, empleado.getEstatus());
            st.setInt(22, empleado.getIdDepartamento());
            st.setInt(23, empleado.getIdPuesto());
            st.setInt(24, empleado.getIdCiudad());
            st.setInt(25, empleado.getIdSucursal());
            st.setInt(26, empleado.getIdTurno());

            st.execute();

            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

//    public ArrayList<RH_Empleado> consultaEmpleados() {
//        String sql = "select * "
//                + " from RH.Estados "
//                + " ORDER BY idEstado ASC";
//        ArrayList<RH_Empleado> lista = new ArrayList<>();
//        try {
//            Statement st = conexion.getConexion().createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                RH_Empleado e = new RH_Empleado();
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
//    public boolean eliminacionLogicaEstado(RH_Estado p) {
//        String sql = "update RH.Estados set estatus=? "
//                + " where idEstado=?";
//        boolean ban = false;
//        try {
//            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
//            st.setInt(2, p.getIdEstado());
//            st.setString(1, "I");
//            st.execute();
//            st.close();
//            ban = true;
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
//        }
//        return ban;
//    }

}
