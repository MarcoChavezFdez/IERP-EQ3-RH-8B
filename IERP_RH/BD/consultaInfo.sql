--Script para consultar los metadatos de la BD
use ERP
go
--
--Consultar los esquemas de la BD
select schema_id,name from sys.schemas
where name in('Compras','RH','Sales')
go
--Consultar total de tablas de la BD
select COUNT(name)as Total_Tablas from sysobjects where type='U'
go

--Consulta de tablas
select t.name tabla,s.name esquema 
from sys.tables t join sys.schemas s on s.schema_id=t.schema_id
go
