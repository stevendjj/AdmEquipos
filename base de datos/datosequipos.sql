-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-03-2016 a las 21:11:57
-- Versión del servidor: 5.6.25
-- Versión de PHP: 5.5.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `datosequipos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `codigo` int(10) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `estadoInicial` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`codigo`, `marca`, `modelo`, `tipo`, `estadoInicial`) VALUES
(123, 'HP', '2015', 'LAPTOP', 'Excelente'),
(145, 'Acer', '2016', 'LAPTOP', 'Memoria RAM dañada'),
(234, 'Pepe', '2014', 'PC', 'Bueno'),
(567, 'Uso carruso original', '2016', 'PC', 'No tiene problemas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hojavidaeqp`
--

CREATE TABLE IF NOT EXISTS `hojavidaeqp` (
  `codigo` int(11) NOT NULL,
  `memoria` varchar(15) DEFAULT NULL,
  `vel_memoria` varchar(5) DEFAULT NULL,
  `procesador` varchar(15) DEFAULT NULL,
  `vel_procesador` varchar(5) DEFAULT NULL,
  `discoD` varchar(15) DEFAULT NULL,
  `cap_discoD` varchar(5) DEFAULT NULL,
  `sistemaOperativo` varchar(15) DEFAULT NULL,
  `version_so` varchar(15) DEFAULT NULL,
  `paqueteOffice` varchar(15) DEFAULT NULL,
  `version_Office` varchar(7) DEFAULT NULL,
  `antivirus` varchar(15) DEFAULT NULL,
  `otros` varchar(30) DEFAULT NULL,
  `equipo_codigo` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento`
--

CREATE TABLE IF NOT EXISTS `mantenimiento` (
  `codigo` int(10) NOT NULL,
  `fechaIngreso` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tipo` varchar(15) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `resultado` varchar(50) NOT NULL,
  `equipo_codigo` int(10) NOT NULL,
  `responsable_identificacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsable`
--

CREATE TABLE IF NOT EXISTS `responsable` (
  `identificacion` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `cargo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `responsable`
--

INSERT INTO `responsable` (`identificacion`, `nombre`, `apellido`, `cargo`) VALUES
(123, 'Steven', 'Hernandez', 'TÉCNOLOGO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `hojavidaeqp`
--
ALTER TABLE `hojavidaeqp`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_hojaVidaEQP_equipo1_idx` (`equipo_codigo`);

--
-- Indices de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_mantenimiento_equipo_idx` (`equipo_codigo`),
  ADD KEY `fk_mantenimiento_responsable1_idx` (`responsable_identificacion`);

--
-- Indices de la tabla `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`identificacion`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `hojavidaeqp`
--
ALTER TABLE `hojavidaeqp`
  ADD CONSTRAINT `fk_hojaVidaEQP_equipo1` FOREIGN KEY (`equipo_codigo`) REFERENCES `equipo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD CONSTRAINT `fk_mantenimiento_equipo` FOREIGN KEY (`equipo_codigo`) REFERENCES `equipo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_mantenimiento_responsable1` FOREIGN KEY (`responsable_identificacion`) REFERENCES `responsable` (`identificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
