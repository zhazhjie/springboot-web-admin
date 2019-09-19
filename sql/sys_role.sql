/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-05 17:43:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1156503917231001602', '商品管理员', '', '1', '2019-07-31 17:56:35', '2019-07-31 17:56:35');
INSERT INTO `sys_role` VALUES ('1156551789343330306', '点点总部管理', '', '1', '2019-07-31 21:06:49', '2019-08-08 18:22:16');
INSERT INTO `sys_role` VALUES ('1156876025341616130', '订单管理员', '', '1', '2019-08-01 18:35:13', '2019-08-01 18:35:13');
