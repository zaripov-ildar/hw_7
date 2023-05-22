create table if not exists students
(
    id   bigint primary key,
    name varchar(50),
    age  int
);
insert into students (name, age)
values ('Bob', 50),
       ('Mike', 35),
       ('Alice', 22);