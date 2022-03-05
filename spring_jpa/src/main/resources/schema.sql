create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null,
  PRIMARY KEY (id)
); 
create table if not exists Taco (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50) not null,
  created_at timestamp not null,
  PRIMARY KEY (id)
); 
create table if not exists Taco_Ingredients (
  taco_id int not null,
  ingredients_id varchar(4) not null,
  FOREIGN KEY (taco_id) REFERENCES Taco(id),
  FOREIGN KEY (ingredients_id) REFERENCES Ingredient(id)
); 

create table if not exists Taco_Order (
	id int NOT NULL AUTO_INCREMENT,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(10) not null,
    zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cccvv varchar(3) not null,
    placed_at timestamp not null,
	PRIMARY KEY (id)
);
create table if not exists Taco_Order_Tacos (
  tacoOrder_id int not null,
  taco_id int not null,
  FOREIGN KEY (tacoOrder_id) REFERENCES Taco_Order(id),
  FOREIGN KEY (taco_id) REFERENCES Taco(id)
); 