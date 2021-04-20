select E.idEmpleado,E.nombre,E.apellidoPaterno,E.apellidoMaterno,E.sexo,E.fechaNacimiento,E.curp,E.estadoCivil,E.fechaContratacion,E.salarioDiario,E.nss,E.diasVacaciones,E.diasPermiso,E.fotografia,E.direccion,E.colonia,E.codigoPostal,E.escolaridad,E.especialidad,E.email,E.password,E.tipo,E.estatus,D.nombre,P.nombre,C.nombre,S.nombre,T.nombre from RH.Empleados E 
join RH.Departamentos D on
E.idDepartamento=D.idDepartamento
join RH.Puestos P on
E.idPuesto=P.idPuesto
join RH.Ciudades  C on
C.idCiudad=E.idCiudad 
join Compras.Sucursales S
on S.idSucursal=E.idSucursal
join RH.Turnos T 
on T.idTurno=E.idTurno
