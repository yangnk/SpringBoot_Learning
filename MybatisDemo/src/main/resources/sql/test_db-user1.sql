/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 127.0.0.1:3306
 Source Schema         : test_db

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 22/03/2023 21:08:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user1
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user1
-- ----------------------------
BEGIN;
INSERT INTO `user1` (`id`, `user_name`, `password`, `sex`) VALUES (1, 'aaa', 'bbb', '1');
INSERT INTO `user1` (`id`, `user_name`, `password`, `sex`) VALUES (2, 'ccc', 'ddd', '2');
INSERT INTO `user1` (`id`, `user_name`, `password`, `sex`) VALUES (20, 'hhh', '666666', 'abc');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
