create table popular_words(
                              id int generated always as identity unique,
                              word varchar not null,
                              translate varchar not null
);

create table words(
                      id int generated always as identity unique,
                      word varchar not null,
                      translate varchar not null
);

create table users(
                      id int generated always as identity unique,
                      "login" varchar(100) not null,
                      "password" varchar(100) not null,
                      email_address varchar(150) not null,
                      popular_words_id int REFERENCES popular_words(id) ON DELETE CASCADE
);

create table role(
                     id int generated always as identity unique ,
                     name varchar(100) not null
);

create table user_roles(
                           user_id int references users(id),
                           role_id int references role(id)
);

create table incorrect_translation(
                                      user_id int references users(id) ON DELETE CASCADE,
                                      word_id int references popular_words(id) ON DELETE CASCADE
);



INSERT INTO role(name) VALUES ('ROLE_USER');
INSERT INTO role(name) VALUES ('ROLE_ADMIN');
