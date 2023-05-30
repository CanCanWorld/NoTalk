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

 Date: 30/05/2023 14:21:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_note
-- ----------------------------
DROP TABLE IF EXISTS `t_note`;
CREATE TABLE `t_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_note
-- ----------------------------
INSERT INTO `t_note` VALUES (1, 1, '1', '1');
INSERT INTO `t_note` VALUES (2, 1, '2023', 'test');
INSERT INTO `t_note` VALUES (3, 1, '2023', 'test');
INSERT INTO `t_note` VALUES (4, 1, '2023', 'test');
INSERT INTO `t_note` VALUES (5, 1, '2023', 'test');
INSERT INTO `t_note` VALUES (6, 2, '2023', 'test');
INSERT INTO `t_note` VALUES (7, 2, '2023', 'test');
INSERT INTO `t_note` VALUES (8, 2, '2023', 'test');
INSERT INTO `t_note` VALUES (9, 2, '2023', 'test');
INSERT INTO `t_note` VALUES (10, 5, '2023', 'test');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zrq', '123456');
INSERT INTO `t_user` VALUES (2, 'zhang', '123');
INSERT INTO `t_user` VALUES (3, '1', '1');
INSERT INTO `t_user` VALUES (4, '2', '2');
INSERT INTO `t_user` VALUES (5, '3', '2');

SET FOREIGN_KEY_CHECKS = 1;
