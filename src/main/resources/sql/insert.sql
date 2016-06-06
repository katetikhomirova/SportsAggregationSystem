INSERT INTO `sport_aggregation_system`.`unit`(`id`,`unitName`) VALUES(null,'sec');
INSERT INTO `sport_aggregation_system`.`unit`(`id`,`unitName`) VALUES(null,'min');
INSERT INTO `sport_aggregation_system`.`unit`(`id`,`unitName`) VALUES(null,'hour');
INSERT INTO `sport_aggregation_system`.`unit`(`id`,`unitName`) VALUES(null,'m');
INSERT INTO `sport_aggregation_system`.`unit`(`id`,`unitName`) VALUES(null,'point');

INSERT INTO `sport_aggregation_system`.`userrole` (`name`) VALUES ('admin');
INSERT INTO `sport_aggregation_system`.`userrole` (`name`) VALUES ('sportsmen');
INSERT INTO `sport_aggregation_system`.`userrole` (`name`) VALUES ('organisator');

INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Merited Master of Sport');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Master of Sport, International Class');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Master of Sport');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Candidate for Master of Sport');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('First-Class Sportsman');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Second-Class Sportsman');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Third-Class Sportsman');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('First-Class Junior Sportsman');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Second-Class Junior Sportsman');
INSERT INTO `sport_aggregation_system`.`sportrank` (`name`) VALUES ('Third-Class Junior Sportsman');

INSERT INTO `sport_aggregation_system`.`status` (`name`) VALUES ('The highest level (world and continental scale competitions)');
INSERT INTO `sport_aggregation_system`.`status` (`name`) VALUES ('Level 1 (competitions carried by country sports federation)');
INSERT INTO `sport_aggregation_system`.`status` (`name`) VALUES ('Level 2 (competitions carried by state sports federations)');
INSERT INTO `sport_aggregation_system`.`status` (`name`) VALUES ('Level 3 (competitions carried by city or area sports federations)');


INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('run');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('volleyball');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('shot put');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('pedestrianism');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('swimming');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('football');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('javelin-throwing');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('gymnastics');
INSERT INTO `sport_aggregation_system`.`sportcategory` (`name`) VALUES ('curling');

INSERT INTO `sport_aggregation_system`.`sport` (`name`, `isCommand`, `sportCategory`) VALUES ('run 60 m',  false, '1');
INSERT INTO `sport_aggregation_system`.`sport` (`name`, `isCommand`, `sportCategory`) VALUES ('run 100 m', false, '1');
INSERT INTO `sport_aggregation_system`.`sport` (`name`, `isCommand`, `sportCategory`) VALUES ('run 200 m', false, '1');
INSERT INTO `sport_aggregation_system`.`sport` (`name`, `isCommand`, `sportCategory`) VALUES ('volleyball', false, '2');
INSERT INTO `sport_aggregation_system`.`sport` (`name`, `isCommand`, `sportCategory`) VALUES ('beach volleyball', false, '2');

INSERT INTO `sport_aggregation_system`.`place` (`name`, `lat`, `lng`, `description`) VALUES ('Metalist Stadium', '49.980728', '36.261489', 'Stadium and the stadium ticket office pavilion were included in the Register of cultural and national heritage of Ukraine.','Plekhanivs\'ka St, 65, Kharkiv, Kharkiv Oblast, Ukraine');
INSERT INTO `sport_aggregation_system`.`place` (`name`, `lat`, `lng`, `description`) VALUES ('NURE gym', '50.015669', '36.227012', 'NURE gym on 4th floor','Bakulina St, 10, Kharkiv, Kharkiv Oblast, Ukraine');
INSERT INTO `sport_aggregation_system`.`place` (`name`, `lat`, `lng`, `description`) VALUES ('NURE football stadium', '50.015669', '36.227012', 'Football stadium near NURE','Bakulina St, 10, Kharkiv, Kharkiv Oblast, Ukraine');

INSERT INTO `sport_aggregation_system`.`user` (`login`, `password`, `firstName`, `lastName`, `email`, `gender`, `role`, `active`) VALUES ('admin', 'admin', 'Kate', 'Tikhomirova', 'romas4ka94@gmail.com', '1', '1', true);


