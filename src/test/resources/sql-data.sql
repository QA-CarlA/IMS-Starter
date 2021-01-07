INSERT INTO `ims`.`customers` (`firstName`, `lastName`) VALUES ('Fubuki', 'Shirakami');
INSERT INTO `ims`.`customers` (`firstName`, `lastName`) VALUES ('Aqua', 'Minato');
INSERT INTO `ims`.`customers` (`firstName`, `lastName`) VALUES ('Pekora', 'Usada');
INSERT INTO `ims`.`customers` (`firstName`, `lastName`) VALUES ('Shion', 'Murasaki');
INSERT INTO `ims`.`customers` (`firstName`, `lastName`) VALUES ('Ayame', 'Nakiri');
INSERT INTO `ims`.`customers` (`firstName`, `lastName`) VALUES ('Haato', 'Akai');
INSERT INTO `ims`.`customers` (`firstName`, `lastName`) VALUES ('Rion', 'Takamiya');

INSERT INTO `ims`.`items` (`itemName`, `itemPrice`, `itemStockCount`) VALUES ("Key Chain", 1.99, 100);
INSERT INTO `ims`.`items` (`itemName`, `itemPrice`, `itemStockCount`) VALUES ("Clear File", 4.99, 100);
INSERT INTO `ims`.`items` (`itemName`, `itemPrice`, `itemStockCount`) VALUES ("Acrylic Stand", 8.99, 100);

INSERT INTO `ims`.`orders` (`customerID`) VALUES ('1');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('2');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('3');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('4');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('5');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('6');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('7');

INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (1, 1, 2);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (1, 2, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (1, 4, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (2, 5, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (2, 6, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (3, 2, 5);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (4, 6, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (4, 7, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (4, 8, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (5, 4, 8);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (6, 3, 14);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (6, 4, 4);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (7, 1, 7);

