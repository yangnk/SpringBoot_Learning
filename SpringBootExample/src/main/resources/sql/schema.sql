CREATE TABLE blog (
                      id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
                      title varchar(255) DEFAULT NULL,
);