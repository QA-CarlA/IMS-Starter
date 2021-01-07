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

INSERT INTO `ims`.`orders` (`customerID`, `datePlaced`) VALUES ('1', '2020-12-01 01:01:01');
INSERT INTO `ims`.`orders` (`customerID`, `datePlaced`) VALUES ('2', '2020-12-02 02:02:02');
INSERT INTO `ims`.`orders` (`customerID`, `datePlaced`) VALUES ('3', '2020-12-03 03:03:03');
INSERT INTO `ims`.`orders` (`customerID`, `datePlaced`) VALUES ('4', '2020-12-04 04:04:04');
INSERT INTO `ims`.`orders` (`customerID`, `datePlaced`) VALUES ('5', '2020-12-05 05:05:05');
INSERT INTO `ims`.`orders` (`customerID`, `datePlaced`) VALUES ('6', '2020-12-06 06:06:06');
INSERT INTO `ims`.`orders` (`customerID`, `datePlaced`) VALUES ('7', '2020-12-07 07:07:07');

INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (1, 1, 2);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (1, 2, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (1, 3, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (2, 1, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (2, 2, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (3, 3, 5);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (4, 1, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (4, 2, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (4, 3, 1);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (5, 1, 8);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (6, 2, 14);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (6, 3, 4);
INSERT INTO `ims`.`order_items` (`orderID`, `itemID`, `itemQuantity`) VALUES (7, 1, 7);

