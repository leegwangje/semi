create table members(
    mno int auto_increment primary key,
    userid varchar(18) unique not NULL ,
    passwd varchar(18)  not NULL ,
    name varchar(50) not null,
    email varchar(100) not null,
    regdate datetime default current_timestamp
);
