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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.TeamDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Team;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class TeamService {

	private TeamDao teamDao;

	@Inject
	public TeamService(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@GET
	public List<Team> getAll() {
		return teamDao.findAll();
	}

	@GET
	@Path("{id}")
	public Team getOne(@PathParam("id") Integer id) {
		Team team = teamDao.findOne(id);
		if (team == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return team;
		}
	}

	@POST
	public Team save(@Valid Team team) {
		return teamDao.save(team);
	}

	@PUT
	@Path("{id}")
	public Team update(@PathParam("id") Integer id,
			@Valid Team team) {
		if (teamDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			team.setId(id);
			return teamDao.save(team);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Team team = teamDao.findOne(id);
		if (team == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			teamDao.delete(team);
		}
	}

}
