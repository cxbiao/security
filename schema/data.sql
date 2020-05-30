/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 120.78.160.86:3306
 Source Schema         : security

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 31/05/2020 00:06:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of oauth_client_details  密码都是123456
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('android', NULL, '{bcrypt}$2a$10$QVs3Vst865eWNLT.5ph.LuODlHSF4cY7x51uirILB7lDAXBUEZeZy', 'all', 'client_credentials,refresh_token', NULL, 'oauth2', NULL, NULL, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('pc', '', '{bcrypt}$2a$10$QVs3Vst865eWNLT.5ph.LuODlHSF4cY7x51uirILB7lDAXBUEZeZy', 'all', 'password,authorization_code,refresh_token', 'http://localhost:8700/client1/login', 'oauth2', NULL, NULL, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('pc2', NULL, '{bcrypt}$2a$10$QVs3Vst865eWNLT.5ph.LuODlHSF4cY7x51uirILB7lDAXBUEZeZy', 'all', 'password,authorization_code,refresh_token', 'http://192.168.201.2:8701/client2/login', 'oauth2', NULL, NULL, NULL, 'true');



-- ----------------------------
-- Records of user 密码都是123456
-- ----------------------------
INSERT INTO `user` VALUES (8, '{bcrypt}$2a$10$OXpjxbwQGUTCthXkobOPfOOoviqeKhBFhaYYqjVPZ7sTVAw8Jxtcu', 'james');
INSERT INTO `user` VALUES (9, '{bcrypt}$2a$10$1IjgJ6p7NBXHPMNes3MZ3.FcHb45UrpzU3MOb1drv1lmLB641Gc9S', 'tom');
INSERT INTO `user` VALUES (10, '{bcrypt}$2a$10$OXpjxbwQGUTCthXkobOPfOOoviqeKhBFhaYYqjVPZ7sTVAw8Jxtcu', 'jack');
INSERT INTO `user` VALUES (13, '{bcrypt}$2a$10$YKJ4AeJeFdPy4JFFDeThK.mQWc1areHOwc1BBvArrnaPCRAXeYEby', 'lison');


-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ADMIN');
INSERT INTO `role` VALUES (2, 'MENU');


-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (8, 1);
INSERT INTO `user_role` VALUES (10, 2);

SET FOREIGN_KEY_CHECKS = 1;