create table  GOODS (name VARCHAR(255) NOT NULL ,id INTEGER NOT NULL
,cost DOUBLE NOT NULL,primary key (id));

insert into GOODS(name,id,cost) values ('Book',1,20.5);
insert into GOODS(name,id,cost) values ('Phone',2,10);
insert into GOODS(name,id,cost) values ('TV',3,24);
insert into GOODS(name,id,cost) values ('Radio',4,26.8);
insert into GOODS(name,id,cost) values ('Table',5,30.4);

create table  USER (id INTEGER AUTO_INCREMENT NOT NULL,login VARCHAR (255) NOT NULL,
password VARCHAR (255),user_role VARCHAR (255));
create table  ORDERS (id INTEGER AUTO_INCREMENT,user_id INTEGER NOT NULL,
total_price DOUBLE NOT NULL,primary key (id),foreign key (user_id) references USER (id));
create table  ORDER_GOOD (id INTEGER AUTO_INCREMENT,order_id INTEGER NOT NULL,
good_id INTEGER NOT NULL,primary key (id),
foreign key (good_id) references GOODS (id),foreign key (order_id) references ORDERS (id));