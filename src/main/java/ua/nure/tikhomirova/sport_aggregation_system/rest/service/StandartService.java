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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.StandartDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Standart;

@Path("/standarts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class StandartService {

	private StandartDao standartDao;

	@Inject
	public StandartService(StandartDao standartDao) {
		this.standartDao = standartDao;
	}

	@GET
	public List<Standart> getAll() {
		return standartDao.findAll();
	}

	@GET
	@Path("{id}")
	public Standart getOne(@PathParam("id") Integer id) {
		Standart standart = standartDao.findOne(id);
		if (standart == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return standart;
		}
	}

	@POST
	public Standart save(@Valid Standart standart) {
		return standartDao.save(standart);
	}

	@PUT
	@Path("{id}")
	public Standart update(@PathParam("id") Integer id,
			@Valid Standart standart) {
		if (standartDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			standart.setId(id);
			return standartDao.save(standart);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Standart standart = standartDao.findOne(id);
		if (standart == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			standartDao.delete(standart);
		}
	}

}
