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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.ResultDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Result;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class ResultService {

	private ResultDao resultDao;

	@Inject
	public ResultService(ResultDao resultDao) {
		this.resultDao = resultDao;
	}

	@GET
	public List<Result> getAll() {
		return resultDao.findAll();
	}

	@GET
	@Path("{id}")
	public Result getOne(@PathParam("id") Integer id) {
		Result result = resultDao.findOne(id);
		if (result == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return result;
		}
	}

	@POST
	public Result save(@Valid Result result) {
		return resultDao.save(result);
	}

	@PUT
	@Path("{id}")
	public Result update(@PathParam("id") Integer id,
			@Valid Result result) {
		if (resultDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			result.setId(id);
			return resultDao.save(result);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Result result = resultDao.findOne(id);
		if (result == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			resultDao.delete(result);
		}
	}

}