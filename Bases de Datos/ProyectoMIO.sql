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
	estado_empleado  BOOLEAN NOT NULL,

	CONSTRAINT empleado_pk PRIMARY KEY (cedula_empleado)
);

--Insertamos datos en la tabla EMPLEADO:

INSERT INTO empleado VALUES (1000000, 690000, 'MAURICIO DOMINGUEZ', '1111111', '31-12-1980', 'VIUDO(A)', 'CONDUCTOR(A)', TRUE);
INSERT INTO empleado VALUES (1000001, 690000, 'JESÚS RAMÍREZ', '2222222', '01-01-1990', 'SOLTERO(A)', 'AUXILIAR', TRUE );
INSERT INTO empleado VALUES (1000002, 1500000, 'MARTHA HOLGUIN', '3333333', '01-05-1985', 'CASADO(A)', 'DIRECTOR(A)', TRUE );
INSERT INTO empleado VALUES (1000003, 690000, 'ALEJANDRO MEJÍA', '4444444', '20-10-1970', 'UNIÓN LIBRE', 'CONDUCTOR', TRUE );
INSERT INTO empleado VALUES (1000004, 690000, 'PEPITO PÉREZ', '5555555', '29-02-1988', 'DIVORCIADO(A)', 'CONDUCTOR', TRUE);

----------------------------------------------------------------------

DROP TABLE IF EXISTS ruta CASCADE;

CREATE TABLE ruta
(
	id_ruta INTEGER NOT NULL,
	nombre_ruta VARCHAR(4) NOT NULL,
	estado_ruta BOOLEAN NOT NULL,
	

	CONSTRAINT ruta_pk PRIMARY KEY (id_ruta)
);

--Insertamos datos en la tabla RUTA:

INSERT INTO ruta VALUES (1, 'T31', 'CHIMINANGOS', TRUE);
INSERT INTO ruta VALUES (2, 'T31', 'FLORA INDUSTRIAL', TRUE);
INSERT INTO ruta VALUES (3, 'T31', 'FÁTIMA', TRUE);
INSERT INTO ruta VALUES (1, 'A01', 'CALLE 30 # 15-28', TRUE);
INSERT INTO ruta VALUES (2, 'A01', 'CARRERA 16 # 50-08', TRUE);

---------------------------------------------------------------------

DROP TABLE IF EXISTS distribuidor CASCADE;

CREATE TABLE distribuidor
(
	nit VARCHAR(20) NOT NULL, 
	nombre VARCHAR(50) NOT NULL,
	direccion VARCHAR(50) NOT NULL,
	telefono VARCHAR(10) NOT NULL,
	estado_distribuidor BOOLEAN NOT NULL,

	CONSTRAINT distribuidor_pk PRIMARY KEY (nit)
);

--Insertamos datos en la tabla DISTRIBUIDOR:

INSERT INTO distribuidor VALUES ('1000000', 'GANE', 'CALLE 80 # 5-23', '1111111', TRUE);
INSERT INTO distribuidor VALUES ('1000001', 'BALOTO', 'CALLE 81 # 6-24', '2222222', TRUE);
INSERT INTO distribuidor VALUES ('1000002', 'ÉXITO', 'CALLE 82 # 7-25', '3333333', TRUE);
INSERT INTO distribuidor VALUES ('1000003', 'OLIMPICA', 'CALLE 83 # 8-26', '4444444', TRUE);
INSERT INTO distribuidor VALUES ('1000004', 'SUPER INTER', 'CALLE 84 # 9-27', '5555555', TRUE);

----------------------------------------------------------------------

DROP TABLE IF EXISTS estacion CASCADE;

CREATE TABLE estacion
(
	id_estacion INTEGER NOT NULL,
        nombre_estacion VARCHAR(20)
	direccion VARCHAR(50) NOT NULL,
	cedula_empleado VARCHAR(20) NOT NULL,	
	estado_estacion BOOLEAN NOT NULL,

	CONSTRAINT estacion_pk PRIMARY KEY (id_estacion),

	
);

--Insertamos datos en la tabla ESTACION:

INSERT INTO estacion VALUES (1,'UNIVALLE', 'CARRERA 100 # 16-04', '1000000', TRUE);
INSERT INTO estacion VALUES (2,'CHIMINANGOS', 'CALLE 99 # 17-05', '1000001', TRUE);
INSERT INTO estacion VALUES (3,'UNIDAD DEPORTIVA', 'CARRERA 101 # 15-03', '1000002', TRUE);
INSERT INTO estacion VALUES (4,'BUITRERA', 'CALLE 98 # 18-05', '1000003', TRUE);
INSERT INTO estacion VALUES (5,'CAPRI', 'CARRERA 102 # 14-02', '1000004', TRUE);

----------------------------------------------------------------------

DROP TABLE IF EXISTS parada CASCADE;

CREATE TABLE parada
(
	id_parada INTEGER NOT NULL,
        nombre_parada VARCHAR(20)
	direccion VARCHAR(50) NOT NULL,		
	estado_parada BOOLEAN NOT NULL,

	CONSTRAINT estacion_pk PRIMARY KEY (id_parada),

	
);

--Insertamos datos en la tabla ESTACION:

INSERT INTO estacion VALUES (6,'MELENDEZ', 'CARRERA 1 # 6-04', TRUE);
INSERT INTO estacion VALUES (7,'CALDAS', 'CALLE 9 # 7-05', TRUE);
INSERT INTO estacion VALUES (8,'SILOE', 'CARRERA 10 # 15-03', TRUE);
INSERT INTO estacion VALUES (9,'BELALCAZAR', 'CALLE 8 # 8-05', TRUE);
INSERT INTO estacion VALUES (10,'CALIPSO', 'CARRERA 12 # 
4-02', TRUE);


----------------------------------------------------------------------

DROP TABLE IF EXISTS tarjeta CASCADE;

CREATE TABLE tarjeta
(
	id_tarjeta INTEGER NOT NULL,
	saldo DOUBLE PRECISION NOT NULL,
	estado_tarjeta VARCHAR(8) NOT NULL,
	id_punto_venta INTEGER NOT NULL,
	fecha_venta DATE NOT NULL

	CONSTRAINT tarjeta_pk PRIMARY KEY (id_tarjeta),

	CONSTRAINT tarjeta_fk1 FOREIGN KEY (id_punto_venta) 
	REFERENCES estacion (id_estacion),

	CONSTRAINT tarjeta_fk2 FOREIGN KEY (id_punto_venta) 
	REFERENCES sucursal (nit)
);

---------------------------------------------------------------------

DROP TABLE IF EXISTS usuario CASCADE;

CREATE TABLE usuario
(
	cedula_usuario VARCHAR(20) NOT NULL,
	id_tarjeta INTEGER NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	telefono VARCHAR(10),
	direccion VARCHAR(50),
	estado_usuario BOOLEAN NOT NULL,
	
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
	id_ruta INTEGER NOT NULL,	
	estado_bus BOOLEAN NOT NULL,

	CONSTRAINT bus_pk PRIMARY KEY (placa_bus),

	CONSTRAINT bus_fk FOREIGN KEY (id_ruta)
	REFERENCES ruta (id_ruta) 
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
	eliminada CHAR NOT NULL,

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
	eliminado CHAR NOT NULL,

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
	eliminado CHAR NOT NULL,	

	CONSTRAINT conduce_pk PRIMARY KEY (cedula_empleado, placa_bus),

	CONSTRAINT conduce_fk1 FOREIGN KEY (cedula_empleado)
	REFERENCES empleado (cedula_empleado), 

	CONSTRAINT conduce_fk2 FOREIGN KEY (placa_bus)
	REFERENCES bus (placa_bus) 
);
