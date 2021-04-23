/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.CiudadDAO;
import conexion.ConexionBD;

/**
 *
 * @author Marco Chavez
 */
public class RH_Ciudad {

    private Integer idCiudad;
    private String nombre;
    private RH_Estado estado;
    private String estatus;

    public RH_Estado getEstado() {
        return estado;
    }

    public RH_Ciudad(Integer idCiudad, ConexionBD conexion) {
        CiudadDAO dao = new CiudadDAO(conexion);
        RH_Ciudad ciudad = dao.consultarCiudadId(idCiudad);
        recuperaDatos(ciudad);
    }

    public void recuperaDatos(RH_Ciudad ciudad) {
        this.idCiudad = ciudad.idCiudad;
        this.nombre = ciudad.nombre;
        this.estado = ciudad.getEstado();
        this.estatus = ciudad.getEstatus();
    }

    public void setEstado(RH_Estado estado) {
        this.estado = estado;
    }

    public RH_Ciudad() {
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

}
