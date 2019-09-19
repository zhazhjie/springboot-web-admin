/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-17 18:02:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父节点ID，顶级为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单对应组件的路径或接口URL',
  `permission_flag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '授权标识 (如：sys:user:list)',
  `type` int(11) NOT NULL COMMENT '类型 0：菜单，1：接口',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单图标 (类型为菜单时选填)',
  `state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 0 正常 1禁用',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `hidden` tinyint(2) NOT NULL DEFAULT '0' COMMENT '在导航菜单中隐藏 1 隐藏，0 显示 (类型为菜单时选填)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT=' 权限管理';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '0', '系统中心', '', null, '0', 'icon-setting', '0', '99', '0', '2017-11-08 09:52:09', '2018-11-10 03:56:45');
INSERT INTO `sys_permission` VALUES ('2', '1', '用户管理', '/sys/user', null, '0', 'icon-user', '0', '1', '0', '2017-11-08 09:52:09', '2018-11-10 04:12:07');
INSERT INTO `sys_permission` VALUES ('3', '1', '权限管理', '/sys/permission', '', '0', 'icon-menu', '0', '2', '0', '2017-11-08 09:52:09', '2018-11-10 04:12:25');
INSERT INTO `sys_permission` VALUES ('4', '1', '角色管理', '/sys/role', null, '0', 'icon-team', '0', '3', '0', '2017-11-08 09:52:09', '2018-11-10 04:12:47');
INSERT INTO `sys_permission` VALUES ('5', '2', '用户查看', '', 'sys:user:list', '1', null, '0', '1', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('6', '2', '用户新增', '', 'sys:user:add', '1', null, '0', '2', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('7', '2', '用户修改', '', 'sys:user:update', '1', null, '0', '3', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('8', '2', '用户删除', '', 'sys:user:delete', '1', null, '0', '4', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('9', '3', '权限查看', '', 'sys:permission:list', '1', null, '0', '1', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('10', '3', '权限新增', '', 'sys:permission:add', '1', null, '0', '2', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('11', '3', '权限修改', '', 'sys:permission:update', '1', null, '0', '3', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('12', '3', '权限删除', '', 'sys:permission:delete', '1', null, '0', '4', '0', '2017-11-08 09:52:09', '2017-12-04 16:31:10');
INSERT INTO `sys_permission` VALUES ('13', '4', '角色查看', '', 'sys:role:list', '1', null, '0', '1', '0', '2018-02-04 13:55:06', '2018-09-15 07:08:15');
INSERT INTO `sys_permission` VALUES ('14', '4', '角色新增', '', 'sys:role:add', '1', null, '0', '2', '0', '2018-02-04 13:55:06', '2018-09-15 07:08:15');
INSERT INTO `sys_permission` VALUES ('15', '4', '角色修改', '', 'sys:role:update', '1', null, '0', '3', '0', '2018-02-04 13:55:06', '2018-09-15 07:08:15');
INSERT INTO `sys_permission` VALUES ('16', '4', '角色删除', '', 'sys:role:delete', '1', null, '0', '4', '0', '2018-02-04 13:55:06', '2018-09-15 07:08:15');
INSERT INTO `sys_permission` VALUES ('17', '2', '重置密码', '', 'sys:user:resetPassword', '1', 'icon-delete', '0', '0', '0', '2019-09-17 17:50:50', '2019-09-17 17:50:50');
