CREATE DATABASE agenda;
use agenda;
CREATE TABLE contato(
id int primary key auto_increment,
nome varchar(100) not null,
fone varchar(15),
email varchar(100) not null,
observacao tinytext
);
-- Mostra a estrutura da tabela
describe contato;

-- excluir uma tabela
drop table contato;

CREATE TABLE contato(
id int primary key auto_increment,
nome varchar(100) not null,
fone varchar(15),
email varchar(100) not null,
dataCadastro date,
observacao tinytext
);

insert into contato(nome, fone, email, observacao)
values("adriano","(47) 0 0000 0000","adriano@email.com","tem medo de programar...hahah");

insert into contato(nome, fone, email, observacao)
values("Ronan","(47) 1 1111 1111","ronan@email.com","qualquer coisa");

insert into contato(nome, fone, email, observacao)
values("Alico","(47) 2 2222 2222","alicio@email.com","professor proway");

insert into contato(nome, fone, email, observacao)
values("Adenilson","(47) 3 3333 3333","adenilson@email.com","o paranaense");

-- all tudo


-- update - atualizar
update contato
set nome = "Alico"
where id = 3;

CREATE TABLE contato(
id int primary key auto_increment,
nome varchar(100) not null,
fone varchar(15),
email varchar(100) not null,
observacao tinytext
);
delete from contato where id = 1;

alter table contato add column data_cadastro datetime default now() 

