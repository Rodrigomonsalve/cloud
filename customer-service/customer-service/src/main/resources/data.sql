DROP TABLE IF EXISTS tbl_regions;
CREATE TABLE tbl_regions (id int auto_increment primary key, name varchar(20));

DROP TABLE IF EXISTS tbl_customers;
CREATE TABLE tbl_customers (id int auto_increment primary key, number_id varchar(20), first_name varchar(20), last_name varchar(20), email varchar(30), photo_url varchar(50), region_id int, state varchar(15));

INSERT INTO tbl_regions (id, name) VALUES (1, 'Sudamérica');
INSERT INTO tbl_regions (id, name) VALUES (2, 'Centroamérica');
INSERT INTO tbl_regions (id, name) VALUES (3, 'Norteamérica');
INSERT INTO tbl_regions (id, name) VALUES (4, 'Europa');
INSERT INTO tbl_regions (id, name) VALUES (5, 'Asia');
INSERT INTO tbl_regions (id, name) VALUES (6, 'Africa');
INSERT INTO tbl_regions (id, name) VALUES (7, 'Oceanía');
INSERT INTO tbl_regions (id, name) VALUES (8, 'Antártida');

INSERT INTO tbl_customers (id,number_id,first_name,last_name , email, photo_url, region_id, state) VALUES(1,'32404580', 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com','',1,'CREATED');