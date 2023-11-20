create table User (
                      user_id int auto_increment primary key ,
                      name varchar(100) not null,
                      email varchar(200) not null,
                      password varchar(200) not null,
                      nickname varchar(100) not null,
                      birthday date null,
                      level varchar(100)
);

create table Post(
                     post_id int auto_increment primary key,
                     title varchar(200) not null ,
                     content text not null ,
                     user_id int not null ,
                     content_type varchar(100) not null,
                     url varchar(200) null ,
                     level varchar(100) null,
                     likeCnt int default 0,
                     foreign key Post(user_id) references User(user_id)
);

create table Video(
                      video_id int auto_increment primary key,
                      url varchar(200) not null ,
                      level varchar(100) default '초보',
                      view_cnt int default 0
);

create table PostLike (
                          like_id int auto_increment primary key,
                          user_id int not null,
                          post_id int not null,
                          foreign key (user_id) references User(user_id),
                          foreign key (post_id) references Post(post_id)
);