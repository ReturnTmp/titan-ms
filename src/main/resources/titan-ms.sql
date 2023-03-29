/*
 Navicat Premium Data Transfer

 Source Server         : czh
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : titan-ms

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 27/03/2023 17:03:02
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_opitem`;
CREATE TABLE `tb_opitem`
(
    `id`                 int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '主键',
    `op`                 int(0) NULL DEFAULT NULL COMMENT '操作人',
    `ob_type`            int(0) NULL DEFAULT NULL COMMIT '操作票类型', ,
    `ob_name`            varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作票名称',
    `op_description`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作描述',
    `secure_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '安全措施',
    `complete_time`      datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
    `create_time`        datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`            tinyint(0) NULL DEFAULT 0 COMMENT '是否删除,0是初始状态，1表示删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO `tb_opitem`
VALUES (0000000001, 6903, 6954, '222', '检查有没有处于X位置', '查确已在就地位置', '2023-03-21 05:53:35');
INSERT INTO `tb_opitem`
VALUES (0000000002, 6916, 6950, '333', '切断X线路', '查确已切断', '2023-03-24 12:06:05');

-- ----------------------------
-- Table structure for tb_syslog
-- ----------------------------
DROP TABLE IF EXISTS `tb_syslog`;
CREATE TABLE `tb_syslog`
(
    `id`         bigint(0) NOT NULL,
    `log_id`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `user_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `user_ip`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `req_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `req_desc`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `ob_id`      bigint(0) NULL DEFAULT NULL,
    `creat_time` datetime(0) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_syslog
-- ----------------------------
INSERT INTO `tb_syslog`
VALUES (1639232428626391042, 'a160786da90b4718a2f48d8637079c19', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', NULL, NULL);
INSERT INTO `tb_syslog`
VALUES (1639233082719707137, 'b3f4786cba1042558c0206da46454674', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', NULL, '2023-03-24 11:49:57');
INSERT INTO `tb_syslog`
VALUES (1639469091935993857, '5220524bcae641a3b836fe4851c254c8', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', NULL, '2023-03-25 03:27:46');
INSERT INTO `tb_syslog`
VALUES (1639469428700852225, 'af87a5b0b1e44ca2aa427cef85e6f5ae', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', NULL, '2023-03-25 03:29:06');
INSERT INTO `tb_syslog`
VALUES (1639474315517947905, 'a38921132fdf4302838b8bdca6ec01a4', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', NULL, '2023-03-25 03:48:31');
INSERT INTO `tb_syslog`
VALUES (1639474858403553281, '0df85d4e227e431ca78c0b195134d4ca', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', NULL, '2023-03-25 03:50:41');
INSERT INTO `tb_syslog`
VALUES (1639475767678316545, '1b939fd4735541ef80e5d6e260582d1e', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', NULL, '2023-03-25 03:54:18');
INSERT INTO `tb_syslog`
VALUES (1639476016132104194, '5ba5e831d9554125a4b7612861165055', 'Sinya', '100.67.80.27',
        'org.csu.ismartguard.service.impl.TicketServiceImpl.add', '添加操作票', 1639476015943360514, '2023-03-25 03:55:17');

-- ----------------------------
-- Table structure for tb_ticket
-- ----------------------------
DROP TABLE IF EXISTS `tb_ticket`;
CREATE TABLE `tb_ticket`
(
    `id`            bigint(0) NOT NULL,
    `company_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `task`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `begin_time`    datetime(0) NULL DEFAULT NULL,
    `end_time`      datetime(0) NULL DEFAULT NULL,
    `opitem_sealed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `remark`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `operator`      varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `guardian`      varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `charge`        varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `leader`        varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `evaluation`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `checker`       varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `check_time`    datetime(0) NULL DEFAULT NULL,
    `ispost`        int(0) NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_ticket
-- ----------------------------
INSERT INTO `tb_ticket`
VALUES (1638433883304460289, NULL, NULL, '2023-03-22 07:05:54', NULL, '[26,27]', NULL, NULL, NULL, '111', NULL, NULL,
        '111', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1638439552329940994, NULL, NULL, '2023-03-22 07:16:44', NULL, '[28,29]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639232428508950529, NULL, NULL, '2023-03-24 11:47:21', NULL, '[36,37]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639233082543546370, NULL, NULL, '2023-03-24 11:49:56', NULL, '[38,39]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639469091743055874, NULL, NULL, '2023-03-25 03:27:45', NULL, '[40,41]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639469428541468674, NULL, NULL, '2023-03-25 03:29:06', NULL, '[42,43]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639474315329204226, NULL, NULL, '2023-03-25 03:48:31', NULL, '[44,45]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639474424897069058, NULL, NULL, '2023-03-25 03:48:57', NULL, '[46,47]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639475115229163522, NULL, NULL, '2023-03-25 03:51:42', NULL, '[50,51]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);
INSERT INTO `tb_ticket`
VALUES (1639476015943360514, NULL, NULL, '2023-03-25 03:55:16', NULL, '[54,55]', NULL, NULL, NULL, '222', NULL, NULL,
        '222', NULL, 0);

-- ----------------------------
-- Table structure for tb_warning
-- ----------------------------
DROP TABLE IF EXISTS `tb_warning`;
CREATE TABLE `tb_warning`
(
    `id`           bigint(0) NOT NULL,
    `ticket_id`    bigint(0) NULL DEFAULT NULL,
    `warning_flag` int(0) NULL DEFAULT NULL,
    `warning_desc` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `warning_time` datetime(0) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_warning
-- ----------------------------
INSERT INTO `tb_warning`
VALUES (1639512139302674433, NULL, 0, NULL, NULL);
INSERT INTO `tb_warning`
VALUES (1639512779844186113, 123, 0, '1', '2023-03-25 06:21:22');
INSERT INTO `tb_warning`
VALUES (1639512999525076993, 123, 0, '1', '2023-03-25 06:22:14');

SET
FOREIGN_KEY_CHECKS = 1;
