/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.SucursalesDAO;

/**
 *
 * @author Marco Chavez
 */
public class Compras_Sucursal {
    private Integer idSucursal;
    private String nombre;
    private String telefono;
    private String direccion;
    private String colonia;
    private String codigoPostal;
    private Float presupuesto;
    private String estatus;
    private RH_Ciudad ciudad;

    public Compras_Sucursal() {
    }
    
    public Compras_Sucursal(Integer idSucursal,ConexionBD conexion){
        SucursalesDAO dao = new SucursalesDAO(conexion);
        Compras_Sucursal s = dao.consultaSucursalId(idSucursal);
        this.idSucursal=idSucursal;
        this.nombre=s.getNombre();
        this.telefono=s.getTelefono();
        this.direccion=s.getDireccion();
        this.colonia=s.getColonia();
        this.codigoPostal=s.getCodigoPostal();
        this.presupuesto=s.getPresupuesto();
        this.estatus=s.getEstatus();
        this.ciudad=s.getCiudad();
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public RH_Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(RH_Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
}
