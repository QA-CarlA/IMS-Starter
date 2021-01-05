drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customerID` INT(11) NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(45) NULL DEFAULT NULL,
    `lastName` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`customerID`)
);
