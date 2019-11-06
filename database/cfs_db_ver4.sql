-- MySQL dump 10.13  Distrib 5.7.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: coffeeshopdb
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.8-MariaDB

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
-- Table structure for table `allcode`
--

DROP TABLE IF EXISTS `allcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cdName` varchar(100) DEFAULT NULL,
  `cdValue` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `content` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `cdType` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allcode`
--

LOCK TABLES `allcode` WRITE;
/*!40000 ALTER TABLE `allcode` DISABLE KEYS */;
INSERT INTO `allcode` VALUES (1,'ORDER_STATUS','N','Mới nhận','TR',1),(2,'ORDER_UPDATE_STATUS','D','Đã xử lý','TR',2),(3,'A_STATUS','A','Hoạt động','CM',1),(4,'A_STATUS','I','Đã ngưng','CM',2),(5,'ORDER_UPDATE_STATUS','C','Hủy','TR',3);
/*!40000 ALTER TABLE `allcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cm_table`
--

DROP TABLE IF EXISTS `cm_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cm_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cm_table`
--

LOCK TABLES `cm_table` WRITE;
/*!40000 ALTER TABLE `cm_table` DISABLE KEYS */;
INSERT INTO `cm_table` VALUES (1,'1','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(2,'2','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(3,'3','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(4,'4','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(5,'5','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(6,'6','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(7,'7','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(8,'8','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(9,'9','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(10,'10','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(11,'11','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(12,'12','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(13,'13','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(14,'14','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(15,'15','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(16,'16','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(17,'17','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(18,'18','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(19,'19','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(20,'20','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(21,'21','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(22,'22','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(23,'23','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(24,'24','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(25,'25','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(26,'26','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(27,'27','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(28,'28','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(29,'29','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(30,'30','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(31,'31','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(32,'32','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(33,'33','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(34,'34','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(35,'35','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(36,'36','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(37,'37','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(38,'38','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(39,'39','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(40,'40','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(41,'41','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(42,'42','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(43,'43','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(44,'44','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(45,'45','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(46,'46','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(47,'47','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(48,'48','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(49,'49','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(50,'50','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(51,'51','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(52,'52','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(53,'53','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(54,'54','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(55,'55','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(56,'56','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(57,'57','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(58,'58','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(59,'59','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(60,'60','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(61,'61','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(62,'62','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(63,'63','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(64,'64','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(65,'65','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(66,'66','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(67,'67','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(68,'68','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(69,'69','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(70,'70','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(71,'71','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(72,'72','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(73,'73','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(74,'74','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(75,'75','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(76,'76','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(77,'77','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(78,'78','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(79,'79','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(80,'80','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(81,'81','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(82,'82','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(83,'83','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(84,'84','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(85,'85','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(86,'86','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(87,'87','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(88,'88','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(89,'89','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(90,'90','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(91,'91','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(92,'92','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(93,'93','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(94,'94','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(95,'95','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(96,'96','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(97,'97','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(98,'98','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(99,'99','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(100,'100','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(101,'101','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(102,'102','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(103,'103','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(104,'104','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(105,'105','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(106,'106','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(107,'107','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(108,'108','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(109,'109','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(110,'110','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(111,'111','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(112,'112','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(113,'113','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(114,'114','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(115,'115','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(116,'116','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(117,'117','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(118,'118','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(119,'119','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(120,'120','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(121,'121','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(122,'122','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(123,'123','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(124,'124','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(125,'125','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(126,'126','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(127,'127','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(128,'128','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(129,'129','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(130,'130','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(131,'131','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(132,'132','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(133,'133','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(134,'134','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(135,'135','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(136,'136','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(137,'137','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(138,'138','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(139,'139','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(140,'140','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(141,'141','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(142,'142','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(143,'143','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(144,'144','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(145,'145','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(146,'146','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(147,'147','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(148,'148','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A'),(149,'149','I',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin','A');
/*!40000 ALTER TABLE `cm_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) DEFAULT NULL,
  `image` varchar(6000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'EMP000000000001','KHANG','1998-05-15 00:00:00','0938422612','KXT KHU A, DHQG',0,'2019-10-20 00:00:00','admin','2019-10-23 00:00:00','admin','/dataSource/images/employees/DSC_6426.jpg'),(3,'EMP000000000002','Ngô Trung Cỏn ','1999-03-28 00:00:00','093233561','KXT KHU A, DHQG',0,'2019-10-20 00:00:00','admin','2019-11-06 00:00:00','admin',''),(5,'EMP000000000003','Chung Bùi','1998-10-15 00:00:00','01234','215 Nguyễn Kiệm, Gò Vấp',0,'2019-10-23 00:00:00','admin','2019-10-23 00:00:00','admin','/dataSource/images/employees/BuiDangHongChung.jpg');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (2,'GD0000000000001','Bánh mì',150000.00,8,'Lô 100 ổ 1 lần nhập','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(3,'GD0000000000002','Thịt bò',250000.00,8,'Tính theo đơn vị kg','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(4,'GD0000000000003','Nước sốt',40000.00,9,'Nước sốt tính theo 10 chai 1 lần nhập','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(5,'GD0000000000004','Khoai tây',10000.00,9,'Tình theo kg nhập','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(6,'GD0000000000005','Thịt gà',65000.00,8,'Tính theo con','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodscategory`
--

DROP TABLE IF EXISTS `goodscategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodscategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodscategory`
--

LOCK TABLES `goodscategory` WRITE;
/*!40000 ALTER TABLE `goodscategory` DISABLE KEYS */;
INSERT INTO `goodscategory` VALUES (8,'GDC000000000001','Nguyên liệu chính','Nhóm nguyên liệu chính',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(9,'GDC000000000002','Phụ gia','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(10,'GDC000000000003','Nước ngọt','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL);
/*!40000 ALTER TABLE `goodscategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `totalPrice` decimal(16,2) DEFAULT NULL,
  `discountPercent` decimal(16,2) DEFAULT NULL,
  `fee` decimal(16,2) DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `tableId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (27,'ORD000000000001','1',0.00,706500.00,0.10,25000.00,'','D',0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL,NULL),(28,'ORD000000000002','30',0.00,0.00,0.00,0.00,'Khangth, 2/11/2019\nHủy phiếu đặt do hệ thông phát sinh lỗi.\nKhông thêm được dữ liệu chi tiết, giai đoạn kiểm thử 01','C',0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL,NULL),(29,'ORD000000000003','10',0.00,432000.00,0.00,20000.00,'','D',0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL,NULL),(30,'ORD000000000004','4',0.00,850000.00,0.00,0.00,'Khach hang khong lien lac duoc','C',0,'2019-11-05 00:00:00','','2019-11-06 00:00:00',NULL,NULL),(31,'ORD000000000005','5',0.00,855000.00,0.10,50000.00,'','D',0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL,NULL),(32,'ORD000000000006','',198000.00,196200.00,0.10,20000.00,'','D',0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL,NULL),(33,'ORD000000000007','4',462000.00,512000.00,0.00,50000.00,'','D',0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `totalPrice` decimal(16,2) DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (21,29,19,12000.00,1,12000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL),(22,29,17,150000.00,1,150000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL),(23,29,18,250000.00,1,250000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL),(24,27,17,150000.00,3,450000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL),(25,27,18,250000.00,1,250000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL),(26,27,19,12000.00,5,60000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL),(33,32,19,12000.00,4,48000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(34,32,17,150000.00,1,150000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(35,31,17,150000.00,1,150000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(36,31,18,250000.00,3,750000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(37,30,17,150000.00,4,600000.00,NULL,NULL,0,'2019-11-05 00:00:00','','2019-11-06 00:00:00',NULL),(38,30,18,250000.00,1,250000.00,NULL,NULL,0,'2019-11-05 00:00:00','','2019-11-06 00:00:00',NULL),(43,33,19,12000.00,1,12000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(44,33,17,150000.00,3,450000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(6000) CHARACTER SET utf8 DEFAULT NULL,
  `thumbnail` varchar(6000) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (17,'PRD000000000001','Gà sốt tiêu đen',150000.00,5,'Gà sốt tiêu truyền thống,được nướng với gia vị độc quyền','/dataSource/images/products/ga-sot-tieu-den.jpg','','','A',0,'2019-10-27 00:00:00','','2019-10-28 00:00:00',NULL),(18,'PRD000000000002','Burger bò Bulgogi',250000.00,5,'Burger với thịt bò thượng hạn, cho trải nghiệm thêm thú vị','/dataSource/images/products/bulgogi-burger.jpg','','','A',0,'2019-10-27 00:00:00','','2019-10-28 00:00:00',NULL),(19,'PRD000000000003','Pepsi',12000.00,4,'Nước ngọt Pepsi','/dataSource/images/products/pepsi.jpg','','','A',0,'2019-10-27 00:00:00','','2019-10-28 00:00:00',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategory`
--

DROP TABLE IF EXISTS `productcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(6000) CHARACTER SET utf8 DEFAULT NULL,
  `thumbnail` varchar(6000) CHARACTER SET utf8 DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
INSERT INTO `productcategory` VALUES (4,'PRDC00000000001','Đồ uống','Các loại nước uống','','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(5,'PRDC00000000002','Đồ ăn','Các loại đồ ăn quán cung cấp','','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL),(6,'PRDC00000000003','Tráng miệng','Các loại món tráng miệng đi kèm','','',0,'2019-10-27 00:00:00','','2019-10-27 00:00:00',NULL);
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Staff','Nhân viên',0,'2019-11-05 00:00:00','system-admin','2019-11-05 00:00:00','system-admin'),(2,'Manager','Quản lý',0,'2019-11-05 00:00:00','system-admin','2019-11-05 00:00:00','system-admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_codemasters`
--

DROP TABLE IF EXISTS `sys_codemasters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_codemasters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prefix` varchar(10) DEFAULT NULL,
  `curValue` decimal(18,0) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `active` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_codemasters`
--

LOCK TABLES `sys_codemasters` WRITE;
/*!40000 ALTER TABLE `sys_codemasters` DISABLE KEYS */;
INSERT INTO `sys_codemasters` VALUES (1,'ORD',7,NULL,'1'),(10,'EMP',3,NULL,'1'),(11,'GD',5,NULL,'1'),(12,'GDC',3,NULL,'1'),(13,'PRD',3,NULL,'1'),(14,'PRDC',3,NULL,'1'),(15,'USER',3,'','1');
/*!40000 ALTER TABLE `sys_codemasters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_error`
--

DROP TABLE IF EXISTS `sys_error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `form` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_error`
--

LOCK TABLES `sys_error` WRITE;
/*!40000 ALTER TABLE `sys_error` DISABLE KEYS */;
INSERT INTO `sys_error` VALUES (1,'OBJ-01','','Đối tượng đã tồn tại'),(2,'OBJ-02',NULL,'Mã code không hợp lệ'),(3,'OBJ-03',NULL,'Đối tượng không tồn tại'),(4,'SYS-01',NULL,'Có lỗi xảy ra với hệ thống'),(5,'LIST-01',NULL,'Danh sách chi tiết không hợp lệ'),(6,'ORD-01',NULL,'Yêu cầu diễn giải nguyên nhân hủy phiếu'),(7,'USER-01',NULL,'Tên đăng nhập không được phép rỗng'),(8,'USER-02',NULL,'Tên đăng nhập bắt buộc phải có ít nhất n ký tự'),(9,'USER-03',NULL,'Mật khẩu  không được phép rỗng'),(10,'USER-04',NULL,'Mật khẩu  bắt buộc phải có ít nhất n ký tự');
/*!40000 ALTER TABLE `sys_error` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_parameters`
--

DROP TABLE IF EXISTS `sys_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_parameters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `value` varchar(256) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_parameters`
--

LOCK TABLES `sys_parameters` WRITE;
/*!40000 ALTER TABLE `sys_parameters` DISABLE KEYS */;
INSERT INTO `sys_parameters` VALUES (1,'tblMaxCount','40','Số bàn không được vượt quá số bàn hiện tại trong hệ thống',0,'2019-10-19 00:00:00','admin','2019-10-19 00:00:00','admin');
/*!40000 ALTER TABLE `sys_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_prefix`
--

DROP TABLE IF EXISTS `sys_prefix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_prefix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `prefix` varchar(10) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_prefix`
--

LOCK TABLES `sys_prefix` WRITE;
/*!40000 ALTER TABLE `sys_prefix` DISABLE KEYS */;
INSERT INTO `sys_prefix` VALUES (1,'TR_ORDER','ORD','Bảng ORDER'),(2,'CM_EMPLOYEE','EMP','Bảng EMPLOYEE'),(3,'PUR_GOODS','GD','Bảng GOODS'),(4,'PUR_GOODSCATEGORY','GDC','Bảng GOODSCATEGORY'),(5,'TR_PRODUCT','PRD','Bảng PRODUCT'),(6,'TR_PRODUCTCATEGORY','PRDC','Bảng PRODUCTCATEGORY'),(7,'SYS_USER','USER','Bảng USER');
/*!40000 ALTER TABLE `sys_prefix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `username` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `employeeId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'USER00000000001','khangth','123456',1,2,0,'2019-11-05 00:00:00','','2019-11-05 00:00:00',NULL),(2,'USER00000000002','chungbdh','123456',5,1,0,'2019-11-05 00:00:00','','2019-11-05 00:00:00',NULL),(3,'USER00000000003','admin','123456',1,2,0,'2019-11-05 00:00:00','','2019-11-05 00:00:00',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-07  0:32:43
