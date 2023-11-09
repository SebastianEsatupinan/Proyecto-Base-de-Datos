CREATE TABLE material (
    codigo_mate INT NOT NULL PRIMARY KEY,
    nombre_mate VARCHAR(255) NOT NULL, 
    tipo_mate VARCHAR(255) NOT NULL, 
    cantidad DOUBLE NOT NULL,
    recomendaciones TEXT,
    codigo_regis INT NOT NULL,
    FOREIGN KEY (codigo_regis) REFERENCES registro_reciclaje(codigo_regis)
);
