/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-19 19:26:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for res_group
-- ----------------------------
DROP TABLE IF EXISTS `res_group`;
CREATE TABLE `res_group` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `res_type` varchar(20) NOT NULL COMMENT '资源类型',
  `group_name` varchar(255) NOT NULL COMMENT '分组名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资源分组';

-- ----------------------------
-- Records of res_group
-- ----------------------------
INSERT INTO `res_group` VALUES ('1174206241432334337', 'image', '分组1', null, '2019-09-18 14:19:18', '2019-09-18 14:19:18');
INSERT INTO `res_group` VALUES ('1174208034618929154', 'image', '123', null, '2019-09-18 14:26:26', '2019-09-18 14:26:26');
