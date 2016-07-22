-- Adminer 4.1.0 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `uuid` varchar(32) NOT NULL,
  `parent_uuid` varchar(32) DEFAULT NULL,
  `task_uuid` varchar(50) NOT NULL,
  `user_uuid` varchar(32) NOT NULL,
  `content` text,
  `project_uuid` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `comment` (`uuid`, `parent_uuid`, `task_uuid`, `user_uuid`, `content`, `project_uuid`, `create_time`) VALUES
('BD747828940644FFAC79A09E017DF622',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'111111',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:56:29'),
('E7C883018DAB456CAAFB1A6BBDC0FA73',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'33333333333333333333333333',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:56:34'),
('CD6D4DAD787447AE82399F5B54D95706',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'adfadfasdfasdf',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:56:38'),
('C71BDD70793745EF839B13708A640F1E',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'adfadfaf',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:56:45'),
('E8EBF14A0FD54A52ADDC9CAEF8D062C7',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'asdfadsfadf',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:56:47'),
('1504D4CACD9B4B6FBD20483064AEC66D',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'adfadfasdfasdf',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:56:51'),
('402016FD894141E3860766566EBE9F3B',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'你as打发打发你as打发打发你as打发打发你as打发打发',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:56:57'),
('44F9775A7EF34E00BC8CF1CA45544FEF',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:57:05'),
('4932EB69FB1C4BEAAB547AE273E9E220',	NULL,	'8085B43F3F174DCFAAFB20CAFE6549EA',	'1234567890',	'你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发\r\n你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发\r\n你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发你as打发打发',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-14 14:57:23');

DROP TABLE IF EXISTS `invite`;
CREATE TABLE `invite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `inviter_uuid` varchar(32) NOT NULL,
  `invitee_email` varchar(32) NOT NULL,
  `invitee_name` varchar(32) DEFAULT NULL,
  `invite_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `invite_overtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `project_uuid` varchar(32) NOT NULL,
  `is_valid` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `invite` (`id`, `code`, `inviter_uuid`, `invitee_email`, `invitee_name`, `invite_time`, `invite_overtime`, `project_uuid`, `is_valid`) VALUES
(2,	'679E8C36EA344B6D8AE5AFB5373F27CF',	'50285E3A7152489682B2E279DACBA992',	'12@q.com',	'123',	'2013-10-12 15:07:50',	'2013-10-13 15:07:50',	'4001EAB8A2F94062B9AA25F1173E0244',	1);

DROP TABLE IF EXISTS `invite_user`;
CREATE TABLE `invite_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `inviter_uuid` varchar(32) NOT NULL,
  `invitee_uuid` varchar(32) NOT NULL,
  `active_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `project_uuid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `invite_user` (`id`, `code`, `inviter_uuid`, `invitee_uuid`, `active_time`, `project_uuid`) VALUES
(8,	'679E8C36EA344B6D8AE5AFB5373F27CF',	'50285E3A7152489682B2E279DACBA992',	'542830E9F6A84322A0A25AE2BD8904F7',	'2013-10-12 15:22:24',	'4001EAB8A2F94062B9AA25F1173E0244');

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `uuid` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `parent_uuid` varchar(32) NOT NULL,
  `description` text,
  `create_uuid` varchar(32) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `project` (`uuid`, `name`, `parent_uuid`, `description`, `create_uuid`, `status`, `create_time`) VALUES
('4001EAB8A2F94062B9AA25F1173E0244',	'2',	'0',	'2',	'1234567890',	0,	'2013-09-14 15:29:48'),
('E2F22400B7534FC6BB998E2EDBE91FE4',	'23',	'0',	'23',	'1234567890',	0,	'2013-09-16 13:51:31'),
('10B116CFFAB74DB3BDAD745D0D22270A',	'89080',	'0',	NULL,	'1234567890',	0,	'2013-09-24 14:12:08'),
('523BD9D9D0454B2DA518BDCA71EFD669',	'312',	'0',	'31212',	'1234567890',	0,	'2013-09-24 14:28:09');

DROP TABLE IF EXISTS `project_tasklist`;
CREATE TABLE `project_tasklist` (
  `project_uuid` varchar(32) NOT NULL,
  `tasklist_uuid` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user` (
  `project_uuid` varchar(32) NOT NULL,
  `user_uuid` varchar(50) NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `project_user` (`project_uuid`, `user_uuid`, `is_admin`) VALUES
('4001EAB8A2F94062B9AA25F1173E0244',	'1234567890',	1),
('E2F22400B7534FC6BB998E2EDBE91FE4',	'1234567890',	1),
('10B116CFFAB74DB3BDAD745D0D22270A',	'1234567890',	1),
('1A954C5294434235BFC57848325B3E58',	'1234567890',	1),
('523BD9D9D0454B2DA518BDCA71EFD669',	'1234567890',	1),
('F5C57806924244EAAECDF0945141C8B6',	'1234567890',	1),
('4001EAB8A2F94062B9AA25F1173E0244',	'09876541',	0),
('4001EAB8A2F94062B9AA25F1173E0244',	'542830E9F6A84322A0A25AE2BD8904F7',	0);

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `uuid` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `content` text,
  `user_uuid` varchar(32) DEFAULT NULL,
  `creat_uuid` varchar(32) NOT NULL,
  `project_uuid` varchar(32) NOT NULL,
  `tasklist_uuid` varchar(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `assign_date` timestamp NULL DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `task` (`uuid`, `name`, `content`, `user_uuid`, `creat_uuid`, `project_uuid`, `tasklist_uuid`, `create_time`, `assign_date`, `status`) VALUES
('0A3A0623187D45FFA016F586671BC939',	'1111111111',	NULL,	'542830E9F6A84322A0A25AE2BD8904F7',	'1234567890',	'4001EAB8A2F94062B9AA25F1173E0244',	'A4567D02363241FE9D44EF94E1080E96',	'2013-10-16 14:02:08',	NULL,	1),
('C6796C8AA7D54545954CBDA5C1C60C3A',	'2222222222',	NULL,	'1234567890',	'1234567890',	'4001EAB8A2F94062B9AA25F1173E0244',	'A4567D02363241FE9D44EF94E1080E96',	'2013-10-16 14:02:10',	NULL,	1),
('6901FB6105B84E8BAE786239B8EA7A3E',	'33333333333',	NULL,	'1234567890',	'1234567890',	'4001EAB8A2F94062B9AA25F1173E0244',	NULL,	'2013-10-16 14:02:12',	NULL,	2),
('1B715673C595448EAB7873324D718AFB',	'444444444',	NULL,	'1234567890',	'1234567890',	'4001EAB8A2F94062B9AA25F1173E0244',	'A4567D02363241FE9D44EF94E1080E96',	'2013-10-16 14:02:13',	NULL,	1),
('FE1F7F4807FA42768EFCCE2BB4DF94D3',	'333333333',	NULL,	'09876541',	'09876541',	'4001EAB8A2F94062B9AA25F1173E0244',	'6522CEAD79324C7BBC4B650A57A535EE',	'2013-10-18 15:26:26',	NULL,	0);

DROP TABLE IF EXISTS `tasklist`;
CREATE TABLE `tasklist` (
  `uuid` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text,
  `creat_uuid` varchar(32) NOT NULL,
  `project_uuid` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `tasklist` (`uuid`, `name`, `description`, `creat_uuid`, `project_uuid`, `create_time`, `status`) VALUES
('DA5050FDD6FF432D9C2CE101D366E75D',	'12',	'12',	'1234567890',	'2',	'2013-09-14 15:34:13',	0),
('06D137FE2C964F66AD8FF68073240502',	'23',	'23',	'1234567890',	'2',	'2013-09-16 13:51:25',	0),
('5159978849794632BD43AE4D1BC39DCC',	'898',	NULL,	'1234567890',	'E2F22400B7534FC6BB998E2EDBE91FE4',	'2013-09-24 14:04:38',	0),
('80322B5624CA4370B18D3801646CD9F9',	'3333333333333',	NULL,	'1234567890',	'523BD9D9D0454B2DA518BDCA71EFD669',	'2013-09-24 14:33:06',	0),
('B7842094EC1D4DFFA6301470A8D62597',	'31231231231',	'23123',	'1234567890',	'523BD9D9D0454B2DA518BDCA71EFD669',	'2013-09-24 14:33:14',	0),
('A4567D02363241FE9D44EF94E1080E96',	'121',	'21212',	'1234567890',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-09-26 14:20:47',	0),
('6522CEAD79324C7BBC4B650A57A535EE',	'tasklist2',	NULL,	'1234567890',	'4001EAB8A2F94062B9AA25F1173E0244',	'2013-10-18 16:48:52',	0);

DROP TABLE IF EXISTS `tasklist_task`;
CREATE TABLE `tasklist_task` (
  `tasklist_uuid` varchar(32) NOT NULL,
  `task_uuid` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uuid` varchar(32) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `description` text,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `avatar` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `user` (`uuid`, `username`, `email`, `password`, `description`, `create_time`, `avatar`) VALUES
('1234567890',	'zhaopeng',	'admin',	'4763733c4936c2cd3bb282663eff025e',	NULL,	'2013-06-20 09:31:43',	'/images/avatar.jpg'),
('09876541',	'mikey',	'mikey',	'4763733c4936c2cd3bb282663eff025e',	NULL,	'2013-09-08 16:12:27',	'/images/avatar2.jpg'),
('542830E9F6A84322A0A25AE2BD8904F7',	'123',	'peng',	'4763733c4936c2cd3bb282663eff025e',	NULL,	'2013-10-12 15:22:24',	'/images/avatar1.gif');

-- 2014-08-07 14:10:22