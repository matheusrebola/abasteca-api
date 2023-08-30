create table Consumo (
	codigoConsumo int(10) AUTO_INCREMENT not null,
	kmPrevista double (20, 20) not null,
	primary key (codigoConsumo)
);

create table Motorista(
	codigoMotorista int (10) AUTO_INCREMENT not null,
	idade int (2),
	sexo varchar (1),
	primary key (codigoMotorista)
);

create table Conducao (
	codigoConducao int (10) AUTO_INCREMENT not null,
	avatarCondutor varchar (20),
	estiloDirecao varchar (50),
	primary key (codigoConducao)
);

create table Trajeto (
	codigoTrajeto int (10) AUTO_INCREMENT not null,
	longitude double (10,10),
	latitude double (10,10),
	primary key (codigoTrajeto)
); 

create table Veiculo (
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

create table Abastecimento (
	codigoAbastecimento int (10) AUTO_INCREMENT not null,
	combustivel varchar (5) not null,
	quantidade float (5,5) not null,
	primary key (codigoAbastecimento)
);
