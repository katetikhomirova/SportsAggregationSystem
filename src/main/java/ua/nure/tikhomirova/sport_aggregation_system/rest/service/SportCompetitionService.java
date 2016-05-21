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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.SportCompetitionDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.SportCompetition;

@Path("/sportCompetitions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class SportCompetitionService {

	private SportCompetitionDao sportCompetitionDao;

	@Inject
	public SportCompetitionService(SportCompetitionDao sportCompetitionDao) {
		this.sportCompetitionDao = sportCompetitionDao;
	}

	@GET
	public List<SportCompetition> getAll() {
		return sportCompetitionDao.findAll();
	}

	@GET
	@Path("{id}")
	public SportCompetition getOne(@PathParam("id") Integer id) {
		SportCompetition sportCompetition = sportCompetitionDao.findOne(id);
		if (sportCompetition == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return sportCompetition;
		}
	}

	@POST
	public SportCompetition save(@Valid SportCompetition sportCompetition) {
		return sportCompetitionDao.save(sportCompetition);
	}

	@PUT
	@Path("{id}")
	public SportCompetition update(@PathParam("id") Integer id,
			@Valid SportCompetition sportCompetition) {
		if (sportCompetitionDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			sportCompetition.setId(id);
			return sportCompetitionDao.save(sportCompetition);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		SportCompetition sportCompetition = sportCompetitionDao.findOne(id);
		if (sportCompetition == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			sportCompetitionDao.delete(sportCompetition);
		}
	}

}
