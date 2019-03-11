create table SINGER (
                      ID serial primary key not null,
                      FIRST_NAME varchar(60) not null,
                      LAST_NAME varchar(40) not null,
                      BIRTH_DATE date,
                      unique (FIRST_NAME, LAST_NAME)
);

create table ALBUM (
                     ID serial primary key not null,
                     SINGER_ID int not null,
                     TITLE varchar(100) not null,
                     RELEASE_DATE date,
                     unique (SINGER_ID, TITLE),
                     constraint FK_ALBUM foreign key (SINGER_ID) references SINGER (ID)
);