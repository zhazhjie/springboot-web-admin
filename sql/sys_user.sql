/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/12/2019 23:21:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `state` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常   0：禁用',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否已删除 0：未删除 1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '0e55cd36ec3236995fd7ba0c0a2872148706965c52dbde99509c545d50f34a91', 'YTWkZgKfde7CFyr9lNjd', '', '13800138001', '/avatar/2018/10/8/eaba659deea844d49edb3cf3a8a01fd4.png', 1, 0, NULL, 1, '2018-09-15 02:44:43', '2019-06-20 11:09:37');
INSERT INTO `sys_user` VALUES (2, 'guest', '0347bc36d0849980ae8fba9d7c262d4d5a6a3d609845f3a0dceb9a5b7c9b34a1', 'vMIGO1H5tW73VcskNwDO', '', '', '', 1, 0, 1, 1, '2019-09-22 20:27:46', '2019-12-27 23:07:53');

SET FOREIGN_KEY_CHECKS = 1;
