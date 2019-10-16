-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: coffeeshopdb
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.35-MariaDB

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
-- Table structure for table `allcode`
--

DROP TABLE IF EXISTS `allcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cdName` varchar(100) DEFAULT NULL,
  `cdValue` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `content` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `cdType` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allcode`
--

LOCK TABLES `allcode` WRITE;
/*!40000 ALTER TABLE `allcode` DISABLE KEYS */;
INSERT INTO `allcode` VALUES (1,'ORDER_STATUS','N','Mới nhận',NULL,1),(2,'ORDER_STATUS','D','Đã xong',NULL,2);
/*!40000 ALTER TABLE `allcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `address` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `district` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `area` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `totalPrice` decimal(16,2) DEFAULT NULL,
  `discountPercent` decimal(16,2) DEFAULT NULL,
  `fee` decimal(16,2) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `voucherId` int(11) DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `totalPrice` decimal(16,2) DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(6000) CHARACTER SET utf8 DEFAULT NULL,
  `thumbnail` varchar(6000) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'PDT001','CHICKEN BURGER',50000.00,NULL,'ABCD',NULL,NULL,NULL,'A',0,'2019-09-25 00:00:00','khangth','2019-09-25 00:00:00','khangth'),(3,'BUR001','2ERETRHT',20000.00,0,'','','','','A',0,'2019-10-08 00:00:00','','2019-10-08 00:00:00',''),(4,'DFG','ADSFDF',1234.00,0,'','','','','A',1,'2019-10-08 00:00:00','','2019-10-08 00:00:00',''),(5,'12344','dwwrfwsdassda',30000.00,0,'','','','','A',1,'2019-10-12 00:00:00','','2019-10-12 00:00:00',''),(6,'ZZZ3aw','aa',12312321.00,0,'','','','','A',1,'2019-10-12 00:00:00','','2019-10-12 00:00:00',''),(7,'QWEQWa','ÃZ',200000.00,0,'','','','','A',1,'2019-10-12 00:00:00','','2019-10-12 00:00:00',''),(8,'ABCDa','DEFCD',231232131.00,NULL,'','','','','A',0,'2019-10-16 00:00:00','','2019-10-16 00:00:00',''),(9,'adsf2','adas',12312312.00,0,'','','','','A',1,'2019-10-12 00:00:00','','2019-10-12 00:00:00',''),(10,'EFE','DEF',20000.00,NULL,'','','','','A',0,'2019-10-16 00:00:00','','2019-10-16 00:00:00',''),(11,'ADC','ADC',123213.00,0,'','','','','A',0,'2019-10-12 00:00:00','','2019-10-12 00:00:00',''),(12,'','',20000.00,NULL,'','','','','A',0,'2019-10-16 00:00:00','','2019-10-16 00:00:00','');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategory`
--

DROP TABLE IF EXISTS `productcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
INSERT INTO `productcategory` VALUES (1,'BUR01','Đồ ăn nhanh','Danh mục đồ ăn nhanh, thưc phẩm',NULL,NULL,0,'2019-11-10 00:00:00','khangth','2019-11-10 00:00:00','khangth');
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_error`
--

DROP TABLE IF EXISTS `sys_error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `form` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_error`
--

LOCK TABLES `sys_error` WRITE;
/*!40000 ALTER TABLE `sys_error` DISABLE KEYS */;
INSERT INTO `sys_error` VALUES (1,'OBJ-01','','Đối tượng đã tồn tại'),(2,'OBJ-02',NULL,'Mã code không hợp lệ'),(3,'OBJ-03',NULL,'Đối tượng không tồn tại');
/*!40000 ALTER TABLE `sys_error` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucher`
--

DROP TABLE IF EXISTS `voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucher` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucher`
--

LOCK TABLES `voucher` WRITE;
/*!40000 ALTER TABLE `voucher` DISABLE KEYS */;
/*!40000 ALTER TABLE `voucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'coffeeshopdb'
--
/*!50003 DROP PROCEDURE IF EXISTS `ALLCODE_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `ALLCODE_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `ALLCODE` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
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
	
	IF `isRollback` THEN		
        ROLLBACK;       
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `ALLCODE_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
		(A.`name` LIKE CONCAT('%',`p_Keyword`,'%') OR A.`name` IS NULL OR A.`name` = '')
        AND (A.`isDeleted` = 0);   
        
    SELECT A.*
		FROM `ALLCODE` A  
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
/*!50003 DROP PROCEDURE IF EXISTS `CUSTOMER_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `CUSTOMER_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 DROP PROCEDURE IF EXISTS `CUSTOMER_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `ORDERDETAIL_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDERDETAIL_ById`(
	`p_Id` INT 
)
proc_label:BEGIN
  
   SELECT A.* FROM `ORDERDETAIL` A WHERE A.`id` = `p_Id` AND A.`isDeleted`<>1;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ORDERDETAIL_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDERDETAIL_InsOrUpd`(
	`p_Id` INT,
`p_OrderId` INT,
`p_ProductId` INT,
`p_Price` decimal(16,2),
`p_Quantity` int,
`p_TotalPrice` decimal(16,2),
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
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `ORDERDETAIL` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
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
	INSERT INTO `ORDERDETAIL`(`id`,`orderId`,`productId`,`price`,`quantity`,`totalPrice`,`note`,`status`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_OrderId`,`p_ProductId`,`p_Price`,`p_Quantity`,`p_TotalPrice`,`p_Note`,`p_Status`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `ORDERDETAIL` A
        	SET
			`orderId` = `p_OrderId`,
		`productId` = `p_ProductId`,
		`price` = `p_Price`,
		`quantity` = `p_Quantity`,
		`totalPrice` = `p_TotalPrice`,
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
	
	IF `isRollback` THEN		
        ROLLBACK;       
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 DROP PROCEDURE IF EXISTS `ORDERDETAIL_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
        
    SELECT A.*
		FROM `ORDERDETAIL` A  
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
/*!50003 DROP PROCEDURE IF EXISTS `ORDER_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `ORDER_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ORDER_InsOrUpd`(
	`p_Id` INT,
`p_Code` varchar(100),
`p_Name` nvarchar(256),
`p_Price` decimal(16,2),
`p_TotalPrice` decimal(16,2),
`p_DiscountPercent` decimal(16,2),
`p_Fee` decimal(16,2),
`p_CustomerId` int,
`p_VoucherId` int,
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
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `isRollback` = 1;
    
         IF (`p_Id` IS NOT NULL AND `p_Id` <> 0)
         THEN
	  	IF (`p_Code` IS NOT NULL AND `p_Code` <> '')
		THEN
			IF NOT EXISTS(SELECT * FROM `ORDER` A WHERE A.`code` = `p_Code` AND A.`isDeleted`<>1)
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
	INSERT INTO `ORDER`(`id`,`code`,`name`,`price`,`totalPrice`,`discountPercent`,`fee`,`customerId`,`voucherId`,`note`,`status`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_Code`,`p_Name`,`p_Price`,`p_TotalPrice`,`p_DiscountPercent`,`p_Fee`,`p_CustomerId`,`p_VoucherId`,`p_Note`,`p_Status`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
	ELSE
		UPDATE `ORDER` A
        	SET
			`code` = `p_Code`,
		`name` = `p_Name`,
		`price` = `p_Price`,
		`totalPrice` = `p_TotalPrice`,
		`discountPercent` = `p_DiscountPercent`,
		`fee` = `p_Fee`,
		`customerId` = `p_CustomerId`,
		`voucherId` = `p_VoucherId`,
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
	
	IF `isRollback` THEN		
        ROLLBACK;       
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
        
    SELECT A.*
		FROM `ORDER` A  
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
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCTCATEGORY_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCTCATEGORY_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
	INSERT INTO `PRODUCTCATEGORY`(`id`,`code`,`name`,`description`,`image`,`thumbnail`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_Code`,`p_Name`,`p_Description`,`p_Image`,`p_Thumbnail`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
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
	
	IF `isRollback` THEN		
        ROLLBACK;       
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCTCATEGORY_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
        
    SELECT A.*
		FROM `PRODUCTCATEGORY` A  
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
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCT_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCT_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
	INSERT INTO `PRODUCT`(`id`,`code`,`name`,`price`,`categoryId`,`description`,`image`,`thumbnail`,`note`,`status`,`isDeleted`,`createdDate`,`createdBy`,`updatedDate`,`updatedBy`) 
        VALUES(`p_Id`,`p_Code`,`p_Name`,`p_Price`,`p_CategoryId`,`p_Description`,`p_Image`,`p_Thumbnail`,`p_Note`,`p_Status`,`p_IsDeleted`,`p_CreatedDate`,`p_CreatedBy`,`p_UpdatedDate`,`p_UpdatedBy`); 
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
	
	IF `isRollback` THEN		
        ROLLBACK;       
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
        
    SELECT A.*
		FROM `PRODUCT` A  
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
/*!50003 DROP PROCEDURE IF EXISTS `SYS_ERROR_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `SYS_ERROR_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
	
	IF `isRollback` THEN		
        ROLLBACK;       
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
        
    SELECT A.*
		FROM `SYS_ERROR` A  
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
/*!50003 DROP PROCEDURE IF EXISTS `VOUCHER_ById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `VOUCHER_InsOrUpd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
        SELECT '-1' AS Result, '' `Id`, '' ErrorDesc;
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
/*!50003 DROP PROCEDURE IF EXISTS `VOUCHER_Search` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-16 13:41:01
