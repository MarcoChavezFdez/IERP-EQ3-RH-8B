USE [ERP]
GO
SET IDENTITY_INSERT [RH].[Estados] ON 

INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (1, N'AGUASCALIENTES', N'AGS.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (2, N'BAJA CALIFORNIA', N'BCN.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (3, N'BAJA CALIFORNIA SUR', N'BCS.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (4, N'CAMPECHE', N'CAMP.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (5, N'CHIAPAS', N'CHIS.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (6, N'CHIHUAHUA', N'CHIH.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (7, N'COAHUILA', N'COAH.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (8, N'COLIMA', N'COL.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (9, N'DISTRITO FEDERAL', N'D.F.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (10, N'DURANGO', N'DGO.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (11, N'GUANAJUATO', N'GTO.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (12, N'GUERRERO', N'GRO.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (13, N'HIDALGO', N'HGO.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (14, N'JALISCO', N'JAL.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (15, N'MÉXICO', N'EDO. MEX.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (16, N'MICHOACÁN', N'MICH.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (17, N'MORELOS', N'MOR.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (18, N'NAYARIT', N'NAY.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (19, N'NUEVO LEÓN', N'MTY.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (20, N'OAXACA', N'OAX.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (21, N'PUEBLA', N'PUE.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (22, N'QUINTANA ROO', N'ROO.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (23, N'SAN LUIS POTOSÍ', N'SLP.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (24, N'SINALOA', N'SIN.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (25, N'SONORA', N'SON.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (26, N'TABASCO', N'TAB.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (27, N'TAMAULIPAS', N'TAM.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (28, N'TLAXCALA', N'TLX.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (29, N'VERACRUZ', N'VER.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (30, N'YUCATÁN', N'YUC.', N'A         ')
INSERT [RH].[Estados] ([idEstado], [nombre], [siglas], [estatus]) VALUES (31, N'ZACATECAS', N'ZAC.', N'A         ')
SET IDENTITY_INSERT [RH].[Estados] OFF
GO
SET IDENTITY_INSERT [RH].[Ciudades] ON 

INSERT [RH].[Ciudades] ([idCiudad], [nombre], [idEstado], [estatus]) VALUES (1, N'ECUANDUREO', 16, N'A')
INSERT [RH].[Ciudades] ([idCiudad], [nombre], [idEstado], [estatus]) VALUES (2, N'MORELIA', 16, N'A')
INSERT [RH].[Ciudades] ([idCiudad], [nombre], [idEstado], [estatus]) VALUES (3, N'PURÉPERO', 16, N'A')
INSERT [RH].[Ciudades] ([idCiudad], [nombre], [idEstado], [estatus]) VALUES (4, N'TANGANCÍCUARO', 16, N'A')
INSERT [RH].[Ciudades] ([idCiudad], [nombre], [idEstado], [estatus]) VALUES (5, N'URUAPAN', 16, N'A')
INSERT [RH].[Ciudades] ([idCiudad], [nombre], [idEstado], [estatus]) VALUES (6, N'ZACAPU', 16, N'A')
INSERT [RH].[Ciudades] ([idCiudad], [nombre], [idEstado], [estatus]) VALUES (7, N'ZAMORA', 16, N'A')
SET IDENTITY_INSERT [RH].[Ciudades] OFF
GO
SET IDENTITY_INSERT [RH].[Turnos] ON 

INSERT [RH].[Turnos] ([idTurno], [nombre], [horaInicio], [horaFin], [dias], [estatus]) VALUES (1, N'MATUTINO ', CAST(N'07:00:00' AS Time), CAST(N'15:00:00' AS Time), N'LUNES,MARTES,MIÉRCOLES,JUEVES,VIERNES', N'A')
INSERT [RH].[Turnos] ([idTurno], [nombre], [horaInicio], [horaFin], [dias], [estatus]) VALUES (2, N'VESPERTINO', CAST(N'15:00:00' AS Time), CAST(N'23:00:00' AS Time), N'LUNES,MARTES,MIÉRCOLES,JUEVES,VIERNES,SÁBADO', N'A')
SET IDENTITY_INSERT [RH].[Turnos] OFF
GO
SET IDENTITY_INSERT [RH].[Departamentos] ON 

INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (1, N'FINANZAS', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (2, N'RECURSOS HUMANOS', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (3, N'MARKETING', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (4, N'COMERCIAL', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (5, N'COMPRAS', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (6, N'LOGÍSTICA Y OPERACIONES', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (7, N'CONTROL DE GESTIÓN', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (8, N'DIRECCION GENERAL', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (9, N'I+D', N'A')
INSERT [RH].[Departamentos] ([idDepartamento], [nombre], [estatus]) VALUES (10, N'SISTEMAS', N'A')
SET IDENTITY_INSERT [RH].[Departamentos] OFF
GO
SET IDENTITY_INSERT [RH].[Puestos] ON 

INSERT [RH].[Puestos] ([idPuesto], [nombre], [salarioMinimo], [salarioMaximo], [estatus]) VALUES (1, N'GERENTE', CAST(200.0000 AS Decimal(18, 4)), CAST(1000.1300 AS Decimal(18, 4)), N'A')
SET IDENTITY_INSERT [RH].[Puestos] OFF
GO
SET IDENTITY_INSERT [Compras].[Sucursales] ON 

INSERT [Compras].[Sucursales] ([idSucursal], [nombre], [telefono], [direccion], [colonia], [codigoPostal], [presupuesto], [estatus], [idCiudad]) VALUES (1, N'MATRIZ ZAMORA', N'351-123-4567', N'5 DE MAYO #222', N'CENTRO', N'59600', CAST(200000.0000 AS Decimal(18, 4)), N'A', 7)
INSERT [Compras].[Sucursales] ([idSucursal], [nombre], [telefono], [direccion], [colonia], [codigoPostal], [presupuesto], [estatus], [idCiudad]) VALUES (2, N'SUCURSAL NORTE', N'351-321-7897', N'AVILA CAMACHO #78', N'JARDINES DE CATEDRAL', N'59600', CAST(200000.0000 AS Decimal(18, 4)), N'A', 7)
INSERT [Compras].[Sucursales] ([idSucursal], [nombre], [telefono], [direccion], [colonia], [codigoPostal], [presupuesto], [estatus], [idCiudad]) VALUES (3, N'SUCURSAL SUR', N'351-478-5896', N'AVENIDA DEL SOL #235', N'LA PRADERA', N'59600', CAST(200000.0000 AS Decimal(18, 4)), N'A', 7)
INSERT [Compras].[Sucursales] ([idSucursal], [nombre], [telefono], [direccion], [colonia], [codigoPostal], [presupuesto], [estatus], [idCiudad]) VALUES (4, N'SUCURSAL CENTRO', N'351-188-5892', N'AQUILES SERDAN #25', N'CENTRO', N'59600', CAST(200000.0000 AS Decimal(18, 4)), N'A', 7)
INSERT [Compras].[Sucursales] ([idSucursal], [nombre], [telefono], [direccion], [colonia], [codigoPostal], [presupuesto], [estatus], [idCiudad]) VALUES (5, N'SUCURSAL MATRIZ ZACAPU', N'351-108-2886', N'AV SIEMPRE VIVA #205', N'CENTRO', N'58700', CAST(400000.0000 AS Decimal(18, 4)), N'A', 6)
SET IDENTITY_INSERT [Compras].[Sucursales] OFF
GO
SET IDENTITY_INSERT [RH].[Empleados] ON 

INSERT [RH].[Empleados] ([idEmpleado], [nombre], [apellidoPaterno], [apellidoMaterno], [sexo], [fechaNacimiento], [curp], [estadoCivil], [fechaContratacion], [salarioDiario], [nss], [diasVacaciones], [diasPermiso], [fotografia], [direccion], [colonia], [codigoPostal], [escolaridad], [especialidad], [email], [password], [tipo], [estatus], [idDepartamento], [idPuesto], [idCiudad], [idSucursal], [idTurno]) VALUES (1, N'MARCO ALBERTO', N'CHÁVEZ', N'FERNÁNDEZ', N'MASCULINO', CAST(N'1999-07-30' AS Date), N'CAFM990730HMNHRR05', N'SOLTERO', CAST(N'2021-05-09' AS Date), CAST(500.0000 AS Decimal(18, 4)), N'11111111111', 10, 10, 0x, N'EXTREMADURA PONIENTE #55', N'MONTE OLIVO', N'59667', N'LICENCIATURA', N'PROGRAMACIÓN', N'MCHAVEZ297@ACCITESZ.COM', N'HOLA.123', N'EMPLEADO', N'A', 10, 1, 6, 5, 1)
INSERT [RH].[Empleados] ([idEmpleado], [nombre], [apellidoPaterno], [apellidoMaterno], [sexo], [fechaNacimiento], [curp], [estadoCivil], [fechaContratacion], [salarioDiario], [nss], [diasVacaciones], [diasPermiso], [fotografia], [direccion], [colonia], [codigoPostal], [escolaridad], [especialidad], [email], [password], [tipo], [estatus], [idDepartamento], [idPuesto], [idCiudad], [idSucursal], [idTurno]) VALUES (2, N'JOSE CARLOS ', N'ESPARZA', N'DE ANDA', N'MASCULINO', CAST(N'1999-11-08' AS Date), N'CAFM990730HMNRRR00', N'SOLTERO', CAST(N'2021-05-12' AS Date), CAST(100.0000 AS Decimal(18, 4)), N'11111111111', 6, 6, 0x9D6834360000000049454E44AE426082, N'EE', N'E', N'59667', N'LICENCIATURA', N'PROCRASTINAR', N'jesparza@compucloud.com.mx', N'HOLA.123', N'ADMINISTRADOR', N'A', 1, 1, 6, 5, 1)
SET IDENTITY_INSERT [RH].[Empleados] OFF
GO
SET IDENTITY_INSERT [RH].[FormasPago] ON 

INSERT [RH].[FormasPago] ([idFormaPago], [nombre], [estatus]) VALUES (1, N'EFECTIVO', N'A')
INSERT [RH].[FormasPago] ([idFormaPago], [nombre], [estatus]) VALUES (2, N'TRANSFERENCIA ELECTRONICA', N'A')
INSERT [RH].[FormasPago] ([idFormaPago], [nombre], [estatus]) VALUES (3, N'CHEQUE', N'A')
SET IDENTITY_INSERT [RH].[FormasPago] OFF
GO
SET IDENTITY_INSERT [RH].[Deducciones] ON 

INSERT [RH].[Deducciones] ([idDeduccion], [nombre], [descripcion], [porcentaje], [estatus]) VALUES (1, N'SEGURO SOCIAL', N'DEDUCCIÓN DEL SEGURO SOCIAL', CAST(5.0000 AS Decimal(18, 4)), N'A')
INSERT [RH].[Deducciones] ([idDeduccion], [nombre], [descripcion], [porcentaje], [estatus]) VALUES (4, N'ISR 1.9', N'DEDUCCIÓN DEL IMPUESTO SOBRE LA RENTA', CAST(1.9000 AS Decimal(18, 4)), N'A')
INSERT [RH].[Deducciones] ([idDeduccion], [nombre], [descripcion], [porcentaje], [estatus]) VALUES (6, N'ISR 8', N'DEDUCCIÓN DEL IMPUESTO SOBRE LA RENTA DEL 8%', CAST(8.0000 AS Decimal(18, 4)), N'I')
SET IDENTITY_INSERT [RH].[Deducciones] OFF
GO
SET IDENTITY_INSERT [RH].[Periodos] ON 

INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (2, N'Primera Quincena Mayo', CAST(N'2021-05-01' AS Date), CAST(N'2021-05-14' AS Date), N'I')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (3, N'Segunfo', CAST(N'2021-05-01' AS Date), CAST(N'2021-05-01' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (4, N'TErcer', CAST(N'2021-05-03' AS Date), CAST(N'2021-05-03' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (5, N'Cuarto', CAST(N'2021-05-04' AS Date), CAST(N'2021-05-04' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (6, N'Quinto', CAST(N'2021-05-05' AS Date), CAST(N'2021-05-05' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (7, N'Sexto', CAST(N'2021-05-06' AS Date), CAST(N'2021-05-06' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (8, N'Septimo', CAST(N'2021-05-07' AS Date), CAST(N'2021-05-07' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (9, N'Octavo', CAST(N'2021-05-08' AS Date), CAST(N'2021-05-08' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (10, N'Noveno', CAST(N'2021-05-09' AS Date), CAST(N'2021-05-09' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (11, N'Decimo', CAST(N'2021-05-10' AS Date), CAST(N'2021-05-10' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (12, N'Noveno', CAST(N'2021-05-14' AS Date), CAST(N'2021-05-14' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (13, N'Decimo', CAST(N'2021-05-10' AS Date), CAST(N'2021-05-10' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (14, N'Onceavo', CAST(N'2021-05-11' AS Date), CAST(N'2021-05-11' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (15, N'Doceavo', CAST(N'2021-05-12' AS Date), CAST(N'2021-05-12' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (16, N'Treceavo', CAST(N'2021-05-13' AS Date), CAST(N'2021-05-13' AS Date), N'A')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (17, N'CuatroCeavo', CAST(N'2021-05-14' AS Date), CAST(N'2021-05-14' AS Date), N'I')
INSERT [RH].[Periodos] ([idPeriodo], [nombre], [fechaInicio], [fechaFin], [estatus]) VALUES (18, N'Primer Quincena Mayo 2021', CAST(N'2021-05-01' AS Date), CAST(N'2021-05-15' AS Date), N'A')
SET IDENTITY_INSERT [RH].[Periodos] OFF
GO
SET IDENTITY_INSERT [RH].[Nominas] ON 

INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (4, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 1, 18)
INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (5, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 1, 18)
INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (6, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 3, 18)
INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (7, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 1, 18)
INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (8, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 1, 18)
INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (9, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 1, 18)
INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (10, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 3, 18)
INSERT [RH].[Nominas] ([idNomina], [fechaElaboracion], [fechaPago], [subTotal], [retenciones], [total], [diasTrabajados], [estatus], [idEmpleado], [idFormaPago], [idPeriodo]) VALUES (11, CAST(N'2021-05-18' AS Date), CAST(N'2021-05-15' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, N'PENDIENTE', 1, 1, 18)
SET IDENTITY_INSERT [RH].[Nominas] OFF
GO
SET IDENTITY_INSERT [RH].[Percepciones] ON 

INSERT [RH].[Percepciones] ([idPercepcion], [nombre], [descripcion], [diasPagar], [estatus]) VALUES (1, N'BONO DE RENDIMIENTO', N'BONO DE RENDIMIENTO', 1, N'A')
SET IDENTITY_INSERT [RH].[Percepciones] OFF
GO
SET IDENTITY_INSERT [RH].[AusenciasJustificadas] ON 

INSERT [RH].[AusenciasJustificadas] ([idAusencia], [fechaSolicitud], [fechaInicio], [fechaFin], [tipo], [idEmpleadoSolicita], [idEmpleadoAutoriza], [evidencia], [estatus], [motivo]) VALUES (1, CAST(N'2021-05-16' AS Date), CAST(N'2021-05-16' AS Date), CAST(N'2021-05-16' AS Date), N'V', 1, 1, NULL, N'A', N'A')
SET IDENTITY_INSERT [RH].[AusenciasJustificadas] OFF
GO
SET IDENTITY_INSERT [RH].[Asistencias] ON 

INSERT [RH].[Asistencias] ([idAsistencia], [fecha], [horaEntrada], [horaSalida], [dia], [idEmpleado], [estatus]) VALUES (1, CAST(N'2021-05-10' AS Date), CAST(N'10:11:00' AS Time), CAST(N'23:00:00' AS Time), N'LUNES', 1, N'A')
INSERT [RH].[Asistencias] ([idAsistencia], [fecha], [horaEntrada], [horaSalida], [dia], [idEmpleado], [estatus]) VALUES (2, CAST(N'2021-05-11' AS Date), CAST(N'10:12:00' AS Time), CAST(N'23:00:00' AS Time), N'MARTES', 1, N'A')
INSERT [RH].[Asistencias] ([idAsistencia], [fecha], [horaEntrada], [horaSalida], [dia], [idEmpleado], [estatus]) VALUES (3, CAST(N'2021-05-12' AS Date), CAST(N'10:12:00' AS Time), CAST(N'23:00:00' AS Time), N'MIERCOLES', 1, N'A')
SET IDENTITY_INSERT [RH].[Asistencias] OFF
GO
SET IDENTITY_INSERT [RH].[Fotografias] ON 

INSERT [RH].[Fotografias] ([idFotografia], [fotografia]) VALUES (1, 0x)
INSERT [RH].[Fotografias] ([idFotografia], [fotografia]) VALUES (2, 0x)
INSERT [RH].[Fotografias] ([idFotografia], [fotografia]) VALUES (3, 0x9D6834360000000049454E44AE426082)
INSERT [RH].[Fotografias] ([idFotografia], [fotografia]) VALUES (4, 0x)
INSERT [RH].[Fotografias] ([idFotografia], [fotografia]) VALUES (1002, 0x)
INSERT [RH].[Fotografias] ([idFotografia], [fotografia]) VALUES (1003, 0x9D6834360000000049454E44AE426082)
SET IDENTITY_INSERT [RH].[Fotografias] OFF
GO
