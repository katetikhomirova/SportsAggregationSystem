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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.UserTeamDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.UserTeam;

@Path("/userTeams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class UserTeamService {

	private UserTeamDao userTeamDao;

	@Inject
	public UserTeamService(UserTeamDao userTeamDao) {
		this.userTeamDao = userTeamDao;
	}

	@GET
	public List<UserTeam> getAll() {
		return userTeamDao.findAll();
	}

	@GET
	@Path("{id}")
	public UserTeam getOne(@PathParam("id") Integer id) {
		UserTeam userTeam = userTeamDao.findOne(id);
		if (userTeam == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return userTeam;
		}
	}

	@POST
	public UserTeam save(@Valid UserTeam userTeam) {
		return userTeamDao.save(userTeam);
	}

	@PUT
	@Path("{id}")
	public UserTeam update(@PathParam("id") Integer id,
			@Valid UserTeam userTeam) {
		if (userTeamDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userTeam.setId(id);
			return userTeamDao.save(userTeam);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		UserTeam userTeam = userTeamDao.findOne(id);
		if (userTeam == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userTeamDao.delete(userTeam);
		}
	}

}
