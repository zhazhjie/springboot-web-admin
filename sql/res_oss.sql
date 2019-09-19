/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-19 19:26:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for res_oss
-- ----------------------------
DROP TABLE IF EXISTS `res_oss`;
CREATE TABLE `res_oss` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `res_type` varchar(20) NOT NULL COMMENT '资源类型',
  `group_id` bigint(20) DEFAULT '0' COMMENT '分组ID',
  `obj_url` varchar(150) NOT NULL COMMENT '对象url',
  `obj_suffix` varchar(10) DEFAULT NULL COMMENT '后缀',
  `alias_name` varchar(150) DEFAULT NULL COMMENT '别名',
  `sort` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资源对象存储';

-- ----------------------------
-- Records of res_oss
-- ----------------------------
INSERT INTO `res_oss` VALUES ('1174512042420105218', 'image', '0', '/upload/images/20190919/分享.png', 'png', '分享.png', null, '2019-09-19 10:34:27', '2019-09-19 10:34:27');
