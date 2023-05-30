-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ziimme
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `zim_mdm_data_branch_service`
--

DROP TABLE IF EXISTS `zim_mdm_data_branch_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_branch_service` (
  `branch_id` int NOT NULL AUTO_INCREMENT,
  `branch_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `branch_name_th` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `branch_name_eng` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_branch_service`
--

LOCK TABLES `zim_mdm_data_branch_service` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_branch_service` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_branch_service` VALUES (1,'ZEER','ซิเม่ เซียร์รังสิต','Ziimme ZeerRangsit','A','2023-05-21 23:00:44','admin_ziimme',NULL,NULL),(2,'NKS','ซิเม่ นครสวรรค์','Ziimme  Nakhon Sawan','A','2023-05-21 23:02:29','admin_ziimme',NULL,NULL),(3,'PCB','ซิเม่ เพชรบูรณ์','Ziimme Phetchabun','A','2023-05-21 23:03:11','admin_ziimme',NULL,NULL);
/*!40000 ALTER TABLE `zim_mdm_data_branch_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_mdm_data_course`
--

DROP TABLE IF EXISTS `zim_mdm_data_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_name_th` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_name_eng` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_detail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_course`
--

LOCK TABLES `zim_mdm_data_course` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_course` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_course` VALUES (1,'DBL','เลเซอร์หน้าใส','Duo Blue Light','A','2023-05-23 21:52:35','admin_ziimme',NULL,NULL,'-'),(2,'DBAC','เลเซอร์สิว','Duo Acne Celar','A','2023-05-23 22:14:07','admin_ziimme',NULL,NULL,'-'),(3,'DGS','เลเซอร์ฝ้า-กระ','Gold Switch','A','2023-05-23 22:14:35','admin_ziimme',NULL,NULL,NULL),(4,'DGC','เลเซอร์รักษาหลุม','Gold Cabon','A','2023-05-23 22:15:03','admin_ziimme',NULL,NULL,'-'),(5,'DMW','ขี้แมลงวัน','-','A','2023-05-23 22:15:30','admin_ziimme',NULL,NULL,'-'),(6,'DMO.','ไฝเม็ดใหญ่','-','A','2023-05-23 22:15:54','admin_ziimme',NULL,NULL,'-'),(7,'DMWF','เหมาทั้งหน้า','-','A','2023-05-23 22:16:12','admin_ziimme',NULL,NULL,'-'),(8,'DGS-M','-','Gold Switch','A','2023-05-23 22:17:18','admin_ziimme','2023-05-23 22:19:01','admin_ziimme','-'),(9,'DTM','ฝ้า กระ','-','A','2023-05-23 22:18:04','admin_ziimme','2023-05-23 22:20:20','admin_ziimme','-'),(10,'PDHY','ฝ้า-กระ ความชุ้มชื้น ริ้วรอย','-','A','2023-05-23 22:20:48','admin_ziimme',NULL,NULL,'-'),(11,'P-CELL','รอยดำ รอยแดง หลุมสิว','-','A','2023-05-23 22:21:17','admin_ziimme',NULL,NULL,'-'),(12,'PRP','-','Growth Factor','A','2023-05-23 22:21:37','admin_ziimme','2023-05-23 22:21:47','admin_ziimme','-'),(13,'DFM','-','Fill Med skin booster','A','2023-05-23 22:22:21','admin_ziimme',NULL,NULL,'-'),(14,'DFB-M','สลายไขมัน','FAT Babi Neo One','A','2023-05-23 22:22:50','admin_ziimme',NULL,NULL,'-'),(15,'DFB-PPC','สลายไขมัน body','FAT-PPC body','A','2023-05-23 22:23:31','admin_ziimme',NULL,NULL,'-'),(16,'DLGN','-','L-Genice','A','2023-05-23 22:24:39','admin_ziimme',NULL,NULL,'-'),(17,'DPGN','-','P-Genice','A','2023-05-23 22:25:05','admin_ziimme',NULL,NULL,'-'),(18,'DDF','-','Derma Dr. Fix','A','2023-05-23 22:25:48','admin_ziimme',NULL,NULL,'-'),(19,'DHR','ขนรักแร้','-','A','2023-05-23 22:26:18','admin_ziimme',NULL,NULL,'-'),(20,'DHM','ขนหนวด (ไม่รวมเครา-คราง)','-','A','2023-05-23 22:26:51','admin_ziimme',NULL,NULL,NULL),(21,'DHMM','ขนหนวด (รวมเครา-คราง)','-','A','2023-05-23 22:27:51','admin_ziimme',NULL,NULL,'-'),(22,'DHF','ขนที่หน้าทั้งหมด (รวมหนวด-เครา)','-','A','2023-05-23 22:30:35','admin_ziimme',NULL,NULL,'-'),(23,'DHA','ขนแขนทั้งหมด','-','A','2023-05-23 22:31:07','admin_ziimme',NULL,NULL,'-'),(24,'DHL','ขนแขน','-','A','2023-05-23 22:31:35','admin_ziimme',NULL,NULL,'-'),(25,'DHB','บิกินี่ทั้งหมด','-','A','2023-05-23 22:31:54','admin_ziimme',NULL,NULL,'-'),(26,'-','-','Stemcell','A','2023-05-23 22:32:45','admin_ziimme',NULL,NULL,'-'),(27,'GFS 50','-','Growth Factor Stemcell (50 PG)','A','2023-05-23 22:34:12','admin_ziimme',NULL,NULL,'50 PG'),(28,'GFS 100','-','Growth Factor Stemcell (100 PG)','A','2023-05-23 22:35:01','admin_ziimme','2023-05-23 22:35:07','admin_ziimme','100 PG'),(29,'FJUPX','-','Filler Juvdrem Ultra Plus XC','A','2023-05-23 22:36:09','admin_ziimme',NULL,NULL,'-'),(30,'FVM','-','Filer Voluma','A','2023-05-23 22:36:37','admin_ziimme',NULL,NULL,'-'),(31,'FVL','-','Filler Vitalight','A','2023-05-23 22:37:01','admin_ziimme',NULL,NULL,'-'),(32,'DBT','-','Botox HUGEL TOXIN','A','2023-05-23 22:37:38','admin_ziimme',NULL,NULL,'UNIT'),(33,'DMV','ไหม Safety Cog','Safey Cog','A','2023-05-23 22:38:14','admin_ziimme',NULL,NULL,'-'),(34,'NPUT','-','Power Ultra three','A','2023-05-23 22:39:01','admin_ziimme',NULL,NULL,'-'),(35,'NPMZ','-','Power Mesiz','A','2023-05-23 22:39:25','admin_ziimme',NULL,NULL,'-'),(36,'NFUF','-','Pormula Upper face','A','2023-05-23 22:39:48','admin_ziimme',NULL,NULL,'-'),(37,'NPUF','-','Power Ultra Fat','A','2023-05-23 22:40:11','admin_ziimme',NULL,NULL,'-'),(38,'LED','-','Duo LED 7 Light','A','2023-05-23 22:40:36','admin_ziimme',NULL,NULL,'-'),(39,'NPUS','-','Power Ultrasound','A','2023-05-23 22:40:58','admin_ziimme',NULL,NULL,'-'),(40,'NBAB','-','Aura Bright','A','2023-05-23 22:41:16','admin_ziimme',NULL,NULL,'-'),(41,'NOA','-','Oxy Acne Clear','A','2023-05-23 22:41:34','admin_ziimme',NULL,NULL,'-\n'),(42,'NRB','-','Gold Ruby + MASK','A','2023-05-23 22:41:59','admin_ziimme',NULL,NULL,'-'),(43,'NFR','-','Face Repair','A','2023-05-23 22:42:15','admin_ziimme',NULL,NULL,'-'),(44,'NBL','-','Bio Lifting Eye','A','2023-05-23 22:42:39','admin_ziimme',NULL,NULL,'-'),(45,'TML','-','The Mask LED (หน้ากาก)','A','2023-05-23 22:43:13','admin_ziimme',NULL,NULL,'-'),(46,'VM','-','VIP Mask','A','2023-05-23 22:43:32','admin_ziimme',NULL,NULL,'-'),(47,'NPDHY','-','NPDHY เครื่อง + AMP/DHY','A','2023-05-23 22:44:13','admin_ziimme','2023-05-23 22:59:03','admin_ziimme','-'),(48,'NPC','-','NPC เครื่อง + AMP/P-cell','A','2023-05-23 22:44:46','admin_ziimme','2023-05-23 22:59:11','admin_ziimme','-'),(49,'NTM','-','NTM เครื่อง + AMP/DTM','A','2023-05-23 22:45:31','admin_ziimme','2023-05-23 22:59:17','admin_ziimme','-');
/*!40000 ALTER TABLE `zim_mdm_data_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_mdm_data_districts`
--

DROP TABLE IF EXISTS `zim_mdm_data_districts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_districts` (
  `districts_id` int NOT NULL AUTO_INCREMENT,
  `districts_name_th` varchar(150) DEFAULT NULL,
  `districts_name_eng` varchar(150) DEFAULT NULL,
  `province_code` int DEFAULT NULL,
  PRIMARY KEY (`districts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=928 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_districts`
--

LOCK TABLES `zim_mdm_data_districts` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_districts` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_districts` VALUES (1,'เขตพระนคร','Khet Phra Nakhon',1),(2,'เขตดุสิต','Khet Dusit',1),(3,'เขตหนองจอก','Khet Nong Chok',1),(4,'เขตบางรัก','Khet Bang Rak',1),(5,'เขตบางเขน','Khet Bang Khen',1),(6,'เขตบางกะปิ','Khet Bang Kapi',1),(7,'เขตปทุมวัน','Khet Pathum Wan',1),(8,'เขตป้อมปราบศัตรูพ่าย','Khet Pom Prap Sattru Phai',1),(9,'เขตพระโขนง','Khet Phra Khanong',1),(10,'เขตมีนบุรี','Khet Min Buri',1),(11,'เขตลาดกระบัง','Khet Lat Krabang',1),(12,'เขตยานนาวา','Khet Yan Nawa',1),(13,'เขตสัมพันธวงศ์','Khet Samphanthawong',1),(14,'เขตพญาไท','Khet Phaya Thai',1),(15,'เขตธนบุรี','Khet Thon Buri',1),(16,'เขตบางกอกใหญ่','Khet Bangkok Yai',1),(17,'เขตห้วยขวาง','Khet Huai Khwang',1),(18,'เขตคลองสาน','Khet Khlong San',1),(19,'เขตตลิ่งชัน','Khet Taling Chan',1),(20,'เขตบางกอกน้อย','Khet Bangkok Noi',1),(21,'เขตบางขุนเทียน','Khet Bang Khun Thian',1),(22,'เขตภาษีเจริญ','Khet Phasi Charoen',1),(23,'เขตหนองแขม','Khet Nong Khaem',1),(24,'เขตราษฎร์บูรณะ','Khet Rat Burana',1),(25,'เขตบางพลัด','Khet Bang Phlat',1),(26,'เขตดินแดง','Khet Din Daeng',1),(27,'เขตบึงกุ่ม','Khet Bueng Kum',1),(28,'เขตสาทร','Khet Sathon',1),(29,'เขตบางซื่อ','Khet Bang Sue',1),(30,'เขตจตุจักร','Khet Chatuchak',1),(31,'เขตบางคอแหลม','Khet Bang Kho Laem',1),(32,'เขตประเวศ','Khet Prawet',1),(33,'เขตคลองเตย','Khet Khlong Toei',1),(34,'เขตสวนหลวง','Khet Suan Luang',1),(35,'เขตจอมทอง','Khet Chom Thong',1),(36,'เขตดอนเมือง','Khet Don Mueang',1),(37,'เขตราชเทวี','Khet Ratchathewi',1),(38,'เขตลาดพร้าว','Khet Lat Phrao',1),(39,'เขตวัฒนา','Khet Watthana',1),(40,'เขตบางแค','Khet Bang Khae',1),(41,'เขตหลักสี่','Khet Lak Si',1),(42,'เขตสายไหม','Khet Sai Mai',1),(43,'เขตคันนายาว','Khet Khan Na Yao',1),(44,'เขตสะพานสูง','Khet Saphan Sung',1),(45,'เขตวังทองหลาง','Khet Wang Thonglang',1),(46,'เขตคลองสามวา','Khet Khlong Sam Wa',1),(47,'เขตบางนา','Khet Bang Na',1),(48,'เขตทวีวัฒนา','Khet Thawi Watthana',1),(49,'เขตทุ่งครุ','Khet Thung Khru',1),(50,'เขตบางบอน','Khet Bang Bon',1),(51,'เมืองสมุทรปราการ','Mueang Samut Prakan',2),(52,'บางบ่อ','Bang Bo',2),(53,'บางพลี','Bang Phli',2),(54,'พระประแดง','Phra Pradaeng',2),(55,'พระสมุทรเจดีย์','Phra Samut Chedi',2),(56,'บางเสาธง','Bang Sao Thong',2),(57,'เมืองนนทบุรี','Mueang Nonthaburi',3),(58,'บางกรวย','Bang Kruai',3),(59,'บางใหญ่','Bang Yai',3),(60,'บางบัวทอง','Bang Bua Thong',3),(61,'ไทรน้อย','Sai Noi',3),(62,'ปากเกร็ด','Pak Kret',3),(63,'เมืองปทุมธานี','Mueang Pathum Thani',4),(64,'คลองหลวง','Khlong Luang',4),(65,'ธัญบุรี','Thanyaburi',4),(66,'หนองเสือ','Nong Suea',4),(67,'ลาดหลุมแก้ว','Lat Lum Kaeo',4),(68,'ลำลูกกา','Lam Luk Ka',4),(69,'สามโคก','Sam Khok',4),(70,'พระนครศรีอยุธยา','Phra Nakhon Si Ayutthaya',5),(71,'ท่าเรือ','Tha Ruea',5),(72,'นครหลวง','Nakhon Luang',5),(73,'บางไทร','Bang Sai',5),(74,'บางบาล','Bang Ban',5),(75,'บางปะอิน','Bang Pa-in',5),(76,'บางปะหัน','Bang Pahan',5),(77,'ผักไห่','Phak Hai',5),(78,'ภาชี','Phachi',5),(79,'ลาดบัวหลวง','Lat Bua Luang',5),(80,'วังน้อย','Wang Noi',5),(81,'เสนา','Sena',5),(82,'บางซ้าย','Bang Sai',5),(83,'อุทัย','Uthai',5),(84,'มหาราช','Maha Rat',5),(85,'บ้านแพรก','Ban Phraek',5),(86,'เมืองอ่างทอง','Mueang Ang Thong',6),(87,'ไชโย','Chaiyo',6),(88,'ป่าโมก','Pa Mok',6),(89,'โพธิ์ทอง','Pho Thong',6),(90,'แสวงหา','Sawaeng Ha',6),(91,'วิเศษชัยชาญ','Wiset Chai Chan',6),(92,'สามโก้','Samko',6),(93,'เมืองลพบุรี','Mueang Lop Buri',7),(94,'พัฒนานิคม','Phatthana Nikhom',7),(95,'โคกสำโรง','Khok Samrong',7),(96,'ชัยบาดาล','Chai Badan',7),(97,'ท่าวุ้ง','Tha Wung',7),(98,'บ้านหมี่','Ban Mi',7),(99,'ท่าหลวง','Tha Luang',7),(100,'สระโบสถ์','Sa Bot',7),(101,'โคกเจริญ','Khok Charoen',7),(102,'ลำสนธิ','Lam Sonthi',7),(103,'หนองม่วง','Nong Muang',7),(104,'เมืองสิงห์บุรี','Mueang Sing Buri',8),(105,'บางระจัน','Bang Rachan',8),(106,'ค่ายบางระจัน','Khai Bang Rachan',8),(107,'พรหมบุรี','Phrom Buri',8),(108,'ท่าช้าง','Tha Chang',8),(109,'อินทร์บุรี','In Buri',8),(110,'เมืองชัยนาท','Mueang Chai Nat',9),(111,'มโนรมย์','Manorom',9),(112,'วัดสิงห์','Wat Sing',9),(113,'สรรพยา','Sapphaya',9),(114,'สรรคบุรี','Sankhaburi',9),(115,'หันคา','Hankha',9),(116,'หนองมะโมง','Nong Mamong',9),(117,'เนินขาม','Noen Kham',9),(118,'เมืองสระบุรี','Mueang Saraburi',10),(119,'แก่งคอย','Kaeng Khoi',10),(120,'หนองแค','Nong Khae',10),(121,'วิหารแดง','Wihan Daeng',10),(122,'หนองแซง','Nong Saeng',10),(123,'บ้านหมอ','Ban Mo',10),(124,'ดอนพุด','Don Phut',10),(125,'หนองโดน','Nong Don',10),(126,'พระพุทธบาท','Phra Phutthabat',10),(127,'เสาไห้','Sao Hai',10),(128,'มวกเหล็ก','Muak Lek',10),(129,'วังม่วง','Wang Muang',10),(130,'เฉลิมพระเกียรติ','Chaloem Phra Kiat',10),(131,'เมืองชลบุรี','Mueang Chon Buri',11),(132,'บ้านบึง','Ban Bueng',11),(133,'หนองใหญ่','Nong Yai',11),(134,'บางละมุง','Bang Lamung',11),(135,'พานทอง','Phan Thong',11),(136,'พนัสนิคม','Phanat Nikhom',11),(137,'ศรีราชา','Si Racha',11),(138,'เกาะสีชัง','Ko Sichang',11),(139,'สัตหีบ','Sattahip',11),(140,'บ่อทอง','Bo Thong',11),(141,'เกาะจันทร์','Ko Chan',11),(142,'เมืองระยอง','Mueang Rayong',12),(143,'บ้านฉาง','Ban Chang',12),(144,'แกลง','Klaeng',12),(145,'วังจันทร์','Wang Chan',12),(146,'บ้านค่าย','Ban Khai',12),(147,'ปลวกแดง','Pluak Daeng',12),(148,'เขาชะเมา','Khao Chamao',12),(149,'นิคมพัฒนา','Nikhom Phatthana',12),(150,'เมืองจันทบุรี','Mueang Chanthaburi',13),(151,'ขลุง','Khlung',13),(152,'ท่าใหม่','Tha Mai',13),(153,'โป่งน้ำร้อน','Pong Nam Ron',13),(154,'มะขาม','Makham',13),(155,'แหลมสิงห์','Laem Sing',13),(156,'สอยดาว','Soi Dao',13),(157,'แก่งหางแมว','Kaeng Hang Maeo',13),(158,'นายายอาม','Na Yai Am',13),(159,'เขาคิชฌกูฏ','Khoa Khitchakut',13),(160,'เมืองตราด','Mueang Trat',14),(161,'คลองใหญ่','Khlong Yai',14),(162,'เขาสมิง','Khao Saming',14),(163,'บ่อไร่','Bo Rai',14),(164,'แหลมงอบ','Laem Ngop',14),(165,'เกาะกูด','Ko Kut',14),(166,'เกาะช้าง','Ko Chang',14),(167,'เมืองฉะเชิงเทรา','Mueang Chachoengsao',15),(168,'บางคล้า','Bang Khla',15),(169,'บางน้ำเปรี้ยว','Bang Nam Priao',15),(170,'บางปะกง','Bang Pakong',15),(171,'บ้านโพธิ์','Ban Pho',15),(172,'พนมสารคาม','Phanom Sarakham',15),(173,'ราชสาส์น','Ratchasan',15),(174,'สนามชัยเขต','Sanam Chai Khet',15),(175,'แปลงยาว','Plaeng Yao',15),(176,'ท่าตะเกียบ','Tha Takiap',15),(177,'คลองเขื่อน','Khlong Khuean',15),(178,'เมืองปราจีนบุรี','Mueang Prachin Buri',16),(179,'กบินทร์บุรี','Kabin Buri',16),(180,'นาดี','Na Di',16),(181,'บ้านสร้าง','Ban Sang',16),(182,'ประจันตคาม','Prachantakham',16),(183,'ศรีมหาโพธิ','Si Maha Phot',16),(184,'ศรีมโหสถ','Si Mahosot',16),(185,'เมืองนครนายก','Mueang Nakhon Nayok',17),(186,'ปากพลี','Pak Phli',17),(187,'บ้านนา','Ban Na',17),(188,'องครักษ์','Ongkharak',17),(189,'เมืองสระแก้ว','Mueang Sa Kaeo',18),(190,'คลองหาด','Khlong Hat',18),(191,'ตาพระยา','Ta Phraya',18),(192,'วังน้ำเย็น','Wang Nam Yen',18),(193,'วัฒนานคร','Watthana Nakhon',18),(194,'อรัญประเทศ','Aranyaprathet',18),(195,'เขาฉกรรจ์','Khao Chakan',18),(196,'โคกสูง','Khok Sung',18),(197,'วังสมบูรณ์','Wang Sombun',18),(198,'เมืองนครราชสีมา','Mueang Nakhon Ratchasima',19),(199,'ครบุรี','Khon Buri',19),(200,'เสิงสาง','Soeng Sang',19),(201,'คง','Khong',19),(202,'บ้านเหลื่อม','Ban Lueam',19),(203,'จักราช','Chakkarat',19),(204,'โชคชัย','Chok Chai',19),(205,'ด่านขุนทด','Dan Khun Thot',19),(206,'โนนไทย','Non Thai',19),(207,'โนนสูง','Non Sung',19),(208,'ขามสะแกแสง','Kham Sakaesaeng',19),(209,'บัวใหญ่','Bua Yai',19),(210,'ประทาย','Prathai',19),(211,'ปักธงชัย','Pak Thong Chai',19),(212,'พิมาย','Phimai',19),(213,'ห้วยแถลง','Huai Thalaeng',19),(214,'ชุมพวง','Chum Phuang',19),(215,'สูงเนิน','Sung Noen',19),(216,'ขามทะเลสอ','Kham Thale So',19),(217,'สีคิ้ว','Sikhio',19),(218,'ปากช่อง','Pak Chong',19),(219,'หนองบุญมาก','Nong Bunnak',19),(220,'แก้งสนามนาง','Kaeng Sanam Nang',19),(221,'โนนแดง','Non Daeng',19),(222,'วังน้ำเขียว','Wang Nam Khiao',19),(223,'เทพารักษ์','Thepharak',19),(224,'เมืองยาง','Mueang Yang',19),(225,'พระทองคำ','Phra Thong Kham',19),(226,'ลำทะเมนชัย','Lam Thamenchai',19),(227,'บัวลาย','Bua Lai',19),(228,'สีดา','Sida',19),(229,'เฉลิมพระเกียรติ','Chaloem Phra Kiat',19),(230,'เมืองบุรีรัมย์','Mueang Buri Ram',20),(231,'คูเมือง','Khu Mueang',20),(232,'กระสัง','Krasang',20),(233,'นางรอง','Nang Rong',20),(234,'หนองกี่','Nong Ki',20),(235,'ละหานทราย','Lahan Sai',20),(236,'ประโคนชัย','Prakhon Chai',20),(237,'บ้านกรวด','Ban Kruat',20),(238,'พุทไธสง','Phutthaisong',20),(239,'ลำปลายมาศ','Lam Plai Mat',20),(240,'สตึก','Satuek',20),(241,'ปะคำ','Pakham',20),(242,'นาโพธิ์','Na Pho',20),(243,'หนองหงส์','Nong Hong',20),(244,'พลับพลาชัย','Phlapphla Chai',20),(245,'ห้วยราช','Huai Rat',20),(246,'โนนสุวรรณ','Non Suwan',20),(247,'ชำนิ','Chamni',20),(248,'บ้านใหม่ไชยพจน์','Ban Mai Chaiyaphot',20),(249,'โนนดินแดง','Din Daeng',20),(250,'บ้านด่าน','Ban Dan',20),(251,'แคนดง','Khaen Dong',20),(252,'เฉลิมพระเกียรติ','Chaloem Phra Kiat',20),(253,'เมืองสุรินทร์','Mueang Surin',21),(254,'ชุมพลบุรี','Chumphon Buri',21),(255,'ท่าตูม','Tha Tum',21),(256,'จอมพระ','Chom Phra',21),(257,'ปราสาท','Prasat',21),(258,'กาบเชิง','Kap Choeng',21),(259,'รัตนบุรี','Rattanaburi',21),(260,'สนม','Sanom',21),(261,'ศีขรภูมิ','Sikhoraphum',21),(262,'สังขะ','Sangkha',21),(263,'ลำดวน','Lamduan',21),(264,'สำโรงทาบ','Samrong Thap',21),(265,'บัวเชด','Buachet',21),(266,'พนมดงรัก','Phanom Dong Rak',21),(267,'ศรีณรงค์','Si Narong',21),(268,'เขวาสินรินทร์','Khwao Sinarin',21),(269,'โนนนารายณ์','Non Narai',21),(270,'เมืองศรีสะเกษ','Mueang Si Sa Ket',22),(271,'ยางชุมน้อย','Yang Chum Noi',22),(272,'กันทรารมย์','Kanthararom',22),(273,'กันทรลักษ์','Kantharalak',22),(274,'ขุขันธ์','Khukhan',22),(275,'ไพรบึง','Phrai Bueng',22),(276,'ปรางค์กู่','Prang Ku',22),(277,'ขุนหาญ','Khun Han',22),(278,'ราษีไศล','Rasi Salai',22),(279,'อุทุมพรพิสัย','Uthumphon Phisai',22),(280,'บึงบูรพ์','Bueng Bun',22),(281,'ห้วยทับทัน','Huai Thap Than',22),(282,'โนนคูณ','Non Khun',22),(283,'ศรีรัตนะ','Si Rattana',22),(284,'น้ำเกลี้ยง','Si Rattana',22),(285,'วังหิน','Wang Hin',22),(286,'ภูสิงห์','Phu Sing',22),(287,'เมืองจันทร์','Mueang Chan',22),(288,'เบญจลักษ์','Benchalak',22),(289,'พยุห์','Phayu',22),(290,'โพธิ์ศรีสุวรรณ','Pho Si Suwan',22),(291,'ศิลาลาด','Sila Lat',22),(292,'เมืองอุบลราชธานี','Mueang Ubon Ratchathani',23),(293,'ศรีเมืองใหม่','Si Mueang Mai',23),(294,'โขงเจียม','Khong Chiam',23),(295,'เขื่องใน','Khueang Nai',23),(296,'เขมราฐ','Khemarat',23),(297,'เดชอุดม','Det Udom',23),(298,'นาจะหลวย','Na Chaluai',23),(299,'น้ำยืน','Nam Yuen',23),(300,'บุณฑริก','Buntharik',23),(301,'ตระการพืชผล','Trakan Phuet Phon',23),(302,'กุดข้าวปุ้น','Kut Khaopun',23),(303,'ม่วงสามสิบ','Muang Sam Sip',23),(304,'วารินชำราบ','Warin Chamrap',23),(305,'พิบูลมังสาหาร','Phibun Mangsahan',23),(306,'ตาลสุม','Tan Sum',23),(307,'โพธิ์ไทร','Pho Sai',23),(308,'สำโรง','Samrong',23),(309,'ดอนมดแดง','Don Mot Daeng',23),(310,'สิรินธร','Sirindhorn',23),(311,'ทุ่งศรีอุดม','Thung Si Udom',23),(312,'นาเยีย','Na Yia',23),(313,'นาตาล','Na Tan',23),(314,'เหล่าเสือโก้ก','Lao Suea Kok',23),(315,'สว่างวีระวงศ์','Sawang Wirawong',23),(316,'น้ำขุ่น','Nam Khun',23),(317,'เมืองยโสธร','Mueang Yasothon',24),(318,'ทรายมูล','Sai Mun',24),(319,'กุดชุม','Kut Chum',24),(320,'คำเขื่อนแก้ว','Kham Khuean Kaeo',24),(321,'ป่าติ้ว','Pa Tio',24),(322,'มหาชนะชัย','Maha Chana Chai',24),(323,'ค้อวัง','Kho Wang',24),(324,'เลิงนกทา','Loeng Nok Tha',24),(325,'ไทยเจริญ','Thai Charoen',24),(326,'เมืองชัยภูมิ','Mueang Chaiyaphum',25),(327,'บ้านเขว้า','Ban Khwao',25),(328,'คอนสวรรค์','Khon Sawan',25),(329,'เกษตรสมบูรณ์','Kaset Sombun',25),(330,'หนองบัวแดง','Nong Bua Daeng',25),(331,'จัตุรัส','Chatturat',25),(332,'บำเหน็จณรงค์','Bamnet Narong',25),(333,'หนองบัวระเหว','Nong Bua Rawe',25),(334,'เทพสถิต','Thep Sathit',25),(335,'ภูเขียว','Phu Khiao',25),(336,'บ้านแท่น','Ban Thaen',25),(337,'แก้งคร้อ','Kaeng Khro',25),(338,'คอนสาร','Khon San',25),(339,'ภักดีชุมพล','Phakdi Chumphon',25),(340,'เนินสง่า','Noen Sa-nga',25),(341,'ซับใหญ่','Sap Yai',25),(342,'เมืองอำนาจเจริญ','Mueang Amnat Charoen',26),(343,'ชานุมาน','Chanuman',26),(344,'ปทุมราชวงศา','Pathum Ratchawongsa',26),(345,'พนา','Phana',26),(346,'เสนางคนิคม','Senangkhanikhom',26),(347,'หัวตะพาน','Hua Taphan',26),(348,'ลืออำนาจ','Lue Amnat',26),(349,'เมืองหนองบัวลำภู','Mueang Nong Bua Lam Phu',27),(350,'นากลาง','Na Klang',27),(351,'โนนสัง','Non Sang',27),(352,'ศรีบุญเรือง','Si Bun Rueang',27),(353,'สุวรรณคูหา','Suwannakhuha',27),(354,'นาวัง','Na Wang',27),(355,'เมืองขอนแก่น','Mueang Khon Kaen',28),(356,'บ้านฝาง','Ban Fang',28),(357,'พระยืน','Phra Yuen',28),(358,'หนองเรือ','Nong Ruea',28),(359,'ชุมแพ','Chum Phae',28),(360,'สีชมพู','Si Chomphu',28),(361,'น้ำพอง','Nam Phong',28),(362,'อุบลรัตน์','Ubolratana',28),(363,'กระนวน','Kranuan',28),(364,'บ้านไผ่','Ban Phai',28),(365,'เปือยน้อย','Pueai Noi',28),(366,'พล','Phon',28),(367,'แวงใหญ่','Waeng Yai',28),(368,'แวงน้อย','Waeng Noi',28),(369,'หนองสองห้อง','Nong Song Hong',28),(370,'ภูเวียง','Phu Wiang',28),(371,'มัญจาคีรี','Mancha Khiri',28),(372,'ชนบท','Chonnabot',28),(373,'เขาสวนกวาง','Khao Suan Kwang',28),(374,'ภูผาม่าน','Phu Pha Man',28),(375,'ซำสูง','Sam Sung',28),(376,'โคกโพธิ์ไชย','Khok Pho Chai',28),(377,'หนองนาคำ','Nong Na Kham',28),(378,'บ้านแฮด','Ban Haet',28),(379,'โนนศิลา','Non Sila',28),(380,'เวียงเก่า','Wiang Kao',28),(381,'เมืองอุดรธานี','Mueang Udon Thani',29),(382,'กุดจับ','Kut Chap',29),(383,'หนองวัวซอ','Nong Wua So',29),(384,'กุมภวาปี','Kumphawapi',29),(385,'โนนสะอาด','Non Sa-at',29),(386,'หนองหาน','Nong Han',29),(387,'ทุ่งฝน','Thung Fon',29),(388,'ไชยวาน','Chai Wan',29),(389,'ศรีธาตุ','Si That',29),(390,'วังสามหมอ','Wang Sam Mo',29),(391,'บ้านดุง','Ban Dung',29),(392,'บ้านผือ','Ban Phue',29),(393,'น้ำโสม','Nam Som',29),(394,'เพ็ญ','Phen',29),(395,'สร้างคอม','Sang Khom',29),(396,'หนองแสง','Nong Saeng',29),(397,'นายูง','Na Yung',29),(398,'พิบูลย์รักษ์','Phibun Rak',29),(399,'กู่แก้ว','Ku Kaeo',29),(400,'ประจักษ์ศิลปาคม','rachak-sinlapakhom',29),(401,'เมืองเลย','Mueang Loei',30),(402,'นาด้วง','Na Duang',30),(403,'เชียงคาน','Chiang Khan',30),(404,'ปากชม','Pak Chom',30),(405,'ด่านซ้าย','Dan Sai',30),(406,'นาแห้ว','Na Haeo',30),(407,'ภูเรือ','Phu Ruea',30),(408,'ท่าลี่','Tha Li',30),(409,'วังสะพุง','Wang Saphung',30),(410,'ภูกระดึง','Phu Kradueng',30),(411,'ภูหลวง','Phu Luang',30),(412,'ผาขาว','Pha Khao',30),(413,'เอราวัณ','Erawan',30),(414,'หนองหิน','Nong Hin',30),(415,'เมืองหนองคาย','Mueang Nong Khai',31),(416,'ท่าบ่อ','Tha Bo',31),(417,'โพนพิสัย','Phon Phisai',31),(418,'ศรีเชียงใหม่','Si Chiang Mai',31),(419,'สังคม','Sangkhom',31),(420,'สระใคร','Sakhrai',31),(421,'เฝ้าไร่','Fao Rai',31),(422,'รัตนวาปี','Rattanawapi',31),(423,'โพธิ์ตาก','Pho Tak',31),(424,'เมืองมหาสารคาม','Mueang Maha Sarakham',32),(425,'แกดำ','Kae Dam',32),(426,'โกสุมพิสัย','Kosum Phisai',32),(427,'กันทรวิชัย','Kantharawichai',32),(428,'เชียงยืน','Kantharawichai',32),(429,'บรบือ','Borabue',32),(430,'นาเชือก','Na Chueak',32),(431,'พยัคฆภูมิพิสัย','Phayakkhaphum Phisai',32),(432,'วาปีปทุม','Wapi Pathum',32),(433,'นาดูน','Na Dun',32),(434,'ยางสีสุราช','Yang Sisurat',32),(435,'กุดรัง','Kut Rang',32),(436,'ชื่นชม','Chuen Chom',32),(437,'เมืองร้อยเอ็ด','Mueang Roi Et',33),(438,'เกษตรวิสัย','Kaset Wisai',33),(439,'ปทุมรัตต์','Pathum Rat',33),(440,'จตุรพักตรพิมาน','Chaturaphak Phiman',33),(441,'ธวัชบุรี','Thawat Buri',33),(442,'พนมไพร','Phanom Phrai',33),(443,'โพนทอง','Phon Thong',33),(444,'โพธิ์ชัย','Pho Chai',33),(445,'หนองพอก','Nong Phok',33),(446,'เสลภูมิ','Selaphum',33),(447,'สุวรรณภูมิ','Suwannaphum',33),(448,'เมืองสรวง','Mueang Suang',33),(449,'โพนทราย','Phon Sai',33),(450,'อาจสามารถ','At Samat',33),(451,'เมยวดี','Moei Wadi',33),(452,'ศรีสมเด็จ','Si Somdet',33),(453,'จังหาร','Changhan',33),(454,'เชียงขวัญ','Chiang Khwan',33),(455,'หนองฮี','Nong Hi',33),(456,'ทุ่งเขาหลวง','Thung Khao Luangกิ่',33),(457,'เมืองกาฬสินธุ์','Mueang Kalasin',34),(458,'นามน','Na Mon',34),(459,'กมลาไสย','Kamalasai',34),(460,'ร่องคำ','Rong Kham',34),(461,'กุฉินารายณ์','Kuchinarai',34),(462,'เขาวง','Khao Wong',34),(463,'ยางตลาด','Yang Talat',34),(464,'ห้วยเม็ก','Huai Mek',34),(465,'สหัสขันธ์','Sahatsakhan',34),(466,'คำม่วง','Kham Muang',34),(467,'ท่าคันโท','Tha Khantho',34),(468,'หนองกุงศรี','Nong Kung Si',34),(469,'สมเด็จ','Somdet',34),(470,'ห้วยผึ้ง','Huai Phueng',34),(471,'สามชัย','Sam Chai',34),(472,'นาคู','Na Khu',34),(473,'ดอนจาน','Don Chan',34),(474,'ฆ้องชัย','Khong Chai',34),(475,'เมืองสกลนคร','Mueang Sakon Nakhon',35),(476,'กุสุมาลย์','Kusuman',35),(477,'กุดบาก','Kut Bak',35),(478,'พรรณานิคม','Phanna Nikhom',35),(479,'พังโคน','Phang Khon',35),(480,'วาริชภูมิ','Waritchaphum',35),(481,'นิคมน้ำอูน','Nikhom Nam Un',35),(482,'วานรนิวาส','Wanon Niwat',35),(483,'คำตากล้า','Kham Ta Kla',35),(484,'บ้านม่วง','Ban Muang',35),(485,'อากาศอำนวย','Akat Amnuai',35),(486,'สว่างแดนดิน','Sawang Daen Din',35),(487,'ส่องดาว','Song Dao',35),(488,'เต่างอย','Tao Ngoi',35),(489,'โคกศรีสุพรรณ','Khok Si Suphan',35),(490,'เจริญศิลป์','Charoen Sin',35),(491,'โพนนาแก้ว','Phon Na Kaeo',35),(492,'ภูพาน','Phu Phan',35),(493,'เมืองนครพนม','Mueang Nakhon Phanom',36),(494,'ปลาปาก','Pla Pak',36),(495,'ท่าอุเทน','Tha Uthen',36),(496,'บ้านแพง','Ban Phaeng',36),(497,'ธาตุพนม','That Phanom',36),(498,'เรณูนคร','Renu Nakhon',36),(499,'นาแก','Na Kae',36),(500,'ศรีสงคราม','Si Songkhram',36),(501,'นาหว้า','Na Wa',36),(502,'โพนสวรรค์','Phon Sawan',36),(503,'นาทม','Na Thom',36),(504,'วังยาง','Wang Yang',36),(505,'เมืองมุกดาหาร','Mueang Mukdahan',37),(506,'นิคมคำสร้อย','Nikhom Kham Soi',37),(507,'ดอนตาล','Don Tan',37),(508,'ดงหลวง','Dong Luang',37),(509,'คำชะอี','Khamcha-i',37),(510,'หว้านใหญ่','Wan Yai',37),(511,'หนองสูง','Nong Sung',37),(512,'เมืองเชียงใหม่','Mueang Chiang Mai',38),(513,'จอมทอง','Chom Thong',38),(514,'แม่แจ่ม','Mae Chaem',38),(515,'เชียงดาว','Chiang Dao',38),(516,'ดอยสะเก็ด','Doi Saket',38),(517,'แม่แตง','Mae Taeng',38),(518,'แม่ริม','Mae Rim',38),(519,'สะเมิง','Samoeng',38),(520,'ฝาง','Fang',38),(521,'แม่อาย','Mae Ai',38),(522,'พร้าว','Phrao',38),(523,'สันป่าตอง','San Pa Tong',38),(524,'สันกำแพง','San Kamphaeng',38),(525,'สันทราย','San Sai',38),(526,'หางดง','Hang Dong',38),(527,'ฮอด','Hot',38),(528,'ดอยเต่า','Doi Tao',38),(529,'อมก๋อย','Omkoi',38),(530,'สารภี','Saraphi',38),(531,'เวียงแหง','Wiang Haeng',38),(532,'ไชยปราการ','Chai Prakan',38),(533,'แม่วาง','Mae Wang',38),(534,'แม่ออน','Mae On',38),(535,'ดอยหล่อ','Doi Lo',38),(536,'เมืองลำพูน','Mueang Lamphun',39),(537,'แม่ทา','Mae Tha',39),(538,'บ้านโฮ่ง','Ban Hong',39),(539,'ลี้','Li',39),(540,'ทุ่งหัวช้าง','Thung Hua Chang',39),(541,'ป่าซาง','Pa Sang',39),(542,'บ้านธิ','Ban Thi',39),(543,'เวียงหนองล่อง','Wiang Nong Long',39),(544,'เมืองลำปาง','Mueang Lampang',40),(545,'แม่เมาะ','Mae Mo',40),(546,'เกาะคา','Ko Kha',40),(547,'เสริมงาม','Soem Ngam',40),(548,'งาว','Ngao',40),(549,'แจ้ห่ม','Chae Hom',40),(550,'วังเหนือ','Wang Nuea',40),(551,'เถิน','Thoen',40),(552,'แม่พริก','Mae Phrik',40),(553,'แม่ทะ','Mae Tha',40),(554,'สบปราบ','Sop Prap',40),(555,'ห้างฉัตร','Hang Chat',40),(556,'เมืองปาน','Mueang Pan',40),(557,'เมืองอุตรดิตถ์','Mueang Uttaradit',41),(558,'ตรอน','Tron',41),(559,'ท่าปลา','Tha Pla',41),(560,'น้ำปาด','Nam Pat',41),(561,'ฟากท่า','Fak Tha',41),(562,'บ้านโคก','Ban Khok',41),(563,'พิชัย','Phichai',41),(564,'ลับแล','Laplae',41),(565,'ทองแสนขัน','Thong Saen Khan',41),(566,'เมืองแพร่','Mueang Phrae',42),(567,'ร้องกวาง','Rong Kwang',42),(568,'ลอง','Long',42),(569,'สูงเม่น','Sung Men',42),(570,'เด่นชัย','Den Chai',42),(571,'สอง','Song',42),(572,'วังชิ้น','Wang Chin',42),(573,'หนองม่วงไข่','Nong Muang Khai',42),(574,'เมืองน่าน','Mueang Nan',43),(575,'แม่จริม','Mae Charim',43),(576,'บ้านหลวง','Ban Luang',43),(577,'นาน้อย','Na Noi',43),(578,'ปัว','Pua',43),(579,'ท่าวังผา','Tha Wang Pha',43),(580,'เวียงสา','Wiang Sa',43),(581,'ทุ่งช้าง','Thung Chang',43),(582,'เชียงกลาง','Chiang Klang',43),(583,'นาหมื่น','Na Muen',43),(584,'สันติสุข','Santi Suk',43),(585,'บ่อเกลือ','Bo Kluea',43),(586,'สองแคว','Song Khwae',43),(587,'ภูเพียง','Phu Phiang',43),(588,'เฉลิมพระเกียรติ','Chaloem Phra Kiat',43),(589,'เมืองพะเยา','Mueang Phayao',44),(590,'จุน','Chun',44),(591,'เชียงคำ','Chiang Kham',44),(592,'เชียงม่วน','Chiang Muan',44),(593,'ดอกคำใต้','Dok Khamtai',44),(594,'ปง','Pong',44),(595,'แม่ใจ','Mae Chai',44),(596,'ภูซาง','Phu Sang',44),(597,'ภูกามยาว','Phu Kamyao',44),(598,'เมืองเชียงราย','Mueang Chiang Rai',45),(599,'เวียงชัย','Wiang Chai',45),(600,'เชียงของ','Chiang Khong',45),(601,'เทิง','Thoeng',45),(602,'พาน','Phan',45),(603,'ป่าแดด','Pa Daet',45),(604,'แม่จัน','Mae Chan',45),(605,'เชียงแสน','Chiang Saen',45),(606,'แม่สาย','Mae Sai',45),(607,'แม่สรวย','Mae Suai',45),(608,'เวียงป่าเป้า','Wiang Pa Pao',45),(609,'พญาเม็งราย','Phaya Mengrai',45),(610,'เวียงแก่น','Wiang Kaen',45),(611,'ขุนตาล','Khun Tan',45),(612,'แม่ฟ้าหลวง','Mae Fa Luang',45),(613,'แม่ลาว','Mae Lao',45),(614,'เวียงเชียงรุ้ง','Wiang Chiang Rung',45),(615,'ดอยหลวง','Doi Luang',45),(616,'เมืองแม่ฮ่องสอน','Mueang Mae Hong Son',46),(617,'ขุนยวม','Khun Yuam',46),(618,'ปาย','Pai',46),(619,'แม่สะเรียง','Mae Sariang',46),(620,'แม่ลาน้อย','Mae La Noi',46),(621,'สบเมย','Sop Moei',46),(622,'ปางมะผ้า','Pang Mapha',46),(623,'เมืองนครสวรรค์','Mueang Nakhon Sawan',47),(624,'โกรกพระ','Krok Phra',47),(625,'ชุมแสง','Chum Saeng',47),(626,'หนองบัว','Nong Bua',47),(627,'บรรพตพิสัย','Banphot Phisai',47),(628,'เก้าเลี้ยว','Kao Liao',47),(629,'ตาคลี','Takhli',47),(630,'ท่าตะโก','Takhli',47),(631,'ไพศาลี','Phaisali',47),(632,'พยุหะคีรี','Phayuha Khiri',47),(633,'ลาดยาว','Phayuha Khiri',47),(634,'ตากฟ้า','Tak Fa',47),(635,'แม่วงก์','Mae Wong',47),(636,'แม่เปิน','Mae Poen',47),(637,'ชุมตาบง','Chum Ta Bong',47),(638,'เมืองอุทัยธานี','Mueang Uthai Thani',48),(639,'ทัพทัน','Thap Than',48),(640,'สว่างอารมณ์','Sawang Arom',48),(641,'หนองฉาง','Nong Chang',48),(642,'หนองขาหย่าง','Nong Khayang',48),(643,'บ้านไร่','Ban Rai',48),(644,'ลานสัก','Lan Sak',48),(645,'ห้วยคต','Huai Khot',48),(646,'เมืองกำแพงเพชร','Mueang Kamphaeng Phet',49),(647,'ไทรงาม','Sai Ngam',49),(648,'คลองลาน','Khlong Lan',49),(649,'ขาณุวรลักษบุรี','Khanu Woralaksaburi',49),(650,'คลองขลุง','Khlong Khlung',49),(651,'พรานกระต่าย','Phran Kratai',49),(652,'ลานกระบือ','Lan Krabue',49),(653,'ทรายทองวัฒนา','Sai Thong Watthana',49),(654,'ปางศิลาทอง','Pang Sila Thong',49),(655,'บึงสามัคคี','Bueng Samakkhi',49),(656,'โกสัมพีนคร','Kosamphi Nakhon',49),(657,'เมืองตาก','Mueang Tak',50),(658,'บ้านตาก','Ban Tak',50),(659,'สามเงา','Sam Ngao',50),(660,'แม่ระมาด','Mae Ramat',50),(661,'ท่าสองยาง','Tha Song Yang',50),(662,'แม่สอด','Mae Sot',50),(663,'พบพระ','Phop Phra',50),(664,'อุ้มผาง','Umphang',50),(665,'วังเจ้า','Wang Chao',50),(666,'เมืองสุโขทัย','Mueang Sukhothai',51),(667,'บ้านด่านลานหอย','Ban Dan Lan Hoi',51),(668,'คีรีมาศ','Khiri Mat',51),(669,'กงไกรลาศ','Kong Krailat',51),(670,'ศรีสัชนาลัย','Si Satchanalai',51),(671,'ศรีสำโรง','Si Samrong',51),(672,'สวรรคโลก','Sawankhalok',51),(673,'ศรีนคร','Si Nakhon',51),(674,'ทุ่งเสลี่ยม','Thung Saliam',51),(675,'เมืองพิษณุโลก','Mueang Phitsanulok',52),(676,'นครไทย','Nakhon Thai',52),(677,'ชาติตระการ','Chat Trakan',52),(678,'บางระกำ','Bang Rakam',52),(679,'บางกระทุ่ม','Bang Krathum',52),(680,'พรหมพิราม','Phrom Phiram',52),(681,'วัดโบสถ์','Wat Bot',52),(682,'วังทอง','Wang Thong',52),(683,'เนินมะปราง','Noen Maprang',52),(684,'เมืองพิจิตร','Mueang Phichit',53),(685,'วังทรายพูน','Wang Sai Phun',53),(686,'โพธิ์ประทับช้าง','Pho Prathap Chang',53),(687,'ตะพานหิน','Taphan Hin',53),(688,'บางมูลนาก','Bang Mun Nak',53),(689,'โพทะเล','Pho Thale',53),(690,'สามง่าม','Sam Ngam',53),(691,'ทับคล้อ','Tap Khlo',53),(692,'สากเหล็ก','Sak Lek',53),(693,'บึงนาราง','Bueng Na Rang',53),(694,'ดงเจริญ','Dong Charoen',53),(695,'วชิรบารมี','Wachirabarami',53),(696,'เมืองเพชรบูรณ์','Mueang Phetchabun',54),(697,'ชนแดน','Chon Daen',54),(698,'หล่มสัก','Lom Sak',54),(699,'หล่มเก่า','Lom Kao',54),(700,'วิเชียรบุรี','Wichian Buri',54),(701,'ศรีเทพ','Si Thep',54),(702,'หนองไผ่','Nong Phai',54),(703,'บึงสามพัน','Bueng Sam Phan',54),(704,'น้ำหนาว','Nam Nao',54),(705,'วังโป่ง','Wang Pong',54),(706,'เขาค้อ','Khao Kho',54),(707,'เมืองราชบุรี','Mueang Ratchaburi',55),(708,'จอมบึง','Chom Bueng',55),(709,'สวนผึ้ง','Suan Phueng',55),(710,'ดำเนินสะดวก','Damnoen Saduak',55),(711,'บ้านโป่ง','Ban Pong',55),(712,'บางแพ','Bang Phae',55),(713,'โพธาราม','Photharam',55),(714,'ปากท่อ','Pak Tho',55),(715,'วัดเพลง','Wat Phleng',55),(716,'บ้านคา','Ban Kha',55),(717,'เมืองกาญจนบุรี','Mueang Kanchanaburi',56),(718,'ไทรโยค','Sai Yok',56),(719,'บ่อพลอย','Bo Phloi',56),(720,'ศรีสวัสดิ์','Si Sawat',56),(721,'ท่ามะกา','Tha Maka',56),(722,'ท่าม่วง','Tha Muang',56),(723,'ทองผาภูมิ','Pha Phum',56),(724,'สังขละบุรี','Sangkhla Buri',56),(725,'พนมทวน','Phanom Thuan',56),(726,'เลาขวัญ','Lao Khwan',56),(727,'ด่านมะขามเตี้ย','Dan Makham Tia',56),(728,'หนองปรือ','Nong Prue',56),(729,'ห้วยกระเจา','Huai Krachao',56),(730,'เมืองสุพรรณบุรี','Mueang Suphan Buri',57),(731,'เดิมบางนางบวช','Doem Bang Nang Buat',57),(732,'ด่านช้าง','Dan Chang',57),(733,'บางปลาม้า','Bang Pla Ma',57),(734,'ศรีประจันต์','Si Prachan',57),(735,'ดอนเจดีย์','Don Chedi',57),(736,'สองพี่น้อง','Song Phi Nong',57),(737,'สามชุก','Sam Chuk',57),(738,'อู่ทอง','U Thong',57),(739,'หนองหญ้าไซ','Nong Ya Sai',57),(740,'เมืองนครปฐม','Mueang Nakhon Pathom',58),(741,'กำแพงแสน','Kamphaeng Saen',58),(742,'นครชัยศรี','Nakhon Chai Si',58),(743,'ดอนตูม','Don Tum',58),(744,'บางเลน','Bang Len',58),(745,'สามพราน','Sam Phran',58),(746,'พุทธมณฑล','Phutthamonthon',58),(747,'เมืองสมุทรสาคร','Mueang Samut Sakhon',59),(748,'กระทุ่มแบน','Krathum Baen',59),(749,'บ้านแพ้ว','Ban Phaeo',59),(750,'เมืองสมุทรสงคราม','Mueang Samut Songkhram',60),(751,'บางคนที','Bang Khonthi',60),(752,'อัมพวา','Amphawa',60),(753,'เมืองเพชรบุรี','Mueang Phetchaburi',61),(754,'เขาย้อย','Khao Yoi',61),(755,'หนองหญ้าปล้อง','Nong Ya Plong',61),(756,'ชะอำ','Cha-am',61),(757,'ท่ายาง','Tha Yang',61),(758,'บ้านลาด','Ban Lat',61),(759,'บ้านแหลม','Ban Laem',61),(760,'แก่งกระจาน','Kaeng Krachan',61),(761,'เมืองประจวบคีรีขันธ์','Mueang Prachuap Khiri Khan',62),(762,'กุยบุรี','Kui Buri',62),(763,'ทับสะแก','Thap Sakae',62),(764,'บางสะพาน','Bang Saphan',62),(765,'บางสะพานน้อย','Bang Saphan Noi',62),(766,'ปราณบุรี','Pran Buri',62),(767,'หัวหิน','Hua Hin',62),(768,'สามร้อยยอด','Sam Roi Yot',62),(769,'เมืองนครศรีธรรมราช','Mueang Nakhon Si Thammarat',63),(770,'พรหมคีรี','Phrom Khiri',63),(771,'ลานสกา','Lan Saka',63),(772,'ฉวาง','Chawang',63),(773,'พิปูน','Phipun',63),(774,'เชียรใหญ่','Chian Yai',63),(775,'ชะอวด','Cha-uat',63),(776,'ท่าศาลา','Tha Sala',63),(777,'ทุ่งสง','Thung Song',63),(778,'นาบอน','Na Bon',63),(779,'ทุ่งใหญ่','Thung Yai',63),(780,'ปากพนัง','Pak Phanang',63),(781,'ร่อนพิบูลย์','Ron Phibun',63),(782,'สิชล','Sichon',63),(783,'ขนอม','Khanom',63),(784,'หัวไทร','Hua Sai',63),(785,'บางขัน','Bang Khan',63),(786,'ถ้ำพรรณรา','Tham Phannara',63),(787,'จุฬาภรณ์','Chulabhorn',63),(788,'พระพรหม','Phra Phrom',63),(789,'นบพิตำ','Nopphitam',63),(790,'ช้างกลาง','Chang Klang',63),(791,'เฉลิมพระเกียรติ','Chaloem Phra Kiat',63),(792,'เมืองกระบี่','Mueang Krabi',64),(793,'เขาพนม','Khao Phanom',64),(794,'เกาะลันตา','Ko Lanta',64),(795,'คลองท่อม','Khlong Thom',64),(796,'อ่าวลึก','Ao Luek',64),(797,'ปลายพระยา','Plai Phraya',64),(798,'ลำทับ','Lam Thap',64),(799,'เหนือคลอง','Nuea Khlong',64),(800,'เมืองพังงา','Mueang Phang-nga',65),(801,'เกาะยาว','Ko Yao',65),(802,'กะปง','Kapong',65),(803,'ตะกั่วทุ่ง','Takua Thung',65),(804,'ตะกั่วป่า','Takua Pa',65),(805,'คุระบุรี','Khura Buri',65),(806,'ทับปุด','Thap Put',65),(807,'ท้ายเหมือง','Thai Mueang',65),(808,'เมืองภูเก็ต','Mueang Phuket',66),(809,'กะทู้','Kathu',66),(810,'ถลาง','Thalang',66),(811,'เมืองสุราษฎร์ธานี','Mueang Surat Thani',67),(812,'กาญจนดิษฐ์','Kanchanadit',67),(813,'ดอนสัก','Don Sak',67),(814,'เกาะสมุย','Ko Samui',67),(815,'เกาะพะงัน','Ko Pha-ngan',67),(816,'ไชยา','Chaiya',67),(817,'ท่าชนะ','Tha Chana',67),(818,'คีรีรัฐนิคม','Khiri Rat Nikhom',67),(819,'บ้านตาขุน','Ban Ta Khun',67),(820,'พนม','Phanom',67),(821,'ท่าฉาง','Tha Chang',67),(822,'บ้านนาสาร','Ban Na San',67),(823,'บ้านนาเดิม','Ban Na Doem',67),(824,'เคียนซา','Khian Sa',67),(825,'เวียงสระ','Wiang Sa',67),(826,'พระแสง','Phrasaeng',67),(827,'พุนพิน','Phunphin',67),(828,'ชัยบุรี','Chai Buri',67),(829,'วิภาวดี','Vibhavadi',67),(830,'เมืองระนอง','Mueang Ranong',68),(831,'ละอุ่น','La-un',68),(832,'กะเปอร์','Kapoe',68),(833,'กระบุรี','Kra Buri',68),(834,'สุขสำราญ','Suk Samran',68),(835,'เมืองชุมพร','Mueang Chumphon',69),(836,'ท่าแซะ','Tha Sae',69),(837,'ปะทิว','Pathio',69),(838,'หลังสวน','Lang Suan',69),(839,'ละแม','Lamae',69),(840,'พะโต๊ะ','Phato',69),(841,'สวี','Sawi',69),(842,'ทุ่งตะโก','Thung Tako',69),(843,'เมืองสงขลา','Mueang Songkhla',70),(844,'สทิงพระ','Sathing Phra',70),(845,'จะนะ','Chana',70),(846,'นาทวี','Na Thawi',70),(847,'เทพา','Thepha',70),(848,'สะบ้าย้อย','Saba Yoi',70),(849,'ระโนด','Ranot',70),(850,'กระแสสินธุ์','Krasae Sin',70),(851,'รัตภูมิ','Rattaphum',70),(852,'สะเดา','Sadao',70),(853,'หาดใหญ่','Hat Yai',70),(854,'นาหม่อม','Na Mom',70),(855,'ควนเนียง','Khuan Niang',70),(856,'บางกล่ำ','Bang Klam',70),(857,'สิงหนคร','Singhanakhon',70),(858,'คลองหอยโข่ง','Khlong Hoi Khong',70),(859,'เมืองสตูล','Mueang Satun',71),(860,'ควนโดน','Khuan Don',71),(861,'ควนกาหลง','Khuan Kalong',71),(862,'ท่าแพ','Tha Phae',71),(863,'ละงู','La-ngu',71),(864,'ทุ่งหว้า','Thung Wa',71),(865,'มะนัง','Manang',71),(866,'เมืองตรัง','Mueang Trang',72),(867,'กันตัง','Kantang',72),(868,'ย่านตาขาว','Yan Ta Khao',72),(869,'ปะเหลียน','Palian',72),(870,'สิเกา','Sikao',72),(871,'ห้วยยอด','Huai Yot',72),(872,'วังวิเศษ','Wang Wiset',72),(873,'นาโยง','Na Yong',72),(874,'รัษฎา','Ratsada',72),(875,'หาดสำราญ','Hat Samran',72),(876,'เมืองพัทลุง','Mueang Phatthalung',73),(877,'กงหรา','Kong Ra',73),(878,'เขาชัยสน','Khao Chaison',73),(879,'ตะโหมด','Tamot',73),(880,'ควนขนุน','Khuan Khanun',73),(881,'ปากพะยูน','Pak Phayun',73),(882,'ศรีบรรพต','Si Banphot',73),(883,'ป่าบอน','Pa Bon',73),(884,'บางแก้ว','Bang Kaeo',73),(885,'ป่าพะยอม','Pa Phayom',73),(886,'ศรีนครินทร์','Srinagarindra',73),(887,'เมืองปัตตานี','Mueang Pattani',74),(888,'โคกโพธิ์','Khok Pho',74),(889,'หนองจิก','Nong Chik',74),(890,'ปะนาเระ','Panare',74),(891,'มายอ','Mayo',74),(892,'ทุ่งยางแดง','Thung Yang Daeng',74),(893,'สายบุรี','Sai Buri',74),(894,'ไม้แก่น','Mai Kaen',74),(895,'ยะหริ่ง','Yaring',74),(896,'ยะรัง','Yarang',74),(897,'กะพ้อ','Kapho',74),(898,'แม่ลาน','Mae Lan',74),(899,'เมืองยะลา','Mueang Yala',75),(900,'เบตง','Betong',75),(901,'บันนังสตา','Bannang Sata',75),(902,'ธารโต','Than To',75),(903,'ยะหา','Yaha',75),(904,'รามัน','Raman',75),(905,'กาบัง','Kabang',75),(906,'กรงปินัง','Krong Pinang',75),(907,'เมืองนราธิวาส','Mueang Narathiwat',76),(908,'ตากใบ','Tak Bai',76),(909,'บาเจาะ','Bacho',76),(910,'ยี่งอ','Yi-ngo',76),(911,'ระแงะ','Ra-ngae',76),(912,'รือเสาะ','Rueso',76),(913,'ศรีสาคร','Si Sakhon',76),(914,'แว้ง','Waeng',76),(915,'สุคิริน','Sukhirin',76),(916,'สุไหงโก-ลก','Su-ngai Kolok',76),(917,'สุไหงปาดี','Su-ngai Padi',76),(918,'จะแนะ','Chanae',76),(919,'เจาะไอร้อง','Cho-airong',76),(920,'เมืองบึงกาฬ','Mueang Bueng Kan',77),(921,'เซกา','Seka',77),(922,'โซ่พิสัย','So Phisai',77),(923,'พรเจริญ','Phon Charoen',77),(924,'ศรีวิไล','Si Wilai',77),(925,'บึงโขงหลง','Bueng Khong Long',77),(926,'ปากคาด','Pak Khat',77),(927,'บุ่งคล้า','Bung Khla',77);
/*!40000 ALTER TABLE `zim_mdm_data_districts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_mdm_data_logs`
--

DROP TABLE IF EXISTS `zim_mdm_data_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_logs` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `log_menu` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `log_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `log_activity` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `log_user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_logs`
--

LOCK TABLES `zim_mdm_data_logs` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_logs` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_logs` VALUES (1,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 15:46:03','admin_ziimme','2023-04-06 15:46:03',NULL,'admin_ziimme'),(2,'เพิ่มผู้เข้าใช้งานระบบ','ผู้ใช้: test','เพิ่มผู้เข้าใช้งานระบบ','test',NULL,'2023-04-06 15:53:59','test','2023-04-06 15:53:59',NULL,'test'),(3,'ลบผู้เข้าใช้งานระบบ','ผู้ใช้: test','ลบผู้เข้าใช้งานระบบ','test','I','2023-04-06 15:55:51','test','2023-04-06 15:55:51',NULL,'test'),(4,'เพิ่มผู้เข้าใช้งานระบบ','ผู้ใช้: test','เพิ่มผู้เข้าใช้งานระบบ','test',NULL,'2023-04-06 15:56:09','test','2023-04-06 15:56:09',NULL,'test'),(5,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:02:09','admin_ziimme','2023-04-06 16:02:09',NULL,'admin_ziimme'),(6,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:11:00','admin_ziimme','2023-04-06 16:11:00',NULL,'admin_ziimme'),(7,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:46:52','admin_ziimme','2023-04-06 16:46:52',NULL,'admin_ziimme'),(8,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:50:47','admin_ziimme','2023-04-06 16:50:47',NULL,'admin_ziimme'),(9,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:52:05','admin_ziimme','2023-04-06 16:52:05',NULL,'admin_ziimme'),(10,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:54:53','admin_ziimme','2023-04-06 16:54:53',NULL,'admin_ziimme'),(11,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:58:20','admin_ziimme','2023-04-06 16:58:20',NULL,'admin_ziimme'),(12,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 16:59:36','admin_ziimme','2023-04-06 16:59:36',NULL,'admin_ziimme'),(13,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:01:45','admin_ziimme','2023-04-06 17:01:45',NULL,'admin_ziimme'),(14,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:02:46','admin_ziimme','2023-04-06 17:02:46',NULL,'admin_ziimme'),(15,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:02:56','admin_ziimme','2023-04-06 17:02:56',NULL,'admin_ziimme'),(16,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:03:16','admin_ziimme','2023-04-06 17:03:16',NULL,'admin_ziimme'),(17,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:03:33','admin_ziimme','2023-04-06 17:03:33',NULL,'admin_ziimme'),(18,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:06:55','admin_ziimme','2023-04-06 17:06:55',NULL,'admin_ziimme'),(19,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:07:17','admin_ziimme','2023-04-06 17:07:17',NULL,'admin_ziimme'),(20,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:10:08','admin_ziimme','2023-04-06 17:10:08',NULL,'admin_ziimme'),(21,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:11:10','admin_ziimme','2023-04-06 17:11:10',NULL,'admin_ziimme'),(22,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:11:21','admin_ziimme','2023-04-06 17:11:21',NULL,'admin_ziimme'),(23,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:11:54','admin_ziimme','2023-04-06 17:11:54',NULL,'admin_ziimme'),(24,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:12:30','admin_ziimme','2023-04-06 17:12:30',NULL,'admin_ziimme'),(25,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-06 17:13:36','admin_ziimme','2023-04-06 17:13:36',NULL,'admin_ziimme'),(26,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-11 08:13:01','admin_ziimme','2023-04-11 08:13:01',NULL,'admin_ziimme'),(27,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-11 08:14:54','admin_ziimme','2023-04-11 08:14:54',NULL,'admin_ziimme'),(28,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-11 08:14:58','admin_ziimme','2023-04-11 08:14:58',NULL,'admin_ziimme'),(29,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-11 08:19:37','admin_ziimme','2023-04-11 08:19:37',NULL,'admin_ziimme'),(30,'เข้าใช้งานระบบ','ผู้ใช้: admin_test','เข้าใช้งานระบบ','admin','A','2023-04-11 08:21:01','admin','2023-04-11 08:21:01',NULL,'admin'),(31,'เข้าใช้งานระบบ','ผู้ใช้: admin_test','เข้าใช้งานระบบ','admin','A','2023-04-11 08:21:59','admin','2023-04-11 08:21:59',NULL,'admin'),(32,'เข้าใช้งานระบบ','ผู้ใช้: admin_test','เข้าใช้งานระบบ','admin','A','2023-04-19 07:52:30','admin','2023-04-19 07:52:30',NULL,'admin'),(33,'เข้าใช้งานระบบ','ผู้ใช้: admin_test','เข้าใช้งานระบบ','admin','A','2023-04-23 13:17:43','admin','2023-04-23 13:17:43',NULL,'admin'),(34,'เข้าใช้งานระบบ','ผู้ใช้: admin_test','เข้าใช้งานระบบ','admin','A','2023-04-23 13:18:10','admin','2023-04-23 13:18:10',NULL,'admin'),(35,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-23 16:00:03','admin_ziimme','2023-04-23 16:00:03',NULL,'admin_ziimme'),(36,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-23 17:11:04','admin_ziimme','2023-04-23 17:11:04',NULL,'admin_ziimme'),(37,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-26 08:32:33','admin_ziimme','2023-04-26 08:32:33',NULL,'admin_ziimme'),(38,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-27 19:45:49','admin_ziimme','2023-04-27 19:45:49',NULL,'admin_ziimme'),(39,'เข้าใช้งานระบบ','ผู้ใช้: ณฐพงศ์ ทองคำรอด','เข้าใช้งานระบบ','ziimme_admin','A','2023-04-27 22:15:26','ziimme_admin','2023-04-27 22:15:26',NULL,'ziimme_admin'),(40,'เข้าใช้งานระบบ','ผู้ใช้: Admin_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-27 23:09:50','admin_ziimme','2023-04-27 23:09:50',NULL,'admin_ziimme'),(41,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-29 07:15:35','admin_ziimme','2023-04-29 07:15:35',NULL,'admin_ziimme'),(42,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-04-30 21:14:11','admin_ziimme','2023-04-30 21:14:11',NULL,'admin_ziimme'),(43,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-12 19:08:46','admin_ziimme','2023-05-12 19:08:46',NULL,'admin_ziimme'),(44,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-12 22:26:51','admin_ziimme','2023-05-12 22:26:51',NULL,'admin_ziimme'),(45,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-12 22:29:33','admin_ziimme','2023-05-12 22:29:33',NULL,'admin_ziimme'),(46,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-14 18:55:00','admin_ziimme','2023-05-14 18:55:00',NULL,'admin_ziimme'),(47,'เข้าใช้งานระบบ','ผู้ใช้: Zolnny','เข้าใช้งานระบบ','zolnny','A','2023-05-14 22:57:32','zolnny','2023-05-14 22:57:32',NULL,'zolnny'),(48,'เข้าใช้งานระบบ','ผู้ใช้: Zolnny','เข้าใช้งานระบบ','zolnny','A','2023-05-14 23:44:28','zolnny','2023-05-14 23:44:28',NULL,'zolnny'),(49,'เข้าใช้งานระบบ','ผู้ใช้: Zolnny','เข้าใช้งานระบบ','zolnny','A','2023-05-15 07:21:07','zolnny','2023-05-15 07:21:07',NULL,'zolnny'),(50,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-15 20:47:13','admin_ziimme','2023-05-15 20:47:13',NULL,'admin_ziimme'),(51,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-15 21:09:44','admin_ziimme','2023-05-15 21:09:44',NULL,'admin_ziimme'),(52,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-16 19:35:54','admin_ziimme','2023-05-16 19:35:54',NULL,'admin_ziimme'),(53,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-17 09:17:45','admin_ziimme','2023-05-17 09:17:45',NULL,'admin_ziimme'),(54,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-18 07:23:56','admin_ziimme','2023-05-18 07:23:56',NULL,'admin_ziimme'),(55,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-18 19:31:49','admin_ziimme','2023-05-18 19:31:49',NULL,'admin_ziimme'),(56,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-19 22:38:58','admin_ziimme','2023-05-19 22:38:58',NULL,'admin_ziimme'),(57,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-20 23:00:27','admin_ziimme','2023-05-20 23:00:27',NULL,'admin_ziimme'),(58,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-21 00:21:31','admin_ziimme','2023-05-21 00:21:31',NULL,'admin_ziimme'),(59,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-21 22:23:21','admin_ziimme','2023-05-21 22:23:21',NULL,'admin_ziimme'),(60,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-23 08:02:25','admin_ziimme','2023-05-23 08:02:25',NULL,'admin_ziimme'),(61,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-23 20:58:37','admin_ziimme','2023-05-23 20:58:37',NULL,'admin_ziimme'),(62,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-24 21:53:59','admin_ziimme','2023-05-24 21:53:59',NULL,'admin_ziimme'),(63,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-24 23:45:25','admin_ziimme','2023-05-24 23:45:25',NULL,'admin_ziimme'),(64,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-25 23:06:36','admin_ziimme','2023-05-25 23:06:36',NULL,'admin_ziimme'),(65,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-26 22:58:11','admin_ziimme','2023-05-26 22:58:11',NULL,'admin_ziimme'),(66,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-29 20:40:58','admin_ziimme','2023-05-29 20:40:58',NULL,'admin_ziimme'),(67,'เข้าใช้งานระบบ','ผู้ใช้: ADMIN_ZIIMME','เข้าใช้งานระบบ','admin_ziimme','A','2023-05-30 16:17:49','admin_ziimme','2023-05-30 16:17:49',NULL,'admin_ziimme');
/*!40000 ALTER TABLE `zim_mdm_data_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_mdm_data_position`
--

DROP TABLE IF EXISTS `zim_mdm_data_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_position` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `position_name_th` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `position_name_eng` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_position`
--

LOCK TABLES `zim_mdm_data_position` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_position` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_position` VALUES (1,'เซลล์','Consultant','A','2023-05-21 22:24:22','admin_ziimme','2023-05-21 22:34:00','admin_ziimme'),(2,'แอดมิน','Admin','A','2023-05-21 22:24:48','admin_ziimme','2023-05-21 22:25:54','admin_ziimme'),(3,'พนักงานนวด','Therapist','A','2023-05-21 22:25:11','admin_ziimme',NULL,NULL),(4,'แม่บ้าน','Maid','A','2023-05-21 22:25:40','admin_ziimme','2023-05-21 22:26:06','admin_ziimme'),(5,'กราฟิก','Graphics','A','2023-05-22 00:27:45','admin_ziimme',NULL,NULL),(6,'ผู้จัดการ','Area Manager','A','2023-05-22 00:28:32','admin_ziimme',NULL,NULL);
/*!40000 ALTER TABLE `zim_mdm_data_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_mdm_data_province`
--

DROP TABLE IF EXISTS `zim_mdm_data_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_province` (
  `province_id` int NOT NULL AUTO_INCREMENT,
  `province_name_th` varchar(150) DEFAULT NULL,
  `province_name_eng` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_province`
--

LOCK TABLES `zim_mdm_data_province` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_province` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_province` VALUES (1,'กรุงเทพมหานคร','Bangkok'),(2,'สมุทรปราการ','Samut Prakan'),(3,'นนทบุรี','Nonthaburi'),(4,'ปทุมธานี','Pathum Thani'),(5,'พระนครศรีอยุธยา','Phra Nakhon Si Ayutthaya'),(6,'อ่างทอง','Ang Thong'),(7,'ลพบุรี','Loburi'),(8,'สิงห์บุรี','Sing Buri'),(9,'ชัยนาท','Chai Nat'),(10,'สระบุรี','Saraburi'),(11,'ชลบุรี','Chon Buri'),(12,'ระยอง','Rayong'),(13,'จันทบุรี','Chanthaburi'),(14,'ตราด','Trat'),(15,'ฉะเชิงเทรา','Chachoengsao'),(16,'ปราจีนบุรี','Prachin Buri'),(17,'นครนายก','Nakhon Nayok'),(18,'สระแก้ว','Sa Kaeo'),(19,'นครราชสีมา','Nakhon Ratchasima'),(20,'บุรีรัมย์','Buri Ram'),(21,'สุรินทร์','Surin'),(22,'ศรีสะเกษ','Si Sa Ket'),(23,'อุบลราชธานี','Ubon Ratchathani'),(24,'ยโสธร','Yasothon'),(25,'ชัยภูมิ','Chaiyaphum'),(26,'อำนาจเจริญ','Amnat Charoen'),(27,'หนองบัวลำภู','Nong Bua Lam Phu'),(28,'ขอนแก่น','Khon Kaen'),(29,'อุดรธานี','Udon Thani'),(30,'เลย','Loei'),(31,'หนองคาย','Nong Khai'),(32,'มหาสารคาม','Maha Sarakham'),(33,'ร้อยเอ็ด','Roi Et'),(34,'กาฬสินธุ์','Kalasin'),(35,'สกลนคร','Sakon Nakhon'),(36,'นครพนม','Nakhon Phanom'),(37,'มุกดาหาร','Mukdahan'),(38,'เชียงใหม่','Chiang Mai'),(39,'ลำพูน','Lamphun'),(40,'ลำปาง','Lampang'),(41,'อุตรดิตถ์','Uttaradit'),(42,'แพร่','Phrae'),(43,'น่าน','Nan'),(44,'พะเยา','Phayao'),(45,'เชียงราย','Chiang Rai'),(46,'แม่ฮ่องสอน','Mae Hong Son'),(47,'นครสวรรค์','Nakhon Sawan'),(48,'อุทัยธานี','Uthai Thani'),(49,'กำแพงเพชร','Kamphaeng Phet'),(50,'ตาก','Tak'),(51,'สุโขทัย','Sukhothai'),(52,'พิษณุโลก','Phitsanulok'),(53,'พิจิตร','Phichit'),(54,'เพชรบูรณ์','Phetchabun'),(55,'ราชบุรี','Ratchaburi'),(56,'กาญจนบุรี','Kanchanaburi'),(57,'สุพรรณบุรี','Suphan Buri'),(58,'นครปฐม','Nakhon Pathom'),(59,'สมุทรสาคร','Samut Sakhon'),(60,'สมุทรสงคราม','Samut Songkhram'),(61,'เพชรบุรี','Phetchaburi'),(62,'ประจวบคีรีขันธ์','Prachuap Khiri Khan'),(63,'นครศรีธรรมราช','Nakhon Si Thammarat'),(64,'กระบี่','Krabi'),(65,'พังงา','Phangnga'),(66,'ภูเก็ต','Phuket'),(67,'สุราษฎร์ธานี','Surat Thani'),(68,'ระนอง','Ranong'),(69,'ชุมพร','Chumphon'),(70,'สงขลา','Songkhla'),(71,'สตูล','Satun'),(72,'ตรัง','Trang'),(73,'พัทลุง','Phatthalung'),(74,'ปัตตานี','Pattani'),(75,'ยะลา','Yala'),(76,'นราธิวาส','Narathiwat'),(77,'บึงกาฬ','buogkan');
/*!40000 ALTER TABLE `zim_mdm_data_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_mdm_data_sub_districts`
--

DROP TABLE IF EXISTS `zim_mdm_data_sub_districts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_sub_districts` (
  `sub_districts_id` int NOT NULL AUTO_INCREMENT,
  `zip_code` varchar(150) DEFAULT NULL,
  `sub_districts_name_th` varchar(150) DEFAULT NULL,
  `sub_districts_name_eng` varchar(150) DEFAULT NULL,
  `districts_code` int NOT NULL,
  PRIMARY KEY (`sub_districts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_sub_districts`
--

LOCK TABLES `zim_mdm_data_sub_districts` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_sub_districts` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_sub_districts` VALUES (1,'10200','พระบรมมหาราชวัง','Phra Borom Maha Ratchawang',1),(2,'10200','วังบูรพาภิรมย์','Wang Burapha Phirom',1),(3,'10200','วัดราชบพิธ','Wat Ratchabophit',1),(4,'10200','สำราญราษฎร์','Samran Rat',1),(5,'10200','ศาลเจ้าพ่อเสือ','San Chao Pho Suea',1),(6,'10200','เสาชิงช้า','Sao Chingcha',1),(7,'10200','บวรนิเวศ','Bowon Niwet',1),(8,'10200','ตลาดยอด','Talat Yot',1),(9,'10200','ชนะสงคราม','Chana Songkhram',1),(10,'10200','บ้านพานถม','Ban Phan Thom',1),(11,'10200','บางขุนพรหม','Bang Khun Phrom',1),(12,'10200','วัดสามพระยา','Wat Sam Phraya',1),(13,'10300','ดุสิต','Dusit',2),(14,'10300','วชิรพยาบาล','Wachiraphayaban',2),(15,'10300','สวนจิตรลดา','Suan Chit Lada',2),(16,'10300','สี่แยกมหานาค','Si Yaek Maha Nak',2),(17,'10300','ถนนนครไชยศรี','Thanon Nakhon Chai Si',2),(18,'10530','กระทุ่มราย','Krathum Rai',3),(19,'10530','หนองจอก','Nong Chok',3),(20,'10530','คลองสิบ','Khlong Sip',3),(21,'10530','คลองสิบสอง','Khlong Sip Song',3),(22,'10530','โคกแฝด','Khok Faet',3),(23,'10530','คู้ฝั่งเหนือ','Khu Fang Nuea',3),(24,'10530','ลำผักชี','Lam Phak Chi',3),(25,'10530','ลำต้อยติ่ง','Lam Toiting',3),(26,'10500','มหาพฤฒาราม','Maha Phruettharam',4),(27,'10500','สีลม','Si Lom',4),(28,'10500','สุริยวงศ์','Suriyawong',4),(29,'10500','บางรัก','Bang Rak',4),(30,'10500','สี่พระยา','Si Phraya',4),(31,'10220','อนุสาวรีย์','Anusawari',5),(32,'10220','ท่าแร้ง','Tha Raeng',5),(33,'10220','คลองถนน','Khlong Thanon',5),(34,'10330','รองเมือง','Rong Mueang',6),(35,'10330','วังใหม่','Wang Mai',6),(36,'10330','ปทุมวัน','Pathum Wan',6),(37,'10330','ลุมพินี','Lumphini',6),(38,'10100','ป้อมปราบ','Pom Prap',8),(39,'10100','วัดเทพศิรินทร์','Wat Thep Sirin',8),(40,'10100','คลองมหานาค','Khlong Maha Nak',8),(41,'10100','บ้านบาตร','Ban Bat',8),(42,'10100','วัดโสมนัส','Wat Sommanat',8),(43,'10260','บางจาก','Bang Chak',9),(44,'10510','มีนบุรี','Min Buri',10),(45,'10510','แสนแสบ','Saen Saep',10),(46,'10520','ลาดกระบัง','Lat Krabang',11),(47,'10520','คลองสองต้นนุ่น','Khlong Song Ton Nun',11),(48,'10520','คลองสามประเวศ','Khlong Sam Prawet',11),(49,'10520','ลำปลาทิว','Lam Pla Thio',11),(50,'10520','ทับยาว','Thap Yao',11),(51,'10520','ขุมทอง','Khum Thong',11),(52,'10120','ช่องนนทรี','Chong Nonsi',12),(53,'10120','บางโพงพาง','Bang Phongphang',12),(54,'10100','จักรวรรดิ','Chakkrawat',13),(55,'10100','สัมพันธวงศ์','Samphanthawong',13),(56,'10100','ตลาดน้อย','Talat Noi',13),(57,'10400','สามเสนใน','Samsen Nai',14),(58,'10600','วัดกัลยาณ์','Wat Kanlaya',15),(59,'10600','หิรัญรูจี','Hiran Ruchi',15),(60,'10600','บางยี่เรือ','Bang Yi Ruea',15),(61,'10600','บุคคโล','Bukkhalo',15),(62,'10600','ตลาดพลู','Talat Phlu',15),(63,'10600','ดาวคะนอง','Dao Khanong',15),(64,'10600','สำเหร่','Samre',15),(65,'10600','วัดอรุณ','Wat Arun',16),(66,'10600','วัดท่าพระ','Wat Tha Phra',16),(67,'10310','ห้วยขวาง','Huai Khwang',17),(68,'10310','บางกะปิ','Bang Kapi',17),(69,'10310','สามเสนนอก','Samsen Nok',17),(70,'10600','สมเด็จเจ้าพระยา','Somdet Chao Phraya',18),(71,'10600','คลองสาน','Khlong San',18),(72,'10600','บางลำภูล่าง','Bang Lamphu Lang',18),(73,'10600','คลองต้นไทร','Khlong Ton Sai',18),(74,'10170','คลองชักพระ','Khlong Chak Phra',19),(75,'10170','ตลิ่งชัน','Taling Chan',19),(76,'10170','ฉิมพลี','Chimphli',19),(77,'10170','บางพรม','Bang Phrom',19),(78,'10170','บางระมาด','Bang Ramat',19),(79,'10170','บางเชือกหนัง','Bang Chueak Nang',19),(80,'10700','ศิริราช','Siri Rat',20),(81,'10700','บ้านช่างหล่อ','Ban Chang Lo',20),(82,'10700','บางขุนนนท์','Bang Khun Non',20),(83,'10700','บางขุนศรี','Bang Khun Si',20),(84,'10700','อรุณอมรินทร์','Arun Ammarin',20),(85,'10150','ท่าข้าม','Tha Kham',21),(86,'10150','แสมดำ','Samae Dam',21),(87,'10160','บางหว้า','Bang Wa',22),(88,'10160','บางด้วน','Bang Duan',22),(89,'10160','บางจาก','Bang Chak',22),(90,'10160','บางแวก','Bang Waek',22),(91,'10160','คลองขวาง','Khlong Khwang',22),(92,'10160','ปากคลองภาษีเจริญ','Pak Khlong Phasi Charoen',22),(93,'10160','คูหาสวรรค์','Khuha Sawan',22),(94,'10160','หนองแขม','Nong Khaem',23),(95,'10160','หนองค้างพลู','Nong Khang Phlu',23),(96,'10140','ราษฎร์บูรณะ','Rat Burana',24),(97,'10140','บางปะกอก','Bang Pakok',24),(98,'10700','บางพลัด','Bang Phlat',25),(99,'10700','บางอ้อ','Bang O',25),(100,'10700','บางบำหรุ','Bang Bamru',25),(101,'10700','บางยี่ขัน','Bang Yi Khan',25),(102,'10400','ดินแดง','Din Daeng',26),(103,'10240','คลองกุ่ม','Klong Khum',27),(104,'10240','นวมินทร์','Nawamin',27),(105,'10240','นวลจันทร์','Nuanchan',27),(106,'10120','ทุ่งวัดดอน','Thung Wat Don',28),(107,'10120','ยานนาวา','Yan Nawa',28),(108,'10120','ทุ่งมหาเมฆ','Thung Maha Mek',28),(109,'10800','บางซื่อ','Bang Sue',29),(110,'10800','วงศ์สว่าง','Wong Sawang',29),(111,'10900','ลาดยาว','Lat Yao',30),(112,'10900','เสนานิคม','Sena Nikhom',30),(113,'10900','จันทรเกษม','Chan Kasem',30),(114,'10900','จอมพล','Chom Phon',30),(115,'10900','จตุจักร','Chatuchak',30),(116,'10120','บางคอแหลม','Bang Kho Laem',31),(117,'10120','วัดพระยาไกร','Wat Phraya Krai',31),(118,'10120','บางโคล่','Bang Khlo',31),(119,'10250','ประเวศ','Prawet',32),(120,'10250','หนองบอน','Nong Bon',32),(121,'10250','ดอกไม้','Dokmai',32),(122,'10110','คลองเตย','Khlong Toei',33),(123,'10110','คลองตัน','Khlong Tan',33),(124,'10110','พระโขนง','Phra Khanong',33),(125,'10250','สวนหลวง','Suan Luang',34),(126,'10150','บางขุนเทียน','Bang Khun Thian',35),(127,'10150','บางค้อ','Bang Kho',35),(128,'10150','บางมด','Bang Mot',35),(129,'10150','จอมทอง','Chom Thong',35),(130,'10210','สีกัน','Si Kan',36),(131,'10210','ดอนเมือง','Don Mueang',36),(132,'10210','สนามบิน','Airport',36),(133,'10400','ทุ่งพญาไท','Thung Phaya Thai',37),(134,'10400','ถนนพญาไท','Thanon Phaya Thai',37),(135,'10400','ถนนเพชรบุรี','Thanon Phetchaburi',37),(136,'10400','มักกะสัน','Makkasan',37),(137,'10230','ลาดพร้าว','Lat Phrao',38),(138,'10230','จรเข้บัว','Chorakhe Bua',38),(139,'10110','คลองเตยเหนือ','Khlong Toei Nuea',39),(140,'10110','คลองตันเหนือ','Khlong Tan Nuea',39),(141,'10110','พระโขนงเหนือ','Phra Khanong Nuea',39),(142,'10160','บางแค','Bang Khae',40),(143,'10160','บางแคเหนือ','Bang Khae Nuea',40),(144,'10160','บางไผ่','Bang Phai',40),(145,'10160','หลักสอง','Lak Song',40),(146,'10210','ทุ่งสองห้อง','Thung Song Hong',41),(147,'10210','ตลาดบางเขน','Talat Bang Khen',41),(148,'10220','สายไหม','Sai Mai',42),(149,'10220','ออเงิน','O Ngoen',42),(150,'10220','คลองถนน','Khlong Thanon',42),(151,'10230','คันนายาว','Khan Na Yao',43),(152,'10230','รามอินทรา','Ramintra',43),(153,'10240','สะพานสูง','Sapan Sung',44),(154,'10310','วังทองหลาง','Wang Thonglang',45),(155,'10310','สะพานสอง','Saphan Song',45),(156,'10310','คลองเจ้าคุณสิงห์','Khlong Chao Khun Sing',45),(157,'10310','พลับพลา','Phnapphna',45),(158,'10510','สามวาตะวันตก','Sam Wa Tawantok',46),(159,'10510','สามวาตะวันออก','Sam Wa Tawan-ok',46),(160,'10510','บางชัน','Bang Chan',46),(161,'10510','ทรายกองดิน','Sai Kong Din',46),(162,'10510','ทรายกองดินใต้','Sai Kong Din Tai',46),(163,'10260','บางนา','Bang Na',47),(164,'10170','ทวีวัฒนา','Thawi Watthana',48),(165,'10170','ศาลาธรรมสพน์','Sala Thammasop',48),(166,'10140','บางมด','Bang Mot',49),(167,'10140','ทุ่งครุ','Thung Khru',49),(168,'10150','บางบอน','Bang Bon',50);
/*!40000 ALTER TABLE `zim_mdm_data_sub_districts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_mdm_data_users`
--

DROP TABLE IF EXISTS `zim_mdm_data_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_mdm_data_users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `display_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `branch_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_mdm_data_users`
--

LOCK TABLES `zim_mdm_data_users` WRITE;
/*!40000 ALTER TABLE `zim_mdm_data_users` DISABLE KEYS */;
INSERT INTO `zim_mdm_data_users` VALUES (1,'admin_ziimme','P@ssw0rd','ADMIN_ZIIMME','admin','zeer (เซียร์ รังสิต)','A','2023-04-27 23:44:55','admin_ziimme',NULL,NULL),(2,'zolnny','55555','Zolnny','admin','zeer (เซียร์ รังสิต)','A','2023-05-14 22:57:15','admin_ziimme',NULL,NULL);
/*!40000 ALTER TABLE `zim_mdm_data_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_txt_data_customer`
--

DROP TABLE IF EXISTS `zim_txt_data_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_txt_data_customer` (
  `cus_id` int NOT NULL AUTO_INCREMENT,
  `cus_member` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_prefix` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_full_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_telephone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_birthday` datetime DEFAULT NULL,
  `cus_gender` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_occupation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_salary` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_payment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_house_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_moo` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_soi` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_road` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `provinceID` int DEFAULT NULL,
  `districtID` int DEFAULT NULL,
  `sub_districtID` int DEFAULT NULL,
  `postcode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `congenital_disease` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `drug_allergy` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cus_nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `postcodeid` int DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_txt_data_customer`
--

LOCK TABLES `zim_txt_data_customer` WRITE;
/*!40000 ALTER TABLE `zim_txt_data_customer` DISABLE KEYS */;
INSERT INTO `zim_txt_data_customer` VALUES (1,'60000','นาย','ณฐพงศ์ ทองคำรอด','0800790345','1998-05-25 00:00:00','ชาย','โปรแกรมเมอร์','โสด','10,000-30,000','เงินสด','747/445','7','32','บางนา-ตราด',1,1,1,NULL,'-','-','A','2023-05-23 23:08:46',NULL,'2023-05-30 02:23:31','admin_ziimme','ไอซ์',1),(2,'70000','นางสาว','เครือวัลย์ แสงศรี','0940299915','1997-06-29 00:00:00','หญิง','บัญชี','โสด','10,000-30,000','เงินสด','747/445','7','32','บางนา-ตราด',1,11,46,NULL,'-','-','A','2023-05-24 22:41:04',NULL,'2023-05-30 02:24:00','admin_ziimme','เบียร์',46);
/*!40000 ALTER TABLE `zim_txt_data_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_txt_data_employee`
--

DROP TABLE IF EXISTS `zim_txt_data_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_txt_data_employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_fullname` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `emp_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `emp_birthday` datetime DEFAULT NULL,
  `emp_telephone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `emp_email` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `emp_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `emp_position` int DEFAULT NULL,
  `emp_branch` int DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_txt_data_employee`
--

LOCK TABLES `zim_txt_data_employee` WRITE;
/*!40000 ALTER TABLE `zim_txt_data_employee` DISABLE KEYS */;
INSERT INTO `zim_txt_data_employee` VALUES (1,'อมรรัตน์ เซี่ยงป๋อง','-','2001-12-16 00:00:00','-','-','โสด',1,1,'A','2023-05-21 23:40:21','admin_ziimme','2023-05-30 14:33:55','admin_ziimme'),(2,'รัตนาวดี ช่อฟ้า','-',NULL,'-','-','โสด',1,1,'A','2023-05-21 23:52:01','admin_ziimme',NULL,NULL),(3,'จิราพร เพ็ญศรี','-',NULL,'-','-','โสด',2,1,'A','2023-05-21 23:52:35','admin_ziimme',NULL,NULL),(4,'มณฑิการณ์ เรือนทอง','-',NULL,'-','-','โสด',3,2,'A','2023-05-22 00:24:44','admin_ziimme',NULL,NULL),(5,'จันทร์ทิพย์ อินเถื่อนพระเนา','-',NULL,'-','-','โสด',3,1,'A','2023-05-22 00:25:42','admin_ziimme',NULL,NULL),(6,'นภัสสร ทองขาว','-',NULL,'-','-','โสด',1,1,'A','2023-05-22 00:26:15','admin_ziimme',NULL,NULL),(7,'ยุภาพร จารุเนตร','-',NULL,'-','-','โสด',6,3,'A','2023-05-22 00:26:59','admin_ziimme','2023-05-22 00:29:39','admin_ziimme'),(8,'อลงกต นามลาย','ติ๊ก',NULL,'-','-','สมรส',5,3,'A','2023-05-22 00:29:34','admin_ziimme',NULL,NULL),(9,'ผกามาศ แก้วติ้ว','-',NULL,'-','-','โสด',3,3,'A','2023-05-22 00:30:09','admin_ziimme',NULL,NULL),(10,'ธนภัทร พระสุวรรณ','แทน',NULL,'-','-','โสด',1,1,'A','2023-05-22 00:30:35','admin_ziimme',NULL,NULL),(11,'ยุพา หงษ์คำดี','-',NULL,'-','-','โสด',3,1,'A','2023-05-22 00:31:05','admin_ziimme',NULL,NULL),(12,'สุมาลี ศรีคุ้ม','-',NULL,'-','-','โสด',4,0,'A','2023-05-22 00:31:35','admin_ziimme','2023-05-22 00:47:47','admin_ziimme'),(13,'น้ำฟ้า ใจทัน','-',NULL,'-','-','โสด',1,2,'A','2023-05-22 00:32:02','admin_ziimme',NULL,NULL),(14,'อัญชลี ภูมินา','-',NULL,'-','-','โสด',3,2,'A','2023-05-22 00:32:36','admin_ziimme',NULL,NULL),(15,'ภัทรวดี ราชอาจ','-',NULL,'-','-','โสด',3,3,'A','2023-05-22 00:33:01','admin_ziimme',NULL,NULL),(16,'วรกมล สีแดน','-',NULL,'-','-','โสด',1,3,'A','2023-05-22 00:34:04','admin_ziimme',NULL,NULL),(17,'ชนาพร แสนหาญ','-',NULL,'-','-','โสด',1,3,'A','2023-05-22 00:34:38','admin_ziimme',NULL,NULL),(18,'ชญาภา พลกัลป์','-',NULL,'-','-','โสด',2,3,'A','2023-05-22 00:35:12','admin_ziimme',NULL,NULL),(19,'พรรณนิภา ลิ่มวิสัย','-',NULL,'-','-','โสด',3,3,'A','2023-05-22 00:35:44','admin_ziimme',NULL,NULL),(20,'จิราพร สีแสง','-',NULL,'-','-','โสด',1,3,'A','2023-05-22 00:36:07','admin_ziimme',NULL,NULL),(21,'ละอองดาว พูนยอด','-',NULL,'-','-','โสด',3,3,'A','2023-05-22 00:36:29','admin_ziimme',NULL,NULL),(22,'จิตติมา เด่นดวง','-',NULL,'-','-','โสด',2,1,'A','2023-05-22 00:37:05','admin_ziimme',NULL,NULL),(23,'กมลวรรณ ภู่ระย้า','-',NULL,'-','-','โสด',4,0,'A','2023-05-22 00:37:41','admin_ziimme','2023-05-22 00:47:27','admin_ziimme'),(24,'จุฑามาส ทองตะ','อีส',NULL,'-','-','โสด',0,1,'A','2023-05-22 00:38:34','admin_ziimme','2023-05-22 00:45:44','admin_ziimme'),(25,'ศิริวรรณ มิ่งขวัญ','โรส',NULL,'-','-','โสด',0,1,'A','2023-05-22 00:39:03','admin_ziimme','2023-05-22 00:45:47','admin_ziimme'),(26,'อารีญาภรณ์ คำสุข','อุ๋มอิ่ม',NULL,'-','-','โสด',0,2,'A','2023-05-22 00:39:59','admin_ziimme','2023-05-22 00:45:24','admin_ziimme'),(27,'วัลภา อินทร์อำนวย','ฝน',NULL,'-','-','โสด',0,2,'A','2023-05-22 00:40:27','admin_ziimme','2023-05-22 00:45:29','admin_ziimme'),(28,'โพธิพร ยศแก้ว','กิ่งไผ่',NULL,'-','-','โสด',0,3,'A','2023-05-22 00:40:53','admin_ziimme','2023-05-22 00:45:34','admin_ziimme'),(29,'แอน อินทรชนะ','แอน',NULL,'-','-','โสด',4,3,'A','2023-05-22 00:41:22','admin_ziimme',NULL,NULL);
/*!40000 ALTER TABLE `zim_txt_data_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_txt_data_sale`
--

DROP TABLE IF EXISTS `zim_txt_data_sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_txt_data_sale` (
  `sale_id` int NOT NULL AUTO_INCREMENT,
  `sale_number` int DEFAULT NULL,
  `sale_consultant` int DEFAULT NULL,
  `sale_product` int DEFAULT NULL,
  `sale_count` int DEFAULT NULL,
  `sale_pay_balance` bigint DEFAULT NULL,
  `sale_pay` bigint DEFAULT NULL,
  `sale_overdue` bigint DEFAULT NULL,
  `record_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sale_cus_id` int DEFAULT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_txt_data_sale`
--

LOCK TABLES `zim_txt_data_sale` WRITE;
/*!40000 ALTER TABLE `zim_txt_data_sale` DISABLE KEYS */;
INSERT INTO `zim_txt_data_sale` VALUES (1,60000,1,1,5,10000,3000,7000,'A','2023-05-23 23:23:17','admin_ziimme',NULL,NULL,1),(2,60001,1,2,2,5000,500,4500,'A','2023-05-24 01:36:23','admin_ziimme','2023-05-30 16:23:04','admin_ziimme',1),(3,70000,8,7,5,10000,5000,5000,'A','2023-05-24 22:43:19','admin_ziimme','2023-05-24 22:43:33','admin_ziimme',2),(4,70001,3,19,5,5000,2000,3000,'A','2023-05-30 11:45:31','admin_ziimme',NULL,NULL,2);
/*!40000 ALTER TABLE `zim_txt_data_sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zim_txt_data_sale_cut`
--

DROP TABLE IF EXISTS `zim_txt_data_sale_cut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zim_txt_data_sale_cut` (
  `sale_cut_id` int NOT NULL AUTO_INCREMENT,
  `sale_cut_count` int DEFAULT NULL,
  `sale_cut_vitamin` varchar(50) DEFAULT NULL,
  `sale_cut_mark` varchar(50) DEFAULT NULL,
  `sale_cut_therapist` int DEFAULT NULL,
  `sale_cut_doctor` varchar(50) DEFAULT NULL,
  `sale_cut_detail` varchar(150) DEFAULT NULL,
  `sale_cut_pay_balance` bigint DEFAULT NULL,
  `sale_cut_pay` bigint DEFAULT NULL,
  `sale_cut_overdue` bigint DEFAULT NULL,
  `sale_id` int DEFAULT NULL,
  `record_status` char(1) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sale_cut_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zim_txt_data_sale_cut`
--

LOCK TABLES `zim_txt_data_sale_cut` WRITE;
/*!40000 ALTER TABLE `zim_txt_data_sale_cut` DISABLE KEYS */;
INSERT INTO `zim_txt_data_sale_cut` VALUES (1,1,'ทดสอบ','ทดสอบ',4,'Dr.โจ','ทดสอบ',7000,5000,2000,1,'A','2023-05-30 14:22:56','admin_ziimme',NULL,NULL),(2,2,'ทดสอบ','ทดสอบ',4,'Dr.โจ','ทดสอบ',2000,1000,1000,1,'A','2023-05-30 14:25:50','admin_ziimme',NULL,NULL);
/*!40000 ALTER TABLE `zim_txt_data_sale_cut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ziimme'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-30 20:41:29
