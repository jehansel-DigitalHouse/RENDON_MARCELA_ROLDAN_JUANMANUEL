DROP TABLE ODONTOLOGOS IF EXISTS;

CREATE TABLE ODONTOLOGOS (
ID INT AUTO_INCREMENT PRIMARY KEY,
nroMatricula VARCHAR(50) NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
);

INSERT INTO ODONTOLOGOS VALUES (DEFAULT,"12345","Marcela","Rendón");
INSERT INTO ODONTOLOGOS VALUES (DEFAULT,"67890","Juan","Roldán");