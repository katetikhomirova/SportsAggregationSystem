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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.StatusDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Status;

@Path("/statuss")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class StatusService {

	private StatusDao statusDao;

	@Inject
	public StatusService(StatusDao statusDao) {
		this.statusDao = statusDao;
	}

	@GET
	public List<Status> getAll() {
		return statusDao.findAll();
	}

	@GET
	@Path("{id}")
	public Status getOne(@PathParam("id") Integer id) {
		Status status = statusDao.findOne(id);
		if (status == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return status;
		}
	}

	@POST
	public Status save(@Valid Status status) {
		return statusDao.save(status);
	}

	@PUT
	@Path("{id}")
	public Status update(@PathParam("id") Integer id,
			@Valid Status status) {
		if (statusDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			status.setId(id);
			return statusDao.save(status);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Status status = statusDao.findOne(id);
		if (status == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			statusDao.delete(status);
		}
	}

}
