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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.AdministrationDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Administration;

@Path("/administrations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class AdministrationService {

	private AdministrationDao administrationDao;

	@Inject
	public AdministrationService(AdministrationDao administrationDao) {
		this.administrationDao = administrationDao;
	}

	@GET
	public List<Administration> getAll() {
		return administrationDao.findAll();
	}

	@GET
	@Path("{id}")
	public Administration getOne(@PathParam("id") Integer id) {
		Administration administration = administrationDao.findOne(id);
		if (administration == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return administration;
		}
	}

	@POST
	public Administration save(@Valid Administration administration) {
		return administrationDao.save(administration);
	}

	@PUT
	@Path("{id}")
	public Administration update(@PathParam("id") Integer id,
			@Valid Administration administration) {
		if (administrationDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			administration.setId(id);
			return administrationDao.save(administration);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Administration administration = administrationDao.findOne(id);
		if (administration == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			administrationDao.delete(administration);
		}
	}

}
