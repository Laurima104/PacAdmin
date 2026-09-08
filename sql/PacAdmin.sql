--create tables section--

create table if not exists tb_admins(
id serial primary key,
nome varchar(255) not null,
email varchar(255) not null,
senha varchar(255) not null
);

create table if not exists tb_usuarios(
id serial primary key,
nome varchar(255) not null,
email varchar(255) not null,
senha varchar(255) not null,
nivel integer not null default 1
);

create table if not exists tb_modulos(
id serial primary key,
titulo varchar(100) not null,
conteudo varchar(2000)
);

create table if not exists tb_quizzes(
id serial primary key,
pergunta varchar(255) not null,
modulo integer not null
);

--foreing key section--



--alter table section--



--insert values sesction--

insert into tb_admins(nome, email, senha) values ('teste', 'teste@pac.com.br', '1234');