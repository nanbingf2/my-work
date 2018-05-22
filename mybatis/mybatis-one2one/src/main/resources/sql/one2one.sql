create table t_card(
	id int auto_increment primary key,
	code varchar(20)
);

insert into t_card(code) values("2015213123");


create table t_person(
	id int auto_increment primary key,
	name varchar(20),
	sex varchar(20),
	age int,
	card_id int unique,
	foreign key(card_id) references t_card(id)
);

insert into t_person(name,age,sex,card_id) values('zhangsan',20,'男',1);