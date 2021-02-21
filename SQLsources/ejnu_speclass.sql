-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ejnu
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `speclass`
--

DROP TABLE IF EXISTS `speclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speclass` (
  `speclass_id` int(11) NOT NULL AUTO_INCREMENT,
  `speclass_name` varchar(64) NOT NULL COMMENT '具体课程名',
  `speclass_time` int(11) DEFAULT NULL COMMENT '6位，aabbcc,表示三次课程的节次，00表示无',
  `speclass_loc` varchar(64) DEFAULT NULL COMMENT '地点',
  `speclass_sidl` int(11) DEFAULT NULL COMMENT '需要上这门课程学生学号范围，左区间',
  `speclass_sidr` int(11) DEFAULT NULL COMMENT '同上，右区间',
  `teacher_id` int(11) NOT NULL,
  `classes_id` int(11) NOT NULL,
  PRIMARY KEY (`speclass_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `classes_id` (`classes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speclass`
--

LOCK TABLES `speclass` WRITE;
/*!40000 ALTER TABLE `speclass` DISABLE KEYS */;
INSERT INTO `speclass` VALUES (1,'c语言',60810,'第一教学楼A201',1001190101,1001190340,20011501,1),(2,'数据结构',10917,'第一教学楼A201',1002190101,1002190340,20011501,4),(3,'数据结构',161800,'第一教学楼B311',1001190101,1001190340,20021702,2),(4,'计算机专业基础体育',19,'中心体育场',1001190101,1001190340,20091403,6),(5,'高数一',1214,'第一教学楼A108',1001190101,1001190340,20101208,8),(6,'计算机导论',2425,'第一教学楼C101',1001190101,1001190340,20011501,9),(7,'英语一',204,'第二教学楼A308',1001190101,1001190340,20091403,10),(8,'算法分析',709,'第二教学楼A308',1001190101,1001190340,20021702,3);
/*!40000 ALTER TABLE `speclass` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-14 22:39:06
