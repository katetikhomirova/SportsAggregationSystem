package ua.nure.tikhomirova.sport_aggregation_system.rest.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.tikhomirova.sport_aggregation_system.rest.dao.UserDao;
import ua.nure.tikhomirova.sport_aggregation_system.rest.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class UserService {

    private UserDao userDao;

    @Inject
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    public List<User> getAll() {
        return userDao.findAll();
    }

    @GET
    @Path("{email}")
    public User getOne(@PathParam("email") String email) {
        User user = userDao.findOne(email);
        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            return user;
        }
    }

    @POST
    public User save(@Valid User user) {
        return userDao.save(user);
    }

    @PUT
    @Path("{email}")
    public User update(@PathParam("email") String email, @Valid User user) {
        if (userDao.findOne(email) == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            user.setEmail(email);
            return userDao.save(user);
        }
    }

    @DELETE
    @Path("{email}")
    public void delete(@PathParam("email") String email) {
        User user = userDao.findOne(email);
        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            userDao.delete(user);
        }
    }

}
