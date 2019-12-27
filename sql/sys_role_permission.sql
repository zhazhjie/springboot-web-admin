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

 Date: 27/12/2019 23:20:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1210577999840460801, 2, 1, '2019-12-27 23:07:41', NULL);
INSERT INTO `sys_role_permission` VALUES (1210577999840460802, 2, 2, '2019-12-27 23:07:41', NULL);
INSERT INTO `sys_role_permission` VALUES (1210577999840460803, 2, 5, '2019-12-27 23:07:41', NULL);
INSERT INTO `sys_role_permission` VALUES (1210577999840460804, 2, 3, '2019-12-27 23:07:41', NULL);
INSERT INTO `sys_role_permission` VALUES (1210577999840460805, 2, 9, '2019-12-27 23:07:41', NULL);
INSERT INTO `sys_role_permission` VALUES (1210577999840460806, 2, 4, '2019-12-27 23:07:41', NULL);
INSERT INTO `sys_role_permission` VALUES (1210577999840460807, 2, 13, '2019-12-27 23:07:41', NULL);

SET FOREIGN_KEY_CHECKS = 1;
