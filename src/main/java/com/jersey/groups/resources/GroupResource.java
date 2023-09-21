package com.jersey.groups.resources;


import com.jersey.groups.models.Group;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import java.util.List;

@Path("/api/v1/groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupResource {


    @POST
    public Response createGroup(Group group) {
        throw new NotImplementedException();
    }

    @POST
    @Path("/{group_id}")
    public Response updateGroup(@PathParam("group_id") long groupId, Group group) {
        throw new NotImplementedException();
    }

    @GET
    @Path("/{group_id}")
    public Response getGroup(@PathParam("group_id") long groupId) {
        throw new NotImplementedException();
    }

    @DELETE
    @Path("/{group_id}")
    public Response deleteGroup(@PathParam("group_id") long groupId) {
        throw new NotImplementedException();
    }

    // Implement additional API endpoints for groups as needed
}
