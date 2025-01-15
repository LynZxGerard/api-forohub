CREATE TABLE topicos (
    id SERIAL PRIMARY KEY, -- ID autoincrementable y llave primaria
    titulo VARCHAR(255) NOT NULL, -- Título con un límite de 255 caracteres
    mensaje VARCHAR(255) NOT NULL, -- Mensaje más largo que VARCHAR
    fechacreacion DATE NOT NULL, -- Fecha de creación
    status VARCHAR(50) NOT NULL, -- Status como string, se usará ENUM en Java
    autor VARCHAR(255) NOT NULL, -- Autor con un límite de 255 caracteres
    curso VARCHAR(255) NOT NULL  -- Curso con un límite de 255 caracteres
);
