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
  `employeeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (27,'ORD000000000001','1',0.00,706500.00,0.10,25000.00,'','D',0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL,NULL,NULL),(28,'ORD000000000002','30',0.00,0.00,0.00,0.00,'Khangth, 2/11/2019\nHủy phiếu đặt do hệ thông phát sinh lỗi.\nKhông thêm được dữ liệu chi tiết, giai đoạn kiểm thử 01','C',0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL,NULL,NULL),(29,'ORD000000000003','10',0.00,432000.00,0.00,20000.00,'','D',0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL,NULL,NULL),(30,'ORD000000000004','4',0.00,850000.00,0.00,0.00,'Khach hang khong lien lac duoc','C',0,'2019-11-05 00:00:00','','2019-11-06 00:00:00',NULL,NULL,NULL),(31,'ORD000000000005','5',0.00,855000.00,0.10,50000.00,'','D',0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL,NULL,NULL),(32,'ORD000000000006','',198000.00,196200.00,0.10,20000.00,'','D',0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL,NULL,NULL),(33,'ORD000000000007','4',462000.00,512000.00,0.00,50000.00,'','D',0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL,NULL,NULL),(34,'ORD000000000008','12',1012000.00,1112000.00,0.00,100000.00,'','D',0,'2019-11-16 00:00:00','admin','2019-11-16 00:00:00','admin',NULL,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (21,29,19,12000.00,1,12000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL),(22,29,17,150000.00,1,150000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL),(23,29,18,250000.00,1,250000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-02 00:00:00',NULL),(24,27,17,150000.00,3,450000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL),(25,27,18,250000.00,1,250000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL),(26,27,19,12000.00,5,60000.00,NULL,NULL,0,'2019-11-02 00:00:00','','2019-11-03 00:00:00',NULL),(33,32,19,12000.00,4,48000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(34,32,17,150000.00,1,150000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(35,31,17,150000.00,1,150000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(36,31,18,250000.00,3,750000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(37,30,17,150000.00,4,600000.00,NULL,NULL,0,'2019-11-05 00:00:00','','2019-11-06 00:00:00',NULL),(38,30,18,250000.00,1,250000.00,NULL,NULL,0,'2019-11-05 00:00:00','','2019-11-06 00:00:00',NULL),(43,33,19,12000.00,1,12000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(44,33,17,150000.00,3,450000.00,NULL,NULL,0,'2019-11-06 00:00:00','','2019-11-06 00:00:00',NULL),(45,34,19,12000.00,1,12000.00,NULL,NULL,0,'2019-11-16 00:00:00','admin','2019-11-16 00:00:00','admin'),(46,34,17,150000.00,5,750000.00,NULL,NULL,0,'2019-11-16 00:00:00','admin','2019-11-16 00:00:00','admin'),(47,34,18,250000.00,1,250000.00,NULL,NULL,0,'2019-11-16 00:00:00','admin','2019-11-16 00:00:00','admin');
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
INSERT INTO `sys_codemasters` VALUES (1,'ORD',8,NULL,'1'),(10,'EMP',3,NULL,'1'),(11,'GD',5,NULL,'1'),(12,'GDC',3,NULL,'1'),(13,'PRD',3,NULL,'1'),(14,'PRDC',3,NULL,'1'),(15,'USER',3,'','1');
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

--
-- Dumping routines for database 'coffeeshopdb'
--
/*!50003 DROP FUNCTION IF EXISTS `fn_SYS_CodeMasters_Gen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_SYS_CodeMasters_Gen`(`p_Kind` varchar(100),  `p_KeyGen` varchar(15)) RETURNS int(11)
RETURN  `p_KeyGen`; ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ALLCODE_ById` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ALLCODE_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `ALLCODE` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `ALLCODE_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ALLCODE_InsOrUpd`(
	`p_Id` INT,
`p_CdName` varchar(100),
`p_CdValue` nvarchar(256),
`p_Content` nvarchar(256),
`p_CdType` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
	INSERT INTO `ALLCODE`(`id`,`cdName`,`cdValue`,`content`,`cdType`) 
        VALUES(`p_Id`,`p_CdName`,`p_CdValue`,`p_Content`,`p_CdType`); 
	ELSE
		UPDATE `ALLCODE` A
        	SET
			`cdName` = `p_CdName`,
		`cdValue` = `p_CdValue`,
		`content` = `p_Content`,
		`cdType` = `p_CdType`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ALLCODE_LstByCode` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ALLCODE_LstByCode`(
IN `p_CdName` NVARCHAR(100)
)
proc_label:BEGIN
	SELECT * FROM `ALLCODE` A WHERE A.`cdName` = `p_CdName`
    ORDER BY A.`priority`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `ALLCODE_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ALLCODE_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `ALLCODE` A WHERE
		(A.`content` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`content` IS NULL OR A.`content` = '');
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `ALLCODE` A ;  
	ELSE
		SELECT A.*
		FROM `ALLCODE` A  
		WHERE
			(A.`content` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`content` IS NULL OR A.`content` = '')
		ORDER BY 
		A.`cdType` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CM_TABLE_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CM_TABLE_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `CM_TABLE` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CM_TABLE_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CM_TABLE_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Type` varchar(100),
`p_Status` varchar(100),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `CM_TABLE` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
			THEN
				SET sErrorCode = 'OBJ-03';           
			END IF;		    
		END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
	INSERT INTO `CM_TABLE`(`id`,`code`,`type`,`status`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_Code`,`p_Type`,`p_Status`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `CM_TABLE` A
        	SET
			`code` = `p_Code`,
		`type` = `p_Type`,
		`status` = `p_Status`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CM_TABLE_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CM_TABLE_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `CM_TABLE` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `CM_TABLE` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `CM_TABLE` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CUSTOMER_ById` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CUSTOMER_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `CUSTOMER` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CUSTOMER_InsOrUpd` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CUSTOMER_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Birthday` datetime,
`p_PhoneNumber` varchar(20),
`p_Address` nvarchar(256),
`p_District` nvarchar(256),
`p_Area` nvarchar(256),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `CUSTOMER` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
			THEN
				SET sErrorCode = 'OBJ-03';           
			END IF;		    
		END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
	INSERT INTO `CUSTOMER`(`id`,`code`,`name`,`birthday`,`phoneNumber`,`address`,`district`,`area`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_Code`,`p_Name`,`p_Birthday`,`p_PhoneNumber`,`p_Address`,`p_District`,`p_Area`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `CUSTOMER` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`birthday` = `p_Birthday`,
		`phoneNumber` = `p_PhoneNumber`,
		`address` = `p_Address`,
		`district` = `p_District`,
		`area` = `p_Area`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
	IF `isRollback` THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CUSTOMER_Search` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CUSTOMER_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `CUSTOMER` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
    SELECT A.*
		FROM `CUSTOMER` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0)    
	ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `EMPLOYEE_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EMPLOYEE_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `EMPLOYEE` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EMPLOYEE_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EMPLOYEE_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Image` nvarchar(6000),
`p_Birthday` datetime,
`p_PhoneNumber` varchar(20),
`p_Address` nvarchar(500),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
    DECLARE `p_CodeGen` nvarchar(100);
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
			IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
			THEN
				IF NOT EXISTS(SELECT * FROM `EMPLOYEE` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
				THEN
					SET sErrorCode = 'OBJ-03';           
				END IF;				
			END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
    CALL sp_fn_SYS_CodeMasters_Gen('CM_EMPLOYEE',`p_CodeGen`);
	INSERT INTO `EMPLOYEE`(`id`,`code`,`name`,`image`,`birthday`,`phoneNumber`,`address`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_CodeGen`,`p_Name`,`p_Image`,`p_Birthday`,`p_PhoneNumber`,`p_Address`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `EMPLOYEE` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`image` = `p_Image`,
		`birthday` = `p_Birthday`,
		`phoneNumber` = `p_PhoneNumber`,
		`address` = `p_Address`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EMPLOYEE_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EMPLOYEE_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `EMPLOYEE` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `EMPLOYEE` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `EMPLOYEE` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GOODSCATEGORY_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GOODSCATEGORY_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `GOODSCATEGORY` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GOODSCATEGORY_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GOODSCATEGORY_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Description` nvarchar(500),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
    DECLARE `p_CodeGen` nvarchar(100);
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
			IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
			THEN
				IF NOT EXISTS(SELECT * FROM `GOODSCATEGORY` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
				THEN
					SET sErrorCode = 'OBJ-03';           
				END IF;
			ELSE
				SET sErrorCode = 'OBJ-01';
			END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
    CALL sp_fn_SYS_CodeMasters_Gen('PUR_GOODSCATEGORY',`p_CodeGen`);
	INSERT INTO `GOODSCATEGORY`(`id`,`code`,`name`,`description`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_CodeGen`,`p_Name`,`p_Description`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `GOODSCATEGORY` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`description` = `p_Description`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GOODSCATEGORY_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GOODSCATEGORY_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `GOODSCATEGORY` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `GOODSCATEGORY` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `GOODSCATEGORY` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GOODS_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GOODS_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `GOODS` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GOODS_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GOODS_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Price` decimal(16,2),
`p_CategoryId` int,
`p_Description` nvarchar(500),
`p_Note` nvarchar(500),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
    DECLARE `p_CodeGen` nvarchar(100);
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
			IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
			THEN
				IF NOT EXISTS(SELECT * FROM `GOODS` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
				THEN
					SET sErrorCode = 'OBJ-03';           
				END IF;		 
			ELSE
				SET sErrorCode = 'OBJ-01'; 
			END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
     CALL sp_fn_SYS_CodeMasters_Gen('PUR_GOODS',`p_CodeGen`);   
	INSERT INTO `GOODS`(`id`,`code`,`name`,`price`,`categoryId`,`description`,`note`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_CodeGen`,`p_Name`,`p_Price`,`p_CategoryId`,`p_Description`,`p_Note`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
    ELSE
		UPDATE `GOODS` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`price` = `p_Price`,
		`categoryId` = `p_CategoryId`,
		`description` = `p_Description`,
		`note` = `p_Note`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GOODS_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GOODS_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `GOODS` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `GOODS` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `GOODS` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ORDERDETAIL_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDERDETAIL_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.*, B.`id` as productId ,B.`code` as productCode, B.`name` as productName 
   FROM `ORDERDETAIL` A
		INNER JOIN `PRODUCT` B ON B.`id` = A.`productId`
   
   WHERE 
	A.`orderId` = `p_Id` 	
	AND A.`orderId` = `p_Id`
    AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ORDERDETAIL_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDERDETAIL_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `ORDERDETAIL` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `ORDERDETAIL` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `ORDERDETAIL` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ORDER_ById` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDER_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `ORDER` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `ORDER_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDER_InsOrUpd`(
`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Price` decimal(16,2),
`p_TotalPrice` decimal(16,2),
`p_DiscountPercent` decimal(16,2),
`p_Fee` decimal(16,2),
`p_EmployeeId` int,
`p_StrOrderDetails` nvarchar(10000),
`p_Note` nvarchar(500),
`p_Status` varchar(50),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE i INT DEFAULT 0;
	DECLARE `p_OrderId` INT DEFAULT 0;
    DECLARE `p_CodeGen` nvarchar(100);
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
   
			 IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
			 THEN
				IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
				THEN
					IF NOT EXISTS(SELECT * FROM `ORDER` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
					THEN
						SET sErrorCode = 'OBJ-03'; 
					ELSE	
						-- check status cancel
                        IF(sErrorCode = '')
                        THEN
							IF(`p_Status` IS NOT NULL AND `p_Status`='C')
							THEN 
								IF (`p_Note` IS NULL OR `p_Note` = '')
								THEN                    
									SET sErrorCode = 'ORD-01'; 
								END IF;
							ELSE
								-- empty list
								IF(sErrorCode = '')
								THEN
									IF(`p_StrOrderDetails` IS NULL OR `p_StrOrderDetails` = '')
									THEN
										SET sErrorCode = 'LIST-01';
									END IF; 
								END IF;	
							END IF;    
                        END IF;			
                        
                        
					END IF;	
				ELSE
					SET sErrorCode = 'OBJ-02'; 
				END IF;
			END IF;
        
	
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
		CALL sp_fn_SYS_CodeMasters_Gen('TR_ORDER',`p_CodeGen`);
		INSERT INTO `ORDER`(`id`,`code`,`name`,`price`,`totalPrice`,`discountPercent`,`fee`,`employeeId`,`note`,`status`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
			VALUES(`p_Id`,`p_CodeGen`,`p_Name`,`p_Price`,`p_TotalPrice`,`p_DiscountPercent`,`p_Fee`,`p_EmployeeId`,`p_Note`,`p_Status`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
		SET `p_OrderId` = LAST_INSERT_ID();
    ELSE
		UPDATE `ORDER` A
		SET
		`code` = `p_Code`,
		`name` = `p_Name`,
		`price` = `p_Price`,
		`totalPrice` = `p_TotalPrice`,
		`discountPercent` = `p_DiscountPercent`,
		`fee` = `p_Fee`,
        `employeeId`=`p_EmployeeId`,
		`note` = `p_Note`,
		`status` = `p_Status`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`
		WHERE A.`id` = `p_Id`;
        
        SET `p_OrderId` = `p_Id`;
		DELETE FROM `orderdetail` WHERE `orderId` = `p_OrderId`;
    END IF;
	
detail_loop:WHILE i < JSON_LENGTH(`p_StrOrderDetails`) DO  
			INSERT INTO `ORDERDETAIL`(`id`,`orderId`,`productId`,`price`,`quantity`,`totalPrice`,`note`,`status`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
			VALUES(
				NULL,
				`p_OrderId`,
				JSON_EXTRACT(`p_StrOrderDetails`,CONCAT('$[',i,'].productId')),
				JSON_EXTRACT(`p_StrOrderDetails`,CONCAT('$[',i,'].price')),
				JSON_EXTRACT(`p_StrOrderDetails`,CONCAT('$[',i,'].quantity')),
				JSON_EXTRACT(`p_StrOrderDetails`,CONCAT('$[',i,'].totalPrice')),
				JSON_EXTRACT(`p_StrOrderDetails`,CONCAT('$[',i,'].note')),
				JSON_EXTRACT(`p_StrOrderDetails`,CONCAT('$[',i,'].status')),
				`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`
			);            
			
			IF `isRollback` 
			THEN						
				LEAVE detail_loop;
		   END IF;
			
			SET i = i+1;        
		END WHILE;
 
   
   IF `isRollback` 
   THEN		
		ROLLBACK;
		SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
	ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ORDER_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDER_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `ORDER` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `ORDER` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `ORDER` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
            AND (A.`status` <> 'C')
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCTCATEGORY_ById` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCTCATEGORY_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `PRODUCTCATEGORY` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCTCATEGORY_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCTCATEGORY_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Description` nvarchar(500),
`p_Image` nvarchar(6000),
`p_Thumbnail` nvarchar(6000),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
    DECLARE `p_CodeGen` nvarchar(100);
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `PRODUCTCATEGORY` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
			THEN
				SET sErrorCode = 'OBJ-03';           
			END IF;		    
		END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
    CALL sp_fn_SYS_CodeMasters_Gen('TR_PRODUCTCATEGORY',`p_CodeGen`);
	INSERT INTO `PRODUCTCATEGORY`(`id`,`code`,`name`,`description`,`image`,`thumbnail`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_CodeGen`,`p_Name`,`p_Description`,`p_Image`,`p_Thumbnail`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `PRODUCTCATEGORY` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`description` = `p_Description`,
		`image` = `p_Image`,
		`thumbnail` = `p_Thumbnail`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCTCATEGORY_Lst` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCTCATEGORY_Lst`()
proc_label:BEGIN
	SELECT * FROM `PRODUCTCATEGORY` A WHERE A.`isDeleted` = 0;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCTCATEGORY_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCTCATEGORY_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `PRODUCTCATEGORY` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `PRODUCTCATEGORY` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `PRODUCTCATEGORY` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCT_ACTIVELST` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`` PROCEDURE `PRODUCT_ACTIVELST`(
IN `p_Keyword` nvarchar(100)
)
proc_label:BEGIN	  
  SELECT A.*
		FROM `PRODUCT` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
            AND (A.`status` = 'A')
		ORDER BY 
		A.`CreatedDate` DESC;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCT_ById` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCT_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `PRODUCT` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCT_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCT_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Price` decimal(16,2),
`p_CategoryId` int,
`p_Description` nvarchar(500),
`p_Image` nvarchar(6000),
`p_Thumbnail` nvarchar(6000),
`p_Note` nvarchar(500),
`p_Status` varchar(50),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
	DECLARE `p_CodeGen` nvarchar(100);
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `PRODUCT` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
			THEN
				SET sErrorCode = 'OBJ-03';           
			END IF;		    
		END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
    CALL sp_fn_SYS_CodeMasters_Gen('TR_PRODUCT',`p_CodeGen`);
	INSERT INTO `PRODUCT`(`id`,`code`,`name`,`price`,`categoryId`,`description`,`image`,`thumbnail`,`note`,`status`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_CodeGen`,`p_Name`,`p_Price`,`p_CategoryId`,`p_Description`,`p_Image`,`p_Thumbnail`,`p_Note`,`p_Status`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `PRODUCT` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`price` = `p_Price`,
		`categoryId` = `p_CategoryId`,
		`description` = `p_Description`,
		`image` = `p_Image`,
		`thumbnail` = `p_Thumbnail`,
		`note` = `p_Note`,
		`status` = `p_Status`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCT_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCT_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `PRODUCT` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `PRODUCT` A   
		WHERE 
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)
		ORDER BY 
			A.`categoryId`,A.`CreatedDate` DESC ; 
	ELSE
		SELECT A.*
		FROM `PRODUCT` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`categoryId`,A.`CreatedDate`  DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ROLE_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`` PROCEDURE `ROLE_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `ROLE` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ROLE_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`` PROCEDURE `ROLE_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `ROLE` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
			THEN
				SET sErrorCode = 'OBJ-03';           
			END IF;		    
		END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
	INSERT INTO `ROLE`(`id`,`code`,`name`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_Code`,`p_Name`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `ROLE` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ROLE_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`` PROCEDURE `ROLE_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `ROLE` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `ROLE` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `ROLE` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rpt_ORDER_REVENUE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`` PROCEDURE `rpt_ORDER_REVENUE`(
	`p_FromDate` datetime,
    `p_ToDate` datetime
)
proc_label:BEGIN
    SELECT `code`, `name`, `fee`, `discountPercent`, `totalPrice`, `createdDate`, `createdBy`,`updatedDate`,`updatedBy`        
	FROM `ORDER` A 
 	WHERE A.`isDeleted`<>1  
    AND (A.`status` <> 'C')
    AND (
		(A.`createdDate` between  `p_FromDate` and  `p_ToDate`) 
		OR A.`createdDate` IS NULL
        );
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spt_WhileLoopDoTest` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spt_WhileLoopDoTest`(
IN `p_Offset` INT,
IN `p_MaxCount` INT
)
proc_label:BEGIN
	DECLARE `p_Index`  INT;	
	SET `p_Index` = `p_Offset`;
		REPEAT   
			 call coffeeshopdb.CM_TABLE_InsOrUpd(`p_Index`, `p_Index`, 'I', 'I', 0, '2019-10-19', 'admin', '2019-10-19', 'admin');
			 SET   `p_Index`    =  `p_Index` + 1;                                                             
			UNTIL `p_Index` >=`p_MaxCount`
		END REPEAT;   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_fn_SYS_CodeMasters_Gen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_fn_SYS_CodeMasters_Gen`(
`p_Kind` varchar(100),  
OUT `p_KeyGen` varchar(15)
)
sp_fn_label:BEGIN
	DECLARE `p_CurValue`  Numeric;
	DECLARE `p_Prefix`  varchar(10);
    
	DECLARE `isRollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;   
    SELECT Z.`prefix` INTO `p_Prefix`  FROM `SYS_PREFIX` Z WHERE Z.`code` = `p_Kind`;
    START TRANSACTION; 
  
    IF NOT EXISTS(SELECT A.`curValue` FROM `SYS_CODEMASTERS` A WHERE A.`prefix`=`p_Prefix`)
	THEN
			INSERT `SYS_CODEMASTERS` (
				`prefix`,
				`curValue`,
				`description`,
				`active`
			)VALUES(
				`p_Prefix`,
				1,
				'',
				1	
			);
			#IF @@ERROR <> 0 THEN leave fn_label; END IF;
            
			SET `p_CurValue` = 1;
				 
	ELSE			
			IF EXISTS(SELECT B.`curValue` FROM `SYS_CODEMASTERS` B WHERE B.`prefix`=`p_Prefix`)
			THEN
				UPDATE `SYS_CODEMASTERS` C SET C.`curValue`= C.`curValue` + 1
				WHERE C.`prefix`=`p_Prefix`;            
			END IF;
        
			#IF @@ERROR <> 0 THEN leave fn_label; END IF;
			SELECT D.`curValue` INTO `p_CurValue` FROM `SYS_CODEMASTERS` D WHERE D.`prefix` = `p_Prefix`;
	END IF;
	
  
	#SET `p_KeyGen` = `p_Prefix` + right('000000000000' + convert(varchar(20),`curValue`), 15 - len(`p_Prefix`));
    #SET `p_KeyGen` =  `p_Prefix` + right(CONCAT('000000000000',`p_CurValue`), 15 - len(`p_Prefix`));
   
  
    SET `p_KeyGen` = concat(`p_Prefix`,right(CONCAT('000000000000',`p_CurValue`), 15 - LENGTH(`p_Prefix`)));
    
	#IF @@ERROR <> 0 THEN leave fn_label; END IF;

	IF `isRollback` 
	THEN		
		ROLLBACK;
		SET `p_KeyGen` = '';
	ELSE		
		COMMIT;  
	END IF;

 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SYS_ERROR_ById` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SYS_ERROR_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `SYS_ERROR` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `SYS_ERROR_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SYS_ERROR_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Description` nvarchar(500),
`p_Form` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `SYS_ERROR` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
			THEN
				SET sErrorCode = 'OBJ-03';           
			END IF;		    
		END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
	INSERT INTO `SYS_ERROR`(`id`,`code`,`description`,`form`) 
        VALUES(`p_Id`,`p_Code`,`p_Description`,`p_Form`); 
	ELSE
		UPDATE `SYS_ERROR` A
        	SET
			`code` = `p_Code`,
		`description` = `p_Description`,
		`form` = `p_Form`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SYS_ERROR_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SYS_ERROR_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `SYS_ERROR` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `SYS_ERROR` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `SYS_ERROR` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SYS_PARAMETERS_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SYS_PARAMETERS_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `SYS_PARAMETERS` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.* 
		FROM `SYS_PARAMETERS` A   
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*
		FROM `SYS_PARAMETERS` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
       		AND (A.`isDeleted` = 0)    
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `test_query` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_query`()
BEGIN
	DECLARE `l_CAR_ID` VARCHAR(15);
    CALL `sp_fn_SYS_CodeMasters_Gen`('PUR_GOODSCATEGORY',`l_CAR_ID`);
    select `l_CAR_ID` as res;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USER_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`` PROCEDURE `USER_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `USER` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USER_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USER_InsOrUpd`(
`p_Id` INT,
`p_Code` varchar(100),
`p_UserName` varchar(256),
`p_Password` nvarchar(256),
`p_EmployeeId` int,
`p_RoleId` int,
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
	DECLARE `p_CodeGen` nvarchar(100);
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
			IF (`p_UserName` IS NOT NULL AND `p_UserName` <> '')
			THEN
				IF NOT EXISTS(SELECT * FROM `USER` A WHERE A.`userName` = `p_UserName` AND A.`isDeleted`<>1)
				THEN
					SET sErrorCode = 'OBJ-03';           
				END IF;		    
			END IF;	
		ELSE 
			IF (`p_UserName` IS  NULL OR `p_UserName` = '')
            THEN 
				SET sErrorCode = 'USER-01';  
            END IF;
            
             IF(sErrorCode <> '')
            THEN
				IF (`p_Password` IS NULL OR  `p_Password` = '')
				THEN 
					SET sErrorCode = 'USER-03';  
				END IF;
            END IF;   
         END IF;     
                  
      

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
    CALL sp_fn_SYS_CodeMasters_Gen('SYS_USER',`p_CodeGen`);
	INSERT INTO `USER`(`id`,`code`,`username`,`password`,`employeeId`,`roleId`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_CodeGen`,`p_UserName`,`p_Password`,`p_EmployeeId`,`p_RoleId`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `USER` A
		SET
		`code` = `p_Code`,
		`username` = `p_UserName`,
		`password` = `p_Password`,
		`employeeId` = `p_EmployeeId`,
		`roleId` = `p_RoleId`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
   IF `isRollback` 
   THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USER_Login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`` PROCEDURE `USER_Login`(
	`p_UserName` NVARCHAR(100),
    `p_Password` NVARCHAR(100)
)
proc_label:BEGIN	
      
    SELECT A.*, B.`code` AS employeeCode,  B.`name` AS employeeName, 
        C.`code` roleCode, C.`name` AS roleName        
	FROM `USER` A   
	INNER JOIN `EMPLOYEE` B ON A.`employeeId` = B.`id`
	INNER JOIN `ROLE` C ON A.`roleId` = C.`id`     
 	WHERE A.`username` = `p_UserName`  
	AND  A.`password` = `p_Password`
 	AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USER_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USER_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` 
    FROM `USER` A 
    INNER JOIN `EMPLOYEE` B ON A.`employeeId` = B.`id`
	INNER JOIN `ROLE` C ON A.`roleId` = C.`id`
    WHERE
		(A.`userName` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`userName` IS NULL OR A.`userName` = '')
        AND (A.`isDeleted` = 0);   
        
	IF(`p_Offset` = -1)
	THEN
		SELECT A.*, B.`code` AS employeeCode,  B.`name` AS employeeName, 
        C.`code` roleCode, C.`name` AS roleName
		FROM `USER` A   
		INNER JOIN `EMPLOYEE` B ON A.`employeeId` = B.`id`
		INNER JOIN `ROLE` C ON A.`roleId` = C.`id`
		WHERE A.`isDeleted` = 0;
	ELSE
		SELECT A.*, B.`code` AS employeeCode,  B.`name` AS employeeName, 
        C.`code` roleCode, C.`name` AS roleName
		FROM `USER` A 
		INNER JOIN `EMPLOYEE` B ON A.`employeeId` = B.`id`
		INNER JOIN `ROLE` C ON A.`roleId` = C.`id`
		WHERE
			(A.`userName` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`userName` IS NULL OR A.`userName` = '')
		AND (A.`isDeleted` = 0)
		ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
	END IF;
    	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `VOUCHER_ById` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `VOUCHER_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `VOUCHER` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `VOUCHER_InsOrUpd` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `VOUCHER_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Description` nvarchar(500),
`p_Image` nvarchar(6000),
`p_Thumbnail` nvarchar(6000),
`p_IsDeleted` bool,
`p_CreatedDate` datetime,
`p_CreatedBy` nvarchar(256),
`p_UpdatedDate` datetime,
`p_UpdatedBy` nvarchar(256)

)
proc_label:BEGIN
	DECLARE sErrorCode VARCHAR(20) DEFAULT '';
	DECLARE `isRollback` BOOL DEFAULT 0;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `VOUCHER` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
			THEN
				SET sErrorCode = 'OBJ-03';           
			END IF;		    
		END IF;
        END IF;

   
   
	IF(sErrorCode<>'')
	THEN
		SELECT E.`code` Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE sErrorCode = E.`code`;
		LEAVE proc_label;
	END IF;
    
    START TRANSACTION;    
    IF(`p_Id` IS NULL OR `p_Id` = 0)
    THEN 
	INSERT INTO `VOUCHER`(`id`,`code`,`name`,`description`,`image`,`thumbnail`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_Code`,`p_Name`,`p_Description`,`p_Image`,`p_Thumbnail`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `VOUCHER` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`description` = `p_Description`,
		`image` = `p_Image`,
		`thumbnail` = `p_Thumbnail`,
		`isDeleted` = `p_IsDeleted`,
		`createdDate` = `p_CreatedDate`,
		`createdBy` = `p_CreatedBy`,
		`updatedDate` = `p_UpdatedDate`,
		`updatedBy` = `p_UpdatedBy`

		WHERE A.`id` = `p_Id`
		;
    END IF;
	
	IF `isRollback` THEN		
        ROLLBACK;
	SELECT '-1' AS Result, '' `Id`,E.`description` ErrorDesc FROM `SYS_ERROR` E WHERE E.`code` = 'SYS-01';       
        /*SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;*/
    ELSE		
        COMMIT;        
        SELECT '1' as Result, `p_Id` `Id`, '' ErrorDesc;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `VOUCHER_Search` */;
ALTER DATABASE `coffeeshopdb` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `VOUCHER_Search`(
IN `p_Keyword` nvarchar(100),
IN `p_Offset` int,
IN `p_PageSize` int,
IN `p_Sorting` varchar(100),
OUT `p_TotalCount` int
)
proc_label:BEGIN	  
	SELECT COUNT(*) INTO `p_TotalCount` FROM `VOUCHER` A WHERE
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
    SELECT A.*
		FROM `VOUCHER` A  
		WHERE
			(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0)    
	ORDER BY 
		A.`CreatedDate` DESC
	LIMIT `p_OFFSET`, `p_PageSize`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `coffeeshopdb` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `WhileLoopDoTest` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `WhileLoopDoTest`(
IN `p_Offset` INT,
IN `p_MaxCount` INT
)
BEGIN
	DECLARE `p_Index`  INT;	
	SET `p_Index` = `p_Offset`;
		REPEAT   
			 call coffeeshopdb.CM_TABLE_InsOrUpd(NULL, `p_Index`, 'I', 'A', 0, '2019-10-19', 'admin', '2019-10-19', 'admin');
			 SET   `p_Index`    =  `p_Index` + 1;                                                             
			UNTIL `p_Index` >=`p_MaxCount`
		END REPEAT;   
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

-- Dump completed on 2019-11-19 16:21:33
