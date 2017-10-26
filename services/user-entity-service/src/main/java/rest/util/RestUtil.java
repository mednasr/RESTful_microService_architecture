package rest.util;

import javax.ws.rs.core.Response;

public class RestUtil
{
    public static Response status(Response.Status status, Object entity)
    {
        return Response.status(status).entity(entity).build();
    }

    public static Response status(Response.Status status)
    {
        return Response.status(status).build();
    }

    public static Response ok()
    {
        return status(Response.Status.OK);
    }

    public static Response ok(Object entity)
    {
        return status(Response.Status.OK, entity);
    }

    public static Response badRequest(Object entity)
    {
        return status(Response.Status.BAD_REQUEST, entity);
    }

    public static Response notFound(Object entity)
    {
        return status(Response.Status.NOT_FOUND, entity);
    }

    public static Response noContent()
    {
        return status(Response.Status.NO_CONTENT);
    }
}
