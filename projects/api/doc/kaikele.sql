/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : localhost
 Source Database       : kaike

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : utf-8

 Date: 07/22/2016 10:58:18 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '课程标题',
  `course_code` varchar(50) NOT NULL DEFAULT '' COMMENT '课程码',
  `desc` text COMMENT '课程描述',
  `cover` varchar(255) NOT NULL DEFAULT '' COMMENT '课程封面',
  `lesson_number` varchar(10) NOT NULL DEFAULT 0 COMMENT '课节数',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '课程价格',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `status` varchar(10) NOT NULL DEFAULT 'true' COMMENT '状态,true:上架 , false:下架',
  `url` varchar(255) DEFAULT NULL COMMENT '(音频,视频,课件,程序)地址',
  `qr_code` varchar(255) DEFAULT NULL COMMENT '课程二维码',
  `template_id` int(11) NOT NULL DEFAULT 0 COMMENT '模板id',
  `open_date` VARCHAR(50) NULL DEFAULT NULL COMMENT '开课日期',
  `create_at` timestamp NULL DEFAULT NULL,
  `update_up` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='课程信息表';

-- ----------------------------
--  Table structure for `template`
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '模板名称',
  `desc` text COMMENT '模板描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='课程模板信息表';

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '会员名字',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '头像',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `create_at` timestamp NULL DEFAULT NULL,
  `update_up` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
--  Table structure for `user_course`
-- ----------------------------
DROP TABLE IF EXISTS `user_course`;
CREATE TABLE `user_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `course_id` int(11) NOT NULL DEFAULT 0 COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户课程关联表';

SET FOREIGN_KEY_CHECKS = 1;
