
create table student(
	studentId int auto_increment primary key,
	studentName varchar(20)
);

create table course(
	courseId int auto_increment primary key,
	courseName varchar(20)
);

create table sc(
	sid int,
	cid int,
	primary key(sid,cid),
	foreign key(cid) references course(courseId),
	foreign key(sid) references student(studentId)
);