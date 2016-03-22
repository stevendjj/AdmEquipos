-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.25 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla datosequipos.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `codigo` int(10) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `estadoInicial` text NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla datosequipos.equipo: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` (`codigo`, `marca`, `modelo`, `tipo`, `estadoInicial`) VALUES
	(123, 'HP', '2015', 'LAPTOP', 'Excelente'),
	(145, 'Acer', '2016', 'LAPTOP', 'Memoria RAM dañada'),
	(234, 'Pepe', '2014', 'PC', 'Bueno'),
	(567, 'Uso carruso original', '2016', 'PC', 'No tiene problemas');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;


-- Volcando estructura para tabla datosequipos.hojavidaeqp
CREATE TABLE IF NOT EXISTS `hojavidaeqp` (
  `codigo` int(11) NOT NULL,
  `memoria` varchar(15) DEFAULT NULL,
  `vel_memoria` varchar(5) DEFAULT NULL,
  `procesador` varchar(50) DEFAULT NULL,
  `vel_procesador` varchar(5) DEFAULT NULL,
  `discoD` varchar(15) DEFAULT NULL,
  `cap_discoD` varchar(5) DEFAULT NULL,
  `sistemaOperativo` varchar(15) DEFAULT NULL,
  `version_so` varchar(15) DEFAULT NULL,
  `paqueteOffice` varchar(15) DEFAULT NULL,
  `version_Office` varchar(7) DEFAULT NULL,
  `antivirus` varchar(15) DEFAULT NULL,
  `otros` varchar(30) DEFAULT NULL,
  `equipo_codigo` int(10),
  PRIMARY KEY (`codigo`),
  KEY `fk_hojaVidaEQP_equipo1_idx` (`equipo_codigo`),
  CONSTRAINT `fk_hojaVidaEQP_equipo1` FOREIGN KEY (`equipo_codigo`) REFERENCES `equipo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla datosequipos.hojavidaeqp: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `hojavidaeqp` DISABLE KEYS */;
INSERT INTO `hojavidaeqp` (`codigo`, `memoria`, `vel_memoria`, `procesador`, `vel_procesador`, `discoD`, `cap_discoD`, `sistemaOperativo`, `version_so`, `paqueteOffice`, `version_Office`, `antivirus`, `otros`, `equipo_codigo`) VALUES
	(256, '2', '45', 'trreth', '34', 'thrd', '345', 'WINDOWS', '8.1', 'SI', '2013', 'nod', '', 145),
	(345, '3Gb', '4Gb', 'Pentium core i8', '7GHz', 'HITACHI 2016', '4TB', 'LINUX', 'ubuntu', 'NO', 'NO', 'ninguno', 'tarjeta grafica NVIDIA AMD 8GB', 234);
/*!40000 ALTER TABLE `hojavidaeqp` ENABLE KEYS */;


-- Volcando estructura para tabla datosequipos.mantenimiento
CREATE TABLE IF NOT EXISTS `mantenimiento` (
  `codigo` int(10) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `resultado` varchar(50) NOT NULL,
  `equipo_codigo` int(10) NOT NULL,
  `responsable_identificacion` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_mantenimiento_equipo_idx` (`equipo_codigo`),
  KEY `fk_mantenimiento_responsable1_idx` (`responsable_identificacion`),
  CONSTRAINT `fk_mantenimiento_equipo` FOREIGN KEY (`equipo_codigo`) REFERENCES `equipo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mantenimiento_responsable1` FOREIGN KEY (`responsable_identificacion`) REFERENCES `responsable` (`identificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla datosequipos.mantenimiento: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
INSERT INTO `mantenimiento` (`codigo`, `fechaIngreso`, `tipo`, `descripcion`, `resultado`, `equipo_codigo`, `responsable_identificacion`) VALUES
	(1, '2016-01-13', 'PREVENTIVO\r\n', 'COMPUTADOR PRESENTABA PROBLEMAS\r\n', 'SE RESOLVIERON LOS PROBLEMAS EXITOSAMENTE', 567, 123),
	(2, '2016-03-02', 'PREVENTIVO', 'aaaaaaa', 'aaaaaaa', 145, 234);
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;


-- Volcando estructura para tabla datosequipos.responsable
CREATE TABLE IF NOT EXISTS `responsable` (
  `identificacion` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  PRIMARY KEY (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla datosequipos.responsable: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
INSERT INTO `responsable` (`identificacion`, `nombre`, `apellido`, `cargo`) VALUES
	(123, 'Steven', 'Hernandez', 'TÉCNOLOGO'),
	(234, 'Carlos Alberto', 'Ballestas Mendoza', 'TÉCNOLOGO');
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
