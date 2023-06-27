SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `chunk`;
CREATE TABLE `chunk`
(
    `c_id`    int                                                          NOT NULL AUTO_INCREMENT,
    `c_md5`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `c_index` int                                                          NULL DEFAULT NULL,
    PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3834
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`
(
    `f_id`   int                                                          NOT NULL AUTO_INCREMENT,
    `f_md5`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `f_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `f_size` bigint                                                       NULL DEFAULT NULL,
    PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 33
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
