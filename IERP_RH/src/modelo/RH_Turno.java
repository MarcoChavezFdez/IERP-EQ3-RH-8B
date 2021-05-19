/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import conexion.TurnosDAO;
import java.sql.Time;

/**
 *
 * @author selen
 */
public class RH_Turno {

    private Integer idTurno;
    private String nombre;
    private String dias;
    private java.sql.Time horaInicio;
    private java.sql.Time horaFin;
    private String estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public RH_Turno() {
    }

    public RH_Turno(Integer idTurno, ConexionBD conexion) {
        TurnosDAO dao = new TurnosDAO(conexion);
        RH_Turno turno = dao.consultarTurnoId(idTurno);
        this.idTurno = idTurno;
        this.nombre = turno.getNombre();
        this.horaInicio = turno.getHoraInicio();
        this.horaFin = turno.getHoraFin();
        this.estatus = turno.getEstatus();
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

}
