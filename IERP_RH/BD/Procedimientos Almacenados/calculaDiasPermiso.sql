-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Marco Alberto Chávez Fernández
-- Create date: 22/05/2020
-- Description:	Procedimiento almacenado para calcular los dias de permiso 
-- =============================================
CREATE PROCEDURE RH.calculaDiasPermiso 
	@fechaFin date,
	@idEmpleado int,
	@dias int out
AS
BEGIN
	SET NOCOUNT ON;
    -- Insert statements for procedure here
	DECLARE @fechaInicio date =DATEADD(YEAR, -1, @fechaFin);
	DECLARE @diasPermiso int;
	DECLARE @diasJustificados int=0;

	-- Consultamos los dias de permiso que cuanta el empleado dentro de 1 años
	SELECT @diasPermiso = diasPermiso from RH.Empleados 
		WHERE idEmpleado=@idEmpleado

	IF OBJECT_ID('ERP..#Asistencias') IS NOT NULL
		BEGIN
		DROP TABLE #Asistencias
		END
	SELECT idAusencia,fechaSolicitud,fechaInicio,fechaFin,tipo,estatus 
	INTO #Asistencias
	FROM RH.AusenciasJustificadas
		WHERE idEmpleadoSolicita = @idEmpleado
		AND fechaInicio >= @fechaInicio 
		AND fechaFin <= @fechaFin
		AND estatus='AUTORIZADO'
		AND tipo = 'PERMISO'
	WHILE 0<(SELECT COUNT(*) FROM #Asistencias)
	BEGIN
		DECLARE @idAusencia int;
		DECLARE @fechaInicial date;
		DECLARE @fechaFinal date;

		SELECT @idAusencia=MAX(idAusencia) from #Asistencias

		SELECT @fechaInicial=fechaInicio from #Asistencias
			WHERE idAusencia=@idAusencia

		SELECT @fechaFinal=fechaFin from #Asistencias
			WHERE idAusencia=@idAusencia

		SELECT @diasJustificados+=DATEDIFF ( DAY , @fechaInicial ,@fechaFinal ) +1

		DELETE FROM #Asistencias
			WHERE idAusencia=@idAusencia
	END
	set @dias=@diasJustificados
END
GO
