/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-05 17:43:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色权限关系表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1156503917340053505', '1156503917231001602', '1154389609496887298', '2019-07-31 17:56:35', '2019-07-31 17:56:35');
INSERT INTO `sys_role_permission` VALUES ('1156503917356830721', '1156503917231001602', '1154389755186036737', '2019-07-31 17:56:35', '2019-07-31 17:56:35');
INSERT INTO `sys_role_permission` VALUES ('1156876025450668034', '1156876025341616130', '1156772099253317634', '2019-08-01 18:35:13', '2019-08-01 18:35:13');
INSERT INTO `sys_role_permission` VALUES ('1156876025454862338', '1156876025341616130', '1156773152807956481', '2019-08-01 18:35:13', '2019-08-01 18:35:13');
INSERT INTO `sys_role_permission` VALUES ('1159409481044897794', '1156551789343330306', '1153189990263828481', '2019-08-08 18:22:16', '2019-08-08 18:22:16');
INSERT INTO `sys_role_permission` VALUES ('1159409481053286401', '1156551789343330306', '1153190263568871426', '2019-08-08 18:22:16', '2019-08-08 18:22:16');
INSERT INTO `sys_role_permission` VALUES ('1159409481053286402', '1156551789343330306', '1154599246522019842', '2019-08-08 18:22:16', '2019-08-08 18:22:16');
INSERT INTO `sys_role_permission` VALUES ('1159409481053286403', '1156551789343330306', '1153653328160645122', '2019-08-08 18:22:16', '2019-08-08 18:22:16');
INSERT INTO `sys_role_permission` VALUES ('1159409481053286404', '1156551789343330306', '1154389609496887298', '2019-08-08 18:22:16', '2019-08-08 18:22:16');
INSERT INTO `sys_role_permission` VALUES ('1159409481103618049', '1156551789343330306', '1154389755186036737', '2019-08-08 18:22:16', '2019-08-08 18:22:16');
INSERT INTO `sys_role_permission` VALUES ('1159409481116200961', '1156551789343330306', '1156772099253317634', '2019-08-08 18:22:16', '2019-08-08 18:22:16');
INSERT INTO `sys_role_permission` VALUES ('1159409481128783874', '1156551789343330306', '1156773152807956481', '2019-08-08 18:22:16', '2019-08-08 18:22:16');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(20) NOT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态  1：正常   0：禁用',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0：未删除 1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '0e55cd36ec3236995fd7ba0c0a2872148706965c52dbde99509c545d50f34a91', 'YTWkZgKfde7CFyr9lNjd', '', '13800138001', '/avatar/2018/10/8/eaba659deea844d49edb3cf3a8a01fd4.png', '0', '0', null, '1', '2018-09-15 02:44:43', '2019-06-20 11:09:37');
INSERT INTO `sys_user` VALUES ('1156504102032035842', 'spadmin01', 'fe92d45d2ec0cdb88bcf98f202b857e76b6193db264638429d3365488ba8fb26', 'p7eaj5KXA6ZM6wvjv8dM', '', null, null, '0', '0', null, null, '2019-07-31 17:57:19', '2019-07-31 17:57:19');
INSERT INTO `sys_user` VALUES ('1156516398133334018', 'spadmin02', 'fc9cf7ec5b7ac8a76811af41ac346bb5561dae66c7956a5db004acbf8b468018', 'sRLKnc1C0zWl4cgRYyyZ', '', null, null, '0', '0', null, null, '2019-07-31 18:46:11', '2019-07-31 18:46:11');
INSERT INTO `sys_user` VALUES ('1156516495197917185', 'spadmin03', 'b84a9ec1a8c4ba3f1a11a6a7469ef96fbc7655d241e85d098c1ad7202ff2187c', '1eliGdHI0USFzUTAXe2J', '', null, null, '0', '0', null, null, '2019-07-31 18:46:34', '2019-07-31 18:46:34');
INSERT INTO `sys_user` VALUES ('1156516624000798722', 'spadmin', '669d88d716c2d105188108af5a4af3595f1cb554114a4d2ef9fdbbf61e99cc28', 'smaBeGuXVLv4LhcJy0GB', '', null, null, '0', '0', null, null, '2019-07-31 18:47:05', '2019-07-31 18:47:05');
INSERT INTO `sys_user` VALUES ('1156551877146890241', 'zbadmin01', 'a6753584325f45ce82b23188b999803abdb7effdd31fcf71e602e93870e4f2a3', 'vDReJmYrzQO6lX17KHw3', '', null, null, '0', '0', null, null, '2019-07-31 21:07:10', '2019-08-16 15:20:11');
INSERT INTO `sys_user` VALUES ('1156876079070650370', 'order01', 'c78cf4a8e2e080891d1a81176d35cc08e3c2b1849741235455c55176f3fca834', 'HxFnwhyhdHORbJYUwMTj', '', null, null, '0', '0', null, null, '2019-08-01 18:35:26', '2019-08-03 10:28:50');
INSERT INTO `sys_user` VALUES ('1156876140638838785', 'order02', '8cbfe46781b5feef7e9adab0e79593323a11bf7fe188f2d65538dbcadaccadad', 'FaLRR1qPRnf5H767mlDB', '', '', null, '0', '0', null, null, '2019-08-01 18:35:40', '2019-08-03 10:29:22');
INSERT INTO `sys_user` VALUES ('1156876219089100802', 'order03', 'e201a0b97138c8bfc9766555e9ec8c14a1eae30b6cb785c6738fe626fede14eb', 'igul2L4eu7CPXmXrV9kN', '', null, null, '0', '0', null, null, '2019-08-01 18:35:59', '2019-08-03 10:30:00');
INSERT INTO `sys_user` VALUES ('1157171025145110530', 'zbadmin02', '3fecdca86ce7487c21b69f534489db620d5b599e6428de887347485c06674cc4', 'cTd8cknfi7GFHob854t2', '', null, null, '0', '1', null, null, '2019-08-02 14:07:26', '2019-09-05 15:09:43');
INSERT INTO `sys_user` VALUES ('1157171068564545537', 'zbadmin03', 'a913c8d1e7abffaf13aaa4d5333f49a22b75b97c4db35089c0c666cb80468dbe', 'M3qJgiFOt7Z16olMiEES', '', '', null, '1', '0', null, null, '2019-08-02 14:07:37', '2019-09-05 15:07:21');
INSERT INTO `sys_user` VALUES ('1169510615008346113', '666', '8c9d7af039b7cc3236d3f48c642f89eadc1b21b8d20d6481b37c115653143a46', '6rhx9LvQmyYbQNUYyidJ', '', '1234568655', null, '1', '0', '1', null, '2019-09-05 15:20:34', '2019-09-05 16:31:16');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1156504102115921922', '1156504102032035842', '1156503917231001602', '2019-07-31 17:57:19', '2019-07-31 17:57:19');
INSERT INTO `sys_user_role` VALUES ('1156516398267551745', '1156516398133334018', '1156503917231001602', '2019-07-31 18:46:11', '2019-07-31 18:46:11');
INSERT INTO `sys_user_role` VALUES ('1156516495214694402', '1156516495197917185', '1156503917231001602', '2019-07-31 18:46:34', '2019-07-31 18:46:34');
INSERT INTO `sys_user_role` VALUES ('1156516624025964545', '1156516624000798722', '1156503917231001602', '2019-07-31 18:47:05', '2019-07-31 18:47:05');
INSERT INTO `sys_user_role` VALUES ('1156551877163667457', '1156551877146890241', '1156551789343330306', '2019-07-31 21:07:10', '2019-07-31 21:07:10');
INSERT INTO `sys_user_role` VALUES ('1156876079221645313', '1156876079070650370', '1156876025341616130', '2019-08-01 18:35:26', '2019-08-01 18:35:26');
INSERT INTO `sys_user_role` VALUES ('1156876219122655234', '1156876219089100802', '1156876025341616130', '2019-08-01 18:35:59', '2019-08-01 18:35:59');
INSERT INTO `sys_user_role` VALUES ('1156876247933329410', '1156876140638838785', '1156876025341616130', '2019-08-01 18:36:06', '2019-08-01 18:36:06');
INSERT INTO `sys_user_role` VALUES ('1157171025220608002', '1157171025145110530', '1156551789343330306', '2019-08-02 14:07:26', '2019-08-02 14:07:26');
INSERT INTO `sys_user_role` VALUES ('1157171068581322754', '1157171068564545537', '1156551789343330306', '2019-08-02 14:07:37', '2019-08-02 14:07:37');
INSERT INTO `sys_user_role` VALUES ('1169520314571223041', '1169510615008346113', '1156503917231001602', '2019-09-05 15:59:06', '2019-09-05 15:59:06');
INSERT INTO `sys_user_role` VALUES ('1169520314923544578', '1169510615008346113', '1156551789343330306', '2019-09-05 15:59:06', '2019-09-05 15:59:06');

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
