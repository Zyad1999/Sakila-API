package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.requests.ActorRequest;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.dtos.responses.BaseActorResponse;
import com.sakilaAPI.service.impls.ActorServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class Actor {

    @WebMethod
    public List<ActorResponse> getAllActors(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return ActorServiceImpl.getActorService().getAllActors(limit, offset);
    }

    @WebMethod
    public ActorResponse getActor(@WebParam(name = "id") int id){
        return ActorServiceImpl.getActorService().getActor(id);
    }

    @WebMethod
    public BaseActorResponse addActor(ActorRequest actor){
        return ActorServiceImpl.getActorService().addActor(actor);
    }

    @WebMethod
    public void deleteActor(@WebParam(name = "id") int id){
        ActorServiceImpl.getActorService().deleteActor(id);
    }

    @WebMethod
    public ActorResponse updateActor(ActorRequest actor, @WebParam(name = "id") int id){
        return ActorServiceImpl.getActorService().updateActor(actor, id);
    }
}
