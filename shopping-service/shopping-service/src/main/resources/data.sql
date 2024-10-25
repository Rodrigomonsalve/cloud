DROP TABLE IF EXISTS tlb_invoices;
CREATE TABLE  tlb_invoices(id int AUTO_INCREMENT PRIMARY KEY, number_invoice varchar(30), description varchar(30), customer_id int,
create_at TIMESTAMP, state varchar(30));

INSERT INTO tlb_invoices (id, number_invoice, description, customer_id, create_at, state) VALUES(1, '0001', 'invoice office items', 1, NOW(),'CREATED');

DROP TABLE IF EXISTS tbl_invoce_items;
CREATE TABLE tbl_invoce_items ( invoice_id int AUTO_INCREMENT PRIMARY KEY, product_id INT, quantity INT, price INT);

INSERT INTO tbl_invoce_items ( invoice_id , product_id, quantity, price ) VALUES(1, 1 , 1, 178.89);
INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price)  VALUES(2, 2 , 2, 12.5);
INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price)  VALUES(3, 3 , 1, 40.06);