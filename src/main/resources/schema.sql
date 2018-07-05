use stocks;
drop table if exists quote;
create table quote (
id int auto_increment not null primary key,
symbol varchar(255),
price double,
volume int,
Date date)