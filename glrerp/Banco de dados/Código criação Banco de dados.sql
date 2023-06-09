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
	email varchar(150) not null,
	senha varchar (150) not null,
	hierarquia varchar (45) not null,
	ativo boolean not null,
	email varchar(150) not null,
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
	unidade_medida varchar(45) not null,
	observacao text,
	conv1 double precision,
	und_conv1 varchar(45),
	conv2 double precision,
	und_conv2 varchar(45),
	valor decimal (10,2) not null,
	qtde_estoque_min double precision null,
	primary key(id),
	constraint fk_id_grupo foreign key (id_grupo) references grupo (id)
);

create table estrutura(
	id serial not null,
	item_id int not null,
	insumo_id int not null,
	qtde_insumo double precision not null,
	ativo boolean not null,
	und_medida varchar(45) not null,
	valor_estrutura decimal (10,2),
	primary key (id),
	constraint fk_item_id foreign key (item_id) references item (id),
	constraint fk_insumo_id foreign key (insumo_id) references item (id)
);

create table movimentacao (
id serial not null,
	tipo varchar (45) not null,
	data Timestamp without Time Zone not null,
	item_id int null,
	cliente_id int not null,
	valor decimal (10,2) not null,
	qtde double precision not null,
	perda double precision not null,
	observacao varchar (500),
	id_pedido int null,
	id_grupo_movimentacao int not null,
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
);

create table adicionais(
	id serial not null,
	descricao varchar(150) not null,
	valor decimal (10,2) not null,
	ativo boolean not null,
	primary key (id)
);

create table movimentacao_adicionais(
	movimentacao_id int not null,
	adicionais_id int not null,
	qtde double precision not null,
	valor decimal(10,2) not null,
	observacao varchar (500),
	primary key(movimentacao_id),
	constraint fk_movimentacao_id foreign key (movimentacao_id) references movimentacao (id),
	constraint fk_adicionais_id foreign key (adicionais_id) references adicionais (id)
);



CREATE OR REPLACE FUNCTION calcular_valor_estrutura()
  RETURNS TRIGGER AS
$$
BEGIN
  UPDATE estrutura
  SET valor_estrutura = 
    CASE 
      WHEN estrutura.und_medida = item.unidade_medida THEN item.valor * estrutura.qtde_insumo
      WHEN estrutura.und_medida = item.und_conv1 THEN item.valor * item.conv2 * estrutura.qtde_insumo
      WHEN estrutura.und_medida = item.und_conv2 THEN item.valor / item.conv2 * estrutura.qtde_insumo
    END
  FROM item
  WHERE estrutura.insumo_id = item.id AND estrutura.ativo=true AND item.id = NEW.id;

  RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER atualizar_valor_estrutura
AFTER UPDATE ON item
FOR EACH ROW
EXECUTE FUNCTION calcular_valor_estrutura();



CREATE OR REPLACE FUNCTION calcular_valor_estoque()
  RETURNS TRIGGER AS
$$
BEGIN
  IF NEW.tipo = 'compra' THEN
    UPDATE item
    SET valor = (
        (item.qtde_estoque * item.valor + NEW.qtde * NEW.valor)
        / (item.qtde_estoque + NEW.qtde)
      ),
      qtde_estoque = item.qtde_estoque + NEW.qtde
    WHERE item.id = NEW.item_id AND item.ativo = true;
  END IF;

  RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER atualizar_valor_estoque
AFTER INSERT ON movimentacao
FOR EACH ROW
EXECUTE FUNCTION calcular_valor_estoque();




CREATE OR REPLACE FUNCTION calcular_estoque_vendaORproducao()
  RETURNS TRIGGER AS
$$
BEGIN
  IF NEW.tipo = 'venda' OR NEW.tipo = 'producao' THEN
    UPDATE item
    SET qtde_estoque = item.qtde_estoque + NEW.qtde
    WHERE item.id = NEW.item_id AND item.ativo = true;
  END IF;

  RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER calcular_estoque_vendaORproducao
AFTER INSERT ON movimentacao
FOR EACH ROW
EXECUTE FUNCTION calcular_estoque_vendaORproducao();