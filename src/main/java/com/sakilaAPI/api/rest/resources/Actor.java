package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.impls.ActorServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("actor")
public class Actor {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorResponse> getAllActor() {
        return ActorServiceImpl.getActorService().getAllActors();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ActorResponse getActor(@PathParam("id") int id){
        return ActorServiceImpl.getActorService().getActor(id);
    }
}