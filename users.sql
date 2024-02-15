USE `bookstore`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords: 
-- employee: emp123 
-- manager:manager123
-- admin: admin123
--

INSERT INTO `users` 
VALUES 
('employee','{bcrypt}$2a$10$VSjfLWQmFddwZzQ7o2cZruBSYFATVScx75geKQbGv.0KA3Wu7KAW6',1),
('manager','{bcrypt}$2a$10$GF/LYKbO1xmNz8L/UU9WfORUdm01OrLqyx.zweRpTz70Pqxws7fO',1),
('admin','{bcrypt}$2a$10$mee8usg5i1sOjD2tVw8FG.Qu05vlGm3yoKFILIxf1Zzd7zBIHYFMS',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('employee','ROLE_EMPLOYEE'),
('manager','ROLE_EMPLOYEE'),
('manager','ROLE_MANAGER'),
('admin','ROLE_EMPLOYEE'),
('admin','ROLE_MANAGER'),
('admin','ROLE_ADMIN');

select * from users;
select * from authorities;