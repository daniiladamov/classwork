create table friends (id int8 not null, friend_id int8 not null);
create table pet (pet_type varchar(31) not null,
id int8 generated by default as identity,
 name varchar(255),
 color varchar(255),
 hair varchar(255),
 voice varchar(255),
 length int4,
 primary key (id));

alter table if exists friends add constraint FK3s5onxtl80fqcu3mum158x870 foreign key (friend_id) references pet;
alter table if exists friends add constraint FK4drhr36wqbylictjyd9006gem foreign key (id) references pet;



insert into pet(pet_type,"name",color) values ('cat','ulya','red')
                                            ,('cat','myeaw','yellow'),('cat','pirate','red');
insert into pet(pet_type,"name",color,voice) values ('dog','gaw','black','aw'),('dog','pirate','blue','aaaaw'),
                                                    ('dog','spring','blue','AAAW');
insert into pet(pet_type,"name","length") values ('snake','harry',100),('snake','ron',200),('snake','ger',300);
insert into friends(id, friend_id) values (1,4),(4,1),(2,3),(3,2),(1,2),(2,1),(4,3),(3,4),(2,5),(5,2),(7,1),(1,7);