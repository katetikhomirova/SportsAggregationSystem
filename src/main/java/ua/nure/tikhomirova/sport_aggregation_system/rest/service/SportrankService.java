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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.SportrankDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Sportrank;

@Path("/sportranks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class SportrankService {

	private SportrankDao sportrankDao;

	@Inject
	public SportrankService(SportrankDao sportrankDao) {
		this.sportrankDao = sportrankDao;
	}

	@GET
	public List<Sportrank> getAll() {
		return sportrankDao.findAll();
	}

	@GET
	@Path("{id}")
	public Sportrank getOne(@PathParam("id") Integer id) {
		Sportrank sportrank = sportrankDao.findOne(id);
		if (sportrank == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return sportrank;
		}
	}

	@POST
	public Sportrank save(@Valid Sportrank sportrank) {
		return sportrankDao.save(sportrank);
	}

	@PUT
	@Path("{id}")
	public Sportrank update(@PathParam("id") Integer id,
			@Valid Sportrank sportrank) {
		if (sportrankDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			sportrank.setId(id);
			return sportrankDao.save(sportrank);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Sportrank sportrank = sportrankDao.findOne(id);
		if (sportrank == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			sportrankDao.delete(sportrank);
		}
	}

}
