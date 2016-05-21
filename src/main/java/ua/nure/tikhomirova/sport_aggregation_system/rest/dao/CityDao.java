package ua.nure.tikhomirova.sport_aggregation_system.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.nure.tikhomirova.sport_aggregation_system.rest.model.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
