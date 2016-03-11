--<!-- 
--Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
--With inputs from 
--Biajay Sahoo			batch-2001
--Sundeep Mohanty (Tutu)	batch-2001
--Sambit Satpathy			batch-2000
--Soumya Mohanty (Bapi) 	batch-2001
--Kamalesh Nayak			batch-2001
 -->

create table member (id int not null auto_increment primary key, 
username varchar(25) not null, enabled tinyint not null default 1,
name varchar(100) not null, password varchar(100) not null, batch_yr int not null, reg_date datetime not null,
roll_no varchar(20), about_you varchar(128), profession varchar(128), hobby varchar(128), 
contact_address varchar(128), contact_no varchar(20), 
contact_email varchar(100) not null, display_contact tinyint not null default 0, location varchar(100), 
unique key uni_username (username)
)

create table role (id int not null auto_increment,
username varchar(25) not null, 
role varchar(45) not null, 
primary key(id),
unique key uni_username (username),
key fk_username_idx(username),
constraint fk_username foreign key (username) 
references member(username))

