/*
 Navicat Premium Data Transfer

 Source Server         : MySQL 8
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : shuliu

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 30/11/2020 14:33:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `bid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `current_price` int NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_creat` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `deleted` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (3, '我是默认字符串', 18, '我是默认字符串', '37', '我是默认字符串', '2020-11-21 15:06:44', '2020-11-21 15:06:44', 0000000000);
INSERT INTO `books` VALUES (4, '软件工程', 18, '周末两节课', '37', '计算机', '2020-11-24 19:24:55', '2020-11-21 15:08:39', 0000000001);
INSERT INTO `books` VALUES (5, '计算机组成原理', 18, '周末四节课节课', '37', '计算机', '2020-11-21 15:09:53', '2020-11-21 15:09:53', 0000000000);
INSERT INTO `books` VALUES (6, '不就是语法和长难句', 99, '测试数据3', '37', '计算机', '2020-11-23 16:45:38', '2020-11-23 16:45:38', 0000000000);
INSERT INTO `books` VALUES (7, '我服了', 50, '描述', '图片链接', '种类', '2020-11-24 19:24:56', '2020-11-24 19:24:56', NULL);

-- ----------------------------
-- Table structure for collections
-- ----------------------------
DROP TABLE IF EXISTS `collections`;
CREATE TABLE `collections`  (
  `cid` int NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collections
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `bir` varbinary(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '小路', 21, 0x313939392D30332D323420);
INSERT INTO `users` VALUES (2, '小连', 22, 0x323030302D30332D323220);
INSERT INTO `users` VALUES (3, '小李', 21, 0x313939382D31302D3233);

SET FOREIGN_KEY_CHECKS = 1;
