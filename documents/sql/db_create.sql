show databases;
create database board;

create user 'sw'@'localhost' identified by 'java1234';

show grants for 'sw'@'localhost';
grant all on board.* to 'sw'@'localhost' with grant option;
flush privileges;
