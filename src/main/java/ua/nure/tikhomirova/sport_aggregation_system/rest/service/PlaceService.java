package ua.nure.tikhomirova.sport_aggregation_system.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
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

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.PlaceDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.Place;

@Path("/places")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class PlaceService {

	private PlaceDao placeDao;

	@Inject
	public PlaceService(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

	@GET
	public List<Place> getAll() {
		return placeDao.findAll();
	}

	@GET
	@Path("{id}")
	public Place getOne(@PathParam("id") Integer id) {
		Place place = placeDao.findOne(id);
		if (place == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return place;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Place save(@FormParam("name") String name,
			@FormParam("description") String description,
			@FormParam("lat") Double lat, @FormParam("lng") Double lng,
			@FormParam("address") String address) {
		Place place = new Place();
		place.setName(name);
		place.setDescription(description);
		place.setLat(lat);
		place.setLng(lng);
		place.setAddress(address);
		return placeDao.save(place);
	}

	@PUT
	@Path("{id}")
	public Place update(@PathParam("id") Integer id, @Valid Place place) {
		if (placeDao.findOne(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			place.setId(id);
			return placeDao.save(place);
		}
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		Place place = placeDao.findOne(id);
		if (place == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			placeDao.delete(place);
		}
	}

}
