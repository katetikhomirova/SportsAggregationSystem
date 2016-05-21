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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.UserRoleDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.UserRole;

@Path("/userRoles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class UserRoleService {

	private UserRoleDao userRoleDao;

	@Inject
	public UserRoleService(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@GET
	public List<UserRole> getAll() {
		return userRoleDao.findAll();
	}

	@GET
	@Path("{id}")
	public UserRole getOne(@PathParam("id") Integer id) {
		UserRole userRole = userRoleDao.findOne(id);
		if (userRole == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return userRole;
		}
	}

	@POST
	public UserRole save(@Valid UserRole userRole) {
		return userRoleDao.save(userRole);
	}

	@PUT
	@Path("{id}")
	public UserRole update(@PathParam("id") Integer id,
			@Valid UserRole userRole) {
		if (userRoleDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userRole.setId(id);
			return userRoleDao.save(userRole);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		UserRole userRole = userRoleDao.findOne(id);
		if (userRole == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userRoleDao.delete(userRole);
		}
	}

}