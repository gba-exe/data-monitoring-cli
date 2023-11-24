
CREATE TABLE tb_category (
	category_id int primary key not null auto_increment,
	name varchar(45) not null,
	description varchar(100) not null,
	data_unit varchar(20) not null 
);
CREATE TABLE tb_register (
	register_id int primary key not null auto_increment,
	register_value double precision,
    date_time datetime,
	fk_category int not null,
	foreign key (fk_category) references tb_category(category_id)
);

insert into tb_category(name, description, data_unit) values ("CPU Usage","Usage of pr ocessor resources","%");
insert into tb_category(name, description, data_unit) values ("RAM Usage","Usage of RAM resources","%");
insert into tb_category(name, description, data_unit) values ("Available Storage","Available Storage of all  volumes", "GB");
insert into tb_category(name, description, data_unit) values ("Total Storage","Sumo of Storag e of all volumes","GB");            

create or replace view vw_register as
	select reg.register_id, reg.register_value, reg.date_time, cat.name 
	from tb_register as reg join tb_category as cat on category_id = fk_category order by reg.register_id desc;
