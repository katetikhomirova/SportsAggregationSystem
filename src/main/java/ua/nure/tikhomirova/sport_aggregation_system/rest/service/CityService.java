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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.CityDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.City;

@Path("/cities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class CityService {

	private CityDao cityDao;

	@Inject
	public CityService(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@GET
	public List<City> getAll() {
		return cityDao.findAll();
	}

	@GET
	@Path("{id}")
	public City getOne(@PathParam("id") Integer id) {
		City userRole = cityDao.findOne(id);
		if (userRole == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return userRole;
		}
	}

	@POST
	public City save(@Valid City userRole) {
		return cityDao.save(userRole);
	}

	@PUT
	@Path("{id}")
	public City update(@PathParam("id") Integer id,
			@Valid City userRole) {
		if (cityDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			userRole.setId(id);
			return cityDao.save(userRole);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		City userRole = cityDao.findOne(id);
		if (userRole == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			cityDao.delete(userRole);
		}
	}

}
