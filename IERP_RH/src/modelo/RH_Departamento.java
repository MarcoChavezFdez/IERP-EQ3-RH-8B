/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.DepartamentoDAO;

/**
 *
 * @author Marco Chavez
 */
public class RH_Departamento {
    private Integer idDepartamento;
    private String nombre;
    private String estatus;

    public RH_Departamento(Integer idDepartamento,ConexionBD conexion) {
        DepartamentoDAO dao = new DepartamentoDAO(conexion);
        RH_Departamento depa = dao.consultaDepartamentoId(idDepartamento);
        this.idDepartamento=depa.getIdDepartamento();
        this.nombre=depa.getNombre();
        this.estatus=depa.getEstatus();
        
    }

    public RH_Departamento() {
    }
   
    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
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
