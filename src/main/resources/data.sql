/* -- table -- */
drop table if exists access_permits;
drop table if exists role_type;
drop table if exists user;
drop table if exists router_link;

create table role_type (
    rt_id int auto_increment  primary key,
    rt_name varchar(10) not null,
    rt_acronym varchar(2) unique not null,
    rt_description varchar(100) not null
);

create table user (
    us_id int auto_increment  primary key,
    us_full_name varchar(100) not null,
    us_email varchar(100) unique not null,
    us_password varchar(100) null
);

create table router_link (
    rl_id int auto_increment  primary key,
    rl_label varchar(50) not null,
    rl_icon varchar(50) not null,
    rl_url varchar(100) not null,
    rl_description varchar(500) null
);

create table access_permits (
    ap_id int auto_increment primary key,
    ap_router_link_id int not null,
    ap_role_type_id int not null,
    ap_user_id int not null
);

alter table access_permits add foreign key (ap_role_type_id) references role_type(rt_id);
alter table access_permits add foreign key (ap_user_id) references user(us_id);
alter table access_permits add foreign key (ap_router_link_id) references router_link(rl_id);

/* -- data -- */

insert into role_type (rt_name,rt_acronym,rt_description) values ('Administrador','A','Persona encargar de multiples tareas y permisos adsolutos en la aplicaciona.');
insert into role_type (rt_name,rt_acronym,rt_description) values ('Usuario','U','Cliente del establecimiento con limitadas funciones en la aplicacion.');

insert into router_link (rl_label,rl_icon,rl_url,rl_description) values ('Dashboard','dashboard','/dashboard','Listado de todoslos servicios que ofrece el establecimiento.');
insert into router_link (rl_label,rl_icon,rl_url,rl_description) values ('Database','database','/database','Acceso completo a las funcionalidades del gesto de appointment.');
insert into router_link (rl_label,rl_icon,rl_url,rl_description) values ('Report','print','/report','Acceso a los reportes de la aplicacion.');
insert into router_link (rl_label,rl_icon,rl_url,rl_description) values ('Security','security','/security',null);
insert into router_link (rl_label,rl_icon,rl_url,rl_description) values ('Extensions','extension','/extension',null);
insert into router_link (rl_label,rl_icon,rl_url,rl_description) values ('Settings','settings','/settings',null);

insert into user (us_full_name,us_email,us_password) values ('Andres Felipe','andres@andres.com','$2a$10$hTabkNtiNB3WCTHT2Y8DuOLgbS.NXYaxjr2eAxgbMKqVXr4bPqh5O');
insert into user (us_full_name,us_email,us_password) values ('Luis Sanchez','luis.sanchez@luis.com','$2a$10$hTabkNtiNB3WCTHT2Y8DuOLgbS.NXYaxjr2eAxgbMKqVXr4bPqh5O');

insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (1,1,1);
insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (2,1,1);
insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (3,1,1);
insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (4,1,1);
insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (5,1,1);
insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (6,1,1);

insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (1,2,2);
insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (2,2,2);
insert into access_permits (ap_router_link_id,ap_role_type_id,ap_user_id) values (6,2,2);