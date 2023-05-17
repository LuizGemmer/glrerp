create table cliente (
id serial not null,
	tipo varchar(45) not null,
	nome varchar(150) not null,
	cpf varchar(45) not null,
	email varchar(150) not null,
	telefone varchar (45) not null,
	endereco varchar(250),
	ativo boolean not null,
	primary key (id)
);

create table usuario (
id serial not null,
	nome varchar(150) not null,
	senha varchar (45) not null,
	hierarquia varchar (45) not null,
	ativo boolean not null,
	primary key (id)
);

create table grupo (
id serial not null,
	descricao varchar (100) not null,
	tipo varchar (45) not null,
	ativo boolean not null,
	primary key (id)
);

create table item (
id serial not null,
	id_grupo int not null,
	descricao varchar (150) not null,
	qtde_estoque double precision not null,
	ativo boolean not null,
	primary key(id),
	constraint fk_id_grupo foreign key (id_grupo) references grupo (id)
);

create table estrutura(
id serial not null,
	item_id int not null,
	insumo_id int not null,
	qtde_insumo double precision not null,
	ativo boolean not null,
	primary key (id),
	constraint fk_item_id foreign key (item_id) references item (id),
	constraint fk_insumo_id foreign key (insumo_id) references item (id)
);

create table movimentacao (
id serial not null,
	tipo varchar (45) not null,
	data Timestamp without Time Zone not null,
	item_id int not null,
	cliente_id int not null,
	valor decimal (10,2) not null,
	qtde double precision not null,
	perda double precision not null,
	observacao varchar (500),
	primary key(id),
	constraint fk_item_id foreign key (item_id) references item (id),
	constraint fk_cliente_id foreign key (cliente_id) references cliente (id)
);

create table movimentacao_usuario(
movimentacao_id int not null,
	usuario_id int not null,
	primary key (movimentacao_id),
	constraint fk_movimentacao_id foreign key (movimentacao_id) references movimentacao (id),
	constraint fk_usuario_id foreign key (usuario_id) references usuario (id)
)