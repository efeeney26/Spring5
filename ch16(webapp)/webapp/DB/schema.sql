create table SINGER (
    ID int not null auto_increment,
    FIRST_NAME varchar(60) not null,
    LAST_NAME varchar(40) not null,
    BIRTH_DATE date,
    DESCRIPTION varchar(2000),
    PHOTO blob,
    VERSION int not null default 0,
    unique UQ_SINGER_1 (FIRST_NAME, LAST_NAME),
    primary key (ID)
);