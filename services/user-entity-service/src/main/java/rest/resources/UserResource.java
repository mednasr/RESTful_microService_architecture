package rest.resources;

import com.codahale.metrics.annotation.Timed;
import rest.dao.entities.UserDAOImpl;
import rest.dto.entities.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static rest.util.RestUtil.*;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
public class UserResource
{
    private UserDAOImpl userDAO = new UserDAOImpl();

    @GET
    @Timed
    @Path("/get/{id}")
    public Response get(@PathParam("id") Long id)
    {
        UserDTO dto = userDAO.get(id);
        return (dto != null) ? ok(dto) : noContent();
    }

    @GET
    @Timed
    @Path("/get")
    public Response getAll()
    {
        return ok(userDAO.get());
    }

    @POST
    @Timed
    @Path("/save")
    public Response add(UserDTO dto)
    {
        try {
            UserDTO result = userDAO.add(dto);
            return (result != null) ? ok(result) : noContent();
        } catch(Exception e) {
            return badRequest("Exception: " + e.getMessage());
        }
    }

    @PUT
    @Timed
    @Path("/update")
    public Response update(UserDTO dto)
    {
        try {
            UserDTO result = userDAO.update(dto);
            return (result != null) ? ok(result) : noContent();
        } catch(Exception e) {
            return badRequest("Exception: " + e.getMessage());
        }
    }

    @DELETE
    @Timed
    @Path("/delete/{id}")
    public Response remove(@PathParam("id") Long id)
    {
        try {
            boolean result = userDAO.delete(id);
            return (result) ? ok() : noContent();
        } catch(Exception e) {
            return badRequest("Exception: " + e.getMessage());
        }
    }
}
