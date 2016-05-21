SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `sport_aggregation_system` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`sportRank`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`sportRank` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`sportCategory`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`sportCategory` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`sport`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`sport` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `isCommand` TINYINT(1) NOT NULL DEFAULT false ,
  `sportCategory` INT(11) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `sport_category_idx` (`sportCategory` ASC) ,
  CONSTRAINT `sport_category`
    FOREIGN KEY (`sportCategory` )
    REFERENCES `sport_aggregation_system`.`sportCategory` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`unit`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`unit` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `unitName` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`standart`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`standart` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `numberOfTimes` INT NULL ,
  `takePosition` INT NULL ,
  `value` INT NULL ,
  `units` INT NULL ,
  `gender` ENUM('female', 'male') NULL ,
  `ceilingAge` INT NULL ,
  `floorAge` INT NULL ,
  `sportRank` INT NOT NULL ,
  `sportId` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `sport_rank_id_standarts_idx` (`sportRank` ASC) ,
  INDEX `sport_id_standarts_idx` (`sportId` ASC) ,
  INDEX `units_id_standarts_idx` (`units` ASC) ,
  CONSTRAINT `sport_rank_id_standarts`
    FOREIGN KEY (`sportRank` )
    REFERENCES `sport_aggregation_system`.`sportRank` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sport_id_standarts`
    FOREIGN KEY (`sportId` )
    REFERENCES `sport_aggregation_system`.`sport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `units_id_standarts`
    FOREIGN KEY (`units` )
    REFERENCES `sport_aggregation_system`.`unit` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`userRole`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`userRole` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `firstName` VARCHAR(50) NOT NULL ,
  `lastName` VARCHAR(50) NOT NULL ,
  `rating` INT(11) NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `gender` ENUM('female','male') NOT NULL ,
  `birthday` DATE NULL DEFAULT NULL ,
  `role` INT(11) NULL DEFAULT NULL ,
  `rank` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  INDEX `user_role_id_idx` (`role` ASC) ,
  INDEX `user_sport_rank_idx` (`rank` ASC) ,
  CONSTRAINT `user_role_id`
    FOREIGN KEY (`role` )
    REFERENCES `sport_aggregation_system`.`userRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_sport_rank`
    FOREIGN KEY (`rank` )
    REFERENCES `sport_aggregation_system`.`sportRank` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`userSport`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`userSport` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `userId` INT(11) NULL DEFAULT NULL ,
  `sportId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id_idx` (`userId` ASC) ,
  INDEX `sport_id_idx` (`sportId` ASC) ,
  CONSTRAINT `user_id_user_sport`
    FOREIGN KEY (`userId` )
    REFERENCES `sport_aggregation_system`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sport_id_user_sport`
    FOREIGN KEY (`sportId` )
    REFERENCES `sport_aggregation_system`.`sport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`team`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`team` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NULL ,
  `userSport` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_sport_idx` (`userSport` ASC) ,
  CONSTRAINT `user_sport`
    FOREIGN KEY (`userSport` )
    REFERENCES `sport_aggregation_system`.`userSport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`user_team`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`user_team` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `userId` INT NULL ,
  `teamId` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id_user_teams_idx` (`userId` ASC) ,
  INDEX `team_id_user_teams_idx` (`teamId` ASC) ,
  CONSTRAINT `user_id_user_teams`
    FOREIGN KEY (`userId` )
    REFERENCES `sport_aggregation_system`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `team_id_user_teams`
    FOREIGN KEY (`teamId` )
    REFERENCES `sport_aggregation_system`.`team` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`status`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`country`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`city`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`city` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `countryId` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `country_id_cities_idx` (`countryId` ASC) ,
  CONSTRAINT `country_id_cities`
    FOREIGN KEY (`countryId` )
    REFERENCES `sport_aggregation_system`.`country` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`place`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`place` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `cityId` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `city_id_places_idx` (`cityId` ASC) ,
  CONSTRAINT `city_id_places`
    FOREIGN KEY (`cityId` )
    REFERENCES `sport_aggregation_system`.`city` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`competition`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`competition` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `startDate` DATETIME NOT NULL ,
  `endDate` DATETIME NOT NULL ,
  `open` TINYINT(1) NOT NULL DEFAULT false ,
  `placeId` INT NULL ,
  `statusId` INT(11) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `status_id_competition_idx` (`statusId` ASC) ,
  INDEX `place_id_sport_competition_idx` (`placeId` ASC) ,
  CONSTRAINT `status_id_competition`
    FOREIGN KEY (`statusId` )
    REFERENCES `sport_aggregation_system`.`status` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `place_id_sport_competition`
    FOREIGN KEY (`placeId` )
    REFERENCES `sport_aggregation_system`.`place` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`sportCompetition`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`sportCompetition` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `sport` INT NOT NULL ,
  `sportCompetition` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `sport_competition_sport_id_idx` (`sport` ASC) ,
  INDEX `sport_competition_sport_competition_id_idx` (`sportCompetition` ASC) ,
  CONSTRAINT `sport_competition_sport_id`
    FOREIGN KEY (`sport` )
    REFERENCES `sport_aggregation_system`.`sport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sport_competition_sport_competition_id`
    FOREIGN KEY (`sportCompetition` )
    REFERENCES `sport_aggregation_system`.`competition` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`competitor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`competitor` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `position` INT NULL ,
  `teamId` INT NULL ,
  `sportCompetition` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `team_id_competitors_idx` (`teamId` ASC) ,
  INDEX `sport_competition_competitor_idx` (`sportCompetition` ASC) ,
  CONSTRAINT `team_id_competitors`
    FOREIGN KEY (`teamId` )
    REFERENCES `sport_aggregation_system`.`team` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sport_competition_competitor`
    FOREIGN KEY (`sportCompetition` )
    REFERENCES `sport_aggregation_system`.`sportCompetition` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`stage`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`stage` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `sportCompetition` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `stage_sport_competition_idx` (`sportCompetition` ASC) ,
  CONSTRAINT `stage_sport_competition`
    FOREIGN KEY (`sportCompetition` )
    REFERENCES `sport_aggregation_system`.`sportCompetition` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`result`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`result` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `result` INT NULL ,
  `unit` INT NULL ,
  `competitor` INT NULL ,
  `stage` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `result_unit_idx` (`unit` ASC) ,
  INDEX `result_competitor_idx` (`competitor` ASC) ,
  INDEX `result_stage_idx` (`stage` ASC) ,
  CONSTRAINT `result_unit`
    FOREIGN KEY (`unit` )
    REFERENCES `sport_aggregation_system`.`unit` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `result_competitor`
    FOREIGN KEY (`competitor` )
    REFERENCES `sport_aggregation_system`.`competitor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `result_stage`
    FOREIGN KEY (`stage` )
    REFERENCES `sport_aggregation_system`.`stage` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `sport_aggregation_system` ;

-- -----------------------------------------------------
-- Table `sport_aggregation_system`.`administration`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sport_aggregation_system`.`administration` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `secretar` TINYINT(1) NOT NULL DEFAULT false ,
  `userId` INT(11) NULL ,
  `sportCompetitionId` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id_idx` (`userId` ASC) ,
  INDEX `sport_competiton_id_administration_idx` (`sportCompetitionId` ASC) ,
  CONSTRAINT `user_id_administration`
    FOREIGN KEY (`userId` )
    REFERENCES `sport_aggregation_system`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sport_competiton_id_administration`
    FOREIGN KEY (`sportCompetitionId` )
    REFERENCES `sport_aggregation_system`.`sportCompetition` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
