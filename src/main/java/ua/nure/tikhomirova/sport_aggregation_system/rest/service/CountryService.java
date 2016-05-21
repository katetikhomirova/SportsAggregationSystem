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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.CountryDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Country;

@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class CountryService {

	private CountryDao countryDao;

	@Inject
	public CountryService(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@GET
	public List<Country> getAll() {
		return countryDao.findAll();
	}

	@GET
	@Path("{id}")
	public Country getOne(@PathParam("id") Integer id) {
		Country country = countryDao.findOne(id);
		if (country == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return country;
		}
	}

	@POST
	public Country save(@Valid Country country) {
		return countryDao.save(country);
	}

	@PUT
	@Path("{id}")
	public Country update(@PathParam("id") Integer id,
			@Valid Country country) {
		if (countryDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			country.setId(id);
			return countryDao.save(country);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Country country = countryDao.findOne(id);
		if (country == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			countryDao.delete(country);
		}
	}

}
