create table Consumos (
	codigoConsumo int(10) AUTO_INCREMENT not null,
	kmPrevista double (20, 20) not null,
	primary key (codigoConsumo)
);

create table Motoristas (
	codigoMotorista int (10) AUTO_INCREMENT not null,
	idade int (2),
	sexo varchar (1),
	primary key (codigoMotorista)
);

create table Conducoes (
	codigoConducao int (10) AUTO_INCREMENT not null,
	avatarCondutor varchar (20),
	estiloDirecao varchar (50),
	primary key (codigoConducao)
);

create table Trajetos (
	codigoTrajeto int (10) AUTO_INCREMENT not null,
	longitude double (10,10),
	latitude double (10,10),
	primary key (codigoTrajeto)
); 

create table Veiculos (
	codigoVeiculo int (10) AUTO_INCREMENT not null,
	marca varchar (20) not null,
	modelo varchar (20) not null,
	versao varchar (20) not null,
	motor varchar (20) not null,
	peso float (10,10) not null,
	calibragemPneus varchar (20) not null,
	tipoPneus varchar (20) not null,
	primary key (codigoVeiculo)
); 

create table Abastecimentos (
	codigoAbastecimento int (10) AUTO_INCREMENT not null,
	combustivel varchar (5) not null,
	quantidade float (5,5) not null,
	primary key (codigoAbastecimento)
);
