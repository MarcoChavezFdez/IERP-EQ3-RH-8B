SELECT DocEmpleado.idDocumento,DocEmpleado.nombreDocumento,DocEmpleado.fechaEntrega,CONCAT(Em.nombre,' ',Em.apellidoPaterno,' ',Em.apellidoMaterno)as NombreEmpleado FROM 
RH.DocumentacionEmpleado DocEmpleado
join RH.Empleados Em on
Em.idEmpleado=DocEmpleado.idEmpleado
where Em.estatus='A' and DocEmpleado.estatus='A'