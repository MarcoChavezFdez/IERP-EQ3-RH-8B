/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.PeriodoDAO;
import java.sql.Date;

/**
 *
 * @author Marco Chavez
 */
public class RH_Periodo {

    private Integer idPeriodo;
    private String nombre;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;
    private String estatus;

    public RH_Periodo() {
    }

    public RH_Periodo(Integer idPeriodo, ConexionBD conexion) {
        PeriodoDAO dao = new PeriodoDAO(conexion);
        RH_Periodo p = new RH_Periodo();
        p = dao.consultaPeriodoId(idPeriodo);
        this.idPeriodo = p.getIdPeriodo();
        this.nombre = p.getNombre();
        this.fechaInicio = p.getFechaInicio();
        this.fechaFin = p.getFechaFin();
        this.estatus = p.getEstatus();
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

}
