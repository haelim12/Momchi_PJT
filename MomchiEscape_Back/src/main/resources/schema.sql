create table User (
                      user_id int auto_increment primary key ,
                      name varchar(100) not null,
                      email varchar(200) not null,
                      password varchar(200) not null,
                      nickname varchar(100) not null,
                      birthday date null,
                      level varchar(100) default '초보',
);
