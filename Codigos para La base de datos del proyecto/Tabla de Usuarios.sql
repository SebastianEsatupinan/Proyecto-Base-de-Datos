CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    edad VARCHAR(10) NOT NULL,
    estrato VARCHAR(10) NOT NULL,
	ubicacion_id INT,
    FOREIGN KEY (ubicacion_id) REFERENCES ubicacion(id)
);
