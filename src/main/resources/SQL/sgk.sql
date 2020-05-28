/*
 Navicat MySQL Data Transfer

 Source Server         : 彬彬
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 116.62.108.120:3306
 Source Schema         : sgk

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 28/05/2020 01:00:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `commodity_id` int(11) NULL DEFAULT NULL,
  `is_del` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_collect
-- ----------------------------
INSERT INTO `t_collect` VALUES (1, 1, 1, 0);
INSERT INTO `t_collect` VALUES (2, 2, 1, 0);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `moment_id` int(11) NULL DEFAULT NULL,
  `is_del` int(255) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, 3, '不错呀', '2020-05-27 20:33:56', 1, 0);
INSERT INTO `t_comment` VALUES (2, 1, '啦啦', '2020-05-27 21:42:15', NULL, 0);
INSERT INTO `t_comment` VALUES (3, 1, '啦啦', '2020-05-27 21:44:38', 1, 0);
INSERT INTO `t_comment` VALUES (4, 1, '嘻嘻', '2020-05-27 21:54:29', 1, 0);

-- ----------------------------
-- Table structure for t_commodity
-- ----------------------------
DROP TABLE IF EXISTS `t_commodity`;
CREATE TABLE `t_commodity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `price` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_commodity
-- ----------------------------
INSERT INTO `t_commodity` VALUES (1, '洋娃娃', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', 299);

-- ----------------------------
-- Table structure for t_like
-- ----------------------------
DROP TABLE IF EXISTS `t_like`;
CREATE TABLE `t_like`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `moment_id` int(11) NULL DEFAULT NULL,
  `is_del` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_like
-- ----------------------------
INSERT INTO `t_like` VALUES (1, 1, 1, 0);
INSERT INTO `t_like` VALUES (2, 2, 1, 1);

-- ----------------------------
-- Table structure for t_moment
-- ----------------------------
DROP TABLE IF EXISTS `t_moment`;
CREATE TABLE `t_moment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_moment
-- ----------------------------
INSERT INTO `t_moment` VALUES (1, 1, '好漂亮呀', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', '2020-05-27 19:41:56', 0);
INSERT INTO `t_moment` VALUES (2, 2, '天气不错', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', '2020-05-27 20:10:01', 0);
INSERT INTO `t_moment` VALUES (3, 1, '江上之清风', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', '2020-05-27 21:22:26', NULL);
INSERT INTO `t_moment` VALUES (4, 1, '山间之明月', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', '2020-05-27 21:34:51', 0);

-- ----------------------------
-- Table structure for t_shopping
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping`;
CREATE TABLE `t_shopping`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `commodity_id` int(11) NULL DEFAULT NULL,
  `is_del` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shopping
-- ----------------------------
INSERT INTO `t_shopping` VALUES (1, 1, 1, 0);
INSERT INTO `t_shopping` VALUES (2, 2, 1, 0);
INSERT INTO `t_shopping` VALUES (3, 3, 1, 0);
INSERT INTO `t_shopping` VALUES (4, 4, 1, 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `is_del` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '张娟', '123456', NULL, 0);
INSERT INTO `t_user` VALUES (2, 'Joker', 'java', 'imgURL', 0);
INSERT INTO `t_user` VALUES (3, 'mary', 'java', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', 0);
INSERT INTO `t_user` VALUES (4, 'Mrs.zhang', 'java', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', 0);
INSERT INTO `t_user` VALUES (5, 'jack', 'java', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', 0);
INSERT INTO `t_user` VALUES (6, 'rose', 'java', 'imgURL', 0);
INSERT INTO `t_user` VALUES (7, '陈先生', 'java', 'https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg', 0);

SET FOREIGN_KEY_CHECKS = 1;
