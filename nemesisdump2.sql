-- MySQL dump 10.13  Distrib 5.5.35, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Nemesis
-- ------------------------------------------------------
-- Server version	5.5.35-1ubuntu1

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
-- Table structure for table `Assignment`
--

DROP TABLE IF EXISTS `Assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Assignment` (
  `Employee_ID` smallint(6) NOT NULL DEFAULT '0',
  `Project_ID` smallint(6) NOT NULL DEFAULT '0',
  `Start_Date` datetime NOT NULL,
  PRIMARY KEY (`Project_ID`,`Employee_ID`),
  KEY `assignmentEmpFK` (`Employee_ID`),
  CONSTRAINT `assignmentEmpFK` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`),
  CONSTRAINT `assignmentProjFK` FOREIGN KEY (`Project_ID`) REFERENCES `Project` (`Project_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Assignment`
--

LOCK TABLES `Assignment` WRITE;
/*!40000 ALTER TABLE `Assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `Employee_ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `NINO` char(11) NOT NULL,
  `Bank_Acc` char(19) NOT NULL,
  `Starting_Salary` decimal(7,0) DEFAULT NULL,
  `Department` varchar(20) NOT NULL,
  PRIMARY KEY (`Employee_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'Joanne','3 Lakeview Gardens, Newtownabbey','JE828771D','1293 8457 4930 2918',25000,'R&D'),(2,'David','15 Cloughfern Gardens, Newtownards','JE849371L','1003 8117 4320 2918',20000,'Enterprise'),(3,'Joanne','3 Lakeview Gardens, Newtownabbey','JE828771D','1293 8457 4930 2918',25000,'R&D'),(4,'David','15 Cloughfern Gardens, Newtownards','JE849371L','1003 8117 4320 2918',20000,'Enterprise'),(5,'Joanne Connor','11 Grovehill ','JE827177D','5643 6754 1234 6789',25000,'Gov');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Project`
--

DROP TABLE IF EXISTS `Project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Project` (
  `Project_ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `Project_Name` varchar(30) NOT NULL,
  `Employee_ID` smallint(6) NOT NULL,
  PRIMARY KEY (`Project_ID`),
  KEY `projectFK` (`Employee_ID`),
  CONSTRAINT `projectFK` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Project`
--

LOCK TABLES `Project` WRITE;
/*!40000 ALTER TABLE `Project` DISABLE KEYS */;
INSERT INTO `Project` VALUES (2,'Trainee Map Development',1),(4,'ACM',2);
/*!40000 ALTER TABLE `Project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sales_Employee`
--

DROP TABLE IF EXISTS `Sales_Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sales_Employee` (
  `Sales_EmployeeID` smallint(6) NOT NULL AUTO_INCREMENT,
  `Commission_Rate` decimal(2,2) NOT NULL,
  `Sales_Total` decimal(10,2) NOT NULL,
  `Employee_ID` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`Sales_EmployeeID`),
  KEY `employeeFK` (`Employee_ID`),
  CONSTRAINT `employeeFK` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sales_Employee`
--

LOCK TABLES `Sales_Employee` WRITE;
/*!40000 ALTER TABLE `Sales_Employee` DISABLE KEYS */;
INSERT INTO `Sales_Employee` VALUES (2,0.20,20000.00,1),(3,0.10,45000.00,2);
/*!40000 ALTER TABLE `Sales_Employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-21  8:42:33
