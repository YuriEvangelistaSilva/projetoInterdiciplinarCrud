//* nome do bd proje_inter4*//
create table publico(
	idPublico serial primary key,
	idadePublico varchar(10)
);
insert into publico(idadePublico) values(12);

create table genero(
	idgenero serial primary key,
	tipogenero varchar(50),
	descricaogenero varchar(1000)
);

insert into genero(idgenero,tipogenero, descricaogenero)values(1,'tiro','Jogo de armas');

create table game(
	idgame serial primary key,
	nome varchar(20),
	categoria varchar(20),
	nota_total varchar(3),
	descricao_game varchar(100),
	situacao varchar(1) not null,
	idgenero int not null,
	constraint fk_genero foreign key (idgenero) references genero(idgenero)
	
);
insert into game(nome,categoria,nota_total,descricao_game,situacao,idgenero)values('gta','ação','8.9','jogo de vida do crime','A',1);

create table plataforma(
	idplataforma serial primary key,
	nomeplataforma varchar(20)
);
insert into plataforma(nomeplataforma) values('polystation');

create table catalogo(
	idcatalogo serial primary key,
	nomecatalogo varchar(50),
	tipocatalogo varchar(200),
	situacao varchar(1) not null,
	idgame int not null,
	constraint fk_game foreign key (idgame) references game(idgame)	
);

insert into catalogo(nomecatalogo, tipocatalogo, situacao, idgame)values('valorant', 'Counter Striker com poder', 'A', 1);

create table conta(
 idconta serial primary key,
	 nomeusuario varchar(50),
	 emailconta varchar(100),
	 senhaconta varchar(16)
	 
 );

select * from plataforma;
select * from publico;
select *from genero;
select * from game;