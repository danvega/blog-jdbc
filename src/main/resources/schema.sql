-- noinspection SqlNoDataSourceInspectionForFile

-- author
create table Author(
    post int primary key, -- The table of the referenced entity is expected to have an additional column named the same as the table of the referencing entity.
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(255) not null
);
-- post
create table Post (
    id int auto_increment,
    title varchar(255) not null,
    content text not null,
    published_on timestamp not null,
    updated_on timestamp not null,
    primary key (id)
);


-- comment
-- create table Comment(
--     id int auto_increment,
--     content text not null,
--     post_id bigint not null,
--     author_id bigint not null,
--     published_on timestamp not null,
--     updated_on timestamp not null,
--     primary key (id),
--     foreign key (post_id) references Post(id),
--     foreign key (author_id) references Author(id)
-- );