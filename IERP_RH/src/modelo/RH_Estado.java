/**
 *
 * @Autor  Marco Alberto Chávez Fernández
 * @Correo: mchavez297@accitesz.com
 *
 * @Docente: MIS Roberto Suárez Zinzún
 * @Asignatura: Infraestructura de un ERP
 * @Escuela: Instituto Tecnologico de Estudios Superiores de Zamora
 * @Semestre : 8
 * @Grupo: B
 * @Carrera: Ing. en Sistemas Computacionales
 *
 * La clase RH_Estados pertenece al paquete de Modelos tiene el proposito de
 * modelar la estructura de la tabla de Estados del Esquema RH asi como los
 * metodos necesarios para el manejo de datos que se intercambien entre las
 * distintas clases
 * @since VER1.0
 */
package modelo;

import conexion.ConexionBD;
import conexion.EstadoDAO;

public class RH_Estado {

    /*
     */
    private Integer idEstado;
    private String nombre;
    private String siglas;
    private String estatus;

    public RH_Estado(Integer idEstado, ConexionBD conexion) {
        EstadoDAO dao = new EstadoDAO(conexion);
        RH_Estado estado = dao.consultaEstadoId(idEstado);
        this.idEstado = estado.idEstado;
        this.nombre = estado.nombre;
        this.siglas = estado.getSiglas();
    }

    public RH_Estado() {

    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "RH_Estado{" + "idEstado=" + idEstado + ", nombre=" + nombre + ", siglas=" + siglas + ", estatus=" + estatus + '}';
    }
    
}
