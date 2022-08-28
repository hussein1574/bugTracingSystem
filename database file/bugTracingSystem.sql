-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.29 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bugtracingsystem
CREATE DATABASE IF NOT EXISTS `bugtracingsystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bugtracingsystem`;

-- Dumping structure for table bugtracingsystem.accounts
CREATE TABLE IF NOT EXISTS `accounts` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `FName` varchar(255) NOT NULL,
  `LName` varchar(255) NOT NULL,
  `NoOfBugs` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table bugtracingsystem.bugs
CREATE TABLE IF NOT EXISTS `bugs` (
  `BugId` int NOT NULL AUTO_INCREMENT,
  `Status` varchar(255) NOT NULL,
  `BugName` varchar(255) NOT NULL,
  `BugType` varchar(255) NOT NULL,
  `Priority` varchar(255) NOT NULL,
  `ImageFileName` varchar(255) NOT NULL,
  `BugDetails` varchar(255) NOT NULL,
  `TesterId` int NOT NULL,
  `DevId` int NOT NULL,
  `ProjectId` int NOT NULL,
  PRIMARY KEY (`BugId`),
  KEY `FK1` (`TesterId`),
  KEY `FK2` (`DevId`),
  KEY `FK3` (`ProjectId`),
  CONSTRAINT `FK1` FOREIGN KEY (`TesterId`) REFERENCES `accounts` (`UserId`),
  CONSTRAINT `FK2` FOREIGN KEY (`DevId`) REFERENCES `accounts` (`UserId`),
  CONSTRAINT `FK3` FOREIGN KEY (`ProjectId`) REFERENCES `projects` (`ProjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table bugtracingsystem.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `ProjectId` int NOT NULL AUTO_INCREMENT,
  `ProjectName` varchar(255) NOT NULL,
  PRIMARY KEY (`ProjectId`),
  UNIQUE KEY `ProjectName` (`ProjectName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table bugtracingsystem.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `RoleName` varchar(255) NOT NULL,
  `AccountsUserId` int NOT NULL,
  KEY `FK1_roles` (`AccountsUserId`),
  KEY `FK2_roles` (`RoleName`),
  CONSTRAINT `FK1_roles` FOREIGN KEY (`AccountsUserId`) REFERENCES `accounts` (`UserId`),
  CONSTRAINT `FK2_roles` FOREIGN KEY (`RoleName`) REFERENCES `rolesname` (`RoleName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table bugtracingsystem.rolesname
CREATE TABLE IF NOT EXISTS `rolesname` (
  `RoleName` varchar(255) NOT NULL,
  PRIMARY KEY (`RoleName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table bugtracingsystem.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `status` int NOT NULL,
  `photo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
