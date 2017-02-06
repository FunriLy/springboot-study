/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : myboot

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-02-06 17:28:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blacklist`
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(30) DEFAULT NULL,
  `iptime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blacklist
-- ----------------------------
INSERT INTO `blacklist` VALUES ('1', '127.0.0.1', '2017-02-06 16:16:42');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'fangrui', '20');
INSERT INTO `users` VALUES ('2', 'fangrui', '20');
INSERT INTO `users` VALUES ('3', 'fangrui', '20');
INSERT INTO `users` VALUES ('4', 'fangrui', '20');
INSERT INTO `users` VALUES ('5', 'fangrui', '20');
INSERT INTO `users` VALUES ('6', 'fangrui', '20');
INSERT INTO `users` VALUES ('7', 'fangrui', '20');
INSERT INTO `users` VALUES ('8', 'fangrui', '20');
INSERT INTO `users` VALUES ('9', 'fangrui', '20');
INSERT INTO `users` VALUES ('10', 'fangrui', '20');
INSERT INTO `users` VALUES ('11', 'fangrui', '20');
INSERT INTO `users` VALUES ('12', 'fangrui', '20');
INSERT INTO `users` VALUES ('13', 'fangrui', '20');
INSERT INTO `users` VALUES ('14', 'fangrui', '11');
INSERT INTO `users` VALUES ('15', 'fangrui', '55');
INSERT INTO `users` VALUES ('16', 'fangrui', '55');
