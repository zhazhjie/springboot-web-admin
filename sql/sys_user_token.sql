/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-05 17:44:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `token` (`token`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', '1156876219089100802', '4784df8b3a85c351c72752f797533db2', '2019-08-17 14:17:01', '2019-08-10 14:17:01');
INSERT INTO `sys_user_token` VALUES ('2', '1156876140638838785', '56aa0b8635fecf97ffe302faf354b3d6', '2019-08-23 16:47:52', '2019-08-16 16:47:52');
INSERT INTO `sys_user_token` VALUES ('3', '1156504102032035842', '929a4ed662e22a73ce782d467b3f3aad', '2019-08-29 11:33:16', '2019-08-22 11:33:16');
INSERT INTO `sys_user_token` VALUES ('4', '1156516495197917185', '9fbd3252fe79412f9a66d649e38bada9', '2019-08-24 11:15:08', '2019-08-17 11:15:08');
INSERT INTO `sys_user_token` VALUES ('5', '1', 'c199330d7d4d73e89473700f73d7c69d', '2019-09-10 15:15:53', '2019-09-03 15:15:53');
INSERT INTO `sys_user_token` VALUES ('6', '1157171068564545537', 'c83e0a25c1fc3dc755162e65a77d3299', '2019-08-30 11:29:58', '2019-08-23 11:29:58');
INSERT INTO `sys_user_token` VALUES ('7', '1157171025145110530', 'c8c4adc38011dda70e9deab4f396d8f1', '2019-08-30 10:28:40', '2019-08-23 10:28:40');
INSERT INTO `sys_user_token` VALUES ('8', '1156876079070650370', 'df30447ba15f931302af4e96921488a4', '2019-08-30 10:10:01', '2019-08-23 10:10:01');
INSERT INTO `sys_user_token` VALUES ('9', '1156551877146890241', 'f78b1b3449cda8368173532049cbac1f', '2019-08-30 11:28:54', '2019-08-23 11:28:54');
