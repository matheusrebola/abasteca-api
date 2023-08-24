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
