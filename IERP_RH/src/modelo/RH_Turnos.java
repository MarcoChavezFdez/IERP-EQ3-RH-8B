/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author selen
 */
public class RH_Turnos {
    private Integer idTurno;
    private String nombre;
    private Integer   horaInicio;
    private Integer  horaFin;
    private  String dias;
    
    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno (Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio( Integer  horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer  getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Integer horaFin) {
        this.horaFin =  horaFin ;
    }
    
    public  String getDias (){
        return dias;
    }
    public  void setDias (String dias){
        this.dias= dias;
    }
}
 
    
    
