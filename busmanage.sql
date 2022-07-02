-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: busmanage
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
-- Table structure for table `员工登录`
--

DROP TABLE IF EXISTS `员工登录`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `员工登录` (
  `userName` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `员工登录`
--

LOCK TABLES `员工登录` WRITE;
/*!40000 ALTER TABLE `员工登录` DISABLE KEYS */;
INSERT INTO `员工登录` VALUES ('周小笛','123'),('宋文静','123'),('李妍妍','123'),('李新友','123');
/*!40000 ALTER TABLE `员工登录` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `排班`
--

DROP TABLE IF EXISTS `排班`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `排班` (
  `code` varchar(20) NOT NULL,
  `lineCode` varchar(50) NOT NULL,
  `busLinense` varchar(10) NOT NULL,
  `tcNumber` varchar(50) NOT NULL,
  `tcTime` varchar(50) NOT NULL,
  `userCode` varchar(20) NOT NULL,
  `startStation` varchar(20) NOT NULL,
  `endStation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `排班`
--

LOCK TABLES `排班` WRITE;
/*!40000 ALTER TABLE `排班` DISABLE KEYS */;
INSERT INTO `排班` VALUES ('1','1','鄂B-12345','2','2022-06-22','李妍妍','湖北师范大学','万达'),('2','3','鄂B-12345','1','2022-08-22','周小笛','黄石北站','摩尔城'),('4','2','2','2','2','2','2','2');
/*!40000 ALTER TABLE `排班` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `用户`
--

DROP TABLE IF EXISTS `用户`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `用户` (
  `idcode` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `idCard` varchar(18) NOT NULL,
  `driving` int DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`idcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `用户`
--

LOCK TABLES `用户` WRITE;
/*!40000 ALTER TABLE `用户` DISABLE KEYS */;
INSERT INTO `用户` VALUES ('1','1','1','1',1,'1'),('2020122000518','李妍妍','17282396206','424568200302234567',1,'开启'),('2020122000530','宋文静','17282395590','412371200301183627',3,'关闭'),('2020122000549','周小笛','17282396372','423728200206073821',2,'开启');
/*!40000 ALTER TABLE `用户` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `站点`
--

DROP TABLE IF EXISTS `站点`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `站点` (
  `stationCode` varchar(20) NOT NULL,
  `stationName` varchar(20) NOT NULL,
  `longitude` int NOT NULL,
  `latitude` int NOT NULL,
  `region` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  PRIMARY KEY (`stationCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `站点`
--

LOCK TABLES `站点` WRITE;
/*!40000 ALTER TABLE `站点` DISABLE KEYS */;
INSERT INTO `站点` VALUES ('1','湖北师范大学',115,30,'黄石港区','磁湖路'),('4','摩尔城',134,40,'黄石北站','武商');
/*!40000 ALTER TABLE `站点` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `管理员登录`
--

DROP TABLE IF EXISTS `管理员登录`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `管理员登录` (
  `userName` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `管理员登录`
--

LOCK TABLES `管理员登录` WRITE;
/*!40000 ALTER TABLE `管理员登录` DISABLE KEYS */;
INSERT INTO `管理员登录` VALUES ('曹杉杉','12345'),('童强','1234');
/*!40000 ALTER TABLE `管理员登录` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `线路`
--

DROP TABLE IF EXISTS `线路`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `线路` (
  `lineCode` varchar(20) NOT NULL,
  `lineName` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL,
  `startLineTime` varchar(50) NOT NULL,
  `direction` varchar(10) NOT NULL,
  PRIMARY KEY (`lineCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `线路`
--

LOCK TABLES `线路` WRITE;
/*!40000 ALTER TABLE `线路` DISABLE KEYS */;
INSERT INTO `线路` VALUES ('1','1号路线','开启','2022-06-22 ','北'),('12','2号路线','开启','2022-08-27','西');
/*!40000 ALTER TABLE `线路` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `线路站点`
--

DROP TABLE IF EXISTS `线路站点`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `线路站点` (
  `lineCode` varchar(20) NOT NULL,
  `stationCode` varchar(20) NOT NULL,
  `id` varchar(20) NOT NULL,
  PRIMARY KEY (`lineCode`,`stationCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `线路站点`
--

LOCK TABLES `线路站点` WRITE;
/*!40000 ALTER TABLE `线路站点` DISABLE KEYS */;
INSERT INTO `线路站点` VALUES ('1','3','第五站'),('1','5','第五站');
/*!40000 ALTER TABLE `线路站点` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `调度员登录`
--

DROP TABLE IF EXISTS `调度员登录`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `调度员登录` (
  `userName` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `调度员登录`
--

LOCK TABLES `调度员登录` WRITE;
/*!40000 ALTER TABLE `调度员登录` DISABLE KEYS */;
INSERT INTO `调度员登录` VALUES ('宋文静','1234'),('李新友','12345');
/*!40000 ALTER TABLE `调度员登录` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `车辆`
--

DROP TABLE IF EXISTS `车辆`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `车辆` (
  `busCode` varchar(20) NOT NULL,
  `busLicense` varchar(10) NOT NULL,
  `busStatus` varchar(10) NOT NULL,
  `busType` varchar(30) DEFAULT NULL,
  `startTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`busCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `车辆`
--

LOCK TABLES `车辆` WRITE;
/*!40000 ALTER TABLE `车辆` DISABLE KEYS */;
INSERT INTO `车辆` VALUES ('12','鄂A-37223','关闭','单层公交','2022-7-23 '),('1234','鄂L-12345','开启','双层公交','2022-8-28'),('123456','鄂B-12345','开启','双层公交','2022-06-22 ');
/*!40000 ALTER TABLE `车辆` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'busmanage'
--

--
-- Dumping routines for database 'busmanage'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-25  7:31:00
