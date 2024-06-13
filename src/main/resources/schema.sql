create table BOOK (
    ID varchar(36) primary key,
    NAME varchar(128),
    PAGECOUNT integer,
    AUTHORID varchar(20)
);

create table AUTHOR (
    ID varchar(36) primary key,
    FIRSTNAME varchar(128),
    LASTNAME varchar(128)
);