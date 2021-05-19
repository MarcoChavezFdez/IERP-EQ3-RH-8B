/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.PercepcionDAO;

/**
 *
 * @author Marco Chavez
 */
public class RH_Percepcion {
    private Integer idPercepcion;
    private String nombre;
    private String descripcion;
    private Integer diasPagar;
    private String estatus;


    public RH_Percepcion(){
        
    }
    
    public RH_Percepcion(int idPercepcion,ConexionBD conexion){
        PercepcionDAO dao = new PercepcionDAO(conexion);
        RH_Percepcion p = dao.consultaPercepcionId(idPercepcion);
        this.idPercepcion = p.getIdPercepcion();
        nombre = p.getDescripcion();
        descripcion = p.getDescripcion();
        diasPagar = p.getDiasPagar();
        estatus = p.getEstatus();
    }
    
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    

    public Integer getIdPercepcion() {
        return idPercepcion;
    }

    public void setIdPercepcion(Integer idPercepcion) {
        this.idPercepcion = idPercepcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDiasPagar() {
        return diasPagar;
    }

    public void setDiasPagar(Integer diasPagar) {
        this.diasPagar = diasPagar;
    }
    
    
}
