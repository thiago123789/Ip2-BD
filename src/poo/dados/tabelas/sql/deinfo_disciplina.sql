-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: deinfo
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `CODIGO_DIS` varchar(20) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `CURSO` int(10) NOT NULL,
  `CARGA_HORARIA` int(11) NOT NULL,
  `TRILHA` varchar(30) DEFAULT NULL,
  `OPTATIVA` tinyint(1) DEFAULT NULL,
  `OBRIGATORIOA` tinyint(1) DEFAULT NULL,
  `GRADUACAO` tinyint(1) DEFAULT NULL,
  `POSGRADUACAO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_DIS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('ALG.EST','Algoritmo e estrutura de dados',1,0,NULL,0,1,1,0),('ALG.LIN','Algebra Linear',1,0,NULL,0,1,1,0),('BAN.DAD','Banco de dados',1,0,NULL,0,1,1,0),('CAL.1','Calculo 1',1,0,NULL,0,1,1,0),('INT.CIE','Introdução a ciencia da computação',1,0,NULL,0,1,1,0),('INT.PRO.1','Introducao a programacao 1',1,0,NULL,0,1,1,0),('INT.PRO.2','Introducao a programacao 2',1,0,NULL,0,1,1,0),('MAT.DIS','Matematica Discreta',1,0,NULL,0,1,1,0);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-29 15:34:06
