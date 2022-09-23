-- noinspection SqlNoDataSourceInspectionForFile

-- author
create table Author(
    id int auto_increment primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(255) not null,
    username varchar(100) not null
);
-- post
create table Post (
    id int auto_increment primary key ,
    title varchar(255) not null,
    content text not null,
    published_on timestamp not null,
    updated_on timestamp not null,
    author_id int not null,
    foreign key (author_id) references Author(id)
);

-- comment
create table Comment(
    id int auto_increment primary key ,
    name varchar(100) not null,
    content text not null,
    post_id int not null,
    published_on timestamp not null,
    updated_on timestamp not null,
    foreign key (post_id) references Post(id)
);