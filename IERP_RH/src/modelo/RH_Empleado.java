/**
 *
 * @Autor  Marco Alberto Chávez Fernández
 * @Correo: mchavez297@accitesz.com
 * @Docente: MIS Roberto Suárez Zinzún
 * @Asignatura: Infraestructura de un ERP
 * @Escuela: Instituto Tecnologico de Estudios Superiores de Zamora
 * @Semestre : 8
 * @Grupo: B
 * @Carrera: Ing. en Sistemas Computacionales
 *
 * La clase RH_Empleado pertenece al paquete de Modelos tiene el proposito de
 * modelar la estructura de la tabla de la tabla Empleados del esquema RH
 * @since VER1.0
 */
package modelo;

import conexion.ConexionBD;
import conexion.EmpleadoDAO;
import java.io.InputStream;
import java.sql.Date;

public class RH_Empleado {

    private Integer idEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private java.sql.Date fechaNacimiento;
    private String curp;
    private String estadoCivil;
    private java.sql.Date fechaContratacion;
    private float salarioDiario;
    private String nss;
    private int diasVacaciones;
    private int diasPermiso;
    private InputStream fotografia;
    private String direccion;
    private String colonia;
    private String codigoPostal;
    private String escolaridad;
    private String especialidad;
    private String email;
    private String password;
    private String tipo;
    private String estatus;
    private RH_Departamento departamento;
    private RH_Puesto puesto;
    private RH_Ciudad ciudad;
    private Compras_Sucursal sucursal;
    private RH_Turno turno;

    public RH_Empleado() {
    }

    public RH_Empleado(Integer idEmpleado, ConexionBD conexion) {
        EmpleadoDAO dao = new EmpleadoDAO(conexion);
        RH_Empleado e = dao.consultaEmpleadoId(idEmpleado);
        this.idEmpleado=e.getIdEmpleado();
        this.nombre=e.getNombre();
        this.apellidoPaterno=e.getApellidoPaterno();
        this.apellidoMaterno=e.getApellidoMaterno();
        this.sexo=e.getSexo();
        this.fechaNacimiento=e.getFechaNacimiento();
        this.curp=e.getCurp();
        this.estadoCivil=e.getEstadoCivil();
        this.fechaContratacion=e.getFechaContratacion();
        this.salarioDiario=e.getSalarioDiario();
        this.nss=e.getNss();
        this.diasVacaciones=e.getDiasVacaciones();
        this.diasPermiso=e.getDiasPermiso();
        this.fotografia=e.getFotografia();
        this.direccion=e.getDireccion();
        this.codigoPostal=e.getCodigoPostal();
        this.escolaridad=e.getEscolaridad();
        this.especialidad=e.getEspecialidad();
        this.email=e.getEmail();
        this.password=e.getPassword();
        this.tipo=e.getPassword();
        this.estatus=e.getEstatus();
        this.departamento=e.getDepartamento();
        this.puesto=e.getPuesto();
        this.ciudad=e.getCiudad();
        this.sucursal=e.getSucursal();
        this.turno=e.getTurno();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public float getSalarioDiario() {
        return salarioDiario;
    }

    public void setSalarioDiario(float salarioDiario) {
        this.salarioDiario = salarioDiario;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

    public int getDiasPermiso() {
        return diasPermiso;
    }

    public void setDiasPermiso(int diasPermiso) {
        this.diasPermiso = diasPermiso;
    }

    public InputStream getFotografia() {
        return fotografia;
    }

    public void setFotografia(InputStream fotografia) {
        this.fotografia = fotografia;
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

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public RH_Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(RH_Departamento departamento) {
        this.departamento = departamento;
    }

    public RH_Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(RH_Puesto puesto) {
        this.puesto = puesto;
    }

    public RH_Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(RH_Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Compras_Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Compras_Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public RH_Turno getTurno() {
        return turno;
    }

    public void setTurno(RH_Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "RH_Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", curp=" + curp + ", estadoCivil=" + estadoCivil + ", fechaContratacion=" + fechaContratacion + ", salarioDiario=" + salarioDiario + ", nss=" + nss + ", diasVacaciones=" + diasVacaciones + ", diasPermiso=" + diasPermiso + ", fotografia=" + fotografia + ", direccion=" + direccion + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", escolaridad=" + escolaridad + ", especialidad=" + especialidad + ", email=" + email + ", password=" + password + ", tipo=" + tipo + ", estatus=" + estatus + ", departamento=" + departamento + ", puesto=" + puesto + ", ciudad=" + ciudad + ", sucursal=" + sucursal + ", turno=" + turno + '}';
    }

}
