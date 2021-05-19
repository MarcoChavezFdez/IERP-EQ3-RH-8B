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
public class RH_NominaPercepcion {
    private RH_Nomina nomina;
    private RH_Percepcion percepcion;
    private Float importe;
    private String estatus;

    public RH_NominaPercepcion() {
    }

    public RH_Nomina getNomina() {
        return nomina;
    }

    public void setNomina(RH_Nomina nomina) {
        this.nomina = nomina;
    }

    public RH_Percepcion getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(RH_Percepcion percepcion) {
        this.percepcion = percepcion;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void calculaImporte() {
        this.importe = this.getNomina().getEmpleado().getSalarioDiario()* this.getPercepcion().getDiasPagar();
    }
    
}
