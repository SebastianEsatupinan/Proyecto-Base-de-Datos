CREATE TABLE IF NOT EXISTS ubicacion (
    codigo_ubi int(50) NOT NULL PRIMARY KEY,
    ciudad VARCHAR(255) NOT NULL,
    barrio VARCHAR(255) NOT NULL,
    departamento VARCHAR(255) NOT NULL,
    codigoU int not null,
    descripcion TEXT,
    FOREIGN KEY (codigoU) REFERENCES usuarios(id_usuario)
);

