/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : taobaoserver

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2014-12-03 18:35:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_menu`
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `orders` double(10,2) DEFAULT NULL,
  `isbutton` char(1) DEFAULT '0',
  `btnflag` varchar(32) DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES ('1', '系统管理', null, '1.00', '0', null, '0');
INSERT INTO `admin_menu` VALUES ('2', '菜单管理', '/admin/menu/index', '2.00', '0', null, '1');
INSERT INTO `admin_menu` VALUES ('3', '角色管理', '/admin/role/index', '3.00', '0', null, '1');
INSERT INTO `admin_menu` VALUES ('4', '管理员管理', '/admin/user', '11.00', '0', null, '1');
INSERT INTO `admin_menu` VALUES ('5', '增加管理员', '/admin/user/doadd', null, '1', 'userdoadd', '4');
INSERT INTO `admin_menu` VALUES ('6', '修改管理员', '/admin/user/doupdate', null, '1', 'userdoupdate', '4');
INSERT INTO `admin_menu` VALUES ('7', '删除管理员', '/admin/user/dodel', null, '1', 'userdodel', '4');
INSERT INTO `admin_menu` VALUES ('8', '管理员查询', '/admin/user/dopage', null, '1', 'userdopage', '4');
INSERT INTO `admin_menu` VALUES ('9', '查看菜单', '/admin/menu/list', null, '1', 'menulist', '2');
INSERT INTO `admin_menu` VALUES ('10', '修改菜单', '/admin/menu/doupdate', null, '1', 'menudoupdate', '2');
INSERT INTO `admin_menu` VALUES ('11', '添加菜单', '/admin/menu/doadd', null, '1', 'menudoadd', '2');
INSERT INTO `admin_menu` VALUES ('12', '删除菜单', '/admin/menu/dodel', null, '1', 'menudodel', '2');
INSERT INTO `admin_menu` VALUES ('13', '添加角色', '/admin/role/doadd', null, '1', 'roledoadd', '3');
INSERT INTO `admin_menu` VALUES ('14', '修改角色', '/admin/role/doupdate', null, '1', 'roledoupdate', '3');
INSERT INTO `admin_menu` VALUES ('15', '删除角色', '/admin/role/setstatus', null, '1', 'rolesetstatus', '3');
INSERT INTO `admin_menu` VALUES ('16', '分页查看角色', '/admin/role/dopage', null, '1', 'roledopage', '3');
INSERT INTO `admin_menu` VALUES ('17', '查看某个角色', '/admin/role/get', null, '1', 'roleget', '3');
INSERT INTO `admin_menu` VALUES ('18', '密码重置', '/admin/user/setpassword', null, '1', 'usersetpassword', '4');

-- ----------------------------
-- Table structure for `admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('8', '系统管理员', '1');
INSERT INTO `admin_role` VALUES ('9', '技术管理组', '1');
INSERT INTO `admin_role` VALUES ('10', 'test', '4');
INSERT INTO `admin_role` VALUES ('11', 'test', '4');
INSERT INTO `admin_role` VALUES ('12', 'test', '4');
INSERT INTO `admin_role` VALUES ('13', 'test', '4');
INSERT INTO `admin_role` VALUES ('14', 'test', '4');

-- ----------------------------
-- Table structure for `admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `real_name` varchar(60) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', '01jiangwei01', '980ac217c6b51e7dc41040bec1edfec8', '管理员', '1');

-- ----------------------------
-- Table structure for `apply_draw`
-- ----------------------------
DROP TABLE IF EXISTS `apply_draw`;
CREATE TABLE `apply_draw` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `third_order_no` varchar(50) NOT NULL,
  `amount` decimal(16,2) NOT NULL,
  `user_id` int(10) NOT NULL,
  `create_time` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  `auditor_id` int(10) DEFAULT NULL,
  `auditor_name` varchar(30) DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `refuse_reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply_draw
-- ----------------------------

-- ----------------------------
-- Table structure for `business_exception`
-- ----------------------------
DROP TABLE IF EXISTS `business_exception`;
CREATE TABLE `business_exception` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `create_time` datetime NOT NULL,
  `type` varchar(30) NOT NULL,
  `class_path` varchar(100) NOT NULL,
  `method_name` varchar(100) NOT NULL,
  `param_string` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_exception
-- ----------------------------

-- ----------------------------
-- Table structure for `operate_log`
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `operate_time` datetime NOT NULL,
  `operate_type` varchar(50) NOT NULL,
  `before_value` varchar(100) DEFAULT NULL,
  `after_value` varchar(100) NOT NULL,
  `ip` varchar(30) NOT NULL,
  `isused` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate_log
-- ----------------------------

-- ----------------------------
-- Table structure for `recharge_apply`
-- ----------------------------
DROP TABLE IF EXISTS `recharge_apply`;
CREATE TABLE `recharge_apply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `third_order_no` varchar(50) NOT NULL,
  `amount` decimal(16,2) NOT NULL,
  `user_id` int(10) NOT NULL,
  `create_time` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  `auditor_id` int(10) DEFAULT NULL,
  `auditor_name` varchar(30) DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `refuse_reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `rel_admin_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `rel_admin_user_role`;
CREATE TABLE `rel_admin_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_user_id` int(10) DEFAULT NULL,
  `admin_role_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rel_admin_user_role
-- ----------------------------
INSERT INTO `rel_admin_user_role` VALUES ('8', '1', '8');

-- ----------------------------
-- Table structure for `rel_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_menu`;
CREATE TABLE `rel_role_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleid` int(10) DEFAULT NULL,
  `menuid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rel_role_menu
-- ----------------------------
INSERT INTO `rel_role_menu` VALUES ('1', '8', '19');
INSERT INTO `rel_role_menu` VALUES ('2', '8', '1');
INSERT INTO `rel_role_menu` VALUES ('3', '8', '2');
INSERT INTO `rel_role_menu` VALUES ('4', '8', '9');
INSERT INTO `rel_role_menu` VALUES ('5', '8', '10');
INSERT INTO `rel_role_menu` VALUES ('6', '8', '11');
INSERT INTO `rel_role_menu` VALUES ('7', '8', '12');
INSERT INTO `rel_role_menu` VALUES ('8', '8', '3');
INSERT INTO `rel_role_menu` VALUES ('9', '8', '13');
INSERT INTO `rel_role_menu` VALUES ('10', '8', '14');
INSERT INTO `rel_role_menu` VALUES ('11', '8', '15');
INSERT INTO `rel_role_menu` VALUES ('12', '8', '16');
INSERT INTO `rel_role_menu` VALUES ('13', '8', '17');
INSERT INTO `rel_role_menu` VALUES ('14', '8', '4');
INSERT INTO `rel_role_menu` VALUES ('15', '8', '5');
INSERT INTO `rel_role_menu` VALUES ('16', '8', '6');
INSERT INTO `rel_role_menu` VALUES ('17', '8', '7');
INSERT INTO `rel_role_menu` VALUES ('18', '8', '8');
INSERT INTO `rel_role_menu` VALUES ('19', '8', '18');
INSERT INTO `rel_role_menu` VALUES ('20', '10', '19');
INSERT INTO `rel_role_menu` VALUES ('21', '11', '19');
INSERT INTO `rel_role_menu` VALUES ('22', '12', '19');
INSERT INTO `rel_role_menu` VALUES ('23', '13', '19');
INSERT INTO `rel_role_menu` VALUES ('24', '14', '19');

-- ----------------------------
-- Table structure for `user_account`
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `current_balance` double(10,2) DEFAULT NULL,
  `current_rest_points` int(10) DEFAULT NULL,
  `locked_balance` double(10,2) DEFAULT NULL,
  `locked_points` int(10) DEFAULT NULL COMMENT '帐户表',
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_account
-- ----------------------------

-- ----------------------------
-- Table structure for `user_account_log`
-- ----------------------------
DROP TABLE IF EXISTS `user_account_log`;
CREATE TABLE `user_account_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `createTime` datetime NOT NULL,
  `user_id` int(10) NOT NULL,
  `type` varchar(30) NOT NULL,
  `amount` double(10,2) DEFAULT '0.00',
  `points` int(10) DEFAULT '0',
  `before_rest_amount` double(10,2) NOT NULL DEFAULT '0.00',
  `before_rest_points` int(10) NOT NULL DEFAULT '0',
  `before_locked_amount` double(10,2) NOT NULL DEFAULT '0.00',
  `before_locked_points` int(10) NOT NULL DEFAULT '0',
  `after_rest_amount` double(10,2) NOT NULL,
  `after_rest_points` int(10) NOT NULL DEFAULT '0',
  `after_locked_amount` double(10,2) NOT NULL,
  `after_locked_points` int(10) NOT NULL DEFAULT '0',
  `admin_user_id` int(10) DEFAULT NULL,
  `task_id` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_account_log
-- ----------------------------

-- ----------------------------
-- Table structure for `user_base`
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(36) NOT NULL,
  `regTime` datetime NOT NULL COMMENT '用户基本信息表',
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_base
-- ----------------------------
INSERT INTO `user_base` VALUES ('1', 'x1', 'ec6ef230f1828039ee794566b9c58adc', '2014-12-02 17:59:15', 'NORMAL');

-- ----------------------------
-- Table structure for `user_link`
-- ----------------------------
DROP TABLE IF EXISTS `user_link`;
CREATE TABLE `user_link` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `link_type` varchar(30) NOT NULL,
  `link_value` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_link
-- ----------------------------
