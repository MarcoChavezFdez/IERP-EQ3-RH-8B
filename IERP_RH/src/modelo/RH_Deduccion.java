package modelo;

import conexion.ConexionBD;
import conexion.DeduccionDAO;

/**
 *
 * @author Carlos Esparza
 */
public class RH_Deduccion {

    private Integer idDeduccion;
    private String nombre;
    private String descripcion;
    private float porcentaje;
    private String estatus;

    public RH_Deduccion() {
    }

    public RH_Deduccion(Integer idDeduccion, ConexionBD conexion) {
        DeduccionDAO dao = new DeduccionDAO(conexion);
        RH_Deduccion deduccion = dao.consultaDeduccionId(idDeduccion);
        this.idDeduccion = deduccion.getIdDeduccion();
        this.nombre = deduccion.getNombre();
        this.descripcion = deduccion.getDescripcion();
        this.porcentaje = deduccion.getPorcentaje();
        this.estatus = deduccion.getEstatus();

    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getIdDeduccion() {
        return idDeduccion;
    }

    public void setIdDeduccion(Integer idDeduccion) {
        this.idDeduccion = idDeduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

}
