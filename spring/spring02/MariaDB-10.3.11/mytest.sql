/*
Navicat MySQL Data Transfer

Source Server         : qxn
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-03-12 18:25:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `table01`
-- ----------------------------
DROP TABLE IF EXISTS `table01`;
CREATE TABLE `table01` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT '',
  `createdTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table01
-- ----------------------------
INSERT INTO `table01` VALUES ('1', 'a', null);
INSERT INTO `table01` VALUES ('2', 'w', null);
