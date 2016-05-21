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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.SportCategoryDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.SportCategory;

@Path("/sportCategories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class SportCategoryService {

	private SportCategoryDao sportCategoryDao;

	@Inject
	public SportCategoryService(SportCategoryDao sportCategoryDao) {
		this.sportCategoryDao = sportCategoryDao;
	}

	@GET
	public List<SportCategory> getAll() {
		return sportCategoryDao.findAll();
	}

	@GET
	@Path("{id}")
	public SportCategory getOne(@PathParam("id") Integer id) {
		SportCategory sportCategory = sportCategoryDao.findOne(id);
		if (sportCategory == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return sportCategory;
		}
	}

	@POST
	public SportCategory save(@Valid SportCategory sportCategory) {
		return sportCategoryDao.save(sportCategory);
	}

	@PUT
	@Path("{id}")
	public SportCategory update(@PathParam("id") Integer id,
			@Valid SportCategory sportCategory) {
		if (sportCategoryDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			sportCategory.setId(id);
			return sportCategoryDao.save(sportCategory);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		SportCategory sportCategory = sportCategoryDao.findOne(id);
		if (sportCategory == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			sportCategoryDao.delete(sportCategory);
		}
	}

}
