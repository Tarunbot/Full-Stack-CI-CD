create table customer(Id BIGSERIAL PRIMARY KEY ,
                       Name TEXT NOT NULL ,
                       Email TEXT NOT NULL UNIQUE,
                       Age INTEGER NOT NULL
                       );