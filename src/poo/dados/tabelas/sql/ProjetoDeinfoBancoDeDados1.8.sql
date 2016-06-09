CREATE DATABASE  IF NOT EXISTS `deinfo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `deinfo`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: deinfo
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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `CPF_ALU` varchar(11) NOT NULL,
  `PRIORIDADE` tinyint(1) NOT NULL,
  `CURSO` int(4) NOT NULL,
  `ANO_ENTRADA` int(4) NOT NULL,
  `SEMESTRE_ENTRADA` int(1) NOT NULL,
  `TURNO` varchar(7) NOT NULL,
  `MONITOR` tinyint(1) NOT NULL,
  `VOLUNTARIO` tinyint(1) NOT NULL,
  `BOLSISTA` tinyint(1) NOT NULL,
  `DESISTIU` tinyint(1) NOT NULL,
  `MEDIA_GERAL` float DEFAULT NULL,
  PRIMARY KEY (`CPF_ALU`),
  KEY `fk_curso_aluno_idx` (`CURSO`),
  CONSTRAINT `fk_cpf_aluno` FOREIGN KEY (`CPF_ALU`) REFERENCES `pessoa` (`CPF_P`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_curso_aluno` FOREIGN KEY (`CURSO`) REFERENCES `curso` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES ('09198875469',1,1,2014,2,'Tarde',0,1,1,0,NULL);
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
  `ID` int(11) NOT NULL,
  `NOTA` int(2) NOT NULL,
  `ANONIMA` tinyint(1) NOT NULL,
  `CPF_ALU` varchar(11) NOT NULL,
  `CPF_PROF` varchar(11) NOT NULL,
  `DATA_AVA` date NOT NULL,
  `DESCRICAO` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_aluno_avalia_idx` (`CPF_ALU`),
  KEY `fk_prof_avaliado_idx` (`CPF_PROF`),
  CONSTRAINT `fk_aluno_avalia` FOREIGN KEY (`CPF_ALU`) REFERENCES `aluno` (`CPF_ALU`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_prof_avaliado` FOREIGN KEY (`CPF_PROF`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
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
  `ID_MATRICULA` int(11) NOT NULL,
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `VA1` float DEFAULT NULL,
  `VA2` float DEFAULT NULL,
  `VA3` float DEFAULT NULL,
  `FINAL` float DEFAULT NULL,
  `SITUACAO` int(11) NOT NULL DEFAULT '1',
  `MEDIA` float DEFAULT NULL,
  `FALTAS` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_MATRICULA`),
  UNIQUE KEY `uniq_ids` (`ID`),
  KEY `fk_situacao_idx` (`SITUACAO`),
  KEY `fk_matricula_idx` (`ID_MATRICULA`),
  CONSTRAINT `fk_matricula` FOREIGN KEY (`ID_MATRICULA`) REFERENCES `matricula` (`COD_MATRICULA`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_situacao` FOREIGN KEY (`SITUACAO`) REFERENCES `situacaoes` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao_oferta`
--

LOCK TABLES `avaliacao_oferta` WRITE;
/*!40000 ALTER TABLE `avaliacao_oferta` DISABLE KEYS */;
INSERT INTO `avaliacao_oferta` VALUES (1,1,NULL,NULL,NULL,NULL,1,NULL,0);
/*!40000 ALTER TABLE `avaliacao_oferta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger atualizarMedia
before update on avaliacao_oferta for each row
begin
	declare media float;
    set media = deinfo.calculaMediaFinal(new.va1, new.va2, new.va3);
	set new.media = MEDIA;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `banca_avaliadora`
--

DROP TABLE IF EXISTS `banca_avaliadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banca_avaliadora` (
  `ID_BANCA` int(11) NOT NULL,
  `DATA_DEFESA` date NOT NULL,
  `RESULTADO` varchar(20) NOT NULL,
  `TRABALHO_COM_DEFESA` int(11) NOT NULL,
  PRIMARY KEY (`ID_BANCA`,`DATA_DEFESA`),
  KEY `fk_publicacao_c_defesa_idx` (`TRABALHO_COM_DEFESA`),
  CONSTRAINT `fk_publicacao_c_defesa` FOREIGN KEY (`TRABALHO_COM_DEFESA`) REFERENCES `publicacao` (`COD_PUBLICACAO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banca_avaliadora`
--

LOCK TABLES `banca_avaliadora` WRITE;
/*!40000 ALTER TABLE `banca_avaliadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `banca_avaliadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bolsista`
--

DROP TABLE IF EXISTS `bolsista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bolsista` (
  `CPF_ALUNO` varchar(11) NOT NULL,
  `PROJETO` int(11) NOT NULL,
  `VALOR_BOLSA` float NOT NULL,
  PRIMARY KEY (`CPF_ALUNO`,`PROJETO`),
  KEY `fk_id_projeto_bolsista_idx` (`PROJETO`),
  CONSTRAINT `fk_aluno_bolsista` FOREIGN KEY (`CPF_ALUNO`) REFERENCES `aluno` (`CPF_ALU`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_id_projeto_bolsista` FOREIGN KEY (`PROJETO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bolsista`
--

LOCK TABLES `bolsista` WRITE;
/*!40000 ALTER TABLE `bolsista` DISABLE KEYS */;
/*!40000 ALTER TABLE `bolsista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `ID` int(4) NOT NULL,
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
-- Table structure for table `co_requisito`
--

DROP TABLE IF EXISTS `co_requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `co_requisito` (
  `DISCIPLINA` varchar(20) NOT NULL,
  `COREQUISITO` varchar(20) NOT NULL,
  PRIMARY KEY (`DISCIPLINA`,`COREQUISITO`),
  KEY `fk_coreq_idx` (`COREQUISITO`),
  CONSTRAINT `fk_coreq` FOREIGN KEY (`COREQUISITO`) REFERENCES `disciplina` (`CODIGO_DIS`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_disciplina_co` FOREIGN KEY (`DISCIPLINA`) REFERENCES `disciplina` (`CODIGO_DIS`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `co_requisito`
--

LOCK TABLES `co_requisito` WRITE;
/*!40000 ALTER TABLE `co_requisito` DISABLE KEYS */;
/*!40000 ALTER TABLE `co_requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colabora_projeto`
--

DROP TABLE IF EXISTS `colabora_projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colabora_projeto` (
  `COD_PROFESSOR_COLABORADOR` varchar(11) NOT NULL,
  `COD_PROJETO_COLABORADO` int(11) NOT NULL,
  PRIMARY KEY (`COD_PROFESSOR_COLABORADOR`,`COD_PROJETO_COLABORADO`),
  KEY `fk_cod_projeto_colaborado_idx` (`COD_PROJETO_COLABORADO`),
  CONSTRAINT `fk_cod_projeto_colaborado` FOREIGN KEY (`COD_PROJETO_COLABORADO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_prof_colaborador` FOREIGN KEY (`COD_PROFESSOR_COLABORADOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colabora_projeto`
--

LOCK TABLES `colabora_projeto` WRITE;
/*!40000 ALTER TABLE `colabora_projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `colabora_projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes_banca_avaliadora`
--

DROP TABLE IF EXISTS `componentes_banca_avaliadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componentes_banca_avaliadora` (
  `ID_BANCA` int(11) NOT NULL,
  `CPF_PROFESSOR` varchar(11) NOT NULL,
  PRIMARY KEY (`ID_BANCA`,`CPF_PROFESSOR`),
  KEY `fk_prof_banca_avalia_idx` (`CPF_PROFESSOR`),
  CONSTRAINT `fk_prof_banca_avalia` FOREIGN KEY (`CPF_PROFESSOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes_banca_avaliadora`
--

LOCK TABLES `componentes_banca_avaliadora` WRITE;
/*!40000 ALTER TABLE `componentes_banca_avaliadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `componentes_banca_avaliadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `ID` int(4) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `COORDENADOR` varchar(11) DEFAULT NULL,
  `VICE_COORDENADOR` varchar(11) DEFAULT NULL,
  `GRADUACAO` tinyint(1) NOT NULL,
  `POSGRADUACAO` tinyint(1) NOT NULL,
  `DEPARTAMENTO_ID` int(11) NOT NULL,
  `ANO_INICIO` int(4) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NOME_UNIQUE` (`NOME`),
  KEY `fk_coordenador_curso_idx` (`COORDENADOR`),
  KEY `fk_vice_coordenador_curso_idx` (`VICE_COORDENADOR`),
  KEY `fk_departamento_curso_idx` (`DEPARTAMENTO_ID`),
  CONSTRAINT `fk_coordenador_curso` FOREIGN KEY (`COORDENADOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_departamento_curso` FOREIGN KEY (`DEPARTAMENTO_ID`) REFERENCES `departamento` (`ID_DEP`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_vice_coordenador_curso` FOREIGN KEY (`VICE_COORDENADOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (0,'Bacharelado em Sistema de Informação',NULL,NULL,0,1,1,2010),(1,'Bacharelado em Ciencia da Computação',NULL,NULL,1,0,1,2010),(2,'Licenciatura em Computacao',NULL,NULL,1,0,1,2008);
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
  KEY `fk_prof_diretor_idx` (`DIRETOR`),
  KEY `fk_prof_vice_idx` (`VICE`),
  CONSTRAINT `fk_prof_diretor` FOREIGN KEY (`DIRETOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_prof_vice` FOREIGN KEY (`VICE`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Departamento de Estatistica e Informatica','DEINFO',NULL,NULL),(2,'Departamento de Matematica','DEMAT',NULL,NULL);
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
  `DIA` varchar(3) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias_semana`
--

LOCK TABLES `dias_semana` WRITE;
/*!40000 ALTER TABLE `dias_semana` DISABLE KEYS */;
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
  `NOME` varchar(100) NOT NULL,
  `CURSO` int(4) NOT NULL,
  `CARGA_HORARIA` int(3) NOT NULL,
  `TRILHA` int(4) DEFAULT NULL,
  `OPTATIVA` tinyint(1) NOT NULL,
  `OBRIGATORIA` tinyint(1) NOT NULL,
  `GRADUACAO` tinyint(1) NOT NULL,
  `POSGRADUACAO` tinyint(1) NOT NULL,
  `PERIODO_DISCIPLINA` int(1) NOT NULL DEFAULT '0',
  `EMENTA` longblob,
  PRIMARY KEY (`CODIGO_DIS`),
  KEY `fk_trilha_idx` (`TRILHA`),
  KEY `fk_curso_disciplina_idx` (`CURSO`),
  CONSTRAINT `fk_curso_disciplina` FOREIGN KEY (`CURSO`) REFERENCES `curso` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_trilha` FOREIGN KEY (`TRILHA`) REFERENCES `trilha` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('14010','GERENCIAMENTO DE REDES',1,60,NULL,0,0,1,1,0,NULL),('14033','ALGORITMOS NUMÉRICOS',1,60,NULL,0,0,1,1,0,NULL),('14043','COMPUTADORES E SOCIEDADE',1,60,NULL,0,0,0,1,0,NULL),('14044','INTRODUÇÃO À CIÊNCIA DA COMPUTAÇÃO',1,60,NULL,1,1,1,1,1,NULL),('14045','DIREITO E LEGISLAÇÃO PARA INFORMÁTICA',1,60,NULL,0,1,1,0,0,NULL),('14046','GERÊNCIA DE PROJETOS',1,60,NULL,0,0,1,1,0,NULL),('14055','COMPUTAÇÃO E EMPREENDEDORISMO',1,60,NULL,1,1,0,0,0,NULL),('14061','ARQUITETURAS ORIENTADAS A SERVIÇOS',1,60,NULL,0,0,1,0,0,NULL),('14063','CIRCUITOS DIGITAIS',1,60,NULL,1,1,1,1,3,NULL),('14064','ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES',1,60,NULL,0,1,1,0,4,NULL),('14066','ARQUITETURAS AVANÇADAS DE COMPUTADORES',1,60,NULL,1,0,1,0,0,NULL),('14067','CIRCUITOS INTEGRADOS',1,60,NULL,1,0,0,1,0,NULL),('14069','COMPUTAÇÃO DE ALTO DESEMPENHO',1,60,NULL,1,1,0,0,0,NULL),('14073','COMPUTAÇÃO QUÂNTICA',1,60,NULL,1,0,1,1,0,NULL),('14074','INTELIGÊNCIA ARTIFICIAL',1,60,NULL,1,0,1,1,5,NULL),('14078','ENGENHARIA DE REQUISITOS',1,60,NULL,0,0,0,0,0,NULL),('14088','BANCO DE DADOS S',1,60,NULL,1,1,0,0,4,NULL),('14090','COMPILADORES',1,60,NULL,0,1,1,1,5,NULL),('14092','BANCO DE DADOS NÃO-CONVENCIONAIS',1,60,NULL,1,1,0,1,0,NULL),('14093','ALGORITMOS EM GRAFOS',1,60,NULL,0,0,1,1,0,NULL),('14094','ANÁLISE E PROJETO DE SISTEMAS ORIENTADOS A ASPECTOS',1,60,NULL,0,0,1,0,0,NULL),('14099','ANÁLISE DE DESEMPENHO',1,60,NULL,1,1,1,0,0,NULL),('14103','BIOLOGIA COMPUTACIONAL',1,60,NULL,1,1,0,0,0,NULL),('14104','BIOINFORMÁTICA',1,60,NULL,1,1,1,1,0,NULL),('14105','ALGORITMOS PARA BUSCA DE PADRÕES EM SEQUÊNCIAS',1,60,NULL,0,0,0,0,0,NULL),('14108','ANÁLISE E PROJETO DE SISTEMAS ORIENTADOS A OBJETOS',1,60,NULL,0,1,0,1,0,NULL),('14110','ESTÁGIO SUPERVISIONADO OBRIGATÓRIO I - BACH COMPUTAÇÃO',1,120,NULL,1,0,0,1,7,NULL),('14111','ESTÁGIO SUPERVISIONADO OBRIGATÓRIO I - BACH COMPUTAÇÃO',1,120,NULL,1,1,0,0,8,NULL),('14117','INTRODUÇÃO À PROGRAMAÇÃO I',1,60,NULL,0,1,1,0,1,NULL),('14119','DESENVOLVIMENTO DE APLICAÇÕES MÓVEIS',1,60,NULL,0,1,1,1,0,NULL),('14120','AVALIAÇÃO DE DESEMPENHO DE REDES',1,60,NULL,1,0,0,0,0,NULL),('14124','COMPUTAÇÃO EM NUVEM',1,60,NULL,1,1,1,1,0,NULL),('14125','DESENVOLVIMENTO DE APLICAÇÕES PARA WEB',1,60,NULL,0,1,1,0,0,NULL),('14128','DESAFIOS DE PROGRAMAÇÃO',1,60,NULL,0,0,1,1,0,NULL),('14130','ALGORITMOS PARA BIOINFORMÁTICA E BIOLOGIA COMPUTACIONAL',1,60,NULL,0,0,0,1,0,NULL),('14313','ALGORITMOS SOBRE TEXTOS',1,60,NULL,0,0,0,0,0,NULL),('14314','GEOMETRIA COMPUTACIONAL',1,60,NULL,1,0,1,0,0,NULL),('14316','AUTÔMATOS JOGOS E LÓGICA',1,60,NULL,1,0,1,0,0,NULL),('14317','INFORMAÇÃO QUÂNTICA',1,60,NULL,0,0,0,1,0,NULL),('14320','INOVAÇÃO EM PROJETOS DE SOFTWARE',1,60,NULL,1,0,0,1,0,NULL),('14322','ASPECTOS COGNITIVOS NO DESENVOLVIMENTO DE SOFTWARE',1,60,NULL,1,0,1,1,0,NULL),('14323','ENGENHARIA DE SOFTWARE EXPERIMENTAL',1,60,NULL,1,1,1,0,0,NULL),('14324','INTERAÇÃO HOMEM MÁQUINA',1,60,NULL,0,0,0,0,0,NULL),('14330','EMPREENDEDORISMO A',1,60,NULL,1,0,1,0,0,NULL),('14701','ESTRUTURAS ALGÉBRICAS PARA COMPUTAÇÃO',1,60,NULL,0,1,1,0,0,NULL),('2661','EDUCAÇÃO DAS RELAÇÕES ÉTNICO-RACIAIS',1,60,NULL,1,0,0,0,0,NULL),('272','EDUCAÇÃO FÍSICA',1,30,NULL,0,1,0,1,9,NULL),('3080','CRIPTOGRAFIA',1,60,NULL,0,0,1,1,0,NULL),('3212','ALGORITMOS E ESTRUTURAS DE DADOS',1,60,NULL,0,1,1,0,2,NULL),('3216','INFORMÁTICA NA EDUCAÇÃO',1,60,NULL,0,0,0,1,0,NULL),('3222','ENGENHARIA DE SOFTWARE',1,60,NULL,0,0,0,0,4,NULL),('3224','COMPUTAÇÃO GRÁFICA BÁSICA',1,60,NULL,1,1,0,0,0,NULL),('3235','ESTATÍSTICA EXPLORATÓRIA I',1,60,NULL,0,0,1,1,3,NULL),('3257','INTRODUÇÃO À COMPUTAÇÃO QUÂNTICA',1,60,NULL,1,0,0,1,0,NULL),('3285','FÍSICA APLICADA À COMPUTAÇÃO',1,60,NULL,0,1,0,0,3,NULL),('3365','CÁLCULO DIFERENC. E INTEGR. II L',1,60,NULL,0,0,1,0,2,NULL),('3366','CÁLCULO DIFERENC. E INTEGR. I L',1,60,NULL,1,1,0,0,1,NULL),('50','EDUCAÇÃO À DISTÂNCIA',1,60,NULL,1,1,0,0,0,NULL);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa_junior`
--

DROP TABLE IF EXISTS `empresa_junior`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa_junior` (
  `COD_PROJETO` int(11) NOT NULL,
  `DEPARTAMENTO` int(11) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`COD_PROJETO`,`DEPARTAMENTO`),
  KEY `fk_cod_dep_ej_idx` (`DEPARTAMENTO`),
  CONSTRAINT `fk_cod_dep_ej` FOREIGN KEY (`DEPARTAMENTO`) REFERENCES `departamento` (`ID_DEP`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_proj_emp_jun` FOREIGN KEY (`COD_PROJETO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa_junior`
--

LOCK TABLES `empresa_junior` WRITE;
/*!40000 ALTER TABLE `empresa_junior` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_junior` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extensao`
--

DROP TABLE IF EXISTS `extensao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extensao` (
  `ID_PROJETO` int(11) NOT NULL,
  `TITULO` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_PROJETO`),
  CONSTRAINT `fk_extensao_proj` FOREIGN KEY (`ID_PROJETO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extensao`
--

LOCK TABLES `extensao` WRITE;
/*!40000 ALTER TABLE `extensao` DISABLE KEYS */;
/*!40000 ALTER TABLE `extensao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `CPF_FUNCIONARIO` varchar(11) NOT NULL,
  `CARGO` int(4) NOT NULL,
  `TIPO_FUNCIONARIO` int(4) NOT NULL,
  PRIMARY KEY (`CPF_FUNCIONARIO`),
  KEY `fk_cargo_funcionario_idx` (`CARGO`),
  CONSTRAINT `fk_cargo_func` FOREIGN KEY (`CARGO`) REFERENCES `cargo` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_cpf_func` FOREIGN KEY (`CPF_FUNCIONARIO`) REFERENCES `pessoa` (`CPF_P`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_login`
--

LOCK TABLES `historico_login` WRITE;
/*!40000 ALTER TABLE `historico_login` DISABLE KEYS */;
INSERT INTO `historico_login` VALUES (61,'34232646086','2016-06-08 20:47:21.540000'),(62,'34232646086','2016-06-08 20:52:54.025000'),(63,'34232646086','2016-06-08 20:56:28.256000'),(64,'34232646086','2016-06-08 22:31:44.320000'),(65,'34232646086','2016-06-08 22:46:25.904000'),(66,'34232646086','2016-06-08 22:47:18.242000'),(67,'34232646086','2016-06-08 23:36:06.982000'),(68,'34232646086','2016-06-09 12:17:08.530000'),(69,'34232646086','2016-06-09 12:31:17.689000');
/*!40000 ALTER TABLE `historico_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `ID` int(11) NOT NULL,
  `DIA` int(1) NOT NULL,
  `HORA_INICIO` time(4) NOT NULL,
  `HORA_FIM` time(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_dia_idx` (`DIA`),
  CONSTRAINT `fk_dia` FOREIGN KEY (`DIA`) REFERENCES `dias_semana` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
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
-- Table structure for table `horarios_ofertas`
--

DROP TABLE IF EXISTS `horarios_ofertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horarios_ofertas` (
  `ID_OFERTA` int(11) NOT NULL,
  `ID_HORARIO` int(11) NOT NULL,
  KEY `fk_id_oferta_idx` (`ID_OFERTA`),
  KEY `fk_id_horario_idx` (`ID_HORARIO`),
  CONSTRAINT `fk_id_horario` FOREIGN KEY (`ID_HORARIO`) REFERENCES `horario` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_id_oferta` FOREIGN KEY (`ID_OFERTA`) REFERENCES `oferta_disciplina` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios_ofertas`
--

LOCK TABLES `horarios_ofertas` WRITE;
/*!40000 ALTER TABLE `horarios_ofertas` DISABLE KEYS */;
/*!40000 ALTER TABLE `horarios_ofertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iniciacao_cientifica`
--

DROP TABLE IF EXISTS `iniciacao_cientifica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iniciacao_cientifica` (
  `ID_PROJETO` int(11) NOT NULL,
  `PRORROGADO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_PROJETO`),
  CONSTRAINT `fk_inciacao_projeto` FOREIGN KEY (`ID_PROJETO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iniciacao_cientifica`
--

LOCK TABLES `iniciacao_cientifica` WRITE;
/*!40000 ALTER TABLE `iniciacao_cientifica` DISABLE KEYS */;
/*!40000 ALTER TABLE `iniciacao_cientifica` ENABLE KEYS */;
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
  PRIMARY KEY (`ID`,`SALA`,`PREDIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacao`
--

LOCK TABLES `localizacao` WRITE;
/*!40000 ALTER TABLE `localizacao` DISABLE KEYS */;
INSERT INTO `localizacao` VALUES (1,20,'CEAGRI II');
/*!40000 ALTER TABLE `localizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `COD_MATRICULA` int(11) NOT NULL,
  `CPF_ALUNO` varchar(11) NOT NULL,
  `ID_OFERTA` int(11) NOT NULL,
  `ANO` int(4) unsigned NOT NULL DEFAULT '0',
  `SEMESTRE` int(1) unsigned NOT NULL DEFAULT '0',
  `ONUS` tinyint(1) NOT NULL,
  `DATA_MATRICULA` datetime DEFAULT NULL,
  PRIMARY KEY (`COD_MATRICULA`),
  KEY `fk_cpf_aluno_matriculado_idx` (`CPF_ALUNO`),
  KEY `fk_cod_oferta_dis_idx` (`ID_OFERTA`),
  CONSTRAINT `fk_cod_aluno` FOREIGN KEY (`CPF_ALUNO`) REFERENCES `aluno` (`CPF_ALU`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_cod_oferta_dis` FOREIGN KEY (`ID_OFERTA`) REFERENCES `oferta_disciplina` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,'09198875469',1,2015,1,0,'2016-06-09 15:13:45');
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger data_matricula 
before insert on deinfo.matricula for each row
begin

	declare id_oferta_aux int;
    declare semestre_aux int;
	select ano into id_oferta_aux from oferta_disciplina where id = new.id_oferta;
	select semestre into semestre_aux from oferta_disciplina where id = new.id_oferta;
	set new.data_matricula = sysdate();
    set new.ano = id_oferta_aux;
    set new.semestre = semestre_aux;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger criarAvaliacaoOferta
after insert on matricula for each row
begin
	insert into deinfo.avaliacao_oferta(ID_MATRICULA) values(NEW.COD_MATRICULA);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `monitor`
--

DROP TABLE IF EXISTS `monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitor` (
  `ID_MONITOR` varchar(11) NOT NULL,
  `ORIENTADOR` varchar(11) NOT NULL,
  PRIMARY KEY (`ID_MONITOR`,`ORIENTADOR`),
  KEY `fk_cpf_prof_orientador_idx` (`ORIENTADOR`),
  CONSTRAINT `fk_cpf_monitor` FOREIGN KEY (`ID_MONITOR`) REFERENCES `aluno` (`CPF_ALU`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_cpf_prof_orientador` FOREIGN KEY (`ORIENTADOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor`
--

LOCK TABLES `monitor` WRITE;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta_disciplina`
--

DROP TABLE IF EXISTS `oferta_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oferta_disciplina` (
  `ID` int(11) NOT NULL,
  `ANO` int(4) NOT NULL,
  `SEMESTRE` int(1) NOT NULL,
  `DISCIPLINA_OFERTA` varchar(20) NOT NULL,
  `LOCALIZACAO` int(10) NOT NULL,
  `MONITOR_OFERTA` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `unq_ids` (`ANO`,`SEMESTRE`,`DISCIPLINA_OFERTA`),
  KEY `fk_disciplina_oferta_idx` (`DISCIPLINA_OFERTA`),
  KEY `fk_localizacao_idx` (`LOCALIZACAO`),
  KEY `fk_monitor_oferta_idx` (`MONITOR_OFERTA`),
  CONSTRAINT `fk_disciplina_oferta` FOREIGN KEY (`DISCIPLINA_OFERTA`) REFERENCES `disciplina` (`CODIGO_DIS`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_id_localizacao` FOREIGN KEY (`LOCALIZACAO`) REFERENCES `localizacao` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_monitor_oferta` FOREIGN KEY (`MONITOR_OFERTA`) REFERENCES `monitor` (`ID_MONITOR`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta_disciplina`
--

LOCK TABLES `oferta_disciplina` WRITE;
/*!40000 ALTER TABLE `oferta_disciplina` DISABLE KEYS */;
INSERT INTO `oferta_disciplina` VALUES (1,2015,1,'14010',1,NULL);
/*!40000 ALTER TABLE `oferta_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orienta_projeto`
--

DROP TABLE IF EXISTS `orienta_projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orienta_projeto` (
  `COD_PROFESSOR_ORIENTADOR` varchar(11) NOT NULL,
  `COD_PROJETO_ORIENTADO` int(11) NOT NULL,
  PRIMARY KEY (`COD_PROFESSOR_ORIENTADOR`,`COD_PROJETO_ORIENTADO`),
  KEY `fk_cod_projeto_orientado_idx` (`COD_PROJETO_ORIENTADO`),
  CONSTRAINT `fk_cod_projeto_orientado` FOREIGN KEY (`COD_PROJETO_ORIENTADO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_prof_orientador` FOREIGN KEY (`COD_PROFESSOR_ORIENTADOR`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orienta_projeto`
--

LOCK TABLES `orienta_projeto` WRITE;
/*!40000 ALTER TABLE `orienta_projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `orienta_projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `CPF_P` varchar(11) NOT NULL,
  `P_NOME` varchar(50) NOT NULL,
  `U_NOME` varchar(30) NOT NULL,
  `SEXO` char(1) NOT NULL,
  `SENHA` varchar(20) NOT NULL DEFAULT '123456',
  `EMAIL` varchar(50) NOT NULL,
  `LOGRADOURO` varchar(50) DEFAULT NULL,
  `CEP` varchar(8) DEFAULT NULL,
  `TIPO_PESSOA` int(1) unsigned NOT NULL,
  `CIDADE` varchar(50) NOT NULL,
  `BAIRRO` varchar(45) DEFAULT NULL,
  `NUMERO` int(4) DEFAULT NULL,
  `ESTADO` varchar(2) NOT NULL,
  `DATA_NASC` date NOT NULL,
  `LATTES` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CPF_P`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES ('09198875469','Thiago','Gomes','1','teste','thiago123789@gmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','0000-00-00',NULL),('14114631887','Thiago','Gomes','0','teste','thiagohfg@hotmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','1994-02-26',NULL),('34232646086','root','root','1','teste','thiago123789@gmail.com','thiago123789@gmail.com','50761030',2,'Recife','san martin',58,'PE','0000-00-00',NULL),('36473548211','Thiago','Gomes','0','teste','thiagohfg@hotmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','2016-05-04',NULL),('50473493225','Aarão','Amorín','M','','aarão.amorín@gmail.com',NULL,NULL,1,'Recife',NULL,NULL,'PE','1980-03-04',NULL),('53351207620','Thiago','Gomes','0','teste','thiagohfg@hotmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','1994-03-26',NULL),('55843160912','Thiago','Gomes','0','teste','thiagohfg@hotmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','1994-02-12',NULL),('63788353309','Thiago','Gomes','0','teste','thiagohfg@hotmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','1994-06-30',NULL),('67666811799','Thiago','Gomes','0','teste','thiagohfg@hotmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','1994-12-12',NULL),('88281466138','Thiago','Gomes','0','teste','thiagohfg@hotmail.com','Rua da Guia','50761030',0,'Recife','san martin',58,'PE','1994-01-12',NULL);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa_publica`
--

DROP TABLE IF EXISTS `pessoa_publica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa_publica` (
  `ID_PUBLICACAO` int(11) NOT NULL,
  `CPF_PESSOA` varchar(11) NOT NULL,
  PRIMARY KEY (`ID_PUBLICACAO`,`CPF_PESSOA`),
  KEY `fk_pessoa_publicou_idx` (`CPF_PESSOA`),
  CONSTRAINT `fk_pessoa_publicou` FOREIGN KEY (`CPF_PESSOA`) REFERENCES `pessoa` (`CPF_P`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_publicacao` FOREIGN KEY (`ID_PUBLICACAO`) REFERENCES `publicacao` (`COD_PUBLICACAO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa_publica`
--

LOCK TABLES `pessoa_publica` WRITE;
/*!40000 ALTER TABLE `pessoa_publica` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa_publica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pos_graduacao`
--

DROP TABLE IF EXISTS `pos_graduacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pos_graduacao` (
  `ID_CURSO` int(4) NOT NULL,
  `ESPECIALIDADE` varchar(45) NOT NULL,
  `TIPO_POS_GRADUACAO` int(11) NOT NULL,
  PRIMARY KEY (`ID_CURSO`),
  CONSTRAINT `fk_curso_id_pos` FOREIGN KEY (`ID_CURSO`) REFERENCES `curso` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pos_graduacao`
--

LOCK TABLES `pos_graduacao` WRITE;
/*!40000 ALTER TABLE `pos_graduacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `pos_graduacao` ENABLE KEYS */;
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
  CONSTRAINT `fk_disc_pre` FOREIGN KEY (`DISCIPLINA`) REFERENCES `disciplina` (`CODIGO_DIS`) ON DELETE NO ACTION ON UPDATE CASCADE,
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
  `CPF_PROF` varchar(11) NOT NULL,
  `EXTERNO` tinytext NOT NULL,
  `IES` varchar(45) NOT NULL,
  `TITULACAO` varchar(45) NOT NULL,
  PRIMARY KEY (`CPF_PROF`),
  KEY `fk_cpf_prof_idx` (`CPF_PROF`),
  CONSTRAINT `fk_prof_cpf` FOREIGN KEY (`CPF_PROF`) REFERENCES `funcionario` (`CPF_FUNCIONARIO`) ON DELETE NO ACTION ON UPDATE CASCADE
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
-- Table structure for table `professor_departamento`
--

DROP TABLE IF EXISTS `professor_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_departamento` (
  `DEPARTAMENTO_ID` int(11) NOT NULL,
  `PROFESSOR_CPF` varchar(11) NOT NULL,
  KEY `fk_departamento_id_idx` (`DEPARTAMENTO_ID`),
  KEY `fk_cpf_prof_depat_idx` (`PROFESSOR_CPF`),
  CONSTRAINT `fk_cpf_prof_depat` FOREIGN KEY (`PROFESSOR_CPF`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_departamento_id` FOREIGN KEY (`DEPARTAMENTO_ID`) REFERENCES `departamento` (`ID_DEP`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_departamento`
--

LOCK TABLES `professor_departamento` WRITE;
/*!40000 ALTER TABLE `professor_departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_oferta_disciplina`
--

DROP TABLE IF EXISTS `professor_oferta_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_oferta_disciplina` (
  `PROF_OFERTA` varchar(11) NOT NULL,
  `OFERTA_COD` int(11) NOT NULL,
  PRIMARY KEY (`PROF_OFERTA`,`OFERTA_COD`),
  UNIQUE KEY `fk_unique_ids` (`PROF_OFERTA`,`OFERTA_COD`),
  KEY `fk_offer_cod_idx` (`OFERTA_COD`),
  CONSTRAINT `fk_offer_cod` FOREIGN KEY (`OFERTA_COD`) REFERENCES `oferta_disciplina` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_prof_oferta` FOREIGN KEY (`PROF_OFERTA`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_oferta_disciplina`
--

LOCK TABLES `professor_oferta_disciplina` WRITE;
/*!40000 ALTER TABLE `professor_oferta_disciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor_oferta_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `CODIGO` int(4) NOT NULL,
  `TEMA` varchar(45) DEFAULT NULL,
  `DATA_INICIO` date NOT NULL,
  `DESCRICAO` varchar(100) DEFAULT NULL,
  `TIPO_PROJETO` int(1) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  KEY `fk_tipo_projeto_idx` (`TIPO_PROJETO`),
  CONSTRAINT `fk_tipo_projeto` FOREIGN KEY (`TIPO_PROJETO`) REFERENCES `tipos_projetos` (`ID_TIPO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicacao`
--

DROP TABLE IF EXISTS `publicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicacao` (
  `COD_PUBLICACAO` int(11) NOT NULL,
  `ANO_PUBLICADO` int(4) NOT NULL,
  `TITULO` varchar(50) NOT NULL,
  `NOME_INST` varchar(50) NOT NULL,
  `RESUMO` varchar(200) NOT NULL,
  `DESCRICAO` varchar(100) DEFAULT NULL,
  `TEMA` varchar(50) NOT NULL,
  `TIPO_PUBLICACAO` int(1) NOT NULL,
  PRIMARY KEY (`COD_PUBLICACAO`),
  KEY `fk_pub_tipo_publicacao_idx` (`TIPO_PUBLICACAO`),
  CONSTRAINT `fk_pub_tipo_publicacao` FOREIGN KEY (`TIPO_PUBLICACAO`) REFERENCES `tipo_publicacao` (`ID_TIPO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacao`
--

LOCK TABLES `publicacao` WRITE;
/*!40000 ALTER TABLE `publicacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicacao` ENABLE KEYS */;
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
INSERT INTO `situacaoes` VALUES (2,'Aprovado'),(3,'Aprovado por média'),(6,'Cancelado com onus'),(1,'Cursando'),(4,'Reprovado'),(5,'Reprovado por Falta');
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
-- Table structure for table `sub_area_pos_graduacao`
--

DROP TABLE IF EXISTS `sub_area_pos_graduacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_area_pos_graduacao` (
  `ID_POS_GRADUCAO` int(11) NOT NULL,
  `ID_SUB_AREA` int(11) NOT NULL,
  PRIMARY KEY (`ID_POS_GRADUCAO`,`ID_SUB_AREA`),
  KEY `fk_id_sub_area_pos_idx` (`ID_SUB_AREA`),
  CONSTRAINT `fk_id_sub_area_pos` FOREIGN KEY (`ID_SUB_AREA`) REFERENCES `sub_area` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_pos_grad` FOREIGN KEY (`ID_POS_GRADUCAO`) REFERENCES `pos_graduacao` (`ID_CURSO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_area_pos_graduacao`
--

LOCK TABLES `sub_area_pos_graduacao` WRITE;
/*!40000 ALTER TABLE `sub_area_pos_graduacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_area_pos_graduacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_area_professor`
--

DROP TABLE IF EXISTS `sub_area_professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_area_professor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CPF_PROF` varchar(11) NOT NULL,
  `ID_SUB_AREA` int(4) NOT NULL,
  PRIMARY KEY (`ID`,`CPF_PROF`,`ID_SUB_AREA`),
  KEY `fk_id_sub_area_idx` (`ID_SUB_AREA`),
  KEY `fk_prof_sub_area_idx` (`CPF_PROF`),
  CONSTRAINT `fk_id_sub_area` FOREIGN KEY (`ID_SUB_AREA`) REFERENCES `sub_area` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_prof_sub_area` FOREIGN KEY (`CPF_PROF`) REFERENCES `professor` (`CPF_PROF`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_area_professor`
--

LOCK TABLES `sub_area_professor` WRITE;
/*!40000 ALTER TABLE `sub_area_professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_area_professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_area_projeto`
--

DROP TABLE IF EXISTS `sub_area_projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_area_projeto` (
  `COD_PRJETO` int(11) NOT NULL,
  `COD_SUB_AREA` int(11) NOT NULL,
  PRIMARY KEY (`COD_PRJETO`,`COD_SUB_AREA`),
  KEY `fk_cod_sub_area_rel_idx` (`COD_SUB_AREA`),
  CONSTRAINT `fk_cod_proj` FOREIGN KEY (`COD_PRJETO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_cod_sub_area_rel` FOREIGN KEY (`COD_SUB_AREA`) REFERENCES `sub_area` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_area_projeto`
--

LOCK TABLES `sub_area_projeto` WRITE;
/*!40000 ALTER TABLE `sub_area_projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_area_projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subarea_publicacao`
--

DROP TABLE IF EXISTS `subarea_publicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subarea_publicacao` (
  `ID_PUBLICACAO` int(11) NOT NULL,
  `CODIGO_SUBAREA` int(11) NOT NULL,
  PRIMARY KEY (`ID_PUBLICACAO`,`CODIGO_SUBAREA`),
  KEY `fk_cod_subarea_pub_idx` (`CODIGO_SUBAREA`),
  CONSTRAINT `fk_cod_subarea_pub` FOREIGN KEY (`CODIGO_SUBAREA`) REFERENCES `sub_area` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_publica` FOREIGN KEY (`ID_PUBLICACAO`) REFERENCES `publicacao` (`COD_PUBLICACAO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subarea_publicacao`
--

LOCK TABLES `subarea_publicacao` WRITE;
/*!40000 ALTER TABLE `subarea_publicacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `subarea_publicacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_publicacao`
--

DROP TABLE IF EXISTS `tipo_publicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_publicacao` (
  `ID_TIPO` int(1) NOT NULL AUTO_INCREMENT,
  `NOME_PUBLICACAO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_publicacao`
--

LOCK TABLES `tipo_publicacao` WRITE;
/*!40000 ALTER TABLE `tipo_publicacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_publicacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_projetos`
--

DROP TABLE IF EXISTS `tipos_projetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_projetos` (
  `ID_TIPO` int(1) NOT NULL,
  `NOME_TIPO` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_projetos`
--

LOCK TABLES `tipos_projetos` WRITE;
/*!40000 ALTER TABLE `tipos_projetos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_projetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trilha`
--

DROP TABLE IF EXISTS `trilha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trilha` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `area_de_pesquisa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_area_de_pesquisa_idx` (`area_de_pesquisa`),
  CONSTRAINT `fk_area_de_pesquisa` FOREIGN KEY (`area_de_pesquisa`) REFERENCES `area_de_pesquisa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trilha`
--

LOCK TABLES `trilha` WRITE;
/*!40000 ALTER TABLE `trilha` DISABLE KEYS */;
/*!40000 ALTER TABLE `trilha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voluntario`
--

DROP TABLE IF EXISTS `voluntario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voluntario` (
  `CPF_ALUNO` varchar(11) NOT NULL,
  `ID_PROJETO` int(4) NOT NULL,
  `CARGA_HORARIA` int(3) unsigned zerofill NOT NULL,
  PRIMARY KEY (`CPF_ALUNO`,`ID_PROJETO`),
  KEY `fk_id_projeto_voluntario_idx` (`ID_PROJETO`),
  CONSTRAINT `fk_cpf_aluno_voluntario` FOREIGN KEY (`CPF_ALUNO`) REFERENCES `aluno` (`CPF_ALU`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_id_projeto_voluntario` FOREIGN KEY (`ID_PROJETO`) REFERENCES `projeto` (`CODIGO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voluntario`
--

LOCK TABLES `voluntario` WRITE;
/*!40000 ALTER TABLE `voluntario` DISABLE KEYS */;
/*!40000 ALTER TABLE `voluntario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'deinfo'
--

--
-- Dumping routines for database 'deinfo'
--
/*!50003 DROP FUNCTION IF EXISTS `calculaMediaFinal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `calculaMediaFinal`(nota1 float, nota2 float, nota3 float) RETURNS float
BEGIN
	DECLARE MAIOR1, MAIOR2, MEDIAFINAL FLOAT;
   
	if nota1 >= nota2 && nota1 >= nota3 then
		set MAIOR1 = nota1;
		if(nota2 >= nota3) THEN
			 set MAIOR2 = nota2;
		else 
			SET MAIOR2 = nota3;
		end iF;
	ELSEIF nota2 >= nota1 && nota2 >= nota3 THEN
		SET maior1 = nota2;
		if(nota1 >= nota3) then
			set MAIOR2 = nota1;
		else
			set maior2 = nota3;
		end if;
	elseif nota3 >= nota1 && nota3 >= nota2 then
		set MAIOR1 = nota3;
		if(nota1 >= nota2) THEN
			SET MAIOR2 = nota1;
		else
			SET MAIOR2 = nota2;
		END IF;
	END if;
    
    set MEDIAFINAL =  (maior1+maior2)/2;
    
    return MEDIAFINAL;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-09 15:17:01
