# A simple projecte use springboot security, jpa and mysql
## Resources
- "/admin": Resource can only be accessed only by user with role admin
- "/user": Resource can only be accessed only by user with role admin and user
- "/signup": Resource can be accessed only by every user,support GET and POST(have csrf disabled)
-- POST:{"name":"user","password":"pass"}
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
        
        
## MySQL start (in docker)
- Start docker image:
    
    `docker run -itd --name mysql-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql`

- login container

    `docker exec -it mysql-test bash`

- login mysql

    `Mysql -u root -p password`
