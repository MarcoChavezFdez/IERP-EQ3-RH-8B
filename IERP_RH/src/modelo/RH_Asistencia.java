/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import java.sql.Date;
import java.sql.Time;
import conexion.AsistenciaDAO;

/**
 *
 * @author Marco Chavez
 */
public class RH_Asistencia {
    
    private Integer idAsistencia;
    private java.sql.Date fecha;
    private java.sql.Time horaEntrada;
    private java.sql.Time horaSalida;
    private String dia;
    private RH_Empleado empleado;
    private String estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public RH_Asistencia() {
    }
    
    public RH_Asistencia(Integer idAsistencia, ConexionBD conexion) {
        AsistenciaDAO dao = new AsistenciaDAO(conexion);
        RH_Asistencia asistencia = dao.consultaAsistenciaId(idAsistencia);
        this.idAsistencia = idAsistencia;
        this.dia = asistencia.getDia();
        this.fecha = asistencia.getFecha();
        this.empleado = asistencia.getEmpleado();
        this.horaEntrada = asistencia.getHoraEntrada();
        this.horaSalida = asistencia.getHoraSalida();
        this.estatus = asistencia.getEstatus();
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public RH_Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(RH_Empleado empleado) {
        this.empleado = empleado;
    }
    
}
