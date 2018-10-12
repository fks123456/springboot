/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : shirotest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-10-12 21:35:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for res
-- ----------------------------
DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res
-- ----------------------------
INSERT INTO `res` VALUES ('1', 'user/save');
INSERT INTO `res` VALUES ('2', 'user/edit');
INSERT INTO `res` VALUES ('3', 'user');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');

-- ----------------------------
-- Table structure for role_res
-- ----------------------------
DROP TABLE IF EXISTS `role_res`;
CREATE TABLE `role_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `res_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_res
-- ----------------------------
INSERT INTO `role_res` VALUES ('1', '1', '1');
INSERT INTO `role_res` VALUES ('2', '1', '2');
INSERT INTO `role_res` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'fks', 'e09d0d5d9150b332b0af269628492d61', '1');
