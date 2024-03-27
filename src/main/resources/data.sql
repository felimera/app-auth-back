/* -- table -- */
drop table if exists tbl_access_permits;
drop table if exists tbl_user;
drop table if exists tbl_role_type;
drop table if exists tbl_router_link;

create table tbl_role_type (
    rt_id int auto_increment  primary key,
    rt_name varchar(20) not null,
    rt_acronym varchar(2) unique not null,
    rt_description varchar(1000) null
);

create table tbl_user (
    us_id int auto_increment  primary key,
    us_full_name varchar(100) not null,
    us_email varchar(100) unique not null,
    us_password varchar(100) null,
    us_role_type_id int not null
);

create table tbl_router_link (
    rl_id int auto_increment  primary key,
    rl_label varchar(50) not null,
    rl_icon varchar(50) not null,
    rl_url varchar(100) not null,
    rl_description varchar(1000) null
);

create table tbl_access_permits (
    ap_id int auto_increment primary key,
    ap_router_link_id int not null,
    ap_role_type_id int not null
);

alter table tbl_access_permits add foreign key (ap_role_type_id) references tbl_role_type(rt_id);
alter table tbl_access_permits add foreign key (ap_router_link_id) references tbl_router_link(rl_id);
alter table tbl_user add foreign key (us_role_type_id) references tbl_role_type(rt_id);

/* -- data -- */

insert into tbl_role_type (rt_name,rt_acronym,rt_description) values ('Administrador','A','Persona encargar de multiples tareas y permisos adsolutos en la aplicaciona.');
insert into tbl_role_type (rt_name,rt_acronym,rt_description) values ('Usuario','U','Cliente del establecimiento con limitadas funciones en la aplicacion.');

insert into tbl_router_link (rl_label,rl_icon,rl_url,rl_description) values ('Dashboard','dashboard','/dashboard','Listado de todoslos servicios que ofrece el establecimiento.');
insert into tbl_router_link (rl_label,rl_icon,rl_url,rl_description) values ('Database','database','/database','Acceso completo a las funcionalidades del gesto de appointment.');
insert into tbl_router_link (rl_label,rl_icon,rl_url,rl_description) values ('Report','print','/report','Acceso a los reportes de la aplicacion.');
insert into tbl_router_link (rl_label,rl_icon,rl_url,rl_description) values ('Security','security','/security',null);
insert into tbl_router_link (rl_label,rl_icon,rl_url,rl_description) values ('Extensions','extension','/extension',null);
insert into tbl_router_link (rl_label,rl_icon,rl_url,rl_description) values ('Settings','settings','/settings',null);

insert into tbl_user (us_full_name,us_email,us_password,us_role_type_id) values ('Andres Felipe','andres@andres.com','$2a$10$hTabkNtiNB3WCTHT2Y8DuOLgbS.NXYaxjr2eAxgbMKqVXr4bPqh5O',1);
insert into tbl_user (us_full_name,us_email,us_password,us_role_type_id) values ('Luis Sanchez','luis.sanchez@luis.com','$2a$10$hTabkNtiNB3WCTHT2Y8DuOLgbS.NXYaxjr2eAxgbMKqVXr4bPqh5O',2);

insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (1,1);
insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (2,1);
insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (3,1);
insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (4,1);
insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (5,1);
insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (6,1);

insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (1,2);
insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (2,2);
insert into tbl_access_permits (ap_router_link_id,ap_role_type_id) values (6,2);