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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.StageDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Stage;

@Path("/stages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class StageService {

	private StageDao stageDao;

	@Inject
	public StageService(StageDao stageDao) {
		this.stageDao = stageDao;
	}

	@GET
	public List<Stage> getAll() {
		return stageDao.findAll();
	}

	@GET
	@Path("{id}")
	public Stage getOne(@PathParam("id") Integer id) {
		Stage stage = stageDao.findOne(id);
		if (stage == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return stage;
		}
	}

	@POST
	public Stage save(@Valid Stage stage) {
		return stageDao.save(stage);
	}

	@PUT
	@Path("{id}")
	public Stage update(@PathParam("id") Integer id,
			@Valid Stage stage) {
		if (stageDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			stage.setId(id);
			return stageDao.save(stage);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Stage stage = stageDao.findOne(id);
		if (stage == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			stageDao.delete(stage);
		}
	}

}
