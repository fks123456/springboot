/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : rabbitmqtest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-10-14 00:15:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brokermessagelog
-- ----------------------------
DROP TABLE IF EXISTS `brokermessagelog`;
CREATE TABLE `brokermessagelog` (
  `message_id` varchar(255) NOT NULL COMMENT '消息id',
  `message` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `try_count` int(11) DEFAULT NULL COMMENT '尝试次数',
  `status` varchar(1) DEFAULT NULL COMMENT '消息传递状态（0:正在传递，1:传递成功，2:传递失败）',
  `next_retry` datetime DEFAULT NULL COMMENT '下次尝试时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息传递日志';

-- ----------------------------
-- Records of brokermessagelog
-- ----------------------------
INSERT INTO `brokermessagelog` VALUES ('1539440279345$a074973a-9610-4453-aab9-012f904ec5b4', null, '3', '2', '2018-10-13 22:18:59', '2018-10-13 22:17:59', '2018-10-14 00:03:17');
INSERT INTO `brokermessagelog` VALUES ('1539440582815$c04dc39a-262e-4945-9e47-4c21386f4cee', '{\"messageId\":\"1539440582815$c04dc39a-262e-4945-9e47-4c21386f4cee\",\"name\":\"测试订单1\"}', '1', '1', '2018-10-13 22:24:03', '2018-10-13 22:23:03', '2018-10-14 00:02:45');
INSERT INTO `brokermessagelog` VALUES ('1539440718415$33862e50-8e16-414b-9882-87794eee4e12', '{\"messageId\":\"1539440718415$33862e50-8e16-414b-9882-87794eee4e12\",\"name\":\"测试订单1\"}', '1', '1', '2018-10-13 22:26:19', '2018-10-13 22:25:19', '2018-10-13 23:23:50');
INSERT INTO `brokermessagelog` VALUES ('1539440738920$6b55a5e0-c88f-48a7-8243-ad10eda02e21', '{\"messageId\":\"1539440738920$6b55a5e0-c88f-48a7-8243-ad10eda02e21\",\"name\":\"测试订单2\"}', '1', '1', '2018-10-13 22:26:39', '2018-10-13 22:25:39', '2018-10-14 00:02:45');
INSERT INTO `brokermessagelog` VALUES ('1539441292864$caa7f3e7-363c-4af8-a507-b26bb7fb6513', '{\"id\":8,\"messageId\":\"1539441292864$caa7f3e7-363c-4af8-a507-b26bb7fb6513\",\"name\":\"测试订单2\"}', '1', '1', '2018-10-13 22:35:53', '2018-10-13 22:34:53', '2018-10-14 00:02:45');
INSERT INTO `brokermessagelog` VALUES ('1539441989504$6e01a9aa-e57b-4580-8ea8-a73c93651210', '{\"id\":9,\"messageId\":\"1539441989504$6e01a9aa-e57b-4580-8ea8-a73c93651210\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 22:47:30', '2018-10-13 22:46:30', '2018-10-14 00:02:45');
INSERT INTO `brokermessagelog` VALUES ('1539442115445$bed74610-3fa4-43b0-b12e-bbd75eec4c27', '{\"id\":10,\"messageId\":\"1539442115445$bed74610-3fa4-43b0-b12e-bbd75eec4c27\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 22:49:35', '2018-10-13 22:48:35', '2018-10-14 00:02:45');
INSERT INTO `brokermessagelog` VALUES ('1539442176047$1a342159-ce8d-44d8-9e72-d7f3c8fdfd74', '{\"id\":11,\"messageId\":\"1539442176047$1a342159-ce8d-44d8-9e72-d7f3c8fdfd74\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 22:50:36', '2018-10-13 22:49:36', '2018-10-14 00:02:45');
INSERT INTO `brokermessagelog` VALUES ('1539442313637$884924b4-8268-4bd2-b1f2-39f3ccd85621', '{\"id\":12,\"messageId\":\"1539442313637$884924b4-8268-4bd2-b1f2-39f3ccd85621\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 22:52:54', '2018-10-13 22:51:54', '2018-10-14 00:02:46');
INSERT INTO `brokermessagelog` VALUES ('1539444618668$7cfa5fe0-8d50-49f6-8770-504412f99354', '{\"id\":13,\"messageId\":\"1539444618668$7cfa5fe0-8d50-49f6-8770-504412f99354\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 23:31:19', '2018-10-13 23:30:19', '2018-10-14 00:02:46');
INSERT INTO `brokermessagelog` VALUES ('1539444635102$55ca8f1c-ea23-473d-8f8a-34a13c9cad0d', '{\"id\":14,\"messageId\":\"1539444635102$55ca8f1c-ea23-473d-8f8a-34a13c9cad0d\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 23:31:35', '2018-10-13 23:30:35', '2018-10-14 00:02:46');
INSERT INTO `brokermessagelog` VALUES ('1539444940530$90ee4557-558c-4804-86af-f091183548bb', '{\"id\":15,\"messageId\":\"1539444940530$90ee4557-558c-4804-86af-f091183548bb\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 23:36:41', '2018-10-13 23:35:41', '2018-10-14 00:02:46');
INSERT INTO `brokermessagelog` VALUES ('1539445156675$31a9f3a3-9200-464c-8a06-09c404b5a217', '{\"id\":16,\"messageId\":\"1539445156675$31a9f3a3-9200-464c-8a06-09c404b5a217\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 23:40:17', '2018-10-13 23:39:17', '2018-10-14 00:02:46');
INSERT INTO `brokermessagelog` VALUES ('1539445388076$8262edf2-0d9c-4059-83ab-989e93774d54', '{\"id\":17,\"messageId\":\"1539445388076$8262edf2-0d9c-4059-83ab-989e93774d54\",\"name\":\"测试订单3\"}', '1', '1', '2018-10-13 23:44:08', '2018-10-13 23:43:08', '2018-10-14 00:02:47');
INSERT INTO `brokermessagelog` VALUES ('1539445517578$7ded7988-88bb-423f-ad10-a185b110adb0', '{\"id\":18,\"messageId\":\"1539445517578$7ded7988-88bb-423f-ad10-a185b110adb0\",\"name\":\"测试订单18\"}', '0', '1', '2018-10-13 23:46:18', '2018-10-13 23:45:18', '2018-10-13 23:45:18');
INSERT INTO `brokermessagelog` VALUES ('1539445677121$501298c1-aebe-48e4-acc0-e02dc1a1c432', '{\"id\":19,\"messageId\":\"1539445677121$501298c1-aebe-48e4-acc0-e02dc1a1c432\",\"name\":\"测试订单18\"}', '1', '1', '2018-10-13 23:48:57', '2018-10-13 23:47:57', '2018-10-14 00:02:47');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `message_id` varchar(255) DEFAULT NULL COMMENT '消息唯一id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('3', '测试订单', '1539440279345$a074973a-9610-4453-aab9-012f904ec5b4');
INSERT INTO `order` VALUES ('4', '测试订单1', '1539440582815$c04dc39a-262e-4945-9e47-4c21386f4cee');
INSERT INTO `order` VALUES ('5', '测试订单1', '1539440718415$33862e50-8e16-414b-9882-87794eee4e12');
INSERT INTO `order` VALUES ('6', '测试订单2', '1539440738920$6b55a5e0-c88f-48a7-8243-ad10eda02e21');
INSERT INTO `order` VALUES ('8', '测试订单2', '1539441292864$caa7f3e7-363c-4af8-a507-b26bb7fb6513');
INSERT INTO `order` VALUES ('9', '测试订单3', '1539441989504$6e01a9aa-e57b-4580-8ea8-a73c93651210');
INSERT INTO `order` VALUES ('10', '测试订单3', '1539442115445$bed74610-3fa4-43b0-b12e-bbd75eec4c27');
INSERT INTO `order` VALUES ('11', '测试订单3', '1539442176047$1a342159-ce8d-44d8-9e72-d7f3c8fdfd74');
INSERT INTO `order` VALUES ('12', '测试订单3', '1539442313637$884924b4-8268-4bd2-b1f2-39f3ccd85621');
INSERT INTO `order` VALUES ('13', '测试订单3', '1539444618668$7cfa5fe0-8d50-49f6-8770-504412f99354');
INSERT INTO `order` VALUES ('14', '测试订单3', '1539444635102$55ca8f1c-ea23-473d-8f8a-34a13c9cad0d');
INSERT INTO `order` VALUES ('15', '测试订单3', '1539444940530$90ee4557-558c-4804-86af-f091183548bb');
INSERT INTO `order` VALUES ('16', '测试订单3', '1539445156675$31a9f3a3-9200-464c-8a06-09c404b5a217');
INSERT INTO `order` VALUES ('17', '测试订单3', '1539445388076$8262edf2-0d9c-4059-83ab-989e93774d54');
INSERT INTO `order` VALUES ('18', '测试订单18', '1539445517578$7ded7988-88bb-423f-ad10-a185b110adb0');
INSERT INTO `order` VALUES ('19', '测试订单18', '1539445677121$501298c1-aebe-48e4-acc0-e02dc1a1c432');
