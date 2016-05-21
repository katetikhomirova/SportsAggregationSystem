package ua.nure.tikhomirova.sport_aggregation_system.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.UserSportDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.UserSport;

@Path("/userSports")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class UserSportService {

	private UserSportDao userSportDao;

	@Inject
	public UserSportService(UserSportDao userSportDao) {
		this.userSportDao = userSportDao;
	}

	@GET
	public List<UserSport> getAll() {
		return userSportDao.findAll();
	}

	@GET
	@Path("{id}")
	public UserSport getOne(@PathParam("id") Integer id) {
		UserSport userSport = userSportDao.findOne(id);
		if (userSport == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return userSport;
		}
	}

	@POST
	public UserSport save(@Valid UserSport userSport) {
		return userSportDao.save(userSport);
	}

	@PUT
	@Path("{id}")
	public UserSport update(@PathParam("id") Integer id,
			@Valid UserSport userSport) {
		if (userSportDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userSport.setId(id);
			return userSportDao.save(userSport);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		UserSport userSport = userSportDao.findOne(id);
		if (userSport == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userSportDao.delete(userSport);
		}
	}

}
