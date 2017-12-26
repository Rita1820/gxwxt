/*
Navicat MySQL Data Transfer

Source Server         : MySQL5.1
Source Server Version : 50145
Source Host           : localhost:3306
Source Database       : db_gxwxt

Target Server Type    : MYSQL
Target Server Version : 50145
File Encoding         : 65001

Date: 2017-09-07 15:45:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(77) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');
INSERT INTO `t_admin` VALUES ('2', 'admin', 'admin');
select * from `t_admin`;
-- ----------------------------
-- Table structure for `t_banji`
-- ----------------------------
DROP TABLE IF EXISTS `t_banji`;
CREATE TABLE `t_banji` (
  `id` int(11) NOT NULL DEFAULT '0',
  `mingcheng` varchar(255) DEFAULT NULL,
  `banzhuren` varchar(255) DEFAULT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `loginpw` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_banji
-- ----------------------------
INSERT INTO `t_banji` VALUES ('4', '计算机专业', '', '', '', 'no');
INSERT INTO `t_banji` VALUES ('5', '国际贸易', '', '', '', 'no');
INSERT INTO `t_banji` VALUES ('6', '软件工程', null, null, null, 'no');

-- ----------------------------
-- Table structure for `t_chengji`
-- ----------------------------
DROP TABLE IF EXISTS `t_chengji`;
CREATE TABLE `t_chengji` (
  `id` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) DEFAULT NULL,
  `kechengId` int(255) DEFAULT NULL,
  `xueqi` varchar(200) DEFAULT NULL,
  `fenshu` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_chengji
-- ----------------------------
INSERT INTO `t_chengji` VALUES ('1', '6', '1', '2018上学期', '80');
INSERT INTO `t_chengji` VALUES ('2', '7', '1', '2018上学期', '88');
INSERT INTO `t_chengji` VALUES ('3', '6', '2', '2018上学期', '90');
INSERT INTO `t_chengji` VALUES ('4', '9', '3', '2017下学期', '98');

-- ----------------------------
-- Table structure for `t_gonggao`
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao` (
  `gonggao_id` int(11) NOT NULL,
  `gonggao_title` varchar(50) DEFAULT NULL,
  `gonggao_content` varchar(5000) DEFAULT NULL,
  `gonggao_data` varchar(77) DEFAULT NULL,
  PRIMARY KEY (`gonggao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gonggao
-- ----------------------------
INSERT INTO `t_gonggao` VALUES ('1', '测试阿通知公告测试阿通知公告测试阿通知公告', '测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告测试阿通知公告', '2017-09-28 02:22');
INSERT INTO `t_gonggao` VALUES ('2', '教务管理系统欢迎大家使用', '&nbsp;教务管理系统欢迎大家使用', '2017-09-07 15:02');
INSERT INTO `t_gonggao` VALUES ('3', '大家好。。', '大家好。。', '2017-09-07 15:36');

-- ----------------------------
-- Table structure for `t_kecheng`
-- ----------------------------
DROP TABLE IF EXISTS `t_kecheng`;
CREATE TABLE `t_kecheng` (
  `id` int(11) NOT NULL DEFAULT '0',
  `mingcheng` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kecheng
-- ----------------------------
INSERT INTO `t_kecheng` VALUES ('1', '大学英语', 'no');
INSERT INTO `t_kecheng` VALUES ('2', '高等数学', 'no');
INSERT INTO `t_kecheng` VALUES ('3', 'Java程序设计', 'no');

-- ----------------------------
-- Table structure for `t_laoshi`
-- ----------------------------
DROP TABLE IF EXISTS `t_laoshi`;
CREATE TABLE `t_laoshi` (
  `id` int(11) NOT NULL,
  `bianhao` varchar(55) DEFAULT NULL,
  `xingming` varchar(55) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `nianling` varchar(50) DEFAULT NULL,
  `loginpw` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_laoshi
-- ----------------------------
INSERT INTO `t_laoshi` VALUES ('1', '0001', '陈发局', '男', '45', '000000', 'no');
INSERT INTO `t_laoshi` VALUES ('2', '0002', '李强强', '男', '45', '000000', 'no');
INSERT INTO `t_laoshi` VALUES ('3', '80001', '李老师', '男', '23', '000000', 'no');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `banjiId` int(255) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_pw` varchar(50) DEFAULT NULL,
  `user_realname` varchar(77) DEFAULT NULL,
  `user_sex` varchar(50) DEFAULT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  `user_del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('6', '4', '2016001', '000000', '刘三', '男', '北京', '13555555555', 'no');
INSERT INTO `t_user` VALUES ('7', '4', '2016002', '000000', '李强', '男', '上海', '13666666666', 'no');
INSERT INTO `t_user` VALUES ('8', '4', '2016003', '000000', '王刚', '男', '重庆', '13777777777', 'no');
INSERT INTO `t_user` VALUES ('9', '4', '90001', '000000', '查都', '男', '辽宁', '13813812345', 'no');
INSERT INTO `t_user` VALUES ('10', '4', '90001', '000000', 'zty', '男', '山西', '15621011111', 'no');