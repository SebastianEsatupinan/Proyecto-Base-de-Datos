CREATE TABLE registro_reciclaje (
    codigo_regis INT NOT NULL PRIMARY KEY,
    imagen longblob,
    retroalimentacion TEXT,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario)
);
