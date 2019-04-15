/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : zyxblog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-09 17:14:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for algo
-- ----------------------------
DROP TABLE IF EXISTS `algo`;
CREATE TABLE `algo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `scence` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of algo
-- ----------------------------
INSERT INTO `algo` VALUES ('1', '随机森林', '是多个决策树的组合算法', '适合带有判断逻辑的业务场景');

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `state` tinyint(2) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `loadURL` varchar(255) DEFAULT NULL,
  `summary` varchar(10000) DEFAULT NULL,
  `post_time` bigint(20) NOT NULL,
  `upd_time` bigint(20) DEFAULT NULL,
  `view` bigint(20) NOT NULL,
  `start` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articles
-- ----------------------------

-- ----------------------------
-- Table structure for ay_mood
-- ----------------------------
DROP TABLE IF EXISTS `ay_mood`;
CREATE TABLE `ay_mood` (
  `id` varchar(32) NOT NULL,
  `content` varchar(256) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `praise_num` int(11) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mood_user_id_index` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ay_mood
-- ----------------------------
INSERT INTO `ay_mood` VALUES ('1', '这是我的第一条微信说说！！！', '1', '0', '2018-11-13 09:58:53');
INSERT INTO `ay_mood` VALUES ('2', '这是我的第一条微信说说！！！', '2', '0', '2018-11-13 09:58:53');

-- ----------------------------
-- Table structure for ay_role
-- ----------------------------
DROP TABLE IF EXISTS `ay_role`;
CREATE TABLE `ay_role` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ay_role
-- ----------------------------
INSERT INTO `ay_role` VALUES ('1', 'ADMIN');
INSERT INTO `ay_role` VALUES ('2', 'USER');

-- ----------------------------
-- Table structure for ay_user
-- ----------------------------
DROP TABLE IF EXISTS `ay_user`;
CREATE TABLE `ay_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(10) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ay_user
-- ----------------------------
INSERT INTO `ay_user` VALUES ('1', '阿毅', '123456');
INSERT INTO `ay_user` VALUES ('2', '阿兰', '123456');
INSERT INTO `ay_user` VALUES ('3', '阿华', '123456');
INSERT INTO `ay_user` VALUES ('5', 'zhouyx', '123');

-- ----------------------------
-- Table structure for ay_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `ay_user_role_rel`;
CREATE TABLE `ay_user_role_rel` (
  `user_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ay_user_role_rel
-- ----------------------------
INSERT INTO `ay_user_role_rel` VALUES ('1', '1');
INSERT INTO `ay_user_role_rel` VALUES ('2', '2');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `reply_id` varchar(255) DEFAULT NULL,
  `reply_comment_id` int(11) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `time` bigint(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for params_algo
-- ----------------------------
DROP TABLE IF EXISTS `params_algo`;
CREATE TABLE `params_algo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `algo_id` int(11) NOT NULL,
  `param_name` varchar(100) NOT NULL,
  `param_detail` varchar(500) DEFAULT NULL,
  `param_value` varchar(255) DEFAULT NULL COMMENT '参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of params_algo
-- ----------------------------
INSERT INTO `params_algo` VALUES ('1', '1', 'max_features', '随机森林允许单个决策树使用的特征的最大数量', '0.2');
INSERT INTO `params_algo` VALUES ('2', '1', 'n_estimators', '利用最大投票数或平均值来预测之前，你想要建立子树的数量', '20');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for tag_links
-- ----------------------------
DROP TABLE IF EXISTS `tag_links`;
CREATE TABLE `tag_links` (
  `tid` int(11) NOT NULL,
  `aid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag_links
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `root` tinyint(2) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `reminder` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for visitors
-- ----------------------------
DROP TABLE IF EXISTS `visitors`;
CREATE TABLE `visitors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `reminder` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitors
-- ----------------------------
