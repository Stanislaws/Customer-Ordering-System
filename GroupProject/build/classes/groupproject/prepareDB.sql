drop table orders;
drop table users;

create table users (
  username varchar(15) not null primary key,
  password varchar(15),
  fullname varchar(50),
  street varchar(25),
  city varchar(25),
  usstate varchar(2),
  zip varchar(5),
  telephone varchar(10),
  email varchar(30)
);

create table orders(
  orderid int not null,
  username varchar(15),
  product varchar(40),
  orderdate char(6),
  price number(5,2),
  qty int,
  primary key (orderid),
  constraint fk_users foreign key (username)
  references users(username)
);

insert into users(username,password) values ('test','test');

commit;

