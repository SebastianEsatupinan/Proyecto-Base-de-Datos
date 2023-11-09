CREATE TABLE IF NOT EXISTS recurso_educativo (
    id INT AUTO_INCREMENT PRIMARY KEY,
	codigo_rec_ed VARCHAR(255) NOT NULL,
    fecha_cargp TIMESTAMP NOT NULL,
    tipo_rec_ed VARCHAR(1) NOT NULL,
    recurso_usuario_id INT,
    FOREIGN KEY (recurso_usuario_id) REFERENCES recurso_usuario(id)
);
