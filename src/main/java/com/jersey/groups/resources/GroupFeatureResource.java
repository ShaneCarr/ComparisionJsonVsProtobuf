package com.jersey.groups.resources;


import com.jersey.groups.models.Feature;
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

@Path("/api/v2/groups/{group_id}/features")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupFeatureResource {
 
    @POST
    public Response createGroupFeature(@PathParam("group_id") long groupId, Feature groupFeature) {
        // Implement the creation of a group feature associated with the specified group
        // You can use the 'groupId' parameter to associate the feature with the group
        throw new NotImplementedException();
    }

    @POST
    @Path("/{feature_id}")
    public Response updateGroupFeature(@PathParam("group_id") long groupId, @PathParam("feature_id") long featureId, Feature groupFeature) {
        // Implement the update of a group feature associated with the specified group and feature ID
        throw new NotImplementedException();
    }

    @GET
    @Path("/{feature_id}")
    public Response getGroupFeature(@PathParam("group_id") long groupId, @PathParam("feature_id") long featureId) {
        // Implement the retrieval of a group feature associated with the specified group and feature ID
        throw new NotImplementedException();
    }

    @DELETE
    @Path("/{feature_id}")
    public Response deleteGroupFeature(@PathParam("group_id") long groupId, @PathParam("feature_id") long featureId) {
        // Implement the deletion of a group feature associated with the specified group and feature ID
        throw new NotImplementedException();
    }

    // Implement additional API endpoints for group features as needed
}
