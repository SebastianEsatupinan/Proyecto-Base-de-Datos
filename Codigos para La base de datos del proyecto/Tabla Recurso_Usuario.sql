CREATE TABLE IF NOT EXISTS recurso_usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    codigo VARCHAR(255) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    comentario VARCHAR (255),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario)
);