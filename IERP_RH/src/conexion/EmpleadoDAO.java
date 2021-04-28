/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Compras_Sucursal;
import modelo.RH_Ciudad;
import modelo.RH_Departamento;
import modelo.RH_Empleado;
import modelo.RH_Puesto;
import modelo.RH_Turno;

/**
 *
 * @author Marco Chavez
 */
public class EmpleadoDAO {

    private ConexionBD conexion;

    public EmpleadoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public boolean insertarPrueba(InputStream image) {
        String sql = "insert into RH.Fotografias values(?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setBinaryStream(1, image);
            st.execute();
            ban = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public InputStream consultaFotografia(Integer idFoto) {
        String sql = "select * from RH.Fotografias "
                + "where idFotografia=" + idFoto;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                InputStream image;
                image = rs.getBinaryStream("fotografia");
                return image;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return null;
    }

    public RH_Empleado consultaEmpleado(Integer idEmpleado) {
        String sql = "select * from vEmpleados"
                + "where idEmpleado=" + idEmpleado;
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                RH_Empleado empleado = new RH_Empleado();
                empleado.setIdEmpleado(idEmpleado);
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                empleado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                empleado.setSexo(rs.getString("sexo"));
                empleado.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                empleado.setCurp(rs.getString("curp"));
                empleado.setEstadoCivil(rs.getString("estadoCivil"));
                empleado.setFechaContratacion(rs.getDate("fechaContratacion"));
                empleado.setSalarioDiario(rs.getFloat("salarioDiario"));
                empleado.setNss(rs.getString("nss"));
                empleado.setDiasVacaciones(rs.getInt("diasVacaciones"));
                empleado.setDiasPermiso(rs.getInt("diasPermiso"));
                empleado.setFotografia(rs.getBinaryStream("fotografia"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setColonia(rs.getString("colonia"));
                empleado.setCodigoPostal(rs.getString("cp"));
                empleado.setEscolaridad(rs.getString("escolaridad"));
                empleado.setEspecialidad(rs.getString("especialidad"));
                empleado.setEmail(rs.getString("email"));
                empleado.setPassword(rs.getString("password"));
                empleado.setTipo(rs.getString("tipo"));
                empleado.setEstatus(rs.getString("estatus"));
                empleado.setDepartamento(new RH_Departamento(rs.getInt("idDepartamento"), this.conexion));
                empleado.setPuesto(new RH_Puesto(rs.getInt("idPuesto"), this.conexion));
                empleado.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                empleado.setSucursal(new Compras_Sucursal(rs.getInt("idSucursal"), this.conexion));
                empleado.setTurno(new RH_Turno(rs.getInt("idTurno"), this.conexion));
                rs.close();
                st.close();
                return empleado;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return null;
    }

    public boolean insertarEmpleado(RH_Empleado empleado) {
        String sql = "insert into RH.Empleados values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean ban = false;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement(sql);
            st.setString(1, empleado.getNombre());
            st.setString(2, empleado.getApellidoPaterno());
            st.setString(3, empleado.getApellidoMaterno());
            st.setString(4, empleado.getSexo());
            st.setDate(5, empleado.getFechaNacimiento());
            st.setString(6, empleado.getCurp());
            st.setString(7, empleado.getEstadoCivil());
            st.setDate(8, empleado.getFechaContratacion());
            st.setFloat(9, empleado.getSalarioDiario());
            st.setString(10, empleado.getNss());
            st.setInt(11, empleado.getDiasVacaciones());
            st.setInt(12, empleado.getDiasPermiso());
            st.setBinaryStream(13, empleado.getFotografia());
            st.setString(14, empleado.getDireccion());
            st.setString(15, empleado.getColonia());
            st.setString(16, empleado.getCodigoPostal());
            st.setString(17, empleado.getEscolaridad());
            st.setString(18, empleado.getEspecialidad());
            st.setString(19, empleado.getEmail());
            st.setString(20, empleado.getPassword());
            st.setString(21, empleado.getTipo());
            st.setString(22, empleado.getEstatus());
            st.setInt(23, empleado.getDepartamento().getIdDepartamento());
            st.setInt(24, empleado.getPuesto().getIdPuesto());
            st.setInt(25, empleado.getCiudad().getIdCiudad());
            st.setInt(26, empleado.getSucursal().getIdSucursal());
            st.setInt(27, empleado.getTurno().getIdTurno());
            st.execute();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return ban;
    }

    public ArrayList<RH_Empleado> consultaEmpleadosVistaPaginada(Integer pagina) {
        String sql = "select * from vEmpleados "
                + "order by idEmpleado "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Empleado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Empleado e = new RH_Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidoPaterno(rs.getString("apellidoPaterno"));
                e.setApellidoMaterno(rs.getString("apellidoMaterno"));
                e.setSexo(rs.getString("sexo"));
                e.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                e.setCurp(rs.getString("curp"));
                e.setEstadoCivil(rs.getString("estadoCivil"));
                e.setFechaContratacion(rs.getDate("fechaContratacion"));
                e.setSalarioDiario(rs.getFloat("salarioDiario"));
                e.setNss(rs.getString("nss"));
                e.setDiasVacaciones(rs.getInt("diasVacaciones"));
                e.setDiasPermiso(rs.getInt("diasPermiso"));
                e.setFotografia(rs.getBinaryStream("fotografia"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setCodigoPostal(rs.getString("codigoPostal"));
                e.setEscolaridad(rs.getString("escolaridad"));
                e.setEspecialidad(rs.getString("especialidad"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("password"));
                e.setTipo(rs.getString("tipo"));
                e.setEstatus(rs.getString("estatus"));
                e.setDepartamento(new RH_Departamento(rs.getInt("idDepartamento"), this.conexion));
                e.setPuesto(new RH_Puesto(rs.getInt("idPuesto"), this.conexion));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                e.setSucursal(new Compras_Sucursal(rs.getInt("idSucursal"), this.conexion));
                e.setTurno(new RH_Turno(rs.getInt("idTurno"), this.conexion));
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Empleados FROM vEmpleados)/CAST(" + 3 + " AS float)))as paginasMaximas";
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
        String sql = "SELECT CEILING((SELECT(SELECT COUNT(*) as Empleados FROM vEmpleados where Nombre like CONCAT( '%','" + nombre + "','%'))/CAST(" + 3 + " AS float)))as paginasMaximas";
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

    public ArrayList<RH_Empleado> consultaEmpleadosNombreVistaPaginada(String nombre, Integer pagina) {
        String sql = "select * "
                + "from vEmpleados "
                + "where nombre like CONCAT( '%','" + nombre + "','%') "
                + "order by idEmpleado "
                + "offset " + (pagina - 1) * 3 + " rows "
                + "fetch next 3 rows only ";

        ArrayList<RH_Empleado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Empleado e = new RH_Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidoPaterno(rs.getString("apellidoPaterno"));
                e.setApellidoMaterno(rs.getString("apellidoMaterno"));
                e.setSexo(rs.getString("sexo"));
                e.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                e.setCurp(rs.getString("curp"));
                e.setEstadoCivil(rs.getString("estadoCivil"));
                e.setFechaContratacion(rs.getDate("fechaContratacion"));
                e.setSalarioDiario(rs.getFloat("salarioDiario"));
                e.setNss(rs.getString("nss"));
                e.setDiasVacaciones(rs.getInt("diasVacaciones"));
                e.setDiasPermiso(rs.getInt("diasPermiso"));
                e.setFotografia(rs.getBinaryStream("fotografia"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setCodigoPostal(rs.getString("codigoPostal"));
                e.setEscolaridad(rs.getString("escolaridad"));
                e.setEspecialidad(rs.getString("especialidad"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("password"));
                e.setTipo(rs.getString("tipo"));
                e.setEstatus(rs.getString("estatus"));
                e.setDepartamento(new RH_Departamento(rs.getInt("idDepartamento"), this.conexion));
                e.setPuesto(new RH_Puesto(rs.getInt("idPuesto"), this.conexion));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                e.setSucursal(new Compras_Sucursal(rs.getInt("idSucursal"), this.conexion));
                e.setTurno(new RH_Turno(rs.getInt("idTurno"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<RH_Empleado> consultaEmpleadosNombreVista(String nombre) {
        String sql = "select * "
                + "from vEmpleados "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        ArrayList<RH_Empleado> lista = new ArrayList<>();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RH_Empleado e = new RH_Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidoPaterno(rs.getString("apellidoPaterno"));
                e.setApellidoMaterno(rs.getString("apellidoMaterno"));
                e.setSexo(rs.getString("sexo"));
                e.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                e.setCurp(rs.getString("curp"));
                e.setEstadoCivil(rs.getString("estadoCivil"));
                e.setFechaContratacion(rs.getDate("fechaContratacion"));
                e.setSalarioDiario(rs.getFloat("salarioDiario"));
                e.setNss(rs.getString("nss"));
                e.setDiasVacaciones(rs.getInt("diasVacaciones"));
                e.setDiasPermiso(rs.getInt("diasPermiso"));
                e.setFotografia(rs.getBinaryStream("fotografia"));
                e.setDireccion(rs.getString("direccion"));
                e.setColonia(rs.getString("colonia"));
                e.setCodigoPostal(rs.getString("codigoPostal"));
                e.setEscolaridad(rs.getString("escolaridad"));
                e.setEspecialidad(rs.getString("especialidad"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("password"));
                e.setTipo(rs.getString("tipo"));
                e.setEstatus(rs.getString("estatus"));
                e.setDepartamento(new RH_Departamento(rs.getInt("idDepartamento"), this.conexion));
                e.setPuesto(new RH_Puesto(rs.getInt("idPuesto"), this.conexion));
                e.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                e.setSucursal(new Compras_Sucursal(rs.getInt("idSucursal"), this.conexion));
                e.setTurno(new RH_Turno(rs.getInt("idTurno"), this.conexion));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return lista;
    }

    public RH_Empleado consultaEmpleadoNombre(String nombre) {
        String sql = "select * "
                + "from vEmpleados "
                + "where Nombre like CONCAT( '%','" + nombre + "','%')";
        RH_Empleado empleado = new RH_Empleado();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                empleado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                empleado.setSexo(rs.getString("sexo"));
                empleado.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                empleado.setCurp(rs.getString("curp"));
                empleado.setEstadoCivil(rs.getString("estadoCivil"));
                empleado.setFechaContratacion(rs.getDate("fechaContratacion"));
                empleado.setSalarioDiario(rs.getFloat("salarioDiario"));
                empleado.setNss(rs.getString("nss"));
                empleado.setDiasVacaciones(rs.getInt("diasVacaciones"));
                empleado.setDiasPermiso(rs.getInt("diasPermiso"));
                empleado.setFotografia(rs.getBinaryStream("fotografia"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setColonia(rs.getString("colonia"));
                empleado.setCodigoPostal(rs.getString("codigoPostal"));
                empleado.setEscolaridad(rs.getString("escolaridad"));
                empleado.setEspecialidad(rs.getString("especialidad"));
                empleado.setEmail(rs.getString("email"));
                empleado.setPassword(rs.getString("password"));
                empleado.setTipo(rs.getString("tipo"));
                empleado.setEstatus(rs.getString("estatus"));
                empleado.setDepartamento(new RH_Departamento(rs.getInt("idDepartamento"), this.conexion));
                empleado.setPuesto(new RH_Puesto(rs.getInt("idPuesto"), this.conexion));
                empleado.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                empleado.setSucursal(new Compras_Sucursal(rs.getInt("idSucursal"), this.conexion));
                empleado.setTurno(new RH_Turno(rs.getInt("idTurno"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error:" + err.getMessage());
        }
        return empleado;

    }

    public RH_Empleado consultaEmpleadoId(int idEmpleado) {
        String sql = (" select * "
                + " from vEmpleados "
                + " where idEmpleado=" + idEmpleado);
        RH_Empleado empleado = new RH_Empleado();
        try {
            Statement st = conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                empleado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                empleado.setSexo(rs.getString("sexo"));
                empleado.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                empleado.setCurp(rs.getString("curp"));
                empleado.setEstadoCivil(rs.getString("estadoCivil"));
                empleado.setFechaContratacion(rs.getDate("fechaContratacion"));
                empleado.setSalarioDiario(rs.getFloat("salarioDiario"));
                empleado.setNss(rs.getString("nss"));
                empleado.setDiasVacaciones(rs.getInt("diasVacaciones"));
                empleado.setDiasPermiso(rs.getInt("diasPermiso"));
                empleado.setFotografia(rs.getBinaryStream("fotografia"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setColonia(rs.getString("colonia"));
                empleado.setCodigoPostal(rs.getString("codigoPostal"));
                empleado.setEscolaridad(rs.getString("escolaridad"));
                empleado.setEspecialidad(rs.getString("especialidad"));
                empleado.setEmail(rs.getString("email"));
                empleado.setPassword(rs.getString("password"));
                empleado.setTipo(rs.getString("tipo"));
                empleado.setEstatus(rs.getString("estatus"));
                empleado.setDepartamento(new RH_Departamento(rs.getInt("idDepartamento"), this.conexion));
                empleado.setPuesto(new RH_Puesto(rs.getInt("idPuesto"), this.conexion));
                empleado.setCiudad(new RH_Ciudad(rs.getInt("idCiudad"), this.conexion));
                empleado.setSucursal(new Compras_Sucursal(rs.getInt("idSucursal"), this.conexion));
                empleado.setTurno(new RH_Turno(rs.getInt("idTurno"), this.conexion));
            }
            rs.close();
            st.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error:" + err.getMessage());
        }
        return empleado;
    }

    public boolean actualizarEmpleado(RH_Empleado empleado) {
        String sql = "update RH.Empleados set nombre=?, apellidoPaterno=?,apellidoMaterno=?, "
                + "sexo=?, fechaNacimiento=?, curp=?, estadoCivil=?, fechaContratacion=?, "
                + "salarioDiario=?, nss=?, diasVacaciones=?, diasPermiso=?, fotografia=?, "
                + "direccion=?, colonia=?, codigoPostal=?, escolaridad=?, especialidad=?, "
                + "email=?, password=?, tipo=?, idDepartamento=?, idPuesto=?,idCiudad=?,idSucursal=?, "
                + "idTurno=?, curp=?"
                + " where idEmpleado=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setString(1, empleado.getNombre());
            st.setString(2, empleado.getApellidoPaterno());
            st.setString(3, empleado.getApellidoMaterno());
            st.setString(4, empleado.getSexo());
            st.setDate(5, empleado.getFechaNacimiento());
            st.setString(6, empleado.getEstadoCivil());
            st.setDate(7, empleado.getFechaContratacion());
            st.setFloat(8, empleado.getSalarioDiario());
            st.setString(9, empleado.getNss());
            st.setInt(10, empleado.getDiasVacaciones());
            st.setInt(11, empleado.getDiasPermiso());
            st.setBinaryStream(12, empleado.getFotografia());
            st.setString(13, empleado.getDireccion());
            st.setString(14, empleado.getColonia());
            st.setString(15, empleado.getCodigoPostal());
            st.setString(16, empleado.getEscolaridad());
            st.setString(17, empleado.getEspecialidad());
            st.setString(18, empleado.getEmail());
            st.setString(19, empleado.getPassword());
            st.setString(20, empleado.getTipo());
            st.setString(21, empleado.getEstatus());
            st.setInt(22, empleado.getDepartamento().getIdDepartamento());
            st.setInt(23, empleado.getPuesto().getIdPuesto());
            st.setInt(24, empleado.getCiudad().getIdCiudad());
            st.setInt(25, empleado.getSucursal().getIdSucursal());
            st.setInt(26, empleado.getTurno().getIdTurno());
            st.setString(27, empleado.getCurp());
            st.setInt(28, empleado.getIdEmpleado());
            st.execute();
            st.close();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean eliminacionLogica(RH_Empleado em) {
        String sql = "update RH.Empleados set estatus=? "
                + " where idEmpleado=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, em.getIdEmpleado());
            st.setString(1, "I");
            st.execute();
            st.close();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean desactivarEmpleado(RH_Empleado em) {
        String sql = "update RH.Empleado set estatus=? "
                + " where idEmpleado=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, em.getIdEmpleado());
            st.setString(1, "D");
            st.execute();
            st.close();
            ban = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando:" + e.getMessage());
        }
        return ban;
    }

    public boolean reactivarEmpleado(RH_Empleado em) {
        String sql = "update RH.Empleado set estatus=? "
                + " where idEmpleado=?";
        boolean ban = false;
        try {
            PreparedStatement st = this.conexion.getConexion().prepareStatement(sql);
            st.setInt(2, em.getIdEmpleado());
            st.setString(1, "A");
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
