CREATE DATABASE SPKL_CROSSWORDS

IF EXISTS (SELECT * FROM DBO.SYSOBJECTS WHERE NAME = 'sp_EXISTSDATA')
BEGIN
	DROP PROC sp_EXISTSDATA
END
GO
CREATE PROC sp_EXISTSDATA
	@STATUS INT OUTPUT
AS
BEGIN
if exists (SELECT * FROM master..sysdatabases where name='crosswords')
