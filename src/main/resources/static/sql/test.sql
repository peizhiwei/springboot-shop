/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 24/07/2020 13:21:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (19);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_stock` int(255) NOT NULL,
  `order_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(19, 2) NOT NULL,
  `product_stock` int(11) NOT NULL,
  `shop_number` int(11) NOT NULL,
  `product_flag` int(11) NULL DEFAULT NULL COMMENT '1はパソコン、２はメモリ',
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `FKd0wpywts11i2uk605ev136itj`(`shop_number`) USING BTREE,
  CONSTRAINT `FKd0wpywts11i2uk605ev136itj` FOREIGN KEY (`shop_number`) REFERENCES `shop` (`shop_number`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (19, 'PC-VG16N2Z47 ', 5486.00, -17, 1, 1);
INSERT INTO `product` VALUES (20, 'PC-VG16N2Z47 ', 8426.00, -6, 1, 1);
INSERT INTO `product` VALUES (21, 'PC-VG16N2Z47 ', 4698.00, -4, 1, 1);
INSERT INTO `product` VALUES (22, 'PC-VG16N2Z47 ', 8461.00, 64, 2, 1);
INSERT INTO `product` VALUES (23, 'PC-VG16N2Z47 ', 4756.00, 66, 2, 1);
INSERT INTO `product` VALUES (24, 'PC-VG16N2Z47 ', 8569.00, 76, 2, 1);
INSERT INTO `product` VALUES (25, 'PC-VG16N2Z47 ', 7136.00, 80, 3, 1);
INSERT INTO `product` VALUES (26, 'PC-VG16N2Z47 ', 7851.00, 90, 3, 1);
INSERT INTO `product` VALUES (27, 'PC-VG16N2Z47 ', 8791.00, 60, 3, 1);
INSERT INTO `product` VALUES (28, ' VS133-128MX  ', 5146.00, -14, 1, 2);
INSERT INTO `product` VALUES (29, ' VS133-128MX  ', 6348.00, -5, 1, 2);
INSERT INTO `product` VALUES (30, ' VS133-128MX  ', 7415.00, -3, 1, 2);
INSERT INTO `product` VALUES (31, ' VS133-128MX  ', 7845.00, 86, 2, 2);
INSERT INTO `product` VALUES (32, ' VS133-128MX  ', 7419.00, 85, 2, 2);
INSERT INTO `product` VALUES (33, ' VS133-128MX  ', 9674.00, 94, 2, 2);
INSERT INTO `product` VALUES (34, ' VS133-128MX  ', 8549.00, 98, 3, 2);
INSERT INTO `product` VALUES (35, ' VS133-128MX  ', 7492.00, 25, 3, 2);
INSERT INTO `product` VALUES (36, ' VS133-128MX  ', 5499.00, 89, 3, 2);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_number` int(11) NOT NULL,
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shop_family_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`shop_id`) USING BTREE,
  UNIQUE INDEX `UK_9cah9ormtdeppfbqa8akv18i5`(`shop_number`) USING BTREE,
  INDEX `shop_number`(`shop_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, 1, '渋谷本店', '相田');
INSERT INTO `shop` VALUES (2, 2, '新宿店', '	斎藤');
INSERT INTO `shop` VALUES (3, 3, '新大阪店', '星野');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
