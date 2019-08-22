create database if not exists sociedadeRoyall;
use sociedadeRoyall;

create table if not exists cliente (
	id int auto_increment not null,
    cpf varchar(11) not null,
    nome varchar(30) not null,
    username varchar(30) not null,
	primary key(id)
);