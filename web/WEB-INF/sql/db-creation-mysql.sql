CREATE TABLE Employees(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255),
FIRSTNAME VARCHAR(255),
HOMEPHONE VARCHAR(255),
MOBILEPHONE VARCHAR(255),
WORKPHONE VARCHAR(255),
ADDRESS VARCHAR(255),
POSTALCODE VARCHAR(255),
CITY VARCHAR(255),
EMAIL VARCHAR(255) UNIQUE
);