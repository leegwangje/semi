create table if not exists members(
    mno int auto_increment primary key,
    userid varchar(18) unique not NULL ,
    passwd varchar(64)  not NULL ,
    name varchar(50) not null,
    email varchar(100) not null,
    regdate datetime default current_timestamp
);

create table if not exists boards(
    bno int auto_increment ,
    title varchar(128)  not NULL ,
    userid varchar(18)  not NULL ,
    regdate datetime default current_timestamp,
    thumbs int default 0,
    views int default 0,
    contents text not null,
    primary key(bno),
    foreign key (userid) references members(userid)
    );


