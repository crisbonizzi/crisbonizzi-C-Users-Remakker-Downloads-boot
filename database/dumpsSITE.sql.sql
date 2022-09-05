CREATE DATABASE  IF NOT EXISTS `site` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `site`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: site
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente_cadastro`
--

DROP TABLE IF EXISTS `cliente_cadastro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_cadastro` (
  `id_cliente_cadastro` int NOT NULL AUTO_INCREMENT,
  `nome_cliente_cadastro` varchar(80) DEFAULT NULL,
  `cpf_cliente_cadastro` varchar(20) DEFAULT NULL,
  `telefone_cliente_cadastro` varchar(20) DEFAULT NULL,
  `email_cliente_cadastro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_cliente_cadastro`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_cadastro`
--

LOCK TABLES `cliente_cadastro` WRITE;
/*!40000 ALTER TABLE `cliente_cadastro` DISABLE KEYS */;
INSERT INTO `cliente_cadastro` VALUES (1,'Cristiane Mello','6445768743301','1196676','cris_mello85@hotmail,com'),(2,'Jeová Mello','6445768743302','119634786','jeova_mello85@hotmail,com'),(3,'Flavio Bonizzi','6445768743303','1196547876','fla_mello85@hotmail,com'),(4,'Julia Mello Bonizzi','6445768743304','1163347876','cju_mello85@hotmail,com'),(5,'Pedro Mello Bonizzi','6445768743305','1197913376','cpedrs_mello85@hotmail,com'),(6,'Regina Mello','6445768743306','119645676','creg_mello85@hotmail,com'),(7,'Dayane Lhamas','6445768743307','1194509876','day_mello85@hotmail,com'),(8,'Lucas Monteiro','6445768743308','119623476','luca_mello85@hotmail,com'),(9,'Viviane Mello','6445768743309','1196534576','vivia_mello85@hotmail,com'),(10,'Vivian Souza','6445768743310','119697556','vivian_mello85@hotmail,com'),(11,'Marcos',NULL,NULL,NULL),(12,'Vânia','3356783245','1195467654','vania@obrigadaportudo'),(16,'Vânia e Cris','3356783245','1195467654','vcssao10@obrigadaportudo');
/*!40000 ALTER TABLE `cliente_cadastro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `id_cliente_cadastro` int DEFAULT NULL,
  `id_passagem` int DEFAULT NULL,
  `id_pacote_viagem` int DEFAULT NULL,
  `valor_compra` decimal(8,0) DEFAULT NULL,
  `data_compra` datetime DEFAULT NULL,
  `qtd_itens_compra` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_cliente_cadastro` (`id_cliente_cadastro`),
  KEY `id_pacote_viagem` (`id_pacote_viagem`),
  KEY `id_passagem` (`id_passagem`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_cliente_cadastro`) REFERENCES `cliente_cadastro` (`id_cliente_cadastro`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_pacote_viagem`) REFERENCES `pacote_viagem` (`id_pacote_viagem`),
  CONSTRAINT `compra_ibfk_3` FOREIGN KEY (`id_passagem`) REFERENCES `passagens` (`id_passagem`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,NULL,NULL,NULL,1,'1985-07-25 00:00:00','3'),(2,NULL,NULL,NULL,2,'1985-07-26 00:00:00',' 4'),(3,NULL,NULL,NULL,3,'1985-07-27 00:00:00','5'),(4,NULL,NULL,NULL,4,'1985-07-25 00:00:00','6'),(5,NULL,NULL,NULL,5,'1985-07-25 00:00:00','7'),(6,NULL,NULL,NULL,6,'1985-07-25 00:00:00','8'),(7,NULL,NULL,NULL,7,'1985-07-25 00:00:00','9'),(8,NULL,NULL,NULL,8,'1985-07-25 00:00:00','2'),(9,NULL,NULL,NULL,9,'1985-07-25 00:00:00','1'),(10,NULL,NULL,NULL,10,'1985-07-25 00:00:00','10'),(21,1,1,NULL,NULL,NULL,NULL),(22,2,2,NULL,NULL,NULL,NULL),(23,3,3,NULL,NULL,NULL,NULL),(24,4,4,NULL,NULL,NULL,NULL),(25,5,5,NULL,NULL,NULL,NULL),(26,6,6,NULL,NULL,NULL,NULL),(27,7,7,NULL,NULL,NULL,NULL),(28,8,8,NULL,NULL,NULL,NULL),(29,9,9,NULL,NULL,NULL,NULL),(30,10,10,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destino`
--

DROP TABLE IF EXISTS `destino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destino` (
  `id_destino` int NOT NULL AUTO_INCREMENT,
  `cidade_destino` varchar(50) DEFAULT NULL,
  `pais_destino` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_destino`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destino`
--

LOCK TABLES `destino` WRITE;
/*!40000 ALTER TABLE `destino` DISABLE KEYS */;
INSERT INTO `destino` VALUES (1,'Salvador','Italia'),(2,'Fortaleza','França'),(3,'Rio de Janeiro','Tailandia'),(4,'Brasilia','Mexico'),(5,'Vitoria','Reino Unido'),(6,'Salvador','Portugal'),(7,'Cuiaba','Auastralia'),(8,'Curitiba','Estados Unidos'),(9,'Natal','Italia'),(10,'Belem','Italia'),(11,'Cuiaba','Espanha'),(12,'Campinas','Peru');
/*!40000 ALTER TABLE `destino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacote_viagem`
--

DROP TABLE IF EXISTS `pacote_viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacote_viagem` (
  `id_pacote_viagem` int NOT NULL AUTO_INCREMENT,
  `id_passagem` int DEFAULT NULL,
  `hoteis` varchar(100) DEFAULT NULL,
  `acomodacao` varchar(50) DEFAULT NULL,
  `preco_pacote` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`id_pacote_viagem`),
  KEY `id_passagem` (`id_passagem`),
  CONSTRAINT `pacote_viagem_ibfk_1` FOREIGN KEY (`id_passagem`) REFERENCES `passagens` (`id_passagem`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacote_viagem`
--

LOCK TABLES `pacote_viagem` WRITE;
/*!40000 ALTER TABLE `pacote_viagem` DISABLE KEYS */;
INSERT INTO `pacote_viagem` VALUES (1,NULL,'Hotel Boutique','family room',16),(2,NULL,'Palacio Tangara','Stantard Studio',9),(3,NULL,'Rio Hotel by Bourbon Sao Paulo','Grand Queen',10),(4,NULL,'Hotel IBIS','Studio',7),(5,NULL,'Hotel Panamby','Triple Room',6);
/*!40000 ALTER TABLE `pacote_viagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passagens`
--

DROP TABLE IF EXISTS `passagens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passagens` (
  `id_passagem` int NOT NULL AUTO_INCREMENT,
  `id_destino` int DEFAULT NULL,
  `preco_passagem` decimal(8,0) DEFAULT NULL,
  `data_ida_passagem` datetime DEFAULT NULL,
  `data_volta_passagem` datetime DEFAULT NULL,
  `origem_passagem` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_passagem`),
  KEY `id_destino` (`id_destino`),
  CONSTRAINT `passagens_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passagens`
--

LOCK TABLES `passagens` WRITE;
/*!40000 ALTER TABLE `passagens` DISABLE KEYS */;
INSERT INTO `passagens` VALUES (1,1,3,'2022-05-12 00:00:00',NULL,NULL),(2,2,3,'2022-05-02 00:00:00',NULL,NULL),(3,3,7,'2022-05-23 00:00:00',NULL,NULL),(4,4,4,'2022-05-05 00:00:00',NULL,NULL),(5,5,6,'2022-05-25 00:00:00',NULL,NULL),(6,NULL,NULL,NULL,'2022-06-15 00:00:00','São Paulo'),(7,NULL,NULL,NULL,'2022-05-07 00:00:00','Rio de Janeiro'),(8,NULL,NULL,NULL,'2022-05-29 00:00:00','Curitiba'),(9,NULL,NULL,NULL,'2022-05-15 00:00:00','Recife'),(10,NULL,NULL,NULL,'2022-06-02 00:00:00','Maceio');
/*!40000 ALTER TABLE `passagens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'site'
--

--
-- Dumping routines for database 'site'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-05 15:11:44
