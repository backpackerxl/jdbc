/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.18-log : Database - girls
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`login` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `login`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(40) NOT NULL,
  `phone` varchar(40) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`NAME`,`phone`,`username`,`password`) values (1,'张三',' 15226332115','zhangsan','123456'),(2,'李四',' 15226332116','lisi','942945');

/*Table structure for table `stu_tab` */

DROP TABLE IF EXISTS `stu_tab`;

CREATE TABLE `stu_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` varchar(10) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `birthday` varchar(40) NOT NULL,
  `class` varchar(50) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `stu_tab` */

insert  into `stu_tab`(`id`,`name`,`age`,`sex`,`birthday`,`class`) values (1,'柳岩','50','女','1988-02-03 ','大数据20-3'),(2,'苍老师','31','女','1987-12-30','大数据20-1'),(3,'Angelababy','35','女','1989-02-03','大数据20-1'),(4,'热巴','27','女','1993-02-03 ','大数据20-3'),(5,'周冬雨','25','女','1992-02-03 ','大数据20-1'),(6,'周芷若','30','女','1988-02-03 ','大数据20-2'),(7,'岳灵珊','32','女','1987-12-30 ','大数据20-3'),(8,'小昭','31','女','1989-02-03','大数据20-2');
/*Table structure for table `stu_sro` */

DROP TABLE IF EXISTS `stu_sro`;

CREATE TABLE `stu_sro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` varchar(20) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `linux` int(11) DEFAULT NULL,
  `html` int(11) DEFAULT NULL,
  `mysql` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `stu_sro` */

insert  into `stu_sro`(`id`,`studentid`,`name`,`linux`,`html`,`mysql`) values  (1,'20201321','柳岩','50','60','70'),(2,'20201322','苍老师','63','85','75'),(3,'20201323','Angelababy','75','60','70'),(4,'20201324','热巴','87','97','50'),(5,'20201325','周冬雨','85','86','87'),(6,'20201326','周芷若','70','76','88'),(7,'20201327','岳灵珊','72','89','85'),(8,'20201328','小昭','71','85','94');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
