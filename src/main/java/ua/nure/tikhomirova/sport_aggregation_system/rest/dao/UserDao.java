package ua.nure.tikhomirova.sport_aggregation_system.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.nure.tikhomirova.sport_aggregation_system.rest.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.login = :login")
	User findByLogin(@Param("login")String login);
}
