create table identitycard(
	id int auto_increment primary key,
	cardidNo varchar(32)
);

create table people(
	id int auto_increment primary key,
	name varchar(20),
	sex varchar(20),
	age int,
	cardid int,
	foreign key(cardid) references identitycard(id)
);