-- Active: 1714186397700@@127.0.0.1@3306@libreria
DROP DATABASE IF EXISTS libreria;
CREATE DATABASE IF NOT EXISTS libreria;
USE libreria;
DROP TABLE IF EXISTS autores;
DROP TABLE IF EXISTS editoriales;
DROP TABLE IF EXISTS libros;

-- Tabla: autores
CREATE TABLE autores (
    id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    nacionalidad VARCHAR(255),
    biografia TEXT,
    activo BOOLEAN DEFAULT TRUE
);

-- Tabla: editoriales
CREATE TABLE editoriales (
    id_editorial INT AUTO_INCREMENT PRIMARY KEY,
    nombre_editorial VARCHAR(255) NOT NULL,
    oficina_editorial VARCHAR(255) NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);

-- Tabla: libros
CREATE TABLE libros (
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    genero VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    id_autor INT,
    id_editorial INT,
    fecha_publicacion DATE,
    activo BOOLEAN DEFAULT TRUE
);

-- Clave foránea: libros -> autores
ALTER TABLE libros
ADD CONSTRAINT fk_libro_autor
FOREIGN KEY (id_autor) REFERENCES autores (id_autor)
ON DELETE SET NULL
ON UPDATE CASCADE;

-- Clave foránea: libros -> editoriales
ALTER TABLE libros
ADD CONSTRAINT fk_libro_editorial
FOREIGN KEY (id_editorial) REFERENCES editoriales (id_editorial)
ON DELETE SET NULL
ON UPDATE CASCADE;

SELECT * FROM editoriales;
SELECT * FROM libros;
SELECT * FROM autores;