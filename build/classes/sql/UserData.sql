-- Crear la base de datos
DROP DATABASE IF EXISTS USERDATA;
CREATE DATABASE USERDATA;

-- Conectar a la base de datos recién creada
USE USERDATA;

-- Crear la tabla USER con el nuevo campo USERID
CREATE TABLE USER (
    USERID INT AUTO_INCREMENT PRIMARY KEY,
    DNI CHAR(9),
    NOMBRE VARCHAR(50),
    APELLIDO VARCHAR(50),
    DIRECCION VARCHAR(100),
    EMAIL VARCHAR(100),
    SEXO VARCHAR(10)
);

INSERT INTO USER (DNI, NOMBRE, APELLIDO, DIRECCION, EMAIL, SEXO)
VALUES ('12345678K', 'Juan Carlos', 'García López', 'Calle de la República 123, 28001 Madrid', 'juan.garcia@example.com', 'Masculino');
