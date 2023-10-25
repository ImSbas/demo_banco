create database demo;

show databases;

use demo;

drop table Cliente;
drop table Status;

create table Status(
                       id_status integer not null primary key auto_increment,
                       description varchar(15) not null
);

insert into status(description) values('activo');
insert into status(description) values('inactivo');


create table Cliente(
                        id integer  AUTO_INCREMENT NOT NULL PRIMARY KEY,
                        name varchar(50) NOT NULL,
                        gender CHAR(1) NOT NULL CHECK (gender = 'M' or gender = 'F'),
                        date_of_birth varchar(40) NOT NULL,
                        direction varchar(40) NOT NULL,
                        telephone varchar(10) NOT NULL,
                        status integer default (1),
                        identification varchar(15) not null,
                        password varchar(70) NOT NULL,
                        FOREIGN KEY (status) REFERENCES Status(id_status)
);

drop table tipocuenta;
drop table cuenta;
drop table tipomovimiento;
drop table Movimiento;

CREATE TABLE TipoCuenta(
                           id integer auto_increment primary key ,
                           description varchar(20) not null
);

insert into tipocuenta(description) values ('debito');
insert into tipocuenta(description) values ('credito');

CREATE TABLE Cuenta(
                       number varchar(70) not null primary key,
                       type integer not null,
                       balance integer not null,
                       status_id integer not null,
                       owner_id integer not null,
                       FOREIGN KEY (type) references TipoCuenta(id),
                       FOREIGN KEY (owner_id) references cliente(id),
                       FOREIGN KEY (status_id) references status(id_status)
);

create table TipoMovimiento(
                               id integer auto_increment primary key ,
                               description varchar(20) not null
);

insert into tipomovimiento(description) values ('abono');
insert into tipomovimiento(description) values ('retiro');


CREATE TABLE Movimiento (
                            id integer not null primary key auto_increment,
                            fecha DATE not null,
                            type_id integer not null,
                            value integer not null,
                            card varchar(70) not null,
                            foreign key (card) references cuenta(number),
                            foreign key (type_id) references tipomovimiento(id)
);

alter table movimiento
    modify fecha DATETIME not null;
