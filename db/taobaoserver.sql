/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : taobaoserver

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2015-01-17 17:26:42
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
  `isbutton` int(1) DEFAULT '0',
  `btnflag` varchar(64) DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

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
INSERT INTO `admin_menu` VALUES ('19', '账单管理', '', null, '0', '', '0');
INSERT INTO `admin_menu` VALUES ('20', '充值管理', '/admin/deposit', null, '0', '', '19');
INSERT INTO `admin_menu` VALUES ('21', '取款管理', '/admin/applydraw', null, '0', '', '19');
INSERT INTO `admin_menu` VALUES ('22', '取款分页查询', '/admin/applydraw/dopage', null, '1', 'admin_applydraw_dopage', '21');
INSERT INTO `admin_menu` VALUES ('23', '充值管理分页查询', '/admin/deposit/dopage', null, '1', 'admin_deposit_dopage', '20');
INSERT INTO `admin_menu` VALUES ('24', '取款拒绝', '/admin/applydraw/doarefuse', null, '1', 'admin_applydraw_doarefuse', '21');
INSERT INTO `admin_menu` VALUES ('25', '取款同意', '/admin/applydraw/doagree', null, '1', 'admin_applydraw_doagree', '21');
INSERT INTO `admin_menu` VALUES ('26', '充值同意', '/admin/deposit/doagree', null, '1', 'admin_deposit_doagree', '20');
INSERT INTO `admin_menu` VALUES ('27', '充值拒绝', '/admin/deposit/doarefuse', null, '1', 'admin_deposit_doarefuse', '20');
INSERT INTO `admin_menu` VALUES ('28', '前台用户管理', '/admin/siteuser', null, '0', '', '29');
INSERT INTO `admin_menu` VALUES ('29', '用户列表', '/admin/siteuser', null, '0', '', '0');
INSERT INTO `admin_menu` VALUES ('30', '前台用户分页查看', '/admin/siteuser/dopage', null, '1', 'admin_siteuser_dopage', '28');
INSERT INTO `admin_menu` VALUES ('32', '设置赞助用户点数', '/admin/siteuser/supplypoint', null, '1', 'admin_siteuser_supplypoint', '28');
INSERT INTO `admin_menu` VALUES ('33', '任务管理', '', null, '0', '', '0');
INSERT INTO `admin_menu` VALUES ('34', '已结束的任务', '/admin/task/haveclose', null, '0', '', '33');
INSERT INTO `admin_menu` VALUES ('35', '未结束的任务', '/admin/task/noclose', null, '0', '', '33');
INSERT INTO `admin_menu` VALUES ('36', '已完成的任务分页查看', '/admin/task/haveclose/dopage', null, '1', 'admin_task_haveclose_dopage', '34');
INSERT INTO `admin_menu` VALUES ('37', '未结束的任务分页查看', '/admin/task/noclose/dopage', null, '1', 'admin_task_noclose_dopage', '35');
INSERT INTO `admin_menu` VALUES ('38', '新建任务', '/admin/task/create', null, '0', '', '33');
INSERT INTO `admin_menu` VALUES ('39', '赞助用户记录', '/admin/log/COMPANY_SUPPLY', null, '0', '', '19');
INSERT INTO `admin_menu` VALUES ('40', '赞助用户记录分页', '/admin/log/dopage/COMPANY_SUPPLY', null, '1', 'admin_log_dopage_COMPANY_SUPPLY', '39');
INSERT INTO `admin_menu` VALUES ('41', '公司收支情况', '/admin/company_account/get', null, '0', '', '19');
INSERT INTO `admin_menu` VALUES ('42', '营销管理', '', null, '0', '', '0');
INSERT INTO `admin_menu` VALUES ('43', '邮件邮箱系统', '', null, '0', '', '42');
INSERT INTO `admin_menu` VALUES ('44', '邮箱模板管理', '/admin/mail/templete', null, '0', '', '43');
INSERT INTO `admin_menu` VALUES ('45', '邮件管理', '/admin/mail/content', null, '0', '', '43');
INSERT INTO `admin_menu` VALUES ('46', '创建邮件模板', '/admin/mail/templete/doadd', null, '1', 'admin_mail_templete_doadd', '44');
INSERT INTO `admin_menu` VALUES ('47', '修改邮件模板', '/admin/mail/templete/doupdate', null, '1', 'admin_mail_templete_doupdate', '44');
INSERT INTO `admin_menu` VALUES ('48', '删除邮件模板', '/admin/mail/templete/dodel', null, '1', 'admin_mail_templete_dodel', '44');
INSERT INTO `admin_menu` VALUES ('49', '分页查看邮件模板', '/admin/mail/templete/dopage', null, '1', 'admin_mail_templete_dopage', '44');
INSERT INTO `admin_menu` VALUES ('50', '分页查看邮件内容', '/admin/mail/content/dopage', null, '1', 'admin_mail_content_dopage', '45');
INSERT INTO `admin_menu` VALUES ('51', '增加邮件', '/admin/mail/content/doadd', null, '1', 'admin_mail_content_doadd', '45');
INSERT INTO `admin_menu` VALUES ('52', '修改邮件内容', '/admin/mail/content/doupdate', null, '1', 'admin_mail_content_doupdate', '45');
INSERT INTO `admin_menu` VALUES ('53', '删除邮件内容', '/admin/mail/content/dodel', null, '1', 'admin_mail_content_dodel', '45');
INSERT INTO `admin_menu` VALUES ('54', '查看邮件详情', '/admin/mail/content/get', null, '1', 'admin_mail_content_get', '45');
INSERT INTO `admin_menu` VALUES ('55', '查看邮件模板详情', '/admin/mail/templete/get', null, '1', 'admin_mail_templete_get', '44');
INSERT INTO `admin_menu` VALUES ('56', '工具箱', '', null, '0', '', '0');
INSERT INTO `admin_menu` VALUES ('57', '图片库', '/admin/tool/pics', null, '0', '', '56');
INSERT INTO `admin_menu` VALUES ('58', '分页查看图片', '/admin/tool/pics/dopage', null, '1', 'admin_tool_pics_dopage', '57');
INSERT INTO `admin_menu` VALUES ('59', '上传图片', '/admin/tool/pics/upload', null, '1', 'admin_tool_pics_upload', '57');
INSERT INTO `admin_menu` VALUES ('60', '删除图片', '/admin/tool/pics/dodel', null, '1', 'admin_tool_pics_del', '57');
INSERT INTO `admin_menu` VALUES ('61', '通讯录管理', '/admin/mail/addresslist', null, '0', '', '43');
INSERT INTO `admin_menu` VALUES ('62', '分页查看通讯录', '/admin/mail/addresslist/dopage', null, '1', 'admin_mail_addresslist_dopage', '61');
INSERT INTO `admin_menu` VALUES ('65', '增加通讯录联系人', '/admin/mail/addresslist/doadd', null, '1', 'admin_mail_addresslist_doadd', '61');
INSERT INTO `admin_menu` VALUES ('66', '修改通讯录联系人', '/admin/mail/addresslist/doupdate', null, '1', 'admin_mail_addresslist_doupdate', '61');
INSERT INTO `admin_menu` VALUES ('67', '删除通讯录联系人', '/admin/mail/addresslist/dodel', null, '1', 'admin_mail_addresslist_dodel', '61');

-- ----------------------------
-- Table structure for `admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

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
INSERT INTO `admin_role` VALUES ('15', '财务管理', '1');

-- ----------------------------
-- Table structure for `admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `real_name` varchar(60) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', '01jiangwei01', '96e79218965eb72c92a549dd5a330112', '管理员', '1');

-- ----------------------------
-- Table structure for `apply_draw`
-- ----------------------------
DROP TABLE IF EXISTS `apply_draw`;
CREATE TABLE `apply_draw` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `third_order_no` varchar(50) DEFAULT NULL,
  `amount` decimal(16,2) NOT NULL,
  `user_id` int(10) NOT NULL,
  `create_time` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  `auditor_id` int(10) DEFAULT NULL,
  `auditor_name` varchar(30) DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `refuse_reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply_draw
-- ----------------------------
INSERT INTO `apply_draw` VALUES ('1', '', '1.00', '1', '2014-12-03 21:57:32', 'REFUSE', '1', '管理员', '2014-12-06 08:51:47', '1111');
INSERT INTO `apply_draw` VALUES ('2', '1', '1.00', '1', '2014-12-06 09:20:08', 'APPROVE', '1', '管理员', '2014-12-06 09:42:38', null);
INSERT INTO `apply_draw` VALUES ('3', null, '1.00', '1', '2014-12-06 09:44:14', 'REFUSE', '1', '管理员', '2014-12-06 09:54:29', '1111');

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
-- Table structure for `company_account`
-- ----------------------------
DROP TABLE IF EXISTS `company_account`;
CREATE TABLE `company_account` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sell_points` double(10,2) NOT NULL,
  `get_points` double(10,2) NOT NULL,
  `supply_points` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_account
-- ----------------------------
INSERT INTO `company_account` VALUES ('1', '0.00', '0.00', '4.00');

-- ----------------------------
-- Table structure for `deposit_apply`
-- ----------------------------
DROP TABLE IF EXISTS `deposit_apply`;
CREATE TABLE `deposit_apply` (
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit_apply
-- ----------------------------
INSERT INTO `deposit_apply` VALUES ('1', '1', '10.00', '1', '2014-12-05 23:13:53', 'APPROVE', '1', '管理员', '2014-12-05 23:21:38', null);
INSERT INTO `deposit_apply` VALUES ('2', '1', '10.00', '1', '2014-12-05 23:22:14', 'REFUSE', '1', '管理员', '2014-12-05 23:38:49', 'ffffffffffff');
INSERT INTO `deposit_apply` VALUES ('3', '1', '10.00', '1', '2014-12-06 08:19:24', 'REFUSE', '1', '管理员', '2014-12-06 08:35:13', '111');
INSERT INTO `deposit_apply` VALUES ('4', '2', '10.00', '1', '2014-12-06 08:35:34', 'APPROVE', '1', '管理员', '2014-12-06 08:38:03', null);

-- ----------------------------
-- Table structure for `log4j_log`
-- ----------------------------
DROP TABLE IF EXISTS `log4j_log`;
CREATE TABLE `log4j_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(150) DEFAULT NULL,
  `method` varchar(150) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `loglevel` varchar(20) DEFAULT NULL,
  `logmsg` varchar(1024) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_type` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log4j_log
-- ----------------------------

-- ----------------------------
-- Table structure for `log_info`
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `log_type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_info
-- ----------------------------
INSERT INTO `log_info` VALUES ('1', '1', '2015-01-10 23:32:14', 'FIND_PASSWORD');
INSERT INTO `log_info` VALUES ('2', '1', '2015-01-11 16:05:44', 'FIND_PASSWORD');
INSERT INTO `log_info` VALUES ('3', '1', '2015-01-12 11:15:34', 'FIND_PASSWORD');

-- ----------------------------
-- Table structure for `mail_address_list`
-- ----------------------------
DROP TABLE IF EXISTS `mail_address_list`;
CREATE TABLE `mail_address_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` varchar(30) NOT NULL,
  `create_user_id` int(11) NOT NULL,
  `crete_time` datetime NOT NULL,
  `come_from` varchar(50) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail_address_list
-- ----------------------------
INSERT INTO `mail_address_list` VALUES ('1', 'xu', '01jiangwei01@163.com', 'DEL', '1', '2015-01-17 17:12:04', 'QQ', 'male');
INSERT INTO `mail_address_list` VALUES ('2', '1', '01jiangwei01@163.com', 'NORMAL', '1', '2015-01-17 17:25:36', 'QQ', 'female');
INSERT INTO `mail_address_list` VALUES ('3', '12', 'ee@163.com', 'NORMAL', '1', '2015-01-17 17:07:46', 'QQ', 'male');

-- ----------------------------
-- Table structure for `mail_content`
-- ----------------------------
DROP TABLE IF EXISTS `mail_content`;
CREATE TABLE `mail_content` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `templete_id` int(10) NOT NULL,
  `content` longtext,
  `title` varchar(100) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `status` varchar(50) NOT NULL,
  `updateUserId` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail_content
-- ----------------------------
INSERT INTO `mail_content` VALUES ('1', '1', '内容1', '标题1-1', '2014-12-24 19:23:02', 'DELETE', '1');
INSERT INTO `mail_content` VALUES ('2', '1', '内容2', '标题2-1', '2014-12-24 19:43:50', 'DELETE', '1');
INSERT INTO `mail_content` VALUES ('3', '1', '<p>内容3<img alt=\"\" src=\"http://001taobaoservice.oss-cn-beijing.aliyuncs.com/img/20150116174648995.jpg\" style=\"height:911px; width:610px\" /></p>\n', '标题3', '2015-01-16 17:49:46', 'NORMAL', '1');
INSERT INTO `mail_content` VALUES ('4', '1', '<p>内容5555</p>\n', '标题4', '2015-01-06 18:52:58', 'NORMAL', '1');
INSERT INTO `mail_content` VALUES ('5', '1', '<p>欢迎注册聚来宝</p>\n', '聚来宝注册', '2015-01-06 18:53:13', 'NORMAL', '1');

-- ----------------------------
-- Table structure for `mail_templete`
-- ----------------------------
DROP TABLE IF EXISTS `mail_templete`;
CREATE TABLE `mail_templete` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `templete_name` varchar(100) NOT NULL,
  `templete_path` varchar(100) NOT NULL,
  `update_time` datetime NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `updateUserId` int(10) DEFAULT NULL,
  `templete_type` varchar(100) DEFAULT NULL,
  `templete_desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail_templete
-- ----------------------------
INSERT INTO `mail_templete` VALUES ('1', '测试模板', '/templete/mail/v1', '2015-01-06 13:44:31', 'NORMAL', '1', 'JU_LAI_BAO_TUI_GUANG_V1', '1');
INSERT INTO `mail_templete` VALUES ('2', '模板2', '/admin/123233', '2014-12-24 19:44:25', 'DELETE', '1', null, null);

-- ----------------------------
-- Table structure for `notifications`
-- ----------------------------
DROP TABLE IF EXISTS `notifications`;
CREATE TABLE `notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notifications
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
  `ip` varchar(30) DEFAULT NULL,
  `isused` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate_log
-- ----------------------------
INSERT INTO `operate_log` VALUES ('1', '1', '2014-12-06 21:12:28', 'SET_SUPPLY_MONEY', '0', '50', null, '0');
INSERT INTO `operate_log` VALUES ('2', '1', '2014-12-06 21:14:39', 'SET_SUPPLY_MONEY', '50', '50', null, '0');
INSERT INTO `operate_log` VALUES ('3', '1', '2014-12-06 21:22:04', 'SET_SUPPLY_MONEY', '50', '50', null, '0');
INSERT INTO `operate_log` VALUES ('4', '1', '2014-12-06 21:22:08', 'SET_SUPPLY_MONEY', '50', '50', null, '0');
INSERT INTO `operate_log` VALUES ('5', '1', '2014-12-06 21:22:09', 'SET_SUPPLY_MONEY', '50', '50', null, '0');
INSERT INTO `operate_log` VALUES ('6', '1', '2014-12-06 21:30:49', 'SET_SUPPLY_MONEY', '50', '49', null, '0');
INSERT INTO `operate_log` VALUES ('7', '1', '2014-12-06 21:30:55', 'SET_SUPPLY_MONEY', '49', '0', null, '0');
INSERT INTO `operate_log` VALUES ('8', '1', '2014-12-06 21:35:15', 'SET_SUPPLY_MONEY', '0', '21', null, '0');
INSERT INTO `operate_log` VALUES ('9', '1', '2014-12-06 21:35:18', 'SET_SUPPLY_MONEY', '21', '0', null, '0');

-- ----------------------------
-- Table structure for `pics`
-- ----------------------------
DROP TABLE IF EXISTS `pics`;
CREATE TABLE `pics` (
  `id` int(11) NOT NULL DEFAULT '0',
  `pic_path` varchar(200) NOT NULL,
  `status` varchar(20) NOT NULL,
  `pic_name` varchar(100) NOT NULL,
  `pic_desc` varchar(400) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pics
-- ----------------------------
INSERT INTO `pics` VALUES ('3', 'http://001taobaoservice.oss-cn-beijing.aliyuncs.com/img/20150116174648995.jpg', 'NORMAL', '阿里测试', '阿里测试', '2015-01-16 17:46:49', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rel_role_menu
-- ----------------------------
INSERT INTO `rel_role_menu` VALUES ('20', '10', '19');
INSERT INTO `rel_role_menu` VALUES ('21', '11', '19');
INSERT INTO `rel_role_menu` VALUES ('22', '12', '19');
INSERT INTO `rel_role_menu` VALUES ('23', '13', '19');
INSERT INTO `rel_role_menu` VALUES ('24', '14', '19');
INSERT INTO `rel_role_menu` VALUES ('131', '9', '19');
INSERT INTO `rel_role_menu` VALUES ('132', '9', '20');
INSERT INTO `rel_role_menu` VALUES ('133', '9', '23');
INSERT INTO `rel_role_menu` VALUES ('134', '9', '26');
INSERT INTO `rel_role_menu` VALUES ('135', '9', '27');
INSERT INTO `rel_role_menu` VALUES ('136', '9', '21');
INSERT INTO `rel_role_menu` VALUES ('137', '9', '22');
INSERT INTO `rel_role_menu` VALUES ('138', '9', '24');
INSERT INTO `rel_role_menu` VALUES ('139', '9', '25');
INSERT INTO `rel_role_menu` VALUES ('140', '9', '1');
INSERT INTO `rel_role_menu` VALUES ('141', '9', '2');
INSERT INTO `rel_role_menu` VALUES ('142', '9', '9');
INSERT INTO `rel_role_menu` VALUES ('143', '9', '10');
INSERT INTO `rel_role_menu` VALUES ('144', '9', '11');
INSERT INTO `rel_role_menu` VALUES ('145', '9', '12');
INSERT INTO `rel_role_menu` VALUES ('146', '9', '3');
INSERT INTO `rel_role_menu` VALUES ('147', '9', '13');
INSERT INTO `rel_role_menu` VALUES ('148', '9', '14');
INSERT INTO `rel_role_menu` VALUES ('149', '9', '15');
INSERT INTO `rel_role_menu` VALUES ('150', '9', '16');
INSERT INTO `rel_role_menu` VALUES ('151', '9', '17');
INSERT INTO `rel_role_menu` VALUES ('152', '9', '4');
INSERT INTO `rel_role_menu` VALUES ('153', '9', '5');
INSERT INTO `rel_role_menu` VALUES ('154', '9', '6');
INSERT INTO `rel_role_menu` VALUES ('155', '9', '7');
INSERT INTO `rel_role_menu` VALUES ('156', '9', '8');
INSERT INTO `rel_role_menu` VALUES ('157', '9', '18');
INSERT INTO `rel_role_menu` VALUES ('158', '15', '19');
INSERT INTO `rel_role_menu` VALUES ('159', '15', '20');
INSERT INTO `rel_role_menu` VALUES ('160', '15', '23');
INSERT INTO `rel_role_menu` VALUES ('161', '15', '26');
INSERT INTO `rel_role_menu` VALUES ('162', '15', '27');
INSERT INTO `rel_role_menu` VALUES ('163', '15', '21');
INSERT INTO `rel_role_menu` VALUES ('164', '15', '22');
INSERT INTO `rel_role_menu` VALUES ('165', '15', '24');
INSERT INTO `rel_role_menu` VALUES ('166', '15', '25');
INSERT INTO `rel_role_menu` VALUES ('167', '8', '19');
INSERT INTO `rel_role_menu` VALUES ('168', '8', '20');
INSERT INTO `rel_role_menu` VALUES ('169', '8', '23');
INSERT INTO `rel_role_menu` VALUES ('170', '8', '26');
INSERT INTO `rel_role_menu` VALUES ('171', '8', '27');
INSERT INTO `rel_role_menu` VALUES ('172', '8', '21');
INSERT INTO `rel_role_menu` VALUES ('173', '8', '22');
INSERT INTO `rel_role_menu` VALUES ('174', '8', '24');
INSERT INTO `rel_role_menu` VALUES ('175', '8', '25');
INSERT INTO `rel_role_menu` VALUES ('176', '8', '39');
INSERT INTO `rel_role_menu` VALUES ('177', '8', '40');
INSERT INTO `rel_role_menu` VALUES ('178', '8', '41');
INSERT INTO `rel_role_menu` VALUES ('179', '8', '29');
INSERT INTO `rel_role_menu` VALUES ('180', '8', '28');
INSERT INTO `rel_role_menu` VALUES ('181', '8', '30');
INSERT INTO `rel_role_menu` VALUES ('182', '8', '32');
INSERT INTO `rel_role_menu` VALUES ('183', '8', '33');
INSERT INTO `rel_role_menu` VALUES ('184', '8', '34');
INSERT INTO `rel_role_menu` VALUES ('185', '8', '36');
INSERT INTO `rel_role_menu` VALUES ('186', '8', '35');
INSERT INTO `rel_role_menu` VALUES ('187', '8', '37');
INSERT INTO `rel_role_menu` VALUES ('188', '8', '38');
INSERT INTO `rel_role_menu` VALUES ('189', '8', '42');
INSERT INTO `rel_role_menu` VALUES ('190', '8', '43');
INSERT INTO `rel_role_menu` VALUES ('191', '8', '44');
INSERT INTO `rel_role_menu` VALUES ('192', '8', '46');
INSERT INTO `rel_role_menu` VALUES ('193', '8', '47');
INSERT INTO `rel_role_menu` VALUES ('194', '8', '48');
INSERT INTO `rel_role_menu` VALUES ('195', '8', '49');
INSERT INTO `rel_role_menu` VALUES ('196', '8', '55');
INSERT INTO `rel_role_menu` VALUES ('197', '8', '45');
INSERT INTO `rel_role_menu` VALUES ('198', '8', '50');
INSERT INTO `rel_role_menu` VALUES ('199', '8', '51');
INSERT INTO `rel_role_menu` VALUES ('200', '8', '52');
INSERT INTO `rel_role_menu` VALUES ('201', '8', '53');
INSERT INTO `rel_role_menu` VALUES ('202', '8', '54');
INSERT INTO `rel_role_menu` VALUES ('203', '8', '61');
INSERT INTO `rel_role_menu` VALUES ('204', '8', '62');
INSERT INTO `rel_role_menu` VALUES ('205', '8', '65');
INSERT INTO `rel_role_menu` VALUES ('206', '8', '66');
INSERT INTO `rel_role_menu` VALUES ('207', '8', '67');
INSERT INTO `rel_role_menu` VALUES ('208', '8', '56');
INSERT INTO `rel_role_menu` VALUES ('209', '8', '57');
INSERT INTO `rel_role_menu` VALUES ('210', '8', '58');
INSERT INTO `rel_role_menu` VALUES ('211', '8', '59');
INSERT INTO `rel_role_menu` VALUES ('212', '8', '60');
INSERT INTO `rel_role_menu` VALUES ('213', '8', '1');
INSERT INTO `rel_role_menu` VALUES ('214', '8', '2');
INSERT INTO `rel_role_menu` VALUES ('215', '8', '9');
INSERT INTO `rel_role_menu` VALUES ('216', '8', '10');
INSERT INTO `rel_role_menu` VALUES ('217', '8', '11');
INSERT INTO `rel_role_menu` VALUES ('218', '8', '12');
INSERT INTO `rel_role_menu` VALUES ('219', '8', '3');
INSERT INTO `rel_role_menu` VALUES ('220', '8', '13');
INSERT INTO `rel_role_menu` VALUES ('221', '8', '14');
INSERT INTO `rel_role_menu` VALUES ('222', '8', '15');
INSERT INTO `rel_role_menu` VALUES ('223', '8', '16');
INSERT INTO `rel_role_menu` VALUES ('224', '8', '17');
INSERT INTO `rel_role_menu` VALUES ('225', '8', '4');
INSERT INTO `rel_role_menu` VALUES ('226', '8', '5');
INSERT INTO `rel_role_menu` VALUES ('227', '8', '6');
INSERT INTO `rel_role_menu` VALUES ('228', '8', '7');
INSERT INTO `rel_role_menu` VALUES ('229', '8', '8');
INSERT INTO `rel_role_menu` VALUES ('230', '8', '18');

-- ----------------------------
-- Table structure for `task_appreciation`
-- ----------------------------
DROP TABLE IF EXISTS `task_appreciation`;
CREATE TABLE `task_appreciation` (
  `id` int(10) NOT NULL,
  `task_order_id` int(10) NOT NULL,
  `task_title` varchar(100) NOT NULL,
  `need_dot` double(10,2) NOT NULL,
  `type` varchar(30) NOT NULL,
  `task_desc` varchar(100) NOT NULL,
  `benefit_type` varchar(30) NOT NULL,
  `task_value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_appreciation
-- ----------------------------

-- ----------------------------
-- Table structure for `task_basic`
-- ----------------------------
DROP TABLE IF EXISTS `task_basic`;
CREATE TABLE `task_basic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `create_time` datetime NOT NULL,
  `taobao_xiaohao` varchar(50) NOT NULL,
  `user_qq` varchar(255) NOT NULL,
  `product_link` varchar(500) NOT NULL,
  `product_title` varchar(100) NOT NULL,
  `pay_method` int(10) NOT NULL,
  `guarantee_price` double(10,2) NOT NULL,
  `basic_publish_dot` double(10,2) NOT NULL,
  `task_type` varchar(20) NOT NULL,
  `good_comment` varchar(500) NOT NULL,
  `good_comment_time_limit` varchar(255) NOT NULL,
  `good_comment_time_dot` double(10,2) NOT NULL,
  `zengzhi_receiver_gain_points` double(11,2) NOT NULL,
  `zengzhi_pingtai_gain_points` double(11,2) NOT NULL,
  `basic_receiver_gain_point` double(11,2) NOT NULL,
  `basic_pingtai_gain_point` double(11,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_basic
-- ----------------------------

-- ----------------------------
-- Table structure for `task_order`
-- ----------------------------
DROP TABLE IF EXISTS `task_order`;
CREATE TABLE `task_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `create_time` datetime NOT NULL,
  `taobao_xiaohao` varchar(50) NOT NULL,
  `user_qq` varchar(255) NOT NULL,
  `product_link` varchar(500) NOT NULL,
  `product_title` varchar(100) NOT NULL,
  `pay_method` int(10) NOT NULL,
  `guarantee_price` double(10,2) NOT NULL,
  `basic_publish_dot` double(10,2) NOT NULL,
  `task_type` varchar(20) NOT NULL,
  `good_comment` varchar(500) NOT NULL,
  `good_comment_time_limit` varchar(255) NOT NULL,
  `good_comment_time_dot` double(10,2) NOT NULL,
  `zengzhi_receiver_gain_points` double(11,2) NOT NULL,
  `zengzhi_pingtai_gain_points` double(11,2) NOT NULL,
  `basic_receiver_gain_point` double(11,2) NOT NULL,
  `basic_pingtai_gain_point` double(11,2) NOT NULL,
  `status` varchar(20) NOT NULL,
  `repeate_times` int(10) NOT NULL,
  `remuneration` double(11,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_order
-- ----------------------------

-- ----------------------------
-- Table structure for `user_account`
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `current_balance` double(10,2) DEFAULT NULL,
  `current_rest_points` double(10,2) DEFAULT NULL,
  `locked_balance` double(10,2) DEFAULT NULL,
  `locked_points` double(10,2) DEFAULT NULL COMMENT '帐户表',
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES ('1', '19.00', '4.00', '0.00', '0.00', '1');

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
  `points` double(10,2) DEFAULT '0.00',
  `before_rest_amount` double(10,2) NOT NULL DEFAULT '0.00',
  `before_rest_points` double(10,2) NOT NULL DEFAULT '0.00',
  `before_locked_amount` double(10,2) NOT NULL DEFAULT '0.00',
  `before_locked_points` double(10,2) NOT NULL DEFAULT '0.00',
  `after_rest_amount` double(10,2) NOT NULL,
  `after_rest_points` double(10,2) NOT NULL DEFAULT '0.00',
  `after_locked_amount` double(10,2) NOT NULL,
  `after_locked_points` double(10,2) NOT NULL DEFAULT '0.00',
  `admin_user_id` int(10) DEFAULT NULL,
  `task_id` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_account_log
-- ----------------------------
INSERT INTO `user_account_log` VALUES ('1', '2014-12-05 23:21:38', '1', 'RECHARGE', '10.00', '0.00', '0.00', '0.00', '0.00', '0.00', '10.00', '0.00', '0.00', '0.00', '1', null);
INSERT INTO `user_account_log` VALUES ('2', '2014-12-06 08:38:03', '1', 'RECHARGE', '10.00', '0.00', '10.00', '0.00', '0.00', '0.00', '20.00', '0.00', '0.00', '0.00', '1', null);
INSERT INTO `user_account_log` VALUES ('3', '2014-12-06 09:42:38', '1', 'WITHDRAW', '1.00', '0.00', '20.00', '0.00', '0.00', '0.00', '19.00', '0.00', '0.00', '0.00', '1', null);
INSERT INTO `user_account_log` VALUES ('4', '2014-12-07 16:21:06', '1', 'COMPANY_SUPPLY', null, '1.00', '19.00', '0.00', '0.00', '0.00', '19.00', '1.00', '0.00', '0.00', '1', null);
INSERT INTO `user_account_log` VALUES ('5', '2014-12-07 16:22:44', '1', 'COMPANY_SUPPLY', null, '1.00', '19.00', '1.00', '0.00', '0.00', '19.00', '2.00', '0.00', '0.00', '1', null);
INSERT INTO `user_account_log` VALUES ('6', '2014-12-14 20:44:56', '1', 'COMPANY_SUPPLY', null, '1.00', '19.00', '2.00', '0.00', '0.00', '19.00', '3.00', '0.00', '0.00', '1', null);
INSERT INTO `user_account_log` VALUES ('7', '2014-12-14 20:48:03', '1', 'COMPANY_SUPPLY', null, '1.00', '19.00', '3.00', '0.00', '0.00', '19.00', '4.00', '0.00', '0.00', '1', null);

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
  `supply_money` double(2,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_base
-- ----------------------------
INSERT INTO `user_base` VALUES ('1', 'x1', '6dbf9ac2da09ee1d3debf5a51873ec6d', '2014-12-02 17:59:15', 'NORMAL', '0');

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

-- ----------------------------
-- Table structure for `valid_info`
-- ----------------------------
DROP TABLE IF EXISTS `valid_info`;
CREATE TABLE `valid_info` (
  `id` int(10) NOT NULL DEFAULT '0',
  `type` varchar(255) NOT NULL,
  `type_value` varchar(100) NOT NULL,
  `code` varchar(8) NOT NULL,
  `create_time` datetime NOT NULL,
  `invalid_time` datetime NOT NULL,
  `active_time` datetime DEFAULT NULL,
  `enabled` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of valid_info
-- ----------------------------
