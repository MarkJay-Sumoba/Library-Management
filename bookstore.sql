CREATE DATABASE  IF NOT EXISTS `bookstore`;

USE `bookstore`;

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `isbn` varchar(100) NOT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `books` VALUES 
	(1,'Harry Potter and the Philosphers Stone','J.K Rowlings','0747532699', 'AVAILABLE'),
	(2,'Harry Potter and the Chamber of Secrets','J.K Rowlings','0747538492', 'CHECKED-OUT'),
	(3,'The Hobbit','J.R.R Tolkien','9780007458424', 'AVAILABLE'),
	(4,'The Great Gatsby','F. Scott Fitzgerald','9780743273565', 'AVAILABLE'),
	(5,'To Kill a Mockingbird','Harper Lee','9780061120084', 'AVAILABLE');
    
SELECT * FROM books;


