/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.NominaDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Marco Chavez
 */
public class RH_Nomina {

    private Integer idNomina;
    private java.sql.Date fechaElaboracion;
    private java.sql.Date fechaPago;
    private Float subtotal;
    private Float retenciones;
    private Float total;
    private Integer diasTrabajados;
    private String Estatus;
    private RH_Empleado empleado;
    private RH_FormaPago formaPago;
    private RH_Periodo periodo;

    public RH_Nomina() {
    }

    public void recuperaNomina(ConexionBD conexion) {
        NominaDAO dao = new NominaDAO(conexion);
        RH_Nomina nomina = new RH_Nomina();
        nomina = dao.consultaNominaId(this.idNomina);
        this.fechaElaboracion = nomina.getFechaElaboracion();
        this.fechaPago = nomina.getFechaPago();
        this.subtotal = nomina.getSubtotal();
        this.retenciones = nomina.getRetenciones();
        this.total = nomina.getTotal();
        this.diasTrabajados = nomina.getDiasTrabajados();
        this.Estatus = nomina.getEstatus();
        this.empleado = nomina.getEmpleado();
        this.formaPago = nomina.getFormaPago();
        this.periodo = nomina.getPeriodo();

    }

    public Integer getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Integer idNomina) {
        this.idNomina = idNomina;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(Float retenciones) {
        this.retenciones = retenciones;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(Integer diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    public RH_Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(RH_Empleado empleado) {
        this.empleado = empleado;
    }

    public RH_FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(RH_FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public RH_Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(RH_Periodo periodo) {
        this.periodo = periodo;
    }

    public void calculaNomina(ArrayList<RH_Percepcion> percepciones, ArrayList<RH_Deduccion> deducciones) {
        this.subtotal = 0.f;
        this.subtotal += this.empleado.getSalarioDiario() * this.getDiasTrabajados();

        percepciones.forEach((p) -> {
            this.subtotal += p.getDiasPagar() * this.empleado.getSalarioDiario();
        });

        this.retenciones = 0.0f;
        deducciones.forEach((d) -> {
            this.retenciones +=d.getPorcentaje();
        });

        this.retenciones /= 100;
        this.retenciones *= this.subtotal;
        this.total = this.subtotal - this.retenciones;
    }

}
