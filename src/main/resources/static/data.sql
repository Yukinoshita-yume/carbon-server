CREATE DATABASE `challenger-cup`;
USE `challenger-cup`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(50) NOT NULL,
    `user_telephone` VARCHAR(15) NOT NULL,
    `user_password` VARCHAR(255) NOT NULL,
    `user_level` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`user_id`)
);
