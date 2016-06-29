CREATE DATABASE  IF NOT EXISTS `deinfo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `deinfo`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: deinfo
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `CPF_ALU` varchar(30) NOT NULL,
  `PRIORIDADE` tinyint(1) NOT NULL,
  `CURSO` int(11) NOT NULL,
  `ANO_ENTRADA` int(11) NOT NULL,
  `SEMESTRE_ENTRADA` int(11) NOT NULL,
  `TURNO` varchar(7) NOT NULL,
  PRIMARY KEY (`CPF_ALU`),
  KEY `fk_curso_idx` (`CURSO`),
  CONSTRAINT `fk_cpf_alu` FOREIGN KEY (`CPF_ALU`) REFERENCES `pessoa` (`CPF_P`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso` FOREIGN KEY (`CURSO`) REFERENCES `curso` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_de_pesquisa`
--

DROP TABLE IF EXISTS `area_de_pesquisa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_de_pesquisa` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_de_pesquisa`
--

LOCK TABLES `area_de_pesquisa` WRITE;
/*!40000 ALTER TABLE `area_de_pesquisa` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_de_pesquisa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOTA` int(2) NOT NULL,
  `ANONIMA` tinyint(1) NOT NULL,
  `CPF_ALU` varchar(20) NOT NULL,
  `CPF_PROF` varchar(20) NOT NULL,
  `DATA_AVA` date NOT NULL,
  `DESCRICAO` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_aluno_idx` (`CPF_ALU`),
  KEY `fk_prof_idx` (`CPF_PROF`),
  CONSTRAINT `fk_aluno` FOREIGN KEY (`CPF_ALU`) REFERENCES `aluno` (`CPF_ALU`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_prof` FOREIGN KEY (`CPF_PROF`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao_oferta`
--

DROP TABLE IF EXISTS `avaliacao_oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao_oferta` (
  `ID` int(4) NOT NULL,
  `VA1` float DEFAULT NULL,
  `VA2` float DEFAULT NULL,
  `VA3` float DEFAULT NULL,
  `FINAL` float DEFAULT NULL,
  `SITUACAO` int(11) NOT NULL,
  `MEDIA` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_situacao_idx` (`SITUACAO`),
  CONSTRAINT `fk_situacao` FOREIGN KEY (`SITUACAO`) REFERENCES `situacaoes` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao_oferta`
--

LOCK TABLES `avaliacao_oferta` WRITE;
/*!40000 ALTER TABLE `avaliacao_oferta` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao_oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `COORDENADOR` varchar(20) DEFAULT NULL,
  `VICE_COORDENADOR` varchar(20) DEFAULT NULL,
  `GRADUACAO` tinyint(1) NOT NULL,
  `POSGRADUACAO` tinyint(1) NOT NULL,
  `DEPARTAMENTO_ID` int(5) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_id_depat_idx` (`DEPARTAMENTO_ID`),
  KEY `fk_coordenador_idx` (`COORDENADOR`),
  KEY `fk_vice_coordenador_idx` (`VICE_COORDENADOR`),
  CONSTRAINT `fk_coordenador` FOREIGN KEY (`COORDENADOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_depat` FOREIGN KEY (`DEPARTAMENTO_ID`) REFERENCES `departamento` (`ID_DEP`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_vice_coordenador` FOREIGN KEY (`VICE_COORDENADOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Bacharelado em Ciência da Computação',NULL,NULL,0,1,1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `ID_DEP` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `SIGLA` varchar(10) NOT NULL,
  `DIRETOR` varchar(11) DEFAULT NULL,
  `VICE` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DEP`),
  UNIQUE KEY `NOME_UNIQUE` (`NOME`),
  UNIQUE KEY `SIGLA_UNIQUE` (`SIGLA`),
  KEY `fk_diretor_idx` (`DIRETOR`),
  KEY `fk_vice_idx` (`VICE`),
  CONSTRAINT `fk_diretor` FOREIGN KEY (`DIRETOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vice` FOREIGN KEY (`VICE`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Departamento de Estatistica e informatica','DEINFO',NULL,NULL),(2,'Departamento de Matematica','DEMAT',NULL,NULL);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dias_semana`
--

DROP TABLE IF EXISTS `dias_semana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dias_semana` (
  `ID` int(1) NOT NULL,
  `DIA` char(3) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias_semana`
--

LOCK TABLES `dias_semana` WRITE;
/*!40000 ALTER TABLE `dias_semana` DISABLE KEYS */;
INSERT INTO `dias_semana` VALUES (1,'Dom'),(2,'Seg'),(3,'Ter'),(4,'Qua'),(5,'Qui'),(6,'Sex'),(7,'Sab');
/*!40000 ALTER TABLE `dias_semana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `CODIGO_DIS` varchar(20) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `CURSO` int(11) NOT NULL,
  `CARGA_HORARIA` int(11) NOT NULL,
  `TRILHA` varchar(30) DEFAULT NULL,
  `OPTATIVA` tinyint(1) DEFAULT NULL,
  `OBRIGATORIOA` tinyint(1) DEFAULT NULL,
  `GRADUACAO` tinyint(1) DEFAULT NULL,
  `POSGRADUACAO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_DIS`),
  KEY `fk_curso_idx` (`CURSO`),
  CONSTRAINT `fk_curso_id` FOREIGN KEY (`CURSO`) REFERENCES `curso` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_login`
--

DROP TABLE IF EXISTS `historico_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CPF_LOG` varchar(20) NOT NULL,
  `DATA_LOGIN` datetime(6) NOT NULL,
  PRIMARY KEY (`ID`,`CPF_LOG`),
  KEY `fk_pessoa_idx` (`CPF_LOG`),
  CONSTRAINT `fk_pessoa` FOREIGN KEY (`CPF_LOG`) REFERENCES `pessoa` (`CPF_P`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_login`
--

LOCK TABLES `historico_login` WRITE;
/*!40000 ALTER TABLE `historico_login` DISABLE KEYS */;
INSERT INTO `historico_login` VALUES (1,'34232646086','2016-05-02 01:31:26.094000'),(2,'09198875469','2016-05-02 01:33:09.143000'),(3,'34232646086','2016-05-02 13:56:58.373000'),(4,'34232646086','2016-05-02 14:02:12.283000'),(5,'34232646086','2016-05-02 14:05:04.235000'),(6,'34232646086','2016-05-02 14:05:51.534000'),(7,'34232646086','2016-05-02 14:10:28.279000');
/*!40000 ALTER TABLE `historico_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `ID` int(4) NOT NULL,
  `DIA` int(1) NOT NULL,
  `HORA_INICIO` varchar(45) NOT NULL,
  `HORA_FIM` varchar(45) NOT NULL,
  `OFERTA` int(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_dia_idx` (`DIA`),
  KEY `fk_oferta_idx` (`OFERTA`),
  CONSTRAINT `fk_dia` FOREIGN KEY (`DIA`) REFERENCES `dias_semana` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_oferta` FOREIGN KEY (`OFERTA`) REFERENCES `oferta` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacao`
--

DROP TABLE IF EXISTS `localizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localizacao` (
  `ID` int(4) NOT NULL,
  `SALA` int(2) NOT NULL,
  `PREDIO` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacao`
--

LOCK TABLES `localizacao` WRITE;
/*!40000 ALTER TABLE `localizacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `localizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `ID` int(11) NOT NULL,
  `CPF_ALUNO` varchar(11) DEFAULT NULL,
  `ID_OFERTA` int(11) DEFAULT NULL,
  `AVALIACAO_OFERTA` int(4) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_cpf_matricula_idx` (`CPF_ALUNO`),
  KEY `fk_oferta_matricula_idx` (`ID_OFERTA`),
  KEY `fk_avaliacao_idx` (`AVALIACAO_OFERTA`),
  CONSTRAINT `fk_avaliacao` FOREIGN KEY (`AVALIACAO_OFERTA`) REFERENCES `avaliacao_oferta` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_cpf_matricula` FOREIGN KEY (`CPF_ALUNO`) REFERENCES `aluno` (`CPF_ALU`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_oferta_matricula` FOREIGN KEY (`ID_OFERTA`) REFERENCES `oferta` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oferta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ANO` int(4) NOT NULL,
  `SEMESTRE` int(1) NOT NULL,
  `DISCIPLINA_OFERTA` varchar(11) NOT NULL,
  `LOCALIZACAO` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_disciplina_oferta_idx` (`DISCIPLINA_OFERTA`),
  KEY `fk_localizacao_idx` (`LOCALIZACAO`),
  CONSTRAINT `fk_disciplina_oferta` FOREIGN KEY (`DISCIPLINA_OFERTA`) REFERENCES `disciplina` (`CODIGO_DIS`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_localizacao` FOREIGN KEY (`LOCALIZACAO`) REFERENCES `localizacao` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `CPF_P` varchar(50) NOT NULL,
  `P_NOME` varchar(50) NOT NULL,
  `U_NOME` varchar(30) NOT NULL,
  `SEXO` tinyint(1) NOT NULL,
  `SENHA` varchar(20) NOT NULL DEFAULT '123456',
  `EMAIL` varchar(50) NOT NULL,
  `LOGRADOURO` varchar(50) NOT NULL,
  `CEP` varchar(10) NOT NULL,
  `TIPO_PESSOA` int(1) unsigned DEFAULT NULL,
  `CIDADE` varchar(50) NOT NULL,
  `BAIRRO` varchar(45) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `ESTADO` varchar(2) NOT NULL,
  `DATA_NASC` date NOT NULL,
  PRIMARY KEY (`CPF_P`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES ('09198875469','Thiago','Gomes',1,'teste','thiago123789@gmail.com','Rua da Guia','50761-030',0,'Recife','san martin',58,'PE','0000-00-00'),('34232646086','root','root',1,'teste','thiago123789@gmail.com','thiago123789@gmail.com','50761-030',2,'Recife','san martin',58,'PE','0000-00-00');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_requisito`
--

DROP TABLE IF EXISTS `pre_requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pre_requisito` (
  `DISCIPLINA` varchar(20) NOT NULL,
  `PREREQUISITO` varchar(20) NOT NULL,
  PRIMARY KEY (`DISCIPLINA`,`PREREQUISITO`),
  KEY `fk_pre_idx` (`PREREQUISITO`),
  CONSTRAINT `fk_disciplina` FOREIGN KEY (`DISCIPLINA`) REFERENCES `disciplina` (`CODIGO_DIS`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pre` FOREIGN KEY (`PREREQUISITO`) REFERENCES `disciplina` (`CODIGO_DIS`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_requisito`
--

LOCK TABLES `pre_requisito` WRITE;
/*!40000 ALTER TABLE `pre_requisito` DISABLE KEYS */;
/*!40000 ALTER TABLE `pre_requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `CPF_PROF` varchar(30) NOT NULL,
  `CARGO` int(11) NOT NULL,
  `LATTES` varchar(100) NOT NULL,
  PRIMARY KEY (`CPF_PROF`),
  KEY `fk_cargo_idx` (`CARGO`),
  CONSTRAINT `fk_cargo` FOREIGN KEY (`CARGO`) REFERENCES `cargo` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cpf_prof` FOREIGN KEY (`CPF_PROF`) REFERENCES `pessoa` (`CPF_P`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_sub_area`
--

DROP TABLE IF EXISTS `professor_sub_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_sub_area` (
  `ID` int(11) NOT NULL,
  `CPF_PROF` varchar(20) NOT NULL,
  `ID_SUB_AREA` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`CPF_PROF`,`ID_SUB_AREA`),
  KEY `fk_cpf_professor_idx` (`CPF_PROF`),
  KEY `fk_id_sub_area_idx` (`ID_SUB_AREA`),
  CONSTRAINT `fk_cpf_professor` FOREIGN KEY (`CPF_PROF`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_sub_area` FOREIGN KEY (`ID_SUB_AREA`) REFERENCES `sub_area` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_sub_area`
--

LOCK TABLES `professor_sub_area` WRITE;
/*!40000 ALTER TABLE `professor_sub_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor_sub_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `situacaoes`
--

DROP TABLE IF EXISTS `situacaoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `situacaoes` (
  `ID` int(11) NOT NULL,
  `TIPO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`,`TIPO`),
  UNIQUE KEY `TIPO_UNIQUE` (`TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `situacaoes`
--

LOCK TABLES `situacaoes` WRITE;
/*!40000 ALTER TABLE `situacaoes` DISABLE KEYS */;
INSERT INTO `situacaoes` VALUES (1,'Aprovado'),(3,'Aprovado por média'),(6,'Cancelado com onus'),(5,'Cancelado sem onus'),(7,'Cursando'),(4,'Dispensado'),(2,'Reprovado');
/*!40000 ALTER TABLE `situacaoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_area`
--

DROP TABLE IF EXISTS `sub_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_area` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `AREA_PESQUISA` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_area_pesquisa_idx` (`AREA_PESQUISA`),
  CONSTRAINT `fk_area_pesquisa` FOREIGN KEY (`AREA_PESQUISA`) REFERENCES `area_de_pesquisa` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_area`
--

LOCK TABLES `sub_area` WRITE;
/*!40000 ALTER TABLE `sub_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'deinfo'
--

--
-- Dumping routines for database 'deinfo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-03 19:26:19
