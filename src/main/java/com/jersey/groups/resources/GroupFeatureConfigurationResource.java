package com.jersey.groups.resources;


import com.jersey.groups.models.FeatureConfiguration;
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

import java.util.List;

@Path("/api/v2/groups/{group_id}/configs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupFeatureConfigurationResource {
   

    @POST
    public Response createGroupFeatureConfiguration(@PathParam("group_id") long groupId, FeatureConfiguration groupFeatureConfiguration) {
        throw new NotImplementedException();
    }

    @POST
    @Path("/{config_id}")
    public Response updateGroupFeatureConfiguration(@PathParam("group_id") long groupId, @PathParam("config_id") long configId, FeatureConfiguration groupFeatureConfiguration) {
        // Implement the update of a group feature configuration associated with the specified group and config ID
        throw new NotImplementedException();
    }

    @GET
    @Path("/{config_id}")
    public Response getGroupFeatureConfiguration(@PathParam("group_id") long groupId, @PathParam("config_id") long configId) {
        // Implement the retrieval of a group feature configuration associated with the specified group and config ID
        throw new NotImplementedException();
    }

    @DELETE
    @Path("/{config_id}")
    public Response deleteGroupFeatureConfiguration(@PathParam("group_id") long groupId, @PathParam("config_id") long configId) {
        throw new NotImplementedException();
    }

}
