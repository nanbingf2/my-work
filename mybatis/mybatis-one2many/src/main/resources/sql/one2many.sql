create table t_class(
	id int primary key auto_increment,
	code varchar(20),
	name varchar(20)
);



create table t_student(
	id int primary key auto_increment,
	name varchar(20),
	sex varchar(20),
	age int,
	class_id int,
	foreign key(class_id) references t_class(id)
);