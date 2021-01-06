drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customerID` INT(11) NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(45) NULL DEFAULT NULL,
    `lastName` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`customerID`)
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`itemID` INT(11) NOT NULL AUTO_INCREMENT,
	`itemName` VARCHAR(45) NOT NULL,
	`itemPrice` DOUBLE NOT NULL,
	`itemStockCount` INT(11) NOT NULL,
	PRIMARY KEY (`itemID`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders`(
	`orderID` INT(11) NOT NULL AUTO_INCREMENT,
	`customerID` INT(11) NOT NULL,
	`datePlaced` DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(orderID),
	FOREIGN KEY(customerID) REFERENCES customers(customerID)
);
CREATE TABLE IF NOT EXISTS `ims`.`order_items`(
	`orderID` INT(11) NOT NULL,
	`itemID` INT(11) NOT NULL,
	`itemQuantity` INT(11) NOT NULL,
	FOREIGN KEY(orderID) REFERENCES orders(orderID),
	FOREIGN KEY(itemID) REFERENCES items(itemID)
);	