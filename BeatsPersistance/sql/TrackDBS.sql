DROP DATABASE na10beats;
CREATE DATABASE na10beats;
USE na10beats;
DROP TABLE TLIKE;
DROP TABLE AUTHOR;
DROP TABLE TRACK;
CREATE TABLE TLIKE(Lwho varchar(42),Ltime DATE);
CREATE TABLE AUTHOR(firstN varchar(42),lastN varchar(42),homepage varchar(42));
CREATE TABLE TRACK(Tname varchar(42),Ptrack blob,Author varchar(42),Tlikes INTEGER);
