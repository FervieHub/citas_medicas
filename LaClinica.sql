#
# DUMP FILE
#
# Database is ported from MS Access
#------------------------------------------------------------------
# Created using "MS Access to MySQL" form http://www.bullzip.com
# Program Version 5.5.282
#
# OPTIONS:
#   sourcefilename=C:/TareaG7_New/clinicaG7.accdb
#   sourceusername=
#   sourcepassword=
#   sourcesystemdatabase=
#   destinationdatabase=movedb
#   storageengine=MyISAM
#   dropdatabase=0
#   createtables=1
#   unicode=1
#   autocommit=1
#   transferdefaultvalues=1
#   transferindexes=1
#   transferautonumbers=1
#   transferrecords=1
#   columnlist=1
#   tableprefix=
#   negativeboolean=0
#   ignorelargeblobs=0
#   memotype=
#   datetimetype=
#

CREATE DATABASE IF NOT EXISTS `clinica`;
USE `clinica`;

#
# Table structure for table 'tbl_cita'
#

DROP TABLE IF EXISTS `tbl_cita`;

CREATE TABLE `tbl_cita` (
  `id_cita` INTEGER NOT NULL AUTO_INCREMENT, 
  `id_personal` INTEGER DEFAULT 0, 
  `id_paciente` INTEGER DEFAULT 0, 
  `id_turno` INTEGER DEFAULT 0, 
  `cita_fecha` VARCHAR(10), 
  `id_horario` INTEGER DEFAULT 0, 
  `cita_observacion` VARCHAR(255), 
  `cita_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_cita`), 
  INDEX (`id_horario`), 
  INDEX (`id_personal`), 
  INDEX (`id_paciente`), 
  INDEX (`id_turno`), 
  PRIMARY KEY (`id_cita`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_cita'
#

INSERT INTO `tbl_cita` (`id_cita`, `id_personal`, `id_paciente`, `id_turno`, `cita_fecha`, `id_horario`, `cita_observacion`, `cita_estado`) VALUES (2, 3, 1, 1, '15/10/2022', 8, NULL, 0);
INSERT INTO `tbl_cita` (`id_cita`, `id_personal`, `id_paciente`, `id_turno`, `cita_fecha`, `id_horario`, `cita_observacion`, `cita_estado`) VALUES (3, 3, 1, 1, '15/10/2022', 6, NULL, 0);
INSERT INTO `tbl_cita` (`id_cita`, `id_personal`, `id_paciente`, `id_turno`, `cita_fecha`, `id_horario`, `cita_observacion`, `cita_estado`) VALUES (4, 3, 2, 1, '15/10/2022', 10, NULL, 0);
INSERT INTO `tbl_cita` (`id_cita`, `id_personal`, `id_paciente`, `id_turno`, `cita_fecha`, `id_horario`, `cita_observacion`, `cita_estado`) VALUES (5, 3, 2, 1, '15/10/2022', 9, NULL, 0);
INSERT INTO `tbl_cita` (`id_cita`, `id_personal`, `id_paciente`, `id_turno`, `cita_fecha`, `id_horario`, `cita_observacion`, `cita_estado`) VALUES (6, 3, 2, 1, '1610/2022', 5, NULL, 0);
INSERT INTO `tbl_cita` (`id_cita`, `id_personal`, `id_paciente`, `id_turno`, `cita_fecha`, `id_horario`, `cita_observacion`, `cita_estado`) VALUES (7, 3, 2, 1, '15/01/2023', 9, NULL, 0);
INSERT INTO `tbl_cita` (`id_cita`, `id_personal`, `id_paciente`, `id_turno`, `cita_fecha`, `id_horario`, `cita_observacion`, `cita_estado`) VALUES (8, 3, 2, 1, '24-05-2023', 2, NULL, 0);
# 7 records

#
# Table structure for table 'tbl_distrito'
#

DROP TABLE IF EXISTS `tbl_distrito`;

CREATE TABLE `tbl_distrito` (
  `id_distrito` INTEGER NOT NULL AUTO_INCREMENT, 
  `distrito_nombre` VARCHAR(60), 
  `distrito_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_distrito`), 
  PRIMARY KEY (`id_distrito`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_distrito'
#

INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (1, 'ANCÓN', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (2, 'ATE VITARTE', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (3, 'BARRANCO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (4, 'BELLAVISTA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (5, 'BREÑA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (6, 'CALLAO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (7, 'CARABAYLLO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (8, 'CARMEN DE LA LEGUA REYNOSO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (9, 'CHACLACAYO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (10, 'CHORRILLOS', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (11, 'CIENEGUILLA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (12, 'COMAS', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (13, 'EL AGUSTINO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (14, 'INDEPENDENCIA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (15, 'JESÚS MARÍA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (16, 'LA MOLINA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (17, 'LA PERLA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (18, 'LA PUNTA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (19, 'LA VICTORIA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (20, 'LIMA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (21, 'LINCE', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (22, 'LOS OLIVOS', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (23, 'LURIGANCHO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (24, 'LURÍN', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (25, 'MAGDALENA DEL MAR', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (26, 'MIRAFLORES', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (27, 'PACHACAMAC', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (28, 'PUCUSANA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (29, 'PUEBLO LIBRE', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (30, 'PUENTE PIEDRA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (31, 'PUNTA HERMOSA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (32, 'PUNTA NEGRA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (33, 'RÍMAC', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (34, 'SAN BARTOLO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (35, 'SAN BORJA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (36, 'SAN ISIDRO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (37, 'SAN JUAN DE LURIGANCHO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (38, 'SAN JUAN DE MIRAFLORES', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (39, 'SAN LUIS', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (40, 'SAN MARTÍN DE PORRES', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (41, 'SAN MIGUEL', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (42, 'SANTA ANITA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (43, 'SANTA MARÍA DEL MAR', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (44, 'SANTA ROSA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (45, 'SANTIAGO DE SURCO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (46, 'SURQUILLO', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (47, 'VENTANILLA', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (48, 'VILLA EL SALVADOR', 1);
INSERT INTO `tbl_distrito` (`id_distrito`, `distrito_nombre`, `distrito_estado`) VALUES (49, 'VILLA MARÍA DEL TRIUNFO', 1);
# 49 records

#
# Table structure for table 'tbl_especialidad'
#

DROP TABLE IF EXISTS `tbl_especialidad`;

CREATE TABLE `tbl_especialidad` (
  `id_especialidad` INTEGER NOT NULL AUTO_INCREMENT, 
  `especialidad_nombre` VARCHAR(100), 
  `especialidad_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_especialidad`), 
  PRIMARY KEY (`id_especialidad`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_especialidad'
#

INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (12, 'MEDICINA GENERAL', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (1, '(NINGUNO)', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (2, 'ALERGOLOGÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (3, 'ANESTESIOLOGÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (4, 'CARDIOLOGÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (5, 'CIRUGÍA GENERAL', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (6, 'DERMATOLOGÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (7, 'ENDOCRINOLOGÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (8, 'ENFERMEDADES INFECCIOSAS', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (9, 'GASTROENTEROLOGÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (10, 'GERIATRÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (11, 'IMMUNOLOGÍA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (14, 'NEUROCIRUGIA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (15, 'PSICOLOGIA', 1);
INSERT INTO `tbl_especialidad` (`id_especialidad`, `especialidad_nombre`, `especialidad_estado`) VALUES (17, 'PEDRIATRIA', 1);
# 15 records

#
# Table structure for table 'tbl_genero'
#

DROP TABLE IF EXISTS `tbl_genero`;

CREATE TABLE `tbl_genero` (
  `id_genero` INTEGER NOT NULL AUTO_INCREMENT, 
  `genero_codigo` VARCHAR(10), 
  `genero_nombre` VARCHAR(20), 
  `genero_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_genero`), 
  PRIMARY KEY (`id_genero`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_genero'
#

INSERT INTO `tbl_genero` (`id_genero`, `genero_codigo`, `genero_nombre`, `genero_estado`) VALUES (1, 'M', 'MASCULINO', 1);
INSERT INTO `tbl_genero` (`id_genero`, `genero_codigo`, `genero_nombre`, `genero_estado`) VALUES (2, 'F', 'FEMENINO', 1);
INSERT INTO `tbl_genero` (`id_genero`, `genero_codigo`, `genero_nombre`, `genero_estado`) VALUES (3, 'O', 'OTRO', 1);
# 3 records

#
# Table structure for table 'tbl_horario'
#

DROP TABLE IF EXISTS `tbl_horario`;

CREATE TABLE `tbl_horario` (
  `Id_horario` INTEGER NOT NULL AUTO_INCREMENT, 
  `id_turno` INTEGER DEFAULT 0, 
  `horario_inicio` VARCHAR(5), 
  `horario_fin` VARCHAR(5), 
  PRIMARY KEY (`Id_horario`), 
  INDEX (`id_turno`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_horario'
#

INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (2, 1, '08:20', '08:40');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (3, 1, '08:40', '09:00');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (4, 1, '09:00', '09:20');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (5, 1, '09:20', '09:40');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (6, 1, '09:40', '10:00');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (7, 1, '10:00', '10:20');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (8, 1, '10:20', '10:40');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (9, 1, '10:40', '11:00');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (10, 1, '11:00', '11:20');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (11, 1, '11:20', '11:40');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (12, 1, '11:40', '12:00');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (13, 2, '12:00', '12:20');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (14, 2, '12:20', '12:40');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (15, 2, '12:40', '01:00');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (16, 2, '02:00', '02:20');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (24, 2, '02:20', '02:40');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (25, 2, '02:40', '03:00');
INSERT INTO `tbl_horario` (`Id_horario`, `id_turno`, `horario_inicio`, `horario_fin`) VALUES (1, 1, '08:00', '08:20');
# 18 records

#
# Table structure for table 'tbl_paciente'
#

DROP TABLE IF EXISTS `tbl_paciente`;

CREATE TABLE `tbl_paciente` (
  `id_paciente` INTEGER NOT NULL AUTO_INCREMENT, 
  `paciente_nombre` VARCHAR(20), 
  `paciente_paterno` VARCHAR(20), 
  `paciente_materno` VARCHAR(20), 
  `id_genero` INTEGER DEFAULT 0, 
  `paciente_fechanacimiento` VARCHAR(20), 
  `id_tipodocumento` INTEGER DEFAULT 0, 
  `paciente_numero` VARCHAR(20), 
  `id_distrito` INTEGER DEFAULT 0, 
  `paciente_direccion` VARCHAR(255), 
  `paciente_telefono` VARCHAR(20), 
  `paciente_celular` VARCHAR(20), 
  `paciente_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_distrito`), 
  INDEX (`id_tipodocumento`), 
  INDEX (`id_genero`), 
  INDEX (`id_paciente`), 
  PRIMARY KEY (`id_paciente`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_paciente'
#

INSERT INTO `tbl_paciente` (`id_paciente`, `paciente_nombre`, `paciente_paterno`, `paciente_materno`, `id_genero`, `paciente_fechanacimiento`, `id_tipodocumento`, `paciente_numero`, `id_distrito`, `paciente_direccion`, `paciente_telefono`, `paciente_celular`, `paciente_estado`) VALUES (1, 'ANDREA', 'VELEZ', 'UGARTE', 2, '', 2, '14785200', 3, 'XD', '', '', 1);
INSERT INTO `tbl_paciente` (`id_paciente`, `paciente_nombre`, `paciente_paterno`, `paciente_materno`, `id_genero`, `paciente_fechanacimiento`, `id_tipodocumento`, `paciente_numero`, `id_distrito`, `paciente_direccion`, `paciente_telefono`, `paciente_celular`, `paciente_estado`) VALUES (2, 'FERNANDO', 'VIERA', 'VÁSQUEZ', 1, '11-05-2023', 2, '41325257', 25, 'JR AMAZONAS', '', '981093572', 1);
INSERT INTO `tbl_paciente` (`id_paciente`, `paciente_nombre`, `paciente_paterno`, `paciente_materno`, `id_genero`, `paciente_fechanacimiento`, `id_tipodocumento`, `paciente_numero`, `id_distrito`, `paciente_direccion`, `paciente_telefono`, `paciente_celular`, `paciente_estado`) VALUES (3, 'JUAN', 'PEREZ', 'VEGA', 1, '11-05-2023', 2, '12345678', 4, 'DDDDDD', '', '99999999', 1);
INSERT INTO `tbl_paciente` (`id_paciente`, `paciente_nombre`, `paciente_paterno`, `paciente_materno`, `id_genero`, `paciente_fechanacimiento`, `id_tipodocumento`, `paciente_numero`, `id_distrito`, `paciente_direccion`, `paciente_telefono`, `paciente_celular`, `paciente_estado`) VALUES (4, 'MARIA', '122', '324234', 2, '12-02-2019', 3, 'BGGB', 3, 'ASDASD', 'ASDAS D', '9888', 0);
# 4 records

#
# Table structure for table 'tbl_perfil'
#

DROP TABLE IF EXISTS `tbl_perfil`;

CREATE TABLE `tbl_perfil` (
  `id_perfil` INTEGER NOT NULL AUTO_INCREMENT, 
  `perfil_descripcion` VARCHAR(255), 
  `perfil_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_perfil`), 
  PRIMARY KEY (`id_perfil`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_perfil'
#

INSERT INTO `tbl_perfil` (`id_perfil`, `perfil_descripcion`, `perfil_estado`) VALUES (1, 'ADMINISTRATIVO', 1);
INSERT INTO `tbl_perfil` (`id_perfil`, `perfil_descripcion`, `perfil_estado`) VALUES (2, 'MEDICO', 1);
INSERT INTO `tbl_perfil` (`id_perfil`, `perfil_descripcion`, `perfil_estado`) VALUES (6, 'PACIENTE', 1);
INSERT INTO `tbl_perfil` (`id_perfil`, `perfil_descripcion`, `perfil_estado`) VALUES (7, 'OPERADOR', 0);
# 4 records

#
# Table structure for table 'tbl_personal'
#

DROP TABLE IF EXISTS `tbl_personal`;

CREATE TABLE `tbl_personal` (
  `id_personal` INTEGER NOT NULL AUTO_INCREMENT, 
  `id_perfil` INTEGER DEFAULT 0, 
  `id_especialidad` INTEGER DEFAULT 0, 
  `personal_nombre` VARCHAR(20), 
  `personal_paterno` VARCHAR(20), 
  `personal_materno` VARCHAR(20), 
  `id_genero` INTEGER DEFAULT 0, 
  `personal_fechanacimiento` VARCHAR(20), 
  `id_tipodocumento` INTEGER DEFAULT 0, 
  `personal_numero` VARCHAR(20), 
  `id_distrito` INTEGER DEFAULT 0, 
  `personal_direccion` VARCHAR(255), 
  `personal_telefono` VARCHAR(20), 
  `personal_celular` VARCHAR(20), 
  `personal_correo` VARCHAR(150), 
  `personal_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_distrito`), 
  INDEX (`id_especialidad`), 
  INDEX (`id_genero`), 
  INDEX (`id_personal`), 
  INDEX (`id_tipodocumento`), 
  INDEX (`id_perfil`), 
  PRIMARY KEY (`id_personal`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_personal'
#

INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (1, 1, 1, 'ADMINISTRADOR', 'DEL SISTEMA', 'DE CITAS', 1, '09-10-1987', 1, '12345678', 1, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (3, 2, 2, 'JUAN', 'SARMIENTO', 'A', 1, '11-05-2023', 2, '65432100', 6, '', '', '', '', 1);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (4, 2, 2, 'JOSE', 'PEREZ', 'UGARTE', 1, '', 2, '65432101', 6, '', '', '', '', 0);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (5, 1, 1, 'KIMBERLY', 'JAVIER DIAS', 'X', 1, '', 3, '88888888', 34, 'DIRECCC', '', '', '', 1);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (6, 1, 1, 'MIGUEL', 'UGAARTE', 'F', 1, '01-05-2023', 2, '88888880', 6, '', '', '', '', 0);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (7, 2, 14, 'LUIS DAVID', 'VIERA', 'MACO', 1, '10-04-2027', 2, '17171717', 25, 'JR AMAZONAS 351', '', '981093572', 'LUISDAVIE@GMAIL.COM', 1);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (8, 2, 15, 'MARIA', 'VIERA', 'MACO', 2, '20-03-2008', 2, '71717171', 25, 'JR AMAZONAS 351', '', '981093572', 'MAFER@GMAIL.COM', 1);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (9, 2, 4, 'MEDIDO DE PRUEBA', 'APELLIDOS', 'MATERNBOI', 1, '13-02-2019', 2, '11111112', 1, 'ANCOSSSS', 'teleq', '999999', 'JUAN@PEREZ.COM', 1);
INSERT INTO `tbl_personal` (`id_personal`, `id_perfil`, `id_especialidad`, `personal_nombre`, `personal_paterno`, `personal_materno`, `id_genero`, `personal_fechanacimiento`, `id_tipodocumento`, `personal_numero`, `id_distrito`, `personal_direccion`, `personal_telefono`, `personal_celular`, `personal_correo`, `personal_estado`) VALUES (10, 2, 17, 'LUIS DAVID', 'VIERA', 'MACO', 1, '22-05-1998', 2, '11111118', 4, 'JR AMAZONAS 351', '99985858', '25325625', 'DAVID@GMAIL.COM', 1);
# 9 records

#
# Table structure for table 'tbl_tipodocumento'
#

DROP TABLE IF EXISTS `tbl_tipodocumento`;

CREATE TABLE `tbl_tipodocumento` (
  `id_tipodocumento` INTEGER NOT NULL AUTO_INCREMENT, 
  `tipodocumento_nombre` VARCHAR(10), 
  `tipodocumento_descripcion` VARCHAR(40), 
  `tipodocumento_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_tipodocumento`), 
  PRIMARY KEY (`id_tipodocumento`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_tipodocumento'
#

INSERT INTO `tbl_tipodocumento` (`id_tipodocumento`, `tipodocumento_nombre`, `tipodocumento_descripcion`, `tipodocumento_estado`) VALUES (1, 'P.N.', 'PARTIDA DE NACIMIENTO', 1);
INSERT INTO `tbl_tipodocumento` (`id_tipodocumento`, `tipodocumento_nombre`, `tipodocumento_descripcion`, `tipodocumento_estado`) VALUES (2, 'D.N.I.', 'DOCUMENTO NACIONAL DE IDENTIDAD', 1);
INSERT INTO `tbl_tipodocumento` (`id_tipodocumento`, `tipodocumento_nombre`, `tipodocumento_descripcion`, `tipodocumento_estado`) VALUES (3, 'C.E.', 'CARNET DE EXTRANJERIA', 1);
# 3 records

#
# Table structure for table 'tbl_turno'
#

DROP TABLE IF EXISTS `tbl_turno`;

CREATE TABLE `tbl_turno` (
  `id_turno` INTEGER NOT NULL AUTO_INCREMENT, 
  `turno_codigo` VARCHAR(5), 
  `turno_nombre` VARCHAR(20), 
  `turno_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_turno`), 
  PRIMARY KEY (`id_turno`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_turno'
#

INSERT INTO `tbl_turno` (`id_turno`, `turno_codigo`, `turno_nombre`, `turno_estado`) VALUES (1, 'M', 'MAÑANA', 1);
INSERT INTO `tbl_turno` (`id_turno`, `turno_codigo`, `turno_nombre`, `turno_estado`) VALUES (2, 'T', 'TARDE', 1);
INSERT INTO `tbl_turno` (`id_turno`, `turno_codigo`, `turno_nombre`, `turno_estado`) VALUES (3, 'N', 'NOCHE', 0);
# 3 records

#
# Table structure for table 'tbl_usuario'
#

DROP TABLE IF EXISTS `tbl_usuario`;

CREATE TABLE `tbl_usuario` (
  `id_usuario` INTEGER NOT NULL AUTO_INCREMENT, 
  `id_personal` INTEGER DEFAULT 0, 
  `usuario_nombre` VARCHAR(20), 
  `usuario_contrasena` VARCHAR(100), 
  `usuario_estado` TINYINT(1) DEFAULT 0, 
  INDEX (`id_personal`), 
  PRIMARY KEY (`id_usuario`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'tbl_usuario'
#

INSERT INTO `tbl_usuario` (`id_usuario`, `id_personal`, `usuario_nombre`, `usuario_contrasena`, `usuario_estado`) VALUES (1, 1, 'ADMIN', 'ADMIN', 1);
INSERT INTO `tbl_usuario` (`id_usuario`, `id_personal`, `usuario_nombre`, `usuario_contrasena`, `usuario_estado`) VALUES (2, 5, 'KIMBERLY', '1234', 0);
# 2 records

