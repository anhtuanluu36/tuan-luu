DROP TABLE IF EXISTS `Course_Student`;
DROP TABLE IF EXISTS `Fee`;
DROP TABLE IF EXISTS `Course`;
DROP TABLE IF EXISTS `Student`;

CREATE TABLE `Student`
(
`StudentID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`StudentName` varchar(255) NOT NULL,
`Birthday` date,
PRIMARY KEY (`StudentID`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Course`
(
`CourseID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`CourseName` varchar(255) NOT NULL,
`StartDate` date,
`EndDate` date,
PRIMARY KEY (`CourseID`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Course_Student`
(
`CourseID` int(10) UNSIGNED NOT NULL,
`StudentID` int(10) UNSIGNED NOT NULL,
PRIMARY KEY (`CourseID`,`StudentID`),
FOREIGN KEY (`CourseID`) REFERENCES `Course`(`CourseID`),
FOREIGN KEY (`StudentID`) REFERENCES `Student`(`StudentID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Fee`
(
`FeeID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`FeeName` varchar(255),
`StudentID` int(10) UNSIGNED NOT NULL,
`Price` BIGINT NOT NULL,
PRIMARY KEY (`FeeID`) USING BTREE,
FOREIGN KEY (`StudentID`) REFERENCES `Student`(`StudentID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;