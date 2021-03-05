package conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RH_Ciudades;

public class EstadoDAO {

    private ConexionBD conexion;

    public CiudadesDAO(ConexionBD conexion) {
        this.conexion = conexion;

    }
  
  public void consultaTodo(JTable tbl) 
    {
        String sql = "SELECT * FROM Ciudades;";
        try 
        {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            mtd = rs.getMetaData();
            ArrayList<Object[]> datos = new ArrayList<>();
            while(rs.next())
            {
                Object[] fila = new Object[mtd.getColumnCount()];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                datos.add(fila);
            }
            dtm = (DefaultTableModel)tbl.getModel();
            for (int i = 0; i < datos.size(); i++) 
            {
                dtm.addRow(datos.get(i));                
            }
            ps.close();
        }
        catch (SQLException e ) 
        {
            JOptionPane.showMessageDialog(null,"Error al realizar la consulta: " + e.getMessage());
            
        }
    }
    
    
    public void eliminarDatos(int idCiudad)
    {
        String sql = "delete from Ciudades Where idCiudad = ?";
        try 
        {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCiudad);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Se Ejecutó Exitosamente El Delete Del Producto Con Clave: "+idCiudad);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean update(RH_Ciudades o)
    {
        String sql = "UPDATE Ciudades SET  idEstado = ?, nombre = ?,  estatus = ? Where idCiudad = ?";
        try 
        {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, o.getIdEstado());
            ps.setString(2, o.getNombre());
            ps.setString(3, o.getEstatus());
            ps.setInt(4, o.getIdCiudad());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se Actualizó Exitosamente El Producto con clave: "+o.getIdCiudad());
            ps.close();
            return true;
        }
        catch (SQLException ex) 
        {
                JOptionPane.showMessageDialog(null, "No Se Actualizaron los datos por: "+ex.getMessage() );
                return false;
        }     
    }
  
   public ConexionBD getConexion() {
        return conexion;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }

}
