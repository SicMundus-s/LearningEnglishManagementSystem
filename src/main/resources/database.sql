create table words(
                      id int generated always as identity unique,
                      word varchar not null,
                      translate varchar not null
);

create table users(
                      id int generated always as identity unique,
                      "login" varchar(100) not null,
                      "password" varchar(100) not null,
                      email_address varchar(150) not null
);

create table dictionary(
                           user_id int references users(id) ON DELETE CASCADE,
                           word_id int references words(id) ON DELETE CASCADE
);

create table role(
                     id int generated always as identity unique ,
                     name varchar(100) not null
);

create table user_roles(
                           user_id int references users(id),
                           role_id int references role(id)
);


create table categories(
                           id int generated always as identity unique,
                           name varchar(100) not null
);

create table categories_of_words(
                                    category_id int references categories(id) ON DELETE CASCADE,
                                    word_id int references words(id) ON DELETE CASCADE
);



INSERT INTO role(name) VALUES ('ROLE_USER');
INSERT INTO role(name) VALUES ('ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);
UPDATE user_roles SET role_id = 2 WHERE user_id = 3;
UPDATE user_roles SET role_id = 2 WHERE user_id = 11;

insert into words(word, translate) values ('as', 'как');
insert into words(word, translate) values ('his', 'его');
insert into words(word, translate) values ('that', 'что, тот');
insert into words(word, translate) values ('he', 'он');
insert into words(word, translate) values ('are', 'являются');



drop table words;
drop table users cascade;
drop table role cascade;
drop table user_roles;
drop table categories;
drop table categories_of_words;
drop table dictionary;

truncate table users cascade;