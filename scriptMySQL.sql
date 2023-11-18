create database db_dmcli;
use db_dmcli;

create user 'dmcli'@'localhost' identified by 'urubu100';
grant all privileges on db_dmcli.* to 'dmcli'@'localhost';

drop table if exists tb_register;
drop table if exists tb_category;

CREATE TABLE tb_category (
	category_id int primary key not null auto_increment,
	name varchar(45) not null,
	description varchar(100) not null,
	data_unit varchar(20) not null 
);
CREATE TABLE tb_register (
	register_id int primary key not null auto_increment,
	register_value double precision,
	fk_category int not null,
	foreign key (fk_category) references tb_category(category_id)
);

insert into tb_category(name, description, data_unit) values ("CPU Usage","Usage of pr ocessor resources","%");
insert into tb_category(name, description, data_unit) values ("RAM Usage","Usage of RAM resources","%");
insert into tb_category(name, description, data_unit) values ("Available Storage","Available Storage of all  volumes", "GB");
insert into tb_category(name, description, data_unit) values ("Total Storage","Sumo of Storag e of all volumes","GB");            