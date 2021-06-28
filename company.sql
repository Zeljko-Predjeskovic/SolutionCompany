create table if not exists personalInformations(
	personId bigint generated always as identity,
	firstName varchar(66) not null,
	lastName varchar(66) not null,
	email varchar(150) not null,
	telefone varchar(30) not null,
	fk_address bigint not null,
	
	primary key(personId)
);

create table if not exists addresses(
	addressId bigint generated always as identity,
	place varchar(40) not null,
	postCode varchar(25) not null,
	street varchar(80) not null,
	
	primary key(addressId)
	
);

alter table personalInformations add 
	constraint fk_adressId
	foreign key (fk_address) references addresses (addressId);

create table if not exists customers(
	customerId bigint generated always as identity,
	fk_personalInformation bigint not null,
	fk_servicePackage bigint not null,
	
	primary key (customerId)
	
);

create table if not exists orders(
	orderId bigint generated always as identity,
	conditions varchar(255) not null,
	description varchar(255),
	fk_customer bigint not null,
	fk_seller bigint not null,
	
	primary key(orderId)
);

create table if not exists servicePackages(
	servicePackageId bigint generated always as identity,
	serviceName varchar(255) not null,
	description varchar(255) not null,
	price int not null,
	
	primary key (servicePackageId)
	
);

create table if not exists sellers(
	sellerId bigint generated always as identity,
	fk_personalInformation bigint not null,
	fk_order bigint,

	primary key (sellerId)
);

alter table customers add
	constraint fk_personalInformation
	foreign key (fk_personalInformation)
	references personalInformations (personId);
	
alter table customers add
	constraint fk_servicePackages
	foreign key (fk_servicePackage)
	references servicePackages (servicePackageId);

alter table orders add
	constraint fk_customer
	foreign key (fk_customer)
	references customers (customerId);

alter table orders add
	constraint fk_seller
	foreign key (fk_seller)
	references sellers (sellerId);

alter table sellers add
	constraint fk_personalInformation
	foreign key (fk_personalInformation)
	references personalInformations (personId);

alter table sellers add
	constraint fk_order
	foreign key (fk_order)
	references orders (orderId);



