# A simple projecte use springboot security, jpa and mysql
## Resources
- "/admin": Resource can only be accessed only by user with role admin
- "/user": Resource can only be accessed only by user with role admin and user
- "/signup": Resource can be accessed only by every user,support GET and POST(have csrf disabled)
-- POST:{"username":"user","password":"pass"}
- "/": Resource can be accessed only by every user


## database schema
table user:
create table user(
    id int unsigned auto_increment,
    name varchar(128) not null,
    password varchar(128) not null,
    active tinyint(1) not null,
    roles varchar(128) not null,
    primary key(id))
    engine=InnoDB default charset=utf8;
