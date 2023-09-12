CREATE TABLE ESTUDIANTE(
    RU_ESTUDIANTE VARCHAR(10) PRIMARY KEY,
    NOM_ESTUDIANTE VARCHAR(20),
    APE_ESTUDIANTE VARCHAR(20),
    SEX_ESTUDIANTE VARCHAR(10),
    FECHAN_ESTUDIANTE DATE,
    DIR_ESTUDIANTE VARCHAR(30),
    GRUP_ESTUDIANTE VARCHAR(2),
	EDAD_ESTUDIANTE INT
);

CREATE TABLE EXAMENTEORICO(
    ID_TEORICO VARCHAR(10) PRIMARY KEY,
    TIT_TEORICO VARCHAR(20),
    NUMPG_TEORICO INT,
    FECHA_TEORICO DATE DEFAULT NULL,
    NOTA_TEORICO INT,
    COD_DOCENTE VARCHAR(10),
    FOREIGN KEY (COD_DOCENTE) REFERENCES DOCENTE(COD_DOCENTE)
);

CREATE TABLE PRACTICA(
    ID_PRACTICO VARCHAR(10) PRIMARY KEY,
    TIT_PRACTICO VARCHAR(20),
    FECHA_PRACTICO DATE,
    GRADODF_PRACTICO VARCHAR(10),
    NOTA_PRACTICO INT
);

CREATE TABLE DOCENTE(
    COD_DOCENTE VARCHAR(10) PRIMARY KEY,
    NOMB_DOCENTE VARCHAR(20),
    APE_DOCENTE VARCHAR(20),
    SEX_DOCENTE VARCHAR(10),
    FECHAN_DOCENTE DATE,
    PROFE_DOCENTE VARCHAR(20),
    DIR_DOCENTE VARCHAR(30)
);

CREATE TABLE DOCENTE_PRACTICA(
    COD_DOCENTE VARCHAR(10),
    ID_PRACTICO VARCHAR(10),
    PRIMARY KEY (COD_DOCENTE, ID_PRACTICO),
    FOREIGN KEY (COD_DOCENTE) REFERENCES DOCENTE(COD_DOCENTE),
    FOREIGN KEY (ID_PRACTICO) REFERENCES PRACTICA(ID_PRACTICO)
);
CREATE TABLE PRACTICA_ESTUDIANTE(
    RU_ESTUDIANTE VARCHAR(10),
    ID_PRACTICO VARCHAR(10),
    PRIMARY KEY (RU_ESTUDIANTE, ID_PRACTICO),
    FOREIGN KEY (RU_ESTUDIANTE) REFERENCES ESTUDIANTE(RU_ESTUDIANTE),
    FOREIGN KEY (ID_PRACTICO) REFERENCES PRACTICA(ID_PRACTICO)
);
CREATE TABLE ESTUDIANTE_TEORICO(
    RU_ESTUDIANTE VARCHAR(10),
    ID_TEORICO VARCHAR(10),
    PRIMARY KEY (RU_ESTUDIANTE, ID_TEORICO),
    FOREIGN KEY (RU_ESTUDIANTE) REFERENCES ESTUDIANTE(RU_ESTUDIANTE),
    FOREIGN KEY (ID_TEORICO) REFERENCES EXAMENTEORICO(ID_TEORICO)
);

INSERT INTO ESTUDIANTE VALUES ('109624', 'Luis', 'Lopez', 'Masculino', '1999-08-12', 'Calle 123, Barrio Centro', 'G1', 18);
INSERT INTO ESTUDIANTE VALUES ('109625', 'María', 'Lopez', 'Femenino', '2000-03-05', 'Avenida Principal 456', 'G2', 23);
INSERT INTO ESTUDIANTE VALUES ('109626', 'José', 'Lopez', 'Masculino', '2001-10-20', 'Calle Nueva 789', 'G3'), 21;
INSERT INTO ESTUDIANTE VALUES ('109627', 'Ana', 'González', 'Femenino', '1998-07-15', 'Calle Sol 789', 'G1', 23);
INSERT INTO ESTUDIANTE VALUES ('109628', 'Pedro', 'Ramirez', 'Masculino', '2002-05-10', 'Avenida del Bosque 234', 'G2', 19);
INSERT INTO ESTUDIANTE VALUES ('109629', 'Lorena', 'Perez', 'Femenino', '2003-01-25', 'Calle Luna 567', 'G3', 20);
INSERT INTO ESTUDIANTE VALUES ('109630', 'Carlos', 'Martínez', 'Masculino', '1999-12-08', 'Avenida Central 789', 'G1', 24);
INSERT INTO ESTUDIANTE VALUES ('109631', 'Sofía', 'Fernández', 'Femenino', '2000-09-18', 'Calle Principal 123', 'G2', 21);
INSERT INTO ESTUDIANTE VALUES ('109632', 'Javier', 'Lopez', 'Masculino', '2001-11-28', 'Calle Nueva 345', 'G3'), 19;
INSERT INTO ESTUDIANTE VALUES ('109633', 'Elena', 'Hernández', 'Femenino', '1999-04-30', 'Avenida del Sol 876', 'G1', 20);

-- Insertar datos en la tabla EXAMENTEORICO
INSERT INTO EXAMENTEORICO VALUES ('TEO001', 'ExamenMatemáticas', 10, '2023-08-25', 85, 'DOC001');
INSERT INTO EXAMENTEORICO VALUES ('TEO002', 'ExamenHistoria', 15, '2023-08-27', 70, 'DOC002');
INSERT INTO EXAMENTEORICO VALUES ('TEO003', 'ExamenCiencias', 12, '2023-08-30', 92, 'DOC003');
INSERT INTO EXAMENTEORICO VALUES ('TEO004', 'ExamenLiteratura', 8, '2023-09-02', 43, 'DOC001');
INSERT INTO EXAMENTEORICO VALUES ('TEO005', 'ExamenGeografía', 10, '2023-09-05', 88, 'DOC002');
INSERT INTO EXAMENTEORICO VALUES ('TEO006', 'ExamenArte', 7, '2023-09-08', 65, 'DOC003');
INSERT INTO EXAMENTEORICO VALUES ('TEO007', 'ExamenMúsica', 6, '2023-09-11', 72, 'DOC001');
INSERT INTO EXAMENTEORICO VALUES ('TEO008', 'ExamenEduFísica', 9, '2023-09-14', 90, 'DOC002');
INSERT INTO EXAMENTEORICO VALUES ('TEO009', 'ExamenInglés', 11, '2023-09-17', 75, 'DOC003');
INSERT INTO EXAMENTEORICO VALUES ('TEO010', 'ExamenTecnología', 13, '2023-09-20', 53, 'DOC001');

-- Insertar datos en la tabla PRACTICA
INSERT INTO PRACTICA VALUES ('PRA001', 'Práctica de Lab 1', '2023-08-25', 'A', 95);
INSERT INTO PRACTICA VALUES ('PRA002', 'Práctica de Lab 2', '2023-08-27', 'B', 88);
INSERT INTO PRACTICA VALUES ('PRA003', 'Práctica de Lab 3', '2023-08-30', 'C', 92);
INSERT INTO PRACTICA VALUES ('PRA004', 'Práctica de Lab 4', '2023-09-02', 'A', 85);
INSERT INTO PRACTICA VALUES ('PRA005', 'Práctica de Lab 5', '2023-09-05', 'B', 90);
INSERT INTO PRACTICA VALUES ('PRA006', 'Práctica de Lab 6', '2023-09-08', 'C', 75);
INSERT INTO PRACTICA VALUES ('PRA007', 'Práctica de Lab 7', '2023-09-11', 'A', 80);
INSERT INTO PRACTICA VALUES ('PRA008', 'Práctica de Lab 8', '2023-09-14', 'B', 87);
INSERT INTO PRACTICA VALUES ('PRA009', 'Práctica de Lab 9', '2023-09-17', 'C', 93);
INSERT INTO PRACTICA VALUES ('PRA010', 'Práctica de Lab 10', '2023-09-20', 'A', 98);

SELECT * FROM PRACTICA;
-- Insertar datos en la tabla DOCENTE
INSERT INTO DOCENTE VALUES ('DOC001', 'Carlos', 'Martínez', 'Masculino', '1978-05-20', 'Matemáticas', 'Calle del Sol 123');
INSERT INTO DOCENTE VALUES ('DOC002', 'Sofía', 'Fernández', 'Femenino', '1985-09-15', 'Historia', 'Avenida de los Pájaros 456');
INSERT INTO DOCENTE VALUES ('DOC003', 'Javier', 'Lopez', 'Masculino', '1976-03-10', 'Ciencias', 'Rincón de las Flores 789');
INSERT INTO DOCENTE VALUES ('DOC004', 'Laura', 'García', 'Femenino', '1982-12-15', 'Química', 'Pasaje del Bosque 234');
INSERT INTO DOCENTE VALUES ('DOC005', 'Miguel', 'Martínez', 'Masculino', '1979-09-25', 'Física', 'Plaza de los Sueños 890');
INSERT INTO DOCENTE VALUES ('DOC006', 'Elena', 'Hernández', 'Femenino', '1984-07-08', 'Biología', 'Camino de las Estrellas 567');
INSERT INTO DOCENTE VALUES ('DOC007', 'José', 'Gómez', 'Masculino', '1975-03-30', 'Historia', 'Carrera de los Delfines 123');
INSERT INTO DOCENTE VALUES ('DOC008', 'María', 'López', 'Femenino', '1980-11-18', 'Matemáticas', 'Paseo de las Mariposas 456');
INSERT INTO DOCENTE VALUES ('DOC009', 'Carlos', 'Fernández', 'Masculino', '1983-02-12', 'Inglés', 'Callejón de las Palmeras 789');
INSERT INTO DOCENTE VALUES ('DOC010', 'Sara', 'Rodríguez', 'Femenino', '1981-06-05', 'Educación Física', 'Avenida de los Cerezos 234');
SELECT * FROM DOCENTE;
-- Insertar datos en la tabla DOCENTE_PRACTICA
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC001', 'PRA001');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC002', 'PRA002');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC003', 'PRA003');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC001', 'PRA004');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC002', 'PRA005');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC003', 'PRA006');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC001', 'PRA007');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC002', 'PRA008');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC003', 'PRA009');
INSERT INTO DOCENTE_PRACTICA VALUES ('DOC001', 'PRA010');

-- Insertar datos en la tabla PRACTICA_ESTUDIANTE
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109624', 'PRA001');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109625', 'PRA002');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109626', 'PRA003');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109627', 'PRA004');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109628', 'PRA005');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109629', 'PRA006');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109630', 'PRA007');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109631', 'PRA008');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109632', 'PRA009');
INSERT INTO PRACTICA_ESTUDIANTE VALUES ('109633', 'PRA010');

-- Insertar datos en la tabla ESTUDIANTE_TEORICO
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109624', 'TEO001');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109625', 'TEO002');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109626', 'TEO003');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109627', 'TEO004');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109628', 'TEO005');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109629', 'TEO006');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109630', 'TEO007');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109631', 'TEO008');
INSERT INTO ESTUDIANTE_TEORICO VALUES ('109632', 'TEO009');
SELECT * FROM ESTUDIANTE_TEORICO;
--7/9/23
SELECT E.NOM_ESTUDIANTE, E.APE_ESTUDIANTE 
FROM ESTUDIANTE E, EXAMENTEORICO NT WHERE NT.NOTA_TEORICO>80;

SELECT E.*, NT.ID_TEORICO
FROM ESTUDIANTE E, EXAMENTEORICO NT WHERE E.EDAD_ESTUDIANTE>20 AND NT.NOTA_TEORICO>50 AND NT.NOTA_TEORICO<85;

SELECT * FROM ESTUDIANTE;
SELECT * FROM DOCENTE;
SELECT * FROM EXAMENTEORICO;
SELECT * FROM ESTUDIANTE_TEORICO;

SELECT E.NOM_ESTUDIANTE
FROM ESTUDIANTE E
ORDER BY E.NOM_ESTUDIANTE;

SELECT E.NOM_ESTUDIANTE
FROM ESTUDIANTE E
ORDER BY E.NOM_ESTUDIANTE DESC;

SELECT E.NOM_ESTUDIANTE
FROM ESTUDIANTE E
ORDER BY E.NOM_ESTUDIANTE ASC;

SELECT E.NOM_ESTUDIANTE, E.APE_ESTUDIANTE
FROM ESTUDIANTE E, PRACTICA PR, PRACTICA_ESTUDIANTE PRE
WHERE E.RU_ESTUDIANTE=PRE.RU_ESTUDIANTE AND PR.ID_PRACTICO=PRE.ID_PRACTICO AND E.GRUP_ESTUDIANTE='G2'
ORDER BY E.NOM_ESTUDIANTE;

SELECT E.NOM_ESTUDIANTE, E.APE_ESTUDIANTE
FROM ESTUDIANTE E, PRACTICA PR, PRACTICA_ESTUDIANTE PRE
WHERE E.RU_ESTUDIANTE=PRE.RU_ESTUDIANTE AND PR.ID_PRACTICO=PRE.ID_PRACTICO
GROUP BY E.NOM_ESTUDIANTE, E.APE_ESTUDIANTE;

SELECT E.NOM_ESTUDIANTE
FROM ESTUDIANTE E, EXAMENTEORICO NT WHERE NT.NOTA_TEORICO>80
GROUP BY E.NOM_ESTUDIANTE;
/* */

--1
SELECT E.NOM_ESTUDIANTE, E.APE_ESTUDIANTE
FROM ESTUDIANTE E, EXAMENTEORICO TEO, ESTUDIANTE_TEORICO ETEO
WHERE E.EDAD_ESTUDIANTE>20 AND E.GRUP_ESTUDIANTE='G2' AND E.RU_ESTUDIANTE=ETEO.RU_ESTUDIANTE AND TEO.ID_TEORICO=ETEO.ID_TEORICO
ORDER BY E.NOM_ESTUDIANTE;

--2
SELECT D.NOMB_DOCENTE
FROM DOCENTE D, EXAMENTEORICO TEO
WHERE D.COD_DOCENTE=TEO.COD_DOCENTE
GROUP BY D.NOMB_DOCENTE;

--3
SELECT D.NOMB_DOCENTE, E.NOM_ESTUDIANTE
FROM ESTUDIANTE E, DOCENTE D, DOCENTE_PRACTICA DP, PRACTICA_ESTUDIANTE EP, PRACTICA PR
WHERE D.COD_DOCENTE=DP.COD_DOCENTE AND E.RU_ESTUDIANTE=EP.RU_ESTUDIANTE
GROUP BY E.NOM_ESTUDIANTE, D.NOMB_DOCENTE;