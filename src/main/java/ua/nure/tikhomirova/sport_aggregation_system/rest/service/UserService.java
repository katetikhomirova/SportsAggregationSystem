package ua.nure.tikhomirova.sport_aggregation_system.rest.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.UserDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class UserService {

	final static Logger log = Logger.getLogger(UserService.class);

	private UserDao userDao;

	@Inject
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	@GET
	public List<User> getAll() {
		return userDao.findAll();
	}

	@GET
	@Path("{login}")
	public User getByLogin(@PathParam("login") String login) {
		User user = userDao.findByLogin(login);
		if (user == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return user;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/signin")
	public boolean signIn(@FormParam("login") String login,
			@FormParam("password") String password) {
		User user = userDao.findByLogin(login);
		return user.getPassword().equals(password);
	}

	@POST
	public User save(@Valid User user) {
		return userDao.save(user);
	}

	@PUT
	@Path("{id}")
	public User update(@PathParam("id") Integer id, @Valid User user) {
		if (userDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			user.setId(id);
			return userDao.save(user);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		User user = userDao.findOne(id);
		if (user == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userDao.delete(user);
		}
	}

}
