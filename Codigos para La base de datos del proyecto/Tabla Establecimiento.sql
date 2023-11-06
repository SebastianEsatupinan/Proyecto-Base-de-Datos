CREATE TABLE IF NOT EXISTS establecimiento (
    nit INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    tipo CHAR(1) NOT NULL CHECK(tipo IN ('C', 'E', 'U')), -- C=colegio, E=empresa, U=universidad
	id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);
