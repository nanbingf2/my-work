create table t_user(
	id int primary key auto_increment,
	loginname varchar(20),
	password varchar(20),
	phone varchar(20),
	address varchar(20)
);


create table t_artical(
	id int primary key auto_increment,
	name varchar(20),
	price int,
	remark varchar(50)
);


create table t_order(
	id int primary key auto_increment,
	code varchar(20),
	total int,
	user_id int,
	foreign key(user_id) references t_user(id)
);


create table t_item(
	order_id int,
	artical_id int,
	amount int,
	primary key(order_id,artical_id),
	foreign key(order_id) references t_order(id),
	foreign key(artical_id) references t_artical(id)
);