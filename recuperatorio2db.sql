CREATE DATABASE `recuperatoriodb`;

USE `recuperatoriodb`;

CREATE TABLE `category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(45) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `company` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(45) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `location` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`lat` DECIMAL(10,8) NULL,
	`ing` DECIMAL(11,8) NULL,
	`likes` INT NULL,
	`terminal_id` INT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `terminal` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`serial` VARCHAR(45) NULL,
	`active` BIT NULL,
	`category_id` INT NULL,
	`user_id` INT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(45) NULL,
	`user_parent_id` INT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_company` (
	`user_id` INT NOT NULL,
	`company_id` INT NOT NULL,
	PRIMARY KEY (`user_id`, `company_id`)
);