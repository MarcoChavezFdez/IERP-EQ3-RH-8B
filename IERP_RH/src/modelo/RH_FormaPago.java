/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.FormaPagoDAO;


/**
 *
 * @author Marco Chavez
 */
public class RH_FormaPago {
    private Integer idFormaPago;
    private String nombre;
    private String estatus;

    public RH_FormaPago() {
    }
        public RH_FormaPago(Integer idFormaPago, ConexionBD conexion) {
        FormaPagoDAO dao = new FormaPagoDAO(conexion);
        RH_FormaPago formaPago = dao.consultaFormaPagoId(idFormaPago);
        this.idFormaPago = formaPago.getIdFormaPago();
        this.nombre = formaPago.getNombre();
        this.estatus = formaPago.getEstatus();
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
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
