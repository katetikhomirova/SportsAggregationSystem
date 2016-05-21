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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.CompetitionDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Competition;

@Path("/competitions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class CompetitionService {

	private CompetitionDao competitionDao;

	@Inject
	public CompetitionService(CompetitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}

	@GET
	public List<Competition> getAll() {
		return competitionDao.findAll();
	}

	@GET
	@Path("{id}")
	public Competition getOne(@PathParam("id") Integer id) {
		Competition competition = competitionDao.findOne(id);
		if (competition == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return competition;
		}
	}

	@POST
	public Competition save(@Valid Competition competition) {
		return competitionDao.save(competition);
	}

	@PUT
	@Path("{id}")
	public Competition update(@PathParam("id") Integer id,
			@Valid Competition competition) {
		if (competitionDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			competition.setId(id);
			return competitionDao.save(competition);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Competition competition = competitionDao.findOne(id);
		if (competition == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			competitionDao.delete(competition);
		}
	}

}
