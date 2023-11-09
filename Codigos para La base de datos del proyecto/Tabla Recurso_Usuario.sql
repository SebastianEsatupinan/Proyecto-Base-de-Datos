CREATE TABLE IF NOT EXISTS recurso_usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_Recurso VARCHAR(255) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    comentario VARCHAR (255),
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario)
);