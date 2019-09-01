CREATE DATABASE pinturas;

USE pinturas;


create table Pintor(
id_pintor INT auto_increment primary KEY,
nombre VARCHAR(50) NOT NULL,
estilo VARCHAR(50) NOT NULL,
anio_nacimiento DATE DEFAULT '0000-00-00'

);


create table Cuadro(
id_cuadro INT auto_increment primary KEY,
titulo VARCHAR(50) NOT NULL,
anio DATE DEFAULT '0000-00-00',
id_autor INT NOT NULL
);


create table Usuario(
id_usuario INT auto_increment primary KEY,
nombre VARCHAR(50) NOT NULL
);

create table Comentarios(
comentarios VARCHAR(550) NOT NULL,
fecha_comentario VARCHAR(550) NOT NULL
);
