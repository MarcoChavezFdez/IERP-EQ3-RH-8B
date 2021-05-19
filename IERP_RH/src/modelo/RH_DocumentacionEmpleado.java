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
public class RH_DocumentacionEmpleado {

    private Integer idDocumento;
    private String nombreDocumento;
    private java.sql.Date fechaEntrega;
    private InputStream documento;
    private RH_Empleado empleado;
    private String estatus;

    public RH_DocumentacionEmpleado() {
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public InputStream getDocumento() {
        return documento;
    }

    public void setDocumento(InputStream documento) {
        this.documento = documento;
    }

    public RH_Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(RH_Empleado empleado) {
        this.empleado = empleado;
    }

    public void setEmpleado(Integer idEmpleado) {
        
    }

}
