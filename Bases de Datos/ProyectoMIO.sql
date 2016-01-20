DROP TABLE IF EXISTS empleado CASCADE;

CREATE TABLE empleado
(
	cedula_empleado VARCHAR(20) NOT NULL,
	salario DOUBLE PRECISION NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	telefono VARCHAR(10),
	fecha_nacimiento DATE,
	estado_civil VARCHAR(13),
	cargo VARCHAR(12) NOT NULL,

	CONSTRAINT empleado_pk PRIMARY KEY (cedula_empleado)
);

--Insertamos datos en la tabla EMPLEADO:

INSERT INTO empleado VALUES (1000000, 690000, 'MAURICIO DOMINGUEZ', '1111111', '31-12-1980', 'VIUDO(A)', 'CONDUCTOR(A)');
INSERT INTO empleado VALUES (1000001, 690000, 'JESÚS RAMÍREZ', '2222222', '01-01-1990', 'SOLTERO(A)', 'AUXILIAR');
INSERT INTO empleado VALUES (1000002, 1500000, 'MARTHA HOLGUIN', '3333333', '01-05-1985', 'CASADO(A)', 'DIRECTOR(A)');
INSERT INTO empleado VALUES (1000003, 690000, 'ALEJANDRO MEJÍA', '4444444', '20-10-1970', 'UNIÓN LIBRE', 'CONDUCTOR');
INSERT INTO empleado VALUES (1000004, 690000, 'PEPITO PÉREZ', '5555555', '29-02-1988', 'DIVORCIADO(A)', 'CONDUCTOR');

----------------------------------------------------------------------

DROP TABLE IF EXISTS ruta CASCADE;

CREATE TABLE ruta
(
	parada_ruta INTEGER NOT NULL,
	nombre_ruta VARCHAR(4) NOT NULL,
	lugar VARCHAR(50) NOT NULL,

	CONSTRAINT ruta_pk PRIMARY KEY (parada_ruta, nombre_ruta)
);

--Insertamos datos en la tabla RUTA:

INSERT INTO ruta VALUES (1, 'T31', 'CHIMINANGOS');
INSERT INTO ruta VALUES (2, 'T31', 'FLORA INDUSTRIAL');
INSERT INTO ruta VALUES (3, 'T31', 'FÁTIMA');
INSERT INTO ruta VALUES (1, 'A01', 'CALLE 30 # 15-28');
INSERT INTO ruta VALUES (2, 'A01', 'CARRERA 16 # 50-08');

---------------------------------------------------------------------

DROP TABLE IF EXISTS distribuidor CASCADE;

CREATE TABLE distribuidor
(
	nit VARCHAR(20) NOT NULL, 
	nombre VARCHAR(50) NOT NULL,
	direccion VARCHAR(50) NOT NULL,
	telefono VARCHAR(10) NOT NULL,

	CONSTRAINT distribuidor_pk PRIMARY KEY (nit)
);

--Insertamos datos en la tabla DISTRIBUIDOR:

INSERT INTO distribuidor VALUES ('1000000', 'GANE', 'CALLE 80 # 5-23', '1111111');
INSERT INTO distribuidor VALUES ('1000001', 'BALOTO', 'CALLE 81 # 6-24', '2222222');
INSERT INTO distribuidor VALUES ('1000002', 'ÉXITO', 'CALLE 82 # 7-25', '3333333');
INSERT INTO distribuidor VALUES ('1000003', 'OLIMPICA', 'CALLE 83 # 8-26', '4444444');
INSERT INTO distribuidor VALUES ('1000004', 'SUPER INTER', 'CALLE 84 # 9-27', '5555555');

----------------------------------------------------------------------

DROP TABLE IF EXISTS estacion CASCADE;

CREATE TABLE estacion
(
	nombre_estacion VARCHAR(20) NOT NULL,
	direccion VARCHAR(50) NOT NULL,
	cedula_empleado VARCHAR(20) NOT NULL,
	parada_ruta INTEGER NOT NULL,
	nombre_ruta VARCHAR(50) NOT NULL,

	CONSTRAINT estacion_pk PRIMARY KEY (nombre_estacion),

	CONSTRAINT estacion_fk1 FOREIGN KEY (cedula_empleado)
	REFERENCES empleado (cedula_empleado),

	CONSTRAINT estacion_fk2 FOREIGN KEY (parada_ruta, nombre_ruta)
	REFERENCES ruta (parada_ruta, nombre_ruta)
);

--Insertamos datos en la tabla ESTACION:

INSERT INTO estacion VALUES ('UNIVALLE', 'CARRERA 100 # 16-04', '1000000', '01', 'T31');
INSERT INTO estacion VALUES ('CHIMINANGOS', 'CALLE 99 # 17-05', '1000001', '02', 'T31');
INSERT INTO estacion VALUES ('UNIDAD DEPORTIVA', 'CARRERA 101 # 15-03', '1000002', '03', 'T31');
INSERT INTO estacion VALUES ('BUITRERA', 'CALLE 98 # 18-05', '1000003', '01', 'A01');
INSERT INTO estacion VALUES ('CAPRI', 'CARRERA 102 # 14-02', '1000004', '02', 'A01');

----------------------------------------------------------------------

DROP TABLE IF EXISTS tarjeta CASCADE;

CREATE TABLE tarjeta
(
	id_tarjeta VARCHAR(20) NOT NULL,
	saldo DOUBLE PRECISION NOT NULL,
	estado VARCHAR(8) NOT NULL,
	punto_venta VARCHAR(20) NOT NULL,

	CONSTRAINT tarjeta_pk PRIMARY KEY (id_tarjeta),

	CONSTRAINT tarjeta_fk1 FOREIGN KEY (punto_venta) 
	REFERENCES estacion (nombre_estacion),

	CONSTRAINT tarjeta_fk2 FOREIGN KEY (punto_venta) 
	REFERENCES distribuidor (nit)
);

---------------------------------------------------------------------

DROP TABLE IF EXISTS usuario CASCADE;

CREATE TABLE usuario
(
	cedula_usuario VARCHAR(20) NOT NULL,
	id_tarjeta VARCHAR(20) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	telefono VARCHAR(10),
	direccion VARCHAR(50),
	
	CONSTRAINT usuario_pk PRIMARY KEY (cedula_usuario),

	CONSTRAINT usuario_fk FOREIGN KEY (id_tarjeta) 
	REFERENCES tarjeta (id_tarjeta)
);

---------------------------------------------------------------------

DROP TABLE IF EXISTS bus CASCADE;

CREATE TABLE bus
(
	placa_bus VARCHAR(20) NOT NULL,
	modelo VARCHAR(4),
	marca VARCHAR(20),
	capacidad INTEGER,
	tipo VARCHAR(13) NOT NULL,
	parada_ruta INTEGER NOT NULL,
	nombre_ruta VARCHAR(4) NOT NULL,

	CONSTRAINT bus_pk PRIMARY KEY (placa_bus),

	CONSTRAINT bus_fk FOREIGN KEY (parada_ruta, nombre_ruta)
	REFERENCES ruta (parada_ruta, nombre_ruta) 
);

---------------------------------------------------------------------

DROP TABLE IF EXISTS pqrs CASCADE;

CREATE TABLE pqrs
(
	id_pqrs INTEGER NOT NULL,
	cedula_empleado VARCHAR(20) NOT NULL,
	nombre_estacion VARCHAR(50) NOT NULL,
	estado VARCHAR(20),
	fecha DATE NOT NULL,
	motivo VARCHAR(100) NOT NULL,
	cedula_usuario VARCHAR(50) NOT NULL,
	descripcion VARCHAR(100),

	CONSTRAINT pqrs_pk PRIMARY KEY (id_pqrs),

	CONSTRAINT pqrs_fk1 FOREIGN KEY (cedula_empleado)
	REFERENCES empleado (cedula_empleado),

	CONSTRAINT pqrs_fk2 FOREIGN KEY (nombre_estacion)
	REFERENCES estacion (nombre_estacion)
);

---------------------------------------------------------------------

DROP TABLE IF EXISTS usa CASCADE;

CREATE TABLE usa
(
	id_usa INTEGER NOT NULL,
	id_tarjeta VARCHAR(20) NOT NULL,
	parada_ruta INTEGER NOT NULL,
	nombre_ruta VARCHAR(4) NOT NULL, 
	fecha DATE NOT NULL,

	CONSTRAINT usa_pk PRIMARY KEY (id_usa),

	CONSTRAINT usa_fk1 FOREIGN KEY (id_tarjeta)
	REFERENCES tarjeta (id_tarjeta),

	CONSTRAINT usa_fk2 FOREIGN KEY (parada_ruta, nombre_ruta)
	REFERENCES ruta (parada_ruta, nombre_ruta)
);

---------------------------------------------------------------------

DROP TABLE IF EXISTS conduce CASCADE;

CREATE TABLE conduce
(
	cedula_empleado VARCHAR(20) NOT NULL, 
	placa_bus VARCHAR(20) NOT NULL,
	fecha DATE NOT NULL,
	horaEntrada TIME(0) NOT NULL,
	horaSalida TIME(0) NOT NULL,	

	CONSTRAINT conduce_pk PRIMARY KEY (cedula_empleado, placa_bus),

	CONSTRAINT conduce_fk1 FOREIGN KEY (cedula_empleado)
	REFERENCES empleado (cedula_empleado), 

	CONSTRAINT conduce_fk2 FOREIGN KEY (placa_bus)
	REFERENCES bus (placa_bus) 
);
