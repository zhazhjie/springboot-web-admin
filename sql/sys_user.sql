/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-05 17:43:59
*/

SET FOREIGN_KEY_CHECKS=0;

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
