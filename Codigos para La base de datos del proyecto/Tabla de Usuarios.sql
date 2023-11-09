CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT(11) NOT NULL primary key,
    nombre_usuario VARCHAR(255) NOT NULL,
    edad VARCHAR(10) NOT NULL,
    estrato VARCHAR(10) NOT NULL
);
