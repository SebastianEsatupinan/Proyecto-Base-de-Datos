CREATE TABLE IF NOT EXISTS ubicacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    barrio VARCHAR(255) NOT NULL,
    departamento VARCHAR(255) NOT NULL,
    descripcion TEXT
);

