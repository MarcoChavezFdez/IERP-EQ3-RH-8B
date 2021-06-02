/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;
import java.sql.Date;

/**
 *
 * @author Marco Chavez
 */
public class RH_AusenciaJustificada {

    private Integer idAusencia;
    private java.sql.Date fechaSolicitud;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;
    private String tipo;
    private RH_Empleado empleadoSolicitador;
    private RH_Empleado empleadoAutorizador;
    private byte[] evidencia;
    private String estatus;
    private String motivo;

    public RH_AusenciaJustificada() {
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getIdAusencia() {
        return idAusencia;
    }

    public void setIdAusencia(Integer idAusencia) {
        this.idAusencia = idAusencia;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public RH_Empleado getEmpleadoSolicitador() {
        return empleadoSolicitador;
    }

    public void setEmpleadoSolicitador(RH_Empleado empleadoSolicitador) {
        this.empleadoSolicitador = empleadoSolicitador;
    }

    public RH_Empleado getEmpleadoAutorizador() {
        return empleadoAutorizador;
    }

    public void setEmpleadoAutorizador(RH_Empleado empleadoAutorizador) {
        this.empleadoAutorizador = empleadoAutorizador;
    }

    public byte[] getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(byte[] evidencia) {
        this.evidencia = evidencia;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
