CREATE TABLE SINGER (
    ID serial NOT NULL primary key
  , FIRST_NAME VARCHAR(60) NOT NULL
  , LAST_NAME VARCHAR(40) NOT NULL
  , BIRTH_DATE DATE
  , UNIQUE (FIRST_NAME, LAST_NAME)
);

CREATE TABLE ALBUM (
    ID serial NOT NULL primary key
  , SINGER_ID INT NOT NULL
  , TITLE VARCHAR(100) NOT NULL
  , RELEASE_DATE DATE
  , UNIQUE (SINGER_ID, TITLE)
  , CONSTRAINT FK_ALBUM FOREIGN KEY (SINGER_ID)
    REFERENCES SINGER (ID)
);