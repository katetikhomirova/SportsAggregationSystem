INSERT INTO season (name) VALUES ('Winter');
INSERT INTO season (name) VALUES ('Spring');
INSERT INTO season (name) VALUES ('Summer');
INSERT INTO season (name) VALUES ('Autumn');

INSERT INTO event (name) VALUES ('Working in the office');
INSERT INTO event (name) VALUES ('Business trips');
INSERT INTO event (name) VALUES ('Business meetings');
INSERT INTO event (name) VALUES ('Studying');
INSERT INTO event (name) VALUES ('Homework');
INSERT INTO event (name) VALUES ('Fitness center and gym');
INSERT INTO event (name) VALUES ('Summer sports');
INSERT INTO event (name) VALUES ('Winter sports');
INSERT INTO event (name) VALUES ('Beach holidays');
INSERT INTO event (name) VALUES ('Walking around the city');
INSERT INTO event (name) VALUES ('City leisure (cafes, cinema, etc.)');
INSERT INTO event (name) VALUES ('Clubs, party');
INSERT INTO event (name) VALUES ('Domestic leisure');
INSERT INTO event (name) VALUES ('Out of town');
INSERT INTO event (name) VALUES ('Shopping');
INSERT INTO event (name) VALUES ('Official events');
INSERT INTO event (name) VALUES ('Theatre, concert');
INSERT INTO event (name) VALUES ('Dinner at the restaurant');
INSERT INTO event (name) VALUES ('Family activities');

INSERT INTO type_of_clothing (name) VALUES ('Clothing');
INSERT INTO type_of_clothing (name) VALUES ('Footwear');
INSERT INTO type_of_clothing (name) VALUES ('Accessory');

INSERT INTO kind_of_clothing (type_id, name) VALUES (1, 'Jacket');
INSERT INTO kind_of_clothing (type_id, name) VALUES (1, 'Coat');
INSERT INTO kind_of_clothing (type_id, name) VALUES (1, 'Jeans');
INSERT INTO kind_of_clothing (type_id, name) VALUES (1, 'Underwear');
INSERT INTO kind_of_clothing (type_id, name) VALUES (2, 'Boots');
INSERT INTO kind_of_clothing (type_id, name) VALUES (2, 'Sneakers');
INSERT INTO kind_of_clothing (type_id, name) VALUES (2, 'Moccasins');
INSERT INTO kind_of_clothing (type_id, name) VALUES (3, 'Purse');
INSERT INTO kind_of_clothing (type_id, name) VALUES (3, 'Belt');
INSERT INTO kind_of_clothing (type_id, name) VALUES (3, 'Cap');

INSERT INTO brand (name) VALUES ('Zegna');
INSERT INTO brand (name) VALUES ('Hermes');
INSERT INTO brand (name) VALUES ('Fendi');
INSERT INTO brand (name) VALUES ('Louis Vuitton');
INSERT INTO brand (name) VALUES ('Salvatore Ferragamo');
INSERT INTO brand (name) VALUES ('Gucci');
INSERT INTO brand (name) VALUES ('Dolce & Gabbana');
INSERT INTO brand (name) VALUES ('Prada');
INSERT INTO brand (name) VALUES ('Giorgio Armani');
INSERT INTO brand (name) VALUES ('Christian Dior');
INSERT INTO brand (name) VALUES ('Versace');

INSERT INTO role (id, name) VALUES (0, 'ADMINISTRATOR');
INSERT INTO role (id, name) VALUES (1, 'USER');

INSERT INTO users (email, name, password_hash, role_id)
VALUES ('user@gmail.com', 'User User', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 1);

INSERT INTO users (email, name, password_hash, role_id)
VALUES ('user2@gmail.com', 'User2 User', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 1);