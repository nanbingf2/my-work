create table publishers(
	id int auto_increment primary key,
	name varchar(20)
)


create table books(
	id int primary key auto_increment,
	title varchar(20),
	author varchar(20),
	publisherId int,
	publish_date date,
	price double,
	foreign key(publisherId) references publishers(id)
);