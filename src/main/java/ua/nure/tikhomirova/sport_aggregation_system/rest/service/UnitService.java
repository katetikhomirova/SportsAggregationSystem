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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.UnitDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Unit;

@Path("/units")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class UnitService {

	private UnitDao unitDao;

	@Inject
	public UnitService(UnitDao unitDao) {
		this.unitDao = unitDao;
	}

	@GET
	public List<Unit> getAll() {
		return unitDao.findAll();
	}

	@GET
	@Path("{id}")
	public Unit getOne(@PathParam("id") Integer id) {
		Unit unit = unitDao.findOne(id);
		if (unit == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return unit;
		}
	}

	@POST
	public Unit save(@Valid Unit unit) {
		return unitDao.save(unit);
	}

	@PUT
	@Path("{id}")
	public Unit update(@PathParam("id") Integer id,
			@Valid Unit unit) {
		if (unitDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			unit.setId(id);
			return unitDao.save(unit);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Unit unit = unitDao.findOne(id);
		if (unit == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			unitDao.delete(unit);
		}
	}

}
