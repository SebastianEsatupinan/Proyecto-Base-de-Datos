CREATE TABLE IF NOT EXISTS establecimiento (
    nit INT NOT NULL PRIMARY KEY,
    nombre_estab VARCHAR(255) NOT NULL,
    tipo CHAR(1) NOT NULL CHECK(tipo IN ('C', 'E', 'U')), -- C=colegio, E=empresa, U=universidad
	id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);
