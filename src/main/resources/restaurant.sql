-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `account_product`
--

DROP TABLE IF EXISTS `account_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_product` (
  `id_account_product` int(11) NOT NULL AUTO_INCREMENT,
  `id_product` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `id_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_account_product`),
  KEY `account_product_product_id_product_fk` (`id_product`),
  KEY `account_product_order_id_order_fk` (`id_order`),
  CONSTRAINT `account_product_order_id_order_fk` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`),
  CONSTRAINT `account_product_product_id_product_fk` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_product`
--

LOCK TABLES `account_product` WRITE;
/*!40000 ALTER TABLE `account_product` DISABLE KEYS */;
INSERT INTO `account_product` VALUES (27,3,1,17),(28,3,12,18),(29,6,10,19),(30,5,2,20),(31,4,1,20),(32,2,22,21),(33,3,11,22),(34,2,1,23),(35,5,1,24),(36,6,1,25),(37,2,1,26);
/*!40000 ALTER TABLE `account_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id_admin` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin'),(2,'Bazik','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'meat'),(2,'beer'),(3,'fruits');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'igor','123','igor@mail.ru','0932356678'),(2,'vova','321','vova@gmail.com','0993256778'),(3,'Саша','789','kek@gmail.com','0634482600'),(4,'Bazik','787898','Bazik@mail.ru','0993256678'),(5,'дима','123','dima@gmail.com','0993256678'),(6,'dima','111','dima@gmail.com','0993256678'),(7,'Client','lolkek','my@gmail.com','0994487632'),(11,'hero','12345','hero@gmail.com','0989565691'),(12,'Hello','123123kek','hello@gmail.com','0989595865'),(13,'alina','qwerty','balitsky99@gmail.com','0989038701'),(14,'qwe','123','qwe@gmail.com','0989676781'),(15,'hui','hui','jgjh@nhvn.ru','0635083234'),(16,'Санька','123','sanka@gmail.com','0993256678');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `total` int(11) DEFAULT NULL,
  `id_customer` int(11) DEFAULT NULL,
  `confirm` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id_order`),
  KEY `order_customer_id_customer_fk` (`id_customer`),
  CONSTRAINT `order_customer_id_customer_fk` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (17,24,14,''),(18,288,14,''),(19,300,14,''),(20,120,15,''),(21,220,14,''),(22,264,14,''),(23,10,14,'\0'),(24,50,14,'\0'),(25,30,16,''),(26,10,14,'\0');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  UNIQUE KEY `id_UNIQUE` (`id_product`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `product_category_id_category_fk` (`id_category`),
  CONSTRAINT `product_category_id_category_fk` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'chicken',0,30,1),(2,'chop',49,10,1),(3,'barbecue',54,24,1),(4,'hike',98,20,2),(5,'guinness',95,50,2),(6,'pineapple',88,30,3),(7,'cherry',87,10,3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-17  5:32:08
