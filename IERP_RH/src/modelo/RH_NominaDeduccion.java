/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marco Chavez
 */
public class RH_NominaDeduccion {
    private RH_Nomina nomina;
    private RH_Deduccion deduccion;
    private Float importe;
    private String estatus;

    public RH_NominaDeduccion() {
    }

    public RH_Nomina getNomina() {
        return nomina;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }
    
    public void setNomina(RH_Nomina nomina) {
        this.nomina = nomina;
    }

    public RH_Deduccion getDeduccion() {
        return deduccion;
    }

    public void setDeduccion(RH_Deduccion deduccion) {
        this.deduccion = deduccion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
