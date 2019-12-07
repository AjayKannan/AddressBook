
CREATE TABLE IF NOT EXISTS Contact (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  surname VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS Contact_Address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  postcode VARCHAR(250) NOT NULL,
  street_name VARCHAR(250) NOT NULL,
  primary_address BOOLEAN NOT NULL,
  contact_id_fk INT,
  foreign key (contact_id_fk) references Contact(id)
);

insert into Contact(first_name,surname) values('ajay','kannan');
insert into Contact(first_name,surname) values('Tom','Major');
insert into Contact(first_name,surname) values('Gareth','Major');

insert into Contact_Address(postcode,street_name,primary_address,contact_id_fk) values('AL13QR','Hillside road','Y',(select id from Contact where first_name='ajay'));
insert into Contact_Address(postcode,street_name,primary_address,contact_id_fk) values('GL72HD','Stable mews','N',(select id from Contact where first_name='ajay'));

insert into Contact_Address(postcode,street_name,primary_address,contact_id_fk) values('BT60GR','Alstone Mews','Y',(select id from Contact where first_name='Tom'));