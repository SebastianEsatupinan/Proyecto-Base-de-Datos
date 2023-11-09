CREATE TABLE IF NOT EXISTS ubicacion (
    codigo_ubi INT(11) NOT NULL PRIMARY KEY,
    ciudad VARCHAR(255) NOT NULL,
    barrio VARCHAR(255) NOT NULL,
    departamento VARCHAR(255) NOT NULL,
    descripcion TEXT,
    codigoU INT(11) NOT NULL,
    FOREIGN KEY (codigoU) REFERENCES usuarios(id_usuario)
);
