/*
 Navicat Premium Data Transfer

 Source Server         : 本地开发环境(localhost)
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : sensitive_word_admin

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 27/07/2022 10:17:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_word
-- ----------------------------
DROP TABLE IF EXISTS `tb_word`;
CREATE TABLE `tb_word`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单词',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型:1-敏感词 2-非敏感词',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_word
-- ----------------------------
INSERT INTO `tb_word` VALUES (1, '傻逼', 1, '2022-07-26 16:35:32', '2022-07-26 16:35:32');
INSERT INTO `tb_word` VALUES (2, '去死吧', 1, '2022-07-26 16:35:56', '2022-07-26 16:35:56');
INSERT INTO `tb_word` VALUES (3, '王八蛋', 1, '2022-07-26 16:36:11', '2022-07-26 16:36:11');
INSERT INTO `tb_word` VALUES (4, '五星红旗', 2, '2022-07-26 16:36:20', '2022-07-26 16:36:20');

SET FOREIGN_KEY_CHECKS = 1;
