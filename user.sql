
create table use(
	id int primary key not null,
	name varchar(50) not null,
	age int not null,
	address varchar(50),
	date date
)


select * from use
insert into use(name,age,address,date) values('Phuong',30,'Hai Duong','19/10/1991');
insert into use(name,age,address,date) values('Tuan',30,'Ha Noi','20/02/2000')
