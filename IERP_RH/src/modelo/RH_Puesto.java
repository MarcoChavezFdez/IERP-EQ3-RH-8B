/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.PuestoDAO;

/**
 *
 * @author Marco Chavez
 */
public class RH_Puesto {
    private Integer idPuesto;
    private String nombre;
    private Float salarioMinimo;
    private Float salarioMaximo;
    private String estatus;

    public RH_Puesto() {
    }
    public RH_Puesto(Integer idPuesto,ConexionBD conexion){
        PuestoDAO dao= new PuestoDAO(conexion);
        RH_Puesto p = dao.consultaPuestoId(idPuesto);
        this.idPuesto=p.getIdPuesto();
        this.nombre= p.getNombre();
        this.salarioMinimo = p.getSalarioMinimo();
        this.salarioMaximo = p.getSalarioMaximo();
        this.estatus = p.getEstatus();
    }
    
    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Float salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public Float getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Float salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
