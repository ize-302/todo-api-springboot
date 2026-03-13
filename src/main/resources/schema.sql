create table TODO  (
  ID int not null AUTO_INCREMENT,
  TITLE varchar(100) not null,
  NOTE varchar(255),
  COMPLETED boolean DEFAULT false,
  PRIMARY KEY ( ID )
);
