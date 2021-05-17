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
import modelo.Compras_Sucursal;
import modelo.RH_Ciudad;

/**
 *
 * @author Marco Chavez
 */
public class SucursalesDAO {

    private ConexionBD conexion;

    public SucursalesDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }

    public boolean insertarSucursal(Compras_Sucursal sucursal) {
        String sql = "insert into Compras.Sucursales values(?,?,?,?,?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, sucursal.getNombre());
            st.setString(2, sucursal.getTelefono());
            st.setString(3, sucursal.getDireccion());
            st.setString(4, sucursal.getColonia());
            st.setString(5, sucursal.getCodigoPostal());
            st.setFloat(6, sucursal.getPresupuesto());
            st.setInt(7, sucursal.getCiudad().getIdCiudad());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<Compras_Sucursal> consultaSucursalesVista() {
        String sql = "select * from vSucursales "
                + "order by idSucursal ";

        ArrayList<Compras_Sucursal> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compras_Sucursal e = new Compras_Sucursal();
                e.setIdSucursal(rs.getInt("idSucursal"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setPresupuesto(rs.getFloat("presupuesto"));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Compras_Sucursal> consultaSucursalesVistaCiudad(Integer idCiudad) {
        String sql = "select * from vSucursales "
                + " where idCiudad="+idCiudad;
        
        ArrayList<Compras_Sucursal> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compras_Sucursal e = new Compras_Sucursal();
                e.setIdSucursal(rs.getInt("idSucursal"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setPresupuesto(rs.getFloat("presupuesto"));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Compras_Sucursal> consultaSucursalesVistaPaginada(Integer pagina) {
        String sql = "select * from vSucursales "
                + "order by idSucursales "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<Compras_Sucursal> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compras_Sucursal e = new Compras_Sucursal();
                e.setIdSucursal(rs.getInt("idSucursal"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setPresupuesto(rs.getFloat("presupuesto"));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Sucursales FROM vSucursales)/CAST(" + 3 + " AS float)))as paginasMaximas";
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Sucursales FROM vSucursales where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 3 + " AS float)))as paginasMaximas";
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

    public ArrayList<Compras_Sucursal> consultaSucursalesNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vSucursales "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idEstado "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<Compras_Sucursal> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compras_Sucursal e = new Compras_Sucursal();
                e.setIdSucursal(rs.getInt("idSucursal"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setPresupuesto(rs.getFloat("presupuesto"));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Compras_Sucursal> consultaSucursalesNombreVista(String nombre) {
        String sql = "select * "
                + "from vSucursales "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<Compras_Sucursal> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compras_Sucursal e = new Compras_Sucursal();
                e.setIdSucursal(rs.getInt("idSucursal"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setPresupuesto(rs.getFloat("presupuesto"));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public Compras_Sucursal consultaSucursalNombre(String nombre) {
        String sql = "select * "
                + "from Compras.Sucursalses "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        Compras_Sucursal e = new Compras_Sucursal();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                e.setIdSucursal(rs.getInt("idSucursal"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setPresupuesto(rs.getFloat("presupuesto"));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error:" + err.getMessage());
        }
        return e;

    }

    public Compras_Sucursal consultaSucursalId(int idSucursal) {
        String sql = (" select * "
                + " from Compras.Sucursales "
                + " where idSucursal=" + idSucursal);
        Compras_Sucursal e = new Compras_Sucursal();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                e.setIdSucursal(rs.getInt("idSucursal"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setPresupuesto(rs.getFloat("presupuesto"));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error:" + err.getMessage());
        }
        return e;
    }

    public boolean actualizarSucursal(Compras_Sucursal sucursal) {
        String sql = "update Compras.Sucursales set nombre=?, telefono=?, direccion=?,"
                + "colonia=? , codigoPostal=? , presupuesto=? ,idCiudad=?  "
                + " where idSucursal=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, sucursal.getNombre());
            st.setString(2, sucursal.getTelefono());
            st.setString(3, sucursal.getDireccion());
            st.setString(4, sucursal.getColonia());
            st.setString(5, sucursal.getCodigoPostal());
            st.setFloat(6, sucursal.getPresupuesto());
            st.setInt(7, sucursal.getCiudad().getIdCiudad());
            st.execute();
            st.close();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(Compras_Sucursal p) {
        String sql = "update RH.Sucursales set estatus=? "
                + " where idSucursal=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, p.getIdSucursal());
            st.setString(1, "I");
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
