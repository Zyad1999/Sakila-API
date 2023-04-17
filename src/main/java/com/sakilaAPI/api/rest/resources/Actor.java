package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.requests.ActorRequest;
import com.sakilaAPI.service.dtos.responses.BaseActorResponse;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.impls.ActorServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("actor")
public class Actor {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorResponse> getAllActors(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return ActorServiceImpl.getActorService().getAllActors(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ActorResponse getActor(@PathParam("id") int id){
        return ActorServiceImpl.getActorService().getActor(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseActorResponse addActor(ActorRequest actor){
        return ActorServiceImpl.getActorService().addActor(actor);
    }

    @DELETE
    @Path("{id}")
    public Response deleteActor(@PathParam("id") int id){
        ActorServiceImpl.getActorService().deleteActor(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActorResponse updateActor(ActorRequest actor, @PathParam("id") int id){
        return ActorServiceImpl.getActorService().updateActor(actor, id);
    }
}