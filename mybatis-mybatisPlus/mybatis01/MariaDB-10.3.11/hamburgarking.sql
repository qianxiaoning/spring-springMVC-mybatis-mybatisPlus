/*
Navicat MySQL Data Transfer

Source Server         : qxn
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : hamburgarking

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-10-26 10:58:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `door`
-- ----------------------------
DROP TABLE IF EXISTS `door`;
CREATE TABLE `door` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `tel` char(12) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of door
-- ----------------------------
INSERT INTO `door` VALUES ('1', '天坛店', '010-61111111', '天坛南路2号');
INSERT INTO `door` VALUES ('2', '鸟巢店', '010-62222222', '鸟巢南路2号');
INSERT INTO `door` VALUES ('3', '奥体店', '010-63333333', '奥体南路2号');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '',
  `job` varchar(50) DEFAULT '',
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '王总', '店长', '7000');
INSERT INTO `emp` VALUES ('2', '王队', '组长', '5000');
INSERT INTO `emp` VALUES ('3', '小王', '店员', '3000');
INSERT INTO `emp` VALUES ('10', '小王总', '全职', '2901');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `door_id` int(11) DEFAULT NULL,
  `order_no` varchar(50) DEFAULT NULL,
  `order_type` varchar(50) DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `cashier` varchar(50) DEFAULT NULL,
  `order_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `pay_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `pay_type` varchar(50) DEFAULT '',
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '3', 'A1012', '堂食', '3', '王总', '2019-10-24 19:02:45', '2019-10-24 19:02:45', '微信支付', '33');
INSERT INTO `order` VALUES ('2', '2', 'A1021', '外带', '1', '小王', '2019-10-24 19:02:49', '2019-10-24 19:02:49', '支付宝支付', '22.5');
INSERT INTO `order` VALUES ('3', '1', 'A1055', '堂食', '2', '王对', '2019-10-24 19:02:52', '2019-10-24 19:02:52', '现金支付', '19.5');
