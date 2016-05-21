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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.CompetitorDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Competitor;

@Path("/competitors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class CompetitorService {

	private CompetitorDao competitorDao;

	@Inject
	public CompetitorService(CompetitorDao competitorDao) {
		this.competitorDao = competitorDao;
	}

	@GET
	public List<Competitor> getAll() {
		return competitorDao.findAll();
	}

	@GET
	@Path("{id}")
	public Competitor getOne(@PathParam("id") Integer id) {
		Competitor competitor = competitorDao.findOne(id);
		if (competitor == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return competitor;
		}
	}

	@POST
	public Competitor save(@Valid Competitor competitor) {
		return competitorDao.save(competitor);
	}

	@PUT
	@Path("{id}")
	public Competitor update(@PathParam("id") Integer id,
			@Valid Competitor competitor) {
		if (competitorDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			competitor.setId(id);
			return competitorDao.save(competitor);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Competitor competitor = competitorDao.findOne(id);
		if (competitor == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			competitorDao.delete(competitor);
		}
	}

}
