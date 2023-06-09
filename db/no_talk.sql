/*
 Navicat Premium Data Transfer

 Source Server         : mydb
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : no_talk

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 09/06/2023 09:07:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_img
-- ----------------------------
DROP TABLE IF EXISTS `t_img`;
CREATE TABLE `t_img`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_img
-- ----------------------------
INSERT INTO `t_img` VALUES (1, '1', 1, '1', '1');
INSERT INTO `t_img` VALUES (17, 'miku', 1, '2023', 'http://8.140.61.64:9999/1_2023.png');
INSERT INTO `t_img` VALUES (18, 'miku', 1, '123456', 'http://8.140.61.64:9999/1_123456.png');
INSERT INTO `t_img` VALUES (19, 'miku', 1, '111', 'http://8.140.61.64:9999/1_111.png');
INSERT INTO `t_img` VALUES (20, 'miku', 1, '111', 'http://8.140.61.64:9999/1_111.png');
INSERT INTO `t_img` VALUES (21, 'miku', 1, '123', 'http://8.140.61.64:9999/1_123.png');
INSERT INTO `t_img` VALUES (22, 'miku', 1, '123', 'http://8.140.61.64:9999/1_123.png');
INSERT INTO `t_img` VALUES (23, 'miku', 1, '233', 'http://8.140.61.64:9999/img/1_233.png');
INSERT INTO `t_img` VALUES (24, 'miku', 1, '20230608135206', 'http://8.140.61.64:9999/img/1_20230608135206.png');

-- ----------------------------
-- Table structure for t_note
-- ----------------------------
DROP TABLE IF EXISTS `t_note`;
CREATE TABLE `t_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_note
-- ----------------------------
INSERT INTO `t_note` VALUES (1, 1, '2023-6-1', '在今年的Google/IO大会上，亮相了一个全新的 Android 原生 UI 开发框架-Jetpack Compose, 与苹果的SwiftIUI一样，Jetpack Compose是一个声明式的UI框架，随着了今年安卓和苹果两大移动平台相继推出自己的UI开发框架Jetpack Compose 和SwiftIUI，标志着移动操作系统正式全面拥抱声明式 UI 开发模式', '原创|Android Jetpack Compose 最全上手指南');
INSERT INTO `t_note` VALUES (2, 1, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (3, 1, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (4, 1, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (5, 1, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (6, 2, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (7, 2, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (8, 2, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (9, 2, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (10, 5, '2023', 'test', 'title');
INSERT INTO `t_note` VALUES (12, 1, '2023', 'test1111', 'test1111');
INSERT INTO `t_note` VALUES (13, 1, '01月01日 08:00', '摸摸摸摸摸摸mmmmmmmmmm', 'rnm退钱');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zrq', '123456');
INSERT INTO `t_user` VALUES (2, 'zhang', '123');
INSERT INTO `t_user` VALUES (3, '1', '1');
INSERT INTO `t_user` VALUES (4, '2', '2');
INSERT INTO `t_user` VALUES (5, '3', '2');

SET FOREIGN_KEY_CHECKS = 1;
