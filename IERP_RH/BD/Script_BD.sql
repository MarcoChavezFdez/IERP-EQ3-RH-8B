USE [master]
GO
/****** Object:  Database [ERP]    Script Date: 14/04/2021 11:06:15 p. m. ******/
CREATE DATABASE [ERP]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ERP', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\ERP.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ERP_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\ERP_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ERP] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ERP].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ERP] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ERP] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ERP] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ERP] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ERP] SET ARITHABORT OFF 
GO
ALTER DATABASE [ERP] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ERP] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ERP] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ERP] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ERP] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ERP] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ERP] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ERP] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ERP] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ERP] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ERP] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ERP] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ERP] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ERP] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ERP] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ERP] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ERP] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ERP] SET RECOVERY FULL 
GO
ALTER DATABASE [ERP] SET  MULTI_USER 
GO
ALTER DATABASE [ERP] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ERP] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ERP] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ERP] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ERP] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ERP] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ERP', N'ON'
GO
ALTER DATABASE [ERP] SET QUERY_STORE = OFF
GO
USE [ERP]
GO
/****** Object:  User [mchavez]    Script Date: 14/04/2021 11:06:15 p. m. ******/
CREATE USER [mchavez] FOR LOGIN [mchavez] WITH DEFAULT_SCHEMA=[Compras]
GO
/****** Object:  User [Admin]    Script Date: 14/04/2021 11:06:15 p. m. ******/
CREATE USER [Admin] FOR LOGIN [Admin] WITH DEFAULT_SCHEMA=[db_owner]
GO
/****** Object:  Schema [Compras]    Script Date: 14/04/2021 11:06:15 p. m. ******/
CREATE SCHEMA [Compras]
GO
/****** Object:  Schema [RH]    Script Date: 14/04/2021 11:06:15 p. m. ******/
CREATE SCHEMA [RH]
GO
/****** Object:  Schema [Sales]    Script Date: 14/04/2021 11:06:15 p. m. ******/
CREATE SCHEMA [Sales]
GO
/****** Object:  Table [RH].[Ciudades]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Ciudades](
	[idCiudad] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](80) NOT NULL,
	[idEstado] [int] NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_Ciudades] PRIMARY KEY CLUSTERED 
(
	[idCiudad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Estados]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Estados](
	[idEstado] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](60) NOT NULL,
	[siglas] [varchar](10) NOT NULL,
	[estatus] [char](10) NOT NULL,
 CONSTRAINT [PK_Estados] PRIMARY KEY CLUSTERED 
(
	[idEstado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[vCiudades]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[vCiudades]
AS SELECT ciudades.idCiudad,ciudades.nombre,estados.nombre as nombreEstado,estados.idEstado from RH.Estados estados
join RH.Ciudades ciudades on
estados.idEstado=ciudades.idEstado
where estados.estatus='A' and ciudades.estatus='A'
GO
/****** Object:  View [dbo].[vEstados]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[vEstados]
 AS SELECT idEstado,nombre,siglas
 FROM RH.Estados
 WHERE estatus='A'
GO
/****** Object:  Table [Compras].[Categorias]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Categorias](
	[idCategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_Categorias] PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[ContactosProveedor]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[ContactosProveedor](
	[idContacto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](80) NOT NULL,
	[telefono] [varchar](12) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[idProveedor] [int] NOT NULL,
 CONSTRAINT [PK_ContactosProveedor_1] PRIMARY KEY CLUSTERED 
(
	[idContacto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[CuentasProveedor]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[CuentasProveedor](
	[idCuentaProveedor] [int] IDENTITY(1,1) NOT NULL,
	[idProveedor] [int] NOT NULL,
	[noCuenta] [varchar](10) NOT NULL,
	[banco] [varchar](30) NOT NULL,
	[referenciaBancaria] [varchar](20) NOT NULL,
 CONSTRAINT [PK_CuentasProveedor] PRIMARY KEY CLUSTERED 
(
	[idCuentaProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Empaques]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Empaques](
	[idEmpaque] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](80) NOT NULL,
	[capacidad] [float] NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idUnidad] [int] NOT NULL,
 CONSTRAINT [PK_Empaques] PRIMARY KEY CLUSTERED 
(
	[idEmpaque] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[ExistenciasSucursal]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[ExistenciasSucursal](
	[idPresentacion] [int] NOT NULL,
	[idSucursal] [int] NOT NULL,
	[cantidad] [float] NOT NULL,
 CONSTRAINT [PK_ExistenciasSucursal] PRIMARY KEY CLUSTERED 
(
	[idPresentacion] ASC,
	[idSucursal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[ImagenesProducto]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[ImagenesProducto](
	[idImagen] [int] IDENTITY(1,1) NOT NULL,
	[nombreImagen] [varchar](100) NOT NULL,
	[imagen] [image] NOT NULL,
	[principal] [char](1) NOT NULL,
	[idProducto] [int] NOT NULL,
 CONSTRAINT [PK_ImagenesProducto] PRIMARY KEY CLUSTERED 
(
	[idImagen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Laboratorios]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Laboratorios](
	[idLaboratorio] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[origen] [varchar](30) NOT NULL,
	[estatus] [char](10) NOT NULL,
 CONSTRAINT [PK_Laboratorios] PRIMARY KEY CLUSTERED 
(
	[idLaboratorio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Ofertas]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Ofertas](
	[idOferta] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](100) NOT NULL,
	[porDescuento] [float] NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NOT NULL,
	[canMinProducto] [int] NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idPresentacion] [int] NOT NULL,
 CONSTRAINT [PK_Ofertas] PRIMARY KEY CLUSTERED 
(
	[idOferta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Pagos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Pagos](
	[idPago] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[importe] [decimal](18, 4) NOT NULL,
	[idPedido] [int] NOT NULL,
	[idFormaPago] [int] NOT NULL,
 CONSTRAINT [PK_Pagos] PRIMARY KEY CLUSTERED 
(
	[idPago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[PedidoDetalle]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[PedidoDetalle](
	[idPedidoDetalle] [int] IDENTITY(1,1) NOT NULL,
	[cantPedida] [int] NOT NULL,
	[precioCompra] [decimal](18, 4) NOT NULL,
	[subTotal] [decimal](18, 4) NOT NULL,
	[cantRecibida] [int] NOT NULL,
	[cantRechazada] [int] NOT NULL,
	[cantAceptada] [int] NOT NULL,
	[idPedido] [int] NOT NULL,
	[idPresentacion] [int] NOT NULL,
 CONSTRAINT [PK_PedidoDetalle] PRIMARY KEY CLUSTERED 
(
	[idPedidoDetalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Pedidos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Pedidos](
	[idPedido] [int] IDENTITY(1,1) NOT NULL,
	[fechaRegistro] [date] NOT NULL,
	[fechaRecepcion] [date] NOT NULL,
	[totalPagar] [decimal](18, 4) NOT NULL,
	[cantidadPagada] [decimal](18, 4) NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idProveedor] [int] NOT NULL,
	[idSucursal] [int] NOT NULL,
	[idEmpleado] [int] NOT NULL,
 CONSTRAINT [PK_Pedidos] PRIMARY KEY CLUSTERED 
(
	[idPedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[PresentacionesProducto]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[PresentacionesProducto](
	[idPresentacion] [int] IDENTITY(1,1) NOT NULL,
	[precioCompra] [decimal](18, 4) NOT NULL,
	[precioVenta] [decimal](18, 4) NOT NULL,
	[puntoReorden] [decimal](18, 4) NOT NULL,
	[idProducto] [int] NOT NULL,
	[idEmpaque] [int] NOT NULL,
 CONSTRAINT [PK_PresentacionesProducto] PRIMARY KEY CLUSTERED 
(
	[idPresentacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Productos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Productos](
	[idProducto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](100) NOT NULL,
	[ingredienteActivo] [varchar](100) NOT NULL,
	[bandaToxicologica] [varchar](80) NOT NULL,
	[aplicacion] [varchar](200) NOT NULL,
	[uso] [varchar](200) NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idLaboratorio] [int] NOT NULL,
	[idCategoria] [int] NOT NULL,
 CONSTRAINT [PK_Productos] PRIMARY KEY CLUSTERED 
(
	[idProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[ProductosProveedor]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[ProductosProveedor](
	[idProveedor] [int] IDENTITY(1,1) NOT NULL,
	[idPresentacion] [int] NOT NULL,
	[diasRetardo] [int] NOT NULL,
	[precioEstandar] [decimal](18, 4) NOT NULL,
	[PrecioUltimaCompra] [decimal](18, 4) NOT NULL,
	[cantMinPedir] [int] NOT NULL,
	[cantMaxPedir] [int] NOT NULL,
 CONSTRAINT [PK_ProductosProveedor] PRIMARY KEY CLUSTERED 
(
	[idProveedor] ASC,
	[idPresentacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Proveedores]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Proveedores](
	[idProveedor] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](80) NOT NULL,
	[telefono] [varchar](12) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[direccion] [varchar](80) NOT NULL,
	[colonia] [varchar](50) NOT NULL,
	[codigoPostal] [varchar](5) NOT NULL,
	[idCiudad] [int] NOT NULL,
 CONSTRAINT [PK_Proveedores] PRIMARY KEY CLUSTERED 
(
	[idProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[Sucursales]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[Sucursales](
	[idSucursal] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[telefono] [varchar](12) NOT NULL,
	[direccion] [varchar](80) NOT NULL,
	[colonia] [varchar](50) NOT NULL,
	[codigoPostal] [varchar](5) NOT NULL,
	[presupuesto] [decimal](18, 4) NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idCiudad] [int] NOT NULL,
 CONSTRAINT [PK_Sucursales] PRIMARY KEY CLUSTERED 
(
	[idSucursal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Compras].[UnidadesMedida]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Compras].[UnidadesMedida](
	[idUnidad] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](80) NOT NULL,
	[siglas] [varchar](20) NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_UnidadesMedida] PRIMARY KEY CLUSTERED 
(
	[idUnidad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Asistencias]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Asistencias](
	[idAsistencia] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[horaEntrada] [time](7) NOT NULL,
	[horaSalida] [time](7) NOT NULL,
	[dia] [varchar](10) NOT NULL,
	[idEmpleado] [int] NOT NULL,
 CONSTRAINT [PK_Asistencias] PRIMARY KEY CLUSTERED 
(
	[idAsistencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[AusenciasJustificadas]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[AusenciasJustificadas](
	[idAusencia] [int] IDENTITY(1,1) NOT NULL,
	[fechaSolicitud] [date] NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NOT NULL,
	[tipo] [char](1) NOT NULL,
	[idEmpleadoSolicita] [int] NOT NULL,
	[idEmpleadoAutoriza] [int] NOT NULL,
	[evidencia] [image] NOT NULL,
	[estatus] [char](1) NOT NULL,
	[motivo] [varchar](100) NOT NULL,
 CONSTRAINT [PK_AusenciasJustificadas] PRIMARY KEY CLUSTERED 
(
	[idAusencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [RH].[Deducciones]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Deducciones](
	[idDeduccion] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[descripcion] [varchar](80) NOT NULL,
	[porcentaje] [decimal](18, 4) NOT NULL,
 CONSTRAINT [PK_Deducciones] PRIMARY KEY CLUSTERED 
(
	[idDeduccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Departamentos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Departamentos](
	[idDepartamento] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_Departamentos] PRIMARY KEY CLUSTERED 
(
	[idDepartamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[DocumentacionEmpleado]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[DocumentacionEmpleado](
	[idDocumento] [int] IDENTITY(1,1) NOT NULL,
	[nombreDocumento] [varchar](80) NULL,
	[fechaEntrega] [date] NULL,
	[documento] [image] NULL,
	[idEmpleado] [int] NULL,
 CONSTRAINT [PK_DocumentacionEmpleado] PRIMARY KEY CLUSTERED 
(
	[idDocumento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [RH].[Empleados]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Empleados](
	[idEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[apellidoPaterno] [varchar](30) NOT NULL,
	[apellidoMaterno] [varchar](30) NOT NULL,
	[sexo] [char](1) NOT NULL,
	[fechaNacimiento] [date] NOT NULL,
	[curp] [varchar](18) NOT NULL,
	[estadoCivil] [varchar](20) NOT NULL,
	[fechaContratacion] [date] NOT NULL,
	[salarioDiario] [decimal](18, 4) NOT NULL,
	[nss] [varchar](10) NOT NULL,
	[diasVacaciones] [int] NOT NULL,
	[diasPermiso] [int] NOT NULL,
	[fotografia] [image] NOT NULL,
	[direccion] [varchar](80) NOT NULL,
	[colonia] [varchar](50) NOT NULL,
	[codigoPostal] [varchar](5) NOT NULL,
	[escolaridad] [varchar](80) NOT NULL,
	[especialidad] [varchar](100) NOT NULL,
	[email] [varchar](200) NOT NULL,
	[tipo] [varchar](10) NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idDepartamento] [int] NOT NULL,
	[idPuesto] [int] NOT NULL,
	[idCiudad] [int] NOT NULL,
	[idSucursal] [int] NOT NULL,
	[idTurno] [int] NOT NULL,
 CONSTRAINT [PK_Empleados] PRIMARY KEY CLUSTERED 
(
	[idEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [RH].[FormasPago]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[FormasPago](
	[idFormaPago] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_FormasPago] PRIMARY KEY CLUSTERED 
(
	[idFormaPago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[HistorialPuestos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[HistorialPuestos](
	[idEmpleado] [int] NOT NULL,
	[idPuesto] [int] NOT NULL,
	[idDepartamento] [int] NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NOT NULL,
 CONSTRAINT [PK_HistorialPuestos] PRIMARY KEY CLUSTERED 
(
	[idEmpleado] ASC,
	[idPuesto] ASC,
	[idDepartamento] ASC,
	[fechaInicio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Nominas]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Nominas](
	[idNomina] [int] IDENTITY(1,1) NOT NULL,
	[fechaElaboracion] [date] NOT NULL,
	[fechaPago] [date] NOT NULL,
	[subTotal] [decimal](18, 4) NOT NULL,
	[retenciones] [decimal](18, 4) NOT NULL,
	[total] [decimal](18, 4) NOT NULL,
	[diasTrabajados] [int] NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idEmpleado] [int] NOT NULL,
	[idFormaPago] [int] NOT NULL,
	[idPeriodo] [int] NOT NULL,
 CONSTRAINT [PK_Nominas] PRIMARY KEY CLUSTERED 
(
	[idNomina] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[NominasDeducciones]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[NominasDeducciones](
	[idNomina] [int] NOT NULL,
	[idDeduccion] [int] NOT NULL,
	[importe] [decimal](18, 4) NOT NULL,
 CONSTRAINT [PK_NominasDeducciones] PRIMARY KEY CLUSTERED 
(
	[idNomina] ASC,
	[idDeduccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[NominasPercepciones]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[NominasPercepciones](
	[idNomina] [int] IDENTITY(1,1) NOT NULL,
	[idPercepcion] [int] NOT NULL,
	[importe] [decimal](18, 4) NOT NULL,
 CONSTRAINT [PK_NominasPercepciones] PRIMARY KEY CLUSTERED 
(
	[idNomina] ASC,
	[idPercepcion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Percepciones]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Percepciones](
	[idPercepcion] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](30) NULL,
	[descripcion] [varchar](80) NULL,
	[diasPagar] [int] NULL,
 CONSTRAINT [PK_Percepciones] PRIMARY KEY CLUSTERED 
(
	[idPercepcion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Periodos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Periodos](
	[idPeriodo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NOT NULL,
	[estatus] [char](10) NOT NULL,
 CONSTRAINT [PK_Periodos] PRIMARY KEY CLUSTERED 
(
	[idPeriodo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Puestos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Puestos](
	[idPuesto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](60) NOT NULL,
	[salarioMinimo] [decimal](18, 4) NOT NULL,
	[salarioMaxino] [decimal](18, 4) NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_Puestos] PRIMARY KEY CLUSTERED 
(
	[idPuesto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [RH].[Turnos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [RH].[Turnos](
	[idTurno] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](20) NOT NULL,
	[horaInicio] [time](7) NOT NULL,
	[horaFin] [time](7) NOT NULL,
	[dias] [varchar](30) NOT NULL,
 CONSTRAINT [PK_Turnos] PRIMARY KEY CLUSTERED 
(
	[idTurno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Asesorias]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Asesorias](
	[idAsesoria] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[comentarios] [varchar](200) NOT NULL,
	[estatus] [char](1) NOT NULL,
	[costo] [decimal](18, 4) NOT NULL,
	[idParcela] [int] NOT NULL,
	[idEmpleado] [int] NOT NULL,
	[idUnidadTransporte] [int] NOT NULL,
 CONSTRAINT [PK_Asesorias] PRIMARY KEY CLUSTERED 
(
	[idAsesoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Asociaciones]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Asociaciones](
	[idAsociacion] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_Asociaciones] PRIMARY KEY CLUSTERED 
(
	[idAsociacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Clientes]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Clientes](
	[idCliente] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[razonSocial] [varchar](100) NOT NULL,
	[limiteCredito] [decimal](18, 4) NOT NULL,
	[rfc] [char](13) NOT NULL,
	[telefono] [char](12) NOT NULL,
	[email] [varchar](12) NOT NULL,
	[tipo] [char](1) NOT NULL,
 CONSTRAINT [PK_Clientes] PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Cobros]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Cobros](
	[idCobro] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[importe] [decimal](18, 4) NOT NULL,
	[idVenta] [int] NOT NULL,
	[idFormaPago] [int] NOT NULL,
 CONSTRAINT [PK_Cobros] PRIMARY KEY CLUSTERED 
(
	[idCobro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[ContactosCliente]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[ContactosCliente](
	[idContacto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[telefono] [varchar](12) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[idCliente] [int] NOT NULL,
 CONSTRAINT [PK_ContactosCliente] PRIMARY KEY CLUSTERED 
(
	[idContacto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Cultivos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Cultivos](
	[idCultivo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[costoAsesoria] [decimal](18, 4) NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_Cultivos] PRIMARY KEY CLUSTERED 
(
	[idCultivo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Detalles_Envio]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Detalles_Envio](
	[idEnvio] [int] NOT NULL,
	[idVenta] [int] NOT NULL,
	[idDireccion] [int] NOT NULL,
	[fechaEntregaPlaneada] [date] NOT NULL,
	[fechaRecepcion] [date] NULL,
	[peso] [float] NOT NULL,
	[estatus] [char](1) NOT NULL,
	[idContacto] [int] NOT NULL,
 CONSTRAINT [PK_Detalles_Envio] PRIMARY KEY CLUSTERED 
(
	[idEnvio] ASC,
	[idVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Direcciones_Clientes]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Direcciones_Clientes](
	[idDireccion] [int] IDENTITY(1,1) NOT NULL,
	[calle] [varchar](80) NOT NULL,
	[numero] [varchar](15) NOT NULL,
	[colonia] [varchar](100) NOT NULL,
	[codigoPostal] [varchar](5) NOT NULL,
	[tipo] [char](1) NOT NULL,
	[idCliente] [int] NOT NULL,
	[idCiudad] [int] NOT NULL,
 CONSTRAINT [PK_DireccionesClientes] PRIMARY KEY CLUSTERED 
(
	[idDireccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Envios]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Envios](
	[idEnvio] [int] IDENTITY(1,1) NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NOT NULL,
	[idUnidadTransporte] [int] NOT NULL,
	[pesoTotal] [float] NOT NULL,
 CONSTRAINT [PK_Envios] PRIMARY KEY CLUSTERED 
(
	[idEnvio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Mantenimientos]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Mantenimientos](
	[idMantenimiento] [int] IDENTITY(1,1) NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NOT NULL,
	[taller] [varchar](100) NOT NULL,
	[costo] [decimal](18, 4) NOT NULL,
	[comentarios] [varchar](200) NOT NULL,
	[tipo] [varchar](30) NOT NULL,
	[idUnidadTransporte] [int] NOT NULL,
 CONSTRAINT [PK_Mantenimientos] PRIMARY KEY CLUSTERED 
(
	[idMantenimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Miembros]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Miembros](
	[idCliente] [int] NOT NULL,
	[idAsociacion] [int] NOT NULL,
	[estatus] [char](1) NOT NULL,
	[fechaIncorporacion] [date] NOT NULL,
 CONSTRAINT [PK_Miembros] PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC,
	[idAsociacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[OfertasAsociacion]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[OfertasAsociacion](
	[idAsociacion] [int] NOT NULL,
	[idOferta] [int] NOT NULL,
	[estatus] [char](1) NOT NULL,
 CONSTRAINT [PK_OfertasAsociacion] PRIMARY KEY CLUSTERED 
(
	[idAsociacion] ASC,
	[idOferta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Parcelas]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Parcelas](
	[idParcela] [int] IDENTITY(1,1) NOT NULL,
	[extension] [float] NOT NULL,
	[idCliente] [int] NOT NULL,
	[idCultivo] [int] NOT NULL,
	[idDireccion] [int] NOT NULL,
 CONSTRAINT [PK_Parcelas] PRIMARY KEY CLUSTERED 
(
	[idParcela] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Tripulacion]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Tripulacion](
	[idEmpleado] [int] NOT NULL,
	[idEnvio] [int] NOT NULL,
	[rol] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Tripulacion] PRIMARY KEY CLUSTERED 
(
	[idEmpleado] ASC,
	[idEnvio] ASC,
	[rol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[UnidadesTransporte]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[UnidadesTransporte](
	[idUnidadTransporte] [int] IDENTITY(1,1) NOT NULL,
	[placas] [varchar](10) NOT NULL,
	[marca] [varchar](80) NOT NULL,
	[modelo] [varchar](80) NOT NULL,
	[anio] [int] NOT NULL,
	[capacidad] [int] NOT NULL,
	[tipo] [varchar](30) NOT NULL,
 CONSTRAINT [PK_UnidadesTransporte] PRIMARY KEY CLUSTERED 
(
	[idUnidadTransporte] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[Ventas]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[Ventas](
	[idVenta] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[subTotal] [decimal](18, 4) NOT NULL,
	[iva] [decimal](18, 4) NOT NULL,
	[total] [decimal](18, 4) NOT NULL,
	[cantPagada] [decimal](18, 4) NOT NULL,
	[comentarios] [varchar](100) NOT NULL,
	[estatus] [char](1) NOT NULL,
	[tipo] [char](1) NOT NULL,
	[idCliente] [int] NOT NULL,
	[idSucursal] [int] NOT NULL,
	[idEmpleado] [int] NOT NULL,
 CONSTRAINT [PK_Ventas] PRIMARY KEY CLUSTERED 
(
	[idVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Sales].[VentasDetalle]    Script Date: 14/04/2021 11:06:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Sales].[VentasDetalle](
	[idVentaDetalle] [int] IDENTITY(1,1) NOT NULL,
	[precioVenta] [decimal](18, 4) NOT NULL,
	[cantidad] [float] NOT NULL,
	[subTotal] [decimal](18, 4) NOT NULL,
	[idVenta] [int] NOT NULL,
	[idPresentacion] [int] NOT NULL,
 CONSTRAINT [PK_VentasDetalle] PRIMARY KEY CLUSTERED 
(
	[idVentaDetalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [Compras].[ContactosProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ContactosProveedor_Proveedores] FOREIGN KEY([idProveedor])
REFERENCES [Compras].[Proveedores] ([idProveedor])
GO
ALTER TABLE [Compras].[ContactosProveedor] CHECK CONSTRAINT [FK_ContactosProveedor_Proveedores]
GO
ALTER TABLE [Compras].[CuentasProveedor]  WITH CHECK ADD  CONSTRAINT [FK_CuentasProveedor_Proveedores] FOREIGN KEY([idProveedor])
REFERENCES [Compras].[Proveedores] ([idProveedor])
GO
ALTER TABLE [Compras].[CuentasProveedor] CHECK CONSTRAINT [FK_CuentasProveedor_Proveedores]
GO
ALTER TABLE [Compras].[Empaques]  WITH CHECK ADD  CONSTRAINT [FK_Empaques_UnidadesMedida] FOREIGN KEY([idUnidad])
REFERENCES [Compras].[UnidadesMedida] ([idUnidad])
GO
ALTER TABLE [Compras].[Empaques] CHECK CONSTRAINT [FK_Empaques_UnidadesMedida]
GO
ALTER TABLE [Compras].[ExistenciasSucursal]  WITH CHECK ADD  CONSTRAINT [FK_ExistenciasSucursal_PresentacionesProducto] FOREIGN KEY([idPresentacion])
REFERENCES [Compras].[PresentacionesProducto] ([idPresentacion])
GO
ALTER TABLE [Compras].[ExistenciasSucursal] CHECK CONSTRAINT [FK_ExistenciasSucursal_PresentacionesProducto]
GO
ALTER TABLE [Compras].[ExistenciasSucursal]  WITH CHECK ADD  CONSTRAINT [FK_ExistenciasSucursal_Sucursales] FOREIGN KEY([idSucursal])
REFERENCES [Compras].[Sucursales] ([idSucursal])
GO
ALTER TABLE [Compras].[ExistenciasSucursal] CHECK CONSTRAINT [FK_ExistenciasSucursal_Sucursales]
GO
ALTER TABLE [Compras].[ImagenesProducto]  WITH CHECK ADD  CONSTRAINT [FK_ImagenesProducto_Productos] FOREIGN KEY([idProducto])
REFERENCES [Compras].[Productos] ([idProducto])
GO
ALTER TABLE [Compras].[ImagenesProducto] CHECK CONSTRAINT [FK_ImagenesProducto_Productos]
GO
ALTER TABLE [Compras].[Ofertas]  WITH CHECK ADD  CONSTRAINT [FK_Ofertas_PresentacionesProducto] FOREIGN KEY([idPresentacion])
REFERENCES [Compras].[PresentacionesProducto] ([idPresentacion])
GO
ALTER TABLE [Compras].[Ofertas] CHECK CONSTRAINT [FK_Ofertas_PresentacionesProducto]
GO
ALTER TABLE [Compras].[Pagos]  WITH CHECK ADD  CONSTRAINT [FK_Pagos_Pedidos] FOREIGN KEY([idPedido])
REFERENCES [Compras].[Pedidos] ([idPedido])
GO
ALTER TABLE [Compras].[Pagos] CHECK CONSTRAINT [FK_Pagos_Pedidos]
GO
ALTER TABLE [Compras].[Pagos]  WITH CHECK ADD  CONSTRAINT [FK_Pagos_Pedidos1] FOREIGN KEY([idPago])
REFERENCES [Compras].[Pedidos] ([idPedido])
GO
ALTER TABLE [Compras].[Pagos] CHECK CONSTRAINT [FK_Pagos_Pedidos1]
GO
ALTER TABLE [Compras].[PedidoDetalle]  WITH CHECK ADD  CONSTRAINT [FK_PedidoDetalle_Pedidos] FOREIGN KEY([idPedido])
REFERENCES [Compras].[Pedidos] ([idPedido])
GO
ALTER TABLE [Compras].[PedidoDetalle] CHECK CONSTRAINT [FK_PedidoDetalle_Pedidos]
GO
ALTER TABLE [Compras].[PedidoDetalle]  WITH CHECK ADD  CONSTRAINT [FK_PedidoDetalle_PresentacionesProducto] FOREIGN KEY([idPresentacion])
REFERENCES [Compras].[PresentacionesProducto] ([idPresentacion])
GO
ALTER TABLE [Compras].[PedidoDetalle] CHECK CONSTRAINT [FK_PedidoDetalle_PresentacionesProducto]
GO
ALTER TABLE [Compras].[Pedidos]  WITH CHECK ADD  CONSTRAINT [FK_Pedidos_Empleados] FOREIGN KEY([idEmpleado])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [Compras].[Pedidos] CHECK CONSTRAINT [FK_Pedidos_Empleados]
GO
ALTER TABLE [Compras].[Pedidos]  WITH CHECK ADD  CONSTRAINT [FK_Pedidos_Proveedores] FOREIGN KEY([idProveedor])
REFERENCES [Compras].[Proveedores] ([idProveedor])
GO
ALTER TABLE [Compras].[Pedidos] CHECK CONSTRAINT [FK_Pedidos_Proveedores]
GO
ALTER TABLE [Compras].[Pedidos]  WITH CHECK ADD  CONSTRAINT [FK_Pedidos_Sucursales] FOREIGN KEY([idSucursal])
REFERENCES [Compras].[Sucursales] ([idSucursal])
GO
ALTER TABLE [Compras].[Pedidos] CHECK CONSTRAINT [FK_Pedidos_Sucursales]
GO
ALTER TABLE [Compras].[PresentacionesProducto]  WITH CHECK ADD  CONSTRAINT [FK_PresentacionesProducto_Empaques] FOREIGN KEY([idEmpaque])
REFERENCES [Compras].[Empaques] ([idEmpaque])
GO
ALTER TABLE [Compras].[PresentacionesProducto] CHECK CONSTRAINT [FK_PresentacionesProducto_Empaques]
GO
ALTER TABLE [Compras].[PresentacionesProducto]  WITH CHECK ADD  CONSTRAINT [FK_PresentacionesProducto_Productos] FOREIGN KEY([idProducto])
REFERENCES [Compras].[Productos] ([idProducto])
GO
ALTER TABLE [Compras].[PresentacionesProducto] CHECK CONSTRAINT [FK_PresentacionesProducto_Productos]
GO
ALTER TABLE [Compras].[Productos]  WITH CHECK ADD  CONSTRAINT [FK_Productos_Categorias] FOREIGN KEY([idCategoria])
REFERENCES [Compras].[Categorias] ([idCategoria])
GO
ALTER TABLE [Compras].[Productos] CHECK CONSTRAINT [FK_Productos_Categorias]
GO
ALTER TABLE [Compras].[Productos]  WITH CHECK ADD  CONSTRAINT [FK_Productos_Laboratorios] FOREIGN KEY([idLaboratorio])
REFERENCES [Compras].[Laboratorios] ([idLaboratorio])
GO
ALTER TABLE [Compras].[Productos] CHECK CONSTRAINT [FK_Productos_Laboratorios]
GO
ALTER TABLE [Compras].[ProductosProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ProductosProveedor_PresentacionesProducto] FOREIGN KEY([idPresentacion])
REFERENCES [Compras].[PresentacionesProducto] ([idPresentacion])
GO
ALTER TABLE [Compras].[ProductosProveedor] CHECK CONSTRAINT [FK_ProductosProveedor_PresentacionesProducto]
GO
ALTER TABLE [Compras].[ProductosProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ProductosProveedor_Proveedores] FOREIGN KEY([idProveedor])
REFERENCES [Compras].[Proveedores] ([idProveedor])
GO
ALTER TABLE [Compras].[ProductosProveedor] CHECK CONSTRAINT [FK_ProductosProveedor_Proveedores]
GO
ALTER TABLE [Compras].[Proveedores]  WITH CHECK ADD  CONSTRAINT [FK_Proveedores_Ciudades] FOREIGN KEY([idCiudad])
REFERENCES [RH].[Ciudades] ([idCiudad])
GO
ALTER TABLE [Compras].[Proveedores] CHECK CONSTRAINT [FK_Proveedores_Ciudades]
GO
ALTER TABLE [Compras].[Sucursales]  WITH CHECK ADD  CONSTRAINT [FK_Sucursales_Ciudades] FOREIGN KEY([idCiudad])
REFERENCES [RH].[Ciudades] ([idCiudad])
GO
ALTER TABLE [Compras].[Sucursales] CHECK CONSTRAINT [FK_Sucursales_Ciudades]
GO
ALTER TABLE [RH].[AusenciasJustificadas]  WITH CHECK ADD  CONSTRAINT [FK_AusenciasJustificadas_Empleados_idEmpleadoAutoriza] FOREIGN KEY([idEmpleadoAutoriza])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [RH].[AusenciasJustificadas] CHECK CONSTRAINT [FK_AusenciasJustificadas_Empleados_idEmpleadoAutoriza]
GO
ALTER TABLE [RH].[AusenciasJustificadas]  WITH CHECK ADD  CONSTRAINT [FK_AusenciasJustificadas_Empleados_idEmpleadoSolicita] FOREIGN KEY([idEmpleadoAutoriza])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [RH].[AusenciasJustificadas] CHECK CONSTRAINT [FK_AusenciasJustificadas_Empleados_idEmpleadoSolicita]
GO
ALTER TABLE [RH].[Ciudades]  WITH CHECK ADD  CONSTRAINT [FK_Ciudades_Estados] FOREIGN KEY([idEstado])
REFERENCES [RH].[Estados] ([idEstado])
GO
ALTER TABLE [RH].[Ciudades] CHECK CONSTRAINT [FK_Ciudades_Estados]
GO
ALTER TABLE [RH].[DocumentacionEmpleado]  WITH CHECK ADD  CONSTRAINT [FK_DocumentacionEmpleado_Empleados] FOREIGN KEY([idEmpleado])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [RH].[DocumentacionEmpleado] CHECK CONSTRAINT [FK_DocumentacionEmpleado_Empleados]
GO
ALTER TABLE [RH].[Empleados]  WITH CHECK ADD  CONSTRAINT [FK_Empleados_Ciudades] FOREIGN KEY([idCiudad])
REFERENCES [RH].[Ciudades] ([idCiudad])
GO
ALTER TABLE [RH].[Empleados] CHECK CONSTRAINT [FK_Empleados_Ciudades]
GO
ALTER TABLE [RH].[Empleados]  WITH CHECK ADD  CONSTRAINT [FK_Empleados_Departamentos] FOREIGN KEY([idDepartamento])
REFERENCES [RH].[Departamentos] ([idDepartamento])
GO
ALTER TABLE [RH].[Empleados] CHECK CONSTRAINT [FK_Empleados_Departamentos]
GO
ALTER TABLE [RH].[Empleados]  WITH CHECK ADD  CONSTRAINT [FK_Empleados_Puestos] FOREIGN KEY([idPuesto])
REFERENCES [RH].[Puestos] ([idPuesto])
GO
ALTER TABLE [RH].[Empleados] CHECK CONSTRAINT [FK_Empleados_Puestos]
GO
ALTER TABLE [RH].[Empleados]  WITH CHECK ADD  CONSTRAINT [FK_Empleados_Sucursales] FOREIGN KEY([idSucursal])
REFERENCES [Compras].[Sucursales] ([idSucursal])
GO
ALTER TABLE [RH].[Empleados] CHECK CONSTRAINT [FK_Empleados_Sucursales]
GO
ALTER TABLE [RH].[Empleados]  WITH CHECK ADD  CONSTRAINT [FK_Empleados_Turnos] FOREIGN KEY([idTurno])
REFERENCES [RH].[Turnos] ([idTurno])
GO
ALTER TABLE [RH].[Empleados] CHECK CONSTRAINT [FK_Empleados_Turnos]
GO
ALTER TABLE [RH].[HistorialPuestos]  WITH CHECK ADD  CONSTRAINT [FK_HistorialPuestos_Departamentos] FOREIGN KEY([idDepartamento])
REFERENCES [RH].[Departamentos] ([idDepartamento])
GO
ALTER TABLE [RH].[HistorialPuestos] CHECK CONSTRAINT [FK_HistorialPuestos_Departamentos]
GO
ALTER TABLE [RH].[HistorialPuestos]  WITH CHECK ADD  CONSTRAINT [FK_HistorialPuestos_Empleados] FOREIGN KEY([idEmpleado])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [RH].[HistorialPuestos] CHECK CONSTRAINT [FK_HistorialPuestos_Empleados]
GO
ALTER TABLE [RH].[HistorialPuestos]  WITH CHECK ADD  CONSTRAINT [FK_HistorialPuestos_Puestos] FOREIGN KEY([idPuesto])
REFERENCES [RH].[Puestos] ([idPuesto])
GO
ALTER TABLE [RH].[HistorialPuestos] CHECK CONSTRAINT [FK_HistorialPuestos_Puestos]
GO
ALTER TABLE [RH].[Nominas]  WITH CHECK ADD  CONSTRAINT [FK_Nominas_Empleados] FOREIGN KEY([idEmpleado])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [RH].[Nominas] CHECK CONSTRAINT [FK_Nominas_Empleados]
GO
ALTER TABLE [RH].[Nominas]  WITH CHECK ADD  CONSTRAINT [FK_Nominas_FormasPago] FOREIGN KEY([idFormaPago])
REFERENCES [RH].[FormasPago] ([idFormaPago])
GO
ALTER TABLE [RH].[Nominas] CHECK CONSTRAINT [FK_Nominas_FormasPago]
GO
ALTER TABLE [RH].[Nominas]  WITH CHECK ADD  CONSTRAINT [FK_Nominas_Periodos] FOREIGN KEY([idPeriodo])
REFERENCES [RH].[Periodos] ([idPeriodo])
GO
ALTER TABLE [RH].[Nominas] CHECK CONSTRAINT [FK_Nominas_Periodos]
GO
ALTER TABLE [RH].[NominasDeducciones]  WITH CHECK ADD  CONSTRAINT [FK_NominasDeducciones_Deducciones] FOREIGN KEY([idDeduccion])
REFERENCES [RH].[Deducciones] ([idDeduccion])
GO
ALTER TABLE [RH].[NominasDeducciones] CHECK CONSTRAINT [FK_NominasDeducciones_Deducciones]
GO
ALTER TABLE [RH].[NominasDeducciones]  WITH CHECK ADD  CONSTRAINT [FK_NominasDeducciones_Nominas] FOREIGN KEY([idNomina])
REFERENCES [RH].[Nominas] ([idNomina])
GO
ALTER TABLE [RH].[NominasDeducciones] CHECK CONSTRAINT [FK_NominasDeducciones_Nominas]
GO
ALTER TABLE [RH].[NominasPercepciones]  WITH CHECK ADD  CONSTRAINT [FK_NominasPercepciones_Nominas] FOREIGN KEY([idNomina])
REFERENCES [RH].[Nominas] ([idNomina])
GO
ALTER TABLE [RH].[NominasPercepciones] CHECK CONSTRAINT [FK_NominasPercepciones_Nominas]
GO
ALTER TABLE [RH].[NominasPercepciones]  WITH CHECK ADD  CONSTRAINT [FK_NominasPercepciones_Percepciones] FOREIGN KEY([idPercepcion])
REFERENCES [RH].[Percepciones] ([idPercepcion])
GO
ALTER TABLE [RH].[NominasPercepciones] CHECK CONSTRAINT [FK_NominasPercepciones_Percepciones]
GO
ALTER TABLE [Sales].[Asesorias]  WITH CHECK ADD  CONSTRAINT [FK_Asesorias_Empleados] FOREIGN KEY([idEmpleado])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [Sales].[Asesorias] CHECK CONSTRAINT [FK_Asesorias_Empleados]
GO
ALTER TABLE [Sales].[Asesorias]  WITH CHECK ADD  CONSTRAINT [FK_Asesorias_Parcelas] FOREIGN KEY([idParcela])
REFERENCES [Sales].[Parcelas] ([idParcela])
GO
ALTER TABLE [Sales].[Asesorias] CHECK CONSTRAINT [FK_Asesorias_Parcelas]
GO
ALTER TABLE [Sales].[Asesorias]  WITH CHECK ADD  CONSTRAINT [FK_Asesorias_UnidadesTransporte] FOREIGN KEY([idUnidadTransporte])
REFERENCES [Sales].[UnidadesTransporte] ([idUnidadTransporte])
GO
ALTER TABLE [Sales].[Asesorias] CHECK CONSTRAINT [FK_Asesorias_UnidadesTransporte]
GO
ALTER TABLE [Sales].[Cobros]  WITH CHECK ADD  CONSTRAINT [FK_Cobros_FormasPago] FOREIGN KEY([idFormaPago])
REFERENCES [RH].[FormasPago] ([idFormaPago])
GO
ALTER TABLE [Sales].[Cobros] CHECK CONSTRAINT [FK_Cobros_FormasPago]
GO
ALTER TABLE [Sales].[Cobros]  WITH CHECK ADD  CONSTRAINT [FK_Cobros_Ventas] FOREIGN KEY([idVenta])
REFERENCES [Sales].[Ventas] ([idVenta])
GO
ALTER TABLE [Sales].[Cobros] CHECK CONSTRAINT [FK_Cobros_Ventas]
GO
ALTER TABLE [Sales].[ContactosCliente]  WITH CHECK ADD  CONSTRAINT [FK_ContactosCliente_Clientes] FOREIGN KEY([idCliente])
REFERENCES [Sales].[Clientes] ([idCliente])
GO
ALTER TABLE [Sales].[ContactosCliente] CHECK CONSTRAINT [FK_ContactosCliente_Clientes]
GO
ALTER TABLE [Sales].[Detalles_Envio]  WITH CHECK ADD  CONSTRAINT [FK_Detalles_Envio_ContactosProveedor] FOREIGN KEY([idContacto])
REFERENCES [Sales].[ContactosCliente] ([idContacto])
GO
ALTER TABLE [Sales].[Detalles_Envio] CHECK CONSTRAINT [FK_Detalles_Envio_ContactosProveedor]
GO
ALTER TABLE [Sales].[Detalles_Envio]  WITH CHECK ADD  CONSTRAINT [FK_Detalles_Envio_Direcciones_Clientes] FOREIGN KEY([idDireccion])
REFERENCES [Sales].[Direcciones_Clientes] ([idDireccion])
GO
ALTER TABLE [Sales].[Detalles_Envio] CHECK CONSTRAINT [FK_Detalles_Envio_Direcciones_Clientes]
GO
ALTER TABLE [Sales].[Detalles_Envio]  WITH CHECK ADD  CONSTRAINT [FK_Detalles_Envio_Envios] FOREIGN KEY([idEnvio])
REFERENCES [Sales].[Envios] ([idEnvio])
GO
ALTER TABLE [Sales].[Detalles_Envio] CHECK CONSTRAINT [FK_Detalles_Envio_Envios]
GO
ALTER TABLE [Sales].[Detalles_Envio]  WITH CHECK ADD  CONSTRAINT [FK_Detalles_Envio_Ventas] FOREIGN KEY([idVenta])
REFERENCES [Sales].[Ventas] ([idVenta])
GO
ALTER TABLE [Sales].[Detalles_Envio] CHECK CONSTRAINT [FK_Detalles_Envio_Ventas]
GO
ALTER TABLE [Sales].[Direcciones_Clientes]  WITH CHECK ADD  CONSTRAINT [FK_Direcciones_Clientes_Ciudades] FOREIGN KEY([idCiudad])
REFERENCES [RH].[Ciudades] ([idCiudad])
GO
ALTER TABLE [Sales].[Direcciones_Clientes] CHECK CONSTRAINT [FK_Direcciones_Clientes_Ciudades]
GO
ALTER TABLE [Sales].[Direcciones_Clientes]  WITH CHECK ADD  CONSTRAINT [FK_Direcciones_Clientes_Clientes] FOREIGN KEY([idCliente])
REFERENCES [Sales].[Clientes] ([idCliente])
GO
ALTER TABLE [Sales].[Direcciones_Clientes] CHECK CONSTRAINT [FK_Direcciones_Clientes_Clientes]
GO
ALTER TABLE [Sales].[Envios]  WITH CHECK ADD  CONSTRAINT [FK_Envios_UnidadesTransporte] FOREIGN KEY([idUnidadTransporte])
REFERENCES [Sales].[UnidadesTransporte] ([idUnidadTransporte])
GO
ALTER TABLE [Sales].[Envios] CHECK CONSTRAINT [FK_Envios_UnidadesTransporte]
GO
ALTER TABLE [Sales].[Mantenimientos]  WITH CHECK ADD  CONSTRAINT [FK_Mantenimientos_UnidadesTransporte] FOREIGN KEY([idUnidadTransporte])
REFERENCES [Sales].[UnidadesTransporte] ([idUnidadTransporte])
GO
ALTER TABLE [Sales].[Mantenimientos] CHECK CONSTRAINT [FK_Mantenimientos_UnidadesTransporte]
GO
ALTER TABLE [Sales].[Miembros]  WITH CHECK ADD  CONSTRAINT [FK_Miembros_Asociaciones] FOREIGN KEY([idAsociacion])
REFERENCES [Sales].[Asociaciones] ([idAsociacion])
GO
ALTER TABLE [Sales].[Miembros] CHECK CONSTRAINT [FK_Miembros_Asociaciones]
GO
ALTER TABLE [Sales].[Miembros]  WITH CHECK ADD  CONSTRAINT [FK_Miembros_Clientes] FOREIGN KEY([idCliente])
REFERENCES [Sales].[Clientes] ([idCliente])
GO
ALTER TABLE [Sales].[Miembros] CHECK CONSTRAINT [FK_Miembros_Clientes]
GO
ALTER TABLE [Sales].[OfertasAsociacion]  WITH CHECK ADD  CONSTRAINT [FK_OfertasAsociacion_Asociaciones] FOREIGN KEY([idAsociacion])
REFERENCES [Sales].[Asociaciones] ([idAsociacion])
GO
ALTER TABLE [Sales].[OfertasAsociacion] CHECK CONSTRAINT [FK_OfertasAsociacion_Asociaciones]
GO
ALTER TABLE [Sales].[OfertasAsociacion]  WITH CHECK ADD  CONSTRAINT [FK_OfertasAsociacion_Ofertas] FOREIGN KEY([idOferta])
REFERENCES [Compras].[Ofertas] ([idOferta])
GO
ALTER TABLE [Sales].[OfertasAsociacion] CHECK CONSTRAINT [FK_OfertasAsociacion_Ofertas]
GO
ALTER TABLE [Sales].[Parcelas]  WITH CHECK ADD  CONSTRAINT [FK_Parcelas_Clientes] FOREIGN KEY([idCliente])
REFERENCES [Sales].[Clientes] ([idCliente])
GO
ALTER TABLE [Sales].[Parcelas] CHECK CONSTRAINT [FK_Parcelas_Clientes]
GO
ALTER TABLE [Sales].[Parcelas]  WITH CHECK ADD  CONSTRAINT [FK_Parcelas_Cultivos] FOREIGN KEY([idCultivo])
REFERENCES [Sales].[Cultivos] ([idCultivo])
GO
ALTER TABLE [Sales].[Parcelas] CHECK CONSTRAINT [FK_Parcelas_Cultivos]
GO
ALTER TABLE [Sales].[Parcelas]  WITH CHECK ADD  CONSTRAINT [FK_Parcelas_Direcciones_Clientes] FOREIGN KEY([idDireccion])
REFERENCES [Sales].[Direcciones_Clientes] ([idDireccion])
GO
ALTER TABLE [Sales].[Parcelas] CHECK CONSTRAINT [FK_Parcelas_Direcciones_Clientes]
GO
ALTER TABLE [Sales].[Tripulacion]  WITH CHECK ADD  CONSTRAINT [FK_Tripulacion_Empleados] FOREIGN KEY([idEmpleado])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [Sales].[Tripulacion] CHECK CONSTRAINT [FK_Tripulacion_Empleados]
GO
ALTER TABLE [Sales].[Tripulacion]  WITH CHECK ADD  CONSTRAINT [FK_Tripulacion_Envios] FOREIGN KEY([idEnvio])
REFERENCES [Sales].[Envios] ([idEnvio])
GO
ALTER TABLE [Sales].[Tripulacion] CHECK CONSTRAINT [FK_Tripulacion_Envios]
GO
ALTER TABLE [Sales].[Ventas]  WITH CHECK ADD  CONSTRAINT [FK_Ventas_Clientes] FOREIGN KEY([idCliente])
REFERENCES [Sales].[Clientes] ([idCliente])
GO
ALTER TABLE [Sales].[Ventas] CHECK CONSTRAINT [FK_Ventas_Clientes]
GO
ALTER TABLE [Sales].[Ventas]  WITH CHECK ADD  CONSTRAINT [FK_Ventas_Empleados] FOREIGN KEY([idEmpleado])
REFERENCES [RH].[Empleados] ([idEmpleado])
GO
ALTER TABLE [Sales].[Ventas] CHECK CONSTRAINT [FK_Ventas_Empleados]
GO
ALTER TABLE [Sales].[Ventas]  WITH CHECK ADD  CONSTRAINT [FK_Ventas_Sucursales] FOREIGN KEY([idSucursal])
REFERENCES [Compras].[Sucursales] ([idSucursal])
GO
ALTER TABLE [Sales].[Ventas] CHECK CONSTRAINT [FK_Ventas_Sucursales]
GO
ALTER TABLE [Sales].[VentasDetalle]  WITH CHECK ADD  CONSTRAINT [FK_VentasDetalle_PresentacionesProducto] FOREIGN KEY([idPresentacion])
REFERENCES [Compras].[PresentacionesProducto] ([idPresentacion])
GO
ALTER TABLE [Sales].[VentasDetalle] CHECK CONSTRAINT [FK_VentasDetalle_PresentacionesProducto]
GO
ALTER TABLE [Sales].[VentasDetalle]  WITH CHECK ADD  CONSTRAINT [FK_VentasDetalle_Ventas] FOREIGN KEY([idVenta])
REFERENCES [Sales].[Ventas] ([idVenta])
GO
ALTER TABLE [Sales].[VentasDetalle] CHECK CONSTRAINT [FK_VentasDetalle_Ventas]
GO
USE [master]
GO
ALTER DATABASE [ERP] SET  READ_WRITE 
GO
