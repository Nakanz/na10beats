DROP DATABASE IF EXISTS na10beats;
CREATE DATABASE na10beats;
USE na10beats;

DROP TABLE IF EXISTS AUTHOR ;
DROP TABLE IF EXISTS TRACK;
DROP TABLE IF EXISTS TLIKE;

	
CREATE TABLE AUTHOR(AID INTEGER, firstN varchar(42),lastN varchar(42), homepage varchar(42),
	PRIMARY KEY(AID));

	
CREATE TABLE TRACK(TID INTEGER, AuthorID INTEGER, Tname varchar(42), Ptrack blob,
	PRIMARY KEY(TID),
	FOREIGN KEY(AuthorID) REFERENCES AUTHOR(AID));
	
CREATE TABLE TLIKE(LID INTEGER, TRACKid INTEGER,Lwho varchar(42),Ltime DATE, 
	PRIMARY KEY(LID),
	FOREIGN KEY(TRACKid) REFERENCES TRACK(TID));

	
INSERT INTO AUTHOR(AID, firstN, lastN, homepage) VALUES(1, 'Nathan', 'Hester', 'http://www.nathanrileyhester.com');
INSERT INTO AUTHOR(AID, firstN, lastN, homepage) VALUES(2, 'Greg', 'Hester', 'http://www.gregoryhester.com');

INSERT INTO TRACK(TID, AuthorID, Tname) VALUES(1, 1, 'miss u');
INSERT INTO TRACK(TID, AuthorID, Tname) VALUES(2, 1, 'appreciate');
INSERT INTO TRACK(TID, AuthorID, Tname) VALUES(3, 2, 'trashtape');

INSERT INTO TLIKE(LID, TRACKid, Lwho, Ltime) VALUES(1, 1, 'Halia', '2019-7-28');
