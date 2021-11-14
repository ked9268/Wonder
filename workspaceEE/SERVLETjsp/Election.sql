-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: CO3098_CW2_2019
-- ------------------------------------------------------
-- Server version	5.7.15

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
-- Table structure for table `BallotBox`
--

DROP TABLE IF EXISTS `BallotBox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BallotBox` (
  `voterEmail` varchar(45) NOT NULL,
  `votedCandidateID` int(11) NOT NULL,
  PRIMARY KEY (`voterEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BallotBox`
--

LOCK TABLES `BallotBox` WRITE;
/*!40000 ALTER TABLE `BallotBox` DISABLE KEYS */;
INSERT INTO `BallotBox` VALUES ('john.smith@gmail.com',2);
/*!40000 ALTER TABLE `BallotBox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Candidate`
--

DROP TABLE IF EXISTS `Candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Candidate` (
  `candidateId` int(11) NOT NULL AUTO_INCREMENT,
  `candidateName` varchar(100) NOT NULL,
  `party` varchar(45) NOT NULL DEFAULT 'Independent candidate',
  `constituency` varchar(45) NOT NULL,
  `voteCount` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`candidateId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Candidate`
--

LOCK TABLES `Candidate` WRITE;
/*!40000 ALTER TABLE `Candidate` DISABLE KEYS */;
INSERT INTO `Candidate` VALUES (1,'Candidate1','Blue Party','Shangri-la Town',0),(2,'Candidate2','Red Party','Shangri-la Town',1),(3,'Candidate3','Yellow Party','Shangri-la Town',0),(4,'Candidate4','Independent','Shangri-la Town',0),(5,'Candidate5','Red Party','Northern Kuen-Lun Mountain',0),(6,'Candidate6','Yellow Party','Northern Kuen-Lun Mountain',0),(7,'Candidate7','Blue Party','Northern Kuen-Lun Mountain',0),(8,'Candidate8','Red Party','Western Shangri-la',0),(9,'Candidate9','Blue Party','Western Shangri-la',0),(10,'Candidate10','Yellow Party','Western Shangri-la',0);
/*!40000 ALTER TABLE `Candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SNI`
--

DROP TABLE IF EXISTS `SNI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SNI` (
  `Code` varchar(50) NOT NULL,
  `Used` int(11) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SNI`
--

LOCK TABLES `SNI` WRITE;
/*!40000 ALTER TABLE `SNI` DISABLE KEYS */;
INSERT INTO `SNI` VALUES ('4817YN1C',1),('4M6YFNAC',0),('70EV6SC4',0),('72GQU9ZK',0),('7XP02HJ3',0),('AUTIHS8I',0),('B7F6EM2Y',0),('DABSP97S',0),('FWM4HQEQ',0),('G9H3FM8G',0),('JTP70XGU',0),('OXFG75MZ',0),('P4YHAJUX',0),('P8AO57RS',0),('Q7OW5WWM',0),('R824O2NZ',0),('RR9E1MBQ',0),('S3ATWJUZ',0),('XIO0FT40',0),('Z4PHBVY9',0);
/*!40000 ALTER TABLE `SNI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Voter`
--

DROP TABLE IF EXISTS `Voter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Voter` (
  `voterEmail` varchar(40) NOT NULL,
  `fullName` varchar(45) NOT NULL,
  `constituency` varchar(45) NOT NULL,
  `passwordHash` longtext NOT NULL,
  `SNICode` varchar(45) NOT NULL,
  PRIMARY KEY (`voterEmail`),
  UNIQUE KEY `email_UNIQUE` (`voterEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Voter`
--

LOCK TABLES `Voter` WRITE;
/*!40000 ALTER TABLE `Voter` DISABLE KEYS */;
INSERT INTO `Voter` VALUES ('john.smith@gmail.com','John Smith','Shangri-la Town','A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3','4817YN1C');
/*!40000 ALTER TABLE `Voter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-29 18:12:18
