package com.jersey.groups.resources;


import com.jersey.groups.models.Group;
import com.jersey.groups.repository.GroupDbo;
import com.jersey.groups.repository.GroupRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.apache.commons.lang3.NotImplementedException;

@Path("/api/v1/groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupResource {


    private GroupRepository repository;

    public GroupResource(GroupRepository repository) {
        this.repository = repository;

    }

    @POST
    public Response createGroup(Group group) {
        repository.createGroup(group);
        return Response.ok().build();
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
