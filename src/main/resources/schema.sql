create table todo(
     id bigint unsigned Auto_increment not null primary key,
     title varchar(30) not null unique,
     deadline date not null,
     status bool not null default false,
     create_time datetime not null default current_timestamp,
     update_time datetime not null default current_timestamp on update current_timestamp
)DEFAULT CHARSET=utf8mb4;
